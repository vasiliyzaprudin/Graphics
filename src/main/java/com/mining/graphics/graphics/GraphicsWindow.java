package com.mining.graphics.graphics;

import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.GraphicsAnchorsEx;
import com.mining.graphics.graphics.support.GraphicsAnchorsInt;
import com.mining.graphics.graphics.support.GraphicsShotcreteEx;
import com.mining.graphics.model.excavation.ModelExcavation;

import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends Frame {
    private GraphicsAnchorsEx GAE;
    private GraphicsShotcreteEx GSE;
    private GraphicsExcavation GE;
    private GraphicsIntersection GI;
    private ModelExcavation ME;
    private GraphicsAnchorsInt GAI;

    public GraphicsWindow() {
        GAE = new GraphicsAnchorsEx();
        GSE = new GraphicsShotcreteEx();
        GE = new GraphicsExcavation();
        GI = new GraphicsIntersection();
        ME = new ModelExcavation();
        GAI = new GraphicsAnchorsInt();

        // Анонимный внутренний класс для обработки событий закрытия окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Переопределяем метод paint для отрисовки
    public void paint(Graphics g) {
        int t = 2; // 1 - одиночная выработка, 2 - сопряжение выработок, 3 - тест
        switch (t) {
            case 1:
                g.translate(300, 400);
                GAE.paint(g);
                GE.paint(g);
                GSE.paint(g);
                break;
            case 2:
                g.translate(700, 700);
                GI.paint(g);
                GAI.paint(g);
                break;
            case 3:
                g.translate(600, 600);
                GAI.paint(g);
        }
    }
    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(1700, 1200));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}