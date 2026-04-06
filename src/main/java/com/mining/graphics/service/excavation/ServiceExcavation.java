package com.mining.graphics.service.excavation;

public class ServiceExcavation {

    public static int getScaleWidth(double width, int scale) {
        return (int) (Math.round(width * scale));
    }

    public static int getScaleHeight(double height, int scale) {
        return (int) (Math.round(height * scale));
    }

    public static int getScaleLength(double length, int scale) {
        return (int) (Math.round(length * scale));
    }

    /**
     * Этот метод вычисляет высоту закругления свода горной выработки (archHeight).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getArchHeight(double width, double formIndication) {
        return width / formIndication;
    }

    public static int getScaleArchHeight(double width, double formIndication, int scale) {
        return (int) (Math.round(getArchHeight(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет опорный угол дуги большого радиуса (alpha).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getAlphaRadian(double width, double formIndication) {
        return Math.atan(2.0 * getArchHeight(width, formIndication) / width);
    }

    public static double getAlphaDegree(double width, double formIndication) {
        return getAlphaRadian(width, formIndication) * 180.0 / Math.PI;
    }

    /**
     * Этот метод вычисляет опорный угол дуги малого радиуса (beta).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getBetaRadian(double width, double formIndication) {
        return Math.PI / 2.0 - getAlphaRadian(width, formIndication);
    }

    public static double getBetaDegree(double width, double formIndication) {
        return getBetaRadian(width, formIndication) * 180.0 / Math.PI;
    }

    /**
     * Этот метод вычисляет величину большого радиуса (largeArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getLargeArcRadius(double width, double formIndication) {
        double archHeight = getArchHeight(width, formIndication);
        double alpha = getAlphaRadian(width, formIndication);

        return (archHeight / Math.cos(alpha) - width / 2.0 - archHeight * Math.tan(alpha)) / (1.0 / Math.cos(alpha) - 1 - Math.tan(alpha));
    }

    public static int getScaleLargeArcRadius(double width, double formIndication, int scale) {
        return (int) (Math.round(getLargeArcRadius(width, formIndication) * scale));
    }


    /**
     * Этот метод вычисляет величину малого радиуса (smallArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getSmallArcRadius(double width, double formIndication) {
        double largeRadius = getLargeArcRadius(width, formIndication);
        double archHeight = getArchHeight(width, formIndication);
        double alpha = getAlphaRadian(width, formIndication);

        return largeRadius - (largeRadius - archHeight) / Math.cos(alpha);
    }

    public static int getScaleSmallArcRadius(double width, double formIndication, int scale) {
        return (int) (Math.round(getSmallArcRadius(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину большой дуги (largeArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getLargeArcLength(double width, double formIndication) {
        double largeArcRadius = getLargeArcRadius(width, formIndication);
        double alpha = getAlphaRadian(width, formIndication);

        return 2.0 * largeArcRadius * alpha;
    }

    public static int getScaleLargeArcLength(double width, double formIndication, int scale) {
        return (int) (Math.round(getLargeArcLength(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину малой дуги (smallArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getSmallArcLength(double width, double formIndication) {
        double smallArcRadius = getSmallArcRadius(width, formIndication);
        double beta = getBetaRadian(width, formIndication);

        return smallArcRadius * beta;
    }

    public static int getScaleSmallArcLength(double width, double formIndication, int scale) {
        return (int) (Math.round(getSmallArcLength(width, formIndication) * scale));
    }

    /**
     * Этот метод вычисляет длину свода (lengthArc).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public static double getLengthArc(double width, double formIndication) {
        double smallArcLength = getSmallArcLength(width, formIndication);
        double largeArcLength = getLargeArcLength(width, formIndication);

        return 2.0 * smallArcLength + largeArcLength;
    }

    public static int getScaleLengthArc(double width, double formIndication, int scale) {
        return (int) (Math.round(getLengthArc(width, formIndication) * scale));
    }
}