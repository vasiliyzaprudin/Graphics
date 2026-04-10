package com.mining.graphics.model.excavation;

public class CoordinatesIntersectionRounding {
    private final double xPointIntersectionExcavations;
    private final double yPointIntersectionExcavations;
    private final double xStartRounding;
    private final double yStartRounding;
    private final double xIntersectionAxisAndStope;
    private final double yIntersectionAxisAndStope;

    public CoordinatesIntersectionRounding(double xPointIntersectionExcavations, double yPointIntersectionExcavations,
                                           double xStartRounding, double yStartRounding,
                                           double xIntersectionAxisAndStope, double yIntersectionAxisAndStope) {
        this.xPointIntersectionExcavations = xPointIntersectionExcavations;
        this.yPointIntersectionExcavations = yPointIntersectionExcavations;
        this.xStartRounding = xStartRounding;
        this.yStartRounding = yStartRounding;
        this.xIntersectionAxisAndStope = xIntersectionAxisAndStope;
        this.yIntersectionAxisAndStope = yIntersectionAxisAndStope;
    }
    // @formatter:off
    public double getXPointIntersection() { return xPointIntersectionExcavations; }
    public double getYPointIntersection() { return yPointIntersectionExcavations; }
    public double getXStartRounding() { return xStartRounding; }
    public double getYStartRounding() { return yStartRounding; }
    public double getXIntersectionAxisAndStope() { return xIntersectionAxisAndStope; }
    public double getYIntersectionAxisAndStope() { return yIntersectionAxisAndStope; }
    // @formatter:on
}