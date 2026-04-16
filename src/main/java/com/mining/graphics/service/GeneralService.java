package com.mining.graphics.service;

import com.mining.graphics.graphics.GraphicsParameters;

public class GeneralService {
    public static double distanceBetweenPoint(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    public static double angleBetweenLines(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return Math.acos(((x2 - x1) * (x4 - x3) + (y2 - y1) * (y4 - y3)) / ((Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))) * (Math.sqrt((x4 - x3) * (x4 - x3) + (y4 - y3) * (y4 - y3)))));
    }
    public static int toScaleParameter(double parameter) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        return (int) (Math.round(parameter * scale));
    }
}
