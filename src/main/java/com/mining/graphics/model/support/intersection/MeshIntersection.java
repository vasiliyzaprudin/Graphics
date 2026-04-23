package com.mining.graphics.model.support.intersection;

public class MeshIntersection {
    private double distanceBetweenContourAndGrid = 0.05;
    private double gridStep = 0.5;
    private double distanceBetweenSoilAndMesh = 1.5;

    public double getDistanceBetweenContourAndGrid() {
        return distanceBetweenContourAndGrid;
    }
    public double getGridStep() {
        return gridStep;
    }
    public double getDistanceBetweenSoilAndMesh(){
        return distanceBetweenSoilAndMesh;
    }
}
