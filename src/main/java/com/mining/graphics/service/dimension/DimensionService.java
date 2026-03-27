package com.mining.graphics.service.dimension;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.AnchorsExcavation;
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
    public DimensionPoints calculateCrossSectionDimensions(ModelExcavation model, AnchorsExcavation anchors, int scale) {
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
        points.widthOffset = 80;  // смещение вниз
        points.widthLengthextensionline = 30; //длина выносной линии
        points.widthText = String.format("%.1f м", width);

        // Размер высоты (смещение влево)
        points.heightStart = new Point(-scaleWidth / 2, 0);
        points.heightEnd = new Point(-scaleWidth / 2, -scaleHeight);
        points.heightOffset = -200;  // смещение влево (отрицательное)
        points.heightLengthextensionline = -30; //длина выносной линии
        points.heightText = String.format("%.1f м", height);

        // Расстояние до нижнего анкера (смещение вправо)
        double bottomAnchorY = anchors.getBottomAnchorY();
        int scaleBottomAnchorY = (int) Math.round(bottomAnchorY * scale);

        points.heightToBottomAnchorStart = new Point(-scaleWidth / 2, 0);
        points.heightToBottomAnchorEnd = new Point(-scaleWidth / 2, scaleBottomAnchorY);
        points.heightToBottomAnchorOffset = 550;  // смещение вправо
        points.heightToBottomAnchorLengthextensionline = 30; //длина выносной линии
        points.heightToBottomAnchorText = String.format("%.1f м", - bottomAnchorY);


        return points;
    }

    /**
     * Класс для хранения точек размеров
     */
    public static class DimensionPoints {
        public Point widthStart;
        public Point widthEnd;
        public int widthOffset;
        public int widthLengthextensionline;
        public String widthText;

        public Point heightStart;
        public Point heightEnd;
        public int heightOffset;
        public int heightLengthextensionline;
        public String heightText;

        public Point heightToBottomAnchorStart;
        public Point heightToBottomAnchorEnd;
        public int heightToBottomAnchorOffset;
        public int heightToBottomAnchorLengthextensionline;
        public String heightToBottomAnchorText;


        public Point lengthStart;
        public Point lengthEnd;
        public int lengthOffset;
        public String lengthText;
    }
}