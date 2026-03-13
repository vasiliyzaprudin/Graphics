package com.mining.graphics.service.support;

import com.mining.graphics.model.support.ModelAnchorsExcavation;

public class ServiceAnchorsExcavation extends ModelAnchorsExcavation {
    public double[][] crossSectionAnchorsXY; //массив для хранения координат анкеров в поперечном сечении

    public int numberAnchors;
    double phi;

    double stepLargeArcX;
    double stepLargeArcY;
    double stepLargeArcAnchorsX;
    double stepLargeArcAnchorsY;

    double stepSmallArcX;
    double stepSmallArcY;
    double stepSmallArcAnchorsX;
    double stepSmallArcAnchorsY;

    //Методы расчета шагов установки анкеров по различным дугам
    public double calculateStepLargeArcX(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * Math.sin(omega + j * step / largeArcRadius);
    }

    public double calculateStepLargeArcY(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * (1.0 - Math.cos(omega + j * step / largeArcRadius));
    }

    public double calculateStepLargeArcAnchorsX(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return (largeArcRadius + lengthAnch) * Math.sin(omega + j * step / largeArcRadius);
    }

    public double calculateStepLargeArcAnchorsY(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(omega + j * step / largeArcRadius);
    }

    public double calculateStepSmallArcX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian) {
        return width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian) {
        return -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcAnchorsX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcAnchorsY(int J, double Height, double ArchHeight, double SmallArcRadius, double Step, double Phi, double BetaRadian, double LengthAnch) {
        return -Height + ArchHeight - (SmallArcRadius + LengthAnch) * Math.sin(BetaRadian - Phi - J * Step / SmallArcRadius);
    }

    /**
     * Этот расчитывает и объединяет значения шагов установки анкеров по дугам.
     *
     * @param j              переменная цикла
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param archHeight     высота свода горной выработки
     * @param largeArcRadius большой радиус
     * @param smallArcRadius малый радиус
     * @param lengthAnch     длина свода
     * @param step           шаг установки анкеров в ряду
     * @param phi            опорный угол дуги равный phi = (step - remainderLargeArcRadius) / smallArcRadius
     * @param betaRadian     опорный угол дуги малого радиуса в радианах
     */
    public void calculateStep(int j, double width, double height, double archHeight, double largeArcRadius, double smallArcRadius, double lengthAnch, double step, double phi, double betaRadian, double omega) {
        stepLargeArcX = calculateStepLargeArcX(j, step, largeArcRadius, omega);
        stepLargeArcY = calculateStepLargeArcY(j, step, largeArcRadius, omega);
        stepLargeArcAnchorsX = calculateStepLargeArcAnchorsX(j, step, largeArcRadius, lengthAnch, omega);
        stepLargeArcAnchorsY = calculateStepLargeArcAnchorsY(j, step, largeArcRadius, lengthAnch, omega);
        stepSmallArcX = calculateStepSmallArcX(j, width, smallArcRadius, step, phi, betaRadian);
        stepSmallArcY = calculateStepSmallArcY(j, height, archHeight, smallArcRadius, step, phi, betaRadian);
        stepSmallArcAnchorsX = calculateStepSmallArcAnchorsX(j, width, smallArcRadius, step, phi, betaRadian, lengthAnch);
        stepSmallArcAnchorsY = calculateStepSmallArcAnchorsY(j, height, archHeight, smallArcRadius, step, phi, betaRadian, lengthAnch);
    }

    /**
     * Этот метод считает координаты анкеров в поперечном сечении горной выработки.
     *
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param formIndication коэффициент формы свода
     * @param scale          масштаб графических построений
     */
    public void calculateCrossSectionAnchors(double width, double height, double formIndication, double scale, String schemeSupport) {
        calculateParameters(width, height, formIndication, scale);

        int i;

        double remainderLargeArcRadius;
        double lengthLargeSegmentAnch;
        double lengthSmallSegmentAnch;

        final String ROOF = "ROOF";
        final String ROOF_AND_WALL = "ROOF and WALL";

        switch (schemeSupport) {
            case ROOF: //крепление кровли
                numberAnchors = (int) Math.ceil(lengthArc / step);

                crossSectionAnchorsXY = new double[numberAnchors + 1][4]; //(numberAnchors + 1) - количество анкеров в ряду

                //Определение варианта расположения анкеров
                switch ((numberAnchors + 1) % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки
                        i = 0;

                        lengthLargeSegmentAnch = largeArcLength / 2.0;

                        //расчет координат анкеров по левой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, 0.0);

                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        remainderLargeArcRadius = largeArcLength / 2.0 - step * (i - 1);
                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

                        //расчет координат анкеров по левой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, 0.0);

                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        //расчет координат анкеров по правой дуге большого радиуса
                        for (int j = 1; largeArcLength / 2.0 > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, 0.0);

                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, 0.0);

                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }
                        break;
                    case 1: // Анкер устанавливатеся со смещением на step/2.0 (половина шага анкерования) от центра кровли выработки
                        i = 0;
                        double omega = Math.asin(step / (2.0 * largeArcRadius));

                        lengthLargeSegmentAnch = largeArcLength / 2.0 - step / 2.0;

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, omega);

                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);

                        System.out.println("i = " + i);
                        System.out.println("largeArcLength / 2.0 - step / 2.0 = " + (largeArcLength / 2.0 - step / 2.0));
                        System.out.println("step * (i-1) = " + (step * (i - 1)));
                        System.out.println("remainderLargeArcRadius = " + remainderLargeArcRadius);
                        phi = (step - remainderLargeArcRadius) / smallArcRadius;

                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

                        //расчет координат анкеров по левой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, omega);

                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, omega);

                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateStep(j, width, height, archHeight, largeArcRadius, smallArcRadius, lengthAnch, step, phi, betaRadian, omega);

                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }
                        break;
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
