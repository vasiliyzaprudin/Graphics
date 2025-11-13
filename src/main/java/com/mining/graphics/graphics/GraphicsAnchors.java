package com.mining.graphics.graphics;

import com.mining.graphics.service.ServiceAnchors;

import java.awt.*;

public class GraphicsAnchors extends ServiceAnchors {

    public void paint(Graphics g) {

        //Построение анкеров в поперечном сечении
        for (int i = 0; i <= n; i++) {
            g.drawLine((int) (СoorAnchAc[i][0] * scaleEx), (int) (СoorAnchAc[i][1] * scaleEx), (int) (СoorAnchAc[i][2] * scaleEx), (int) (СoorAnchAc[i][3] * scaleEx));
        }

        //Построение расположения опорных плиток - вид сбоку
        for (int j = 0; j <= m - 1; j++) {
            for (int i = 0; i <= n / 2; i++) {
                g.drawRect((int) (distance + (cAl / 2 - d / 2 + cAl * j) * scaleEx), (int) (СoorAnchAc[i][1] * scaleEx - d / 2 * scaleEx), (int) (d * scaleEx), (int) (d * scaleEx));
            }
        }

        //Построение анкеров, вблизи оси выработки
        for (int j = 0; j <= m - 1; j++) {
            g.drawLine((int) (distance + (cAl / 2 + cAl * j)*scaleEx), 0, (int) (distance + (cAl / 2 + cAl * j)*scaleEx), (int) (-l * scaleEx));
        }
    }
}
