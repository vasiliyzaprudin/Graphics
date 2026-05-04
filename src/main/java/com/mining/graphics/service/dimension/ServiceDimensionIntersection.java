package com.mining.graphics.service.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.intersection.AnchorsIntersection;
import com.mining.graphics.service.GeneralService;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.intersection.CalculateCoordinatesAnchorsIntersection;

import java.awt.*;

public class ServiceDimensionIntersection {
    private CalculateCoordinatesAnchorsIntersection calculateCoordinatesAnchorsIntersection;
    private AnchorsIntersection anchorsIntersection;
    private AnchorsExcavation anchorsExcavation;
    private CoordinatesIntersection coordinatesIntersection;
    public DimensionPointsIntersection calculateDimensionIntersection(CoordinatesIntersection coordinatesIntersection,
                                                                      ModelIntersection modelIntersection,
                                                                      CalculateCoordinatesAnchorsIntersection calculateCoordinatesAnchorsIntersection,
                                                                      AnchorsIntersection anchorsIntersection) {

        DimensionPointsIntersection dimensionPointsIntersection = new DimensionPointsIntersection();

        // Размер ширины горной выработки 1
        dimensionPointsIntersection.width1Start = new Point(coordinatesIntersection.getXScaleStopeLeft1(), coordinatesIntersection.getYScaleStopeLeft1());
        dimensionPointsIntersection.width1End = new Point(coordinatesIntersection.getXScaleStopeRight1(), coordinatesIntersection.getYScaleStopeRight1());
        dimensionPointsIntersection.width1Offset = -50;
        dimensionPointsIntersection.width1LengthExtensionline = -30;
        dimensionPointsIntersection.width1Text = String.format("%.1f м", modelIntersection.getWidth1());

        // Размер ширины горной выработки 3
        dimensionPointsIntersection.width3Start = new Point(coordinatesIntersection.getXScaleStopeLeft3(), coordinatesIntersection.getYScaleStopeLeft3());
        dimensionPointsIntersection.width3End = new Point(coordinatesIntersection.getXScaleStopeRight3(), coordinatesIntersection.getYScaleStopeRight3());
        dimensionPointsIntersection.width3Offset = -50;
        dimensionPointsIntersection.width3LengthExtensionline = -30;
        dimensionPointsIntersection.width3Text = String.format("%.1f м", modelIntersection.getWidth3());

        // Размер высоты горной выработки 1
        dimensionPointsIntersection.height1Start = new Point(0, GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION);
        dimensionPointsIntersection.height1End = new Point(0, GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION - coordinatesIntersection.getScaleHeight1());
        dimensionPointsIntersection.height1Offset = 0;
        dimensionPointsIntersection.height1LengthExtensionline = 0;
        dimensionPointsIntersection.height1Text = String.format("%.1f м", modelIntersection.getHeight1());

        // Размер высоты горной выработки 3
        dimensionPointsIntersection.height3Start = new Point(coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION);
        dimensionPointsIntersection.height3End = new Point(coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION - coordinatesIntersection.getScaleHeight3());
        dimensionPointsIntersection.height3Offset = -50;
        dimensionPointsIntersection.height3LengthExtensionline = -30;
        dimensionPointsIntersection.height3Text = String.format("%.1f м", modelIntersection.getHeight3());

        // Растояние до нижнего анкера
        double[][] crossSectionAnchors2 = calculateCoordinatesAnchorsIntersection.getCrossSectionAnchors2();

        double[] bottomAnchor = crossSectionAnchors2[crossSectionAnchors2.length - 1];
        double bottomAnchorY = bottomAnchor[1];

        System.out.println(bottomAnchorY);

        int scaleBottomAnchorY = GeneralService.toScaleIntersectionParameter(Math.abs(bottomAnchorY));

        int x1 = coordinatesIntersection.getXScaleIntersectionAxisAndStope2();
        int y1 = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        int x2 = coordinatesIntersection.getXScaleIntersectionAxisAndStope2();
        int y2 = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION - scaleBottomAnchorY;

        dimensionPointsIntersection.heightToBottomAnchorStart = new Point(x2, y2);
        dimensionPointsIntersection.heightToBottomAnchorEnd = new Point(x1, y1);
        dimensionPointsIntersection.heightToBottomAnchorOffset = -50;
        dimensionPointsIntersection.heightToBottomAnchorLengthExtensionline = -30;
        dimensionPointsIntersection.heightToBottomAnchorText = String.format("%.1f м", -bottomAnchorY);


        double width1 = modelIntersection.getWidth1();
        double height1 = modelIntersection.getHeight1();
        double formIndication1 = modelIntersection.getFormIndication1();
        double distanceLowerAnchor1 = anchorsIntersection.getDistanceLowerAnchor1();
        double step1 = anchorsIntersection.getStep1();

        double width2 = modelIntersection.getWidth2();
        double height2 = modelIntersection.getHeight2();
        double formIndication2 = modelIntersection.getFormIndication2();
        double distanceLowerAnchor2 = anchorsIntersection.getDistanceLowerAnchor2();
        double step2 = anchorsIntersection.getStep2();

        boolean installationAnchorsCenter1 = ServiceExcavation.determiningInstallationAnchorsCenter(width1, height1, formIndication1, distanceLowerAnchor1, step1);
        boolean installationAnchorsCenter2 = ServiceExcavation.determiningInstallationAnchorsCenter(width2, height2, formIndication2, distanceLowerAnchor2, step2);

        int scaleStep = GeneralService.toScaleIntersectionParameter(step1);

        if (installationAnchorsCenter1 == true && installationAnchorsCenter2 == true) {
            dimensionPointsIntersection.step1Start = new Point(0, 0);
            dimensionPointsIntersection.step1End = new Point(scaleStep, 0);
            dimensionPointsIntersection.step2Start = new Point(0, -scaleStep);
            dimensionPointsIntersection.step2End = new Point(0, 0);

        } else if (installationAnchorsCenter1 == false && installationAnchorsCenter2 == true) {
            dimensionPointsIntersection.step1Start = new Point(-scaleStep / 2, 0);
            dimensionPointsIntersection.step1End = new Point(scaleStep / 2, 0);
            dimensionPointsIntersection.step2Start = new Point(-scaleStep / 2, -scaleStep);
            dimensionPointsIntersection.step2End = new Point(-scaleStep / 2, 0);

        } else if (installationAnchorsCenter1 == true && installationAnchorsCenter2 == false) {
            dimensionPointsIntersection.step1Start = new Point(0, scaleStep / 2);
            dimensionPointsIntersection.step1End = new Point(scaleStep, scaleStep / 2);
            dimensionPointsIntersection.step2Start = new Point(0, -scaleStep / 2);
            dimensionPointsIntersection.step2End = new Point(0, scaleStep / 2);

        } else if (installationAnchorsCenter1 == false && installationAnchorsCenter2 == false) {
            dimensionPointsIntersection.step1Start = new Point(-scaleStep / 2, scaleStep / 2);
            dimensionPointsIntersection.step1End = new Point(scaleStep / 2, scaleStep / 2);
            dimensionPointsIntersection.step2Start = new Point(-scaleStep / 2, -scaleStep / 2);
            dimensionPointsIntersection.step2End = new Point(-scaleStep / 2, scaleStep / 2);
        }

        dimensionPointsIntersection.step2Offset = -75;
        dimensionPointsIntersection.step2LengthExtensionline = 0;
        dimensionPointsIntersection.step2Text = String.format("%.1f м", anchorsIntersection.getStep1());

        dimensionPointsIntersection.step1Offset = -75;
        dimensionPointsIntersection.step1LengthExtensionline = 0;
        dimensionPointsIntersection.step1Text = String.format("%.1f м", anchorsIntersection.getStep1());

        return dimensionPointsIntersection;
    }
    public static class DimensionPointsIntersection {
        public Point width1Start;
        public Point width1End;
        public int width1Offset;
        public int width1LengthExtensionline;
        public String width1Text;

        public Point width3Start;
        public Point width3End;
        public int width3Offset;
        public int width3LengthExtensionline;
        public String width3Text;

        public Point height1Start;
        public Point height1End;
        public int height1Offset;
        public int height1LengthExtensionline;
        public String height1Text;

        public Point height3Start;
        public Point height3End;
        public int height3Offset;
        public int height3LengthExtensionline;
        public String height3Text;

        public Point heightToBottomAnchorStart;
        public Point heightToBottomAnchorEnd;
        public int heightToBottomAnchorOffset;
        public int heightToBottomAnchorLengthExtensionline;
        public String heightToBottomAnchorText;

        public Point step1Start;
        public Point step1End;
        public int step1Offset;
        public int step1LengthExtensionline;
        public String step1Text;

        public Point step2Start;
        public Point step2End;
        public int step2Offset;
        public int step2LengthExtensionline;
        public String step2Text;
    }
}
