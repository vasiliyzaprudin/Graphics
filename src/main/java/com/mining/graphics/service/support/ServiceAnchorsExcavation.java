package com.mining.graphics.service.support;

import com.mining.graphics.model.support.AnchorsExcavation;

public class ServiceAnchorsExcavation extends AnchorsExcavation {
//    public double[][] crossSectionAnchorsXY; //массив для хранения координат анкеров в поперечном сечении
//    public double[][] longSectionAnchorsXY; //массив для хранения координат анкеров в продольном сечении
//    public double[][] basePlateXY; //массив для хранения координат опорных плит
//
//    public int numberCrossSectionAnchors;
//    public int numberLongSectionAnchors;
//    public int numberBasePlateInRow;
//    public int numberBasePlateLongSection;
//
//    double phi, delta;
//
//    double stepLargeArcX;
//    double stepLargeArcY;
//    double stepLargeArcAnchorsX;
//    double stepLargeArcAnchorsY;
//
//    double stepSmallArcX;
//    double stepSmallArcY;
//    double stepSmallArcAnchorsX;
//    double stepSmallArcAnchorsY;
//
//    double stepWallX;
//    double stepWallY;
//    double stepWallAnchorsX;
//    double stepWallAnchorsY;
//
//    int a;
//
//    //Методы расчета шага установки анкеров по дугам большого радиуса
//    public double calculateStepLargeArcX(int j, double step, double largeArcRadius, double omega) {
//        return largeArcRadius * Math.sin(omega + j * step / largeArcRadius);
//    }
//
//    public double calculateStepLargeArcY(int j, double step, double largeArcRadius, double omega) {
//        return largeArcRadius * (1.0 - Math.cos(omega + j * step / largeArcRadius));
//    }
//
//    public double calculateStepLargeArcAnchorsX(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
//        return (largeArcRadius + lengthAnch) * Math.sin(omega + j * step / largeArcRadius);
//    }
//
//    public double calculateStepLargeArcAnchorsY(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
//        return largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(omega + j * step / largeArcRadius);
//    }
//
//
//    //Методы расчета шага установки анкеров по дугам малого радиуса
//    public double calculateStepSmallArcX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian) {
//        return width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
//    }
//
//    public double calculateStepSmallArcY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian) {
//        return -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
//    }
//
//    public double calculateStepSmallArcAnchorsX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
//        return width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
//    }
//
//    public double calculateStepSmallArcAnchorsY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
//        return -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
//    }
//
//
//    //Методы расчета шага установки анкеров по боку горной выработки
//    public double calculateStepWallX(double width) {
//        return width / 2.0;
//    }
//
//    public double calculateStepWallY(int j, double height, double archHeight, double step, double delta) {
//        return -height + archHeight + delta + j * step;
//    }
//
//    public double calculateStepWallAnchorsX(double width, double lengthAnch) {
//        return width / 2.0 + lengthAnch;
//    }
//
//    public double calculateStepWallAnchorsY(int j, double height, double archHeight, double step, double delta) {
//        return -height + archHeight + delta + j * step;
//    }
//
//    /**
//     * Этот расчитывает и объединяет значения шагов установки анкеров по дуге большого радиуса.
//     *
//     * @param j              переменная цикла
//     * @param largeArcRadius большой радиус
//     * @param lengthAnch     длина свода
//     * @param step           шаг установки анкеров в ряду
//     * @param omega          начальный угол смещения координат первого анкера относительно центра свода горной выработки
//     */
//    public void calculateLargeArcStep(int j, double largeArcRadius, double lengthAnch, double step, double omega) {
//        stepLargeArcX = calculateStepLargeArcX(j, step, largeArcRadius, omega);
//        stepLargeArcY = calculateStepLargeArcY(j, step, largeArcRadius, omega);
//        stepLargeArcAnchorsX = calculateStepLargeArcAnchorsX(j, step, largeArcRadius, lengthAnch, omega);
//        stepLargeArcAnchorsY = calculateStepLargeArcAnchorsY(j, step, largeArcRadius, lengthAnch, omega);
//    }
//
//    /**
//     * Этот расчитывает и объединяет значения шагов установки анкеров по дуге малого радиуса.
//     *
//     * @param j              переменная цикла
//     * @param width          ширина горной выработки
//     * @param height         высота горной выработки
//     * @param archHeight     высота свода горной выработки
//     * @param smallArcRadius малый радиус
//     * @param lengthAnch     длина свода
//     * @param step           шаг установки анкеров в ряду
//     * @param phi            опорный угол дуги равный phi = (step - remainderLargeArcRadius) / smallArcRadius
//     * @param betaRadian     опорный угол дуги малого радиуса в радианах
//     */
//    public void calculateSmallArcStep(int j, double width, double height, double archHeight, double smallArcRadius, double lengthAnch, double step, double phi, double betaRadian) {
//        stepSmallArcX = calculateStepSmallArcX(j, width, smallArcRadius, step, phi, betaRadian);
//        stepSmallArcY = calculateStepSmallArcY(j, height, archHeight, smallArcRadius, step, phi, betaRadian);
//        stepSmallArcAnchorsX = calculateStepSmallArcAnchorsX(j, width, smallArcRadius, step, phi, betaRadian, lengthAnch);
//        stepSmallArcAnchorsY = calculateStepSmallArcAnchorsY(j, height, archHeight, smallArcRadius, step, phi, betaRadian, lengthAnch);
//    }
//
//    /**
//     * Этот расчитывает и объединяет значения шагов установки анкеров в боку горной выработки.
//     *
//     * @param j          переменная цикла
//     * @param width      ширина горной выработки
//     * @param height     высота горной выработки
//     * @param archHeight высота свода горной выработки
//     * @param lengthAnch длина свода
//     * @param step       шаг установки анкеров в ряду
//     * @param delta      delta = step - remainderSmallArcRadius
//     */
//    public void calculateWallStep(int j, double width, double height, double archHeight, double lengthAnch, double step, double delta) {
//        stepWallX = calculateStepWallX(width);
//        stepWallY = calculateStepWallY(j, height, archHeight, step, delta);
//        stepWallAnchorsX = calculateStepWallAnchorsX(width, lengthAnch);
//        stepWallAnchorsY = calculateStepWallAnchorsY(j, height, archHeight, step, delta);
//    }
//
//    /**
//     * Этот метод считает координаты анкеров в поперечном сечении горной выработки.
//     *
//     * @param width          ширина горной выработки
//     * @param height         высота горной выработки
//     * @param formIndication коэффициент формы свода
//     * @param scale          масштаб графических построений
//     */
//    public void calculateCrossSectionAnchors(double width, double height, double formIndication, double scale, String schemeSupport) {
//        calculateParametersExcavation(width, height, formIndication, scale);
//
//        int i;
//
//        double remainderLargeArcRadius;
//        double remainderSmallArcRadius;
//
//        double lengthLargeSegmentAnch;
//        double lengthSmallSegmentAnch;
//        double lengthWallSegmentAnch;
//
//        final String ROOF = "ROOF";
//        final String ROOF_AND_WALL = "ROOF and WALL";
//
//        switch (schemeSupport) {
//            case ROOF: //крепление кровли
//                numberCrossSectionAnchors = (int) Math.ceil(lengthArc / step);
//
//                crossSectionAnchorsXY = new double[numberCrossSectionAnchors + 1][4]; //(numberCrossSectionAnchors + 1) - количество анкеров в ряду
//
//                //Определение варианта расположения анкеров
//                switch ((numberCrossSectionAnchors + 1) % 2) {
//
//                    case 0: //Анкер устанавливается по центру кровли выработки
//                        i = 0;
//
//                        lengthLargeSegmentAnch = largeArcLength / 2.0;
//
//                        //расчет координат анкеров по левой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
//                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        remainderLargeArcRadius = largeArcLength / 2.0 - step * (i - 1);
//                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
//                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;
//
//                        //расчет координат анкеров по левой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//
//                        //расчет координат анкеров по правой дуге большого радиуса
//                        for (int j = 1; largeArcLength / 2.0 > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
//                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        //определение координат анкеров по правой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//                        break;
//                    case 1: // Анкер устанавливатеся со смещением на step/2.0 (половина шага анкерования) от центра кровли выработки
//                        i = 0;
//                        double omega = Math.asin(step / (2.0 * largeArcRadius));
//
//                        lengthLargeSegmentAnch = largeArcLength / 2.0 - step / 2.0;
//
//                        //определение координат установки анкеров по левой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
//                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);
//                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
//                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;
//
//                        //расчет координат анкеров по левой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
//                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//                        break;
//                }
//                break;
//            case ROOF_AND_WALL: //крепление кровли и боков
//                numberCrossSectionAnchors = (int) Math.ceil((lengthArc + (height - archHeight - distanceLowerAnchor) * 2.0) / step);
//
//                crossSectionAnchorsXY = new double[numberCrossSectionAnchors + 1][4]; //(numberCrossSectionAnchors + 1) - количество анкеров в ряду
//
//                //Определение варианта расположения анкеров
//                switch ((numberCrossSectionAnchors + 1) % 2) {
//                    case 0: //Анкер устанавливается по центру кровли выработки
//                        i = 0;
//
//                        lengthLargeSegmentAnch = largeArcLength / 2.0;
//
//                        //расчет координат анкеров по левой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
//                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        remainderLargeArcRadius = largeArcLength / 2.0 - step * (i - 1);
//                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
//                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;
//
//                        //расчет координат анкеров по левой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//
//                        remainderSmallArcRadius = largeArcLength / 2.0 + smallArcLength - step * (i - 1);
//                        delta = step - remainderSmallArcRadius;
//                        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);
//
//                        //определение координат установки анкеров в левом боку
//                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
//                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
//                            crossSectionAnchorsXY[i][0] = -stepWallX;
//                            crossSectionAnchorsXY[i][1] = stepWallY;
//                            crossSectionAnchorsXY[i][2] = -stepWallAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
//                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//
//                        //определение координат установки анкеров в правом боку
//                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
//                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
//                            crossSectionAnchorsXY[i][0] = stepWallX;
//                            crossSectionAnchorsXY[i][1] = stepWallY;
//                            crossSectionAnchorsXY[i][2] = stepWallAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
//                        }
//                        break;
//
//                    case 1: // Анкер устанавливатеся со смещением на step/2.0 (половина шага анкерования) от центра кровли выработки
//                        i = 0;
//                        double omega = Math.asin(step / (2.0 * largeArcRadius));
//
//                        lengthLargeSegmentAnch = largeArcLength / 2.0 - step / 2.0;
//
//                        //определение координат установки анкеров по левой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
//                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);
//                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
//                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;
//
//                        //расчет координат анкеров по левой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//
//                        remainderSmallArcRadius = (largeArcLength / 2.0 + smallArcLength) - step / 2.0 - step * (i - 1);
//                        delta = step - remainderSmallArcRadius;
//                        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);
//
//                        //определение координат установки анкеров в левом боку
//                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
//                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
//                            crossSectionAnchorsXY[i][0] = -stepWallX;
//                            crossSectionAnchorsXY[i][1] = stepWallY;
//                            crossSectionAnchorsXY[i][2] = -stepWallAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге большого радиуса
//                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
//                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
//                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
//                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
//                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
//                        }
//
//                        //определение координат установки анкеров по правой дуге малого радиуса
//                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
//                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
//                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
//                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
//                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
//                        }
//                        //определение координат установки анкеров в правом боку
//                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
//                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
//                            crossSectionAnchorsXY[i][0] = stepWallX;
//                            crossSectionAnchorsXY[i][1] = stepWallY;
//                            crossSectionAnchorsXY[i][2] = stepWallAnchorsX;
//                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
//                        }
//                        break;
//                }
//        }
//    }
//
//    /**
//     * Этот метод считает координаты анкеров в продольном сечении горной выработки.
//     *
//     * @param length              длина горной выработки
//     * @param distanceBetweenRows расстояние между рядами анкеров
//     */
//    public void calculateLongSectionAnchors(double height, double length, double distanceBetweenRows) {
//        numberLongSectionAnchors = (int) Math.floor(length / (2 * distanceBetweenRows)) * 2 + 1;
//        longSectionAnchorsXY = new double[numberLongSectionAnchors + 1][4]; //(numberLongSectionAnchors + 1) - количество анкеров в ряду
//        int i = 0;
//
//        for (int j = 0; length / 2.0 > j * distanceBetweenRows; j++, i++) {
//            longSectionAnchorsXY[i][0] = length / 2.0 - distanceBetweenRows * j;
//            longSectionAnchorsXY[i][1] = -height;
//            longSectionAnchorsXY[i][2] = length / 2.0 - distanceBetweenRows * j;
//            longSectionAnchorsXY[i][3] = crossSectionAnchorsXY[0][3];
//        }
//        for (int j = 1; length / 2.0 > j * distanceBetweenRows; j++, i++) {
//            longSectionAnchorsXY[i][0] = length / 2.0 + distanceBetweenRows * j;
//            longSectionAnchorsXY[i][1] = -height;
//            longSectionAnchorsXY[i][2] = length / 2.0 + distanceBetweenRows * j;
//            longSectionAnchorsXY[i][3] = crossSectionAnchorsXY[0][3];
//        }
//    }
//
//    /**
//     * Этот метод считает координаты опорных плит в продольном сечении горной выработки.
//     *
//     * @param plateSize размер опорной плиты
//     */
//    public void calculateBasePlate(double plateSize) {
//        a = 0;
//        if (numberCrossSectionAnchors % 2 == 0) {
//            numberBasePlateInRow = numberCrossSectionAnchors / 2;
//        } else {
//            numberBasePlateInRow = (int) (Math.floor(numberCrossSectionAnchors / 2.0));
//        }
//        numberBasePlateLongSection = numberBasePlateInRow * numberLongSectionAnchors;
//
//        basePlateXY = new double[numberBasePlateLongSection][2]; //numberBasePlateLongSection - количество опорных плит для отображения в продольном разрезе
//
//        for (int k = 1; k <= numberLongSectionAnchors; k++) {
//            for (int j = 1; j <= numberBasePlateInRow; j++, a++) {
//                basePlateXY[a][0] = longSectionAnchorsXY[k - 1][0] - plateSize / 2.0;
//                basePlateXY[a][1] = crossSectionAnchorsXY[j][1] - plateSize / 2.0;
//            }
//        }
//    }
}