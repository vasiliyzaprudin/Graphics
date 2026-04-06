package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.MeshExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.ServiceMeshExcavation;

import java.awt.*;

public class GraphicsMeshExcavation {
    //Модели данных
    private final ModelExcavation modelExcavation;
    private final MeshExcavation meshExcavation;
    //Сервисы
    private final ServiceExcavation serviceExcavation;
    private final ServiceMeshExcavation serviceMeshExcavation;

    public GraphicsMeshExcavation(ModelExcavation modelExcavation,
                                  MeshExcavation meshExcavation,
                                  ServiceExcavation serviceExcavation,
                                  ServiceMeshExcavation serviceMeshExcavation) {
        this.modelExcavation = modelExcavation;
        this.meshExcavation = meshExcavation;
        this.serviceExcavation = serviceExcavation;
        this.serviceMeshExcavation = serviceMeshExcavation;
    }

    /**
     * Это графический метод построения сетки в поперечном сечении горной выработки.
     */
    public void drawCrossSectionExcavationMesh(Graphics g) {

        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;

        double distanceBetweenContourAndGrid = meshExcavation.getDistanceBetweenContourAndGrid();
        double distanceBetweenSoilAndMesh = meshExcavation.getDistanceBetweenSoilAndMesh();

        int scaleDistanceBetweenSoilAndMesh = serviceMeshExcavation.getScaleDistanceBetweenSoilAndMesh(distanceBetweenSoilAndMesh, scale);
        double widthExcavationWithMesh = serviceMeshExcavation.getWidthExcavationWithMesh(width, distanceBetweenContourAndGrid);
        double heightExcavationWithMesh = serviceMeshExcavation.getHeightExcavationWithMesh(height, distanceBetweenContourAndGrid);

        int scaleWidth = serviceExcavation.getScaleWidth(widthExcavationWithMesh, scale);
        int scaleHeight = serviceExcavation.getScaleHeight(heightExcavationWithMesh, scale);
        int scaleArchHeight = serviceExcavation.getScaleArchHeight(widthExcavationWithMesh, formIndication, scale);
        int scaleSmallArcRadius = serviceExcavation.getScaleSmallArcRadius(widthExcavationWithMesh, formIndication, scale);
        int scaleLargeArcRadius = serviceExcavation.getScaleLargeArcRadius(widthExcavationWithMesh, formIndication, scale);
        double alphaDegree = serviceExcavation.getAlphaDegree(widthExcavationWithMesh, formIndication);
        double betaDegree = serviceExcavation.getBetaDegree(widthExcavationWithMesh, formIndication);

        Graphics2D g2d = (Graphics2D) g;

        // Создание пунктирного штриха
        float[] dashPattern = {10.0f, 5.0f}; // длина штриха 10px, промежуток 5px
        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        // Установка пунктирного штриха
        g2d.setStroke(dashedStroke);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(-scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g2d.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, (int) Math.round(90 + alphaDegree), (int) Math.round(betaDegree)); //Левая малая дуга
        g2d.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, (int) Math.round(betaDegree), (int) Math.round(2 * alphaDegree)); //Большая дуга
        g2d.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, (int) Math.round(betaDegree)); //Правая малая дуга
        g2d.drawLine(scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка

        // Возврат к обычному штриху (опционально)
        g2d.setStroke(new BasicStroke(1));
    }


    /**
     * Это графический метод построения сетки в продольном сечении горной выработки.
     */
    public void drawLongSectionExcavationMesh(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();

        double distanceBetweenContourAndGrid = meshExcavation.getDistanceBetweenContourAndGrid();
        double distanceBetweenSoilAndMesh = meshExcavation.getDistanceBetweenSoilAndMesh();
        double gridStep = meshExcavation.getGridStep();

        double heightExcavationWithMesh = serviceMeshExcavation.getHeightExcavationWithMesh(height, distanceBetweenContourAndGrid);
        int scaleDistanceBetweenSoilAndMesh = serviceMeshExcavation.getScaleDistanceBetweenSoilAndMesh(distanceBetweenSoilAndMesh, scale);
        int scaleGridStep = serviceMeshExcavation.getScaleGridStep(gridStep,scale);

        int scaleHeight = serviceExcavation.getScaleHeight(heightExcavationWithMesh, scale);
        int scaleLength = serviceExcavation.getScaleLength(length, scale);

        Graphics2D g2d = (Graphics2D) g;

        // Создание пунктирного штриха
        float[] dashPattern = {7.0f, 3.0f}; // длина штриха 7px, промежуток 3px
        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        // Установка пунктирного штриха
        g2d.setStroke(dashedStroke);
        g2d.translate(distance, 0);
        g2d.setColor(new Color(120, 130, 140)); //темносерый для сетки

        for (int i = 0; scaleHeight - scaleDistanceBetweenSoilAndMesh >= i * scaleGridStep; i++) {
            g2d.drawLine(0, - scaleDistanceBetweenSoilAndMesh - i * scaleGridStep, scaleLength, -scaleDistanceBetweenSoilAndMesh - i * scaleGridStep);
        }

        for (int i = 1; scaleLength >= (i+1) * scaleGridStep; i++) {
            g2d.drawLine(i * scaleGridStep, -scaleHeight, i * scaleGridStep, -scaleDistanceBetweenSoilAndMesh);
        }
        g2d.drawLine(0, -scaleHeight, scaleLength, -scaleHeight);

        g2d.translate(-distance, 0);
        // Возврат к обычному штриху
        g2d.setStroke(new BasicStroke(1));
    }
}