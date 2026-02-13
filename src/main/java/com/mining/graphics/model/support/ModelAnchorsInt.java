package com.mining.graphics.model.support;

import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.service.excavation.ServiceIntersection;

public class ModelAnchorsInt extends ServiceIntersection {

    //длина анкеров
    public double
            l1 = 1.8,
            l2 = 1.8,
            l3 = 1.8,
            l4 = 1.8;

    //шаг анкерования в ряду
    public double
            bAc1 = 0.8,
            bAc2 = 0.8,
            bAc3 = 0.8,
            bAc4 = 0.8;

    //расстояние мужду рядами анкеров
    public double
            cAl1 = 1.0,
            cAl2 = 1.0,
            cAl3 = 1.0,
            cAl4 = 1.0;

    //максимальное расстояние от почвы выработки до точки установки нижнего анкера
    public double
            p1 = 1.2,
            p2 = 1.2,
            p3 = 1.2,
            p4 = 1.2;
}
