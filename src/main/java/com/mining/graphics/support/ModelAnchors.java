package com.mining.graphics.support;

public class ModelAnchors {

    private double l = 2.1; //длина анкера
    private double bAc =0.8; //шаг анкерования в ряду
    private double cAl = 0.8; //расстояние между рядами анкеров
    private double d = 0.1; //размер опорной плитки
    private  double p = 0.6; //максимальное расстояние от почвы выработки до точки установки нижнего анкера

    public double getl() {
        return l;
    }

    public double getbAc() {
        return bAc;
    }

    public double getcAl() {
        return cAl;
    }

    public double getd() {
        return d;
    }

    public double getp() {
        return p;
    }
}