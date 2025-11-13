package com.mining.graphics.service;

import com.mining.graphics.support.ModelAnchors;

public class ServiceAnchors extends ModelAnchors {
    public double[][] СoorAnchAc; //массив для хранения координат установки анкеров в поперечном сечении
    public int n;
    double phi0, phi1, lbeg0, lbeg1;

    public ServiceAnchors() {
        CalculateCoordinatesAnchorsAc();
    }

    public void CalculateCoordinatesAnchorsAc() {
        int i, j;

        int v = 1;
        switch (v) {
            case 0: //крепление кровли
                n = (int) Math.floor(LroofAc / bAc);

                СoorAnchAc = new double[n + 1][4]; //(n+1) - количество анкеров в ряду

                //Определение варианта расположения анкеров
                switch (n % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                        }

                        phi0 = (i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
                        которая является продолжением остатка дуги большого радиуса Lrem.
                        Их сумма равна шагу анкерования Lrem + lbeg = b */
                        //double Lrem = R * alpha - bAc * (i - 1);
                        lbeg0 = r * phi0;

                        //определение координат установки анкеров по левой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (j = 1; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                        }

                        //цопределение координат установки анкеров по правой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }
                        break;
                    case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
                        }

                        phi0 = (bAc / 2 + i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
                        которая является продолжением остатка дуги большого радиуса Lrem.
                        Их сумма равна шагу анкерования Lrem + lbeg = b */
                        //double Lrem = R * alpha - bAc * (i - 1);
                        lbeg0 = r * phi0;

                        //определение координат установки анкеров по левой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }
                        break;
                }
                break;
            case 1: //крепление кровли и боков
                n = (int) Math.floor((LroofAc + (H - hr - p) * 2) / bAc);

                СoorAnchAc = new double[n + 1][4]; //(n+1) - количество анкеров в ряду

                //Определение варианта расположения анкеров
                switch (n % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                        }

                        phi0 = (i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
                        которая является продолжением остатка дуги большого радиуса Lrem.
                        Их сумма равна шагу анкерования Lrem + lbeg = b */
                        //double Lrem = R * alpha - bAc * (i - 1);
                        lbeg0 = r * phi0;

                        //определение координат установки анкеров по левой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров в левом боку
                        lbeg1 = LroofAc / 2 - bAc * Math.floor((LroofAc / (2 * bAc)));

                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = 0;
                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
                            СoorAnchAc[i][2] = -l;
                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (j = 1; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров в правом боку
                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B;
                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
                            СoorAnchAc[i][2] = B + l;
                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
                        }
                        break;

                    case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
                        }

                        phi0 = (bAc / 2 + i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
                        которая является продолжением остатка дуги большого радиуса Lrem.
                        Их сумма равна шагу анкерования Lrem + lbeg = b */
                        //double Lrem = R * alpha - bAc * (i - 1);
                        lbeg0 = r * phi0;

                        //определение координат установки анкеров по левой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров в левом боку
                        lbeg1 = (LroofAc / 2 - bAc / 2) - bAc * Math.floor((LroofAc / 2 - bAc / 2) / bAc);

                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = 0;
                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
                            СoorAnchAc[i][2] = -l;
                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (j = 0; Rl / 2.0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
                        }

                        //определение координат установки анкеров в правом боку
                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
                            СoorAnchAc[i][0] = B;
                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
                            СoorAnchAc[i][2] = B + l;
                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
                        }
                        break;
                }
        }
    }
}
