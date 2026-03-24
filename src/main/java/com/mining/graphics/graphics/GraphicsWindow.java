package com.mining.graphics.graphics;

import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.*;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.MeshExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.ServiceMeshExcavation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {

    // Модели данных
    private final ModelExcavation model;
    private final MeshExcavation mesh;

    // Сервисы вычислений
    private final ServiceExcavation excavationService;
    private final ServiceMeshExcavation meshService;

    // Графические классы
    private final GraphicsExcavation graphicsExcavation;
    private final GraphicsAnchorsExcavation graphicsAnchorsExcavation;
    private final GraphicsShotcreteExcavation graphicsShotcreteExcavation;
    private final GraphicsMeshExcavation graphicsMeshExcavation;

    private final GraphicsIntersection graphicsIntersection;
    private final GraphicsAnchorsIntersection graphicsAnchorsIntersection;

    private final Drawing drawing;

    public GraphicsWindow() {
        // Инициализация моделей и сервисов
        model = new ModelExcavation();
        mesh = new MeshExcavation();
        excavationService = new ServiceExcavation();
        meshService = new ServiceMeshExcavation();

        // Инициализация графических классов
        graphicsExcavation = new GraphicsExcavation(model, excavationService);
        graphicsAnchorsExcavation = new GraphicsAnchorsExcavation();
        graphicsShotcreteExcavation = new GraphicsShotcreteExcavation();
        graphicsMeshExcavation = new GraphicsMeshExcavation(model, mesh, excavationService, meshService);

        graphicsIntersection = new GraphicsIntersection();
        graphicsAnchorsIntersection = new GraphicsAnchorsIntersection();

        drawing = new Drawing();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int numberExcavation = 1;
                switch (numberExcavation) {
                    case 1:
                        drawExcavation(g2d);
                        break;
                    case 3:
                        drawIntersection(g2d);
                        break;
                }
            }
        };

        panel.setBackground(Color.WHITE);
        panel.setDoubleBuffered(true);

        // Добавляем слушатели мыши на панель
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                drawing.mousePressed(e.getX(), e.getY());
            }
            public void mouseReleased(MouseEvent e) {
                drawing.mouseReleased(e.getX(), e.getY());
                panel.repaint();
            }
        });

        add(panel);

        setupWindowListener();
        setSize(new Dimension(1750, 1300));
        setTitle("Графический модуль");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawExcavation(Graphics2D g2d) {
        g2d.translate(550, 900);

        g2d.setColor(new Color(190, 190, 190));
        // graphicsShotcreteExcavation.graphicsShotcrete(g2d);
        // graphicsAnchorsExcavation.prepareAnchorCalculations();
        // graphicsAnchorsExcavation.drawAllAnchors(g2d);

        g2d.setColor(Color.BLACK);
        graphicsExcavation.drawCrossSectionExcavation(g2d);
        graphicsExcavation.drawLongSectionExcavation(g2d);

        g2d.setColor(new Color(119, 131, 143));
        graphicsMeshExcavation.drawCrossSectionExcavationMesh(g2d);

        g2d.translate(-550, -900);

        g2d.setColor(Color.BLUE);
        drawing.draw(g2d);
    }

    private void drawIntersection(Graphics2D g2d) {
        g2d.translate(500, 500);
        graphicsAnchorsIntersection.TestIntAnch(g2d);
        graphicsIntersection.GraphConstrInt3(g2d);
        graphicsIntersection.graphIntAc(g2d);
        graphicsAnchorsIntersection.graphAnchPlanIntConstr3(g2d);
        graphicsAnchorsIntersection.graphAnchProjIntConstr3(g2d);
        g2d.translate(-500, -500);
    }

    private void setupWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        GraphicsWindow appwin = new GraphicsWindow();
        appwin.setVisible(true);
    }
}