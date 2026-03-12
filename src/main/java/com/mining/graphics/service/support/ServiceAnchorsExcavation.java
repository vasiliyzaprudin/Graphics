package com.mining.graphics.service.support;

import com.mining.graphics.model.support.ModelAnchorsExcavation;

public class ServiceAnchorsExcavation extends ModelAnchorsExcavation {
    public double[][] crossSectionAnchorsXY; //массив для хранения координат анкеров в поперечном сечении

    public int numberAnchors;

    public ServiceAnchorsExcavation() {
        calculateCrossSectionAnchors(width, height, formIndication, GRAPHICS_SCALE);
    }

    /**
     * Этот метод считает координаты анкеров в поперечном сечении горной выработки.
     *
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param formIndication коэффициент формы свода
     * @param scale          масштаб графических построений
     */

    public void calculateCrossSectionAnchors(double width, double height, double formIndication, double scale) {
        calculateParameters(width, height, formIndication, scale);
        int i = 0;

        final String ROOF = "ROOF";
        final String ROOF_AND_WALL = "ROOF and WALL";

        String attachmentType = ROOF;

        switch (attachmentType) {
            case ROOF: //крепление кровли
                numberAnchors = (int) Math.ceil(lengthArc / step);

                crossSectionAnchorsXY = new double[numberAnchors + 1][4]; //(numberAnchors + 1) - количество анкеров в ряду

                //Определение варианта расположения анкеров
                switch (numberAnchors % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки

                        //расчет координат установки анкеров по левой дуге большого радиуса
                        for (int j = 0; largeArcLength / 2.0 > j * step; j++, i++) {
                            crossSectionAnchorsXY[i][0] = -largeArcRadius * Math.sin(j * step / largeArcRadius);
                            crossSectionAnchorsXY[i][1] = -height + largeArcRadius * (1.0 - Math.cos(j * step / largeArcRadius));
                            crossSectionAnchorsXY[i][2] = -(largeArcRadius + lengthAnch) * Math.sin(j * step / largeArcRadius);
                            crossSectionAnchorsXY[i][3] = -height + largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(j * step / largeArcRadius);
                        }

                        double remainderLargeArcRadius = largeArcLength / 2.0 - step * (i - 1);

                        double phi = (step - remainderLargeArcRadius) / smallArcRadius;

                        //расчет координат установки анкеров по левой дуге малого радиуса
                        for (int j = 0; smallArcLength + remainderLargeArcRadius - step > j * step; j++, i++) {
                            crossSectionAnchorsXY[i][0] = -width / 2.0 + smallArcRadius - smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][1] = -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][2] = -width / 2.0 + smallArcRadius - (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][3] = -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
                        }

                        //расчет координат установки анкеров по правой дуге большого радиуса
                        for (int j = 1; largeArcLength / 2.0 > j * step; j++, i++) {
                            crossSectionAnchorsXY[i][0] = largeArcRadius * Math.sin(j * step / largeArcRadius);
                            crossSectionAnchorsXY[i][1] = -height + largeArcRadius * (1.0 - Math.cos(j * step / largeArcRadius));
                            crossSectionAnchorsXY[i][2] = (largeArcRadius + lengthAnch) * Math.sin(j * step / largeArcRadius);
                            crossSectionAnchorsXY[i][3] = -height + largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(j * step / largeArcRadius);
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (int j = 0; smallArcLength + remainderLargeArcRadius - step > j * step; j++, i++) {
                            crossSectionAnchorsXY[i][0] = width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][1] = -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][2] = width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
                            crossSectionAnchorsXY[i][3] = -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
                        }
                        break;
//                    case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки
//
//                        //определение координат установки анкеров по левой дуге большого радиуса
//                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
//                        }
//
//                        phi0 = (bAc / 2 + i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
//                        которая является продолжением остатка дуги большого радиуса Lrem.
//                        Их сумма равна шагу анкерования Lrem + lbeg = b */
//                        //double Lrem = R * alpha - bAc * (i - 1);
//                        lbeg0 = r * phi0;
//
//                        //определение координат установки анкеров по левой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (j = 0; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//                        break;
//                }
//                break;
//            case 1: //крепление кровли и боков
//                n = (int) Math.floor((LroofAc + (H - hr - p) * 2) / bAc);
//
//                СoorAnchAc = new double[n + 1][4]; //(n+1) - количество анкеров в ряду
//
//                //Определение варианта расположения анкеров
//                switch (n % 2) {
//                    case 0: //Анкер устанавливается по центру кровли выработки
//
//                        //определение координат установки анкеров по левой дуге большого радиуса
//                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
//                        }
//
//                        phi0 = (i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
//                        которая является продолжением остатка дуги большого радиуса Lrem.
//                        Их сумма равна шагу анкерования Lrem + lbeg = b */
//                        //double Lrem = R * alpha - bAc * (i - 1);
//                        lbeg0 = r * phi0;
//
//                        //определение координат установки анкеров по левой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//
//                        //определение координат установки анкеров в левом боку
//                        lbeg1 = LroofAc / 2 - bAc * Math.floor((LroofAc / (2 * bAc)));
//
//                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = 0;
//                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
//                            СoorAnchAc[i][2] = -l;
//                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (j = 1; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(j * bAc / R)) - l;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//
//                        //определение координат установки анкеров в правом боку
//                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B;
//                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
//                            СoorAnchAc[i][2] = B + l;
//                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
//                        }
//                        break;
//
//                    case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки
//
//                        //определение координат установки анкеров по левой дуге большого радиуса
//                        for (i = 0, j = 0; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 - R * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 - (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
//                        }
//
//                        phi0 = (bAc / 2 + i * bAc - R * alpha) / r; /* phi0 - опорный угол дуги малого радиуса lbeg,
//                        которая является продолжением остатка дуги большого радиуса Lrem.
//                        Их сумма равна шагу анкерования Lrem + lbeg = b */
//                        //double Lrem = R * alpha - bAc * (i - 1);
//                        lbeg0 = r * phi0;
//
//                        //определение координат установки анкеров по левой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = r * (1.0 - Math.cos(beta - phi0 - j * bAc / r)) - l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//
//                        //определение координат установки анкеров в левом боку
//                        lbeg1 = (LroofAc / 2 - bAc / 2) - bAc * Math.floor((LroofAc / 2 - bAc / 2) / bAc);
//
//                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = 0;
//                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
//                            СoorAnchAc[i][2] = -l;
//                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (j = 0; Rl / 2.0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B / 2.0 + R * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][1] = R * (1 - Math.cos(bAc / (2 * R) + j * bAc / R));
//                            СoorAnchAc[i][2] = B / 2.0 + (R + l) * Math.sin(bAc / (2 * R) + j * bAc / R);
//                            СoorAnchAc[i][3] = (R + l) * (1 - Math.cos(bAc / (2 * R) + j * bAc / R)) - l;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (j = 0; rl - lbeg0 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B - r + r * Math.cos(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][1] = hr - r * Math.sin(beta - phi0 - j * bAc / r);
//                            СoorAnchAc[i][2] = B - r + r * Math.cos(beta - phi0 - j * bAc / r) + l * (Math.cos(beta - phi0 - j * bAc / r));
//                            СoorAnchAc[i][3] = hr - r * Math.sin(beta - phi0 - j * bAc / r) - l * (Math.sin(beta - phi0 - j * bAc / r));
//                        }
//
//                        //определение координат установки анкеров в правом боку
//                        for (j = 1; H - hr - p + lbeg1 > j * bAc; j++, i++) {
//                            СoorAnchAc[i][0] = B;
//                            СoorAnchAc[i][1] = hr - lbeg1 + j * bAc;
//                            СoorAnchAc[i][2] = B + l;
//                            СoorAnchAc[i][3] = hr - lbeg1 + j * bAc;
//                        }
//                        break;
                }
        }
    }
}
