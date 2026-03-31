package com.mining.graphics.graphics.dimension;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Класс для отрисовки линейных размеров
 */
public class DimensionRenderer {

    private static final int ARROW_SIZE = 10;            // размер стрелки в пикселях
    private static final int TEXT_OFFSET = -10;          // отступ текста от размерной линии для больших размеров

    private static final int TEXT_OFFSET_FLIPPED = -12;  // отступ для перевернутого текста
    private static final int MIN_DIMENSION_FOR_OUTSIDE_ARROWS = 50; // минимальный размер для внешних стрелок (пиксели)
    private static final int ARROW_LENGTH = 25; //длина стрелки для маленьких размеров

    private static final Color DIMENSION_COLOR = Color.BLACK;
    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color EXTENSION_COLOR = Color.BLACK;

    private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 14);

    /**
     * Универсальный метод отрисовки размера.
     *
     * @param g                   Graphics2D объект
     * @param x1                  x начала измеряемого отрезка
     * @param y1                  y начала измеряемого отрезка
     * @param x2                  x конца измеряемого отрезка
     * @param y2                  y конца измеряемого отрезка
     * @param offset              смещение размерной линии от измеряемого отрезка (положительное - наружу)
     * @param lengthextensionline длина выноски
     * @param text                текст размера
     * @param textOnOppositeSide  true - текст с противоположной стороны от размерной линии
     */
    public static void drawDimension(Graphics2D g, int x1, int y1, int x2, int y2, int offset, int lengthextensionline, String text, boolean textOnOppositeSide) {
        // Вычисляем длину размера
        double dimensionLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Определяем, нужно ли использовать внешние стрелки
        boolean useOutsideArrows = dimensionLength < MIN_DIMENSION_FOR_OUTSIDE_ARROWS;

        if (useOutsideArrows) {
            drawDimensionWithOutsideArrows(g, x1, y1, x2, y2, offset, lengthextensionline, text, textOnOppositeSide);
        } else {
            drawDimensionWithInsideArrows(g, x1, y1, x2, y2, offset, lengthextensionline, text, textOnOppositeSide);
        }
    }

    /**
     * Отрисовка размера с внутренними стрелками (стандартный вариант)
     */
    private static void drawDimensionWithInsideArrows(Graphics2D g, int x1, int y1, int x2, int y2, int offset, int lengthextensionline, String text, boolean textOnOppositeSide) {
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

        // Точки выносной линии
        int extX1 = dimX1 - (int) (lengthextensionline * Math.cos(perpAngle));
        int extY1 = dimY1 - (int) (lengthextensionline * Math.sin(perpAngle));
        int extX2 = dimX2 - (int) (lengthextensionline * Math.cos(perpAngle));
        int extY2 = dimY2 - (int) (lengthextensionline * Math.sin(perpAngle));

        // Рисуем выносные линии
        drawExtensionLine(g, extX1, extY1, dimX1, dimY1);
        drawExtensionLine(g, extX2, extY2, dimX2, dimY2);

        // Рисуем размерную линию
        g.setColor(DIMENSION_COLOR);
        g.drawLine(dimX1, dimY1, dimX2, dimY2);

        // Рисуем стрелки (внутренние)
        drawArrow(g, dimX1, dimY1, angle + Math.PI);
        drawArrow(g, dimX2, dimY2, angle);

        // Рисуем текст
        drawDimensionText(g, dimX1, dimY1, dimX2, dimY2, angle, perpAngle, text, textOnOppositeSide);
    }

    /**
     * Отрисовка размера с внешними стрелками (для маленьких размеров)
     */
    private static void drawDimensionWithOutsideArrows(Graphics2D g, int x1, int y1, int x2, int y2, int offset, int lengthextensionline, String text, boolean textOnOppositeSide) {
        // Вычисляем угол отрезка
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Вычисляем перпендикулярный угол (для смещения размерной линии)
        double perpAngle = angle + Math.PI / 2;

        // Смещаем размерную линию перпендикулярно отрезку
        int dx = (int) (offset * Math.cos(perpAngle));
        int dy = (int) (offset * Math.sin(perpAngle));

        // Точки на размерной линии (между выносными)
        int lineX1 = x1 + dx;
        int lineY1 = y1 + dy;
        int lineX2 = x2 + dx;
        int lineY2 = y2 + dy;

        // Вычисляем направление размерной линии (единичный вектор)
        double lineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double dirX = (x2 - x1) / lineLength;
        double dirY = (y2 - y1) / lineLength;

        // Точки для внешних стрелок (СНАРУЖИ от выносных линий)
        // Отступаем от точек размерной линии наружу
        int arrow1X = lineX1 - (int) (dirX * ARROW_SIZE * 1);
        int arrow1Y = lineY1 - (int) (dirY * ARROW_SIZE * 1);

        int arrow2X = lineX2 + (int) (dirX * ARROW_SIZE * 1);
        int arrow2Y = lineY2 + (int) (dirY * ARROW_SIZE * 1);

        // Точки выносных линий (отступаем от размерной линии)
        int extX1 = lineX1 - (int) (lengthextensionline * Math.cos(perpAngle));
        int extY1 = lineY1 - (int) (lengthextensionline * Math.sin(perpAngle));
        int extX2 = lineX2 - (int) (lengthextensionline * Math.cos(perpAngle));
        int extY2 = lineY2 - (int) (lengthextensionline * Math.sin(perpAngle));

        // Рисуем выносные линии (от внешних точек до размерной линии)
        drawExtensionLine(g, extX1, extY1, lineX1, lineY1);
        drawExtensionLine(g, extX2, extY2, lineX2, lineY2);

        // Рисуем размерную линию (между точками на выносных линиях)
        g.setColor(DIMENSION_COLOR);
        g.drawLine(lineX1, lineY1, lineX2, lineY2);

        // Рисуем стрелки СНАРУЖИ (развернутые на 180 градусов)
        drawOutsideArrow(g, lineX1, lineY1, angle);           // стрелка смотрит влево/вниз
        drawOutsideArrow(g, lineX2, lineY2, angle + Math.PI); // стрелка смотрит вправо/вверх

        // Рисуем текст над удлинением первой стрелки
        // Вычисляем точку на конце удлинения стрелки
        int extensionEndX = lineX1 - (int)(dirX * (ARROW_SIZE + ARROW_LENGTH));
        int extensionEndY = lineY1 - (int)(dirY * (ARROW_SIZE + ARROW_LENGTH));

        int textX = extensionEndX;
        int textY = extensionEndY;

        // Смещаем текст перпендикулярно размерной линии
        int textOffset = TEXT_OFFSET;
        if (textOnOppositeSide) {
            textOffset = -TEXT_OFFSET_FLIPPED;
        }

        textX += (int) (textOffset * Math.cos(perpAngle));
        textY += (int) (textOffset * Math.sin(perpAngle));

        drawText(g, textX, textY, angle, text, textOnOppositeSide);
    }

    /**
     * Отрисовка текста для стандартного размера
     */
    private static void drawDimensionText(Graphics2D g, int dimX1, int dimY1, int dimX2, int dimY2, double angle, double perpAngle, String text, boolean textOnOppositeSide) {
        int textX = (dimX1 + dimX2) / 2;
        int textY = (dimY1 + dimY2) / 2;

        // Смещаем текст от размерной линии в зависимости от параметра
        int textOffset;
        if (textOnOppositeSide) {
            textOffset = -TEXT_OFFSET_FLIPPED;
        } else {
            textOffset = TEXT_OFFSET;
        }

        // Смещаем текст от размерной линии
        textX += (int) (textOffset * Math.cos(perpAngle));
        textY += (int) (textOffset * Math.sin(perpAngle));

        drawText(g, textX, textY, angle, text, textOnOppositeSide);
    }

    /**
     * Отрисовка выносной линии
     */
    private static void drawExtensionLine(Graphics2D g, int fromX, int fromY, int toX, int toY) {
        g.setColor(EXTENSION_COLOR);
        g.drawLine(fromX, fromY, toX, toY);
    }

    /**
     * Отрисовка стандартной стрелки (внутренней)
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
     * Отрисовка внешней стрелки (развернутой наружу, на 180 градусов)
     */
    private static void drawOutsideArrow(Graphics2D g, int x, int y, double angle) {
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        // Разворачиваем стрелку на 180 градусов, чтобы она "смотрела" наружу
        g.rotate(angle);

        Polygon arrow = new Polygon();
        arrow.addPoint(0, 0);
        arrow.addPoint(-ARROW_SIZE, -ARROW_SIZE / 2);
        arrow.addPoint(-ARROW_SIZE, ARROW_SIZE / 2);


        g.fillPolygon(arrow);
        // Рисуем удлинение стрелки (прямая линия от основания наружу)
        g.drawLine(-ARROW_SIZE, 0, -ARROW_SIZE - ARROW_LENGTH, 0);
        g.setTransform(old);
    }

    /**
     * Отрисовка текста с поворотом
     */
    private static void drawText(Graphics2D g, int x, int y, double angle, String text, boolean textOnOppositeSide) {
        AffineTransform old = g.getTransform();

        g.translate(x, y);

        // Корректируем угол поворота текста в зависимости от стороны
        double textAngle = angle;
        if (textOnOppositeSide) {
            textAngle = angle + Math.PI; // Поворачиваем на 180 градусов
        }

        g.rotate(textAngle);

        FontMetrics fm = g.getFontMetrics(TEXT_FONT);
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int textDescent = fm.getDescent();

        // Для перевернутого текста нужно скорректировать смещение
        if (textOnOppositeSide) {
            // При перевороте текста точка привязки меняется
            // Смещаем так, чтобы текст был ближе к размерной линии
            g.translate(-textWidth / 2, textHeight / 2 - textDescent);
        } else {
            g.translate(-textWidth / 2, textHeight / 4);
        }

        // Фон под текстом
        g.setColor(Color.WHITE);
        g.fillRect(-2, -textHeight + 2, textWidth + 4, textHeight - 2);

        // Текст
        g.setColor(TEXT_COLOR);
        g.setFont(TEXT_FONT);
        g.drawString(text, 0, 0);

        g.setTransform(old);
    }

    /**
     * Дополнительный метод для принудительной отрисовки размера с внешними стрелками
     */
    public static void drawDimensionWithOutsideArrowsForced(Graphics2D g, int x1, int y1, int x2, int y2, int offset, int lengthextensionline, String text, boolean textOnOppositeSide) {
        drawDimensionWithOutsideArrows(g, x1, y1, x2, y2, offset, lengthextensionline, text, textOnOppositeSide);
    }
}