package com.mining.graphics.graphics.excavation;

import com.mining.graphics.model.support.ModelAnchorsEx;

import java.awt.*;

public class GraphicsExcavation extends ModelAnchorsEx {
    public void paint(Graphics g) {

        //Построение поперечного сечения выработки
        //Левая стенка
        g.drawLine(0, Hsc, 0, hrsc);
        //Кровля
        g.drawArc(0, hrsc - rsc, 2 * rsc,  2 * rsc, (int) (90 + (alpha * 180 / Math.PI)), (int) (beta * 180 / Math.PI));
        g.drawArc((int) ((B / 2 - R) * scaleEx), 0, 2 * Rsc, 2 * Rsc, (int) (beta * 180 / Math.PI), (int) (2.0 * alpha * 180 / Math.PI));
        g.drawArc((int) ((B - 2 * r) * scaleEx), hrsc - rsc, 2 * rsc, 2 * rsc, 0, (int) (beta * 180 / Math.PI));
        //Правая стенка
        g.drawLine(Bsc, hrsc, Bsc, Hsc);
        //Почва
        g.drawLine(Bsc, Hsc, 0, Hsc);

        //Вид сбоку
        g.drawLine(distance, 0, distance, Hsc);
        g.drawLine(distance, Hsc, distance + (int) (cAl * m * scaleEx), Hsc);
        g.drawLine(distance + (int) (cAl * m * scaleEx), Hsc, distance + (int) (cAl * m * scaleEx), 0);
        g.drawLine(distance + (int) (cAl * m * scaleEx), 0, distance, 0);


        //Информация о геометрических параметрах выработки

        int startX = 15; //Начальная координата X
        int startY = 450; // Начальная координата Y
        int lineHeight = 30; // Высота строки

        g.setFont(new Font("Arial", Font.PLAIN, 14));

        // Фон для текста
        g.setColor(new Color(215, 215, 215, 215));
        g.fillRect(startX -15, startY - 30, 250, 300);

        // Рамка
        g.setColor(Color.BLACK);
        g.drawRect(startX -15, startY - 30, 250, 300);

        // Заголовок
        g.setColor(Color.BLUE);
        g.drawString("Параметры выработки:", startX, startY);

        // Список параметров
        g.setColor(Color.BLACK);
        int y = startY + lineHeight;

        g.drawString(String.format("Ширина B = %.2f м", B), startX, y);
        y += lineHeight;

        g.drawString(String.format("Высота H = %.2f м", H), startX, y);
        y += lineHeight;

        g.drawString(String.format("Малый радиус r = %.3f м", r), startX, y);
        y += lineHeight;

        g.drawString(String.format("Большой радиус R = %.3f м", R), startX, y);
        y += lineHeight;

        g.drawString(String.format("Высота закругления hr = %.3f м", hr), startX, y);
        y += lineHeight;

        g.drawString(String.format("Угол α = %.1f°", alpha * 180 / Math.PI), startX, y);
        y += lineHeight;

        g.drawString(String.format("Угол β = %.1f°", beta * 180 / Math.PI), startX, y);
        y += lineHeight;

        g.drawString(String.format("Масштаб = 1:%d", scaleEx), startX, y);
    }
}