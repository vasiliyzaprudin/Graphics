package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceAnchorsInt;

import java.awt.*;

public class GraphicsAnchorsInt extends ServiceAnchorsInt {

    //Построение анкеров в плане
    public void graphAnchPlanIntConstr3(Graphics g) {
        //Расчет и построение анкеров в выработке 1
        g.setColor(new Color(130, 0, 130));
        calcCoordAnPlanInt(x1, y1, x12, y12, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphAnchPlanInt(g);
        calcCoordAnPlanInt(x33, y33, x13, y13, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphAnchPlanInt(g);

        //Расчет и построение анкеров в выработке 2
        g.setColor(Color.BLUE);
        calcCoordAnPlanInt(x1, y1, x21, y21, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphAnchPlanInt(g);
        calcCoordAnPlanInt(x2, y2, x23, y23, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphAnchPlanInt(g);

        //Расчет и построение анкеров в выработке 3
        g.setColor(new Color(0, 120, 0));
        calcCoordAnPlanInt(x2, y2, x32, y32, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphAnchPlanInt(g);
        calcCoordAnPlanInt(x33, y33, x31, y31, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphAnchPlanInt(g);
    }

    //Построение анкеров в проекции
    public void graphAnchProjIntConstr3(Graphics g) {
        g.translate(0, distance); //Перенос начала координат в центр отрезка, изображающего почву сопряжения
        calcCoordAnProjInt(x21, -h2, cAl2, l2);
        g.setColor(Color.BLUE);
        graphAnchProjInt(g);
        calcCoordAnProjInt(x31, -h3, cAl3, l3);
        g.setColor(new Color(0, 120, 0));
        graphAnchProjInt(g);
        g.translate(0, -distance); //Перенос начала координат в центр отрезка, изображающего почву сопряжения
    }

    //Проверка построения анкеров в плане сопряжения
    public void TestIntAnch(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        //Для выработки 1
        testX0Y0(cAl1, xb1, -yb1);
        graphicsTestAnch(g);
        //Для выработки 2
        testX0Y0(cAl2, xb2, -yb2);
        graphicsTestAnch(g);
        //Для выработки 3
        testX0Y0(cAl3, xb3, yb3);
        graphicsTestAnch(g);
    }

    //Информация о параметрах сопряжения
    public void InformationInt(Graphics g) {
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
    public void graphAnchPlanInt(Graphics g) {
        for (int i = 0; i <= n; i++) {
            g.drawLine((int) (СoorAncIntPlan[i][0] * scaleInt), (int) (СoorAncIntPlan[i][1] * scaleInt), (int) (СoorAncIntPlan[i][2] * scaleInt), (int) (СoorAncIntPlan[i][3] * scaleInt));
        }
    }

    //Метод построения анкеров в проекции сопряжения
    public void graphAnchProjInt(Graphics g) {
        for (int i = 0; i <= numAnchProj; i++) {
            g.drawLine((int) (СoorAncIntProj[i][0] * scaleInt), (int) (СoorAncIntProj[i][1] * scaleInt), (int) (СoorAncIntProj[i][2] * scaleInt), (int) (СoorAncIntProj[i][3] * scaleInt));
        }
    }

    public void graphicsTestAnch(Graphics g) {
        for (int i = 0; i <= m; i++) {
            g.drawLine((int) (СoorTestX0Y0[i][0] * scaleInt), (int) (СoorTestX0Y0[i][1] * scaleInt), (int) (СoorTestX0Y0[i][2] * scaleInt), (int) (СoorTestX0Y0[i][3] * scaleInt));
        }
    }
}