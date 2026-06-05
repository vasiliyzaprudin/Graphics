package com.mining.graphics.service.support.excavation;

import com.mining.graphics.service.excavation.ServiceExcavation;

public class ServiceAnchorsExcavation {

    public static double calculateStepLargeArcX(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * Math.sin(omega + j * step / largeArcRadius);
    }

    public static double calculateStepLargeArcY(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * (1.0 - Math.cos(omega + j * step / largeArcRadius));
    }

    public static double calculateStepLargeArcAnchorsX(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return (largeArcRadius + lengthAnch) * Math.sin(omega + j * step / largeArcRadius);
    }

    public static double calculateStepLargeArcAnchorsY(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(omega + j * step / largeArcRadius);
    }

    public static double calculateStepSmallArcX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian) {
        return width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public static double calculateStepSmallArcY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian) {
        return -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }

    public static double calculateStepSmallArcAnchorsX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public static double calculateStepSmallArcAnchorsY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }

    public static double calculateStepWallX(double width) {
        return width / 2.0;
    }

    public static double calculateStepWallY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }

    public static double calculateStepWallAnchorsX(double width, double lengthAnch) {
        return width / 2.0 + lengthAnch;
    }

    public static double calculateStepWallAnchorsY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }

    public static boolean determiningInstallationAnchorsCenter(double width, double height, double formIndication, double distanceLowerAnchor,
                                                               double step) {
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        int numberCrossSectionAnchors = (int) Math.ceil((totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0) / step);
        if ((numberCrossSectionAnchors + 1) % 2 == 0) return true;
        else return false;
    }
}
