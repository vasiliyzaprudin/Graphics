package com.mining.graphics.model;

public class ModelExcavation {
    //Исходные геометрические параметры выработки
    private double B = 5.0; //ширина
    private double H = 8.0; //высота
    private double hr = B / 3.0; //высота закругления

    //Расчетные геометрические параметры выработки
    private double alpha; //опорный угол дуги большого радиуса
    private double beta; //опорный угол дуги малого радиуса
    private double r; // радиус малой окружности
    private double R; //радиус большой окружности
    private double rl; //длина дуги малой окружности
    private double Rl; //длина дуги большой окружности
    private double LroofAc; //длина свода в плоскости поперечного сечения горной выработки

    private double calculatealpha() {
        return Math.atan(2.0 * hr / B);
    }

    private double calculatebeta() {
        return Math.PI / 2.0 - alpha;
    }

    private double calculater() {
        return B * (2.0 / 3.0 * Math.sin(alpha) + Math.cos(alpha) - 1.0) / (2.0 * (Math.sin(alpha)
                + Math.cos(alpha) - 1.0));
    }

    private double calculateR() {
        return B * (1.0 / 3.0 - Math.cos(alpha) / (2.0 * (1.0 - Math.sin(alpha)))) / (1 - Math.cos(alpha)
                - Math.sin(2.0 * alpha) / (2.0 * (1.0 - Math.sin(alpha))));
    }

    private double calculaterl() {
        return r * beta;
    }

    private double calculateRl() {
        return 2.0 * R * alpha;
    }

    private double calculateLroof() {
        return 2.0 * rl + Rl;
    }

    public ModelExcavation() {
        this.alpha = calculatealpha();
        this.beta = calculatebeta();
        this.r = calculater();
        this.R = calculateR();
        this.rl = calculaterl();
        this.Rl = calculateRl();
        this.LroofAc = calculateLroof();
    }

    public double getB() {
        return B;
    }

    public double getH() {
        return H;
    }

    public double gethr() {
        return hr;
    }

    public double getalpha() {
        return alpha;
    }

    public double getbeta() {
        return beta;
    }

    public double getr() {
        return r;
    }

    public double getR() {
        return R;
    }

    public double getrl() {
        return rl;
    }

    public double getRl() {
        return Rl;
    }

    public double getLroofAc() {
        return LroofAc;
    }
}


