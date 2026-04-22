package com.mining.graphics.graphics.support.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.MeshExcavation;
import com.mining.graphics.service.excavation.ServiceExcavation;
import com.mining.graphics.service.support.excavation.ServiceMeshExcavation;

import java.awt.*;

public class GraphicsMeshExcavation {

    private final ModelExcavation modelExcavation;
    private final MeshExcavation meshExcavation;


    public GraphicsMeshExcavation(ModelExcavation modelExcavation,
                                  MeshExcavation meshExcavation) {
        this.modelExcavation = modelExcavation;
        this.meshExcavation = meshExcavation;
    }

    public void drawCrossSectionExcavationMesh(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;

        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double distanceBetweenContourAndGrid = meshExcavation.getDistanceBetweenContourAndGrid();
        double distanceBetweenSoilAndMesh = meshExcavation.getDistanceBetweenSoilAndMesh();

        int scaleDistanceBetweenSoilAndMesh = ServiceMeshExcavation.getScaleDistanceBetweenSoilAndMesh(distanceBetweenSoilAndMesh, scale);
        double widthExcavationWithMesh = ServiceMeshExcavation.getWidthExcavationWithMesh(width, distanceBetweenContourAndGrid);
        double heightExcavationWithMesh = ServiceMeshExcavation.getHeightExcavationWithMesh(height, distanceBetweenContourAndGrid);

        int scaleWidth = ServiceExcavation.scaleWidth(widthExcavationWithMesh, scale);
        int scaleHeight = ServiceExcavation.scaleHeight(heightExcavationWithMesh, scale);
        int scaleArchHeight = ServiceExcavation.scaleArchHeight(widthExcavationWithMesh, formIndication, scale);
        int scaleSmallArcRadius = ServiceExcavation.scaleSmallArcRadius(widthExcavationWithMesh, formIndication, scale);
        int scaleLargeArcRadius = ServiceExcavation.scaleLargeArcRadius(widthExcavationWithMesh, formIndication, scale);
        double alphaDegree = ServiceExcavation.alphaDegree(widthExcavationWithMesh, formIndication);
        double betaDegree = ServiceExcavation.betaDegree(widthExcavationWithMesh, formIndication);

        Graphics2D g2d = (Graphics2D) g;

        float[] dashPattern = {10.0f, 5.0f};
        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(dashedStroke);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(-scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, (int) (Math.round(-scaleWidth / 2.0)), -(scaleHeight - scaleArchHeight)); //Левая стенка
        g2d.drawArc(-scaleWidth / 2, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, (int) Math.round(90 + alphaDegree), (int) Math.round(betaDegree)); //Левая малая дуга
        g2d.drawArc(-scaleLargeArcRadius, -scaleHeight, 2 * scaleLargeArcRadius, 2 * scaleLargeArcRadius, (int) Math.round(betaDegree), (int) Math.round(2 * alphaDegree)); //Большая дуга
        g2d.drawArc(scaleWidth / 2 - 2 * scaleSmallArcRadius, -(scaleHeight - scaleArchHeight) - scaleSmallArcRadius, 2 * scaleSmallArcRadius, 2 * scaleSmallArcRadius, 0, (int) Math.round(betaDegree)); //Правая малая дуга
        g2d.drawLine(scaleWidth / 2, -scaleDistanceBetweenSoilAndMesh, scaleWidth / 2, -(scaleHeight - scaleArchHeight)); //Правая стенка

        g2d.setStroke(new BasicStroke(1));
    }

    public void drawLongSectionExcavationMesh(Graphics g) {
        int scale = GraphicsParameters.GRAPHICS_EXCAVATION_SCALE;
        int distance = GraphicsParameters.DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION;

        double height = modelExcavation.getHeight();
        double length = modelExcavation.getLength();

        double distanceBetweenContourAndGrid = meshExcavation.getDistanceBetweenContourAndGrid();
        double distanceBetweenSoilAndMesh = meshExcavation.getDistanceBetweenSoilAndMesh();
        double gridStep = meshExcavation.getGridStep();

        double heightExcavationWithMesh = ServiceMeshExcavation.getHeightExcavationWithMesh(height, distanceBetweenContourAndGrid);
        int scaleDistanceBetweenSoilAndMesh = ServiceMeshExcavation.getScaleDistanceBetweenSoilAndMesh(distanceBetweenSoilAndMesh, scale);
        int scaleGridStep = ServiceMeshExcavation.getScaleGridStep(gridStep,scale);

        int scaleHeight = ServiceExcavation.scaleHeight(heightExcavationWithMesh, scale);
        int scaleLength = ServiceExcavation.scaleLength(length, scale);

        Graphics2D g2d = (Graphics2D) g;

        float[] dashPattern = {7.0f, 3.0f};
        BasicStroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);

        g2d.setStroke(dashedStroke);
        g2d.translate(distance, 0);
        g2d.setColor(new Color(120, 130, 140));

        for (int i = 0; scaleHeight - scaleDistanceBetweenSoilAndMesh >= i * scaleGridStep; i++) {
            g2d.drawLine(0, - scaleDistanceBetweenSoilAndMesh - i * scaleGridStep, scaleLength, -scaleDistanceBetweenSoilAndMesh - i * scaleGridStep);
        }

        for (int i = 1; scaleLength >= (i+1) * scaleGridStep; i++) {
            g2d.drawLine(i * scaleGridStep, -scaleHeight, i * scaleGridStep, -scaleDistanceBetweenSoilAndMesh);
        }
        g2d.drawLine(0, -scaleHeight, scaleLength, -scaleHeight);

        g2d.translate(-distance, 0);

        g2d.setStroke(new BasicStroke(1));
    }
}