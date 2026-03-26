package com.mining.graphics.model.support;

public class AnchorsExcavation {

    private double lengthAnchor = 2.0;
    private double step = 0.6;
    private double distanceBetweenRows = 0.9;
    private double plateSize = 0.15;
    private double anchorDiameter = 0.1; //диаметр анкера
    private double distanceLowerAnchor = 1.8; //максимальное расстояние от почвы выработки до точки установки нижнего анкера

    private double[][] crossSectionAnchorsXY; //анкеры в поперечном сечении
    private double[][] longSectionAnchorsXY; //анкеры в продольном сечении
    private double[][] basePlateXY; //опорные плиты

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

    public double getAnchorDiameter() {
        return anchorDiameter;
    }

    public double getDistanceLowerAnchor() {
        return distanceLowerAnchor;
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

    public void setAnchorDiameter(double anchorDiameter) {
        this.anchorDiameter = anchorDiameter;
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
}