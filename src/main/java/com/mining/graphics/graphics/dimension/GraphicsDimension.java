package com.mining.graphics.graphics.dimension;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.service.dimension.DimensionService;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

/**
 * Графический класс для отрисовки размеров
 */
public class GraphicsDimension {

    private final ModelExcavation model;
    private final AnchorsExcavation anchorsExcavation;
    private final DimensionService dimensionService;

    public GraphicsDimension(ModelExcavation model,AnchorsExcavation anchorsExcavation, ServiceExcavation excavationService) {
        this.model = model;
        this.anchorsExcavation = anchorsExcavation;
        this.dimensionService = new DimensionService(excavationService);
    }

    /**
     * Отрисовка всех размеров для поперечного сечения
     */
    public void drawCrossSectionDimensions(Graphics2D g) {
        int scale = GraphicsParameters.GRAPHICS_SCALE;
        DimensionService.DimensionPoints points = dimensionService.calculateCrossSectionDimensions(model,anchorsExcavation, scale);

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
                points.heightText,false);

        // Расстояние до нижнего анкера (смещение вправо)
        DimensionRenderer.drawDimension(g,
                points.heightToBottomAnchorStart.x, points.heightToBottomAnchorStart.y,
                points.heightToBottomAnchorEnd.x, points.heightToBottomAnchorEnd.y,
                points.heightToBottomAnchorOffset,
                points.heightToBottomAnchorLengthextensionline,
                points.heightToBottomAnchorText, true);
    }
}