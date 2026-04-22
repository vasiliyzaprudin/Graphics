package com.mining.graphics.graphics.support.intersection;

import java.awt.*;

public class DrawMeshIntersection {
    public static void drawPlanMesh(Graphics2D g2d, int x1, int y1, int x2, int y2) {

        g2d.setColor(Color.BLACK);
        float[] dashPattern = {10.0f, 5.0f};
        BasicStroke mesh = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(mesh);

        g2d.drawLine(x1, y1, x2, y2);
    }
}
