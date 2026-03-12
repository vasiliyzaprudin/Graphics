package com.mining.graphics.service.excavation;

import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.service.support.ServiceAnchorsIntersection;

public class ServiceIntersection extends ModelIntersection {

    private ServiceAnchorsIntersection SAI;

    public double xi1, yi1, xi2, yi2, xi3, yi3, xi4, yi4, xi22, yi22, xi33, yi33; //координаты точек пересечения боков выработок
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
        xi1 = calcCoordPointSidesX(b1, b2, alpha1Rad, alpha2Rad);
        xi1sc = (int) (xi1 * scaleInt);
        yi1 = calcCoordPointSidesY(b1, b2, alpha1Rad, alpha2Rad);
        yi1sc = (int) (yi1 * scaleInt);

        xi2 = calcCoordPointSidesX(b2, b3, alpha2Rad, alpha3Rad);
        xi2sc = (int) (xi2 * scaleInt);
        yi2 = calcCoordPointSidesY(b2, b3, alpha2Rad, alpha3Rad);
        yi2sc = (int) (yi2 * scaleInt);

        xi3 = calcCoordPointSidesX(b3, b4, alpha3Rad, alpha4Rad);
        xi3sc = (int) (xi3 * scaleInt);
        yi3 = calcCoordPointSidesY(b3, b4, alpha3Rad, alpha4Rad);
        yi3sc = (int) (yi3 * scaleInt);

        xi4 = calcCoordPointSidesX(b4, b1, alpha4Rad, alpha1Rad);
        xi4sc = (int) (xi4 * scaleInt);
        yi4 = calcCoordPointSidesY(b4, b1, alpha4Rad, alpha1Rad);
        yi4sc = (int) (yi4 * scaleInt);

        xi33 = calcCoordPointSidesX(b3, b1, alpha3Rad, alpha1Rad);
        xi33sc = (int) (xi33 * scaleInt);
        yi33 = calcCoordPointSidesY(b3, b1, alpha3Rad, alpha1Rad);
        yi33sc = (int) (yi33 * scaleInt);

        xi22 = -xi1;
        xi22sc = (int) (xi22 * scaleInt);
        yi22 = -yi1;
        yi22sc = (int) (yi22 * scaleInt);

        //Расчет координат плоскостей забоя горных выработок
        xs11 = calcCoordPointStopeExX(L1, b1, alpha1Rad);
        xs11sc = (int) (xs11 * scaleInt);
        ys11 = calcCoordPointStopeExY(L1, b1, alpha1Rad);
        ys11sc = (int) (ys11 * scaleInt);

        xs12 = calcCoordPointStopeExX(L1, -b1, alpha1Rad);
        xs12sc = (int) (xs12 * scaleInt);
        ys12 = calcCoordPointStopeExY(L1, -b1, alpha1Rad);
        ys12sc = (int) (ys12 * scaleInt);

        xs21 = calcCoordPointStopeExX(L2, b2, alpha2Rad);
        xs21sc = (int) (xs21 * scaleInt);
        ys21 = calcCoordPointStopeExY(L2, b2, alpha2Rad);
        ys21sc = (int) (ys21 * scaleInt);

        xs22 = calcCoordPointStopeExX(L2, -b2, alpha2Rad);
        xs22sc = (int) (xs22 * scaleInt);
        ys22 = calcCoordPointStopeExY(L2, -b2, alpha2Rad);
        ys22sc = (int) (ys22 * scaleInt);

        xs31 = calcCoordPointStopeExX(L3, b3, alpha3Rad);
        xs31sc = (int) (xs31 * scaleInt);
        ys31 = calcCoordPointStopeExY(L3, b3, alpha3Rad);
        ys31sc = (int) (ys31 * scaleInt);

        xs32 = calcCoordPointStopeExX(L3, -b3, alpha3Rad);
        xs32sc = (int) (xs32 * scaleInt);
        ys32 = calcCoordPointStopeExY(L3, -b3, alpha3Rad);
        ys32sc = (int) (ys32 * scaleInt);

        xs41 = calcCoordPointStopeExX(L4, b4, alpha4Rad);
        xs41sc = (int) (xs41 * scaleInt);
        ys41 = calcCoordPointStopeExY(L4, b4, alpha4Rad);
        ys41sc = (int) (ys41 * scaleInt);

        xs42 = calcCoordPointStopeExX(L4, -b4, alpha4Rad);
        xs42sc = (int) (xs42 * scaleInt);
        ys42 = calcCoordPointStopeExY(L4, -b4, alpha4Rad);
        ys42sc = (int) (ys42 * scaleInt);

        //Расчет величины закругления сопряжения
        CalculateBB(b2, b1, alpha2Rad, alpha1Rad);
        bb12 = bb;
        CalculateBB(b3, b2, alpha3Rad, alpha2Rad);
        bb23 = bb;
        CalculateBB(b1, b3, alpha1Rad, alpha3Rad);
        bb31 = bb;

        //Координаты точек закругления выработок
        x1 = xi1 + bb12 * Math.cos(Math.atan2(yi1, xi1));
        x1sc = (int) (x1 * scaleInt);
        y1 = yi1 + bb12 * Math.sin(Math.atan2(yi1, xi1));
        y1sc = (int) (y1 * scaleInt);

        x2 = xi2 + bb23 * Math.cos(Math.atan2(yi2, xi2));
        x2sc = (int) (x2 * scaleInt);
        y2 = yi2 + bb23 * Math.sin(Math.atan2(yi2, xi2));
        y2sc = (int) (y2 * scaleInt);


        x3 = xi3 - bb34 * Math.abs(Math.sin((alpha3Rad + alpha4Rad) / 2));
        x3sc = (int) (x3 * scaleInt);
        y3 = yi3 + bb34 * Math.abs(Math.cos((alpha3Rad + alpha4Rad) / 2));
        y3sc = (int) (y3 * scaleInt);

        x4 = xi4 - bb41 * Math.abs(Math.sin((alpha4Rad + alpha1Rad) / 2));
        x4sc = (int) (x4 * scaleInt);
        y4 = yi4 - bb41 * Math.abs(Math.cos((alpha4Rad + alpha1Rad) / 2));
        y4sc = (int) (y4 * scaleInt);

        x33 = xi33 + bb31 * Math.cos(Math.atan2(yi33, xi33));
        x33sc = (int) (x33 * scaleInt);
        y33 = yi33 + bb31 * Math.sin(Math.atan2(yi33, xi33));
        y33sc = (int) (y33 * scaleInt);

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
        //System.out.println("B = " + B + " м");
        double X0 = 0.0;
        double Y0 = -h1 * calcIndHeightInt() + RBIG(B, typeInt);
        //double Y0 = -Collections.max(Arrays.asList(h1, h2, h3)) * calcIndHeightInt() + RBIG(B, typeInt);
//        System.out.println("Collections.max(Arrays.asList(h1, h2, h3)) * k = " + h1 * calcIndHeightInt() + " м");
//        System.out.println("RBIG = " + RBIG(B, typeInt) + " м");
        double HI = Math.acos(RBIG(B, typeInt) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        //System.out.println("distanceBetweenPoint(X0, Y0, X1, Y1) = " + SAI.distanceBetweenPoint(X0, Y0, X1, Y1) + " м");
        //System.out.println("HI = " + HI * 180 / Math.PI + "градусов");
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        //System.out.println("PSI = " + PSI * 180 / Math.PI + "градусов");
        //System.out.println("HI + PSI = " + (PSI + HI) * 180 / Math.PI + "градусов");
        double dx = RBIG(B, typeInt) * Math.abs(Math.cos(HI + PSI));
        //System.out.println("dx = " + dx + " м");
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
        double Y0 = -h1 * calcIndHeightInt() + RBIG(B, typeInt);
        //double Y0 = -Collections.max(Arrays.asList(h1, h2, h3)) * calcIndHeightInt() + RBIG(B, typeInt);
        double HI = Math.acos(RBIG(B, typeInt) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        double dy = RBIG(B, typeInt) * Math.abs(Math.sin(HI + PSI));
        //System.out.println("dy = " + dy + " м");
        double Y = (-h1 * calcIndHeightInt() + RBIG(B, typeInt) - dy);
        //double Y = (-Collections.max(Arrays.asList(h1, h2, h3)) * calcIndHeightInt() + RBIG(B, typeInt) - dy);
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
        double Y0 = -h1 * calcIndHeightInt() + RBIG(B, typeInt);
        double HI = Math.acos(RBIG(B, typeInt) / SAI.distanceBetweenPoint(X0, Y0, X1, Y1));
        double PSI = Math.atan(Math.abs((Y1 - Y0) / (X1 - X0)));
        //System.out.println((Math.PI / 2 - HI - PSI) * 180 / Math.PI);
        return Math.PI / 2 - HI - PSI;
    }
}





