package com.mining.graphics.graphics.support.intersection;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.graphics.excavation.DrawIntersection;
import com.mining.graphics.graphics.excavation.GraphicsExcavation;
import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.service.GeneralService;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

public class GraphicsShotcreteIntersection {
    private final CoordinatesIntersection coordinatesIntersectionWithShotcrete;
    private ModelIntersection modelIntersection;

    public GraphicsShotcreteIntersection(CoordinatesIntersection coordinatesIntersection, ModelIntersection modelIntersection) {
        this.coordinatesIntersectionWithShotcrete = coordinatesIntersection;
        this.modelIntersection = modelIntersection;
    }

    public void drawShotcretePlanIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsWalls3(g2d);
        graphicsRoundings3(g2d);
    }
    public void drawShotcreteProfileIntersection3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        graphicsProfileShotcrete(g2d);
        graphicsProfileCrossSectionIncreaseExcavation(g2d);
    }


    private void graphicsWalls3(Graphics2D g2d) {
        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeRight1(), coordinatesIntersectionWithShotcrete.getYScaleStopeRight1(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding12(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding12());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeLeft1(), coordinatesIntersectionWithShotcrete.getYScaleStopeLeft1(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding13(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding13());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeRight2(), coordinatesIntersectionWithShotcrete.getYScaleStopeRight2(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding23(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding23());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeLeft2(), coordinatesIntersectionWithShotcrete.getYScaleStopeLeft2(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding21(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding21());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeRight3(), coordinatesIntersectionWithShotcrete.getYScaleStopeRight3(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding31(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding31());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStopeLeft3(), coordinatesIntersectionWithShotcrete.getYScaleStopeLeft3(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding32(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding32());
    }

    private void graphicsRoundings3(Graphics2D g2d) {
        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding13(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding13(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation31(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation31());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding12(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding12(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation12(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation12());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding21(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding21(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation12(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation12());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding23(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding23(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation23(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation23());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding32(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding32(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation23(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation23());

        DrawShotcreteIntersection.drawPlanShotcrete(g2d, coordinatesIntersectionWithShotcrete.getXScaleStartRounding31(), coordinatesIntersectionWithShotcrete.getYScaleStartRounding31(), coordinatesIntersectionWithShotcrete.getXScalePointIntrsectionExcavation31(), coordinatesIntersectionWithShotcrete.getYScalePointIntrsectionExcavation31());
    }
    private void graphicsProfileShotcrete(Graphics2D g2d) {

        DrawShotcreteIntersection.drawProfileShotcrete(g2d, (int) (Math.round(coordinatesIntersectionWithShotcrete.getIncreasedWidth1() / 2.0)), 0, coordinatesIntersectionWithShotcrete.getXScaleStartRounding21(), 0, coordinatesIntersectionWithShotcrete.getXScaleIntersectionAxisAndStope2(), 0, coordinatesIntersectionWithShotcrete.getXScaleIntersectionAxisAndStope2(), -coordinatesIntersectionWithShotcrete.getScaleHeight2(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding21(), -coordinatesIntersectionWithShotcrete.getScaleHeight2(), coordinatesIntersectionWithShotcrete.getXScaleCalculateCoordinatePointContact21(), coordinatesIntersectionWithShotcrete.getYScaleCalculateCoordinatePointContact21());


        DrawShotcreteIntersection.drawProfileShotcrete(g2d, (int) (Math.round(coordinatesIntersectionWithShotcrete.getIncreasedWidth1() / 2.0)), 0, coordinatesIntersectionWithShotcrete.getXScaleStartRounding31(), 0, coordinatesIntersectionWithShotcrete.getXScaleIntersectionAxisAndStope3(), 0, coordinatesIntersectionWithShotcrete.getXScaleIntersectionAxisAndStope3(), -coordinatesIntersectionWithShotcrete.getScaleHeight3(), coordinatesIntersectionWithShotcrete.getXScaleStartRounding31(), -coordinatesIntersectionWithShotcrete.getScaleHeight3(), coordinatesIntersectionWithShotcrete.getXScaleCalculateCoordinatePointContact31(), coordinatesIntersectionWithShotcrete.getYScaleCalculateCoordinatePointContact31());
    }

    private void graphicsProfileCrossSectionIncreaseExcavation(Graphics2D g2d) {
        int distance = GraphicsParameters.DISTANCE_BETWEEN_PLAN_AND_PROFILE_SECTION;
        g2d.translate(0, distance);

        double width = coordinatesIntersectionWithShotcrete.getIncreasedWidth1();
        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();

        int heightScale = GeneralService.toScaleParameter(coordinatesIntersectionWithShotcrete.getIncreasedHeight1());
        int alphaDegree = coordinatesIntersectionWithShotcrete.getAngleBetweenCenterRoofAndPointContactDegrees31();

        double largeArcRadius = ServiceExcavation.largeArcRadius(width, formIndicationIntersection);
        int scaleLargeArcRadius = GeneralService.toScaleParameter(largeArcRadius);

        g2d.drawArc(-scaleLargeArcRadius, -heightScale, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, 90 - alphaDegree, 2 * alphaDegree);

        g2d.translate(0, -distance);
    }
}