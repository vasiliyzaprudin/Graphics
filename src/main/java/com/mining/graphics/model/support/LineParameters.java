package com.mining.graphics.model.support;

public class LineParameters {
    private final double xStartRounding;
    private final double yStartRounding;
    private final double xStope;
    private final double yStope;
    private final double xStartRounding2;
    private final double yStartRounding2;
    private final double xStope2;
    private final double yStope2;
    private final double distanceBetweenRows;
    private final double lengthAnchor;
    private final double azimuthRadians;

    // @formatter:off
    public LineParameters(double xStartRounding, double yStartRounding, double xStope, double yStope,
                          double xStartRounding2, double yStartRounding2, double xStope2, double yStope2,
                          double distanceBetweenRows, double lengthAnchor, double azimuthRadians) {
        this.xStartRounding = xStartRounding;
        this.yStartRounding = yStartRounding;
        this.xStope = xStope;
        this.yStope = yStope;
        this.xStartRounding2 = xStartRounding2;
        this.yStartRounding2 = yStartRounding2;
        this.xStope2 = xStope2;
        this.yStope2 = yStope2;
        this.distanceBetweenRows = distanceBetweenRows;
        this.lengthAnchor = lengthAnchor;
        this.azimuthRadians = azimuthRadians;
    }

    public double getXStartRounding() { return xStartRounding; }
    public double getYStartRounding() { return yStartRounding; }
    public double getXStope() { return xStope; }
    public double getYStope() { return yStope; }
    public double getXStartRounding2() { return xStartRounding2; }
    public double getYStartRounding2() { return yStartRounding2; }
    public double getXStope2() { return xStope2; }
    public double getYStope2() { return yStope2; }
    public double getDistanceBetweenRows() { return distanceBetweenRows; }
    public double getLengthAnchor() { return lengthAnchor; }
    public double getAzimuthRadians() { return azimuthRadians; }
    // @formatter:on
}