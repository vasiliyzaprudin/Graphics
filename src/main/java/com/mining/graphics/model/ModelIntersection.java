package com.mining.graphics.model;

public class ModelIntersection {
    public double b1 = 5.0; //ширина выработки 1
    public double b2 = 5.0; //ширина выработки 2
    public double b3 = 5.0; //ширина выработки 3
    public int alpha1 = 45; //угол поворота оси выработки 1 относительно севера (от 0 до 270)
    public int alpha2 = 180; //угол поворота оси выработки 2 относительно севера (от 45 до 315)
    public int alpha3 = 315; //угол поворота оси выработки 3 относительно севера (от 90 до 360)
    public double L1 = 10.0; //длина выработки 1
    public double L2 = 15.0; //длина выработки 2
    public double L3 = 10.0; //длина выработки 3
    public int scaleIn = 30; //масштаб построений

    public double alpha1Rad = alpha1 * Math.PI / 180;
    public double alpha2Rad = alpha2 * Math.PI / 180;
    public double alpha3Rad = alpha3 * Math.PI / 180;

    public int b1sc = (int) (b1 * scaleIn);
    public int b2sc = (int) (b2 * scaleIn);
    public int b3sc = (int) (b3 * scaleIn);

    public int L1sc = (int) (L1 * scaleIn);
    public int L2sc = (int) (L2 * scaleIn);
    public int L3sc = (int) (L3 * scaleIn);
}