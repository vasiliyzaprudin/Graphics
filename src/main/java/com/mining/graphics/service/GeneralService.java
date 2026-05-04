package com.mining.graphics.service;

import com.mining.graphics.graphics.GraphicsParameters;

public class GeneralService {
    public static double distanceBetweenPoint(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    public static double angleBetweenLines(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return Math.acos(((x2 - x1) * (x4 - x3) + (y2 - y1) * (y4 - y3)) / ((Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))) * (Math.sqrt((x4 - x3) * (x4 - x3) + (y4 - y3) * (y4 - y3)))));
    }
    public static int toScaleIntersectionParameter(double parameter) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        return (int) (Math.round(parameter * scale));
    }

    public static int toScaleExcavationParameter(double parameter) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;
        return (int) (Math.round(parameter * scale));
    }

    public static double findProjectionX(double xPoint, double yPoint, double x1, double y1, double x2, double y2) {
        double dx = x2 - x1, dy = y2 - y1;
        double t = ((xPoint - x1) * dx + (yPoint - y1) * dy) / (dx * dx + dy * dy);
        return x1 + t * dx;
    }

    public static double findProjectionY(double xPoint, double yPoint, double x1, double y1, double x2, double y2) {
        double dx = x2 - x1, dy = y2 - y1;
        double t = ((xPoint - x1) * dx + (yPoint - y1) * dy) / (dx * dx + dy * dy);
        return y1 + t * dy;
    }
}
