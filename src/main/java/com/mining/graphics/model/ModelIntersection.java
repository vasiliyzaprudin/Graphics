package com.mining.graphics.model;

public class ModelIntersection {
    private double b1 = 100.0; //ширина выработки 1
    private double b2 = 100.0; //ширина выработки 2
    private double b3 = 100.0; //ширина выработки 3
    private int alpha1 = 90; //угол поворота оси выработки 1 относительно севера (от 0 до 270)
    private int alpha2 = 180; //угол поворота оси выработки 2 относительно севера (от 45 до 315)
    private int alpha3 = 270; //угол поворота оси выработки 3 относительно севера (от 90 до 360)
    private double L1 = 250.0; //длина выработки 1
    private double L2 = 250.0; //длина выработки 2
    private double L3 = 250.0; //длина выработки 3


    public double getb1() {
        return b1;
    }

    public double getb2() {
        return b2;
    }

    public double getb3() {
        return b3;
    }

    public int getalpha1() {
        return alpha1;
    }

    public int getalpha2() {
        return alpha2;
    }

    public int getalpha3() {
        return alpha3;
    }

    public double getL1() {
        return L1;
    }

    public double getL2() {
        return L2;
    }

    public double getL3() {
        return L3;
    }
}
