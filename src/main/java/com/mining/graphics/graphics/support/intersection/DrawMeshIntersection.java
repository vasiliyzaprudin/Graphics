package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.service.GeneralService;

import java.awt.*;

public class DrawMeshIntersection {
    public static void drawPlanWallMesh(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.BLACK);
        float[] dashPattern = {10.0f, 5.0f};
        BasicStroke mesh = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(mesh);

        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void drawPlanLineMeshExcavation(Graphics2D g2d, double projectionX, double projectionY, double startRoundingX,
                                                       double startRoundingY) {
        g2d.setColor(Color.BLACK);
        float[] dashPattern = {10.0f, 5.0f};
        BasicStroke mesh = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(mesh);

        int x1 = GeneralService.toScaleIntersectionParameter(startRoundingX);
        int y1 = GeneralService.toScaleIntersectionParameter(startRoundingY);
        int x2 = GeneralService.toScaleIntersectionParameter(projectionX);
        int y2 = GeneralService.toScaleIntersectionParameter(projectionY);

        //Math.abs(startRoundingY - projectionY) > 0.01 - исключает построение, когда координаты по Y почти одинаковые в выработках 2 и 3
        if (startRoundingY > 0 || (Math.abs(startRoundingY - projectionY) > 0.01 && startRoundingY < 0 && startRoundingY > projectionY)){
            g2d.drawLine(x1, y1, x2, y2);
        }
    }




    public static void drawProfileRoofMesh(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6,
                                           int y6) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        g2d.setColor(Color.BLACK);
        float[] dashPattern = {10.0f, 5.0f};
        BasicStroke mesh = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        //g2d.drawLine(x4, y4, x5, y5);
        g2d.drawLine(x5, y5, x6, y6);

        g2d.translate(0, -distance);
    }
    public static void drawProfileWallMesh(Graphics2D g2d, double xBottomRight, double xBottomLeft, double height, double distanceBetweenSoilAndMesh,
                                           double gridStep) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;

        int scaleHeight = GeneralService.toScaleIntersectionParameter(height);
        int scaleDistanceBetweenSoilAndMesh = GeneralService.toScaleIntersectionParameter(distanceBetweenSoilAndMesh);
        int scaleGridStep = GeneralService.toScaleIntersectionParameter(gridStep);
        int scaleLength = GeneralService.toScaleIntersectionParameter(xBottomRight - xBottomLeft);
        int scaleXBottomRight = GeneralService.toScaleIntersectionParameter(xBottomRight);
        int scaleXBottomLeft = GeneralService.toScaleIntersectionParameter(xBottomLeft);

        float[] dashPattern = {7.0f, 3.0f};
        BasicStroke mesh = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(mesh);
        g2d.translate(0, distance);
        g2d.setColor(new Color(120, 130, 140));

        for (int i = 0; scaleHeight - scaleDistanceBetweenSoilAndMesh >= i * scaleGridStep; i++) {
            int x1 = scaleXBottomLeft;
            int y1 = -scaleDistanceBetweenSoilAndMesh - i * scaleGridStep;
            int x2 = scaleXBottomRight;
            int y2 =-scaleDistanceBetweenSoilAndMesh - i * scaleGridStep;

            g2d.drawLine(x1, y1, x2, y2);
        }

        for (int i = 1; scaleLength >= i * scaleGridStep; i++) {
            int x1 = scaleXBottomLeft + i * scaleGridStep;
            int y1 = -scaleHeight;
            int x2 = scaleXBottomLeft + i * scaleGridStep;
            int y2 =-scaleDistanceBetweenSoilAndMesh;

            g2d.drawLine(x1, y1, x2, y2);
        }

        g2d.translate(0, -distance);
        g2d.setStroke(new BasicStroke(1));
    }
}
