package com.mining.graphics.service.support.intersection;

import com.mining.graphics.service.support.excavation.ServiceMaterialSupportExcavation;

public class ServiceMaterialSupportIntersection {

    public static double calculateAreaAnchorageMainExcavation(double widthMain, double heightMain, double formIndicationMain, double increasedWidth,
                                                              double increasedHeight, double xPointIntrsectionExcavation, double xStartRounding,
                                                              double distanceLowerAnchor) {
        double anchorageLength = ServiceMaterialSupportExcavation.calculateAnchorageLength(widthMain, heightMain, formIndicationMain, distanceLowerAnchor);
        double anchorageLengthIncreased = ServiceMaterialSupportExcavation.calculateAnchorageLength(increasedWidth, increasedHeight, formIndicationMain, distanceLowerAnchor);

        double length = xStartRounding - xPointIntrsectionExcavation;

        double anchorageMainExcavationArea = length * (anchorageLength + anchorageLengthIncreased) / 2.0;

        return anchorageMainExcavationArea;
    }

    public static double calculateAreaAnchorageAdjacentExcavation(double widthAdjacent, double heightAdjacent, double formIndicationAdjacent,
                                                                  double increasedWidth, double increasedHeight, double yPointIntrsectionExcavation,
                                                                  double yStartRounding, double distanceLowerAnchor) {
        double anchorageLength = ServiceMaterialSupportExcavation.calculateAnchorageLength(widthAdjacent, heightAdjacent, formIndicationAdjacent, distanceLowerAnchor);
        double anchorageLengthIncreased = ServiceMaterialSupportExcavation.calculateAnchorageLength(increasedWidth, increasedHeight, formIndicationAdjacent, distanceLowerAnchor);

        double length = Math.abs(yStartRounding - yPointIntrsectionExcavation);

        double anchorageAdjacentExcavationArea = length * (anchorageLength + anchorageLengthIncreased) / 2.0;

        return anchorageAdjacentExcavationArea;
    }

    public static double calculateAreaAnchorageIntersectionCenter(double increasedWidthAdjacentExcavation, double increasedWidthMainExcavation,
                                                                  double increasedHeightMainExcavation, double formIndicationIntersection,
                                                                  double distanceLowerAnchor) {
        double anchorageLengthIncreased = ServiceMaterialSupportExcavation.calculateAnchorageLength(increasedWidthMainExcavation, increasedHeightMainExcavation, formIndicationIntersection, distanceLowerAnchor) / 2.0;

        double anchorageIntersectionCenterArea = anchorageLengthIncreased * increasedWidthAdjacentExcavation;
        return anchorageIntersectionCenterArea;
    }

    public static int calculateNumderTotalAnchorsIntersection(double intersectionAnchorageTotalArea, double step) {
        int numderTotalAnchorsIntersection = (int) Math.ceil(intersectionAnchorageTotalArea / (step * step));
        return numderTotalAnchorsIntersection;
    }

    public static int calculateNumderTotalMeshIntersection(double areaTotalAnchorageIntersection, double meshVolume) {
        int numderTotalMeshIntersection = (int) (Math.floor(areaTotalAnchorageIntersection / meshVolume));
        return numderTotalMeshIntersection;
    }
}
