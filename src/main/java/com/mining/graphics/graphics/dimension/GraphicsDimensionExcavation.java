package com.mining.graphics.graphics.dimension;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.excavation.ShotcreteExcavation;
import com.mining.graphics.service.dimension.ServiceDimensionExcavation;

import java.awt.*;

public class GraphicsDimensionExcavation {

    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;
    private final ShotcreteExcavation shotcreteExcavation;
    private final ServiceDimensionExcavation serviceDimensionExcavation;

    public GraphicsDimensionExcavation(ModelExcavation model, AnchorsExcavation anchorsExcavation, ShotcreteExcavation shotcreteExcavation) {
        this.modelExcavation = model;
        this.anchorsExcavation = anchorsExcavation;
        this.shotcreteExcavation = shotcreteExcavation;
        this.serviceDimensionExcavation = new ServiceDimensionExcavation();
    }

    public void drawDimensionsExcavation(Graphics2D g) {
        ServiceDimensionExcavation.DimensionPointsExcavation points = serviceDimensionExcavation.calculateDimensionsExcavation(modelExcavation, anchorsExcavation, shotcreteExcavation);

        // Ширина
        DrawDimension.drawDimension(g,
                points.widthStart.x, points.widthStart.y,
                points.widthEnd.x, points.widthEnd.y,
                points.widthOffset,
                points.widthLengthextensionline,
                points.widthText, false);

        // Высота
        DrawDimension.drawDimension(g,
                points.heightStart.x, points.heightStart.y,
                points.heightEnd.x, points.heightEnd.y,
                points.heightOffset,
                points.heightLengthextensionline,
                points.heightText, false);

        // Расстояние до нижнего анкера (смещение вправо)
        DrawDimension.drawDimension(g,
                points.heightToBottomAnchorStart.x, points.heightToBottomAnchorStart.y,
                points.heightToBottomAnchorEnd.x, points.heightToBottomAnchorEnd.y,
                points.heightToBottomAnchorOffset,
                points.heightToBottomAnchorLengthextensionline,
                points.heightToBottomAnchorText, false);

        // Расстояние между анкерами в ряду
        DrawDimension.drawDimension(g,
                points.stepStart.x, points.stepStart.y,
                points.stepEnd.x, points.stepEnd.y,
                points.stepOffset,
                points.stepLengthextensionline,
                points.stepText, false);

        // Расстояние между рядами анкеров
        DrawDimension.drawDimension(g,
                points.distanceBetweenRowsStart.x, points.distanceBetweenRowsStart.y,
                points.distanceBetweenRowsEnd.x, points.distanceBetweenRowsEnd.y,
                points.distanceBetweenRowsOffset,
                points.distanceBetweenRowsLengthextensionline,
                points.distanceBetweenRowsText, false);

        //Толщина набрызгбетона
        DrawDimension.drawDimension(g,
                points.thicknessShorcreteStart.x, points.thicknessShorcreteStart.y,
                points.thicknessShorcreteEnd.x, points.thicknessShorcreteEnd.y,
                points.thicknessShorcreteOffset,
                points.thicknessShorcreteLengthextensionline,
                points.thicknessShorcreteText, false);
    }

}