package com.mining.graphics.service.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.model.support.ShotcreteExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

/**
 * Сервис для расчета координат размеров
 */
public class ServiceDimension {

    private final ServiceExcavation excavationService;

    public ServiceDimension(ServiceExcavation excavationService) {
        this.excavationService = excavationService;
    }

    /**
     * Расчет размеров для поперечного сечения
     */
    public DimensionPoints calculateCrossSectionDimensions(ModelExcavation model, AnchorsExcavation anchors, ShotcreteExcavation shotcreteExcavation, int scale) {
        double width = model.getWidth();
        double height = model.getHeight();
        double length = model.getLength();
        double formIndication = model.getFormIndication();

        double step = anchors.getStep();
        double distanceBetweenRows = anchors.getDistanceBetweenRows();

        double archHeight = excavationService.getArchHeight(width, formIndication);

        int scaleWidth = (int) Math.round(width * scale);
        int scaleHeight = (int) Math.round(height * scale);
        int scaleLength = (int) Math.round(length * scale);
        int scaleArchHeight = (int) Math.round(archHeight * scale);

        DimensionPoints points = new DimensionPoints();

        // Размер ширины (смещение вниз)
        points.widthStart = new Point(-scaleWidth / 2, 0);
        points.widthEnd = new Point(scaleWidth / 2, 0);
        points.widthOffset = 65;  // смещение вниз
        points.widthLengthextensionline = 30; //длина выносной линии
        points.widthText = String.format("%.1f м", width);

        // Размер высоты (смещение влево)
        points.heightStart = new Point(-scaleWidth / 2, 0);
        points.heightEnd = new Point(-scaleWidth / 2, -scaleHeight);
        points.heightOffset = -300;  // смещение влево (отрицательное)
        points.heightLengthextensionline = -30; //длина выносной линии
        points.heightText = String.format("%.1f м", height);

        // Расстояние до нижнего анкера (смещение вправо)
        double bottomAnchorY = anchors.getBottomAnchorY();
        int scaleBottomAnchorY = (int) Math.round(bottomAnchorY * scale);

        points.heightToBottomAnchorStart = new Point(-scaleWidth / 2, 0);
        points.heightToBottomAnchorEnd = new Point(-scaleWidth / 2, scaleBottomAnchorY);
        points.heightToBottomAnchorOffset = -225;  // смещение вправо
        points.heightToBottomAnchorLengthextensionline = -30; //длина выносной линии
        points.heightToBottomAnchorText = String.format("%.1f м", -bottomAnchorY);

        // Расстояние между анкерами в ряду
        double firstСrossSectionAnchorX = anchors.getFirstcrossSectionAnchorX();
        double firstСrossSectionAnchorY = anchors.getFirstcrossSectionAnchorY();
        double secondСrossSectionAnchorX = anchors.getSecondcrossSectionAnchorX();
        double secondСrossSectionAnchorY = anchors.getSecondcrossSectionAnchorY();

        int scaleFirstCrossSectionAnchorX = (int) Math.round(firstСrossSectionAnchorX * scale);
        int scaleFirstCrossSectionAnchorY = (int) Math.round(firstСrossSectionAnchorY * scale);
        int scaleSecondCrossSectionAnchorX = (int) Math.round(secondСrossSectionAnchorX * scale);
        int scaleSecondCrossSectionAnchorY = (int) Math.round(secondСrossSectionAnchorY * scale);

        points.stepStart = new Point(scaleSecondCrossSectionAnchorX, scaleSecondCrossSectionAnchorY);
        points.stepEnd = new Point(scaleFirstCrossSectionAnchorX, scaleFirstCrossSectionAnchorY);
        points.stepOffset = -225;  // смещение влево (отрицательное)
        points.stepLengthextensionline = -30; //длина выносной линии
        points.stepText = String.format("%.1f м", step);

        // Расстояние между рядами анкеров
        double firstLongSectionAnchorX = anchors.getFirstLongSectionAnchorX();
        double firstLongSectionAnchorY = anchors.getFirstLongSectionAnchorY();
        double secondLongSectionAnchorX = anchors.getSecondLongSectionAnchorX();
        double secondLongSectionAnchorY = anchors.getSecondLongSectionAnchorY();

        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        int scaleFirstLongSectionAnchorX = (int) Math.round(firstLongSectionAnchorX * scale);
        int scaleFirstLongSectionAnchorY = (int) Math.round(firstLongSectionAnchorY * scale);
        int scaleSecondLongSectionAnchorX = (int) Math.round(secondLongSectionAnchorX * scale);
        int scaleSecondLongSectionAnchorY = (int) Math.round(secondLongSectionAnchorY * scale);


        points.distanceBetweenRowsStart = new Point(scaleFirstLongSectionAnchorX + distance, scaleFirstLongSectionAnchorY);
        points.distanceBetweenRowsEnd = new Point(scaleSecondLongSectionAnchorX + distance, scaleSecondLongSectionAnchorY);

        points.distanceBetweenRowsOffset = -225;  // смещение влево (отрицательное)
        points.distanceBetweenRowsLengthextensionline = -30; //длина выносной линии
        points.distanceBetweenRowsText = String.format("%.1f м", distanceBetweenRows);

        //Толщина набрызгбетона
        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();
        int scaleThicknessShorcrete = (int) Math.round(thicknessShorcrete * scale);
        points.thicknessShorcreteStart = new Point(scaleLength + distance, -scaleHeight);
        points.thicknessShorcreteEnd = new Point(scaleLength + distance, -scaleHeight + scaleThicknessShorcrete + 5);
        points.thicknessShorcreteOffset = -100;  // смещение вправо
        points.thicknessShorcreteLengthextensionline = -30; //длина выносной линии
        points.thicknessShorcreteText = String.format("%.0f см", thicknessShorcrete * 100);


        return points;
    }

    /**
     * Класс для хранения точек размеров
     */
    public static class DimensionPoints {
        public Point widthStart;
        public Point widthEnd;
        public int widthOffset;
        public int widthLengthextensionline;
        public String widthText;

        public Point heightStart;
        public Point heightEnd;
        public int heightOffset;
        public int heightLengthextensionline;
        public String heightText;

        public Point heightToBottomAnchorStart;
        public Point heightToBottomAnchorEnd;
        public int heightToBottomAnchorOffset;
        public int heightToBottomAnchorLengthextensionline;
        public String heightToBottomAnchorText;

        public Point stepStart;
        public Point stepEnd;
        public int stepOffset;
        public int stepLengthextensionline;
        public String stepText;

        public Point distanceBetweenRowsStart;
        public Point distanceBetweenRowsEnd;
        public int distanceBetweenRowsOffset;
        public int distanceBetweenRowsLengthextensionline;
        public String distanceBetweenRowsText;

        public Point thicknessShorcreteStart;
        public Point thicknessShorcreteEnd;
        public int thicknessShorcreteOffset;
        public int thicknessShorcreteLengthextensionline;
        public String thicknessShorcreteText;


        public Point lengthStart;
        public Point lengthEnd;
        public int lengthOffset;
        public String lengthText;
    }
}