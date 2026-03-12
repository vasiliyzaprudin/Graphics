package com.mining.graphics.graphics;

import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.GraphicsAnchorsExcavation;
import com.mining.graphics.graphics.support.GraphicsAnchorsInt;
import com.mining.graphics.graphics.support.GraphicsShotcreteEx;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.support.ServiceAnchorsIntersection;

import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends Frame {

    private GraphicsAnchorsExcavation GAE;
    private GraphicsShotcreteEx GSE;
    private GraphicsExcavation GE;
    private GraphicsIntersection GI;
    private ModelExcavation ME;
    private GraphicsAnchorsInt GAI;
    private ServiceAnchorsIntersection SAI;
    private Setting S;

    public GraphicsWindow() {
        GAE = new GraphicsAnchorsExcavation();
        GSE = new GraphicsShotcreteEx();
        GE = new GraphicsExcavation();
        GI = new GraphicsIntersection();
        ME = new ModelExcavation();
        GAI = new GraphicsAnchorsInt();
        SAI = new ServiceAnchorsIntersection();
        S = new Setting();

        // Анонимный внутренний класс для обработки событий закрытия окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Переопределяем метод paint для отрисовки
    public void paint(Graphics g) {
        S.setGraph(g);
        int t = 1; // 1 - одиночная выработка, 3 - сопряжение 3 выработок
        switch (t) {
            case 1:
                g.translate(600, 800);
                GAE.paint(g);
                GE.graphEx(g);
                //GE.graphExSide(g);
                //GE.graphExInf(g);
                GSE.paint(g);
                break;
            case 3:
                g.translate(500, 500);
                GAI.TestIntAnch(g); //проверка правильности построения анкеров в плане сопряжения
                GI.GraphConstrInt3(g); //построение сопряжения в плане
                GI.graphIntAc(g); //построение сечения сопряжения
                GAI.graphAnchPlanIntConstr3(g); //построение анкеров в плане сопряжения
                GAI.graphAnchProjIntConstr3(g); //построение анкеров в проекции сопряжения
                //GAI.InformationInt(g); //информация о параметрах сопряжения
                break;
        }
    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setSize(new Dimension(1750, 1300));
        appwin.setTitle("Graphics");
        appwin.setVisible(true);
    }
}