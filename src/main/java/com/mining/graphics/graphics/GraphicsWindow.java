package com.mining.graphics.graphics;

import com.mining.graphics.controlpanel.ControlPanel;
import com.mining.graphics.graphics.dimension.GraphicsDimension;
import com.mining.graphics.graphics.drawing.Drawing;
import com.mining.graphics.graphics.drawing.DrawingMouse;
import com.mining.graphics.graphics.elementssupport.AnchorsRenderer;
import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.*;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.model.support.MeshExcavation;
import com.mining.graphics.model.support.ShotcreteExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.ServiceMeshExcavation;
import com.mining.graphics.service.support.ServiceShotcreteExcavation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {

    // Модели данных
    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;
    private final MeshExcavation meshExcavation;
    private final ShotcreteExcavation shotcreteExcavation;

    private final AnchorsRenderer anchorsRenderer;

    // Сервисы вычислений
    private final ServiceExcavation serviceExcavation;
    private final ServiceMeshExcavation serviceMeshExcavation;
    private final ServiceShotcreteExcavation serviceShotcreteExcavation;

    // Графические классы
    private final GraphicsExcavation graphicsExcavation;
    private final GraphicsAnchorsExcavation graphicsAnchors;
    private final GraphicsShotcreteExcavation graphicsShotcreteExcavation;
    private final GraphicsMeshExcavation graphicsMeshExcavation;
    private final GraphicsDimension graphicsDimension;

    private final GraphicsIntersection graphicsIntersection;
    private final GraphicsAnchorsIntersection graphicsAnchorsIntersection;

    private final Drawing drawing;

    private JPanel drawingPanel;

    public GraphicsWindow() {
        // Инициализация моделей и сервисов
        modelExcavation = new ModelExcavation();
        anchorsExcavation = new AnchorsExcavation();
        meshExcavation = new MeshExcavation();
        shotcreteExcavation = new ShotcreteExcavation();

        anchorsRenderer = new AnchorsRenderer();

        serviceExcavation = new ServiceExcavation();
        serviceMeshExcavation = new ServiceMeshExcavation();
        serviceShotcreteExcavation = new ServiceShotcreteExcavation();

        // Инициализация графических классов
        graphicsExcavation = new GraphicsExcavation(modelExcavation, serviceExcavation);
        graphicsAnchors = new GraphicsAnchorsExcavation(modelExcavation, anchorsExcavation, anchorsRenderer);
        graphicsMeshExcavation = new GraphicsMeshExcavation(modelExcavation, meshExcavation, serviceExcavation, serviceMeshExcavation);
        graphicsShotcreteExcavation = new GraphicsShotcreteExcavation(modelExcavation, shotcreteExcavation, serviceExcavation, serviceShotcreteExcavation);

        graphicsIntersection = new GraphicsIntersection();
        graphicsAnchorsIntersection = new GraphicsAnchorsIntersection();

        graphicsDimension = new GraphicsDimension(modelExcavation, serviceExcavation);

        drawing = new Drawing();

        // Создаем панель для рисования
        drawingPanel = new JPanel() {
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
                    case 4:
                        drawAnchor(g2d);
                        break;
                }
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setDoubleBuffered(true);
        drawingPanel.setPreferredSize(new Dimension(1700, 1300));

        // Создаем панель управления
        ControlPanel controlPanel = new ControlPanel(modelExcavation, anchorsExcavation, drawingPanel);

        // Устанавливаем обработчик рисования
        DrawingMouse mouseHandler = new DrawingMouse(drawing, drawingPanel);
        mouseHandler.install();

        // Настраиваем JFrame
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);

        setupWindowListener();
        setTitle("Графический модуль");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void drawExcavation(Graphics2D g2d) {
        g2d.translate(550, 900);

        g2d.setColor(new Color(200, 200, 200));
        graphicsShotcreteExcavation.drawCrossSectionExcavationShotcrete(g2d);
        graphicsShotcreteExcavation.drawLongSectionExcavationShotcrete(g2d);

        g2d.setColor(new Color(30, 50, 65));
        graphicsAnchors.prepareAnchorCalculations();
        graphicsAnchors.drawAllAnchors(g2d);
        g2d.setColor(new Color(120, 90, 145));
        graphicsAnchors.drawAllAnchorsTest(g2d);

        g2d.setColor(Color.BLACK);
        graphicsExcavation.drawCrossSectionExcavation(g2d);
        graphicsExcavation.drawLongSectionExcavation(g2d);

        g2d.setColor(new Color(119, 131, 143));
        graphicsMeshExcavation.drawCrossSectionExcavationMesh(g2d);
        graphicsMeshExcavation.drawLongSectionExcavationMesh(g2d);

        // Отрисовка размеров
        g2d.setColor(Color.BLACK);
        graphicsDimension.drawCrossSectionDimensions(g2d);

        g2d.translate(-550, -900);

        g2d.setColor(Color.BLUE);
        //drawing.draw(g2d);
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

    private void drawAnchor(Graphics2D g2d) {
        g2d.translate(550, 600);

        double anchorLengthMeters = anchorsExcavation.getLengthAnchor();
        int scale = 300;
        int anchorLength = (int) Math.round(anchorLengthMeters * scale);

        anchorsRenderer.drawExpansionAnchor(g2d, 0, 0, anchorLength, 0);
        anchorsRenderer.drawAnchorMonolithicCompositions(g2d, 0, 100, anchorLength, 100);
    }

    private void setupWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            GraphicsWindow appwin = new GraphicsWindow();
            appwin.setVisible(true);
        });
    }
}