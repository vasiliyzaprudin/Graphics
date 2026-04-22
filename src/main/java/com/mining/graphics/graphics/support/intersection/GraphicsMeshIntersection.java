package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.model.coordinates.CoordinatesIntersection;

import java.awt.*;

public class GraphicsMeshIntersection {
    private final CoordinatesIntersection coordinatesIntersectionWithMesh;

    public GraphicsMeshIntersection(CoordinatesIntersection coordinatesIntersection) {
        this.coordinatesIntersectionWithMesh = coordinatesIntersection;
    }

    public void drawMeshPlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsWalls3(g2d);
        graphicsRoundings3(g2d);
    }

    private void graphicsWalls3(Graphics2D g2d) {
        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeRight1(),
                coordinatesIntersectionWithMesh.getYScaleStopeRight1(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding12(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding12());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeLeft1(),
                coordinatesIntersectionWithMesh.getYScaleStopeLeft1(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding13(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding13());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeRight2(),
                coordinatesIntersectionWithMesh.getYScaleStopeRight2(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding23(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding23());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeLeft2(),
                coordinatesIntersectionWithMesh.getYScaleStopeLeft2(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding21(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding21());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeRight3(),
                coordinatesIntersectionWithMesh.getYScaleStopeRight3(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding31(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding31());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStopeLeft3(),
                coordinatesIntersectionWithMesh.getYScaleStopeLeft3(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding32(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding32());
    }

    private void graphicsRoundings3(Graphics2D g2d) {
        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding13(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding13(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation31(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation31());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding12(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding12(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation12(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation12());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding21(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding21(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation12(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation12());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding23(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding23(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation23(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation23());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding32(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding32(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation23(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation23());

        DrawMeshIntersection.drawPlanMesh(g2d,
                coordinatesIntersectionWithMesh.getXScaleStartRounding31(),
                coordinatesIntersectionWithMesh.getYScaleStartRounding31(),
                coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation31(),
                coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation31());
    }
}
