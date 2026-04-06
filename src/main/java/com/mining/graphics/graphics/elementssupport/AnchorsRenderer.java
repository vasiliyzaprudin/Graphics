package com.mining.graphics.graphics.elementssupport;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Класс для отрисовки анкеров
 */
public class AnchorsRenderer {


    private static int GRAPHICS_ANCHORS_SCALE = 100; //масштаб построений

    // Параметры анкеров в метрах
    private static final double DIAMETER_ANCHOR = 0.035;        //Диаметр анкера
    private static final double LEDGE_ANCHOR = 0.07;            //Выступ анкера за контур
    private static final double DIAMETER_BOREHOLE = 0.05;       //Диаметр шпура
    private static final double WIDTH_BASE_PLATE = 0.2;         //Ширина опорной плиты
    private static final double THICKNESS_BASE_PLATE = 0.015;   //Толщина опорной плиты
    private static final double LENGTH_FRONT_TIP = 0.06;        //Длина переднего наконечника
    private static final double LENGTH_BACK_TIP = 0.07;         //Длина заднего наконечника
    private static final double DIAMETER_TIP = 0.02;            //Диаметр наконечника
    private static final double DIAMETER_RING = 0.07;           //Диаметр кольца

    // Цвета
    private static final Color COLOR_MONOLITHIC_COMPONENT = (new Color(180, 190, 200));      // Светло серый цвет омоноличивающего состава
    private static final Color COLOR_EXPANSION_COMPONENT = (new Color(30, 50, 65));    // Серо-синий цвет анкера
    private static final Color AXIS_COLOR = Color.BLACK;       // Черный цвет оси

    /**
     * Этот метод рисует анкера c омоноличивающими составами.
     *
     * @param g  Graphics2D объект для рисования
     * @param x1 x координата начала анкера (опорная плита) в пикселях
     * @param y1 y координата начала анкера (опорная плита) в пикселях
     * @param x2 x координата конца анкера в пикселях
     * @param y2 y координата конца анкера в пикселях
     */
    public static void drawAnchorMonolithicCompositions(Graphics2D g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        double length = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        AffineTransform old = g.getTransform();
        g.translate(x1, y1);
        g.rotate(angle);

        int ledgeAnchor = (int) Math.round(LEDGE_ANCHOR * GRAPHICS_ANCHORS_SCALE);
        int widthBasePlate = (int) Math.round(WIDTH_BASE_PLATE * GRAPHICS_ANCHORS_SCALE);
        int thicnessBasePlate = (int) Math.round(THICKNESS_BASE_PLATE * GRAPHICS_ANCHORS_SCALE);
        int anchorWidth = (int) Math.round(DIAMETER_BOREHOLE * GRAPHICS_ANCHORS_SCALE);
        int anchorLength = (int) Math.round(length);
        int anchorDiameter = (int) Math.round(DIAMETER_ANCHOR * GRAPHICS_ANCHORS_SCALE);
        int diameterRing = (int) Math.round(DIAMETER_RING * GRAPHICS_ANCHORS_SCALE);

        // 1. Анкер
        g.setColor(COLOR_MONOLITHIC_COMPONENT);
        g.fillRect(-ledgeAnchor, -anchorDiameter / 2, anchorLength, anchorDiameter);

        // 2. Ось анкера (простая черная тонкая линия)
        g.setColor(AXIS_COLOR);
        g.setStroke(new BasicStroke(1.0f));
        g.drawLine(-ledgeAnchor, 0, anchorLength - ledgeAnchor, 0);

        // 3. Кольцо
        g.drawOval(-2 * diameterRing- thicnessBasePlate, -diameterRing/2, diameterRing, diameterRing);

        // 4. Опорная плита
        g.drawRect(-ledgeAnchor - thicnessBasePlate, -widthBasePlate / 2, thicnessBasePlate, widthBasePlate);

//        g.drawLine(-ledgeAnchor, -300, -ledgeAnchor, 300);
//        g.drawLine(anchorLength - ledgeAnchor, -300, anchorLength - ledgeAnchor, 300);

        g.setStroke(new BasicStroke(1.0f));
        g.setTransform(old);
    }

    /**
     * Этот метод рисует распорные анкера.
     *
     * @param g  Graphics2D объект для рисования
     * @param x1 x координата начала анкера
     * @param y1 y координата начала анкера
     * @param x2 x координата конца анкера
     * @param y2 y координата конца анкера
     */
    public static void drawExpansionAnchor(Graphics2D g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        double length = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        AffineTransform old = g.getTransform();

        g.translate(x1, y1);
        g.rotate(angle);

        int anchorDiameter = (int) Math.round(DIAMETER_ANCHOR * GRAPHICS_ANCHORS_SCALE);
        int anchorLength = (int) Math.round(length);
        int lengthFrontTip = (int) Math.round(LENGTH_FRONT_TIP * GRAPHICS_ANCHORS_SCALE);
        int lengthBackTip = (int) Math.round(LENGTH_BACK_TIP * GRAPHICS_ANCHORS_SCALE);
        int diameterTip = (int) Math.round(DIAMETER_TIP * GRAPHICS_ANCHORS_SCALE);
        int ledgeAnchor = (int) Math.round(LEDGE_ANCHOR * GRAPHICS_ANCHORS_SCALE);
        int widthBasePlate = (int) Math.round(WIDTH_BASE_PLATE * GRAPHICS_ANCHORS_SCALE);
        int thicnessBasePlate = (int) Math.round(THICKNESS_BASE_PLATE * GRAPHICS_ANCHORS_SCALE);

        g.setColor(COLOR_EXPANSION_COMPONENT);
        //Анкер
        g.drawRect(-ledgeAnchor, -anchorDiameter / 2, anchorLength - ledgeAnchor, anchorDiameter);
        //Опорная плита
        g.drawRect(-ledgeAnchor - thicnessBasePlate, -widthBasePlate / 2, thicnessBasePlate, widthBasePlate);
        //Наконечник в начале анкера
        g.drawRect(-ledgeAnchor - thicnessBasePlate - lengthFrontTip, -diameterTip / 2, lengthFrontTip, diameterTip);
        //Наконечник в конце анкера
        g.drawRect(anchorLength - ledgeAnchor - ledgeAnchor, -diameterTip / 2, lengthBackTip, diameterTip);

        g.setStroke(new BasicStroke(1.0f));
        g.setTransform(old);
    }

    public int getGraphicsAnchorsScale() {
        return GRAPHICS_ANCHORS_SCALE;
    }
}