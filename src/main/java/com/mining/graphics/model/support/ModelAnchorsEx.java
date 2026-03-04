package com.mining.graphics.model.support;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;

public class ModelAnchorsEx extends ServiceExcavation {

    public double l = 1.8; //длина анкера
    public double bAc = 0.8; //шаг анкерования в ряду
    public double cAl = 0.8; //расстояние между рядами анкеров
    public double d = 0.1; //размер опорной плитки
    public double p = 1.2; //максимальное расстояние от почвы выработки до точки установки нижнего анкера
    public int m = 5; //количество рядов анкеров для отображения - вид сбоку
}