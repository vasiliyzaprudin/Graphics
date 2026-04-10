package com.mining.graphics.model.excavation;

public class CoordinatesIntersectionLine {
    private final double xStartRounding1;
    private final double yStartRounding1;
    private final double xStope1;
    private final double yStope1;
    private final double xIntersectionAxisAndStope;
    private final double yIntersectionAxisAndStope;
    private final double xStartRounding2;
    private final double yStartRounding2;
    private final double xStope2;
    private final double yStope2;

    public CoordinatesIntersectionLine(double xStartRounding1, double yStartRounding1, double xStope1, double yStope1,
                                       double xIntersectionAxisAndStope, double yIntersectionAxisAndStope,
                                       double xStartRounding2, double yStartRounding2, double xStope2, double yStope2) {
        this.xStartRounding1 = xStartRounding1;
        this.yStartRounding1 = yStartRounding1;
        this.xStope1 = xStope1;
        this.yStope1 = yStope1;
        this.xIntersectionAxisAndStope = xIntersectionAxisAndStope;
        this.yIntersectionAxisAndStope = yIntersectionAxisAndStope;
        this.xStartRounding2 = xStartRounding2;
        this.yStartRounding2 = yStartRounding2;
        this.xStope2 = xStope2;
        this.yStope2 = yStope2;
    }

    // @formatter:off
    public double getXStartRounding1() { return xStartRounding1; }
    public double getYStartRounding1() { return yStartRounding1; }
    public double getXStope1() { return xStope1; }
    public double getYStope1() { return yStope1; }
    public double getXIntersectionAxisAndStope() { return xIntersectionAxisAndStope; }
    public double getYIntersectionAxisAndStope() { return yIntersectionAxisAndStope; }
    public double getXStartRounding2() { return xStartRounding2; }
    public double getYStartRounding2() { return yStartRounding2; }
    public double getXStope2() { return xStope2; }
    public double getYStope2() { return yStope2; }
    // @formatter:on
}