package com.mining.graphics.graphics;

import com.mining.graphics.mineexcavation.ModelExcavation;
import com.mining.graphics.mineexcavation.ModelIntersection;
import com.mining.graphics.service.ServiceAnchors;
import com.mining.graphics.service.ServiceIntersection;
import com.mining.graphics.support.ModelAnchors;

import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends Frame {
    public GraphicsWindow() {

        //Анонимный внутренний класс для обработки событий закрытия окна.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    int scale = 50; //масштаб построений
    int distance = 500; //расстояние между поперечным разрезом и вида сбоку в графическом окне
    int m = 7; //количество рядов анкеров для отображения - вид сбоку

    ModelExcavation ModelExcavation = new ModelExcavation();
    //Исходные геометрические параметры выработки в масштабе
    int B = (int) Math.round(ModelExcavation.getB() * scale);
    int H = (int) Math.round(ModelExcavation.getH() * scale);
    int hr = (int) Math.round(ModelExcavation.gethr() * scale);

    //Расчетные геометрические параметры выработки в масштабе
    double alpha = ModelExcavation.getalpha();
    double beta = ModelExcavation.getbeta();
    int r = (int) Math.round(ModelExcavation.getr() * scale);
    int R = (int) Math.round(ModelExcavation.getR() * scale);

    //Исходные данные о параметрах анкерного крепления
    ModelAnchors ModelAnchors = new ModelAnchors();
    double l = ModelAnchors.getl() * scale;
    double cAl = ModelAnchors.getcAl() * scale;
    double d = ModelAnchors.getd() * scale;

    //Результаты расчета координат установки анкеров
    ServiceAnchors ServiceAnchors = new ServiceAnchors();
    int n = ServiceAnchors.getn();
    double[][] СoorAnchAc = ServiceAnchors.getСoorAnchAc();

    //Исходные данные о параметрах сопряжения
    ModelIntersection ModelIntersection = new ModelIntersection();
    int b1 = (int) ModelIntersection.getb1() * scale;
    int b2 = (int) ModelIntersection.getb2() * scale;
    int b3 = (int) ModelIntersection.getb3() * scale;
    double alpha1 = ModelIntersection.getalpha1();
    double alpha2 =  ModelIntersection.getalpha2();
    double alpha3 = ModelIntersection.getalpha3();
    int L1 = (int) ModelIntersection.getL1() * scale;
    int L2 = (int) ModelIntersection.getL2() * scale;
    int L3 = (int) ModelIntersection.getL3() * scale;

    //Результаты расчета координат пересечения боков выработок
    ServiceIntersection ServiceIntersection = new ServiceIntersection();
    int x1 = (int) ServiceIntersection.getx1() * scale;
    int y1 = (int) ServiceIntersection.gety1() * scale;


    public void paint(Graphics g) {
        //Перенос начала координат
        g.translate(150, 300);
        int t = 2;
        switch (t) {
            case 0: //одиночная выработка
                //System.out.print("x1 = " + СoorAnchAc[0][0] + ", ");
                //System.out.print("y1 = " + СoorAnchAc[0][1] + ", ");
                //System.out.print("x2 = " + СoorAnchAc[0][2] + ", ");
                //System.out.println("y2 = " + СoorAnchAc[0][3]);

                //System.out.println("alpha равно " + alpha);
                //System.out.println("beta равно " + beta);
                //System.out.println("r равно " + r);
                //System.out.println("R равно" + R);
                //System.out.println("Длина дуги малой окружности равна " + rl);
                //System.out.println("Длина дуги большой окружности равна " + Rl);

                //Построение поперечного сечения выработки
                //Левая стенка
                g.drawLine(0, H, 0, hr);
                //Кровля
                g.drawArc(0, hr - r, 2 * r, 2 * r, (int) (90 + (alpha * 180 / Math.PI)), (int) (beta * 180 / Math.PI));
                g.drawArc(B / 2 - R, 0, 2 * R, 2 * R, (int) (beta * 180 / Math.PI), (int) (2.0 * alpha * 180 / Math.PI));
                g.drawArc(B - 2 * r, hr - r, 2 * r, 2 * r, 0, (int) (beta * 180 / Math.PI));
                //Правая стенка
                g.drawLine(B, hr, B, H);
                //Почва
                g.drawLine(B, H, 0, H);

                //Построение - вид сбоку выработки
                g.drawLine(distance, 0, distance, H);
                g.drawLine(distance, H, distance + (int) cAl * m, H);
                g.drawLine(distance + (int) cAl * m, H, distance + (int) cAl * m, 0);
                g.drawLine(distance + (int) cAl * m, 0, distance, 0);

                //Построение анкеров в поперечном сечении
                for (int i = 0; i <= n; i++) {
                    g.drawLine((int) (СoorAnchAc[i][0] * scale), (int) (СoorAnchAc[i][1] * scale), (int) (СoorAnchAc[i][2] * scale), (int) (СoorAnchAc[i][3] * scale));
                }

                //Построение расположения опорных плиток - вид сбоку
                for (int j = 0; j <= m - 1; j++) {
                    for (int i = 0; i <= n / 2; i++) {
                        g.fillRect((int) (distance + cAl / 2 - d / 2 + cAl * j), (int) (СoorAnchAc[i][1] * scale - d / 2), (int) (d), (int) (d));
                    }
                }

                //Построение анкеров, вблизи оси выработки
                for (int j = 0; j <= m - 1; j++) {
                    g.drawLine((int) (distance + cAl / 2 + cAl * j), 0, (int) (distance + cAl / 2 + cAl * j), (int) -l);
                }
                break;
            case 1: //сопряжение двух выработок (поворот)
                break;
            case 2: //сопряжение трех выработок
                g.drawLine(0, 0, (int)(L1 * Math.sin(alpha1)), (int)(L1 * Math.cos(alpha1)));
                break;
        }

    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(1200, 700));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}