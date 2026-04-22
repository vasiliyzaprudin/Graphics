package com.mining.graphics.model.support.excavation;

public class MeshExcavation {
    private double distanceBetweenContourAndGrid = 0.05;
    private double gridStep = 0.25;
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
