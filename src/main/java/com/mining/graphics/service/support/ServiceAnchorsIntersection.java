package com.mining.graphics.service.support;

import com.mining.graphics.model.excavation.CoordinatesIntersectionLine;
import com.mining.graphics.model.excavation.CoordinatesIntersectionRounding;
import com.mining.graphics.service.GeneralService;

public class ServiceAnchorsIntersection {

    public static double calculateAngleBetweenHorizontalAndAxisExcavation(double xIntersectionAxisAndStope, double yIntersectionAxisAndStope) {
        return Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope);
    }

    public static double calculatePhi(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xPointIntrsectionStopeAndWall,
                                      double yPointIntrsectionStopeAndWall, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope) {
        return Math.atan2(yPointIntrsectionStopeAndWall - yPointIntrsectionExcavations, xPointIntrsectionStopeAndWall - xPointIntrsectionExcavations) - calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);
    }


    public static double calculateStartX(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xStartRounding,
                                         double yStartRounding, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope,
                                         double distanceBetweenRows) {

        double  azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double omega = GeneralService.angleBetweenLines(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0.0, 0.0, 0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double distance = GeneralService.distanceBetweenPoint(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0, 0);
        double projection;
        if (azimuthRadians >= Math.PI / 4.0)
            projection = Math.abs(distance * Math.abs(Math.cos(omega)));
        else
            projection = Math.abs(distance * (Math.cos(omega)));

        double phi = calculatePhi(xPointIntrsectionExcavations, yPointIntrsectionExcavations, xStartRounding, yStartRounding, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double beta = calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        double delta;
        if (Math.abs(phi) < 0.01) {
            delta = 0;
        } else {
            delta = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
        }
        return xPointIntrsectionExcavations + (delta / Math.cos(phi)) * Math.cos(beta + phi);
    }

    public static double calculateStartY(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xStartRounding,
                                         double yStartRounding, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope,
                                         double distanceBetweenRows) {
        double  azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double omega = GeneralService.angleBetweenLines(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0.0, 0.0, 0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double distance = GeneralService.distanceBetweenPoint(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0, 0);
        double projection;
        if (azimuthRadians >= Math.PI / 4.0)
            projection = Math.abs(distance * Math.abs(Math.cos(omega)));
        else
            projection = Math.abs(distance * (Math.cos(omega)));

        double phi = calculatePhi(xPointIntrsectionExcavations, yPointIntrsectionExcavations, xStartRounding, yStartRounding, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double beta = calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        double delta;
        if (Math.abs(phi) < 0.01) {
            delta = 0;
        } else {
            delta = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
        }
        return yPointIntrsectionExcavations + (delta / Math.cos(phi)) * Math.sin(beta + phi);
    }


    // @formatter:off
    public static double[][] calculateCoordinatesAnchorPlanRound(CoordinatesIntersectionRounding roundingParameters,
                                                                 double distanceBetweenRows, double lengthAnchor) {

        double xPointIntersectionExcavations = roundingParameters.getXPointIntersection();
        double yPointIntersectionExcavations = roundingParameters.getYPointIntersection();
        double xStartRounding = roundingParameters.getXStartRounding();
        double yStartRounding = roundingParameters.getYStartRounding();
        double xIntersectionAxisAndStope = roundingParameters.getXIntersectionAxisAndStope();
        double yIntersectionAxisAndStope = roundingParameters.getYIntersectionAxisAndStope();

        double  azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double phi = GeneralService.angleBetweenLines(xPointIntersectionExcavations,
                yPointIntersectionExcavations, xStartRounding, yStartRounding,
                0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        double startX = calculateStartX(xPointIntersectionExcavations, yPointIntersectionExcavations,
                xStartRounding, yStartRounding, xIntersectionAxisAndStope,
                yIntersectionAxisAndStope, distanceBetweenRows);
        double startY = calculateStartY(xPointIntersectionExcavations, yPointIntersectionExcavations,
                xStartRounding, yStartRounding, xIntersectionAxisAndStope,
                yIntersectionAxisAndStope, distanceBetweenRows);
    // @formatter:on

        double distanceBetweenRowsToRounding = distanceBetweenRows / Math.cos(phi);

        double lToRounding;

        if (azimuthRadians >= Math.PI / 4) lToRounding = lengthAnchor;
        else lToRounding = -lengthAnchor;

        double gamma = Math.atan2(yStartRounding - yPointIntersectionExcavations, xStartRounding - xPointIntersectionExcavations);

        double distanceRounding = GeneralService.distanceBetweenPoint(startX, startY, xStartRounding, yStartRounding);

        int numberAnchorRounding = (int) (distanceRounding / Math.abs(distanceBetweenRowsToRounding));

        double distanceX = distanceBetweenRowsToRounding * Math.cos(gamma);
        double distanceY = distanceBetweenRowsToRounding * Math.sin(gamma);

        double[][] anchorPlanRoundXY = new double[numberAnchorRounding + 1][4];

        if (yPointIntersectionExcavations >= 0) {
            if (xPointIntersectionExcavations + xStartRounding >= 0) {
                for (int i = 0, j = 0; numberAnchorRounding >= j; j++, i++) {
                    anchorPlanRoundXY[i][0] = startX + j * distanceX;
                    anchorPlanRoundXY[i][1] = startY + j * distanceY;
                    anchorPlanRoundXY[i][2] = startX + j * distanceX - lToRounding * Math.sin(gamma);
                    anchorPlanRoundXY[i][3] = startY + j * distanceY + lToRounding * Math.cos(gamma);
                }
            } else {
                for (int i = 0, j = 0; numberAnchorRounding >= j; j++, i++) {
                    anchorPlanRoundXY[i][0] = startX + j * distanceX;
                    anchorPlanRoundXY[i][1] = startY + j * distanceY;
                    anchorPlanRoundXY[i][2] = startX + j * distanceX + lToRounding * Math.sin(gamma);
                    anchorPlanRoundXY[i][3] = startY + j * distanceY - lToRounding * Math.cos(gamma);
                }
            }
        } else {
            if (xPointIntersectionExcavations + xStartRounding >= 0) {
                for (int i = 0, j = 0; numberAnchorRounding >= j; j++, i++) {
                    anchorPlanRoundXY[i][0] = startX + j * distanceX;
                    anchorPlanRoundXY[i][1] = startY + j * distanceY;
                    anchorPlanRoundXY[i][2] = startX + j * distanceX + lToRounding * Math.sin(gamma);
                    anchorPlanRoundXY[i][3] = startY + j * distanceY - lToRounding * Math.cos(gamma);
                }
            } else {
                for (int i = 0, j = 0; numberAnchorRounding >= j; j++, i++) {
                    anchorPlanRoundXY[i][0] = startX + j * distanceX;
                    anchorPlanRoundXY[i][1] = startY + j * distanceY;
                    anchorPlanRoundXY[i][2] = startX + j * distanceX - lToRounding * Math.sin(gamma);
                    anchorPlanRoundXY[i][3] = startY + j * distanceY + lToRounding * Math.cos(gamma);
                }
            }
        }
        return anchorPlanRoundXY;
    }

    public static double[][] calculateCoordinatesAnchorPlanLine(double[][] anchorPlanRoundXY, CoordinatesIntersectionLine lineParameters,
                                                                double distanceBetweenRows, double lengthAnchor) {

        double xStartRounding1 = lineParameters.getXStartRounding1();
        double yStartRounding1 = lineParameters.getYStartRounding1();
        double xStope1 = lineParameters.getXStope1();
        double yStope1 = lineParameters.getYStope1();
        double xIntersectionAxisAndStope = lineParameters.getXIntersectionAxisAndStope();
        double yIntersectionAxisAndStope = lineParameters.getYIntersectionAxisAndStope();
        double xStartRounding2 = lineParameters.getXStartRounding2();
        double yStartRounding2 = lineParameters.getYStartRounding2();
        double xStope2 = lineParameters.getXStope2();
        double yStope2 = lineParameters.getYStope2();

        double azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;

        double xExtremeAnchor = anchorPlanRoundXY[anchorPlanRoundXY.length - 1][0];
        double yExtremeAnchor = anchorPlanRoundXY[anchorPlanRoundXY.length - 1][1];

        double lengthRemainderRound = GeneralService.distanceBetweenPoint(xStartRounding1, yStartRounding1,
                xExtremeAnchor, yExtremeAnchor);
        double lengthSide = GeneralService.distanceBetweenPoint(xStope1, yStope1, xStartRounding1, yStartRounding1) -
                GeneralService.distanceBetweenPoint(xStope2, yStope2, xStartRounding2, yStartRounding2);

        int numberAnchorLine = (int) (Math.ceil(lengthRemainderRound + lengthSide) / distanceBetweenRows);

        if (numberAnchorLine >= 0) {
            double[][] anchorPlanLineXY = new double[numberAnchorLine + 1][4];

            double Beta = Math.atan2(yStope1 - yStartRounding1, xStope1 - xStartRounding1);

            double xStartAnchor = xStartRounding1 + (distanceBetweenRows - lengthRemainderRound) * Math.cos(Beta);
            double yStartAnchor = yStartRounding1 + (distanceBetweenRows - lengthRemainderRound) * Math.sin(Beta);

            // Условия ориентации анкеров для разных горных выработок
            double anchorLength = lengthAnchor;
            if (-Math.PI / 4 <= azimuthRadians && azimuthRadians <= Math.PI / 4 && xStartRounding1 > xStartRounding2
                    || Math.PI / 4 <= azimuthRadians && azimuthRadians <= Math.PI * 3 / 4 && yStartRounding1 > yStartRounding2
                    || Math.PI * 5 / 4 <= azimuthRadians && azimuthRadians <= Math.PI * 7 / 4 && yStartRounding1 < yStartRounding2) {
                anchorLength = lengthAnchor * (-1.0);
            }

            for (int i = 0, j = 0; lengthRemainderRound + lengthSide - distanceBetweenRows >= j * distanceBetweenRows; j++, i++) {
                anchorPlanLineXY[i][0] = xStartAnchor + j * distanceBetweenRows * Math.cos(Beta);
                anchorPlanLineXY[i][1] = yStartAnchor + j * distanceBetweenRows * Math.sin(Beta);
                anchorPlanLineXY[i][2] = xStartAnchor + j * distanceBetweenRows * Math.cos(Beta) + anchorLength * Math.sin(Beta);
                anchorPlanLineXY[i][3] = yStartAnchor + j * distanceBetweenRows * Math.sin(Beta) - anchorLength * Math.cos(Beta);
            }
            return anchorPlanLineXY;
        }
        return anchorPlanRoundXY;
    }

    public static double[][] testPlanStartXY(double intersectionAxisAndStopeX, double intersectionAxisAndStopeY, double distanceBetweenRows, double lengthLineTestAnchorsPlanIntersection) {

        double lengthLine = GeneralService.distanceBetweenPoint(intersectionAxisAndStopeX, intersectionAxisAndStopeY, 0.0, 0.0);
        int numberLineTest = (int) (lengthLine / distanceBetweenRows);

        double sigma = Math.atan2(intersectionAxisAndStopeY, intersectionAxisAndStopeX);

        double[][] lineTestXY = new double[numberLineTest + 1][4];

        for (int i = 0, j = 0; lengthLine >= j * distanceBetweenRows; j++, i++) {
            lineTestXY[i][0] = j * distanceBetweenRows * Math.cos(sigma) - lengthLineTestAnchorsPlanIntersection * Math.cos(sigma - Math.PI / 2);
            lineTestXY[i][1] = j * distanceBetweenRows * Math.sin(sigma) - lengthLineTestAnchorsPlanIntersection * Math.sin(sigma - Math.PI / 2);
            lineTestXY[i][2] = j * distanceBetweenRows * Math.cos(sigma) + lengthLineTestAnchorsPlanIntersection * Math.cos(sigma - Math.PI / 2);
            lineTestXY[i][3] = j * distanceBetweenRows * Math.sin(sigma) + lengthLineTestAnchorsPlanIntersection * Math.sin(sigma - Math.PI / 2);
        }
        return lineTestXY;
    }
}

//    /**
//     * Это метод рассчета координат установки анкеров в проекции.
//     */
//    public void calcCoordAnchProjInt(double X1, double Y1, double CAL, double L) {
//        int i, j, k;
//
//        double B = distanceBetweenPoint(x33, y33, x1, y1); //Ширина выработки
//
//        double ArcLength = RBIG(B, formIndicationIntersection) * calcAngleBetweenVertAndPointCont(X1, Y1); //Длина дуги
//
//        double LineLength = distanceBetweenPoint(calcCoordPointContX(X1, Y1), calcCoordPointContY(X1, Y1), X1, Y1); //Длина прямолинейного отрезка
//
//        numAnchProj = (int) (Math.ceil((ArcLength + LineLength) / CAL));
//
//        double X0arc = 0.0; //координата X установки первого анкера по дуге
//        double Y0arc = height1 * calcIndHeightInt(); //координата Y установки первого анкера по дуге
//
//        СoorAncIntProj = new double[numAnchProj + 1][4]; //numAnchProj + 1 - количество анкеров в ряду
//
//        //определение координат установки анкеров по дуге большого радиуса
//        if (X1 >= 0) {
//            for (i = 0, j = 0; ArcLength >= j * CAL; i++, j++) {
//                СoorAncIntProj[i][0] = X0arc + RBIG(B, formIndicationIntersection) * Math.sin(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][1] = -Y0arc * Math.cos(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][2] = X0arc + (RBIG(B, formIndicationIntersection) + L) * Math.sin(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][3] = (-Y0arc - L) * Math.cos(j * CAL / RBIG(B, formIndicationIntersection));
//            }
//        } else {
//            for (i = 0, j = 0; ArcLength >= j * CAL; i++, j++) {
//                СoorAncIntProj[i][0] = X0arc - RBIG(B, formIndicationIntersection) * Math.sin(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][1] = -Y0arc * Math.cos(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][2] = X0arc - (RBIG(B, formIndicationIntersection) + L) * Math.sin(j * CAL / RBIG(B, formIndicationIntersection));
//                СoorAncIntProj[i][3] = (-Y0arc - L) * Math.cos(j * CAL / RBIG(B, formIndicationIntersection));
//            }
//        }
//
//        double REMAIN = ArcLength - (i - 1) * CAL; //остаток дуги
//        double OMEGA = Math.atan(Math.abs((calcCoordPointContY(X1, Y1) - Y1) / (calcCoordPointContX(X1, Y1) - X1))); //угол наклона прямолинейного отрезка кровли отностительно оси X
//
//        //определение координат установки анкеров по прямолинейному участку кровли сопряжения
//        if (X1 >= 0) {
//            XStartAnchToLine = calcCoordPointContX(X1, Y1) + (CAL - REMAIN) * Math.cos(OMEGA); //координата X установки первого анкера по линии
//            YStartAnchToLine = calcCoordPointContY(X1, Y1) + (CAL - REMAIN) * Math.sin(OMEGA); //координата Y установки первого анкера по линии
//        } else {
//            XStartAnchToLine = calcCoordPointContX(X1, Y1) - (CAL - REMAIN) * Math.cos(OMEGA); //координата X установки первого анкера по линии
//            YStartAnchToLine = calcCoordPointContY(X1, Y1) + (CAL - REMAIN) * Math.sin(OMEGA); //координата Y установки первого анкера по линии
//        }
//
//        if (X1 >= 0) {
//            for (k = 0; (REMAIN + LineLength) * Math.cos(OMEGA) - CAL >= k * CAL; i++, k++) {
//                СoorAncIntProj[i][0] = XStartAnchToLine + k * CAL;
//                СoorAncIntProj[i][1] = YStartAnchToLine + k * CAL * Math.sin(OMEGA);
//                СoorAncIntProj[i][2] = XStartAnchToLine + k * CAL + L * Math.cos(OMEGA - Math.PI / 2.0);
//                СoorAncIntProj[i][3] = YStartAnchToLine + k * CAL * Math.sin(OMEGA) + L * Math.sin(OMEGA - Math.PI / 2.0);
//            }
//        } else {
//            for (k = 0; (REMAIN + LineLength) * Math.cos(OMEGA) - CAL >= k * CAL; i++, k++) {
//                СoorAncIntProj[i][0] = XStartAnchToLine - k * CAL;
//                СoorAncIntProj[i][1] = YStartAnchToLine + k * CAL * Math.sin(OMEGA);
//                СoorAncIntProj[i][2] = XStartAnchToLine - k * CAL + L * Math.cos(OMEGA + Math.PI / 2.0);
//                СoorAncIntProj[i][3] = YStartAnchToLine + k * CAL * Math.sin(OMEGA) - L * Math.sin(OMEGA + Math.PI / 2.0);
//            }
//        }
//    }



