package com.mining.graphics.graphics;

import com.mining.graphics.controlpanel.ControlPanelExcavation;
import com.mining.graphics.controlpanel.ControlPanelIntersection;
import com.mining.graphics.graphics.dimension.GraphicsDimension;
import com.mining.graphics.graphics.drawing.Drawing;
import com.mining.graphics.graphics.drawing.DrawingMouse;
import com.mining.graphics.graphics.elementssupport.AnchorsRenderer;
import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.graphics.excavation.GraphicsIntersection;
import com.mining.graphics.graphics.support.excavation.GraphicsAnchorsExcavation;
import com.mining.graphics.graphics.support.excavation.GraphicsMeshExcavation;
import com.mining.graphics.graphics.support.excavation.GraphicsShotcreteExcavation;
import com.mining.graphics.graphics.support.intersection.GraphicsAnchorsIntersection;
import com.mining.graphics.graphics.support.intersection.GraphicsMeshIntersection;
import com.mining.graphics.graphics.support.intersection.GraphicsShotcreteIntersection;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.excavation.MeshExcavation;
import com.mining.graphics.model.support.excavation.ShotcreteExcavation;
import com.mining.graphics.model.support.intersection.AnchorsIntersection;
import com.mining.graphics.model.support.intersection.MeshIntersection;
import com.mining.graphics.model.support.intersection.ShotcreteIntersection;
import com.mining.graphics.model.test.ModelTest;
import com.mining.graphics.service.excavation.ServiceExcavation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {

    private int currentMode = 3; // 1 - одиночная выработка, 2 - анкер, 3 - сопряжение

    // Компоненты UI для переключения режимов
    private JButton excavationModeButton;
    private JButton intersectionModeButton;
    private JButton anchorModeButton;

    // Цветовая схема
    private static final Color BUTTON_BG = new Color(85, 109, 88);
    private static final Color BUTTON_FG = Color.WHITE;
    private static final Color BUTTON_HOVER_BG = new Color(65, 89, 68);
    private static final Color PANEL_BG = new Color(238, 234, 226);

    // Панели управления
    private ControlPanelExcavation controlPanelExcavation;
    private ControlPanelIntersection controlPanelIntersection;
    private JPanel currentControlPanel;

    // Модели данных
    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;
    private final MeshExcavation meshExcavation;
    private final ShotcreteExcavation shotcreteExcavation;

    private final ModelIntersection modelIntersection;
    private final CoordinatesIntersection modelCoordinatesIntersection;
    private final CoordinatesIntersection shotcreteCoordinatesIntersection;
    private final CoordinatesIntersection meshCoordinatesIntersection;
    private final AnchorsIntersection anchorsIntersection;
    private final ShotcreteIntersection shotcreteIntersection;
    private final MeshIntersection meshIntersection;


    private final AnchorsRenderer anchorsRenderer;

    // Сервисы вычислений
    private final ServiceExcavation serviceExcavation;

    // Графические классы
    private final GraphicsExcavation graphicsExcavation;
    private final GraphicsAnchorsExcavation graphicsAnchors;
    private final GraphicsShotcreteExcavation graphicsShotcreteExcavation;
    private final GraphicsMeshExcavation graphicsMeshExcavation;
    private final GraphicsDimension graphicsDimension;

    private final GraphicsIntersection graphicsIntersection;
    private final GraphicsAnchorsIntersection graphicsAnchorsIntersection;
    private final GraphicsShotcreteIntersection graphicsShotcreteIntersection;
    private final GraphicsMeshIntersection graphicsMeshIntersection;

    //Тесты
    private final ModelTest modelTest;

    private final Drawing drawing;

    private JPanel drawingPanel;

    public GraphicsWindow() {
        //Инициализация тестов
        modelTest = new ModelTest();

        // Инициализация моделей и сервисов
        modelExcavation = new ModelExcavation();
        anchorsExcavation = new AnchorsExcavation();
        meshExcavation = new MeshExcavation();
        shotcreteExcavation = new ShotcreteExcavation();

        modelIntersection = new ModelIntersection();
        modelCoordinatesIntersection = new CoordinatesIntersection(modelIntersection);
        shotcreteIntersection = new ShotcreteIntersection();
        shotcreteCoordinatesIntersection = new CoordinatesIntersection(modelIntersection);
        meshCoordinatesIntersection = new CoordinatesIntersection(modelIntersection);
        anchorsIntersection = new AnchorsIntersection();
        meshIntersection = new MeshIntersection();

        anchorsRenderer = new AnchorsRenderer();

        serviceExcavation = new ServiceExcavation();

        // Инициализация графических классов
        graphicsExcavation = new GraphicsExcavation(modelExcavation);
        graphicsAnchors = new GraphicsAnchorsExcavation(modelExcavation, anchorsExcavation, anchorsRenderer);
        graphicsMeshExcavation = new GraphicsMeshExcavation(modelExcavation, meshExcavation);
        graphicsShotcreteExcavation = new GraphicsShotcreteExcavation(modelExcavation, shotcreteExcavation);

        graphicsIntersection = new GraphicsIntersection(modelIntersection, modelCoordinatesIntersection, graphicsExcavation);
        graphicsAnchorsIntersection = new GraphicsAnchorsIntersection(modelIntersection, modelCoordinatesIntersection, anchorsIntersection, modelTest, anchorsRenderer);
        graphicsShotcreteIntersection = new GraphicsShotcreteIntersection(shotcreteCoordinatesIntersection, modelIntersection);
        graphicsMeshIntersection = new GraphicsMeshIntersection(meshCoordinatesIntersection, modelIntersection, meshIntersection);

        graphicsDimension = new GraphicsDimension(modelExcavation, anchorsExcavation, shotcreteExcavation, serviceExcavation);

        drawing = new Drawing();

        // Создаем панель для рисования
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                switch (currentMode) {
                    case 1:
                        drawExcavation(g2d);
                        break;
                    case 2:
                        drawAnchor(g2d);
                        break;
                    case 3:
                        drawIntersection(g2d);
                        break;
                }
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setDoubleBuffered(true);
        drawingPanel.setPreferredSize(new Dimension(1700, 1300));


        controlPanelExcavation = new ControlPanelExcavation(modelExcavation, anchorsExcavation, drawingPanel);
        controlPanelIntersection = new ControlPanelIntersection(modelIntersection, modelCoordinatesIntersection,
                shotcreteCoordinatesIntersection,
                meshCoordinatesIntersection,
                anchorsIntersection,
                drawingPanel);

        // Создаем панель для переключения режимов со стилизованными кнопками
        JPanel modePanel = createModePanel();

        // Устанавливаем начальную панель управления
        currentControlPanel = controlPanelExcavation;

        // Настраиваем JFrame - используем BorderLayout
        setLayout(new BorderLayout());

        // Верхняя панель с переключателями режимов
        add(modePanel, BorderLayout.NORTH);

        // Левая панель с управлением (будет обновляться при смене режима)
        updateControlPanel();

        // Центральная панель с рисованием
        add(drawingPanel, BorderLayout.CENTER);

        // Устанавливаем обработчик рисования
        DrawingMouse mouseHandler = new DrawingMouse(drawing, drawingPanel);
        mouseHandler.install();

        setupWindowListener();
        setTitle("Графический модуль");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createModePanel() {
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        modePanel.setBackground(PANEL_BG);
        modePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(238, 234, 226)), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        excavationModeButton = createModeButton("Одиночная выработка", true);
        intersectionModeButton = createModeButton("Сопряжение выработок", false);
        anchorModeButton = createModeButton("Анкер", false);

        modePanel.add(excavationModeButton);
        modePanel.add(intersectionModeButton);
        modePanel.add(anchorModeButton);

        return modePanel;
    }

    private JButton createModeButton(String text, boolean isSelected) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(isSelected ? new Color(65, 89, 68) : BUTTON_BG);
        button.setForeground(BUTTON_FG);
        button.setFocusPainted(false);

        button.setPreferredSize(new Dimension(250, 40));
        button.setMinimumSize(new Dimension(250, 40));
        button.setMaximumSize(new Dimension(250, 40));

        button.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(e -> {
            if (button == excavationModeButton) {
                switchMode(1);
                updateButtonStates(excavationModeButton);
            } else if (button == intersectionModeButton) {
                switchMode(3);
                updateButtonStates(intersectionModeButton);
            } else if (button == anchorModeButton) {
                switchMode(2);
                updateButtonStates(anchorModeButton);
            }
        });
        return button;
    }

    private void updateButtonStates(JButton activeButton) {
        excavationModeButton.setBackground(BUTTON_BG);
        intersectionModeButton.setBackground(BUTTON_BG);
        anchorModeButton.setBackground(BUTTON_BG);
        activeButton.setBackground(new Color(60, 60, 60));
    }

    private void switchMode(int mode) {
        this.currentMode = mode;
        updateControlPanel();
        drawingPanel.repaint();
    }

    private void updateControlPanel() {
        if (currentControlPanel != null) {
            remove(currentControlPanel);
        }

        switch (currentMode) {
            case 1:
                currentControlPanel = controlPanelExcavation;
                break;
            case 2:
                currentControlPanel = controlPanelExcavation;
                break;
            case 3:
                currentControlPanel = controlPanelIntersection;
                break;
        }

        add(currentControlPanel, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    private void drawExcavation(Graphics2D g2d) {
        g2d.translate(600, 900);

        g2d.setColor(new Color(200, 200, 200));
        graphicsShotcreteExcavation.drawCrossSectionExcavationShotcrete(g2d);
        graphicsShotcreteExcavation.drawLongSectionExcavationShotcrete(g2d);

        g2d.setColor(new Color(30, 50, 65));
        graphicsAnchors.prepareAnchorCalculations();
        graphicsAnchors.drawAllAnchors(g2d);
        g2d.setColor(new Color(120, 90, 145));

        g2d.setColor(Color.BLACK);
        graphicsExcavation.drawCrossSectionExcavation(g2d);
        graphicsExcavation.drawLongSectionExcavation(g2d);

        g2d.setColor(new Color(119, 131, 143));
        graphicsMeshExcavation.drawCrossSectionExcavationMesh(g2d);
        graphicsMeshExcavation.drawLongSectionExcavationMesh(g2d);

        g2d.setColor(Color.BLACK);
        graphicsDimension.drawCrossSectionDimensions(g2d);

        g2d.translate(-600, -900);

        g2d.setColor(Color.BLUE);
        //drawing.draw(g2d);
    }

    private void drawIntersection(Graphics2D g2d) {
        g2d.translate(500, 400);

        g2d.setColor(Color.BLACK);
        graphicsIntersection.drawPlanIntersection3(g2d);
        graphicsIntersection.drawProfileIntersection3(g2d);

        graphicsAnchorsIntersection.drawAllAnchorsPlanRounding3(g2d);
        graphicsAnchorsIntersection.drawAllAnchorsPlanLine3(g2d);
        graphicsAnchorsIntersection.drawAllAnchorsProjectionLine3(g2d);
        graphicsAnchorsIntersection.drawBasePlateProjection(g2d);

        graphicsShotcreteIntersection.drawShotcretePlanIntersection3(g2d);
        graphicsShotcreteIntersection.drawShotcreteProfileIntersection3(g2d);

        graphicsMeshIntersection.graphicsMeshPlanIntersection3(g2d);
        graphicsMeshIntersection.graphicsMeshProfileIntersection3(g2d);
        g2d.translate(-500, -400);
    }

    private void drawAnchor(Graphics2D g2d) {
        g2d.translate(550, 600);

        double anchorLengthMeters = anchorsExcavation.getLengthAnchor();
        int scale = 300;
        int anchorLength = (int) Math.round(anchorLengthMeters * scale);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Деталь анкерного крепления", 50, -50);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        g2d.drawString("Анкер распорного типа:", 50, 20);
        anchorsRenderer.drawExpansionAnchor(g2d, 50, 30, anchorLength, 30);

        g2d.drawString("Анкер с монолитными составами:", 50, 120);
        anchorsRenderer.drawAnchorMonolithicCompositions(g2d, 50, 130, anchorLength, 130);

        g2d.setColor(Color.GRAY);
        g2d.drawLine(50, -10, 50 + anchorLength, -10);
        g2d.drawLine(50, -15, 50, -5);
        g2d.drawLine(50 + anchorLength, -15, 50 + anchorLength, -5);
        g2d.drawString(String.format("%.2f м", anchorLengthMeters), 50 + anchorLength / 2 - 20, -5);

        g2d.translate(-550, -600);
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