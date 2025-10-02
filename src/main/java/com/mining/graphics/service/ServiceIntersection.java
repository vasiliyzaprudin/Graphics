package com.mining.graphics.service;

import com.mining.graphics.model.ModelIntersection;

public class ServiceIntersection {
    ModelIntersection ModelIntersection = new ModelIntersection();
    double b1 = ModelIntersection.getb1();
    double b2 = ModelIntersection.getb2();
    double b3 = ModelIntersection.getb3();
    double alpha1 = ModelIntersection.getalpha1() * Math.PI / 180;
    double alpha2 = ModelIntersection.getalpha2() * Math.PI / 180;
    double alpha3 = ModelIntersection.getalpha3() * Math.PI / 180;
    double x1, y1, x2, y2, x3, y3; //координаты точек пересечения боков выработок
    double beta1, beta2, beta3;

    public ServiceIntersection() {
        CalculateCoordinatesIntersection();
    }

    private void CalculateCoordinatesIntersection() {
        beta1 = Math.atan((b1 * Math.sin(alpha2 - alpha1)) / (b2 + b1 * Math.cos(alpha2 - alpha1)));
        x1 = b1 / (2.0 * Math.sin(beta1)) * Math.cos(alpha1 + beta1 - Math.PI / 2.0);
        y1 = b1 / (2.0 * Math.sin(beta1)) * Math.sin(alpha1 + beta1 - Math.PI / 2.0);

        //Первый вариант расчета beta2, x2, y2, beta 3, x3, y3
        beta2 = Math.atan((b2 * Math.sin(alpha3 - alpha2)) / (b3 + b2 * Math.cos(alpha3 - alpha2)));
        x2 = (-1.0) * b2 / (2.0 * Math.sin(beta2)) * Math.cos(3.0 / 2.0 * Math.PI - alpha2 - beta2);
        y2 = b2 / (2.0 * Math.sin(beta2)) * Math.sin(3.0 / 2.0 * Math.PI - alpha2 - beta2);

        beta3 = Math.atan((b3 * Math.sin(alpha1 - alpha3)) / (b1 + b3 * Math.cos(alpha1 - alpha3)));
        x3 = b3 / (2.0 * Math.sin(beta3)) * Math.cos(5.0 / 2.0 * Math.PI - alpha3 - beta3);
        y3 = (-1.0) * b3 / (2.0 * Math.sin(beta3)) * Math.sin(5.0 / 2.0 * Math.PI - alpha3 - beta3);

        //Второй вариант расчета beta2, x2, y2, beta 3, x3, y3
        //beta2 = Math.atan((b2 * Math.sin(alpha3 - alpha2)) / (b3 + b2 * Math.cos(alpha3 - alpha2)));
        //x2 = b2 / (2.0 * Math.sin(beta2)) * Math.cos(alpha2 + beta2 - Math.PI / 2.0);
        //y2 = b2 / (2.0 * Math.sin(beta2)) * Math.sin(alpha2 + beta2 - Math.PI / 2.0);

        //beta3 = Math.atan((b3 * Math.sin(alpha1 - alpha3)) / (b1 + b3 * Math.cos(alpha1 - alpha3)));
        //x3 = b3 / (2.0 * Math.sin(beta3)) * Math.cos(alpha3 + beta3 - Math.PI / 2.0);
        //y3 = b3 / (2.0 * Math.sin(beta3)) * Math.sin(alpha3 + beta3 - Math.PI / 2.0);

    }

    public double getbeta1() {
        return this.beta1;
    }

    public double getbeta2() {
        return this.beta2;
    }

    public double getbeta3() {
        return this.beta3;
    }

    public double getx1() {
        return this.x1;
    }

    public double gety1() {
        return this.y1;
    }

    public double getx2() {
        return this.x2;
    }

    public double gety2() {
        return this.y2;
    }

    public double getx3() {
        return this.x3;
    }

    public double gety3() {
        return this.y3;
    }

}



