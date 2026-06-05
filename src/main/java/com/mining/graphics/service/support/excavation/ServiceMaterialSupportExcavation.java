package com.mining.graphics.service.support.excavation;

import com.mining.graphics.service.excavation.ServiceExcavation;

public class ServiceMaterialSupportExcavation {

    public static double calculateAnchorageLength(double width, double height, double formIndication, double distanceLowerAnchor) {
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double totalAnchorageLength = totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0;

        return totalAnchorageLength;
    }

    public static int calculateNumberAnchorsInRow(double width, double height, double formIndication, double distanceLowerAnchor, double step) {

        double anchorageLength = calculateAnchorageLength(width, height, formIndication, distanceLowerAnchor);
        return (int) Math.ceil(anchorageLength / step);
    }

    public static int calculateTotalNumberAnchors(int numberAnchorsInRow, double lengthExcavation) {
        int totalNumberAnchorsExcavation = (int) (Math.ceil(numberAnchorsInRow * lengthExcavation));
        return totalNumberAnchorsExcavation;
    }

    public static double calculateMeshingLength (double width, double height, double formIndication, double distanceLowerAnchor){
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double meshingLength = totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0;

        return meshingLength;
    }
    public static double calculateAreaMesh (double meshLength, double lengthExcavation){

        int areaMesh = (int) (Math.ceil(meshLength * lengthExcavation));
        return areaMesh;
    }

    public static int calculateTotalNumberMesh (double totalAreaMesh, double meshVolume) {
        int totalNumberMesh = (int)(Math.floor(totalAreaMesh/meshVolume));
        return totalNumberMesh;
    }

    public static double calculateShotcreteLength(double width, double height, double formIndication) {
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double totalShotcreteLength = totalArcLength + (height - archHeight) * 2.0;

        return totalShotcreteLength;
    }

    public static double calculateShotcreteVolume(double shotcreteLength, double lengthExcavation) {
        double shotcreteVolume = shotcreteLength * lengthExcavation;
        return shotcreteVolume;
    }
}
