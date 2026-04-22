package com.mining.graphics.graphics.support.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.ShotcreteExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.excavation.ServiceShotcreteExcavation;

import java.awt.*;

public class GraphicsShotcreteExcavation extends ServiceShotcreteExcavation {

    private final int heightCorrectDrawShorcrete = -5; //графический корректировочный параметр отображения набрызгбетона

    private final ModelExcavation modelExcavation;
    private final ShotcreteExcavation shotcreteExcavation;

    public GraphicsShotcreteExcavation(ModelExcavation modelExcavation, ShotcreteExcavation shotcreteExcavation) {
        this.modelExcavation = modelExcavation;
        this.shotcreteExcavation = shotcreteExcavation;
    }

    public void drawCrossSectionExcavationShotcrete(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;

        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();

        double widthWithShotcrete = ServiceShotcreteExcavation.getWidthExcavationWithShotcrete(width, thicknessShorcrete);
        double heightWithShotcrete = ServiceShotcreteExcavation.getHeightExcavationWithShotcrete(height, thicknessShorcrete);

        int scaleWidth = ServiceExcavation.scaleWidth(widthWithShotcrete, scale);
        int scaleHeight = ServiceExcavation.scaleHeight(heightWithShotcrete, scale);
        int scaleArchHeight = ServiceExcavation.scaleArchHeight(widthWithShotcrete, formIndication, scale);
        int scaleSmallArcRadius = ServiceExcavation.scaleSmallArcRadius(widthWithShotcrete, formIndication, scale);
        int scaleLargeArcRadius = ServiceExcavation.scaleLargeArcRadius(widthWithShotcrete, formIndication, scale);
        double alphaDegree = ServiceExcavation.alphaDegree(widthWithShotcrete, formIndication);
        double betaDegree = ServiceExcavation.betaDegree(widthWithShotcrete, formIndication);

        ((Graphics2D) g).setStroke(new BasicStroke(10));
        g.drawLine(-scaleWidth / 2, heightCorrectDrawShorcrete, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, (int) Math.round(90 + alphaDegree), (int) Math.round(betaDegree)); //Левая малая дуга
        g.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, (int) Math.round(betaDegree), (int) Math.round(2 * alphaDegree)); //Большая дуга
        g.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, (int) Math.round(betaDegree)); //Правая малая дуга
        g.drawLine(scaleWidth / 2, heightCorrectDrawShorcrete, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка
    }

    public void drawLongSectionExcavationShotcrete(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();
        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();

        int scaleHeightExcavationWithShotcrete = ServiceShotcreteExcavation.getScaleHeightExcavationWithShotcrete(height, thicknessShorcrete, scale);
        int scaleLengthExcavationWithShotcrete = ServiceExcavation.scaleLength(length, scale);

        g.translate(distance, 0);
        ((Graphics2D) g).setStroke(new BasicStroke(10));

        g.drawLine(-heightCorrectDrawShorcrete, -scaleHeightExcavationWithShotcrete, scaleLengthExcavationWithShotcrete + heightCorrectDrawShorcrete, -scaleHeightExcavationWithShotcrete);

        g.translate(-distance, 0);
        ((Graphics2D) g).setStroke(new BasicStroke(1));
    }
}