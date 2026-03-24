package com.mining.graphics.graphics.elementssupport;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Класс для отрисовки анкеров
 */
public class AnchorsRenderer {
    public static int GRAPHICS_ANCHORS_SCALE = 100; //масштаб построений

    // Параметры отрисовки в метрах
    private static final double DIAMETER_ANCHOR = 0.04;        // Диаметр анкера
    private static final double DIAMETER_BOREHOLE = 0.06;      // Диаметр шпура

    // Цвета
    private static final Color COLOR_MONOLITHIC_COMPONENT = (new Color(190, 190, 190));      // Светло серый цвет омоноличивающего состава
    private static final Color ANCHOR_COLOR = (new Color(65, 100, 130));    // Серо-синий цвет анкера
    private static final Color AXIS_COLOR = Color.BLACK;       // Черный цвет оси

    /**
     * Этот метод рисует анкера c омоноличивающими составами.
     *
     * @param g      Graphics2D объект для рисования
     * @param x1     x координата начала анкера (опорная плита) в пикселях
     * @param y1     y координата начала анкера (опорная плита) в пикселях
     * @param x2     x координата конца анкера в пикселях
     * @param y2     y координата конца анкера в пикселях
     */
    public static void drawAnchorMonolithicCompositions(Graphics2D g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int length = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        AffineTransform old = g.getTransform();
        g.translate(x1, y1);
        g.rotate(angle);

//        // 1. Анкер (линия)
//        int anchorThickness = (int) Math.round(DIAMETER_ANCHOR * GRAPHICS_ANCHORS_SCALE);
//        g.setColor(ANCHOR_COLOR);
//        g.setStroke(new BasicStroke(anchorThickness));
//        g.drawLine(0, 0, length, 0);

        // 1. Анкер
        int anchorWidth = (int) Math.round(DIAMETER_BOREHOLE * GRAPHICS_ANCHORS_SCALE);
        int anchorLength = length;

        g.setColor(COLOR_MONOLITHIC_COMPONENT);
        g.fillRect(0, -anchorWidth / 2, anchorLength, anchorWidth);
        //g.setColor(COLOR_MONOLITHIC_COMPONENT.darker());
        g.drawRect(0, -anchorWidth / 2, anchorLength, anchorWidth);

        // 2. Ось анкера (простая черная тонкая линия)
        g.setColor(AXIS_COLOR);
        g.setStroke(new BasicStroke(1.0f));
        g.drawLine(0, 0, length, 0);


//        double amplitude = 1.0;   // Амплитуда волны
//        double wavelength = 30.0; // Длина волны
//        // Используем Path2D для более плавной линии
//        Path2D wavePath = new Path2D.Double();
//        wavePath.moveTo(0, 0);
//
//        for (double x = 0; x <= length; x += 2.0) {
//            double y = amplitude * Math.sin(2 * Math.PI * x / wavelength);
//            wavePath.lineTo(x, y);
//        }
//        g.draw(wavePath);


        g.setTransform(old);
    }

    /**
     * Этот метод рисует распорные анкера.
     *
     * @param g      Graphics2D объект для рисования
     * @param x1     x координата начала анкера
     * @param y1     y координата начала анкера
     * @param x2     x координата конца анкера
     * @param y2     y координата конца анкера
     */
    public static void drawExpansionAnchor(Graphics2D g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int length = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        AffineTransform old = g.getTransform();

        g.translate(x1, y1);
        g.rotate(angle);

        // 1. Анкер
        int anchorWidth = (int) Math.round(DIAMETER_ANCHOR * GRAPHICS_ANCHORS_SCALE);

        g.setColor(ANCHOR_COLOR);
        g.drawRect(0, -anchorWidth / 2, length, anchorWidth);
        g.setColor(ANCHOR_COLOR.darker());
        g.drawRect(0, -anchorWidth / 2, length, anchorWidth);

        g.setStroke(new BasicStroke(1.0f));
        g.setTransform(old);
    }
}