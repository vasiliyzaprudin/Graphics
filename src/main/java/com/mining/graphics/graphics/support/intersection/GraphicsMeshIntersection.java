package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.intersection.MeshIntersection;
import com.mining.graphics.service.GeneralService;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.excavation.ServiceMeshExcavation;

import java.awt.*;

public class GraphicsMeshIntersection {
    private final CoordinatesIntersection coordinatesIntersectionWithMesh;
    private ModelIntersection modelIntersection;
    private MeshIntersection meshIntersection;

    public GraphicsMeshIntersection(CoordinatesIntersection coordinatesIntersection, ModelIntersection modelIntersection,
                                    MeshIntersection meshIntersection) {
        this.coordinatesIntersectionWithMesh = coordinatesIntersection;
        this.modelIntersection = modelIntersection;
        this.meshIntersection = meshIntersection;
    }

    public void graphicsMeshPlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //graphicsWalls3(g2d);
        graphicsRoundings3(g2d);
        graphicsPlanLineMesh(g2d);
    }

    public void graphicsMeshProfileIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsProfileMesh(g2d);
        graphicsProfileCrossSectionIncreaseExcavationMesh(g2d);

        graphicsProfileWallMesh(g2d);
    }

    private void graphicsWalls3(Graphics2D g2d) {
        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeRight1(), coordinatesIntersectionWithMesh.getYScaleStopeRight1(), coordinatesIntersectionWithMesh.getXScaleStartRounding12(), coordinatesIntersectionWithMesh.getYScaleStartRounding12());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeLeft1(), coordinatesIntersectionWithMesh.getYScaleStopeLeft1(), coordinatesIntersectionWithMesh.getXScaleStartRounding13(), coordinatesIntersectionWithMesh.getYScaleStartRounding13());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeRight2(), coordinatesIntersectionWithMesh.getYScaleStopeRight2(), coordinatesIntersectionWithMesh.getXScaleStartRounding23(), coordinatesIntersectionWithMesh.getYScaleStartRounding23());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeLeft2(), coordinatesIntersectionWithMesh.getYScaleStopeLeft2(), coordinatesIntersectionWithMesh.getXScaleStartRounding21(), coordinatesIntersectionWithMesh.getYScaleStartRounding21());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeRight3(), coordinatesIntersectionWithMesh.getYScaleStopeRight3(), coordinatesIntersectionWithMesh.getXScaleStartRounding31(), coordinatesIntersectionWithMesh.getYScaleStartRounding31());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStopeLeft3(), coordinatesIntersectionWithMesh.getYScaleStopeLeft3(), coordinatesIntersectionWithMesh.getXScaleStartRounding32(), coordinatesIntersectionWithMesh.getYScaleStartRounding32());
    }

    private void graphicsRoundings3(Graphics2D g2d) {
        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding13(), coordinatesIntersectionWithMesh.getYScaleStartRounding13(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation31(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation31());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding12(), coordinatesIntersectionWithMesh.getYScaleStartRounding12(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation12(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation12());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding21(), coordinatesIntersectionWithMesh.getYScaleStartRounding21(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation12(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation12());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding23(), coordinatesIntersectionWithMesh.getYScaleStartRounding23(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation23(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation23());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding32(), coordinatesIntersectionWithMesh.getYScaleStartRounding32(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation23(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation23());

        DrawMeshIntersection.drawPlanWallMesh(g2d, coordinatesIntersectionWithMesh.getXScaleStartRounding31(), coordinatesIntersectionWithMesh.getYScaleStartRounding31(), coordinatesIntersectionWithMesh.getXScalePointIntrsectionExcavation31(), coordinatesIntersectionWithMesh.getYScalePointIntrsectionExcavation31());
    }

    public void graphicsPlanLineMesh(Graphics2D g2d) {

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding21ToWall23(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding21ToWall23(),
                coordinatesIntersectionWithMesh.getXStartRounding23(),
                coordinatesIntersectionWithMesh.getYStartRounding23());

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding23ToWall21(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding23ToWall21(),
                coordinatesIntersectionWithMesh.getXStartRounding21(),
                coordinatesIntersectionWithMesh.getYStartRounding21());

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding31ToWall32(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding31ToWall32(),
                coordinatesIntersectionWithMesh.getXStartRounding32(),
                coordinatesIntersectionWithMesh.getYStartRounding32());

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding32ToWall31(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding32ToWall31(),
                coordinatesIntersectionWithMesh.getXStartRounding31(),
                coordinatesIntersectionWithMesh.getYStartRounding31());

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding12ToWall13(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding12ToWall13(),
                coordinatesIntersectionWithMesh.getXStartRounding13(),
                coordinatesIntersectionWithMesh.getYStartRounding13());

        DrawMeshIntersection.drawPlanLineMeshExcavation (g2d,
                coordinatesIntersectionWithMesh.getxProjectionPointStartRounding13ToWall12(),
                coordinatesIntersectionWithMesh.getyProjectionPointStartRounding13ToWall12(),
                coordinatesIntersectionWithMesh.getXStartRounding12(),
                coordinatesIntersectionWithMesh.getYStartRounding12());
    }

    // @formatter:off

    private void graphicsProfileMesh(Graphics2D g2d) {

        DrawMeshIntersection.drawProfileRoofMesh(g2d,
                (int) (Math.round(coordinatesIntersectionWithMesh.getIncreasedWidth1() / 2.0)),
                0, coordinatesIntersectionWithMesh.getXScaleStartRounding21(),
                0, coordinatesIntersectionWithMesh.getXScaleIntersectionAxisAndStope2(),
                0, coordinatesIntersectionWithMesh.getXScaleIntersectionAxisAndStope2(),
                -coordinatesIntersectionWithMesh.getScaleHeight2(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding21(),
                -coordinatesIntersectionWithMesh.getScaleHeight2(),
                coordinatesIntersectionWithMesh.getXScaleCalculateCoordinatePointContact21(),
                coordinatesIntersectionWithMesh.getYScaleCalculateCoordinatePointContact21());

        DrawMeshIntersection.drawProfileRoofMesh(g2d,
                (int) (Math.round(coordinatesIntersectionWithMesh.getIncreasedWidth1() / 2.0)),
                0, coordinatesIntersectionWithMesh.getXScaleStartRounding31(),
                0, coordinatesIntersectionWithMesh.getXScaleIntersectionAxisAndStope3(),
                0, coordinatesIntersectionWithMesh.getXScaleIntersectionAxisAndStope3(),
                -coordinatesIntersectionWithMesh.getScaleHeight3(),
                coordinatesIntersectionWithMesh.getXScaleStartRounding31(),
                -coordinatesIntersectionWithMesh.getScaleHeight3(),
                coordinatesIntersectionWithMesh.getXScaleCalculateCoordinatePointContact31(),
                coordinatesIntersectionWithMesh.getYScaleCalculateCoordinatePointContact31());
    }

    private void graphicsProfileCrossSectionIncreaseExcavationMesh(Graphics2D g2d) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        double width = coordinatesIntersectionWithMesh.getIncreasedWidth1();
        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();

        int heightScale = GeneralService.toScaleIntersectionParameter(coordinatesIntersectionWithMesh.getIncreasedHeight1());
        int alphaDegree = coordinatesIntersectionWithMesh.getAngleBetweenCenterRoofAndPointContactDegrees31();

        double largeArcRadius = ServiceExcavation.largeArcRadius(width, formIndicationIntersection);
        int scaleLargeArcRadius = GeneralService.toScaleIntersectionParameter(largeArcRadius);

        g2d.drawArc(-scaleLargeArcRadius, -heightScale, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, 90 - alphaDegree, 2 * alphaDegree);

        g2d.translate(0, -distance);
    }


    public void graphicsProfileWallMesh(Graphics2D g2d) {

        DrawMeshIntersection.drawProfileWallMesh(g2d,
                coordinatesIntersectionWithMesh.getXStartRounding21(),
                coordinatesIntersectionWithMesh.getIncreasedWidth1() / 2.0,
                modelIntersection.getHeight2(),
                meshIntersection.getDistanceBetweenSoilAndMesh(),
                meshIntersection.getGridStep());
        DrawMeshIntersection.drawProfileWallMesh(g2d,
                -coordinatesIntersectionWithMesh.getIncreasedWidth1() / 2.0,
                coordinatesIntersectionWithMesh.getXStartRounding31(),
                modelIntersection.getHeight3(),
                meshIntersection.getDistanceBetweenSoilAndMesh(),
                meshIntersection.getGridStep());

    }

    // @formatter:on
}
