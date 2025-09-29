package com.mining.graphics.mineexcavation;

public class ModelIntersection {
    private double b1 = 5.0; //ширина выработки 1
    private double b2 = 5.5; //ширина выработки 2
    private double b3 = 4.0; //ширина выработки 3
    private double alpha1 = 3.0 / 2.0 * Math.PI; //угол поворота оси выработки 1 относительно севера
    private double alpha2 = 3.0 / 5.0 * Math.PI; //угол поворота оси выработки 2 относительно севера
    private double alpha3; //угол поворота оси выработки 3 относительно севера
    private double L1 = 5.0; //длина выработки 1
    private double L2; //длина выработки 2
    private double L3; //длина выработки 3


    public double getb1() {
        return b1;
    }

    public double getb2() {
        return b2;
    }

    public double getb3() {
        return b3;
    }

    public double getalpha1() {
        return alpha1;
    }

    public double getalpha2() {
        return alpha2;
    }

    public double getalpha3() {
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
