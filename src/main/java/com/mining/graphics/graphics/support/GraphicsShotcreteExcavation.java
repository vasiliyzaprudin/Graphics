package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.ShotcreteExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.ServiceShotcreteExcavation;

import java.awt.*;

public class GraphicsShotcreteExcavation extends ServiceShotcreteExcavation {

    private final int heightCorrectDrawShorcrete = -5; //графический корректировочный параметр отображения набрызгбетона

    private final ModelExcavation modelExcavation;
    private final ShotcreteExcavation shotcreteExcavation;
    private final ServiceExcavation serviceExcavation;
    private final ServiceShotcreteExcavation serviceShotcreteExcavation;

    public GraphicsShotcreteExcavation(ModelExcavation modelExcavation,
                                       ShotcreteExcavation shotcreteExcavation,
                                       ServiceExcavation serviceExcavation,
                                       ServiceShotcreteExcavation serviceShotcreteExcavation) {
        this.modelExcavation = modelExcavation;
        this.shotcreteExcavation = shotcreteExcavation;
        this.serviceExcavation = serviceExcavation;
        this.serviceShotcreteExcavation = serviceShotcreteExcavation;
    }



    /**
     * Это метод изображения набрызгбетона на поперечном сечении горной выработки.
     * Начало координат находится в центре почвы горной выработки.
     */
    public void drawCrossSectionExcavationShotcrete(Graphics g) {

        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();

        double widthWithShotcrete = serviceShotcreteExcavation.getWidthExcavationWithShotcrete(width, thicknessShorcrete);
        double heightWithShotcrete = serviceShotcreteExcavation.getHeightExcavationWithShotcrete(height, thicknessShorcrete);
        double formIndication = modelExcavation.getFormIndication();
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;

        int scaleWidth = serviceExcavation.getScaleWidth(widthWithShotcrete, scale);
        int scaleHeight = serviceExcavation.getScaleHeight(heightWithShotcrete, scale);
        int scaleArchHeight = serviceExcavation.getScaleArchHeight(widthWithShotcrete, formIndication, scale);
        int scaleSmallArcRadius = serviceExcavation.getScaleSmallArcRadius(widthWithShotcrete, formIndication, scale);
        int scaleLargeArcRadius = serviceExcavation.getScaleLargeArcRadius(widthWithShotcrete, formIndication, scale);
        double alphaDegree = serviceExcavation.getAlphaDegree(widthWithShotcrete, formIndication);
        double betaDegree = serviceExcavation.getBetaDegree(widthWithShotcrete, formIndication);

        ((Graphics2D) g).setStroke(new BasicStroke(10));
        g.drawLine(-scaleWidth / 2, heightCorrectDrawShorcrete, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, (int) Math.round(90 + alphaDegree), (int) Math.round(betaDegree)); //Левая малая дуга
        g.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, (int) Math.round(betaDegree), (int) Math.round(2 * alphaDegree)); //Большая дуга
        g.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, (int) Math.round(betaDegree)); //Правая малая дуга
        g.drawLine(scaleWidth / 2, heightCorrectDrawShorcrete, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка
    }

    /**
     * Это метод изображения набрызгбетона на продольном сечении горной выработки.
     */
    public void drawLongSectionExcavationShotcrete(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();
        double thicknessShorcrete = shotcreteExcavation.getThicknessShorcrete();

        int scaleHeightExcavationWithShotcrete = serviceShotcreteExcavation.getScaleHeightExcavationWithShotcrete(height,thicknessShorcrete, scale);
        int scaleLengthExcavationWithShotcrete = serviceExcavation.getScaleLength(length,scale);

        g.translate(distance, 0);
        ((Graphics2D) g).setStroke(new BasicStroke(10));

        g.drawLine(-heightCorrectDrawShorcrete, -scaleHeightExcavationWithShotcrete, scaleLengthExcavationWithShotcrete + heightCorrectDrawShorcrete, -scaleHeightExcavationWithShotcrete);

        g.translate(-distance, 0);
        ((Graphics2D) g).setStroke(new BasicStroke(1));
    }
}
