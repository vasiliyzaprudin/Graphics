package com.mining.graphics.service.excavation;

import com.mining.graphics.model.excavation.ModelExcavation;

public class ServiceExcavation extends ModelExcavation {
    public double ALPHA;
    public double BETA;
    public int HRSC;
    public int RBIGSC;
    public int RSMALLSC;
    public int HSC;
    public int BSC;

    //Расчетные геометрические параметры выработки
    public static double HR(double B, double K) {
        return B / K; //высота закругления
    }

    public static double ALPHA(double B, double K) {
        return Math.atan(2.0 * HR(B, K) / B); //опорный угол дуги большого радиуса;
    }

    public static double BETA(double B, double K) {
        return Math.PI / 2.0 - ALPHA(B, K); //опорный угол дуги малого радиуса
    }

    public static double RBIG(double B, double K) {
        return (HR(B, K) / Math.cos(ALPHA(B, K)) - B / 2.0 - HR(B, K) * Math.tan(ALPHA(B, K))) / (1.0 / Math.cos(ALPHA(B, K)) - 1 - Math.tan(ALPHA(B, K))); //радиус большой окружности
    }

    public static double RSMALL(double B, double K) {
        return RBIG(B, K) - (RBIG(B, K) - HR(B, K)) / Math.cos(ALPHA(B, K)); // радиус малой окружности
    }

    public void calcElemExSc(double B, double H, double K, double SC) {
        ALPHA = ALPHA(B, K);
        BETA = BETA(B, K);
        HSC = (int) (H * SC);
        BSC = (int) (B * SC);
        HRSC = (int) (HR(B, K) * SC);
        RBIGSC = (int) (RBIG(B, K) * SC);
        RSMALLSC = (int) (RSMALL(B, K) * SC);
    }
}