package com.mining.graphics.model.support;

import com.mining.graphics.service.excavation.ServiceExcavation;

public class ModelAnchorsExcavation extends ServiceExcavation {

    public double lengthAnch = 2.0; //длина анкера
    public double step = 0.8; //шаг установки анкеров в ряду
    public double distanceBetweenRows = 0.9; //расстояние между рядами анкеров
    public double plateSize = 0.1; //размер опорной плитки
    public double distanceLowerAnchor = 2.5; //максимальное расстояние от почвы выработки до точки установки нижнего анкера
    public int numberAnchorToGraphic = 5; //количество рядов анкеров для отображения - вид сбоку
}