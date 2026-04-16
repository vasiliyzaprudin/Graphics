package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.graphics.elementssupport.AnchorsRenderer;
import com.mining.graphics.model.excavation.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.AnchorsIntersection;
import com.mining.graphics.model.test.ModelTest;
import com.mining.graphics.service.GeneralService;
import com.mining.graphics.service.support.CalculateCoordinatesAnchorsIntersection;
import com.mining.graphics.service.support.ServiceAnchorsIntersection;

import java.awt.*;

import static com.mining.graphics.graphics.support.GraphicsAnchorsExcavation.ANCHOR_EXPANSION;

public class GraphicsAnchorsIntersection {

    private final CalculateCoordinatesAnchorsIntersection calculator;
    private final CoordinatesIntersection modelCoordinatesIntersection;
    private final AnchorsIntersection anchorsIntersection;
    private final AnchorsRenderer anchorsRenderer;

    public GraphicsAnchorsIntersection(
            ModelIntersection modelIntersection,
            CoordinatesIntersection modelCoordinatesIntersection,
            AnchorsIntersection anchorsIntersection,
            ModelTest modelTest,
            AnchorsRenderer anchorsRenderer) {
        this.modelCoordinatesIntersection = modelCoordinatesIntersection;
        this.anchorsIntersection = anchorsIntersection;
        this.anchorsRenderer = anchorsRenderer;
        this.calculator = new CalculateCoordinatesAnchorsIntersection(
                modelIntersection, modelCoordinatesIntersection, anchorsIntersection, modelTest
        );
    }


    public void drawAllAnchorsPlanRounding3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound12(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound13(), ANCHOR_EXPANSION);

        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound21(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound23(), ANCHOR_EXPANSION);

        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound32(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanRound31(), ANCHOR_EXPANSION);
    }

    public void drawAllAnchorsPlanLine3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine12(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine13(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine23(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine21(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine32(), ANCHOR_EXPANSION);
        drawAnchorsPlan(g2d, calculator.getAnchorPlanLine31(), ANCHOR_EXPANSION);
    }


    public void drawAllAnchorsProjectionLine3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawAnchorsProjection(g2d, calculator.getAnchorProjection2(), ANCHOR_EXPANSION);
        drawAnchorsProjection(g2d, calculator.getAnchorProjection3(), ANCHOR_EXPANSION);
    }

    public void testDrawAllAnchorsPlanRounding3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawTestLineAnchorsPlan(g2d, calculator.getTestLine1(), ANCHOR_EXPANSION);
        drawTestLineAnchorsPlan(g2d, calculator.getTestLine2(), ANCHOR_EXPANSION);
        drawTestLineAnchorsPlan(g2d, calculator.getTestLine3(), ANCHOR_EXPANSION);
    }

    public void drawBasePlateProjection(Graphics2D g) {
        double[][] crossSectionAnchors2 = calculator.getCrossSectionAnchors2();
        double[][] projectionAnchors2 = calculator.getAnchorProjection2();
        drawBasePlateProjection(g, crossSectionAnchors2, projectionAnchors2);

        double[][] crossSectionAnchors3 = calculator.getCrossSectionAnchors3();
        double[][] projectionAnchors3 = calculator.getAnchorProjection3();
        drawBasePlateProjection(g, crossSectionAnchors3, projectionAnchors3);

    }

    private void drawAnchorsPlan(Graphics2D g, double[][] anchors, String anchorType) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        for (double[] anchor : anchors) {
            int x1 = (int) Math.round(anchor[0] * scale);
            int y1 = (int) Math.round(anchor[1] * scale);
            int x2 = (int) Math.round(anchor[2] * scale);
            int y2 = (int) Math.round(anchor[3] * scale);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawTestLineAnchorsPlan(Graphics2D g, double[][] lineTestXY, String anchorType) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        for (double[] line : lineTestXY) {
            int x1 = (int) Math.round(line[0] * scale);
            int y1 = (int) Math.round(line[1] * scale);
            int x2 = (int) Math.round(line[2] * scale);
            int y2 = (int) Math.round(line[3] * scale);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawAnchorsProjection(Graphics2D g, double[][] anchors, String anchorType) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;

        g.translate(0, distance);
        for (double[] anchor : anchors) {
            int x1 = (int) Math.round(anchor[0] * scale);
            int y1 = (int) Math.round(anchor[1] * scale);
            int x2 = (int) Math.round(anchor[2] * scale);
            int y2 = (int) Math.round(anchor[3] * scale);
            g.drawLine(x1, y1, x2, y2);
        }
        g.translate(0, -distance);
    }

    private void drawBasePlateProjection(Graphics2D g, double[][] crossSectionAnchors, double[][] projectionAnchors) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;

        double plateSize = anchorsIntersection.getPlateSize();
        int scalePlateSize = GeneralService.toScaleParameter(plateSize);

        double increasedWidth = modelCoordinatesIntersection.getIncreasedWidth1();

        double[][] basePlates = ServiceAnchorsIntersection.calculateCoordinatesBasePlate(
                crossSectionAnchors, projectionAnchors, plateSize, increasedWidth
        );

        g.translate(0, distance);
        for (double[] plate : basePlates) {
            int x = (int) Math.round(plate[0] * scale);
            int y = (int) Math.round(plate[1] * scale);
            g.drawRect(x, y, scalePlateSize, scalePlateSize);
        }
        g.translate(0, -distance);
    }
}