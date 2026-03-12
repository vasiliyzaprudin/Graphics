package com.mining.graphics.model.support;

import com.mining.graphics.service.excavation.ServiceIntersection;

public class ModelAnchorsIntersection extends ServiceIntersection {

    //длина анкеров
    public double
            l1 = 1.8,
            l2 = 2.2,
            l3 = 1.8,
            l4 = 1.8;

    //шаг анкерования в ряду
    public double
            bAc1 = 1.1,
            bAc2 = 1.1,
            bAc3 = 0.8,
            bAc4 = 0.8;

    //расстояние мужду рядами анкеров
    public double
            cAl1 = 1.0,
            cAl2 = 1.3,
            cAl3 = 1.0,
            cAl4 = 1.0;

    //максимальное расстояние от почвы выработки до точки установки нижнего анкера
    public double
            p1 = 1.2,
            p2 = 1.2,
            p3 = 1.2,
            p4 = 1.2;
}
