package com.mining.graphics.model.support;

public class RoundingParameters {
    private final double xPointIntersection;
    private final double yPointIntersection;
    private final double xStartRounding;
    private final double yStartRounding;
    private final double xIntersectionAxisAndStope;
    private final double yIntersectionAxisAndStope;
    private final double azimuthRadians;
    private final double distanceBetweenRows;
    private final double lengthAnchor;

    public RoundingParameters(double xPointIntersection, double yPointIntersection, double xStartRounding, double yStartRounding,
                              double xIntersectionAxisAndStope, double yIntersectionAxisAndStope, double azimuthRadians,
                              double distanceBetweenRows, double lengthAnchor) {
        this.xPointIntersection = xPointIntersection;
        this.yPointIntersection = yPointIntersection;
        this.xStartRounding = xStartRounding;
        this.yStartRounding = yStartRounding;
        this.xIntersectionAxisAndStope = xIntersectionAxisAndStope;
        this.yIntersectionAxisAndStope = yIntersectionAxisAndStope;
        this.azimuthRadians = azimuthRadians;
        this.distanceBetweenRows = distanceBetweenRows;
        this.lengthAnchor = lengthAnchor;
    }
    // @formatter:off
    public double getXPointIntersection() { return xPointIntersection; }
    public double getYPointIntersection() { return yPointIntersection; }
    public double getXStartRounding() { return xStartRounding; }
    public double getYStartRounding() { return yStartRounding; }
    public double getXIntersectionAxisAndStope() { return xIntersectionAxisAndStope; }
    public double getYIntersectionAxisAndStope() { return yIntersectionAxisAndStope; }
    public double getAzimuthRadians() { return azimuthRadians; }
    public double getDistanceBetweenRows() { return distanceBetweenRows; }
    public double getLengthAnchor() { return lengthAnchor; }
    // @formatter:on
}