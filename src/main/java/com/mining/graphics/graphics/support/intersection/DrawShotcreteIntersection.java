package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.service.GeneralService;

import java.awt.*;

public class DrawShotcreteIntersection {

    public static void drawPlanRoundingShotcrete(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(new Color(200, 200, 200));

        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void drawPlanLineShotcreteExcavation(Graphics2D g2d, double projectionX, double projectionY, double startRoundingX,
                                                       double startRoundingY) {
        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(new Color(200, 200, 200));

        int x1 = GeneralService.toScaleIntersectionParameter(startRoundingX);
        int y1 = GeneralService.toScaleIntersectionParameter(startRoundingY);
        int x2 = GeneralService.toScaleIntersectionParameter(projectionX);
        int y2 = GeneralService.toScaleIntersectionParameter(projectionY);

        //Math.abs(startRoundingY - projectionY) > 0.01 - исключает построение, когда координаты по Y почти одинаковые в выработках 2 и 3
        if (startRoundingY > 0 || (Math.abs(startRoundingY - projectionY) > 0.01 && startRoundingY < 0 && startRoundingY > projectionY)){
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    public static void drawProfileShotcrete(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6,
                                            int y6) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;

        g2d.translate(0, distance);

        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(new Color(200, 200, 200));

        //g2d.drawLine(x4, y4, x5, y5);
        g2d.drawLine(x5, y5, x6, y6);

        g2d.translate(0, -distance);
    }
}
