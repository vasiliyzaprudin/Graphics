package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceAnchorsInt;

import java.awt.*;

public class GraphicsAnchorsInt extends ServiceAnchorsInt {

    public void paint(Graphics g) {
        //Построение анкеров в выработке 1
        g.setColor(Color.BLUE);
        CalculateCoordinatesAnchorsInt(x12, y12, x1, y1, cAl1, l1, bAc1, LroofAc1);
        GraphicsAnchorsInt(g);
        CalculateCoordinatesAnchorsInt(x33, y33, x13, y13, cAl1, l1, bAc1, LroofAc1);
        GraphicsAnchorsInt(g);

        //Построение анкеров в выработке 2
        g.setColor(Color.RED);
        CalculateCoordinatesAnchorsInt(x1, y1, x21, y21, cAl2, l2, bAc2, LroofAc2);
        GraphicsAnchorsInt(g);
        CalculateCoordinatesAnchorsInt(x23, y23, x2, y2, cAl2, l2, bAc2, LroofAc2);
        GraphicsAnchorsInt(g);

        //Построение анкеров в выработке 3
        g.setColor(Color.GREEN);
        CalculateCoordinatesAnchorsInt(x2, y2, x32, y32, cAl3, l3, bAc3, LroofAc3);
        GraphicsAnchorsInt(g);
        CalculateCoordinatesAnchorsInt(x31, y31, x33, y33, cAl3, l3, bAc3, LroofAc3);
        GraphicsAnchorsInt(g);
    }

    public void GraphicsAnchorsInt(Graphics g) {

        for (int i = 0; i <= n; i++) {
            g.drawLine((int) (СoorAncInt[i][0] * scaleInt), (int) (СoorAncInt[i][1] * scaleInt), (int) (СoorAncInt[i][2] * scaleInt), (int) (СoorAncInt[i][3] * scaleInt));
        }
    }
}