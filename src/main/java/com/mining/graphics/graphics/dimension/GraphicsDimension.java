package com.mining.graphics.graphics.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.dimension.DimensionService;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

/**
 * Графический класс для отрисовки размеров
 */
public class GraphicsDimension {

    private final ModelExcavation model;
    private final DimensionService dimensionService;

    public GraphicsDimension(ModelExcavation model, ServiceExcavation excavationService) {
        this.model = model;
        this.dimensionService = new DimensionService(excavationService);
    }

    /**
     * Отрисовка всех размеров для поперечного сечения
     */
    public void drawCrossSectionDimensions(Graphics2D g) {
        int scale = GraphicsParameters.GRAPHICS_SCALE;
        DimensionService.DimensionPoints points = dimensionService.calculateCrossSectionDimensions(model, scale);

        // Ширина
        DimensionRenderer.drawDimension(g,
                points.widthStart.x, points.widthStart.y,
                points.widthEnd.x, points.widthEnd.y,
                points.widthOffset,
                points.widthText);

        // Высота
        DimensionRenderer.drawDimension(g,
                points.heightStart.x, points.heightStart.y,
                points.heightEnd.x, points.heightEnd.y,
                points.heightOffset,
                points.heightText);
    }
}