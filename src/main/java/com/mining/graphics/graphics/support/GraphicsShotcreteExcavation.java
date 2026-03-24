package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceShotcreteExcavation;

import java.awt.*;

public class GraphicsShotcreteExcavation extends ServiceShotcreteExcavation {

//    int heightCorrectDrawShorcrete = -8; //графический корректировочный параметр отображения набрызгбетона
//
//    public void graphicsShotcrete(Graphics g) {
//        calculateParametersExcavationScale(widthExcavationWithShotcrete, heightExcavationWithShotcrete, length, formIndication, GRAPHICS_SCALE);
//        drawCrossSectionExcavationShotcrete(g);
//        drawLongSectionExcavationShotcrete(g);
//    }
//
//    /**
//     * Это метод изображения набрызгбетона на поперечном сечении горной выработки.
//     * Начало координат находится в центре почвы горной выработки.
//     */
//    public void drawCrossSectionExcavationShotcrete(Graphics g) {
//        ((Graphics2D) g).setStroke(new BasicStroke(16));
//
//        g.drawLine(-scaleWidth / 2, heightCorrectDrawShorcrete, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
//        g.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 90 + alphaDegree, betaDegree); //Левая малая дуга
//        g.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, betaDegree, 2 * alphaDegree); //Большая дуга
//        g.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, betaDegree); //Правая малая дуга
//        g.drawLine(scaleWidth / 2, heightCorrectDrawShorcrete, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка
//
//        ((Graphics2D) g).setStroke(new BasicStroke(1));
//    }
//
//    /**
//     * Это метод изображения набрызгбетона на продольном сечении горной выработки.
//     */
//    public void drawLongSectionExcavationShotcrete(Graphics g) {
//        g.translate(DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//        ((Graphics2D) g).setStroke(new BasicStroke(14));
//
//        g.drawLine(-heightCorrectDrawShorcrete, -scaleHeight, scaleLength + heightCorrectDrawShorcrete, -scaleHeight);
//
//        g.translate(-DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//        ((Graphics2D) g).setStroke(new BasicStroke(1));
//    }
//

}
