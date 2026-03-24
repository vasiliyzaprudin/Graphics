package com.mining.graphics.graphics.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

public class GraphicsExcavation {
    private final ModelExcavation modelExcavation;
    private final ServiceExcavation serviceExcavation;

    public GraphicsExcavation(ModelExcavation modelExcavation, ServiceExcavation serviceExcavation) {
        this.modelExcavation = modelExcavation;
        this.serviceExcavation = serviceExcavation;
    }

    /**
     * Построение поперечного сечения.
     * Начало координат находится в центре ее почвы.
     */
    public void drawCrossSectionExcavation(Graphics g) {
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();
        int scale = GraphicsParameters.GRAPHICS_SCALE;

        int scaleWidth = serviceExcavation.getScaleWidth(width, scale);
        int scaleHeight = serviceExcavation.getScaleHeight(height, scale);
        int scaleArchHeight = serviceExcavation.getScaleArchHeight(width, formIndication, scale);
        int scaleSmallArcRadius = serviceExcavation.getScaleSmallArcRadius(width, formIndication, scale);
        int scaleLargeArcRadius = serviceExcavation.getScaleLargeArcRadius(width, formIndication, scale);
        int alphaDegree = serviceExcavation.getAlphaDegree(width, formIndication);
        int betaDegree = serviceExcavation.getBetaDegree(width, formIndication);

        g.drawLine(-scaleWidth / 2, 0, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 90 + alphaDegree, betaDegree); //Левая малая дуга
        g.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, betaDegree, 2 * alphaDegree); //Большая дуга
        g.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, betaDegree); //Правая малая дуга
        g.drawLine(scaleWidth / 2, 0, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка
        g.drawLine(-scaleWidth / 2, 0, scaleWidth / 2, 0); //Почва
    }

    /**
     * Построение продольного сечения горной выработки.
     */
    public void drawLongSectionExcavation(Graphics g) {
        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();
        int scale = GraphicsParameters.GRAPHICS_SCALE;

        int scaleHeight = serviceExcavation.getScaleHeight(height, scale);
        int scaleLength = serviceExcavation.getScaleLength(length, scale);
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        g.translate(distance, 0);

        g.drawLine(0, 0, 0, -scaleHeight);
        g.drawLine(0, -scaleHeight, scaleLength, -scaleHeight);
        g.drawLine(scaleLength, -scaleHeight, scaleLength, 0);
        g.drawLine(scaleLength, 0, 0, 0);

        g.translate(-distance, 0);

    }
}