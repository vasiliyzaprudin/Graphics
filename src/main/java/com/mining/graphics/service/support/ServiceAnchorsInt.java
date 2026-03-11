package com.mining.graphics.service.support;

import com.mining.graphics.model.support.ModelAnchorsInt;

public class ServiceAnchorsInt extends ModelAnchorsInt {
    public double GAMMA, L, CAL;

    public double[][] СoorAncIntPlanRound; //массив для хранения координат анкеров в плане на закруглении сопряжения
    public double[][] СoorAncIntPlanLine; //массив для хранения координат недостающих анкеров в плане в боку горной выработки
    public double[][] СoorAncIntProj; //массив для хранения координат установки анкеров в проекции сопряжения
    public double[][] СoorTestX0Y0; //координаты перпендикуляров к осям выработок

    public double[][] CoorLine; //для демонстрации работы с массиом
    public int numAnchPlanRound, numAnchTest, numAnchProj, numAnchPlanLine;

    public double X0line, Y0line;

    //Расстояние между точками
    public static double distanceBetweenPoint(double X1, double Y1, double X2, double Y2) {
        return Math.sqrt((X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1));
    }

    //Расчет BETA
    public static double calculateBETA(double XB, double YB) {
        return Math.atan2(YB, XB);
    }

    //Расчет ALPHA
    public static double calculateALPHA(double Y1, double X1) {
        return Math.atan2(Y1, X1);
    }

    public static double calculatePHI(double X1, double Y1, double X2, double Y2, double XB, double YB) {
        return Math.atan2(Y2 - Y1, X2 - X1) - calculateBETA(XB, YB);
    }

    //Расчет угла между отрезками через координаты вершин
    public static double angleBetweenLines(double X1, double Y1, double X2, double Y2, double X3, double Y3, double X4, double Y4) {
        return Math.acos(((X2 - X1) * (X4 - X3) + (Y2 - Y1) * (Y4 - Y3)) / ((Math.sqrt((X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1))) * (Math.sqrt((X4 - X3) * (X4 - X3) + (Y4 - Y3) * (Y4 - Y3)))));
    }

    //Расчет X0
    public static double calculateX0(double X1, double Y1, double X2, double Y2, double XB, double YB, double CAL, double ALPHARAD) {
        if (ALPHARAD >= Math.PI / 4.0) {
            double PROJECTION = Math.abs(distanceBetweenPoint(X1, Y1, 0, 0) * Math.abs(Math.cos(angleBetweenLines(X1, Y1, 0.0, 0.0, 0.0, 0.0, XB, YB))));
            double DELTA = Math.ceil(PROJECTION / CAL) * CAL - PROJECTION;
            return X1 + (DELTA / Math.cos(calculatePHI(X1, Y1, X2, Y2, XB, YB))) * Math.cos(calculateBETA(XB, YB) + calculatePHI(X1, Y1, X2, Y2, XB, YB));
        } else {
            double PROJECTION = Math.abs(distanceBetweenPoint(X1, Y1, 0, 0) * (Math.cos(angleBetweenLines(X1, Y1, 0.0, 0.0, 0.0, 0.0, XB, YB))));
            double DELTA = Math.ceil(PROJECTION / CAL) * CAL - PROJECTION;
            return X1 + (DELTA / Math.cos(calculatePHI(X2, Y2, X1, Y1, XB, YB))) * Math.cos(calculateBETA(XB, YB) + calculatePHI(X2, Y2, X1, Y1, XB, YB));
        }
    }

    //Расчет Y0
    public static double calculateY0(double X1, double Y1, double X2, double Y2, double XB, double YB, double CAL, double ALPHARAD) {
        if (ALPHARAD >= Math.PI / 4) {
            double PROJECTION = Math.abs(distanceBetweenPoint(X1, Y1, 0, 0) * Math.abs(Math.cos(angleBetweenLines(X1, Y1, 0.0, 0.0, 0.0, 0.0, XB, YB))));
            double DELTA = Math.ceil(PROJECTION / CAL) * CAL - PROJECTION;
            return Y1 + (DELTA / Math.cos(calculatePHI(X1, Y1, X2, Y2, XB, YB))) * Math.sin(calculateBETA(XB, YB) + calculatePHI(X1, Y1, X2, Y2, XB, YB));
        } else {
            double PROJECTION = Math.abs(distanceBetweenPoint(X1, Y1, 0, 0) * (Math.cos(angleBetweenLines(X1, Y1, 0.0, 0.0, 0.0, 0.0, XB, YB))));
            double DELTA = Math.ceil(PROJECTION / CAL) * CAL - PROJECTION;
            return Y1 + (DELTA / Math.cos(calculatePHI(X1, Y1, X2, Y2, XB, YB))) * Math.sin(calculateBETA(XB, YB) + calculatePHI(X1, Y1, X2, Y2, XB, YB));
        }
    }

    /**
     * Это метод расчета координат установки анкеров в плане сопряжения на закруглении.
     */
    public void calcCoordAnchPlanInt(double X1, double Y1, double X2, double Y2, double cAl, double l, double bAc, double LroofAc, double XB, double YB, double ALPHARAD) {
        //Расчет угла между осью выработки и отрезком закругления
        double PHI = angleBetweenLines(X1, Y1, X2, Y2, 0.0, 0.0, XB, YB);

        //Коорндинаты точки установки первого анкера на отрезке закругления
        double X0 = calculateX0(X1, Y1, X2, Y2, XB, YB, cAl, ALPHARAD);
        double Y0 = calculateY0(X1, Y1, X2, Y2, XB, YB, cAl, ALPHARAD);

        CAL = cAl / Math.cos(PHI);

        if (ALPHARAD >= Math.PI / 4) L = l;
        else L = -l;

        GAMMA = Math.atan2(Y2 - Y1, X2 - X1);

        numAnchPlanRound = (int) (distanceBetweenPoint(X0, Y0, X2, Y2) / Math.abs(CAL));
        СoorAncIntPlanRound = new double[numAnchPlanRound + 1][4]; //n + 1 - количество анкеров
        if (Y1 >= 0) {
            if (X1 + X2 >= 0) {
                for (int i = 0, j = 0; distanceBetweenPoint(X0, Y0, X2, Y2) >= j * Math.abs(CAL); j++, i++) {
                    СoorAncIntPlanRound[i][0] = X0 + j * CAL * Math.cos(GAMMA);
                    СoorAncIntPlanRound[i][1] = Y0 + j * CAL * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][2] = X0 + j * CAL * Math.cos(GAMMA) - L * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][3] = Y0 + j * CAL * Math.sin(GAMMA) + L * Math.cos(GAMMA);
                }
            } else {
                for (int i = 0, j = 0; distanceBetweenPoint(X0, Y0, X2, Y2) >= j * Math.abs(CAL); j++, i++) {
                    СoorAncIntPlanRound[i][0] = X0 + j * CAL * Math.cos(GAMMA);
                    СoorAncIntPlanRound[i][1] = Y0 + j * CAL * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][2] = X0 + j * CAL * Math.cos(GAMMA) + L * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][3] = Y0 + j * CAL * Math.sin(GAMMA) - L * Math.cos(GAMMA);
                }
            }
        } else {
            if (X1 + X2 >= 0) {
                for (int i = 0, j = 0; distanceBetweenPoint(X0, Y0, X2, Y2) >= j * Math.abs(CAL); j++, i++) {
                    СoorAncIntPlanRound[i][0] = X0 + j * CAL * Math.cos(GAMMA);
                    СoorAncIntPlanRound[i][1] = Y0 + j * CAL * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][2] = X0 + j * CAL * Math.cos(GAMMA) + L * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][3] = Y0 + j * CAL * Math.sin(GAMMA) - L * Math.cos(GAMMA);
                }
            } else {
                for (int i = 0, j = 0; distanceBetweenPoint(X0, Y0, X2, Y2) >= j * Math.abs(CAL); j++, i++) {
                    СoorAncIntPlanRound[i][0] = X0 + j * CAL * Math.cos(GAMMA);
                    СoorAncIntPlanRound[i][1] = Y0 + j * CAL * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][2] = X0 + j * CAL * Math.cos(GAMMA) - L * Math.sin(GAMMA);
                    СoorAncIntPlanRound[i][3] = Y0 + j * CAL * Math.sin(GAMMA) + L * Math.cos(GAMMA);
                }
            }
        }
    }

    /**
     * Это метод рассчета количества и координат установки дополнительных анкеров
     * в плане по боку горной выработки.
     */
    public void calcCoordAnchPlanIntSide(double X1, double Y1, double X2, double Y2, double X3, double Y3, double X4, double Y4, double CAL, double L, double ALPHA) {
        double XExtrAnch = СoorAncIntPlanRound[numAnchPlanRound][0];
        double YExtrAnch = СoorAncIntPlanRound[numAnchPlanRound][1];

        double LengthExtrRound = distanceBetweenPoint(X1, Y1, XExtrAnch, YExtrAnch); //остаток отрезка закругления
        double LengthSide = distanceBetweenPoint(X2, Y2, X1, Y1) - distanceBetweenPoint(X4, Y4, X3, Y3); //прямой отрезок для установки анкеров
        numAnchPlanLine = (int) (Math.ceil(LengthExtrRound + LengthSide) / CAL);

        if (numAnchPlanLine >= 0) {
            СoorAncIntPlanLine = new double[numAnchPlanLine + 1][4]; //numAnchPlanLine + 1 - количество анкеров

            double Beta = Math.atan2(Y2 - Y1, X2 - X1);

            double CoordXFirstAnch = X1 + (CAL - LengthExtrRound) * Math.cos(Beta);
            double CoordYFirstAnch = Y1 + (CAL - LengthExtrRound) * Math.sin(Beta);

            //Условия ориентации анкеров для разных горных выработок
            if (-Math.PI / 4 <= ALPHA && ALPHA <= Math.PI / 4 && X1 > X3 ||
                    Math.PI / 4 <= ALPHA && ALPHA <= Math.PI * 3 / 4 && Y1 > Y3 ||
                    Math.PI * 5 / 4 <= ALPHA && ALPHA <= Math.PI * 7 / 4 && Y1 < Y3
            ) {
                L = L * (-1.0);
            }

            for (int i = 0, j = 0; LengthExtrRound + LengthSide - CAL >= j * CAL; j++, i++) {
                СoorAncIntPlanLine[i][0] = CoordXFirstAnch + j * CAL * Math.cos(Beta);
                СoorAncIntPlanLine[i][1] = CoordYFirstAnch + j * CAL * Math.sin(Beta);
                СoorAncIntPlanLine[i][2] = CoordXFirstAnch + j * CAL * Math.cos(Beta) + L * Math.sin(Beta);
                СoorAncIntPlanLine[i][3] = CoordYFirstAnch + j * CAL * Math.sin(Beta) - L * Math.cos(Beta);
            }
        } else {
        }
    }

    /**
     * Это метод рассчета координат установки анкеров в проекции.
     */
    public void calcCoordAnchProjInt(double X1, double Y1, double CAL, double L) {
        int i, j, k;

        double B = distanceBetweenPoint(x33, y33, x1, y1); //Ширина выработки

        double ArcLength = RBIG(B, typeInt) * calcAngleBetweenVertAndPointCont(X1, Y1); //Длина дуги

        double LineLength = distanceBetweenPoint(calcCoordPointContX(X1, Y1), calcCoordPointContY(X1, Y1), X1, Y1); //Длина прямолинейного отрезка

        numAnchProj = (int) (Math.ceil((ArcLength + LineLength) / CAL));

        double X0arc = 0.0; //координата X установки первого анкера по дуге
        double Y0arc = h1 * calcIndHeightInt(); //координата Y установки первого анкера по дуге

        СoorAncIntProj = new double[numAnchProj + 1][4]; //numAnchProj + 1 - количество анкеров в ряду

        //определение координат установки анкеров по дуге большого радиуса
        if (X1 >= 0) {
            for (i = 0, j = 0; ArcLength >= j * CAL; i++, j++) {
                СoorAncIntProj[i][0] = X0arc + RBIG(B, typeInt) * Math.sin(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][1] = -Y0arc * Math.cos(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][2] = X0arc + (RBIG(B, typeInt) + L) * Math.sin(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][3] = (-Y0arc - L) * Math.cos(j * CAL / RBIG(B, typeInt));
            }
        } else {
            for (i = 0, j = 0; ArcLength >= j * CAL; i++, j++) {
                СoorAncIntProj[i][0] = X0arc - RBIG(B, typeInt) * Math.sin(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][1] = -Y0arc * Math.cos(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][2] = X0arc - (RBIG(B, typeInt) + L) * Math.sin(j * CAL / RBIG(B, typeInt));
                СoorAncIntProj[i][3] = (-Y0arc - L) * Math.cos(j * CAL / RBIG(B, typeInt));
            }
        }

        double REMAIN = ArcLength - (i - 1) * CAL; //остаток дуги
        double OMEGA = Math.atan(Math.abs((calcCoordPointContY(X1, Y1) - Y1) / (calcCoordPointContX(X1, Y1) - X1))); //угол наклона прямолинейного отрезка кровли отностительно оси X

        //определение координат установки анкеров по прямолинейному участку кровли сопряжения
        if (X1 >= 0) {
            X0line = calcCoordPointContX(X1, Y1) + (CAL - REMAIN) * Math.cos(OMEGA); //координата X установки первого анкера по линии
            Y0line = calcCoordPointContY(X1, Y1) + (CAL - REMAIN) * Math.sin(OMEGA); //координата Y установки первого анкера по линии
        } else {
            X0line = calcCoordPointContX(X1, Y1) - (CAL - REMAIN) * Math.cos(OMEGA); //координата X установки первого анкера по линии
            Y0line = calcCoordPointContY(X1, Y1) + (CAL - REMAIN) * Math.sin(OMEGA); //координата Y установки первого анкера по линии
        }

        if (X1 >= 0) {
            for (k = 0; (REMAIN + LineLength) * Math.cos(OMEGA) - CAL >= k * CAL; i++, k++) {
                //СoorAncIntProj[i][0] = X0line + k * CAL * Math.cos(OMEGA);
                СoorAncIntProj[i][0] = X0line + k * CAL;
                СoorAncIntProj[i][1] = Y0line + k * CAL * Math.sin(OMEGA);
                //СoorAncIntProj[i][2] = X0line + k * CAL * Math.cos(OMEGA) + L * Math.cos(OMEGA - Math.PI / 2.0);
                СoorAncIntProj[i][2] = X0line + k * CAL + L * Math.cos(OMEGA - Math.PI / 2.0);
                СoorAncIntProj[i][3] = Y0line + k * CAL * Math.sin(OMEGA) + L * Math.sin(OMEGA - Math.PI / 2.0);
            }
        } else {
            for (k = 0; (REMAIN + LineLength) * Math.cos(OMEGA) - CAL >= k * CAL; i++, k++) {
                //СoorAncIntProj[i][0] = X0line - k * CAL * Math.cos(OMEGA);
                СoorAncIntProj[i][0] = X0line - k * CAL;
                СoorAncIntProj[i][1] = Y0line + k * CAL * Math.sin(OMEGA);
                //СoorAncIntProj[i][2] = X0line - k * CAL * Math.cos(OMEGA) + L * Math.cos(OMEGA + Math.PI / 2.0);
                СoorAncIntProj[i][2] = X0line - k * CAL + L * Math.cos(OMEGA + Math.PI / 2.0);
                СoorAncIntProj[i][3] = Y0line + k * CAL * Math.sin(OMEGA) - L * Math.sin(OMEGA + Math.PI / 2.0);
            }
        }
    }

    /**
     * Это метод проверки построения анкеров в плане сопряжения.
     */
    public void testX0Y0(double cal, double XB, double YB) {
        numAnchTest = (int) (distanceBetweenPoint(XB, YB, 0.0, 0.0) / cal); //расчет количества перпендикуляров
        double SIGMA = Math.atan2(YB, XB);
        СoorTestX0Y0 = new double[numAnchTest + 1][4]; //numAnchTest + 1 - количество перпендикуляров
        for (int i = 0, j = 0; distanceBetweenPoint(XB, YB, 0.0, 0.0) >= j * cal; j++, i++) {
            СoorTestX0Y0[i][0] = j * cal * Math.cos(SIGMA) - L0 * Math.cos(SIGMA - Math.PI / 2);
            СoorTestX0Y0[i][1] = j * cal * Math.sin(SIGMA) - L0 * Math.sin(SIGMA - Math.PI / 2);
            СoorTestX0Y0[i][2] = j * cal * Math.cos(SIGMA) + L0 * Math.cos(SIGMA - Math.PI / 2);
            СoorTestX0Y0[i][3] = j * cal * Math.sin(SIGMA) + L0 * Math.sin(SIGMA - Math.PI / 2);
        }
    }
}
