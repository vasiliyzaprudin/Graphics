package com.mining.graphics.graphics;

import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends Frame {
    private GraphicsAnchors GA;
    private GraphicsExcavation GE;
    private  GraphicsIntersection GI;

    public GraphicsWindow() {
        GA = new GraphicsAnchors();
        GE = new GraphicsExcavation();
        GI = new GraphicsIntersection();

        // Анонимный внутренний класс для обработки событий закрытия окна.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Переопределяем метод paint для отрисовки
    public void paint(Graphics g) {
        int t = 1;
        switch (t) {
            case 0:
                g.translate(400, 400);
                GA.paint(g);
                GE.paint(g);
                break;
            case 1:
                g.translate(400, 400);
                GI.paint(g);
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
