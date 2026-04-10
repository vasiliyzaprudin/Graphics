package com.mining.graphics.graphics.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelCoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;

import java.awt.*;

public class GraphicsIntersection {
    private final ModelIntersection modelIntersection;
    private final ModelCoordinatesIntersection coordinatesIntersection;
    private final GraphicsExcavation graphicsExcavation;


    public GraphicsIntersection(ModelIntersection modelIntersection, ModelCoordinatesIntersection coordinatesIntersection,
                                GraphicsExcavation graphicsExcavation) {
        this.modelIntersection = modelIntersection;
        this.coordinatesIntersection = coordinatesIntersection;
        this.graphicsExcavation = graphicsExcavation;

    }

    public void drawPlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawStopes3(g2d);
        drawWalls3(g2d);
        drawRoundings3(g2d);
        drawAxes3(g2d);
    }

    public void drawProfileIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawAllProfileExcavation(g2d);
        drawProfileCrossSectionIncreaseExcavation(g2d);
        drawProfileCrossSectionExcavation(g2d);
    }

    private void drawStopes3(Graphics2D g2d) {
        drawStope(g2d, coordinatesIntersection.getXScaleStopeLeft1(), coordinatesIntersection.getYScaleStopeLeft1(), coordinatesIntersection.getXScaleStopeRight1(), coordinatesIntersection.getYScaleStopeRight1());
        drawStope(g2d, coordinatesIntersection.getXScaleStopeLeft2(), coordinatesIntersection.getYScaleStopeLeft2(), coordinatesIntersection.getXScaleStopeRight2(), coordinatesIntersection.getYScaleStopeRight2());
        drawStope(g2d, coordinatesIntersection.getXScaleStopeLeft3(), coordinatesIntersection.getYScaleStopeLeft3(), coordinatesIntersection.getXScaleStopeRight3(), coordinatesIntersection.getYScaleStopeRight3());
    }
    private void drawStope(Graphics2D g2d, int xLeft, int yLeft, int xRight, int yRight) {
        g2d.drawLine(xLeft, yLeft, xRight, yRight);
    }

    private void drawWalls3(Graphics2D g2d) {
        drawWall(g2d, coordinatesIntersection.getXScaleStopeRight1(), coordinatesIntersection.getYScaleStopeRight1(), coordinatesIntersection.getXScaleStartRounding12(), coordinatesIntersection.getYScaleStartRounding12());
        drawWall(g2d, coordinatesIntersection.getXScaleStopeLeft1(), coordinatesIntersection.getYScaleStopeLeft1(), coordinatesIntersection.getXScaleStartRounding13(), coordinatesIntersection.getYScaleStartRounding13());

        drawWall(g2d, coordinatesIntersection.getXScaleStopeRight2(), coordinatesIntersection.getYScaleStopeRight2(), coordinatesIntersection.getXScaleStartRounding23(), coordinatesIntersection.getYScaleStartRounding23());
        drawWall(g2d, coordinatesIntersection.getXScaleStopeLeft2(), coordinatesIntersection.getYScaleStopeLeft2(), coordinatesIntersection.getXScaleStartRounding21(), coordinatesIntersection.getYScaleStartRounding21());

        drawWall(g2d, coordinatesIntersection.getXScaleStopeRight3(), coordinatesIntersection.getYScaleStopeRight3(), coordinatesIntersection.getXScaleStartRounding31(), coordinatesIntersection.getYScaleStartRounding31());
        drawWall(g2d, coordinatesIntersection.getXScaleStopeLeft3(), coordinatesIntersection.getYScaleStopeLeft3(), coordinatesIntersection.getXScaleStartRounding32(), coordinatesIntersection.getYScaleStartRounding32());
    }
    private void drawWall(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    private void drawRoundings3(Graphics2D g2d) {
        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding13(), coordinatesIntersection.getYScaleStartRounding13(), coordinatesIntersection.getXScalePointIntrsectionExcavation31(), coordinatesIntersection.getYScalePointIntrsectionExcavation31());
        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding12(), coordinatesIntersection.getYScaleStartRounding12(), coordinatesIntersection.getXScalePointIntrsectionExcavation12(), coordinatesIntersection.getYScalePointIntrsectionExcavation12());

        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding21(), coordinatesIntersection.getYScaleStartRounding21(), coordinatesIntersection.getXScalePointIntrsectionExcavation12(), coordinatesIntersection.getYScalePointIntrsectionExcavation12());
        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding23(), coordinatesIntersection.getYScaleStartRounding23(), coordinatesIntersection.getXScalePointIntrsectionExcavation23(), coordinatesIntersection.getYScalePointIntrsectionExcavation23());

        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding32(), coordinatesIntersection.getYScaleStartRounding32(), coordinatesIntersection.getXScalePointIntrsectionExcavation23(), coordinatesIntersection.getYScalePointIntrsectionExcavation23());
        drawRounding(g2d, coordinatesIntersection.getXScaleStartRounding31(), coordinatesIntersection.getYScaleStartRounding31(), coordinatesIntersection.getXScalePointIntrsectionExcavation31(), coordinatesIntersection.getYScalePointIntrsectionExcavation31());
    }
    private void drawRounding(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    private void drawAxes3(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);

        int centerX = 0;
        int centerY = 0;

        drawAxis(g2d, centerX, centerY, coordinatesIntersection.getXScaleIntersectionAxisAndStope1(), coordinatesIntersection.getYScaleIntersectionAxisAndStope1());
        drawAxis(g2d, centerX, centerY, coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), coordinatesIntersection.getYScaleIntersectionAxisAndStope2());
        drawAxis(g2d, centerX, centerY, coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), coordinatesIntersection.getYScaleIntersectionAxisAndStope3());
    }
    private void drawAxis(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    // @formatter:off
    private void drawAllProfileExcavation(Graphics2D g2d) {

        drawProfileExcavation(g2d, (int)(Math.round(coordinatesIntersection.getIncreasedWidth1()/2.0)), 0,
                                    coordinatesIntersection.getXScaleStartRounding21(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), -coordinatesIntersection.getScaleHeight2(),
                                    coordinatesIntersection.getXScaleStartRounding21(), -coordinatesIntersection.getScaleHeight2(),
                                    coordinatesIntersection.getXScaleCalculateCoordinatePointContact21(), coordinatesIntersection.getYScaleCalculateCoordinatePointContact21());


        drawProfileExcavation(g2d, (int)(Math.round(coordinatesIntersection.getIncreasedWidth1()/2.0)), 0,
                                    coordinatesIntersection.getXScaleStartRounding31(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), -coordinatesIntersection.getScaleHeight3(),
                                    coordinatesIntersection.getXScaleStartRounding31(), -coordinatesIntersection.getScaleHeight3(),
                                    coordinatesIntersection.getXScaleCalculateCoordinatePointContact31(), coordinatesIntersection.getYScaleCalculateCoordinatePointContact31());
    }
    // @formatter:on

    private void drawProfileExcavation(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6,
                                       int y6) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, x3, y3);
        g2d.drawLine(x3, y3, x4, y4);
        g2d.drawLine(x4, y4, x5, y5);
        g2d.drawLine(x5, y5, x6, y6);

        g2d.drawLine(x2, y2, x5, y5);

        g2d.translate(0, -distance);
    }

    private void drawProfileCrossSectionIncreaseExcavation(Graphics2D g2d) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        double width = coordinatesIntersection.getIncreasedWidth1();
        double height = coordinatesIntersection.getIncreasedHeight1();
        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;

        graphicsExcavation.renderCrossSectionExcavation(g2d, width, height, formIndicationIntersection, scale);

        g2d.translate(0, -distance);
    }

    private void drawProfileCrossSectionExcavation(Graphics2D g2d) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        double width = modelIntersection.getWidth1();
        double height = modelIntersection.getHeight1();
        double formIndication = modelIntersection.getFormIndication1();
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;

        graphicsExcavation.renderCrossSectionExcavation(g2d, width, height, formIndication, scale);

        g2d.translate(0, -distance);
    }
}
