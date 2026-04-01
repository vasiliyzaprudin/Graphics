package com.mining.graphics.service.excavation;

import com.mining.graphics.service.support.ServiceAnchorsIntersection;

public class ServiceIntersection {

    public int getScaleParameter(double Parameter, int scale) {
        return (int) (Math.round(Parameter * scale));
    }


    private ServiceAnchorsIntersection SAI;
    // @formatter:off
    private double xIntersectionWall12, yIntersectionWall12, xIntersectionWall23, yIntersectionWall23, xIntersectionWall34, yIntersectionWall34, xIntersectionWall41, yIntersectionWall41,
            xIntersectionWall21, yIntersectionWall21,
            xIntersectionWall31, yIntersectionWall31;



    // @formatter:on



    public int xi1sc, yi1sc, xi2sc, yi2sc, xi3sc, yi3sc, xi4sc, yi4sc, xi22sc, yi22sc, xi33sc, yi33sc;


    public double xs11, ys11, xs12, ys12, xs21, ys21, xs22, ys22, xs31, ys31, xs32, ys32, xs41, ys41, xs42, ys42; //координаты забоя выработок
    public int xs11sc, ys11sc, xs12sc, ys12sc, xs21sc, ys21sc, xs22sc, ys22sc, xs31sc, ys31sc, xs32sc, ys32sc, xs41sc, ys41sc, xs42sc, ys42sc;

    public double x12, y12, x21, y21, x23, y23, x32, y32, x34, y34, x43, y43, x41, y41, x14, y14;
    public int x12sc, y12sc, x21sc, y21sc, x23sc, y23sc, x32sc, y32sc, x34sc, y34sc, x43sc, y43sc, x41sc, y41sc, x14sc, y14sc;
    public double x13, y13, x31, y31;
    public int x13sc, y13sc, x31sc, y31sc;

    public double xb1, yb1, xb2, yb2, xb3, yb3, xb4, yb4; //координаты точек пресечения осей выработок и забоя
    public int xb1sc, yb1sc, xb2sc, yb2sc, xb3sc, yb3sc, xb4sc, yb4sc;

    public double x1, y1, x2, y2, x3, y3, x4, y4;
    public int x1sc, y1sc, x2sc, y2sc, x3sc, y3sc, x4sc, y4sc;
    public double x33, y33;
    public int x33sc, y33sc;

    public static double BETAINT; //Вспомогательный угол для расчета координат пересечения боков горных выработок

    public ServiceIntersection() {
        calcCoordInt();
    }

    //Расчетные геометрические параметры выработки
    public double ALPHA;
    public double BETA;
    public int HRSC;
    public int RBIGSC;
    public int RSMALLSC;
    public int HSC;
    public int BSC;

    //Параметры поперечного сечения горной выработки
    public static double HR(double B, double K) {
        return B / K; //высота закругления
    }

    public static double ALPHA(double B, double K) {
        return Math.atan(2.0 * HR(B, K) / B); //опорный угол дуги большого радиуса;
    }

    public static double BETA(double B, double K) {
        return Math.PI / 2.0 - ALPHA(B, K); //опорный угол дуги малого радиуса
    }

    public static double RBIG(double B, double K) {
        return (HR(B, K) / Math.cos(ALPHA(B, K)) - B / 2.0 - HR(B, K) * Math.tan(ALPHA(B, K))) / (1.0 / Math.cos(ALPHA(B, K)) - 1 - Math.tan(ALPHA(B, K))); //радиус большой окружности
    }

    public static double RSMALL(double B, double K) {
        return RBIG(B, K) - (RBIG(B, K) - HR(B, K)) / Math.cos(ALPHA(B, K)); // радиус малой окружности
    }

    /**
     * Этот метод объединяет параметры, необходимые для построения сечения горной выработки,
     * и масштабирует их.
     */
    public void calcElemInSc(double B, double H, double K, double SC) {
        ALPHA = ALPHA(B, K);
        BETA = BETA(B, K);
        HSC = (int) (H * SC);
        BSC = (int) (B * SC);
        HRSC = (int) (HR(B, K) * SC);
        RBIGSC = (int) (RBIG(B, K) * SC);
        RSMALLSC = (int) (RSMALL(B, K) * SC);
    }

    private void calcCoordInt() {
        //Расчет координат точек пересечения боков горных выработок
        xIntersectionWall12 = calcCoordPointSidesX(b1, width2, alpha1Rad, alpha2Rad);
        xi1sc = (int) (xIntersectionWall12 * scaleInt);
        yIntersectionWall12 = calcCoordPointSidesY(b1, width2, alpha1Rad, alpha2Rad);
        yi1sc = (int) (yIntersectionWall12 * scaleInt);

        xIntersectionWall23 = calcCoordPointSidesX(width2, b3, alpha2Rad, alpha3Rad);
        xi2sc = (int) (xIntersectionWall23 * scaleInt);
        yIntersectionWall23 = calcCoordPointSidesY(width2, b3, alpha2Rad, alpha3Rad);
        yi2sc = (int) (yIntersectionWall23 * scaleInt);

        xIntersectionWall34 = calcCoordPointSidesX(b3, width4, alpha3Rad, alpha4Rad);
        xi3sc = (int) (xIntersectionWall34 * scaleInt);
        yIntersectionWall34 = calcCoordPointSidesY(b3, width4, alpha3Rad, alpha4Rad);
        yi3sc = (int) (yIntersectionWall34 * scaleInt);

        xIntersectionWall41 = calcCoordPointSidesX(width4, b1, alpha4Rad, alpha1Rad);
        xi4sc = (int) (xIntersectionWall41 * scaleInt);
        yIntersectionWall41 = calcCoordPointSidesY(width4, b1, alpha4Rad, alpha1Rad);
        yi4sc = (int) (yIntersectionWall41 * scaleInt);

        xIntersectionWall31 = calcCoordPointSidesX(b3, b1, alpha3Rad, alpha1Rad);
        xi33sc = (int) (xIntersectionWall31 * scaleInt);
        yIntersectionWall31 = calcCoordPointSidesY(b3, b1, alpha3Rad, alpha1Rad);
        yi33sc = (int) (yIntersectionWall31 * scaleInt);

        xIntersectionWall21 = -xIntersectionWall12;
        xi22sc = (int) (xIntersectionWall21 * scaleInt);
        yIntersectionWall21 = -yIntersectionWall12;
        yi22sc = (int) (yIntersectionWall21 * scaleInt);

        //Расчет координат плоскостей забоя горных выработок
        xs11 = calcCoordPointStopeExX(L1, b1, alpha1Rad);
        xs11sc = (int) (xs11 * scaleInt);
        ys11 = calcCoordPointStopeExY(L1, b1, alpha1Rad);
        ys11sc = (int) (ys11 * scaleInt);

        xs12 = calcCoordPointStopeExX(L1, -b1, alpha1Rad);
        xs12sc = (int) (xs12 * scaleInt);
        ys12 = calcCoordPointStopeExY(L1, -b1, alpha1Rad);
        ys12sc = (int) (ys12 * scaleInt);

        xs21 = calcCoordPointStopeExX(L2, width2, alpha2Rad);
        xs21sc = (int) (xs21 * scaleInt);
        ys21 = calcCoordPointStopeExY(L2, width2, alpha2Rad);
        ys21sc = (int) (ys21 * scaleInt);

        xs22 = calcCoordPointStopeExX(L2, -width2, alpha2Rad);
        xs22sc = (int) (xs22 * scaleInt);
        ys22 = calcCoordPointStopeExY(L2, -width2, alpha2Rad);
        ys22sc = (int) (ys22 * scaleInt);

        xs31 = calcCoordPointStopeExX(L3, b3, alpha3Rad);
        xs31sc = (int) (xs31 * scaleInt);
        ys31 = calcCoordPointStopeExY(L3, b3, alpha3Rad);
        ys31sc = (int) (ys31 * scaleInt);

        xs32 = calcCoordPointStopeExX(L3, -b3, alpha3Rad);
        xs32sc = (int) (xs32 * scaleInt);
        ys32 = calcCoordPointStopeExY(L3, -b3, alpha3Rad);
        ys32sc = (int) (ys32 * scaleInt);

        xs41 = calcCoordPointStopeExX(L4, width4, alpha4Rad);
        xs41sc = (int) (xs41 * scaleInt);
        ys41 = calcCoordPointStopeExY(L4, width4, alpha4Rad);
        ys41sc = (int) (ys41 * scaleInt);

        xs42 = calcCoordPointStopeExX(L4, -width4, alpha4Rad);
        xs42sc = (int) (xs42 * scaleInt);
        ys42 = calcCoordPointStopeExY(L4, -width4, alpha4Rad);
        ys42sc = (int) (ys42 * scaleInt);

        //Расчет величины закругления сопряжения
        CalculateBB(width2, b1, alpha2Rad, alpha1Rad);
        bb12 = bb;
        CalculateBB(b3, width2, alpha3Rad, alpha2Rad);
        bb23 = bb;
        CalculateBB(b1, b3, alpha1Rad, alpha3Rad);
        bb31 = bb;

        //Координаты точек закругления выработок
        x1 = xIntersectionWall12 + bb12 * Math.cos(Math.atan2(yIntersectionWall12, xIntersectionWall12));
        x1sc = (int) (x1 * scaleInt);
        y1 = yIntersectionWall12 + bb12 * Math.sin(Math.atan2(yIntersectionWall12, xIntersectionWall12));
        y1sc = (int) (y1 * scaleInt);

        x2 = xIntersectionWall23 + bb23 * Math.cos(Math.atan2(yIntersectionWall23, xIntersectionWall23));
        x2sc = (int) (x2 * scaleInt);
        y2 = yIntersectionWall23 + bb23 * Math.sin(Math.atan2(yIntersectionWall23, xIntersectionWall23));
        y2sc = (int) (y2 * scaleInt);


        x3 = xIntersectionWall34 - bb34 * Math.abs(Math.sin((alpha3Rad + alpha4Rad) / 2));
        x3sc = (int) (x3 * scaleInt);
        y3 = yIntersectionWall34 + bb34 * Math.abs(Math.cos((alpha3Rad + alpha4Rad) / 2));
        y3sc = (int) (y3 * scaleInt);

        x4 = xIntersectionWall41 - bb41 * Math.abs(Math.sin((alpha4Rad + alpha1Rad) / 2));
        x4sc = (int) (x4 * scaleInt);
        y4 = yIntersectionWall41 - bb41 * Math.abs(Math.cos((alpha4Rad + alpha1Rad) / 2));
        y4sc = (int) (y4 * scaleInt);

        x33 = xIntersectionWall31 + bb31 * Math.cos(Math.atan2(yIntersectionWall31, xIntersectionWall31));
        x33sc = (int) (x33 * scaleInt);
        y33 = yIntersectionWall31 + bb31 * Math.sin(Math.atan2(yIntersectionWall31, xIntersectionWall31));
        y33sc = (int) (y33 * scaleInt);

        //Координаты точек начала закругления выработок
        x12 = xIntersectionWall12 + b12 * Math.sin(alpha1Rad);
        x12sc = (int) (x12 * scaleInt);
        y12 = yIntersectionWall12 - b12 * Math.cos(alpha1Rad);
        y12sc = (int) (y12 * scaleInt);

        x21 = xIntersectionWall12 + b21 * Math.sin(alpha2Rad);
        x21sc = (int) (x21 * scaleInt);
        y21 = yIntersectionWall12 - b21 * Math.cos(alpha2Rad);
        y21sc = (int) (y21 * scaleInt);

        x23 = xIntersectionWall23 + b23 * Math.sin(alpha2Rad);
        x23sc = (int) (x23 * scaleInt);
        y23 = yIntersectionWall23 - b23 * Math.cos(alpha2Rad);
        y23sc = (int) (y23 * scaleInt);

        x32 = xIntersectionWall23 + b32 * Math.sin(alpha3Rad);
        x32sc = (int) (x32 * scaleInt);
        y32 = yIntersectionWall23 - b32 * Math.cos(alpha3Rad);
        y32sc = (int) (y32 * scaleInt);

        x34 = xIntersectionWall34 + b34 * Math.sin(alpha3Rad);
        x34sc = (int) (x34 * scaleInt);
        y34 = yIntersectionWall34 - b34 * Math.cos(alpha3Rad);
        y34sc = (int) (y34 * scaleInt);

        x43 = xIntersectionWall34 + b43 * Math.sin(alpha4Rad);
        x43sc = (int) (x43 * scaleInt);
        y43 = yIntersectionWall34 - b43 * Math.cos(alpha4Rad);
        y43sc = (int) (y43 * scaleInt);

        x41 = xIntersectionWall41 + b41 * Math.sin(alpha4Rad);
        x41sc = (int) (x41 * scaleInt);
        y41 = yIntersectionWall41 - b41 * Math.cos(alpha4Rad);
        y41sc = (int) (y41 * scaleInt);

        x14 = xIntersectionWall41 + b14 * Math.sin(alpha1Rad);
        x14sc = (int) (x14 * scaleInt);
        y14 = yIntersectionWall41 - b14 * Math.cos(alpha1Rad);
        y14sc = (int) (y14 * scaleInt);

        x31 = xIntersectionWall31 + b31 * Math.sin(alpha3Rad);
        x31sc = (int) (x31 * scaleInt);
        y31 = yIntersectionWall31 - b31 * Math.cos(alpha3Rad);
        y31sc = (int) (y31 * scaleInt);

        x13 = xIntersectionWall31 + b13 * Math.sin(alpha1Rad);
        x13sc = (int) (x13 * scaleInt);
        y13 = yIntersectionWall31 - b13 * Math.cos(alpha1Rad);
        y13sc = (int) (y13 * scaleInt);

        //Расчет координат точек пресечения осей выработок и забоя
        xb1 = L1 * Math.sin(alpha1Rad);
        xb1sc = (int) (xb1 * scaleInt);
        yb1 = L1 * Math.cos(alpha1Rad);
        yb1sc = (int) (yb1 * scaleInt);

        xb2 = L2 * Math.sin(alpha2Rad);
        xb2sc = (int) (xb2 * scaleInt);
        yb2 = L2 * Math.cos(alpha2Rad);
        yb2sc = (int) (yb2 * scaleInt);

        xb3 = L3 * Math.sin(alpha3Rad);
        xb3sc = (int) (xb3 * scaleInt);
        yb3 = -L3 * Math.cos(alpha3Rad);
        yb3sc = (int) (yb3 * scaleInt);

        xb4 = L4 * Math.sin(alpha4Rad);
        xb4sc = (int) (xb4 * scaleInt);
        yb4 = L4 * Math.cos(alpha4Rad);
        yb4sc = (int) (yb4 * scaleInt);
    }

    /**
     * Этот метод считает координату X точки пересечения боков горных выработок.
     */
    public static double calcCoordPointSidesX(double B1, double B2, double ALPHARAD1, double ALPHARAD2) {
        BETAINT = Math.atan((B1 * Math.sin(ALPHARAD2 - ALPHARAD1)) / (B2 + B1 * Math.cos(ALPHARAD2 - ALPHARAD1)));
        return B1 / (2.0 * Math.sin(BETAINT)) * Math.cos(ALPHARAD1 + BETAINT - Math.PI / 2.0);
    }

    /**
     * Этот метод считает координату Y точки пересечения боков горных выработок.
     */
    public static double calcCoordPointSidesY(double B1, double B2, double ALPHARAD1, double ALPHARAD2) {
        BETAINT = Math.atan((B1 * Math.sin(ALPHARAD2 - ALPHARAD1)) / (B2 + B1 * Math.cos(ALPHARAD2 - ALPHARAD1)));
        return B1 / (2.0 * Math.sin(BETAINT)) * Math.sin(ALPHARAD1 + BETAINT - Math.PI / 2.0);
    }

    /**
     * Этот метод считает координату X точки забоя горной выработки.
     */
    public static double calcCoordPointStopeExX(double L, double B, double ALPHARAD) {
        return L * Math.sin(ALPHARAD) - B / 2.0 * Math.cos(ALPHARAD);
    }

    /**
     * Этот метод считает координату Y точки забоя горной выработки.
     */
    public static double calcCoordPointStopeExY(double L, double B, double ALPHARAD) {
        return (-1.0) * L * Math.cos(ALPHARAD) - B / 2.0 * Math.sin(ALPHARAD);
    }

    /**
     * Этот метод считает координату X точки перехода
     * прямого отрезка кровли горной выработки к дуге окружности большого радиуса.
     */
    public double calcCoordPointContX(double X1, double Y1) {
        double B = SAI.distanceBetweenPoint(x33, y33, x1, y1);
        double X0 = 0.0;
        double Y0 = -height1 * calcIndHeightInt() + RBIG(B, formIndicationIntersection);
        double HI = Math.acos(RBIG(B, formIndicationIntersection) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        double dx = RBIG(B, formIndicationIntersection) * Math.abs(Math.cos(HI + PSI));

        if (X1 > 0) {
            return dx;
        } else {
            return -dx;
        }
    }

    /**
     * Этот метод считает координату Y точки перехода
     * прямого отрезка кровли горной выработки к дуге окружности большого радиуса.
     */
    public double calcCoordPointContY(double X1, double Y1) {
        double B = SAI.distanceBetweenPoint(x33, y33, x1, y1);
        double X0 = 0.0;
        double Y0 = -height1 * calcIndHeightInt() + RBIG(B, formIndicationIntersection);
        double HI = Math.acos(RBIG(B, formIndicationIntersection) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        double dy = RBIG(B, formIndicationIntersection) * Math.abs(Math.sin(HI + PSI));
        double Y = (-height1 * calcIndHeightInt() + RBIG(B, formIndicationIntersection) - dy);
        return Y;
    }

    /**
     * Этот метод считает показатель высоты сопряжения.
     */
    public double calcIndHeightInt() {
        //System.out.println("calcIndHeightInt = " + (SAI.distanceBetweenPoint(x33, y33, x1, y1) / (2.0 * b1) + 0.5));
        return SAI.distanceBetweenPoint(x33, y33, x1, y1) / (2.0 * b1) + 0.5;
    }

    /**
     * Этот метод считает опорный угол дуги,
     * соединяющей центр кровли горной выработки и точку касания
     * (точку перехода от дуги к прямолинейному отрезку кровли сопрягаемой горной выработки).
     */
    public double calcAngleBetweenVertAndPointCont(double X1, double Y1) {
        double B = SAI.distanceBetweenPoint(x33, y33, x1, y1);
        double X0 = 0.0;
        double Y0 = -height1 * calcIndHeightInt() + RBIG(B, formIndicationIntersection);
        double HI = Math.acos(RBIG(B, formIndicationIntersection) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        //System.out.println((Math.PI / 2 - HI - PSI) * 180 / Math.PI);
        return Math.PI / 2 - HI - PSI;
    }
}





