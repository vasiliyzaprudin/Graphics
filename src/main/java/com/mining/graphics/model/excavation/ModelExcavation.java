package com.mining.graphics.model.excavation;

public class ModelExcavation {
    private double width = 4.7; //ширина
    private double height = 4.2; //высота
    private double length = 5.0; //длина
    private double formIndication = 3.0; //показатель формы свода (отношение высоты свода к ширине горной выработки)

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getFormIndication() {
        return formIndication;
    }
}