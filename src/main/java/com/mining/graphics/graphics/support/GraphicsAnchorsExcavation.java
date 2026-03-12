package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceAnchorsExcavation;

import java.awt.*;

public class GraphicsAnchorsExcavation extends ServiceAnchorsExcavation {

    public void paint(Graphics g) {

        //Построение анкеров в поперечном сечении
        for (int i = 0; i <= numberAnchors; i++) {
            g.drawLine((int) (Math.round(crossSectionAnchorsXY[i][0] * GRAPHICS_SCALE)), (int) (Math.round(crossSectionAnchorsXY[i][1] * GRAPHICS_SCALE)), (int) (Math.round(crossSectionAnchorsXY[i][2] * GRAPHICS_SCALE)), (int) (Math.round(crossSectionAnchorsXY[i][3] * GRAPHICS_SCALE)));
        }

//        //Построение расположения опорных плиток - вид сбоку
//        for (int j = 0; j <= m - 1; j++) {
//            for (int i = 0; i <= n / 2; i++) {
//                g.drawRect((int) (distance + (cAl / 2 - d / 2 + cAl * j) * scaleEx), (int) (СoorAnchAc[i][1] * scaleEx - d / 2 * scaleEx), (int) (d * scaleEx), (int) (d * scaleEx));
//            }
//        }
//
//        //Построение анкеров, вблизи оси выработки
//        for (int j = 0; j <= m - 1; j++) {
//            g.drawLine((int) (distance + (cAl / 2 + cAl * j) * scaleEx), 0, (int) (distance + (cAl / 2 + cAl * j) * scaleEx), (int) (-l * scaleEx));
//        }
    }
}
