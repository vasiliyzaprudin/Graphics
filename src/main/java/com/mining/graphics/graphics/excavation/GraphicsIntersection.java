package com.mining.graphics.graphics.excavation;

import com.mining.graphics.service.excavation.ServiceIntersection;
import com.mining.graphics.service.support.ServiceAnchorsInt;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class GraphicsIntersection extends ServiceIntersection {


    private ServiceAnchorsInt SAI;

    //Построение проекции сопряжения
    public void graphIntAc(Graphics g) {

        g.translate(0, distance); //Перенос начала координат в центр отрезка, изображающего почву сопряжения

        //calcElemInSc(SAI.distanceBetweenPoint(x33, y33, x1, y1), Collections.max(Arrays.asList(h1, h2, h3)) * calcIndHeightInt(), typeInt, scaleInt);
        calcElemInSc(SAI.distanceBetweenPoint(x33, y33, x1, y1), h1 * calcIndHeightInt(), typeInt, scaleInt);

        graphConstrIn(g); //Увеличенное сечение выработки 1

        calcElemInSc(b1, h1, k1, scaleInt);
        graphConstrIn(g); //Сечение выработки 1

        g.drawLine(x31sc, -h3sc,(int)(calcCoordPointContactX(x31, -h3)), (int)(calcCoordPointContactY(x31, -h3))); //Кровля сопряжения слева
        g.drawLine(x21sc, -h2sc, (int)(calcCoordPointContactX(x21, -h2)), (int)(calcCoordPointContactY(x21, -h2))); //Кровля сопряжения справа

        //Почва и границы
        g.drawLine(x31sc, 0, x21sc, 0); //почва сопряжения
        g.drawLine(x31sc, 0, x31sc, -h3sc); //левая граница сопряжения
        g.drawLine(x21sc, 0, x21sc, -h2sc); //правая граница сопряжения

        g.translate(0, -distance);
    }

    /**
     * Этот метод строит поперечное сечение горной выработки на поперечном разрезе сопряжения.
     * Начало координат расположено в центре отрезка, изображающего почву горной выработки.
     */
    public void graphConstrIn(Graphics o) {
        o.drawLine(-BSC / 2, 0, -BSC / 2, -(HSC - HRSC)); //Левая стенка
        o.drawArc(-BSC / 2, -(HSC - HRSC) - RSMALLSC, 2 * RSMALLSC, 2 * RSMALLSC, (int) (90 + (ALPHA * 180.0 / Math.PI)), (int) (BETA * 180.0 / Math.PI)); //Левая малая дуга
        o.drawArc(-RBIGSC, -HSC, 2 * RBIGSC, 2 * RBIGSC, (int) (BETA * 180.0 / Math.PI), (int) (2.0 * ALPHA * 180.0 / Math.PI)); //Большая дуга
        o.drawArc((int) (BSC / 2 - 2.0 * RSMALLSC), -(HSC - HRSC) - RSMALLSC, 2 * RSMALLSC, 2 * RSMALLSC, 0, (int) (BETA * 180.0 / Math.PI)); //Правая малая дуга
        o.drawLine(BSC / 2, 0, BSC / 2, -(HSC - HRSC)); //Правая стенка
        o.drawLine(-BSC / 2, 0, BSC / 2, 0); //Почва
    }

    public void GraphConstrInt2(Graphics g) {
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
        g.drawLine(xs11sc, ys11sc, xi22sc, yi22sc); //Бок выработки 1 правый

        //Выработка 2
        g.drawLine(xs21sc, ys21sc, xs22sc, ys22sc); //Забой выработки 2
        g.drawLine(xs21sc, ys21sc, x21sc, y21sc); //Бок выработки 2 правый
        g.drawLine(x21sc, y21sc, x1sc, y1sc); //Закругление выработки 2 к выработке 1 правое
        g.drawLine(xs22sc, ys22sc, xi22sc, yi22sc); //Бок выработки 2 левый
    }

    public void GraphConstrInt3(Graphics g) {

        //Построение осей выработок
//        g.drawLine(0, 0, xb1sc, -yb1sc);
//        g.drawLine(0, 0, xb2sc, -yb2sc);
//        g.drawLine(0, 0, xb3sc, yb3sc);

        //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
//        g.drawLine(0, 0, x1sc, y1sc);
//        g.drawLine(0, 0, x2sc, y2sc);
//        g.drawLine(0, 0, x33sc, y33sc);

        //Линии, соединяющие точку пересечения боков выработок с точками пересечения закругления выработок
//        g.drawLine(0, 0, xi1sc, yi1sc);
//        g.drawLine(0, 0, xi2sc, yi2sc);
//        g.drawLine(0, 0, xi33sc, yi33sc);


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
    }

    public void GraphConstrInt4(Graphics g) {
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
    }
}
