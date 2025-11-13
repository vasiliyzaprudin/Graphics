package com.mining.graphics.graphics;

import com.mining.graphics.support.ModelAnchors;

import java.awt.*;

public class GraphicsExcavation extends ModelAnchors {
    public void paint(Graphics g) {

        //Построение поперечного сечения выработки
        //Левая стенка
        g.drawLine(0, (int) (H * scaleEx), 0, (int) (hr * scaleEx));
        //Кровля
        g.drawArc(0, (int) ((hr - r) * scaleEx), (int) (2 * r * scaleEx), (int) (2 * r * scaleEx), (int) (90 + (alpha * 180 / Math.PI)), (int) (beta * 180 / Math.PI));
        g.drawArc((int) ((B / 2 - R) * scaleEx), 0, (int) (2 * R * scaleEx), (int) (2 * R * scaleEx), (int) (beta * 180 / Math.PI), (int) (2.0 * alpha * 180 / Math.PI));
        g.drawArc((int) ((B - 2 * r) * scaleEx), (int) ((hr - r) * scaleEx), (int) (2 * r * scaleEx), (int) (2 * r * scaleEx), 0, (int) (beta * 180 / Math.PI));
        //Правая стенка
        g.drawLine((int) (B * scaleEx), (int) (hr * scaleEx), (int) (B * scaleEx), (int) (H * scaleEx));
        //Почва
        g.drawLine((int) (B * scaleEx), (int) (H * scaleEx), 0, (int) (H * scaleEx));

        //Вид сбоку
        g.drawLine(distance, 0, distance, (int) (H * scaleEx));
        g.drawLine(distance, (int) (H * scaleEx), distance + (int) (cAl * m * scaleEx), (int) (H * scaleEx));
        g.drawLine(distance + (int) (cAl * m * scaleEx), (int) (H * scaleEx), distance + (int) (cAl * m * scaleEx), 0);
        g.drawLine(distance + (int) (cAl * m * scaleEx), 0, distance, 0);

    }
}
