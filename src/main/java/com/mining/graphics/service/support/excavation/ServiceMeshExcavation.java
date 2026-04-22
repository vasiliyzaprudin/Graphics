package com.mining.graphics.service.support.excavation;

public class ServiceMeshExcavation {

    public static double getWidthExcavationWithMesh(double width, double distanceBetweenContourAndGrid) {
        return width - 2.0 * distanceBetweenContourAndGrid;
    }

    public static double getHeightExcavationWithMesh(double height, double distanceBetweenContourAndGrid) {
        return height - distanceBetweenContourAndGrid;
    }

    public static int getScaleDistanceBetweenSoilAndMesh(double distanceBetweenSoilAndMesh, double scale) {
        return (int) (Math.round(distanceBetweenSoilAndMesh * scale));
    }

    public static int getScaleGridStep(double gridStep, int scale) {
        return (int) (Math.round(gridStep * scale));
    }
}
