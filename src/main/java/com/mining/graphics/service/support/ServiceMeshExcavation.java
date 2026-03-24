package com.mining.graphics.service.support;

public class ServiceMeshExcavation {

    public double getWidthExcavationWithMesh(double width, double distanceBetweenContourAndGrid) {
        return width - 2.0 * distanceBetweenContourAndGrid;
    }

    public int getScaleWidthExcavationWithMesh(double width, double distanceBetweenContourAndGrid, int scale) {
        return (int) (Math.round((width - 2.0 * distanceBetweenContourAndGrid) * scale));
    }

    public double getHeightExcavationWithMesh(double height, double distanceBetweenContourAndGrid) {
        return height - distanceBetweenContourAndGrid;
    }

    public int getScaleHeightExcavationWithMesh(double height, double distanceBetweenContourAndGrid, int scale) {
        return (int) (Math.round((height - distanceBetweenContourAndGrid) * scale));
    }

    public int getScaleDistanceBetweenSoilAndMesh(double distanceBetweenSoilAndMesh, double scale) {
        return (int) (Math.round(distanceBetweenSoilAndMesh * scale));
    }

    public int getScaleDistanceBetweenContourAndGrid(double distanceBetweenContourAndGrid, int scale) {
        return (int) (Math.round(distanceBetweenContourAndGrid * scale));
    }

    public int getScaleGridStep(double gridStep, int scale) {
        return (int) (Math.round(gridStep * scale));
    }
}
