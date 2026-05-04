package com.mining.graphics.service.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.excavation.ShotcreteExcavation;
import com.mining.graphics.service.GeneralService;

import java.awt.*;

public class ServiceDimensionExcavation {

    public DimensionPointsExcavation calculateDimensionsExcavation(ModelExcavation modelExcavation, AnchorsExcavation anchorsExcavation, ShotcreteExcavation shotcreteExcavation) {
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();

        double step = anchorsExcavation.getStep();
        double distanceBetweenRows = anchorsExcavation.getDistanceBetweenRows();

        int scaleWidth = GeneralService.toScaleExcavationParameter(width);
        int scaleHeight = GeneralService.toScaleExcavationParameter(height);
        int scaleLength = GeneralService.toScaleExcavationParameter(length);

        DimensionPointsExcavation points = new DimensionPointsExcavation();

        // Размер ширины (смещение вниз)
        points.widthStart = new Point(-scaleWidth / 2, 0);
        points.widthEnd = new Point(scaleWidth / 2, 0);
        points.widthOffset = 65;  // смещение вниз
        points.widthLengthextensionline = 50; //длина выносной линии
        points.widthText = String.format("%.1f м", width);

        // Размер высоты (смещение влево)
        points.heightStart = new Point(-scaleWidth / 2, 0);
        points.heightEnd = new Point(-scaleWidth / 2, -scaleHeight);
        points.heightOffset = -300;  // смещение влево (отрицательное)
        points.heightLengthextensionline = -50; //длина выносной линии
        points.heightText = String.format("%.1f м", height);

        // Расстояние до нижнего анкера (смещение вправо)
        double bottomAnchorY = anchorsExcavation.getBottomAnchorY();
        int scaleBottomAnchorY = GeneralService.toScaleExcavationParameter(bottomAnchorY);

        points.heightToBottomAnchorStart = new Point(-scaleWidth / 2, 0);
        points.heightToBottomAnchorEnd = new Point(-scaleWidth / 2, scaleBottomAnchorY);
        points.heightToBottomAnchorOffset = -225;  // смещение вправо
        points.heightToBottomAnchorLengthextensionline = -50; //длина выносной линии
        points.heightToBottomAnchorText = String.format("%.1f м", -bottomAnchorY);

        // Расстояние между анкерами в ряду
        double firstСrossSectionAnchorX = anchorsExcavation.getFirstcrossSectionAnchorX();
        double firstСrossSectionAnchorY = anchorsExcavation.getFirstcrossSectionAnchorY();
        double secondСrossSectionAnchorX = anchorsExcavation.getSecondcrossSectionAnchorX();
        double secondСrossSectionAnchorY = anchorsExcavation.getSecondcrossSectionAnchorY();

        int scaleFirstCrossSectionAnchorX = GeneralService.toScaleExcavationParameter(firstСrossSectionAnchorX);
        int scaleFirstCrossSectionAnchorY = GeneralService.toScaleExcavationParameter(firstСrossSectionAnchorY);
        int scaleSecondCrossSectionAnchorX = GeneralService.toScaleExcavationParameter(secondСrossSectionAnchorX);
        int scaleSecondCrossSectionAnchorY = GeneralService.toScaleExcavationParameter(secondСrossSectionAnchorY);

        points.stepStart = new Point(scaleSecondCrossSectionAnchorX, scaleSecondCrossSectionAnchorY);
        points.stepEnd = new Point(scaleFirstCrossSectionAnchorX, scaleFirstCrossSectionAnchorY);
        points.stepOffset = -225;  // смещение влево (отрицательное)
        points.stepLengthextensionline = -50; //длина выносной линии
        points.stepText = String.format("%.1f м", step);

        // Расстояние между рядами анкеров
        double firstLongSectionAnchorX = anchorsExcavation.getFirstLongSectionAnchorX();
        double firstLongSectionAnchorY = anchorsExcavation.getFirstLongSectionAnchorY();
        double secondLongSectionAnchorX = anchorsExcavation.getSecondLongSectionAnchorX();
        double secondLongSectionAnchorY = anchorsExcavation.getSecondLongSectionAnchorY();

        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        int scaleFirstLongSectionAnchorX = GeneralService.toScaleExcavationParameter(firstLongSectionAnchorX);
        int scaleFirstLongSectionAnchorY = GeneralService.toScaleExcavationParameter(firstLongSectionAnchorY);
        int scaleSecondLongSectionAnchorX = GeneralService.toScaleExcavationParameter(secondLongSectionAnchorX);
        int scaleSecondLongSectionAnchorY = GeneralService.toScaleExcavationParameter(secondLongSectionAnchorY);

        points.distanceBetweenRowsStart = new Point(scaleFirstLongSectionAnchorX + distance, scaleFirstLongSectionAnchorY);
        points.distanceBetweenRowsEnd = new Point(scaleSecondLongSectionAnchorX + distance, scaleSecondLongSectionAnchorY);

        points.distanceBetweenRowsOffset = -225;  // смещение влево (отрицательное)
        points.distanceBetweenRowsLengthextensionline = -50; //длина выносной линии
        points.distanceBetweenRowsText = String.format("%.1f м", distanceBetweenRows);

        //Толщина набрызгбетона
        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();
        int scaleThicknessShorcrete = GeneralService.toScaleExcavationParameter(thicknessShorcrete);

        points.thicknessShorcreteStart = new Point(scaleLength + distance, -scaleHeight);
        points.thicknessShorcreteEnd = new Point(scaleLength + distance, -scaleHeight + scaleThicknessShorcrete + 5);
        points.thicknessShorcreteOffset = -100;  // смещение вправо
        points.thicknessShorcreteLengthextensionline = -50; //длина выносной линии
        points.thicknessShorcreteText = String.format("%.0f см", thicknessShorcrete * 100);

        return points;
    }

    public static class DimensionPointsExcavation {
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
    }
}