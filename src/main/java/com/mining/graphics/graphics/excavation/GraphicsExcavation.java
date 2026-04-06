package com.mining.graphics.graphics.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;

import java.awt.*;

import static com.mining.graphics.service.excavation.ServiceExcavation.*;

public class GraphicsExcavation {
    private final ModelExcavation modelExcavation;

    public GraphicsExcavation(ModelExcavation modelExcavation) {
        this.modelExcavation = modelExcavation;
    }

    public void drawCrossSectionExcavation(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        renderCrossSectionExcavation(g2d, modelExcavation.getWidth(), modelExcavation.getHeight(), modelExcavation.getFormIndication(), GraphicsParameters.GRAPHICS_EXCAVATION_SCALE);
    }

    public void renderCrossSectionExcavation(Graphics2D g2d, double width, double height, double formIndication, int scale) {

        int scaleWidth = getScaleWidth(width, scale);
        int scaleHeight = getScaleHeight(height, scale);
        int scaleArchHeight = getScaleArchHeight(width, formIndication, scale);

        int scaleSmallArcRadius = getScaleSmallArcRadius(width, formIndication, scale);
        int scaleLargeArcRadius = getScaleLargeArcRadius(width, formIndication, scale);

        double alphaDegree = getAlphaDegree(width, formIndication);
        double betaDegree = getBetaDegree(width, formIndication);

        g2d.drawLine((int) (Math.round(-scaleWidth / 2.0)), 0, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g2d.drawArc((int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, (int) Math.round(90 + alphaDegree), (int) Math.round(betaDegree)); //Левая малая дуга
        g2d.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, (int) Math.round(betaDegree), (int) Math.round(2 * alphaDegree)); //Большая дуга
        g2d.drawArc((int) (Math.round(scaleWidth / 2.0)) - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, (int) Math.round(betaDegree)); //Правая малая дуга
        g2d.drawLine((int) (Math.round(scaleWidth / 2.0)), 0, (int) (Math.round(scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Правая стенка
        g2d.drawLine((int) (Math.round(-scaleWidth / 2.0)), 0, (int) (Math.round(scaleWidth / 2.0)), 0); //Почва
    }

    public void drawLongSectionExcavation(Graphics g) {
        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;

        int scaleHeight = getScaleHeight(height, scale);
        int scaleLength = getScaleLength(length, scale);
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        g.translate(distance, 0);

        g.drawLine(0, 0, 0, -scaleHeight);
        g.drawLine(0, -scaleHeight, scaleLength, -scaleHeight);
        g.drawLine(scaleLength, -scaleHeight, scaleLength, 0);
        g.drawLine(scaleLength, 0, 0, 0);

        g.translate(-distance, 0);

    }
}