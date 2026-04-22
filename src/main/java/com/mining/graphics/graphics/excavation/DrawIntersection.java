package com.mining.graphics.graphics.excavation;

import com.mining.graphics.graphics.GraphicsParameters;

import java.awt.*;

public class DrawIntersection {

    public static void drawContourLine(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void drawAxis(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.GRAY);

        int centerX = 0;
        int centerY = 0;

        g2d.drawLine(centerX, centerY, x, y);
    }

    public static void drawProfileExcavation(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6,
                                       int y6) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, x3, y3);
        g2d.drawLine(x3, y3, x4, y4);
        g2d.drawLine(x4, y4, x5, y5);
        g2d.drawLine(x5, y5, x6, y6);

        g2d.drawLine(x2, y2, x5, y5);

        g2d.translate(0, -distance);
    }
}
