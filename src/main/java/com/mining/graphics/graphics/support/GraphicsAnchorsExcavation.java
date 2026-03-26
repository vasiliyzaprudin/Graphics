package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.graphics.elementssupport.AnchorsRenderer;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.service.support.CalculateCoordinatesAnchorsExcavation;
import com.mining.graphics.service.support.ServiceAnchors;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

public class GraphicsAnchorsExcavation {
    // Константы для типов анкеров
    public static final String ANCHOR_EXPANSION = "expansion";
    public static final String ANCHOR_MONOLITHIC = "monolithic";

    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;
    private final CalculateCoordinatesAnchorsExcavation calculator;
    private final AnchorsRenderer anchorsRenderer;

    public GraphicsAnchorsExcavation(ModelExcavation modelExcavation, AnchorsExcavation anchorsExcavation, AnchorsRenderer anchorsRenderer) {
        this.modelExcavation = modelExcavation;
        this.anchorsExcavation = anchorsExcavation;
        this.calculator = new CalculateCoordinatesAnchorsExcavation(
                new ServiceExcavation(),
                new ServiceAnchors()
        );
        this.anchorsRenderer = anchorsRenderer;
    }

    public void prepareAnchorCalculations() {
        calculator.calculateCrossSectionAnchors(modelExcavation, anchorsExcavation);
        calculator.calculateLongSectionAnchors(modelExcavation, anchorsExcavation);
        calculator.calculateBasePlate(anchorsExcavation);
    }

    public void drawAllAnchors(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Тип анкера: ANCHOR_EXPANSION - распорный, ANCHOR_MONOLITHIC - на омоноличивающих составах
        drawCrossSectionAnchors(g2d, ANCHOR_MONOLITHIC);
        drawLongSectionAnchors(g2d, ANCHOR_MONOLITHIC);
        drawBasePlate(g2d);
    }

    public void drawAllAnchorsTest(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        testDrawLongSectionAnchors(g);
        testDrawLowerAnchor(g);
    }

    /**
     * Отрисовка анкеров в поперечном сечении.
     *
     * @param anchorType тип анкера: ANCHOR_EXPANSION - распорный, ANCHOR_MONOLITHIC - на омоноличивающих составах
     */
    public void drawCrossSectionAnchors(Graphics2D g, String anchorType) {
        double[][] crossSectionAnchorsXY = anchorsExcavation.getCrossSectionAnchorsXY();
        if (crossSectionAnchorsXY == null) return;

        int scale = GraphicsParameters.GRAPHICS_SCALE;

        for (int i = 0; i < crossSectionAnchorsXY.length; i++) {
            int x1 = (int) Math.round(crossSectionAnchorsXY[i][0] * scale);
            int y1 = (int) Math.round(crossSectionAnchorsXY[i][1] * scale);
            int x2 = (int) Math.round(crossSectionAnchorsXY[i][2] * scale);
            int y2 = (int) Math.round(crossSectionAnchorsXY[i][3] * scale);

            //g.drawLine(x1, y1, x2, y2);
            if (anchorType.equals(ANCHOR_EXPANSION)) {
                AnchorsRenderer.drawExpansionAnchor(g, x1, y1, x2, y2);
            } else {
                AnchorsRenderer.drawAnchorMonolithicCompositions(g, x1, y1, x2, y2);
            }
        }
    }

    /**
     * Отрисовка анкеров в продольном сечении.
     *
     * @param anchorType тип анкера: ANCHOR_EXPANSION - распорный, ANCHOR_MONOLITHIC - на омоноличивающих составах
     */
    public void drawLongSectionAnchors(Graphics2D g, String anchorType) {
        double[][] longSectionAnchorsXY = anchorsExcavation.getLongSectionAnchorsXY();
        if (longSectionAnchorsXY == null) return;

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        g.translate(distance, 0);

        for (int i = 0; i < longSectionAnchorsXY.length; i++) {
            int x1 = (int) Math.round(longSectionAnchorsXY[i][0] * scale);
            int y1 = (int) Math.round(longSectionAnchorsXY[i][1] * scale);
            int x2 = (int) Math.round(longSectionAnchorsXY[i][2] * scale);
            int y2 = (int) Math.round(longSectionAnchorsXY[i][3] * scale);

            //g.drawLine(x1, y1, x2, y2);
            if (anchorType.equals(ANCHOR_EXPANSION)) {
                AnchorsRenderer.drawExpansionAnchor(g, x1, y1, x2, y2);
            } else {
                AnchorsRenderer.drawAnchorMonolithicCompositions(g, x1, y1, x2, y2);
            }
        }

        g.translate(-distance, 0);
    }

    /**
     * Отрисовка опорных плит.
     */
    public void drawBasePlate(Graphics g) {
        double[][] basePlateXY = anchorsExcavation.getBasePlateXY();
        if (basePlateXY == null) return;

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
        double plateSize = anchorsExcavation.getPlateSize();

        g.translate(distance, 0);

        for (int i = 0; i < basePlateXY.length; i++) {
            int x = (int) Math.round(basePlateXY[i][0] * scale);
            int y = (int) Math.round(basePlateXY[i][1] * scale);
            int size = (int) Math.round(plateSize * scale);
            g.drawRect(x, y, size, size);
        }
        g.translate(-distance, 0);
    }

    /**
     * Тестовый метод.
     */
    public void testDrawLongSectionAnchors(Graphics g) {
//        double[][] crossSectionAnchorsXY = anchorsExcavation.getCrossSectionAnchorsXY();
//        double[][] longSectionAnchorsXY = anchorsExcavation.getLongSectionAnchorsXY();
//        if (crossSectionAnchorsXY == null || longSectionAnchorsXY == null) return;
//
//        int scale = GraphicsParameters.GRAPHICS_SCALE;
//        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
//
//        g.translate(distance, 0);
//
//        int x1 = (int) Math.round(crossSectionAnchorsXY[0][2] * scale) - distance;
//        int y1 = (int) Math.round(crossSectionAnchorsXY[0][3] * scale);
//        int x2 = (int) Math.round(longSectionAnchorsXY[0][2] * scale);
//        int y2 = (int) Math.round(longSectionAnchorsXY[0][3] * scale);
//
//        g.drawLine(x1, y1, x2, y2);
//
//        g.translate(-distance, 0);
    }

    /**
     * Тестовый метод.
     */
    public void testDrawLowerAnchor(Graphics g) {
        double width = modelExcavation.getWidth();
        double length = modelExcavation.getLength();
        double step = anchorsExcavation.getStep();
        double distanceLowerAnchor = anchorsExcavation.getDistanceLowerAnchor();

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
        int scaleWidth = (int) Math.round(width * scale);

        double[][] crossSectionAnchorsXY = anchorsExcavation.getCrossSectionAnchorsXY();
        if (crossSectionAnchorsXY == null) return;

        //Проверка верхнего анкера в ряду на соответствие простроения в поперечном и продольном видах
//        g.drawLine(0, (int) Math.round(crossSectionAnchorsXY[0][1] * scale),
//                (int) Math.round(distance + length * scale),
//                (int) Math.round(crossSectionAnchorsXY[0][1] * scale));

        //Минимальная высота установки нижнего анкера
        g.drawLine(-scaleWidth / 2, (int) Math.round(-distanceLowerAnchor * scale),
                scaleWidth / 2, (int) Math.round(-distanceLowerAnchor * scale));

        //Максимальная высота установки нижнего анкера
        g.drawLine(-scaleWidth / 2, (int) Math.round((-distanceLowerAnchor - step / 2.0) * scale),
                scaleWidth / 2, (int) Math.round((-distanceLowerAnchor - step / 2.0) * scale));
    }
}