package com.mining.graphics.service.excavation;

public class ServiceExcavation {

    public static int scaleWidth(double width, int scale) {
        return (int) (Math.round(width * scale));
    }

    public static int scaleHeight(double height, int scale) {
        return (int) (Math.round(height * scale));
    }

    public static int scaleLength(double length, int scale) {
        return (int) (Math.round(length * scale));
    }

    /**
     * Этот метод вычисляет высоту закругления свода горной выработки (archHeight).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double archHeight(double width, double formIndication) {
        return width / formIndication;
    }

    public static int scaleArchHeight(double width, double formIndication, int scale) {
        return (int) (Math.round(archHeight(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет опорный угол дуги большого радиуса (alpha).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double alphaRadian(double width, double formIndication) {
        return Math.atan(2.0 * archHeight(width, formIndication) / width);
    }

    public static double alphaDegree(double width, double formIndication) {
        return alphaRadian(width, formIndication) * 180.0 / Math.PI;
    }

    /**
     * Этот метод вычисляет опорный угол дуги малого радиуса (beta).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double betaRadian(double width, double formIndication) {
        return Math.PI / 2.0 - alphaRadian(width, formIndication);
    }

    public static double betaDegree(double width, double formIndication) {
        return betaRadian(width, formIndication) * 180.0 / Math.PI;
    }

    /**
     * Этот метод вычисляет величину большого радиуса (largeArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double largeArcRadius(double width, double formIndication) {
        double archHeight = archHeight(width, formIndication);
        double alpha = alphaRadian(width, formIndication);

        return (archHeight / Math.cos(alpha) - width / 2.0 - archHeight * Math.tan(alpha)) / (1.0 / Math.cos(alpha) - 1 - Math.tan(alpha));
    }

    public static int scaleLargeArcRadius(double width, double formIndication, int scale) {
        return (int) (Math.round(largeArcRadius(width, formIndication) * scale));
    }


    /**
     * Этот метод вычисляет величину малого радиуса (smallArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double smallArcRadius(double width, double formIndication) {
        double largeRadius = largeArcRadius(width, formIndication);
        double archHeight = archHeight(width, formIndication);
        double alpha = alphaRadian(width, formIndication);

        return largeRadius - (largeRadius - archHeight) / Math.cos(alpha);
    }

    public static int scaleSmallArcRadius(double width, double formIndication, int scale) {
        return (int) (Math.round(smallArcRadius(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину большой дуги (largeArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double largeArcLength(double width, double formIndication) {
        double largeArcRadius = largeArcRadius(width, formIndication);
        double alpha = alphaRadian(width, formIndication);

        return 2.0 * largeArcRadius * alpha;
    }

    public static int scaleLargeArcLength(double width, double formIndication, int scale) {
        return (int) (Math.round(largeArcLength(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину малой дуги (smallArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double smallArcLength(double width, double formIndication) {
        double smallArcRadius = smallArcRadius(width, formIndication);
        double beta = betaRadian(width, formIndication);

        return smallArcRadius * beta;
    }

    public static int scaleSmallArcLength(double width, double formIndication, int scale) {
        return (int) (Math.round(smallArcLength(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину свода (lengthArc).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double lengthArc(double width, double formIndication) {
        double smallArcLength = smallArcLength(width, formIndication);
        double largeArcLength = largeArcLength(width, formIndication);

        return 2.0 * smallArcLength + largeArcLength;
    }

    public static int scaleLengthArc(double width, double formIndication, int scale) {
        return (int) (Math.round(lengthArc(width, formIndication) * scale));
    }
}