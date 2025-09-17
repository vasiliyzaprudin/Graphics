package com.mining.graphics.graphics;

//Графические построения

import com.mining.graphics.mineexcavation.MineExcavation;

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

    double scale = 50.0;

    MineExcavation MineExcavation = new MineExcavation();
    double B = MineExcavation.getB() * scale;
    double H = MineExcavation.getH() * scale;
    double hr = MineExcavation.gethr() * scale;
    double alpha = MineExcavation.getalpha();
    double beta = MineExcavation.getbeta();
    double r = MineExcavation.getr() * scale;
    double R = MineExcavation.getR() * scale;
    double rl = MineExcavation.getrl() * scale;
    double Rl = MineExcavation.getRl() * scale;
    double Lroof = MineExcavation.getLroof() * scale;

    public void paint(Graphics g) {
        g.translate(100, 300);


        //Левая стенка
        g.drawLine(0, (int) (H), 0, (int) (hr));
        //Кровля
        g.drawArc(0, (int) ((int)r*Math.sin(beta)), (int)r, (int) ((int)r*Math.sin(beta)), (int)(270-beta), 270);
        //Почва
        g.drawLine((int) B, (int) (H), 0, (int) (H));


        //Вычертить многоугольник
        //int[] xpoint = {20, 200, 20, 200, 30};
        //int[] ypoint = {450, 450, 650, 650, 150};
        //int num = 5;
        //g.drawPolygon(xpoint, ypoint, num);
    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(500, 700));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}
