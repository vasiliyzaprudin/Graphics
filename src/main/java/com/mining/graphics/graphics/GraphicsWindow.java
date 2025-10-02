package com.mining.graphics.graphics;

import com.mining.graphics.model.ModelExcavation;
import com.mining.graphics.model.ModelIntersection;
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
    double b1 = ModelIntersection.getb1() * scale;
    double b2 = ModelIntersection.getb2() * scale;
    double b3 = ModelIntersection.getb3() * scale;
    double alpha1 = Math.PI / 180 * ModelIntersection.getalpha1();
    double alpha2 = Math.PI / 180 * ModelIntersection.getalpha2();
    double alpha3 = Math.PI / 180 * ModelIntersection.getalpha3();
    double L1 = ModelIntersection.getL1() * scale;
    double L2 = ModelIntersection.getL2() * scale;
    double L3 = ModelIntersection.getL3() * scale;

    //Результаты расчета координат пересечения боков выработок
    ServiceIntersection ServiceIntersection = new ServiceIntersection();
    double beta1 = ServiceIntersection.getbeta1();
    double beta2 = ServiceIntersection.getbeta2();
    double beta3 = ServiceIntersection.getbeta3();
    int x1 = (int) (ServiceIntersection.getx1() * scale);
    int y1 = (int) (ServiceIntersection.gety1() * scale);
    int x2 = (int) (ServiceIntersection.getx2() * scale);
    int y2 = (int) (ServiceIntersection.gety2() * scale);
    int x3 = (int) (ServiceIntersection.getx3() * scale);
    int y3 = (int) (ServiceIntersection.gety3() * scale);

    public void paint(Graphics g) {
        //Перенос начала координат
        g.translate(600, 500);
        int t = 0;
        switch (t) {
            case 0: //одиночная выработка
                //System.out.print("x1 = " + СoorAnchAc[0][0] + ", ");
                //System.out.print("y1 = " + СoorAnchAc[0][1] + ", ");
                //System.out.print("x2 = " + СoorAnchAc[0][2] + ", ");
                //System.out.println("y2 = " + СoorAnchAc[0][3]);

                //System.out.println("alpha равно " + alpha);
                //System.out.println("beta равно " + beta);
                //System.out.println("i равно " + i);
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
                //Построение осей выработок
                //g.drawLine(0, 0, (int) (L1 * Math.sin(alpha1)), (int) (-L1 * Math.cos(alpha1)));
                //g.drawLine(0, 0, (int) (L2 * Math.sin(alpha2)), (int) (-L2 * Math.cos(alpha2)));
                //g.drawLine(0, 0, (int) (L3 * Math.sin(alpha3)), (int) (-L3 * Math.cos(alpha3)));
                //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
                g.drawLine(0, 0, x1, y1);
                g.drawLine(0, 0, x2, y2);
                g.drawLine(0, 0, x3, y3);
                //Бока и торцевые части выработок
                //Выработка 1
                g.drawLine((int) (L1 * Math.sin(alpha1)), (int) ((-1.0) * L1 * Math.cos(alpha1)), (int) (L1 * Math.sin(alpha1) + b1 / 2.0 * Math.cos(alpha1)), (int) ((-1.0) * L1 * Math.cos(alpha1) + b1 / 2.0 * Math.sin(alpha1)));
                g.drawLine(((int) (L1 * Math.sin(alpha1) + b1 / 2.0 * Math.cos(alpha1))), (int) ((-1.0) * L1 * Math.cos(alpha1) + b1 / 2.0 * Math.sin(alpha1)), x1, y1);
                g.drawLine((int) (L1 * Math.sin(alpha1)), (int) ((-1.0) * L1 * Math.cos(alpha1)), (int) (L1 * Math.sin(alpha1) - b1 / 2.0 * Math.cos(alpha1)), (int) ((-1.0) * L1 * Math.cos(alpha1) - b1 / 2.0 * Math.sin(alpha1)));
                g.drawLine(((int) (L1 * Math.sin(alpha1) - b1 / 2.0 * Math.cos(alpha1))), (int) ((-1.0) * L1 * Math.cos(alpha1) - b1 / 2.0 * Math.sin(alpha1)), x3, y3);

                //Выработка 2
                g.drawLine((int) (L2 * Math.sin(alpha2)), (int) ((-1.0) * L2 * Math.cos(alpha2)), (int) (L2 * Math.sin(alpha2) + b2 / 2.0 * Math.cos(alpha2)), (int) ((-1.0) * L2 * Math.cos(alpha2) + b2 / 2.0 * Math.sin(alpha2)));
                g.drawLine((int) (L2 * Math.sin(alpha2) + b2 / 2.0 * Math.cos(alpha2)), (int) ((-1.0) * L2 * Math.cos(alpha2) + b2 / 2.0 * Math.sin(alpha2)), x2, y2);
                g.drawLine((int) (L2 * Math.sin(alpha2)), (int) ((-1.0) * L2 * Math.cos(alpha2)), (int) (L2 * Math.sin(alpha2) - b2 / 2.0 * Math.cos(alpha2)), (int) ((-1.0) * L2 * Math.cos(alpha2) - b2 / 2.0 * Math.sin(alpha2)));
                g.drawLine(((int) (L2 * Math.sin(alpha2) - b2 / 2.0 * Math.cos(alpha2))), (int) ((-1.0) * L2 * Math.cos(alpha2) - b2 / 2.0 * Math.sin(alpha2)), x1, y1);

                //Выработка 3
                g.drawLine((int) (L3 * Math.sin(alpha3)), (int) ((-1.0) * L3 * Math.cos(alpha3)), (int) (L3 * Math.sin(alpha3) + b3 / 2.0 * Math.cos(alpha3)), (int) ((-1.0) * L3 * Math.cos(alpha3) + b3 / 2.0 * Math.sin(alpha3)));
                g.drawLine((int) (L3 * Math.sin(alpha3) + b3 / 2.0 * Math.cos(alpha3)), (int) ((-1.0) * L3 * Math.cos(alpha3) + b3 / 2.0 * Math.sin(alpha3)), x3, y3);
                g.drawLine((int) (L3 * Math.sin(alpha3)), (int) ((-1.0) * L3 * Math.cos(alpha3)), (int) (L3 * Math.sin(alpha3) - b3 / 2.0 * Math.cos(alpha3)), (int) ((-1.0) * L3 * Math.cos(alpha3) - b3 / 2.0 * Math.sin(alpha3)));
                g.drawLine(((int) (L3 * Math.sin(alpha3) - b3 / 2.0 * Math.cos(alpha3))), (int) ((-1.0) * L3 * Math.cos(alpha3) - b3 / 2.0 * Math.sin(alpha3)), x2, y2);
                break;
        }

    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(1700, 1000));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}