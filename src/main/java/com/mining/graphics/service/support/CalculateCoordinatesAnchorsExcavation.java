package com.mining.graphics.service.support;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;

/**
 * Сервис для расчета координат анкеров.
 */
public class CalculateCoordinatesAnchorsExcavation {

    private final ServiceExcavation excavationService;
    private final ServiceAnchorsExcavation anchorsService;

    // Временные переменные для расчетов
    private double phi;
    private double delta;
    private double stepLargeArcX;
    private double stepLargeArcY;
    private double stepLargeArcAnchorsX;
    private double stepLargeArcAnchorsY;
    private double stepSmallArcX;
    private double stepSmallArcY;
    private double stepSmallArcAnchorsX;
    private double stepSmallArcAnchorsY;
    private double stepWallX;
    private double stepWallY;
    private double stepWallAnchorsX;
    private double stepWallAnchorsY;

    public CalculateCoordinatesAnchorsExcavation(ServiceExcavation excavationService,
                                                 ServiceAnchorsExcavation anchorsService) {
        this.excavationService = excavationService;
        this.anchorsService = anchorsService;
    }

    /**
     * Расчет координат анкеров в поперечном сечении.
     */
    public void calculateCrossSectionAnchors(ModelExcavation model, AnchorsExcavation anchors) {
        double width = model.getWidth();
        double height = model.getHeight();
        double formIndication = model.getFormIndication();

        // Геометрические параметры
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        double largeArcRadius = ServiceExcavation.largeArcRadius(width, formIndication);
        double smallArcRadius = ServiceExcavation.smallArcRadius(width, formIndication);
        double largeArcLength = ServiceExcavation.largeArcLength(width, formIndication);
        double smallArcLength = ServiceExcavation.smallArcLength(width, formIndication);
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double betaRadian = ServiceExcavation.betaRadian(width, formIndication);

        double step = anchors.getStep();
        double lengthAnchor = anchors.getLengthAnchor();
        double distanceLowerAnchor = anchors.getDistanceLowerAnchor();

        // Количество анкеров
        int numberCrossSectionAnchors = (int) Math.ceil((totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0) / step);

        double[][] crossSectionAnchorsXY;

        int i = 0;

        // Вариант расположения анкеров
        if ((numberCrossSectionAnchors + 1) % 2 == 0) {
            // Анкер по центру
            crossSectionAnchorsXY = new double[numberCrossSectionAnchors + 1][4];
            i = calculateWithCenterAnchor(i, crossSectionAnchorsXY,
                    width, height, archHeight,
                    largeArcRadius, smallArcRadius,
                    largeArcLength, smallArcLength,
                    betaRadian, step, lengthAnchor, distanceLowerAnchor);
        } else {
            // Анкер со смещением
            crossSectionAnchorsXY = new double[numberCrossSectionAnchors][4];
            i = calculateWithOffsetAnchor(i, crossSectionAnchorsXY,
                    width, height, archHeight,
                    largeArcRadius, smallArcRadius,
                    largeArcLength, smallArcLength,
                    betaRadian, step, lengthAnchor, distanceLowerAnchor);
        }

        anchors.setCrossSectionAnchorsXY(crossSectionAnchorsXY);

        double bottomAnchorY = crossSectionAnchorsXY[i - 1][1]; // Y координата начала последнего анкера
        anchors.setBottomAnchorY(bottomAnchorY);

        double firstCrossSectionAnchorX = crossSectionAnchorsXY[0][0];
        anchors.setFirstCrossSectionAnchorX(firstCrossSectionAnchorX);
        double firstCrossSectionAnchorY = crossSectionAnchorsXY[0][1];
        anchors.setFirstCrossSectionAnchorY(firstCrossSectionAnchorY);
        double secondCrossSectionAnchorX = crossSectionAnchorsXY[1][0];
        anchors.setSecondCrossSectionAnchorX(secondCrossSectionAnchorX);
        double secondCrossSectionAnchorY = crossSectionAnchorsXY[1][1];
        anchors.setSecondCrossSectionAnchorY(secondCrossSectionAnchorY);
    }


    /**
     * Расчет с центральным анкером.
     */
    private int calculateWithCenterAnchor(int startIndex, double[][] anchors,
                                          double width, double height, double archHeight,
                                          double largeArcRadius, double smallArcRadius,
                                          double largeArcLength, double smallArcLength,
                                          double betaRadian, double step, double lengthAnchor, double distanceLowerAnchor) {

        int i = startIndex;
        double remainderLargeArcRadius;
        double remainderSmallArcRadius;
        double lengthLargeSegmentAnch;
        double lengthSmallSegmentAnch;
        double lengthWallSegmentAnch;

        // Левая сторона - большая дуга
        lengthLargeSegmentAnch = largeArcLength / 2.0;
        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
            calculateLargeArcStep(j, largeArcRadius, lengthAnchor, step, 0.0);
            anchors[i][0] = -stepLargeArcX;
            anchors[i][1] = -height + stepLargeArcY;
            anchors[i][2] = -stepLargeArcAnchorsX;
            anchors[i][3] = -height + stepLargeArcAnchorsY;
        }

        // Левая сторона - малая дуга
        remainderLargeArcRadius = largeArcLength / 2.0 - step * (i - 1);
        phi = (step - remainderLargeArcRadius) / smallArcRadius;
        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnchor, step, phi, betaRadian);
            anchors[i][0] = -stepSmallArcX;
            anchors[i][1] = stepSmallArcY;
            anchors[i][2] = -stepSmallArcAnchorsX;
            anchors[i][3] = stepSmallArcAnchorsY;
        }

        // Левая сторона - стенка
        remainderSmallArcRadius = largeArcLength / 2.0 + smallArcLength - step * (i - 1);
        delta = step - remainderSmallArcRadius;
        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);

        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
            calculateWallStep(j, width, height, archHeight, lengthAnchor, step, delta);
            anchors[i][0] = -stepWallX;
            anchors[i][1] = stepWallY;
            anchors[i][2] = -stepWallAnchorsX;
            anchors[i][3] = stepWallAnchorsY;
        }

        // Правая сторона - большая дуга
        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
            calculateLargeArcStep(j, largeArcRadius, lengthAnchor, step, 0.0);
            anchors[i][0] = stepLargeArcX;
            anchors[i][1] = -height + stepLargeArcY;
            anchors[i][2] = stepLargeArcAnchorsX;
            anchors[i][3] = -height + stepLargeArcAnchorsY;
        }

        // Правая сторона - малая дуга
        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnchor, step, phi, betaRadian);
            anchors[i][0] = stepSmallArcX;
            anchors[i][1] = stepSmallArcY;
            anchors[i][2] = stepSmallArcAnchorsX;
            anchors[i][3] = stepSmallArcAnchorsY;
        }

        // Правая сторона - стенка
        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
            calculateWallStep(j, width, height, archHeight, lengthAnchor, step, delta);
            anchors[i][0] = stepWallX;
            anchors[i][1] = stepWallY;
            anchors[i][2] = stepWallAnchorsX;
            anchors[i][3] = stepWallAnchorsY;
        }

        return i;
    }

    /**
     * Расчет со смещенным анкером.
     */
    private int calculateWithOffsetAnchor(int startIndex, double[][] anchors,
                                          double width, double height, double archHeight,
                                          double largeArcRadius, double smallArcRadius,
                                          double largeArcLength, double smallArcLength,
                                          double betaRadian, double step, double lengthAnchor, double distanceLowerAnchor) {

        int i = startIndex;
        double remainderLargeArcRadius;
        double remainderSmallArcRadius;
        double lengthLargeSegmentAnch;
        double lengthSmallSegmentAnch;
        double lengthWallSegmentAnch;
        double omega = Math.asin(step / (2.0 * largeArcRadius));

        // Левая сторона - большая дуга
        lengthLargeSegmentAnch = largeArcLength / 2.0 - step / 2.0;
        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
            calculateLargeArcStep(j, largeArcRadius, lengthAnchor, step, omega);
            anchors[i][0] = -stepLargeArcX;
            anchors[i][1] = -height + stepLargeArcY;
            anchors[i][2] = -stepLargeArcAnchorsX;
            anchors[i][3] = -height + stepLargeArcAnchorsY;
        }

        // Левая сторона - малая дуга
        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);
        phi = (step - remainderLargeArcRadius) / smallArcRadius;
        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnchor, step, phi, betaRadian);
            anchors[i][0] = -stepSmallArcX;
            anchors[i][1] = stepSmallArcY;
            anchors[i][2] = -stepSmallArcAnchorsX;
            anchors[i][3] = stepSmallArcAnchorsY;
        }

        // Левая сторона - стенка
        remainderSmallArcRadius = (largeArcLength / 2.0 + smallArcLength) - step / 2.0 - step * (i - 1);
        delta = step - remainderSmallArcRadius;
        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);

        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
            calculateWallStep(j, width, height, archHeight, lengthAnchor, step, delta);
            anchors[i][0] = -stepWallX;
            anchors[i][1] = stepWallY;
            anchors[i][2] = -stepWallAnchorsX;
            anchors[i][3] = stepWallAnchorsY;
        }

        // Правая сторона - большая дуга
        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
            calculateLargeArcStep(j, largeArcRadius, lengthAnchor, step, omega);
            anchors[i][0] = stepLargeArcX;
            anchors[i][1] = -height + stepLargeArcY;
            anchors[i][2] = stepLargeArcAnchorsX;
            anchors[i][3] = -height + stepLargeArcAnchorsY;
        }

        // Правая сторона - малая дуга
        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnchor, step, phi, betaRadian);
            anchors[i][0] = stepSmallArcX;
            anchors[i][1] = stepSmallArcY;
            anchors[i][2] = stepSmallArcAnchorsX;
            anchors[i][3] = stepSmallArcAnchorsY;
        }

        // Правая сторона - стенка
        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
            calculateWallStep(j, width, height, archHeight, lengthAnchor, step, delta);
            anchors[i][0] = stepWallX;
            anchors[i][1] = stepWallY;
            anchors[i][2] = stepWallAnchorsX;
            anchors[i][3] = stepWallAnchorsY;
        }

        return i;
    }

    /**
     * Расчет шагов для большой дуги.
     */
    private void calculateLargeArcStep(int j, double largeArcRadius, double lengthAnchor, double step, double omega) {
        stepLargeArcX = anchorsService.calculateStepLargeArcX(j, step, largeArcRadius, omega);
        stepLargeArcY = anchorsService.calculateStepLargeArcY(j, step, largeArcRadius, omega);
        stepLargeArcAnchorsX = anchorsService.calculateStepLargeArcAnchorsX(j, step, largeArcRadius, lengthAnchor, omega);
        stepLargeArcAnchorsY = anchorsService.calculateStepLargeArcAnchorsY(j, step, largeArcRadius, lengthAnchor, omega);
    }

    /**
     * Расчет шагов для малой дуги.
     */
    private void calculateSmallArcStep(int j, double width, double height, double archHeight,
                                       double smallArcRadius, double lengthAnchor, double step,
                                       double phi, double betaRadian) {
        stepSmallArcX = anchorsService.calculateStepSmallArcX(j, width, smallArcRadius, step, phi, betaRadian);
        stepSmallArcY = anchorsService.calculateStepSmallArcY(j, height, archHeight, smallArcRadius, step, phi, betaRadian);
        stepSmallArcAnchorsX = anchorsService.calculateStepSmallArcAnchorsX(j, width, smallArcRadius, step, phi, betaRadian, lengthAnchor);
        stepSmallArcAnchorsY = anchorsService.calculateStepSmallArcAnchorsY(j, height, archHeight, smallArcRadius, step, phi, betaRadian, lengthAnchor);
    }

    /**
     * Расчет шагов для стенки.
     */
    private void calculateWallStep(int j, double width, double height, double archHeight,
                                   double lengthAnchor, double step, double delta) {
        stepWallX = anchorsService.calculateStepWallX(width);
        stepWallY = anchorsService.calculateStepWallY(j, height, archHeight, step, delta);
        stepWallAnchorsX = anchorsService.calculateStepWallAnchorsX(width, lengthAnchor);
        stepWallAnchorsY = anchorsService.calculateStepWallAnchorsY(j, height, archHeight, step, delta);
    }

    /**
     * Расчет координат анкеров в продольном сечении.
     */
    public void calculateLongSectionAnchors(ModelExcavation model, AnchorsExcavation anchors) {
        double height = model.getHeight();
        double length = model.getLength();
        double distanceBetweenRows = anchors.getDistanceBetweenRows();

        double[][] crossSectionAnchorsXY = anchors.getCrossSectionAnchorsXY();

        int numberLongSectionAnchors = (int) Math.floor(length / (2 * distanceBetweenRows)) * 2 + 1;
        double[][] longSectionAnchorsXY = new double[numberLongSectionAnchors][4];

        int i = 0;

        for (int j = 0; length / 2.0 > j * distanceBetweenRows; j++, i++) {
            longSectionAnchorsXY[i][0] = length / 2.0 - distanceBetweenRows * j;
            longSectionAnchorsXY[i][1] = crossSectionAnchorsXY[0][1];
            longSectionAnchorsXY[i][2] = length / 2.0 - distanceBetweenRows * j;
            longSectionAnchorsXY[i][3] = crossSectionAnchorsXY[0][3];
        }

        for (int j = 1; length / 2.0 > j * distanceBetweenRows; j++, i++) {
            longSectionAnchorsXY[i][0] = length / 2.0 + distanceBetweenRows * j;
            longSectionAnchorsXY[i][1] = crossSectionAnchorsXY[0][1];
            longSectionAnchorsXY[i][2] = length / 2.0 + distanceBetweenRows * j;
            longSectionAnchorsXY[i][3] = crossSectionAnchorsXY[0][3];
        }

        anchors.setLongSectionAnchorsXY(longSectionAnchorsXY);

        double firstLongSectionAnchorX = longSectionAnchorsXY[i - 2][0];
        anchors.setFirstLongSectionAnchorX(firstLongSectionAnchorX);
        double firstLongSectionAnchorY = longSectionAnchorsXY[i - 2][1];
        anchors.setFirstLongSectionAnchorY(firstLongSectionAnchorY);
        double secondLongSectionAnchorX = longSectionAnchorsXY[i - 1][0];
        anchors.setSecondLongSectionAnchorX(secondLongSectionAnchorX);
        double secondLongSectionAnchorY = longSectionAnchorsXY[i - 1][1];
        anchors.setSecondLongSectionAnchorY(secondLongSectionAnchorY);
    }

    /**
     * Расчет координат опорных плит.
     */
    public void calculateBasePlate(AnchorsExcavation anchors) {
        double[][] crossSectionAnchorsXY = anchors.getCrossSectionAnchorsXY();
        double[][] longSectionAnchorsXY = anchors.getLongSectionAnchorsXY();
        double plateSize = anchors.getPlateSize();

        int numberCrossSectionAnchors = crossSectionAnchorsXY.length;
        int numberLongSectionAnchors = longSectionAnchorsXY.length;

        int numberBasePlateInRow;
        if (numberCrossSectionAnchors % 2 == 0) {
            numberBasePlateInRow = numberCrossSectionAnchors / 2;
        } else {
            numberBasePlateInRow = (int) Math.floor(numberCrossSectionAnchors / 2.0);
        }

        int numberBasePlateLongSection = (numberBasePlateInRow - 2) * numberLongSectionAnchors;
        double[][] basePlateXY = new double[numberBasePlateLongSection][2];

        int a = 0;
        for (int k = 0; k < numberLongSectionAnchors; k++) {
            for (int j = 2; j < numberBasePlateInRow; j++, a++) {
                basePlateXY[a][0] = longSectionAnchorsXY[k][0] - plateSize / 2.0;
                basePlateXY[a][1] = crossSectionAnchorsXY[j][1] - plateSize / 2.0;
            }
        }
        anchors.setBasePlateXY(basePlateXY);
    }
}