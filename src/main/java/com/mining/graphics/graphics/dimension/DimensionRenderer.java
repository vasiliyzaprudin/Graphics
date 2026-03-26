package com.mining.graphics.graphics.dimension;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Класс для отрисовки линейных размеров
 */
public class DimensionRenderer {

    private static final int ARROW_SIZE = 10;            // размер стрелки в пикселях
    private static final int TEXT_OFFSET = -10;           // отступ текста от размерной линии

    private static final Color DIMENSION_COLOR = Color.BLACK;
    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color EXTENSION_COLOR = Color.GRAY;

    private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 14);

    /**
     * Универсальный метод отрисовки размера.
     *
     * @param g        Graphics2D объект
     * @param x1       x начала измеряемого отрезка
     * @param y1       y начала измеряемого отрезка
     * @param x2       x конца измеряемого отрезка
     * @param y2       y конца измеряемого отрезка
     * @param offset   смещение размерной линии от измеряемого отрезка (положительное - наружу)
     * @param text     текст размера
     */
    public static void drawDimension(Graphics2D g, int x1, int y1, int x2, int y2, int offset, String text) {
        // Вычисляем угол отрезка
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Вычисляем перпендикулярный угол (для смещения размерной линии)
        double perpAngle = angle + Math.PI / 2;

        // Смещаем размерную линию перпендикулярно отрезку
        int dx = (int) (offset * Math.cos(perpAngle));
        int dy = (int) (offset * Math.sin(perpAngle));

        // Точки размерной линии
        int dimX1 = x1 + dx;
        int dimY1 = y1 + dy;
        int dimX2 = x2 + dx;
        int dimY2 = y2 + dy;

        // Рисуем выносные линии
        drawExtensionLine(g, x1, y1, dimX1, dimY1);
        drawExtensionLine(g, x2, y2, dimX2, dimY2);

        // Рисуем размерную линию
        g.setColor(DIMENSION_COLOR);
        g.drawLine(dimX1, dimY1, dimX2, dimY2);

        // Рисуем стрелки
        drawArrow(g, dimX1, dimY1, angle + Math.PI);
        drawArrow(g, dimX2, dimY2, angle);

        // Рисуем текст
        int textX = (dimX1 + dimX2) / 2;
        int textY = (dimY1 + dimY2) / 2;

        // Смещаем текст от размерной линии
        textX += (int) (TEXT_OFFSET * Math.cos(perpAngle));
        textY += (int) (TEXT_OFFSET * Math.sin(perpAngle));

        drawText(g, textX, textY, angle, text);
    }

    /**
     * Отрисовка выносной линии
     */
    private static void drawExtensionLine(Graphics2D g, int fromX, int fromY, int toX, int toY) {
        g.setColor(EXTENSION_COLOR);
        g.drawLine(fromX, fromY, toX, toY);
    }

    /**
     * Отрисовка стрелки
     */
    private static void drawArrow(Graphics2D g, int x, int y, double angle) {
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        g.rotate(angle);

        Polygon arrow = new Polygon();
        arrow.addPoint(0, 0);
        arrow.addPoint(-ARROW_SIZE, -ARROW_SIZE / 2);
        arrow.addPoint(-ARROW_SIZE, ARROW_SIZE / 2);

        g.fillPolygon(arrow);
        g.setTransform(old);
    }

    /**
     * Отрисовка текста с поворотом
     */
    private static void drawText(Graphics2D g, int x, int y, double angle, String text) {
        AffineTransform old = g.getTransform();

        g.translate(x, y);
        g.rotate(angle);

        FontMetrics fm = g.getFontMetrics(TEXT_FONT);
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        g.translate(-textWidth / 2, textHeight / 4);

        // Фон под текстом
        g.setColor(Color.WHITE);
        g.fillRect(-2, -textHeight + 2, textWidth + 4, textHeight - 2);

        // Текст
        g.setColor(TEXT_COLOR);
        g.setFont(TEXT_FONT);
        g.drawString(text, 0, 0);

        g.setTransform(old);
    }
}