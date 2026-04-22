package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.graphics.excavation.DrawIntersection;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;

import java.awt.*;

public class GraphicsShotcreteIntersection {
    private final CoordinatesIntersection shotcreteCoordinates;

    public GraphicsShotcreteIntersection(CoordinatesIntersection shotcreteCoordinates) {
        this.shotcreteCoordinates = shotcreteCoordinates;
    }

    public void drawShotcretePlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsStopes3(g2d);
        graphicsWalls3(g2d);
        graphicsRoundings3(g2d);
    }

    private void graphicsStopes3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft1(),
                shotcreteCoordinates.getYScaleStopeLeft1(),
                shotcreteCoordinates.getXScaleStopeRight1(),
                shotcreteCoordinates.getYScaleStopeRight1());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft2(),
                shotcreteCoordinates.getYScaleStopeLeft2(),
                shotcreteCoordinates.getXScaleStopeRight2(),
                shotcreteCoordinates.getYScaleStopeRight2());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft3(),
                shotcreteCoordinates.getYScaleStopeLeft3(),
                shotcreteCoordinates.getXScaleStopeRight3(),
                shotcreteCoordinates.getYScaleStopeRight3());
    }

    private void graphicsWalls3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeRight1(),
                shotcreteCoordinates.getYScaleStopeRight1(),
                shotcreteCoordinates.getXScaleStartRounding12(),
                shotcreteCoordinates.getYScaleStartRounding12());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft1(),
                shotcreteCoordinates.getYScaleStopeLeft1(),
                shotcreteCoordinates.getXScaleStartRounding13(),
                shotcreteCoordinates.getYScaleStartRounding13());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeRight2(),
                shotcreteCoordinates.getYScaleStopeRight2(),
                shotcreteCoordinates.getXScaleStartRounding23(),
                shotcreteCoordinates.getYScaleStartRounding23());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft2(),
                shotcreteCoordinates.getYScaleStopeLeft2(),
                shotcreteCoordinates.getXScaleStartRounding21(),
                shotcreteCoordinates.getYScaleStartRounding21());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeRight3(),
                shotcreteCoordinates.getYScaleStopeRight3(),
                shotcreteCoordinates.getXScaleStartRounding31(),
                shotcreteCoordinates.getYScaleStartRounding31());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStopeLeft3(),
                shotcreteCoordinates.getYScaleStopeLeft3(),
                shotcreteCoordinates.getXScaleStartRounding32(),
                shotcreteCoordinates.getYScaleStartRounding32());
    }

    private void graphicsRoundings3(Graphics2D g2d) {
        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding13(),
                shotcreteCoordinates.getYScaleStartRounding13(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation31(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation31());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding12(),
                shotcreteCoordinates.getYScaleStartRounding12(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation12(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation12());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding21(),
                shotcreteCoordinates.getYScaleStartRounding21(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation12(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation12());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding23(),
                shotcreteCoordinates.getYScaleStartRounding23(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation23(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation23());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding32(),
                shotcreteCoordinates.getYScaleStartRounding32(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation23(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation23());

        DrawIntersection.drawContourLine(g2d,
                shotcreteCoordinates.getXScaleStartRounding31(),
                shotcreteCoordinates.getYScaleStartRounding31(),
                shotcreteCoordinates.getXScalePointIntrsectionExcavation31(),
                shotcreteCoordinates.getYScalePointIntrsectionExcavation31());
    }
}