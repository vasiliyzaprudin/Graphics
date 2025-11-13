package com.mining.graphics.model;

import com.mining.graphics.graphics.GraphicsWindow;

import java.awt.*;

public class ModelExcavation {
    //Исходные геометрические параметры выработки
    public double B = 4.2; //ширина
    public double H = 4.2; //высота
    public double hr = B / 3.0; //высота закругления
    public int scaleEx = 65; //масштаб построений
    public int distance = 550; //расстояние между поперечным разрезом и вида сбоку в графическом окне

    //Расчетные геометрические параметры выработки
    public double alpha; //опорный угол дуги большого радиуса
    public double beta; //опорный угол дуги малого радиуса
    public double r; // радиус малой окружности
    public double R; //радиус большой окружности
    public double rl; //длина дуги малой окружности
    public double Rl; //длина дуги большой окружности
    public double LroofAc; //длина свода в плоскости поперечного сечения горной выработки

    public double calculatealpha() {
        return Math.atan(2.0 * hr / B);
    }

    public double calculatebeta() {
        return Math.PI / 2.0 - alpha;
    }

    public double calculater() {
        return B * (2.0 / 3.0 * Math.sin(alpha) + Math.cos(alpha) - 1.0) / (2.0 * (Math.sin(alpha)
                + Math.cos(alpha) - 1.0));
    }

    public double calculateR() {
        return B * (1.0 / 3.0 - Math.cos(alpha) / (2.0 * (1.0 - Math.sin(alpha)))) / (1 - Math.cos(alpha)
                - Math.sin(2.0 * alpha) / (2.0 * (1.0 - Math.sin(alpha))));
    }

    public double calculaterl() {
        return r * beta;
    }

    public double calculateRl() {
        return 2.0 * R * alpha;
    }

    public double calculateLroof() {
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
}


