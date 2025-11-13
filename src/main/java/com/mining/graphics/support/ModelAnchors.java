package com.mining.graphics.support;

import com.mining.graphics.model.ModelExcavation;

public class ModelAnchors extends ModelExcavation {

    public double l = 1.8; //длина анкера
    public double bAc = 0.85; //шаг анкерования в ряду
    public double cAl = 0.9; //расстояние между рядами анкеров
    public double d = 0.1; //размер опорной плитки
    public double p = 1.2; //максимальное расстояние от почвы выработки до точки установки нижнего анкера
    public int m = 7; //количество рядов анкеров для отображения - вид сбоку
}