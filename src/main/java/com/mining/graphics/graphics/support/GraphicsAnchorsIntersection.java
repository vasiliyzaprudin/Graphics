package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.model.excavation.ModelCoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.AnchorsIntersection;
import com.mining.graphics.service.support.ServiceAnchorsIntersection;

import java.awt.*;

public class GraphicsAnchorsIntersection {

    private final ModelIntersection modelIntersection;
    private final ModelCoordinatesIntersection modelCoordinatesIntersection;
    private final AnchorsIntersection anchorsIntersection;

    public GraphicsAnchorsIntersection(ModelIntersection modelIntersection, ModelCoordinatesIntersection modelCoordinatesIntersection,
                                       AnchorsIntersection anchorsIntersection) {
        this.modelIntersection = modelIntersection;
        this.modelCoordinatesIntersection = modelCoordinatesIntersection;
        this.anchorsIntersection = anchorsIntersection;
    }
    // @formatter:off
    public void drawAllAnchorsPlanRounding3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters12(modelIntersection, anchorsIntersection)));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters13(modelIntersection, anchorsIntersection)));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters21(modelIntersection, anchorsIntersection)));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters23(modelIntersection, anchorsIntersection)));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters32(modelIntersection, anchorsIntersection)));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                        modelCoordinatesIntersection.getRoundingParameters31(modelIntersection, anchorsIntersection)));
    }
    // @formatter:on
    public void drawAnchorsPlan(Graphics2D g, double[][] anchorPlanRoundXY) {
        int scale = GraphicsParameters.GRAPHICS_INTERSECTION_SCALE;
        for (int i = 0; i < anchorPlanRoundXY.length; i++) {
            int x1 = (int) Math.round(anchorPlanRoundXY[i][0] * scale);
            int y1 = (int) Math.round(anchorPlanRoundXY[i][1] * scale);
            int x2 = (int) Math.round(anchorPlanRoundXY[i][2] * scale);
            int y2 = (int) Math.round(anchorPlanRoundXY[i][3] * scale);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    public void drawAllAnchorsPlanLine3(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        double[][] anchorPlanRoundXY12 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters12(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY12, modelCoordinatesIntersection.getLineParametersRight1(modelIntersection, anchorsIntersection)));

        double[][] anchorPlanRoundXY13 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters13(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY13, modelCoordinatesIntersection.getLineParametersLeft1(modelIntersection, anchorsIntersection)));

        double[][] anchorPlanRoundXY23 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters23(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY23, modelCoordinatesIntersection.getLineParametersRight2(modelIntersection, anchorsIntersection)));

        double[][] anchorPlanRoundXY21 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters21(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY21, modelCoordinatesIntersection.getLineParametersLeft2(modelIntersection, anchorsIntersection)));

        double[][] anchorPlanRoundXY32 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters32(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY32, modelCoordinatesIntersection.getLineParametersLeft3(modelIntersection, anchorsIntersection)));

        double[][] anchorPlanRoundXY31 = ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters31(modelIntersection, anchorsIntersection));
        drawAnchorsPlan(g2d, ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                anchorPlanRoundXY31, modelCoordinatesIntersection.getLineParametersRight3(modelIntersection, anchorsIntersection)));
    }



//    /**
//     * Этот метод объединяет расчет координат
//     * и графическое изображение анкеров в проекции.
//     */
//    public void graphAnchProjIntConstr3(Graphics g) {
//        g.translate(0, distance); //Перенос начала координат в центр отрезка, изображающего почву сопряжения
//        calcCoordAnchProjInt(x21, -height2, cAl2, l2);
//        g.setColor(Color.BLUE);
//        graphAnchProjInt(g);
//        calcCoordAnchProjInt(x31, -height3, cAl3, l3);
//        g.setColor(new Color(0, 120, 0));
//        graphAnchProjInt(g);
//        g.translate(0, -distance); //Перенос начала координат в точку пересечения осей гороных выработок в плане сопряжения
//    }

//    /**
//     * Этот метод объединяет расчет координат
//     * и графическое построение перпендикуляров.
//     */
//    public void TestIntAnch(Graphics g) {
//        g.setColor(new Color(210, 220, 230));
//        //Для выработки 1
//        testX0Y0(cAl1, xb1, -yb1);
//        graphicsTestAnch(g);
//        //Для выработки 2
//        testX0Y0(cAl2, xb2, -yb2);
//        graphicsTestAnch(g);
//        //Для выработки 3
//        testX0Y0(cAl3, xb3, yb3);
//        graphicsTestAnch(g);
//        g.setColor(Color.BLACK);
//    }



//    /**
//     * Это графический метод построения анкеров в плане на прямом отрезке сопряжения.
//     */
//    public void graphAnchPlanIntLine(Graphics g) {
//        if (numAnchPlanLine >= 0) {
//            for (int i = 0; i <= numAnchPlanLine; i++) {
//                g.drawLine((int) (СoorAncIntPlanLine[i][0] * scaleInt), (int) (СoorAncIntPlanLine[i][1] * scaleInt),
//                        (int) (СoorAncIntPlanLine[i][2] * scaleInt), (int) (СoorAncIntPlanLine[i][3] * scaleInt));
//            }
//        } else {
//        }
//    }
//
//    /**
//     * Это графический метод построения анкеров в проекции сопряжения.
//     */
//    public void graphAnchProjInt(Graphics g) {
//        for (int i = 0; i <= numAnchProj; i++) {
//            g.drawLine((int) (СoorAncIntProj[i][0] * scaleInt), (int) (СoorAncIntProj[i][1] * scaleInt),
//                    (int) (СoorAncIntProj[i][2] * scaleInt), (int) (СoorAncIntProj[i][3] * scaleInt));
//        }
//    }
//
//    /**
//     * Этот графический метод строит перпендикуляры к оси горной выработки
//     * от начала координат до забоя с шагом анкерования.
//     */
//    public void graphicsTestAnch(Graphics g) {
//        for (int i = 0; i <= numAnchTest; i++) {
//            g.drawLine((int) (СoorTestX0Y0[i][0] * scaleInt), (int) (СoorTestX0Y0[i][1] * scaleInt),
//                    (int) (СoorTestX0Y0[i][2] * scaleInt), (int) (СoorTestX0Y0[i][3] * scaleInt));
//        }
//    }
}