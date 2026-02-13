package com.mining.graphics.service.support;

import com.mining.graphics.model.support.ModelAnchorsInt;

public class ServiceAnchorsInt extends ModelAnchorsInt {
    public double ALPHA;
    public double[][] СoorAncInt; //массив для хранения координат установки анкеров в боках сопряжения
    public int m, n;

    public void CalculateCoordinatesAnchorsInt(double X1, double Y1, double X2, double Y2, double cAl, double l, double bAc, double LroofAc) {
        int v = 0;
        switch (v) {
            case 0: //крепление кровли
                m = (int) Math.floor(LroofAc / bAc);
                //Определение варианта расположения анкеров
                switch (m % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки
                        double deltaX = X2 - X1;
                        double deltaY = Y2 - Y1;
                        double D = Math.sqrt(deltaX * deltaX + deltaY * deltaY); //длина отрезка
                        ALPHA = Math.atan(deltaY / deltaX); //угол наклона отрезка относительно горизонтали
                        n = (int) (D / cAl);
                        СoorAncInt = new double[n + 1][4]; //n + 1 - количество анкеров
                        //определение координат установки анкеров
                        if (X1 <= X2) {
                            for (int i = 0, j = 0; D > j * cAl; j++, i++) {
                                СoorAncInt[i][0] = X1 + j * cAl * Math.cos(ALPHA);
                                СoorAncInt[i][1] = Y1 + j * cAl * Math.sin(ALPHA);
                                СoorAncInt[i][2] = X1 + j * cAl * Math.cos(ALPHA) + l * Math.sin(ALPHA);
                                СoorAncInt[i][3] = Y1 + j * cAl * Math.sin(ALPHA) - l * Math.cos(ALPHA);
                            }
                        } else {
                            for (int i = 0, j = 0; D > j * cAl; j++, i++) {
                                СoorAncInt[i][0] = X1 - j * cAl * Math.cos(ALPHA);
                                СoorAncInt[i][1] = Y1 - j * cAl * Math.sin(ALPHA);
                                СoorAncInt[i][2] = X1 - j * cAl * Math.cos(ALPHA) - l * Math.sin(ALPHA);
                                СoorAncInt[i][3] = Y1 - j * cAl * Math.sin(ALPHA) + l * Math.cos(ALPHA);
                            }
                        }
                        break;
                    case 1: // Анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки
                        break;
                }
            case 1: //крепление кровли и боков
                m = (int) Math.floor((LroofAc1 + (h1 - hr1 - p1) * 2) / bAc1);
                //Определение варианта расположения анкеров
                switch (m % 2) {
                    case 0: //Анкер устанавливается по центру кровли выработки

                        break;

                    case 1: //крепление кровли и боков

                        break;
                }
        }
    }
}
