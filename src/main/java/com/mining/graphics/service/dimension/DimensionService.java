package com.mining.graphics.service.dimension;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;

import java.awt.*;

/**
 * Сервис для расчета координат размеров
 */
public class DimensionService {

    private final ServiceExcavation excavationService;

    public DimensionService(ServiceExcavation excavationService) {
        this.excavationService = excavationService;
    }

    /**
     * Расчет размеров для поперечного сечения
     */
    public DimensionPoints calculateCrossSectionDimensions(ModelExcavation model, int scale) {
        double width = model.getWidth();
        double height = model.getHeight();
        double formIndication = model.getFormIndication();

        double archHeight = excavationService.getArchHeight(width, formIndication);

        int scaleWidth = (int) Math.round(width * scale);
        int scaleHeight = (int) Math.round(height * scale);
        int scaleArchHeight = (int) Math.round(archHeight * scale);

        DimensionPoints points = new DimensionPoints();

        // Размер ширины (смещение вниз)
        points.widthStart = new Point(-scaleWidth / 2, 0);
        points.widthEnd = new Point(scaleWidth / 2, 0);
        points.widthOffset = 60;  // смещение вниз
        points.widthText = String.format("%.1f м", width);

        // Размер высоты (смещение влево)
        points.heightStart = new Point(-scaleWidth / 2, 0);
        points.heightEnd = new Point(-scaleWidth / 2, -scaleHeight);
        points.heightOffset = -200;  // смещение влево (отрицательное)
        points.heightText = String.format("%.1f м", height);

        return points;
    }

    /**
     * Класс для хранения точек размеров
     */
    public static class DimensionPoints {
        public Point widthStart;
        public Point widthEnd;
        public int widthOffset;
        public String widthText;

        public Point heightStart;
        public Point heightEnd;
        public int heightOffset;
        public String heightText;

        public Point archHeightStart;
        public Point archHeightEnd;
        public int archHeightOffset;
        public String archHeightText;

        public Point lengthStart;
        public Point lengthEnd;
        public int lengthOffset;
        public String lengthText;
    }
}