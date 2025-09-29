package com.mining.graphics.service;

import com.mining.graphics.mineexcavation.ModelIntersection;

public class ServiceIntersection {
    ModelIntersection ModelIntersection = new ModelIntersection();
    double b1 = ModelIntersection.getb1();
    double b2 = ModelIntersection.getb1();
    double b3 = ModelIntersection.getb1();
    double alpha1 = ModelIntersection.getalpha1();
    double alpha2 = ModelIntersection.getalpha1();
    double alpha3 = ModelIntersection.getalpha1();
    double x1, y1, x2, y2, x3, y3; //координаты точек пересечения боков выработок

    public ServiceIntersection() {
        CalculateCoordinatesIntersection();
    }

    private void CalculateCoordinatesIntersection() {
        int beta1 = (int) Math.atan(b1 * Math.sin(alpha2) / (b1 * Math.cos(alpha2) + b2));
        x1 = b1 / (2 * Math.sin(beta1)) * Math.sin(alpha1 + beta1);
        y1 = (-1) * b1 / (2 * Math.sin(beta1)) * Math.cos(alpha1 + beta1);
    }

    public double getx1() {
        return this.x1;
    }
    public double gety1() {
        return this.y1;
    }
}



