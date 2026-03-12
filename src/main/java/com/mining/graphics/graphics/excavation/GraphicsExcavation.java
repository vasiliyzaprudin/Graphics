package com.mining.graphics.graphics.excavation;

import com.mining.graphics.model.support.ModelAnchorsExcavation;

import java.awt.*;

public class GraphicsExcavation extends ModelAnchorsExcavation {


    /**
     * Этот метод расчитывает геометрические параметры горной выработки
     * и строит ее на графическом холсте.
     */
    public void graphEx(Graphics g) {
        calculateParametersScale(width, height, formIndication, GRAPHICS_SCALE);
        drawExcavationSection(g);
    }

    /**
     * Это графический метод построения поперечного сечения горной выработки.
     * Начало координат находится в центре ее почвы.
     */
    public void drawExcavationSection(Graphics g) {
        g.drawLine(-scaleWidth/ 2, 0, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 90 + alphaDegree, betaDegree); //Левая малая дуга
        g.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, betaDegree, 2 * alphaDegree); //Большая дуга
        g.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, betaDegree); //Правая малая дуга
        g.drawLine(scaleWidth / 2, 0, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка
        g.drawLine(-scaleWidth / 2, 0, scaleWidth / 2, 0); //Почва
    }

    /**
     * Это графический метод построения продольного сечения горной выработки.
     */
//    public void graphExSide(Graphics g) {
//        //Вид сбоку
//        g.drawLine(distance, 0, distance, Hsc);
//        g.drawLine(distance, Hsc, distance + (int) (cAl * m * scaleEx), Hsc);
//        g.drawLine(distance + (int) (cAl * m * scaleEx), Hsc, distance + (int) (cAl * m * scaleEx), 0);
//        g.drawLine(distance + (int) (cAl * m * scaleEx), 0, distance, 0);
//    }
}