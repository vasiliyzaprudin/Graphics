package com.mining.graphics.model.support;

public class MeshExcavation {
    private double distanceBetweenContourAndGrid = 0.05; //расстояние между конрутом горной выработки и сеткой в метрах
    private double gridStep = 0.25; //расстояние между прутками сетки в метрах
    private double distanceBetweenSoilAndMesh = 1.5; //расстояние мужду почвой горной выработки и сеткой

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
