package com.mining.graphics.model.support;

public class AnchorsExcavation {

    private double lengthAnchor = 2.0;
    private double step = 0.9;
    private double distanceBetweenRows = 0.9;
    private double plateSize = 0.15;
    //private double anchorDiameter = 0.03; //диаметр анкера
    private double distanceLowerAnchor = 1.8; //максимальное расстояние от почвы выработки до точки установки нижнего анкера

    private double[][] crossSectionAnchorsXY; //анкеры в поперечном сечении
    private double[][] longSectionAnchorsXY; //анкеры в продольном сечении
    private double[][] basePlateXY; //опорные плиты

    private double bottomAnchorY;

    double firstCrossSectionAnchorX;
    double firstCrossSectionAnchorY;
    double secondCrossSectionAnchorX;
    double secondCrossSectionAnchorY;

    double firstLongSectionAnchorX;
    double firstLongSectionAnchorY;
    double secondLongSectionAnchorX;
    double secondLongSectionAnchorY;

    public static class AnchorPoint {
        private final double startX;
        private final double startY;
        private final double endX;
        private final double endY;

        public AnchorPoint(double startX, double startY, double endX, double endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public double getStartX() {
            return startX;
        }

        public double getStartY() {
            return startY;
        }

        public double getEndX() {
            return endX;
        }

        public double getEndY() {
            return endY;
        }
    }

    public static class BasePlatePoint {
        private final double x;
        private final double y;

        public BasePlatePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    //Геттеры
    public double getLengthAnchor() {
        return lengthAnchor;
    }

    public double getStep() {
        return step;
    }

    public double getDistanceBetweenRows() {
        return distanceBetweenRows;
    }

    public double getPlateSize() {
        return plateSize;
    }


    public double getDistanceLowerAnchor() {
        return distanceLowerAnchor;
    }

    public double getBottomAnchorY() {
        return bottomAnchorY;
    }

    public double getFirstcrossSectionAnchorX() {
        return firstCrossSectionAnchorX;
    }

    public double getFirstcrossSectionAnchorY() {
        return firstCrossSectionAnchorY;
    }

    public double getSecondcrossSectionAnchorX() {
        return secondCrossSectionAnchorX;
    }

    public double getSecondcrossSectionAnchorY() {
        return secondCrossSectionAnchorY;
    }

    public double getFirstLongSectionAnchorX() {
        return firstLongSectionAnchorX;
    }

    public double getFirstLongSectionAnchorY() {
        return firstLongSectionAnchorY;
    }

    public double getSecondLongSectionAnchorX() {
        return secondLongSectionAnchorX;
    }

    public double getSecondLongSectionAnchorY() {
        return secondLongSectionAnchorY;
    }

    //Сеттеры
    public void setLengthAnchor(double lengthAnchor) {
        this.lengthAnchor = lengthAnchor;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public void setDistanceBetweenRows(double distanceBetweenRows) {
        this.distanceBetweenRows = distanceBetweenRows;
    }

    public void setPlateSize(double plateSize) {
        this.plateSize = plateSize;
    }


    public void setDistanceLowerAnchor(double distanceLowerAnchor) {
        this.distanceLowerAnchor = distanceLowerAnchor;
    }


    public double[][] getCrossSectionAnchorsXY() {
        return crossSectionAnchorsXY;
    }

    public void setCrossSectionAnchorsXY(double[][] crossSectionAnchorsXY) {
        this.crossSectionAnchorsXY = crossSectionAnchorsXY;
    }

    public double[][] getLongSectionAnchorsXY() {
        return longSectionAnchorsXY;
    }

    public void setLongSectionAnchorsXY(double[][] longSectionAnchorsXY) {
        this.longSectionAnchorsXY = longSectionAnchorsXY;
    }

    public double[][] getBasePlateXY() {
        return basePlateXY;
    }

    public void setBasePlateXY(double[][] basePlateXY) {
        this.basePlateXY = basePlateXY;
    }

    public void setBottomAnchorY(double bottomAnchorY) {
        this.bottomAnchorY = bottomAnchorY;
    }

    public void setFirstCrossSectionAnchorX(double firstAnchorX) {
        this.firstCrossSectionAnchorX = firstAnchorX;
    }

    public void setFirstCrossSectionAnchorY(double firstAnchorY) {
        this.firstCrossSectionAnchorY = firstAnchorY;
    }

    public void setSecondCrossSectionAnchorX(double secondAnchorX) {
        this.secondCrossSectionAnchorX = secondAnchorX;
    }

    public void setSecondCrossSectionAnchorY(double secondAnchorY) {
        this.secondCrossSectionAnchorY = secondAnchorY;
    }

    public void setFirstLongSectionAnchorX(double firstLongSectionAnchorX) {
        this.firstLongSectionAnchorX = firstLongSectionAnchorX;
    }

    public void setFirstLongSectionAnchorY(double firstLongSectionAnchorY) {
        this.firstLongSectionAnchorY = firstLongSectionAnchorY;
    }

    public void setSecondLongSectionAnchorX(double secondLongSectionAnchorX) {
        this.secondLongSectionAnchorX = secondLongSectionAnchorX;
    }

    public void setSecondLongSectionAnchorY(double secondLongSectionAnchorY) {
        this.secondLongSectionAnchorY = secondLongSectionAnchorY;
    }
}