package com.mining.graphics.graphics.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.model.support.ShotcreteExcavation;
import com.mining.graphics.service.dimension.ServiceDimension;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

/**
 * Графический класс для отрисовки размеров
 */
public class GraphicsDimension {

    private final ModelExcavation model;
    private final AnchorsExcavation anchorsExcavation;
    private final ShotcreteExcavation shotcreteExcavation;
    private final ServiceDimension dimensionService;

    public GraphicsDimension(ModelExcavation model, AnchorsExcavation anchorsExcavation,ShotcreteExcavation shotcreteExcavation, ServiceExcavation excavationService) {
        this.model = model;
        this.anchorsExcavation = anchorsExcavation;
        this.shotcreteExcavation = shotcreteExcavation;
        this.dimensionService = new ServiceDimension(excavationService);
    }

    /**
     * Отрисовка всех размеров для поперечного сечения
     */
    public void drawCrossSectionDimensions(Graphics2D g) {
        int scale = GraphicsParameters.GRAPHICS_SCALE;
        ServiceDimension.DimensionPoints points = dimensionService.calculateCrossSectionDimensions(model, anchorsExcavation, shotcreteExcavation, scale);

        // Ширина
        DimensionRenderer.drawDimension(g,
                points.widthStart.x, points.widthStart.y,
                points.widthEnd.x, points.widthEnd.y,
                points.widthOffset,
                points.widthLengthextensionline,
                points.widthText, false);

        // Высота
        DimensionRenderer.drawDimension(g,
                points.heightStart.x, points.heightStart.y,
                points.heightEnd.x, points.heightEnd.y,
                points.heightOffset,
                points.heightLengthextensionline,
                points.heightText, false);

        // Расстояние до нижнего анкера (смещение вправо)
        DimensionRenderer.drawDimension(g,
                points.heightToBottomAnchorStart.x, points.heightToBottomAnchorStart.y,
                points.heightToBottomAnchorEnd.x, points.heightToBottomAnchorEnd.y,
                points.heightToBottomAnchorOffset,
                points.heightToBottomAnchorLengthextensionline,
                points.heightToBottomAnchorText, false);

        // Расстояние между анкерами в ряду
        DimensionRenderer.drawDimension(g,
                points.stepStart.x, points.stepStart.y,
                points.stepEnd.x, points.stepEnd.y,
                points.stepOffset,
                points.stepLengthextensionline,
                points.stepText, false);

        // Расстояние между рядами анкеров
        DimensionRenderer.drawDimension(g,
                points.distanceBetweenRowsStart.x, points.distanceBetweenRowsStart.y,
                points.distanceBetweenRowsEnd.x, points.distanceBetweenRowsEnd.y,
                points.distanceBetweenRowsOffset,
                points.distanceBetweenRowsLengthextensionline,
                points.distanceBetweenRowsText, false);

        //Толщина набрызгбетона
        DimensionRenderer.drawDimension(g,
                points.thicknessShorcreteStart.x, points.thicknessShorcreteStart.y,
                points.thicknessShorcreteEnd.x, points.thicknessShorcreteEnd.y,
                points.thicknessShorcreteOffset,
                points.thicknessShorcreteLengthextensionline,
                points.thicknessShorcreteText, false);
    }

}