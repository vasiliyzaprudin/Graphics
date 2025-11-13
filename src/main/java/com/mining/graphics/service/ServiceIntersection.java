package com.mining.graphics.service;

import com.mining.graphics.model.ModelIntersection;

public class ServiceIntersection extends ModelIntersection {
    public double x1, y1, x2, y2, x3, y3; //координаты точек пересечения боков выработок
    public int x1sc, y1sc, x2sc, y2sc, x3sc, y3sc; //координаты точек пересечения боков выработок в масштабе
    public double beta1, beta2, beta3;

    public ServiceIntersection() {
        CalculateCoordinatesIntersection();
    }

    private void CalculateCoordinatesIntersection() {
        beta1 = Math.atan((b1 * Math.sin(alpha2Rad - alpha1Rad)) / (b2 + b1 * Math.cos(alpha2Rad - alpha1Rad)));
        x1 = b1 / (2.0 * Math.sin(beta1)) * Math.cos(alpha1Rad + beta1 - Math.PI / 2.0);
        y1 = b1 / (2.0 * Math.sin(beta1)) * Math.sin(alpha1Rad + beta1 - Math.PI / 2.0);

        //Первый вариант расчета beta2, x2, y2, beta 3, x3, y3
        beta2 = Math.atan((b2 * Math.sin(alpha3Rad - alpha2Rad)) / (b3 + b2 * Math.cos(alpha3Rad - alpha2Rad)));
        x2 = (-1.0) * b2 / (2.0 * Math.sin(beta2)) * Math.cos(3.0 / 2.0 * Math.PI - alpha2Rad - beta2);
        y2 = b2 / (2.0 * Math.sin(beta2)) * Math.sin(3.0 / 2.0 * Math.PI - alpha2Rad - beta2);

        beta3 = Math.atan((b3 * Math.sin(alpha1Rad - alpha3Rad)) / (b1 + b3 * Math.cos(alpha1Rad - alpha3Rad)));
        x3 = b3 / (2.0 * Math.sin(beta3)) * Math.cos(5.0 / 2.0 * Math.PI - alpha3Rad - beta3);
        y3 = (-1.0) * b3 / (2.0 * Math.sin(beta3)) * Math.sin(5.0 / 2.0 * Math.PI - alpha3Rad - beta3);

        //Второй вариант расчета beta2, x2, y2, beta 3, x3, y3
//        beta2 = Math.atan((b2 * Math.sin(alpha3Rad - alpha2Rad)) / (b3 + b2 * Math.cos(alpha3Rad - alpha2Rad)));
//        x2 = b2 / (2.0 * Math.sin(beta2)) * Math.cos(alpha2Rad + beta2 - Math.PI / 2.0);
//        y2 = b2 / (2.0 * Math.sin(beta2)) * Math.sin(alpha2Rad + beta2 - Math.PI / 2.0);
//
//        beta3 = Math.atan((b3 * Math.sin(alpha1Rad - alpha3Rad)) / (b1 + b3 * Math.cos(alpha1Rad - alpha3Rad)));
//        x3 = b3 / (2.0 * Math.sin(beta3)) * Math.cos(alpha3Rad + beta3 - Math.PI / 2.0);
//        y3 = b3 / (2.0 * Math.sin(beta3)) * Math.sin(alpha3Rad + beta3 - Math.PI / 2.0);
        x1sc = (int) (x1 * scaleIn);
        x2sc = (int) (x2 * scaleIn);
        x3sc = (int) (x3 * scaleIn);
        y1sc = (int) (y1 * scaleIn);
        y2sc = (int) (y2 * scaleIn);
        y3sc = (int) (y3 * scaleIn);
    }


}



