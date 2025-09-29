package com.mining.graphics.service;

import com.mining.graphics.mineexcavation.ModelExcavation;

public class ServiceAnchors {
    private double[][] СoorAnchAc; //массив для хранения координат установки анкеров в поперечном сечении

    double l = 1.8; //длина анкера
    double bAc = 0.65; //шаг анкерования в ряду
    double cAl = 1.0; //расстояние между рядами анкеров
    double d = 0.15; //размер опорной плитки

    ModelExcavation ModelExcavation = new ModelExcavation();
    double B = ModelExcavation.getB();
    double hr = ModelExcavation.gethr();
    double alpha = ModelExcavation.getalpha();
    double beta = ModelExcavation.getbeta();
    double r = ModelExcavation.getr();
    double R = ModelExcavation.getR();
    double rl = ModelExcavation.getrl();
    double Rl = ModelExcavation.getRl();
    double LroofAc = ModelExcavation.getLroofAc();

    int n = (int) Math.floor(LroofAc / bAc);

    public ServiceAnchors() {
        CalculateCoordinatesAnchorsAc();
    }

    public void CalculateCoordinatesAnchorsAc() {
        int i, j;

        СoorAnchAc = new double[n + 1][4]; //(n+1) - количество анкеров в ряду

        //Определение варианта расположения анкеров
        switch (n % 2) {
            case 0: //Анкер устанавливается по центру кровли выработки
                for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                    СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(j * bAc / R);
                    СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                    СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(j * bAc / R);
                    СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                }

                double phi0 = (i * bAc - R * alpha) / r; /* phi0 - это опорный угол дуги малого радиуса lbeg,
                которая является продолжением остатка дуги большого радиуса Lrem.
                Их сумма равна шагу анкерования Lrem + lbeg = b */
                //double Lrem = R * alpha - bAc * (i - 1);
                double lbeg = r * phi0;

                for (j = 0; rl - lbeg > j * bAc; j++, i++) {
                    СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
                    СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                    СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
                    СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                }

                for (j = 1; Rl / 2.0 > j * bAc; j++, i++) {
                    СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(j * bAc / R);
                    СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                    СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(j * bAc / R);
                    СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                }

                for (j = 0; rl - lbeg > j * bAc; j++, i++) {
                    СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
                    СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                    СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
                    СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                }
                break;

            case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки

                break;
        }
    }
    public double[][] getСoorAnchAc() {
        return this.СoorAnchAc;
    }
    public int getn() {
        return n;
    }
}
