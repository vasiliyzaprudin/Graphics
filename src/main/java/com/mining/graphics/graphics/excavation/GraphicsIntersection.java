package com.mining.graphics.graphics.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;

import java.awt.*;

public class GraphicsIntersection {
    private final ModelIntersection modelIntersection;
    private final CoordinatesIntersection coordinatesIntersection;
    private final GraphicsExcavation graphicsExcavation;


    public GraphicsIntersection(ModelIntersection modelIntersection, CoordinatesIntersection coordinatesIntersection,
                                GraphicsExcavation graphicsExcavation) {
        this.modelIntersection = modelIntersection;
        this.coordinatesIntersection = coordinatesIntersection;
        this.graphicsExcavation = graphicsExcavation;
    }

    public void drawPlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsStopes3(g2d);
        graphicsWalls3(g2d);
        graphicsRoundings3(g2d);
        graphicsAxes3(g2d);
    }

    public void drawProfileIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsAllProfileExcavation(g2d);
        graphicsProfileCrossSectionIncreaseExcavation(g2d);
        graphicsProfileCrossSectionExcavation(g2d);
    }

    private void graphicsStopes3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft1(), coordinatesIntersection.getYScaleStopeLeft1(), coordinatesIntersection.getXScaleStopeRight1(), coordinatesIntersection.getYScaleStopeRight1());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft2(), coordinatesIntersection.getYScaleStopeLeft2(), coordinatesIntersection.getXScaleStopeRight2(), coordinatesIntersection.getYScaleStopeRight2());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft3(), coordinatesIntersection.getYScaleStopeLeft3(), coordinatesIntersection.getXScaleStopeRight3(), coordinatesIntersection.getYScaleStopeRight3());
    }

    private void graphicsWalls3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeRight1(), coordinatesIntersection.getYScaleStopeRight1(), coordinatesIntersection.getXScaleStartRounding12(), coordinatesIntersection.getYScaleStartRounding12());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft1(), coordinatesIntersection.getYScaleStopeLeft1(), coordinatesIntersection.getXScaleStartRounding13(), coordinatesIntersection.getYScaleStartRounding13());

        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeRight2(), coordinatesIntersection.getYScaleStopeRight2(), coordinatesIntersection.getXScaleStartRounding23(), coordinatesIntersection.getYScaleStartRounding23());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft2(), coordinatesIntersection.getYScaleStopeLeft2(), coordinatesIntersection.getXScaleStartRounding21(), coordinatesIntersection.getYScaleStartRounding21());

        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeRight3(), coordinatesIntersection.getYScaleStopeRight3(), coordinatesIntersection.getXScaleStartRounding31(), coordinatesIntersection.getYScaleStartRounding31());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStopeLeft3(), coordinatesIntersection.getYScaleStopeLeft3(), coordinatesIntersection.getXScaleStartRounding32(), coordinatesIntersection.getYScaleStartRounding32());
    }

    private void graphicsRoundings3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding13(), coordinatesIntersection.getYScaleStartRounding13(), coordinatesIntersection.getXScalePointIntrsectionExcavation31(), coordinatesIntersection.getYScalePointIntrsectionExcavation31());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding12(), coordinatesIntersection.getYScaleStartRounding12(), coordinatesIntersection.getXScalePointIntrsectionExcavation12(), coordinatesIntersection.getYScalePointIntrsectionExcavation12());

        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding21(), coordinatesIntersection.getYScaleStartRounding21(), coordinatesIntersection.getXScalePointIntrsectionExcavation12(), coordinatesIntersection.getYScalePointIntrsectionExcavation12());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding23(), coordinatesIntersection.getYScaleStartRounding23(), coordinatesIntersection.getXScalePointIntrsectionExcavation23(), coordinatesIntersection.getYScalePointIntrsectionExcavation23());

        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding32(), coordinatesIntersection.getYScaleStartRounding32(), coordinatesIntersection.getXScalePointIntrsectionExcavation23(), coordinatesIntersection.getYScalePointIntrsectionExcavation23());
        DrawIntersection.drawContourLine(g2d, coordinatesIntersection.getXScaleStartRounding31(), coordinatesIntersection.getYScaleStartRounding31(), coordinatesIntersection.getXScalePointIntrsectionExcavation31(), coordinatesIntersection.getYScalePointIntrsectionExcavation31());
    }

    private void graphicsAxes3(Graphics2D g2d) {
        DrawIntersection.drawAxis(g2d, coordinatesIntersection.getXScaleIntersectionAxisAndStope1(), coordinatesIntersection.getYScaleIntersectionAxisAndStope1());
        DrawIntersection.drawAxis(g2d, coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), coordinatesIntersection.getYScaleIntersectionAxisAndStope2());
        DrawIntersection.drawAxis(g2d, coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), coordinatesIntersection.getYScaleIntersectionAxisAndStope3());
    }

    // @formatter:off
    private void graphicsAllProfileExcavation(Graphics2D g2d) {

        DrawIntersection.drawProfileExcavation(g2d, (int)(Math.round(coordinatesIntersection.getIncreasedWidth1()/2.0)), 0,
                                    coordinatesIntersection.getXScaleStartRounding21(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope2(), -coordinatesIntersection.getScaleHeight2(),
                                    coordinatesIntersection.getXScaleStartRounding21(), -coordinatesIntersection.getScaleHeight2(),
                                    coordinatesIntersection.getXScaleCalculateCoordinatePointContact21(), coordinatesIntersection.getYScaleCalculateCoordinatePointContact21());


        DrawIntersection.drawProfileExcavation(g2d, (int)(Math.round(coordinatesIntersection.getIncreasedWidth1()/2.0)), 0,
                                    coordinatesIntersection.getXScaleStartRounding31(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), 0,
                                    coordinatesIntersection.getXScaleIntersectionAxisAndStope3(), -coordinatesIntersection.getScaleHeight3(),
                                    coordinatesIntersection.getXScaleStartRounding31(), -coordinatesIntersection.getScaleHeight3(),
                                    coordinatesIntersection.getXScaleCalculateCoordinatePointContact31(), coordinatesIntersection.getYScaleCalculateCoordinatePointContact31());
    }
    // @formatter:on

    private void graphicsProfileCrossSectionIncreaseExcavation(Graphics2D g2d) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        double width = coordinatesIntersection.getIncreasedWidth1();
        double height = coordinatesIntersection.getIncreasedHeight1();
        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;

        graphicsExcavation.renderCrossSectionExcavation(g2d, width, height, formIndicationIntersection, scale);

        g2d.translate(0, -distance);
    }

    private void graphicsProfileCrossSectionExcavation(Graphics2D g2d) {
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