package com.mining.graphics.graphics.support;

import com.mining.graphics.service.support.ServiceAnchorsIntersection;

import java.awt.*;

public class GraphicsAnchorsInt extends ServiceAnchorsIntersection {

    /**
     * Этот метод объединяет расчет координат
     * и графическое изображение анкеров в плане сопряжения из 3 выработок.
     */
    public void graphAnchPlanIntConstr3(Graphics g) {

        //Расчет и построение анкеров в выработке 1
        g.setColor(new Color(130, 0, 130));

        calcCoordAnchPlanInt(x1, y1, x12, y12, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x12, y12, xs12, ys12, x13, y13, xs11, ys11, cAl1, l1, alpha1Rad);
        graphAnchPlanIntLine(g);

        calcCoordAnchPlanInt(x33, y33, x13, y13, cAl1, l1, bAc1, LroofAc1, xb1, -yb1, alpha1Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x13, y13, xs11, ys11, x12, y12, xs12, ys12, cAl1, l1, alpha1Rad);
        graphAnchPlanIntLine(g);

        //Расчет и построение анкеров в выработке 2
        g.setColor(Color.BLUE);

        calcCoordAnchPlanInt(x1, y1, x21, y21, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x21, y21, xs21, ys21, x23, y23, xs22, ys22, cAl2, l2, alpha2Rad);
        graphAnchPlanIntLine(g);

        calcCoordAnchPlanInt(x2, y2, x23, y23, cAl2, l2, bAc2, LroofAc2, xb2, -yb2, alpha2Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x23, y23, xs22, ys22, x21, y21, xs21, ys21, cAl2, l2, alpha2Rad);
        graphAnchPlanIntLine(g);

        //Расчет и построение анкеров в выработке 3
        g.setColor(new Color(0, 120, 0));

        calcCoordAnchPlanInt(x2, y2, x32, y32, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x32, y32, xs31, ys31, x31, y31, xs32, ys32, cAl3, l3, alpha3Rad);
        graphAnchPlanIntLine(g);

        calcCoordAnchPlanInt(x33, y33, x31, y31, cAl3, l3, bAc3, LroofAc3, xb3, yb3, alpha3Rad);
        graphAnchPlanIntRound(g);
        calcCoordAnchPlanIntSide(x31, y31, xs32, ys32, x32, y32, xs31, ys31, cAl3, l3, alpha3Rad);
        graphAnchPlanIntLine(g);
    }

    /**
     * Этот метод объединяет расчет координат
     * и графическое изображение анкеров в проекции.
     */
    public void graphAnchProjIntConstr3(Graphics g) {
        g.translate(0, distance); //Перенос начала координат в центр отрезка, изображающего почву сопряжения
        calcCoordAnchProjInt(x21, -h2, cAl2, l2);
        g.setColor(Color.BLUE);
        graphAnchProjInt(g);
        calcCoordAnchProjInt(x31, -h3, cAl3, l3);
        g.setColor(new Color(0, 120, 0));
        graphAnchProjInt(g);
        g.translate(0, -distance); //Перенос начала координат в точку пересечения осей гороных выработок в плане сопряжения
    }

    /**
     * Этот метод объединяет расчет координат
     * и графическое построение перпендикуляров.
     */
    public void TestIntAnch(Graphics g) {
        g.setColor(new Color(210, 220, 230));
        //Для выработки 1
        testX0Y0(cAl1, xb1, -yb1);
        graphicsTestAnch(g);
        //Для выработки 2
        testX0Y0(cAl2, xb2, -yb2);
        graphicsTestAnch(g);
        //Для выработки 3
        testX0Y0(cAl3, xb3, yb3);
        graphicsTestAnch(g);
        g.setColor(Color.BLACK);
    }

    /**
     * Это графический метод построения анкеров в плане на закруглении сопряжения.
     */
    public void graphAnchPlanIntRound(Graphics g) {
        for (int i = 0; i <= numAnchPlanRound; i++) {
            g.drawLine((int) (СoorAncIntPlanRound[i][0] * scaleInt), (int) (СoorAncIntPlanRound[i][1] * scaleInt),
                    (int) (СoorAncIntPlanRound[i][2] * scaleInt), (int) (СoorAncIntPlanRound[i][3] * scaleInt));
        }
    }

    /**
     * Это графический метод построения анкеров в плане на прямом отрезке сопряжения.
     */
    public void graphAnchPlanIntLine(Graphics g) {
        if (numAnchPlanLine >= 0) {
            for (int i = 0; i <= numAnchPlanLine; i++) {
                g.drawLine((int) (СoorAncIntPlanLine[i][0] * scaleInt), (int) (СoorAncIntPlanLine[i][1] * scaleInt),
                        (int) (СoorAncIntPlanLine[i][2] * scaleInt), (int) (СoorAncIntPlanLine[i][3] * scaleInt));
            }
        } else {
        }
    }

    /**
     * Это графический метод построения анкеров в проекции сопряжения.
     */
    public void graphAnchProjInt(Graphics g) {
        for (int i = 0; i <= numAnchProj; i++) {
            g.drawLine((int) (СoorAncIntProj[i][0] * scaleInt), (int) (СoorAncIntProj[i][1] * scaleInt),
                    (int) (СoorAncIntProj[i][2] * scaleInt), (int) (СoorAncIntProj[i][3] * scaleInt));
        }
    }

    /**
     * Этот графический метод строит перпендикуляры к оси горной выработки
     * от начала координат до забоя с шагом анкерования.
     */
    public void graphicsTestAnch(Graphics g) {
        for (int i = 0; i <= numAnchTest; i++) {
            g.drawLine((int) (СoorTestX0Y0[i][0] * scaleInt), (int) (СoorTestX0Y0[i][1] * scaleInt),
                    (int) (СoorTestX0Y0[i][2] * scaleInt), (int) (СoorTestX0Y0[i][3] * scaleInt));
        }
    }

    /**
     * Этот метод показывает на экране параметры сопряжения.
     */
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
}