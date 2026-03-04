package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceAnchorsInt;

import java.awt.*;

public class GraphicsAnchorsInt extends ServiceAnchorsInt {

    public void graphAnchIntConstr3(Graphics g) {
        //Построение анкеров в выработке 1
        g.setColor(Color.ORANGE);
        calculateCoordinatesAnchorsInt(x1, y1, x12, y12, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphicsAnchorsInt(g);
        calculateCoordinatesAnchorsInt(x33, y33, x13, y13, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphicsAnchorsInt(g);

        //Построение анкеров в выработке 2
        g.setColor(Color.BLUE);
        calculateCoordinatesAnchorsInt(x1, y1, x21, y21, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphicsAnchorsInt(g);
        calculateCoordinatesAnchorsInt(x2, y2, x23, y23, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphicsAnchorsInt(g);

        //Построение анкеров в выработке 3
        g.setColor(Color.GREEN);
        calculateCoordinatesAnchorsInt(x2, y2, x32, y32, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphicsAnchorsInt(g);
        calculateCoordinatesAnchorsInt(x33, y33, x31, y31, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphicsAnchorsInt(g);
    }

    //Проверка правильности построения анкеров в плане сопряжения
    public void TestIntAnch(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        //Для выработки 1
        testX0(cAl1, xb1, -yb1);
        graphicsTestAnch(g);
        //Для выработки 2
        testX0(cAl2, xb2, -yb2);
        graphicsTestAnch(g);
        //Для выработки 3
        testX0(cAl3, xb3, yb3);
        graphicsTestAnch(g);
    }

    //Информация о параметрах сопряжения
    public void InformationInt(Graphics g) {
        //Информация о геометрических параметрах выработки
        int startX = 700; //Начальная координата X
        int startY = 0; // Начальная координата Y
        int lineHeight = 30; // Высота строки
        g.setFont(new Font("Arial", Font.PLAIN, 14));

        // Заголовок
        g.setColor(Color.BLUE);
        g.drawString("Параметры выработки:", startX, startY);

        // Список параметров
        g.setColor(Color.BLACK);
        int y = startY + lineHeight;
        g.drawString(String.format("CAL = %.2f м", CAL), startX, y);
        y += lineHeight;
        g.drawString(String.format("GAMMA = %.2f градусов", GAMMA * 180 / Math.PI), startX, y);
        y += lineHeight;
        g.drawString(String.format("Угол = %.2f градусов", angleBetweenLines(x1, y1, 0.0, 0.0, xb1, -yb1, 0.0, 0.0) * 180 / Math.PI), startX, y);
        y += lineHeight;
    }

    //Метод построения анкеров в плане сопряжения
    public void graphicsAnchorsInt(Graphics g) {
        for (int i = 0; i <= n; i++) {
            g.drawLine((int) (СoorAncInt[i][0] * scaleInt), (int) (СoorAncInt[i][1] * scaleInt), (int) (СoorAncInt[i][2] * scaleInt), (int) (СoorAncInt[i][3] * scaleInt));
        }
    }

    public void graphicsTestAnch(Graphics g) {
        for (int i = 0; i <= m; i++) {
            g.drawLine((int) (СoorTestX0[i][0] * scaleInt), (int) (СoorTestX0[i][1] * scaleInt), (int) (СoorTestX0[i][2] * scaleInt), (int) (СoorTestX0[i][3] * scaleInt));
        }
    }
}