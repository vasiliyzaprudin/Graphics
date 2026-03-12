package com.mining.graphics.service.excavation;

import com.mining.graphics.model.excavation.ModelExcavation;

public class ServiceExcavation extends ModelExcavation {
    public int alphaDegree;
    public int betaDegree;

    public double alphaRadian;
    public double betaRadian;

    //Линейные параметры горной выработки
    public double archHeight;
    public double largeArcRadius;
    public double smallArcRadius;
    public double largeArcLength;
    public double smallArcLength;
    public double lengthArc;

    //Линейные параметры горной выработки в масштабе
    public int scaleWidth;
    public int scaleHeight;
    public int scaleArchHeight;
    public int scaleLargeArcRadius;
    public int scaleSmallArcRadius;
    public int scaleLargeArcLength;
    public int scaleSmallArcLength;
    public int scaleLengthArc;

    //Методы расчета геометрических параметров горной выработки

    /**
     * Этот метод вычисляет высоту закругления свода горной выработки (archHeight).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateArchHeight(double width, double formIndication) {
        return width / formIndication;
    }

    /**
     * Этот метод вычисляет опорный угол дуги большого радиуса (alpha).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateAlpha(double width, double formIndication) {
        return Math.atan(2.0 * calculateArchHeight(width, formIndication) / width);
    }

    /**
     * Этот метод вычисляет опорный угол дуги малого радиуса (beta).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateBeta(double width, double formIndication) {
        return Math.PI / 2.0 - calculateAlpha(width, formIndication);

    }

    /**
     * Этот метод вычисляет величину большого радиуса (largeArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateLargeArcRadius(double width, double formIndication) {
        double archHeight = calculateArchHeight(width, formIndication);
        double alpha = calculateAlpha(width, formIndication);

        return (archHeight / Math.cos(alpha) - width / 2.0 - archHeight * Math.tan(alpha)) / (1.0 / Math.cos(alpha) - 1 - Math.tan(alpha));
    }


    /**
     * Этот метод вычисляет величину малого радиуса (smallArcRadius).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateSmallArcRadius(double width, double formIndication) {
        double largeRadius = calculateLargeArcRadius(width, formIndication);
        double archHeight = calculateArchHeight(width, formIndication);
        double alpha = calculateAlpha(width, formIndication);

        return largeRadius - (largeRadius - archHeight) / Math.cos(alpha);
    }


    /**
     * Этот метод вычисляет длину малой дуги (smallArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateSmallArcLength(double width, double formIndication) {
        double smallArcRadius = calculateSmallArcRadius(width, formIndication);
        double beta = calculateBeta(width, formIndication);

        return smallArcRadius * beta;
    }

    /**
     * Этот метод вычисляет длину большой дуги (largeArcLength).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateLargeArcLength(double width, double formIndication) {
        double largeArcRadius = calculateLargeArcRadius(width, formIndication);
        double alpha = calculateAlpha(width, formIndication);

        return 2.0 * largeArcRadius * alpha;
    }

    /**
     * Этот метод вычисляет длину свода (lengthArc).
     *
     * @param width          ширина горной выработки
     * @param formIndication коэффициент формы свода
     */
    public double calculateLengthArc(double width, double formIndication) {
        double smallArcLength = calculateSmallArcLength(width, formIndication);
        double largeArcLength = calculateLargeArcLength(width, formIndication);

        return 2.0 * smallArcLength + largeArcLength;
    }
    /**
     * Этот метод объединяет и все параметры,
     * необходимые для графического построения поперечного сечения горной выработки.
     * Углы alpha и beta в радианах.
     *
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param formIndication коэффициент формы свода
     * @param scale          масштаб графических построений
     */
    public void calculateParameters(double width, double height, double formIndication, double scale) {

        alphaRadian = calculateAlpha(width, formIndication);
        betaRadian = calculateBeta(width, formIndication);

        archHeight = calculateArchHeight(width, formIndication);
        largeArcRadius = calculateLargeArcRadius(width, formIndication);
        smallArcRadius = calculateSmallArcRadius(width, formIndication);
        largeArcLength = calculateLargeArcLength(width, formIndication);
        smallArcLength = calculateSmallArcLength(width, formIndication);
        lengthArc = calculateLengthArc(width, formIndication);
    }


    /**
     * Этот метод объединяет и масштабирует все параметры,
     * необходимые для графического построения поперечного сечения горной выработки.
     * Углы alpha и beta переводятся в градусы.
     *
     * @param width          ширина горной выработки
     * @param height         высота горной выработки
     * @param formIndication коэффициент формы свода
     * @param scale          масштаб графических построений
     */
    public void calculateParametersScale(double width, double height, double formIndication, double scale) {
        // Переводим углы в градусы для графики
        alphaDegree = (int) (Math.round(calculateAlpha(width, formIndication) * 180.0 / Math.PI));
        betaDegree = (int) (Math.round(calculateBeta(width, formIndication) * 180.0 / Math.PI));

        // Масштабируем линейные размеры
        scaleWidth = (int) (Math.round(width * scale));
        scaleHeight = (int) (Math.round(height * scale));
        scaleArchHeight = (int) (Math.round(calculateArchHeight(width, formIndication) * scale));
        scaleLargeArcRadius = (int) (Math.round(calculateLargeArcRadius(width, formIndication) * scale));
        scaleSmallArcRadius = (int) (Math.round(calculateSmallArcRadius(width, formIndication) * scale));
        scaleLargeArcLength = (int) (Math.round(calculateLargeArcLength(width, formIndication) * scale));
        scaleSmallArcLength = (int) (Math.round(calculateSmallArcLength(width, formIndication) * scale));
        scaleLengthArc = (int) (Math.round(calculateLengthArc(width, formIndication) * scale));
    }
}