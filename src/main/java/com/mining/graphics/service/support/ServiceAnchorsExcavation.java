package com.mining.graphics.service.support;

import com.mining.graphics.model.support.ModelAnchorsExcavation;

public class ServiceAnchorsExcavation extends ModelAnchorsExcavation {
    public double[][] crossSectionAnchorsXY; //массив для хранения координат анкеров в поперечном сечении

    public int numberAnchors;
    double phi, delta;

    double stepLargeArcX;
    double stepLargeArcY;
    double stepLargeArcAnchorsX;
    double stepLargeArcAnchorsY;

    double stepSmallArcX;
    double stepSmallArcY;
    double stepSmallArcAnchorsX;
    double stepSmallArcAnchorsY;

    double stepWallX;
    double stepWallY;
    double stepWallAnchorsX;
    double stepWallAnchorsY;

    //Методы расчета шагов установки анкеров по дугам большого радиуса
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



    //Методы расчета шагов установки анкеров по дугам малого радиуса
    public double calculateStepSmallArcX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian) {
        return width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }
    public double calculateStepSmallArcY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian) {
        return -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }
    public double calculateStepSmallArcAnchorsX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }
    public double calculateStepSmallArcAnchorsY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }



    //Методы расчета шагов установки анкеров по боку горной выработки
    public double calculateStepWallX(double width) {
        return width / 2.0;
    }
    public double calculateStepWallY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }
    public double calculateStepWallAnchorsX(double width, double lengthAnch) {
        return width / 2.0 + lengthAnch;
    }
    public double calculateStepWallAnchorsY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }

    /**
     * Этот расчитывает и объединяет значения шагов установки анкеров по дуге большого радиуса.
     *
     * @param j              переменная цикла
     * @param largeArcRadius большой радиус
     * @param lengthAnch     длина свода
     * @param step           шаг установки анкеров в ряду
     * @param omega          начальный угол смещения координат первого анкера относительно центра свода горной выработки
     */
    public void calculateLargeArcStep(int j, double largeArcRadius, double lengthAnch, double step, double omega) {
        stepLargeArcX = calculateStepLargeArcX(j, step, largeArcRadius, omega);
        stepLargeArcY = calculateStepLargeArcY(j, step, largeArcRadius, omega);
        stepLargeArcAnchorsX = calculateStepLargeArcAnchorsX(j, step, largeArcRadius, lengthAnch, omega);
        stepLargeArcAnchorsY = calculateStepLargeArcAnchorsY(j, step, largeArcRadius, lengthAnch, omega);
    }

    /**
     * Этот расчитывает и объединяет значения шагов установки анкеров по дуге малого радиуса.
     *
     * @param j              переменная цикла
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param archHeight     высота свода горной выработки
     * @param smallArcRadius малый радиус
     * @param lengthAnch     длина свода
     * @param step           шаг установки анкеров в ряду
     * @param phi            опорный угол дуги равный phi = (step - remainderLargeArcRadius) / smallArcRadius
     * @param betaRadian     опорный угол дуги малого радиуса в радианах
     */
    public void calculateSmallArcStep(int j, double width, double height, double archHeight, double smallArcRadius, double lengthAnch, double step, double phi, double betaRadian) {
        stepSmallArcX = calculateStepSmallArcX(j, width, smallArcRadius, step, phi, betaRadian);
        stepSmallArcY = calculateStepSmallArcY(j, height, archHeight, smallArcRadius, step, phi, betaRadian);
        stepSmallArcAnchorsX = calculateStepSmallArcAnchorsX(j, width, smallArcRadius, step, phi, betaRadian, lengthAnch);
        stepSmallArcAnchorsY = calculateStepSmallArcAnchorsY(j, height, archHeight, smallArcRadius, step, phi, betaRadian, lengthAnch);
    }

    /**
     * Этот расчитывает и объединяет значения шагов установки анкеров в боку горной выработки.
     *
     * @param j          переменная цикла
     * @param width      ширина горной выработки
     * @param height     высота горной выработки
     * @param archHeight высота свода горной выработки
     * @param lengthAnch длина свода
     * @param step       шаг установки анкеров в ряду
     * @param delta      delta = step - remainderSmallArcRadius
     */
    public void calculateWallStep(int j, double width, double height, double archHeight, double lengthAnch, double step, double delta) {
        stepWallX = calculateStepWallX(width);
        stepWallY = calculateStepWallY(j, height, archHeight, step, delta);
        stepWallAnchorsX = calculateStepWallAnchorsX(width, lengthAnch);
        stepWallAnchorsY = calculateStepWallAnchorsY(j, height, archHeight, step, delta);
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
        double remainderSmallArcRadius;

        double lengthLargeSegmentAnch;
        double lengthSmallSegmentAnch;
        double lengthWallSegmentAnch;

        final String ROOF = "ROOF";
        final String ROOF_AND_WALL = "ROOF and WALL";

        schemeSupport = ROOF;

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
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
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
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        //расчет координат анкеров по правой дуге большого радиуса
                        for (int j = 1; largeArcLength / 2.0 > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
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
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);
                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

                        //расчет координат анкеров по левой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }
                        break;
                }
                break;
            case ROOF_AND_WALL: //крепление кровли и боков
                numberAnchors = (int) Math.ceil((lengthArc + (height - archHeight - distanceLowerAnchor) * 2.0) / step);

                crossSectionAnchorsXY = new double[20][4]; //(numberAnchors + 1) - количество анкеров в ряду

                //Определение варианта расположения анкеров
                switch ((numberAnchors + 1) % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки
                        i = 0;

                        lengthLargeSegmentAnch = largeArcLength / 2.0;

                        //расчет координат анкеров по левой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
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
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        remainderSmallArcRadius = largeArcLength / 2.0 + smallArcLength - step * (i - 1);
                        delta = step - remainderSmallArcRadius;
                        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);

                        //определение координат установки анкеров в левом боку
                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
                            crossSectionAnchorsXY[i][0] = -stepWallX;
                            crossSectionAnchorsXY[i][1] = stepWallY;
                            crossSectionAnchorsXY[i][2] = -stepWallAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, 0.0);
                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        //определение координат установки анкеров в правом боку
                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
                            crossSectionAnchorsXY[i][0] = stepWallX;
                            crossSectionAnchorsXY[i][1] = stepWallY;
                            crossSectionAnchorsXY[i][2] = stepWallAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
                        }
                        break;

                    case 1: // Анкер устанавливатеся со смещением на step/2.0 (половина шага анкерования) от центра кровли выработки
                        i = 0;
                        double omega = Math.asin(step / (2.0 * largeArcRadius));

                        lengthLargeSegmentAnch = largeArcLength / 2.0 - step / 2.0;

                        //определение координат установки анкеров по левой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
                            crossSectionAnchorsXY[i][0] = -stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = -stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        remainderLargeArcRadius = largeArcLength / 2.0 - step / 2.0 - step * (i - 1);
                        phi = (step - remainderLargeArcRadius) / smallArcRadius;
                        lengthSmallSegmentAnch = smallArcLength + remainderLargeArcRadius - step;

                        //расчет координат анкеров по левой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = -stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = -stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }

                        remainderSmallArcRadius = (largeArcLength / 2.0 + smallArcLength) - step / 2.0 - step * (i - 1);
                        delta = step - remainderSmallArcRadius;
                        lengthWallSegmentAnch = remainderSmallArcRadius + (height - archHeight - distanceLowerAnchor);

                        //определение координат установки анкеров в левом боку
                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
                            crossSectionAnchorsXY[i][0] = -stepWallX;
                            crossSectionAnchorsXY[i][1] = stepWallY;
                            crossSectionAnchorsXY[i][2] = -stepWallAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге большого радиуса
                        for (int j = 0; lengthLargeSegmentAnch > j * step; j++, i++) {
                            calculateLargeArcStep(j, largeArcRadius, lengthAnch, step, omega);
                            crossSectionAnchorsXY[i][0] = stepLargeArcX;
                            crossSectionAnchorsXY[i][1] = -height + stepLargeArcY;
                            crossSectionAnchorsXY[i][2] = stepLargeArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = -height + stepLargeArcAnchorsY;
                        }

                        //определение координат установки анкеров по правой дуге малого радиуса
                        for (int j = 0; lengthSmallSegmentAnch > j * step; j++, i++) {
                            calculateSmallArcStep(j, width, height, archHeight, smallArcRadius, lengthAnch, step, phi, betaRadian);
                            crossSectionAnchorsXY[i][0] = stepSmallArcX;
                            crossSectionAnchorsXY[i][1] = stepSmallArcY;
                            crossSectionAnchorsXY[i][2] = stepSmallArcAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepSmallArcAnchorsY;
                        }
                        //определение координат установки анкеров в правом боку
                        for (int j = 0; lengthWallSegmentAnch - step > j * step; j++, i++) {
                            calculateWallStep(j, width, height, archHeight, lengthAnch, step, delta);
                            crossSectionAnchorsXY[i][0] = stepWallX;
                            crossSectionAnchorsXY[i][1] = stepWallY;
                            crossSectionAnchorsXY[i][2] = stepWallAnchorsX;
                            crossSectionAnchorsXY[i][3] = stepWallAnchorsY;
                        }
                        break;
                }
        }
    }
}
