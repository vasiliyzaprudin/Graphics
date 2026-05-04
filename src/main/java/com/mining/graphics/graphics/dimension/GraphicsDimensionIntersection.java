package com.mining.graphics.graphics.dimension;

import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.intersection.AnchorsIntersection;
import com.mining.graphics.service.dimension.ServiceDimensionIntersection;
import com.mining.graphics.service.support.intersection.CalculateCoordinatesAnchorsIntersection;

import java.awt.*;

public class GraphicsDimensionIntersection {

    private final CoordinatesIntersection coordinatesIntersection;
    private final ModelIntersection modelIntersection;
    private final ServiceDimensionIntersection serviceDimensionIntersection;
    private CalculateCoordinatesAnchorsIntersection calculateCoordinatesAnchorsIntersection;
    private AnchorsIntersection anchorsIntersection;

    public GraphicsDimensionIntersection(CoordinatesIntersection coordinatesIntersection,
                                         ModelIntersection modelIntersection,
                                         AnchorsIntersection anchorsIntersection) {
        this.coordinatesIntersection = coordinatesIntersection;
        this.modelIntersection = modelIntersection;
        this.anchorsIntersection = anchorsIntersection;
        this.serviceDimensionIntersection = new ServiceDimensionIntersection();
        this.calculateCoordinatesAnchorsIntersection = new CalculateCoordinatesAnchorsIntersection(
                modelIntersection,
                coordinatesIntersection,
                anchorsIntersection
        );
    }


    public void drawDimensionsIntersection(Graphics2D g) {
        ServiceDimensionIntersection.DimensionPointsIntersection points = serviceDimensionIntersection.calculateDimensionIntersection(coordinatesIntersection, modelIntersection, calculateCoordinatesAnchorsIntersection, anchorsIntersection );

        // Ширина горной выработки 1
        DrawDimension.drawDimension(g, points.width1Start.x, points.width1Start.y,
                                        points.width1End.x, points.width1End.y,
                                        points.width1Offset, points.width1LengthExtensionline,
                                        points.width1Text, false);

        // Ширина горной выработки 3
        DrawDimension.drawDimension(g, points.width3Start.x, points.width3Start.y,
                points.width3End.x, points.width3End.y,
                points.width3Offset, points.width3LengthExtensionline,
                points.width3Text, false);

        // Высота горной выработки 1
        DrawDimension.drawDimension(g, points.height1Start.x, points.height1Start.y,
                points.height1End.x, points.height1End.y,
                points.height1Offset, points.height1LengthExtensionline,
                points.height1Text, false);

        // Высота горной выработки 3
        DrawDimension.drawDimension(g, points.height3Start.x, points.height3Start.y,
                points.height3End.x, points.height3End.y,
                points.height3Offset, points.height3LengthExtensionline,
                points.height3Text, false);

         //расстояние до нижнего анкера
        DrawDimension.drawDimension(g, points.heightToBottomAnchorStart.x, points.heightToBottomAnchorStart.y,
                points.heightToBottomAnchorEnd.x, points.heightToBottomAnchorEnd.y,
                points.heightToBottomAnchorOffset, points.heightToBottomAnchorLengthExtensionline,
                points.heightToBottomAnchorText, false);

        //Расстояние между анкерами вдоль основной горной выработки
        DrawDimension.drawDimension(g, points.step1Start.x, points.step1Start.y,
                points.step1End.x, points.step1End.y,
                points.step1Offset, points.step1LengthExtensionline,
                points.step1Text, false);

        //Расстояние между анкерами вдоль сопрягаемой горной выработки
        DrawDimension.drawDimension(g, points.step2Start.x, points.step2Start.y,
                points.step2End.x, points.step2End.y,
                points.step2Offset, points.step2LengthExtensionline,
                points.step2Text, false);

    }
}
