package com.mining.graphics.graphics;

import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.GraphicsAnchorsEx;
import com.mining.graphics.graphics.support.GraphicsAnchorsInt;
import com.mining.graphics.graphics.support.GraphicsShotcreteEx;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.support.ServiceAnchorsInt;

import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends Frame {
    private GraphicsAnchorsEx GAE;
    private GraphicsShotcreteEx GSE;
    private GraphicsExcavation GE;
    private GraphicsIntersection GI;
    private ModelExcavation ME;
    private GraphicsAnchorsInt GAI;
    private ServiceAnchorsInt SAI;

    public GraphicsWindow() {
        GAE = new GraphicsAnchorsEx();
        GSE = new GraphicsShotcreteEx();
        GE = new GraphicsExcavation();
        GI = new GraphicsIntersection();
        ME = new ModelExcavation();
        GAI = new GraphicsAnchorsInt();
        SAI = new ServiceAnchorsInt();

        // Анонимный внутренний класс для обработки событий закрытия окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Переопределяем метод paint для отрисовки
    public void paint(Graphics g) {
        int t = 2; // 3 - одиночная выработка, 2 - сопряжение выработок, 3 - тест
        switch (t) {
            case 1:
                g.translate(300, 400);
                GAE.paint(g);
                GE.paint(g);
                GSE.paint(g);
                break;
            case 2:
                g.translate(500, 500);
                GI.paint(g);
                GAI.paint(g);
                break;
            case 3:
        }
    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(1750, 1300));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}