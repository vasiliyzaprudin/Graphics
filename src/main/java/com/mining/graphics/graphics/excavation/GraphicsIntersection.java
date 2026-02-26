package com.mining.graphics.graphics.excavation;

import com.mining.graphics.service.excavation.ServiceIntersection;

import java.awt.*;

public class GraphicsIntersection extends ServiceIntersection {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
         //Сглаживание
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
         //Толщина линий
        ((Graphics2D) g).setStroke(new BasicStroke(1));
        int t = 3;
        switch (t) {
            case 2:
                //Построение осей выработок
                //g.drawLine(0, 0, (int) (L1sc * Math.sin(alpha1Rad)), (int) (-L1sc * Math.cos(alpha1Rad)));
                //g.drawLine(0, 0, (int) (L2sc * Math.sin(alpha2Rad)), (int) (-L2sc * Math.cos(alpha2Rad)));

                //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
                //g.drawLine(0, 0, x1sc, y1sc);
                //g.drawLine(0, 0, x22sc, y22sc);

                //Выработка 1
                g.drawLine(xs12sc, ys12sc, xs11sc, ys11sc); //Забой выработки 1
                g.drawLine(xs12sc, ys12sc, x12sc, y12sc); //Бок выработки 1 левый
                g.drawLine(x12sc, y12sc, x1sc, y1sc); //Закругление выработки 1 к выработке 2 левое
                g.drawLine(xs11sc, ys11sc, xi22sc,yi22sc); //Бок выработки 1 правый

                //Выработка 2
                g.drawLine(xs21sc, ys21sc, xs22sc, ys22sc); //Забой выработки 2
                g.drawLine(xs21sc, ys21sc, x21sc, y21sc); //Бок выработки 2 правый
                g.drawLine(x21sc, y21sc, x1sc, y1sc); //Закругление выработки 2 к выработке 1 правое
                g.drawLine(xs22sc,ys22sc, xi22sc,yi22sc); //Бок выработки 2 левый
                break;

            case 3:
                //Построение осей выработок
                g.drawLine(0, 0, xb1sc, -yb1sc);
                g.drawLine(0, 0, xb2sc,-yb2sc);
                g.drawLine(0, 0, xb3sc,yb3sc);

                //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
//                g.drawLine(0, 0, x1sc, y1sc);
//                g.drawLine(0, 0, x2sc, y2sc);
//                g.drawLine(0, 0, x33sc, y33sc);

                //Линии, соединяющие точку пересечения боков выработок с точками пересечения закругления выработок
                g.drawLine(0, 0, xi1sc, yi1sc);
                g.drawLine(0, 0, xi2sc, yi2sc);
                g.drawLine(0, 0, xi33sc, yi33sc);


                //Выработка 1
                g.drawLine(xs11sc, ys11sc, xs12sc, ys12sc); //Забой
                g.drawLine(xs12sc, ys12sc, x12sc, y12sc); //Левый бок
                g.drawLine(x12sc, y12sc, x1sc, y1sc); //Закругление к выработке 2
                g.drawLine(xs11sc, ys11sc, x13sc, y13sc); //Правый бок
                g.drawLine(x13sc, y13sc, x33sc, y33sc); //Закругление к выработке 3

                //Выработка 2
                g.drawLine(xs21sc, ys21sc, xs22sc, ys22sc); //Забой
                g.drawLine(xs22sc, ys22sc, x23sc, y23sc); //Левый бок
                g.drawLine(x23sc, y23sc, x2sc, y2sc); //Закругление к выработке 3
                g.drawLine(xs21sc, ys21sc, x21sc, y21sc); //Правый бок
                g.drawLine(x21sc, y21sc, x1sc, y1sc); //Закругление к выработке 1

                //Выработка 3
                g.drawLine(xs31sc, ys31sc, xs32sc, ys32sc); //Забой
                g.drawLine(xs32sc, ys32sc, x31sc, y31sc); //Левый бок
                g.drawLine(x31sc, y31sc, x33sc, y33sc); //Закругление к выработке 1
                g.drawLine(xs31sc, ys31sc, x32sc, y32sc); //Правый бок
                g.drawLine(x32sc, y32sc, x2sc, y2sc); //Закругление к выработке 2
                break;

            case 4:
                //Построение осей выработок
                //g.drawLine(0, 0, (int) (L1sc * Math.sin(alpha1Rad)), (int) (-L1sc * Math.cos(alpha1Rad)));
                //g.drawLine(0, 0, (int) (L2sc * Math.sin(alpha2Rad)), (int) (-L2sc * Math.cos(alpha2Rad)));
                //g.drawLine(0, 0, (int) (L3sc * Math.sin(alpha3Rad)), (int) (-L3sc * Math.cos(alpha3Rad)));
                //g.drawLine(0, 0, (int) (L4sc * Math.sin(alpha4Rad)), (int) (-L4sc * Math.cos(alpha4Rad)));

                //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
                g.drawLine(0, 0, x1sc, y1sc);
                g.drawLine(0, 0, x2sc, y2sc);
                g.drawLine(0, 0, x3sc, y3sc);
                g.drawLine(0, 0, x4sc, y4sc);

                //Выработка 1
                g.drawLine(xs11sc, ys11sc, xs12sc, ys12sc); //Забой
                g.drawLine(xs12sc, ys12sc, x12sc, y12sc); //Левый бок
                g.drawLine(x12sc, y12sc, x1sc, y1sc); //Закругление к выработке 2
                g.drawLine(xs11sc, ys11sc, x14sc, y14sc); //Правый бок
                g.drawLine(x14sc, y14sc, x4sc, y4sc); //Закругление к выработке 4

                //Выработка 2
                g.drawLine(xs21sc, ys21sc, xs22sc, ys22sc); //Забой
                g.drawLine(xs22sc, ys22sc, x23sc, y23sc); //Левый бок
                g.drawLine(x23sc, y23sc, x2sc, y2sc); //Закругление к выработке 3
                g.drawLine(xs21sc, ys21sc, x21sc, y21sc); //Правый бок
                g.drawLine(x21sc, y21sc, x1sc, y1sc); //Закругление к выработке 1

                //Выработка 3
                g.drawLine(xs31sc, ys31sc, xs32sc, ys32sc); //Забой
                g.drawLine(xs32sc, ys32sc, x34sc, y34sc); //Левый бок
                g.drawLine(x34sc, y34sc, x3sc, y3sc); //Закругление к выработке 4
                g.drawLine(xs31sc, ys31sc, x32sc, y32sc); //Правый бок
                g.drawLine(x32sc, y32sc, x2sc, y2sc); //Закругление к выработке 2

                //Выработка 4
                g.drawLine(xs41sc, ys41sc, xs42sc, ys42sc); //Забой
                g.drawLine(xs42sc, ys42sc, x41sc, y41sc); //Левый бок
                g.drawLine(x41sc, y41sc, x4sc, y4sc); //Закругление к выработке 4
                g.drawLine(xs41sc, ys41sc, x43sc, y43sc); //Правый бок
                g.drawLine(x43sc, y43sc, x3sc, y3sc); //Закругление к выработке 2
                break;
        }
    }
}
