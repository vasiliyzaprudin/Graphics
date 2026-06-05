package com.mining.graphics.material.intersection;

import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.intersection.AnchorsIntersection;
import com.mining.graphics.service.support.intersection.ServiceMaterialSupportIntersection;

public class IntersectionMaterial {

   private final ModelIntersection modelIntersection;
   private final CoordinatesIntersection modelCoordinatesIntersection;
   private  final AnchorsIntersection anchorsIntersection;

    IntersectionMaterial(ModelIntersection modelIntersection, CoordinatesIntersection modelCoordinatesIntersection, AnchorsIntersection anchorsIntersection){
        this.modelIntersection = modelIntersection;
        this.modelCoordinatesIntersection = modelCoordinatesIntersection;
        this.anchorsIntersection = anchorsIntersection;
    }

    public double areaTotalAnchorageIntersection() {
        double widthAdjacent = modelIntersection.getWidth1();
        double heightAdjacent = modelIntersection.getHeight1();
        double widthMain = modelIntersection.getWidth2();
        double heightMain = modelIntersection.getHeight2();

        double increasedWidthAdjacent = modelCoordinatesIntersection.getIncreasedWidth1();
        double increasedHeightAdjacent = modelCoordinatesIntersection.getIncreasedHeight1();
        double increasedWidthMain = modelCoordinatesIntersection.getIncreasedWidth2();
        double increasedHeightMain = modelCoordinatesIntersection.getIncreasedHeight2();

        double yPointIntrsectionExcavation = modelCoordinatesIntersection.getYPointIntrsectionExcavation12();
        double yStartRounding = modelCoordinatesIntersection.getYStartRounding12();
        double xPointIntrsectionExcavation = modelCoordinatesIntersection.getXPointIntrsectionExcavation12();
        double xStartRounding = modelCoordinatesIntersection.getXStartRounding21();

        double formIndicationAdjacent = modelIntersection.getFormIndication1();
        double formIndicationMain = modelIntersection.getFormIndication2();
        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();

        double distanceLowerAnchor = anchorsIntersection.getDistanceLowerAnchor1();

        double anchorageMainExcavationArea = ServiceMaterialSupportIntersection.calculateAreaAnchorageMainExcavation(widthMain, heightMain, formIndicationMain, increasedWidthMain, increasedHeightMain, xPointIntrsectionExcavation, xStartRounding, distanceLowerAnchor);
        System.out.println("anchorageMainExcavationArea = " + anchorageMainExcavationArea);

        double anchorageAdjacentExcavationArea = ServiceMaterialSupportIntersection.calculateAreaAnchorageAdjacentExcavation(widthAdjacent, heightAdjacent, formIndicationAdjacent, increasedWidthAdjacent, increasedHeightAdjacent, yPointIntrsectionExcavation, yStartRounding, distanceLowerAnchor);
        System.out.println("anchorageAdjacentExcavationArea = " + anchorageAdjacentExcavationArea);

        double intersectionCenterArea = ServiceMaterialSupportIntersection.calculateAreaAnchorageIntersectionCenter(increasedWidthAdjacent, increasedWidthMain, increasedHeightMain, formIndicationIntersection, distanceLowerAnchor);
        System.out.println("intersectionCenterArea = " + intersectionCenterArea);

        double intersectionAnchorageTotalArea = anchorageMainExcavationArea * 2.0 + anchorageAdjacentExcavationArea + intersectionCenterArea;
        System.out.println("intersectionTotalArea = " + intersectionAnchorageTotalArea);

        return intersectionAnchorageTotalArea;
    }

    public int numderTotalAnchorsIntersection() {
        double intersectionAnchorageTotalArea = areaTotalAnchorageIntersection();
        double step = anchorsIntersection.getStep1();
        int numderTotalAnchorsIntersection = ServiceMaterialSupportIntersection.calculateNumderTotalAnchorsIntersection(intersectionAnchorageTotalArea, step);

        System.out.println("numderTotalAnchorsIntersection = " + numderTotalAnchorsIntersection);
        return numderTotalAnchorsIntersection;
    }
}
