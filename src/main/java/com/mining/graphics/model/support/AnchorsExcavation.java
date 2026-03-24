package com.mining.graphics.model.support;

import com.mining.graphics.service.excavation.ServiceExcavation;

public class AnchorsExcavation extends ServiceExcavation {

    public double lengthAnch = 2.0; //длина анкера
    public double step = 0.9; //шаг установки анкеров в ряду
    public double distanceBetweenRows = 0.9; //расстояние между рядами анкеров
    public double plateSize = 0.1; //размер опорной плиты
    public double anchorDiameter = 0.1; //диаметр анкера
    public double distanceLowerAnchor = 0.5; //максимальное расстояние от почвы выработки до точки установки нижнего анкера
}