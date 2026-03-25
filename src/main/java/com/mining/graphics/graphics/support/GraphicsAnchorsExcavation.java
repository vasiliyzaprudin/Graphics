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

    private final ModelExcavation model;
    private final AnchorsExcavation anchors;
    private final CalculateCoordinatesAnchorsExcavation calculator;
    private final AnchorsRenderer anchorsRenderer;

    public GraphicsAnchorsExcavation(ModelExcavation model, AnchorsExcavation anchors, AnchorsRenderer anchorsRenderer) {
        this.model = model;
        this.anchors = anchors;
        this.calculator = new CalculateCoordinatesAnchorsExcavation(
                new ServiceExcavation(),
                new ServiceAnchors()
        );
        this.anchorsRenderer = anchorsRenderer;
    }

    public void prepareAnchorCalculations() {
        calculator.calculateCrossSectionAnchors(model, anchors);
        calculator.calculateLongSectionAnchors(model, anchors);
        calculator.calculateBasePlate(anchors);
    }

    public void drawAllAnchors(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Тип анкера: ANCHOR_EXPANSION - распорный, ANCHOR_MONOLITHIC - на омоноличивающих составах
        drawCrossSectionAnchors(g2d, ANCHOR_EXPANSION);
        drawLongSectionAnchors(g2d, ANCHOR_EXPANSION);
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
        double[][] crossSectionAnchorsXY = anchors.getCrossSectionAnchorsXY();
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
        double[][] longSectionAnchorsXY = anchors.getLongSectionAnchorsXY();
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
        double[][] basePlateXY = anchors.getBasePlateXY();
        if (basePlateXY == null) return;

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
        double plateSize = anchors.getPlateSize();

        g.translate(distance, 0);

        for (int i = 0; i < basePlateXY.length; i++) {
            int x = (int) Math.round(basePlateXY[i][0] * scale);
            int y = (int) Math.round(basePlateXY[i][1] * scale);
            int size = (int) Math.round(plateSize * scale);
            g.drawRect(x, y, size, size);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

        g.translate(-distance, 0);
    }

    /**
     * Тестовый метод.
     */
    public void testDrawLongSectionAnchors(Graphics g) {
        double[][] crossSectionAnchorsXY = anchors.getCrossSectionAnchorsXY();
        double[][] longSectionAnchorsXY = anchors.getLongSectionAnchorsXY();
        if (crossSectionAnchorsXY == null || longSectionAnchorsXY == null) return;

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        g.translate(distance, 0);

        int x1 = (int) Math.round(crossSectionAnchorsXY[0][2] * scale) - distance;
        int y1 = (int) Math.round(crossSectionAnchorsXY[0][3] * scale);
        int x2 = (int) Math.round(longSectionAnchorsXY[0][2] * scale);
        int y2 = (int) Math.round(longSectionAnchorsXY[0][3] * scale);

        g.drawLine(x1, y1, x2, y2);

        g.translate(-distance, 0);
    }

    /**
     * Тестовый метод.
     */
    public void testDrawLowerAnchor(Graphics g) {
        double width = model.getWidth();
        double height = model.getHeight();
        double length = model.getLength();
        double step = anchors.getStep();
        double distanceLowerAnchor = anchors.getDistanceLowerAnchor();

        ServiceExcavation service = new ServiceExcavation();
        double archHeight = service.getArchHeight(width, model.getFormIndication());

        int scale = GraphicsParameters.GRAPHICS_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
        int scaleWidth = (int) Math.round(width * scale);

        double[][] crossSectionAnchorsXY = anchors.getCrossSectionAnchorsXY();
        if (crossSectionAnchorsXY == null) return;

        g.drawLine(0, (int) Math.round(crossSectionAnchorsXY[0][1] * scale),
                (int) Math.round(distance + length * scale),
                (int) Math.round(crossSectionAnchorsXY[0][1] * scale));

        g.drawLine(-scaleWidth / 2, (int) Math.round(-distanceLowerAnchor * scale),
                scaleWidth / 2, (int) Math.round(-distanceLowerAnchor * scale));

        g.drawLine(-scaleWidth / 2, (int) Math.round((-distanceLowerAnchor - step / 2.0) * scale),
                scaleWidth / 2, (int) Math.round((-distanceLowerAnchor - step / 2.0) * scale));
    }
}