package com.mining.graphics.service.excavation;

import com.mining.graphics.model.excavation.ModelIntersection;

public class ServiceIntersection extends ModelIntersection {
    public double xi1, yi1, xi2, yi2, xi3, yi3, xi4, yi4, xi22, yi22, xi33, yi33; //координаты точек пересечения боков выработок
    public int xi1sc, yi1sc, xi2sc, yi2sc, xi3sc, yi3sc, xi4sc, yi4sc, xi22sc, yi22sc, xi33sc, yi33sc; //координаты точек пересечения боков выработок в масштабе

    public double xs11, ys11, xs12, ys12, xs21, ys21, xs22, ys22, xs31, ys31, xs32, ys32, xs41, ys41, xs42, ys42; //координаты забоя выработок
    public int xs11sc, ys11sc, xs12sc, ys12sc, xs21sc, ys21sc, xs22sc, ys22sc, xs31sc, ys31sc, xs32sc, ys32sc, xs41sc, ys41sc, xs42sc, ys42sc; //координаты забоя выработок в масштабе

    public double x12, y12, x21, y21, x23, y23, x32, y32, x34, y34, x43, y43, x41, y41, x14, y14;
    public int x12sc, y12sc, x21sc, y21sc, x23sc, y23sc, x32sc, y32sc, x34sc, y34sc, x43sc, y43sc, x41sc, y41sc, x14sc, y14sc;
    public double x13, y13, x31, y31;
    public int x13sc, y13sc, x31sc, y31sc;

    public double x1, y1, x2, y2, x3, y3, x4, y4;
    public int x1sc, y1sc, x2sc, y2sc, x3sc, y3sc, x4sc, y4sc;
    public double x33, y33;
    public int x33sc, y33sc;


    public double beta1, beta2, beta3, beta33, beta4;

    public ServiceIntersection() {
        CalculateCoordinatesIntersection();
    }

    private void CalculateCoordinatesIntersection() {
        //Координаты точек пересечения боков выработок
        beta1 = Math.atan((b1 * Math.sin(alpha2Rad - alpha1Rad)) / (b2 + b1 * Math.cos(alpha2Rad - alpha1Rad)));
        xi1 = b1 / (2.0 * Math.sin(beta1)) * Math.cos(alpha1Rad + beta1 - Math.PI / 2.0);
        xi1sc = (int) (xi1 * scaleInt);
        yi1 = b1 / (2.0 * Math.sin(beta1)) * Math.sin(alpha1Rad + beta1 - Math.PI / 2.0);
        yi1sc = (int) (yi1 * scaleInt);

        beta2 = Math.atan((b2 * Math.sin(alpha3Rad - alpha2Rad)) / (b3 + b2 * Math.cos(alpha3Rad - alpha2Rad)));
        xi2 = b2 / (2.0 * Math.sin(beta2)) * Math.cos(alpha2Rad + beta2 - Math.PI / 2.0);
        xi2sc = (int) (xi2 * scaleInt);
        yi2 = b2 / (2.0 * Math.sin(beta2)) * Math.sin(alpha2Rad + beta2 - Math.PI / 2.0);
        yi2sc = (int) (yi2 * scaleInt);

        beta3 = Math.atan((b3 * Math.sin(alpha4Rad - alpha3Rad)) / (b4 + b3 * Math.cos(alpha4Rad - alpha3Rad)));
        xi3 = b3 / (2.0 * Math.sin(beta3)) * Math.cos(alpha3Rad + beta3 - Math.PI / 2.0);
        xi3sc = (int) (xi3 * scaleInt);
        yi3 = b3 / (2.0 * Math.sin(beta3)) * Math.sin(alpha3Rad + beta3 - Math.PI / 2.0);
        yi3sc = (int) (yi3 * scaleInt);

        beta4 = Math.atan((b4 * Math.sin(alpha1Rad - alpha4Rad)) / (b1 + b4 * Math.cos(alpha1Rad - alpha4Rad)));
        xi4 = b4 / (2.0 * Math.sin(beta4)) * Math.cos(alpha4Rad + beta4 - Math.PI / 2.0);
        xi4sc = (int) (xi4 * scaleInt);
        yi4 = b4 / (2.0 * Math.sin(beta4)) * Math.sin(alpha4Rad + beta4 - Math.PI / 2.0);
        yi4sc = (int) (yi4 * scaleInt);

        beta33 = Math.atan((b3 * Math.sin(alpha1Rad - alpha3Rad)) / (b1 + b3 * Math.cos(alpha1Rad - alpha3Rad)));
        xi33 = b3 / (2.0 * Math.sin(beta33)) * Math.cos(alpha3Rad + beta33 - Math.PI / 2.0);
        xi33sc = (int) (xi33 * scaleInt);
        yi33 = b3 / (2.0 * Math.sin(beta33)) * Math.sin(alpha3Rad + beta33 - Math.PI / 2.0);
        yi33sc = (int) (yi33 * scaleInt);

        xi22 = -xi1;
        xi22sc = (int) (xi22 * scaleInt);
        yi22 = -yi1;
        yi22sc = (int) (yi22 * scaleInt);

        //Координаты точек забоя выработок
        xs11 = L1 * Math.sin(alpha1Rad) - b1 / 2.0 * Math.cos(alpha1Rad);
        xs11sc = (int) (xs11 * scaleInt);
        ys11 = (-1.0) * L1 * Math.cos(alpha1Rad) - b1 / 2.0 * Math.sin(alpha1Rad);
        ys11sc = (int) (ys11 * scaleInt);

        xs12 = L1 * Math.sin(alpha1Rad) + b1 / 2.0 * Math.cos(alpha1Rad);
        xs12sc = (int) (xs12 * scaleInt);
        ys12 = (-1.0) * L1 * Math.cos(alpha1Rad) + b1 / 2.0 * Math.sin(alpha1Rad);
        ys12sc = (int) (ys12 * scaleInt);

        xs21 = L2 * Math.sin(alpha2Rad) - b2 / 2.0 * Math.cos(alpha2Rad);
        xs21sc = (int) (xs21 * scaleInt);
        ys21 = (-1.0) * L2 * Math.cos(alpha2Rad) - b2 / 2.0 * Math.sin(alpha2Rad);
        ys21sc = (int) (ys21 * scaleInt);

        xs22 = L2 * Math.sin(alpha2Rad) + b2 / 2.0 * Math.cos(alpha2Rad);
        xs22sc = (int) (xs22 * scaleInt);
        ys22 = (-1.0) * L2 * Math.cos(alpha2Rad) + b2 / 2.0 * Math.sin(alpha2Rad);
        ys22sc = (int) (ys22 * scaleInt);

        xs31 = L3 * Math.sin(alpha3Rad) - b3 / 2.0 * Math.cos(alpha3Rad);
        xs31sc = (int) (xs31 * scaleInt);
        ys31 = (-1.0) * L3 * Math.cos(alpha3Rad) - b3 / 2.0 * Math.sin(alpha3Rad);
        ys31sc = (int) (ys31 * scaleInt);

        xs32 = L3 * Math.sin(alpha3Rad) + b3 / 2.0 * Math.cos(alpha3Rad);
        xs32sc = (int) (xs32 * scaleInt);
        ys32 = (-1.0) * L3 * Math.cos(alpha3Rad) + b3 / 2.0 * Math.sin(alpha3Rad);
        ys32sc = (int) (ys32 * scaleInt);

        xs41 = L4 * Math.sin(alpha4Rad) - b4 / 2.0 * Math.cos(alpha4Rad);
        xs41sc = (int) (xs41 * scaleInt);
        ys41 = (-1.0) * L4 * Math.cos(alpha4Rad) - b4 / 2.0 * Math.sin(alpha4Rad);
        ys41sc = (int) (ys41 * scaleInt);

        xs42 = L4 * Math.sin(alpha4Rad) + b4 / 2.0 * Math.cos(alpha4Rad);
        xs42sc = (int) (xs42 * scaleInt);
        ys42 = (-1.0) * L4 * Math.cos(alpha4Rad) + b4 / 2.0 * Math.sin(alpha4Rad);
        ys42sc = (int) (ys42 * scaleInt);

        //Координаты точек закругления выработок
        x1 = xi1 + bb12 * Math.sin(alpha1Rad + alpha2Rad);
        x1sc = (int)(x1 * scaleInt);
        y1 = yi1 - bb12 * Math.sin(alpha1Rad + alpha2Rad);
        y1sc = (int)(y1 * scaleInt);

        x2 = xi2 - bb23 * Math.sin(alpha2Rad + alpha3Rad);
        x2sc = (int)(x2 * scaleInt);
        y2 = yi2 - bb23 * Math.sin(alpha2Rad + alpha3Rad);
        y2sc = (int)(y2 * scaleInt);

        x3 = xi3 - bb34 * Math.sin(alpha3Rad + alpha4Rad);
        x3sc = (int)(x3 * scaleInt);
        y3 = yi3 + bb34 * Math.sin(alpha3Rad + alpha4Rad);
        y3sc = (int)(y3 * scaleInt);

        x4 = xi4 + bb41 * Math.sin(alpha4Rad + alpha1Rad);
        x4sc = (int)(x4 * scaleInt);
        y4 = yi4 + bb41 * Math.sin(alpha4Rad + alpha1Rad);
        y4sc = (int)(y4 * scaleInt);

        x33 = xi33 + bb31 * Math.sin(alpha3Rad + alpha1Rad);
        x33sc = (int)(x33 * scaleInt);
        y33 = yi33 + bb31 * Math.sin(alpha3Rad + alpha1Rad);
        y33sc = (int)(y33 * scaleInt);

        //Координаты точек начала закругления выработок
        x12 = xi1 + b12 * Math.sin(alpha1Rad);
        x12sc = (int) (x12 * scaleInt);
        y12 = yi1 - b12 * Math.cos(alpha1Rad);
        y12sc = (int) (y12 * scaleInt);

        x21 = xi1 + b21 * Math.sin(alpha2Rad);
        x21sc = (int) (x21 * scaleInt);
        y21 = yi1 - b21 * Math.cos(alpha2Rad);
        y21sc = (int) (y21 * scaleInt);

        x23 = xi2 + b23 * Math.sin(alpha2Rad);
        x23sc = (int) (x23 * scaleInt);
        y23 = yi2 - b23 * Math.cos(alpha2Rad);
        y23sc = (int) (y23 * scaleInt);

        x32 = xi2 + b32 * Math.sin(alpha3Rad);
        x32sc = (int) (x32 * scaleInt);
        y32 = yi2 - b32 * Math.cos(alpha3Rad);
        y32sc = (int) (y32 * scaleInt);

        x34 = xi3 + b34 * Math.sin(alpha3Rad);
        x34sc = (int) (x34 * scaleInt);
        y34 = yi3 - b34 * Math.cos(alpha3Rad);
        y34sc = (int) (y34 * scaleInt);

        x43 = xi3 + b43 * Math.sin(alpha4Rad);
        x43sc = (int) (x43 * scaleInt);
        y43 = yi3 - b43 * Math.cos(alpha4Rad);
        y43sc = (int) (y43 * scaleInt);

        x41 = xi4 + b41 * Math.sin(alpha4Rad);
        x41sc = (int) (x41 * scaleInt);
        y41 = yi4 - b41 * Math.cos(alpha4Rad);
        y41sc = (int) (y41 * scaleInt);

        x14 = xi4 + b14 * Math.sin(alpha1Rad);
        x14sc = (int) (x14 * scaleInt);
        y14 = yi4 - b14 * Math.cos(alpha1Rad);
        y14sc = (int) (y14 * scaleInt);

        x31 = xi33 + b31 * Math.sin(alpha3Rad);
        x31sc = (int) (x31 * scaleInt);
        y31 = yi33 - b31 * Math.cos(alpha3Rad);
        y31sc = (int) (y31 * scaleInt);

        x13 = xi33 + b13 * Math.sin(alpha1Rad);
        x13sc = (int) (x13 * scaleInt);
        y13 = yi33 - b13 * Math.cos(alpha1Rad);
        y13sc = (int) (y13 * scaleInt);
    }
}



