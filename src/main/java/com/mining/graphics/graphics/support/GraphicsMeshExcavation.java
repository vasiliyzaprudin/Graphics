package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.MeshExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.ServiceMeshExcavation;

import java.awt.*;

public class GraphicsMeshExcavation {
    //Модели данных
    private final ModelExcavation model;
    private final MeshExcavation mesh;
    //Сервисы
    private final ServiceExcavation excavationService;
    private final ServiceMeshExcavation meshService;


    public GraphicsMeshExcavation(ModelExcavation model,
                                  MeshExcavation mesh,
                                  ServiceExcavation excavationService,
                                  ServiceMeshExcavation meshService) {
        this.model = model;
        this.mesh = mesh;
        this.excavationService = excavationService;
        this.meshService = meshService;
    }

    /**
     * Это графический метод построения сетки в поперечном сечении горной выработки.
     */
    public void drawCrossSectionExcavationMesh(Graphics g) {

        double width = model.getWidth();
        double height = model.getHeight();
        double formIndication = model.getFormIndication();
        int scale = GraphicsParameters.GRAPHICS_SCALE;

        double distanceBetweenContourAndGrid = mesh.getDistanceBetweenContourAndGrid();
        double distanceBetweenSoilAndMesh = mesh.getDistanceBetweenSoilAndMesh();

        int scaleDistanceBetweenSoilAndMesh = meshService.getScaleDistanceBetweenSoilAndMesh(distanceBetweenSoilAndMesh, scale);
        double widthExcavationWithMesh = meshService.getWidthExcavationWithMesh(width, distanceBetweenContourAndGrid);
        double heightExcavationWithMesh = meshService.getHeightExcavationWithMesh(height, distanceBetweenContourAndGrid);

        int scaleWidth = excavationService.getScaleWidth(widthExcavationWithMesh, scale);
        int scaleHeight = excavationService.getScaleHeight(heightExcavationWithMesh, scale);
        int scaleArchHeight = excavationService.getScaleArchHeight(widthExcavationWithMesh, formIndication, scale);
        int scaleSmallArcRadius = excavationService.getScaleSmallArcRadius(widthExcavationWithMesh, formIndication, scale);
        int scaleLargeArcRadius = excavationService.getScaleLargeArcRadius(widthExcavationWithMesh, formIndication, scale);
        int alphaDegree = excavationService.getAlphaDegree(widthExcavationWithMesh, formIndication);
        int betaDegree = excavationService.getBetaDegree(widthExcavationWithMesh, formIndication);

        Graphics2D g2d = (Graphics2D) g;

        // Создание пунктирного штриха
        float[] dashPattern = {10.0f, 5.0f}; // длина штриха 10px, промежуток 5px
        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        // Установка пунктирного штриха
        g2d.setStroke(dashedStroke);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(-scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g2d.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 90 + alphaDegree, betaDegree); //Левая малая дуга
        g2d.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, betaDegree, 2 * alphaDegree); //Большая дуга
        g2d.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, betaDegree); //Правая малая дуга
        g2d.drawLine(scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка

        // Возврат к обычному штриху (опционально)
        g2d.setStroke(new BasicStroke(1));
    }


//    /**
//     * Это графический метод построения сетки в продольном сечении горной выработки.
//     */
//    public void drawLongSectionExcavationMesh(Graphics g) {
//
//        int scaleHeight = serviceMeshExcavation.getScaleHeightExcavationWithMesh();
//        int scaleLength = serviceExcavation.getScaleLength();
//        int scaleDistanceBetweenSoilAndMesh = serviceMeshExcavation.getScaleDistanceBetweenSoilAndMesh();
//        int scaleGridStep = serviceMeshExcavation.getScaleGridStep();
//        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;
//
//        Graphics2D g2d = (Graphics2D) g;
//
//        // Создание пунктирного штриха
//        float[] dashPattern = {7.0f, 3.0f}; // длина штриха 7px, промежуток 3px
//        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
//
//        // Установка пунктирного штриха
//        g2d.setStroke(dashedStroke);
//        g2d.translate(distance, 0);
//        g2d.setColor(new Color(120, 130, 140)); //темносерый для сетки
//
//        for (int i = 0; scaleHeight - scaleDistanceBetweenSoilAndMesh >= i * scaleGridStep; i++) {
//            g2d.drawLine(0, - scaleDistanceBetweenSoilAndMesh - i * scaleGridStep, scaleLength, -scaleDistanceBetweenSoilAndMesh - i * scaleGridStep);
//        }
//
//        for (int i = 1; scaleLength >= (i+1) * scaleGridStep; i++) {
//            g2d.drawLine(i * scaleGridStep, -scaleHeight, i * scaleGridStep, -scaleDistanceBetweenSoilAndMesh);
//        }
//
//        g2d.translate(-distance, 0);
//        // Возврат к обычному штриху
//        g2d.setStroke(new BasicStroke(1));
//    }
}