package com.mining.graphics.service.support;

import com.mining.graphics.model.excavation.CoordinatesIntersectionLine;
import com.mining.graphics.model.excavation.CoordinatesIntersectionRounding;
import com.mining.graphics.service.GeneralService;
import com.mining.graphics.service.excavation.ServiceExcavation;

public class ServiceAnchorsIntersection {

    public static double calculateAngleBetweenHorizontalAndAxisExcavation(double xIntersectionAxisAndStope, double yIntersectionAxisAndStope) {
        return Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope);
    }

    public static double calculatePhi(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xPointIntrsectionStopeAndWall,
                                      double yPointIntrsectionStopeAndWall, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope) {
        return Math.atan2(yPointIntrsectionStopeAndWall - yPointIntrsectionExcavations, xPointIntrsectionStopeAndWall - xPointIntrsectionExcavations) - calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);
    }


    public static double calculateStartX(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xStartRounding,
                                         double yStartRounding, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope, double width,
                                         double height, double formIndication, double distanceBetweenRows, double distanceLowerAnchor, double step) {

        double azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double omega = GeneralService.angleBetweenLines(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0.0, 0.0, 0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double distance = GeneralService.distanceBetweenPoint(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0, 0);
        double projection;
        if (azimuthRadians >= Math.PI / 4.0) projection = Math.abs(distance * Math.abs(Math.cos(omega)));
        else projection = Math.abs(distance * (Math.cos(omega)));

        double phi = calculatePhi(xPointIntrsectionExcavations, yPointIntrsectionExcavations, xStartRounding, yStartRounding, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double beta = calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        //Проверка варианта расположения анкеров
        double delta;
        double d;

        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        int numberCrossSectionAnchors = (int) Math.ceil((totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0) / step);
        if ((numberCrossSectionAnchors + 1) % 2 == 0) {
            // Анкер по центру
            if (Math.abs(phi) < 0.01) {
                delta = 0;
            } else {
                delta = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
            }
        } else {
            // Анкер со смещением
            if (Math.abs(phi) < 0.01) {
                delta = distanceBetweenRows / 2.0;
            } else {
                d = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
                if (d < distanceBetweenRows / 2.0) delta = d + distanceBetweenRows / 2.0;
                else delta = d - distanceBetweenRows / 2.0;
            }
        }

        return xPointIntrsectionExcavations + (delta / Math.cos(phi)) * Math.cos(beta + phi);
    }

    public static double calculateStartY(double xPointIntrsectionExcavations, double yPointIntrsectionExcavations, double xStartRounding,
                                         double yStartRounding, double xIntersectionAxisAndStope, double yIntersectionAxisAndStope, double width,
                                         double height, double formIndication, double distanceBetweenRows, double distanceLowerAnchor, double step) {
        double azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double omega = GeneralService.angleBetweenLines(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0.0, 0.0, 0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double distance = GeneralService.distanceBetweenPoint(xPointIntrsectionExcavations, yPointIntrsectionExcavations, 0, 0);
        double projection;
        if (azimuthRadians >= Math.PI / 4.0) projection = Math.abs(distance * Math.abs(Math.cos(omega)));
        else projection = Math.abs(distance * (Math.cos(omega)));

        double phi = calculatePhi(xPointIntrsectionExcavations, yPointIntrsectionExcavations, xStartRounding, yStartRounding, xIntersectionAxisAndStope, yIntersectionAxisAndStope);
        double beta = calculateAngleBetweenHorizontalAndAxisExcavation(xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        //Проверка варианта расположения анкеров
        double delta;
        double d;

        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        int numberCrossSectionAnchors = (int) Math.ceil((totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0) / step);
        if ((numberCrossSectionAnchors + 1) % 2 == 0) {
            // Анкер по центру
            if (Math.abs(phi) < 0.01) {
                delta = 0;
            } else {
                delta = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
            }
        } else {
            // Анкер со смещением
            if (Math.abs(phi) < 0.01) {
                delta = distanceBetweenRows / 2.0;
            } else {
                d = Math.ceil(projection / distanceBetweenRows) * distanceBetweenRows - projection;
                if (d < distanceBetweenRows / 2.0) delta = d + distanceBetweenRows / 2.0;
                else delta = d - distanceBetweenRows / 2.0;
            }
        }
        return yPointIntrsectionExcavations + (delta / Math.cos(phi)) * Math.sin(beta + phi);
    }


    // @formatter:off
    public static double[][] calculateCoordinatesAnchorPlanRound(CoordinatesIntersectionRounding coordinatesIntersectionRounding, double width, double height, double formIndication,
                                                                 double distanceBetweenRows, double distanceLowerAnchor, double step, double lengthAnchor) {

        double xPointIntersectionExcavations = coordinatesIntersectionRounding.getXPointIntersection();
        double yPointIntersectionExcavations = coordinatesIntersectionRounding.getYPointIntersection();
        double xStartRounding = coordinatesIntersectionRounding.getXStartRounding();
        double yStartRounding = coordinatesIntersectionRounding.getYStartRounding();
        double xIntersectionAxisAndStope = coordinatesIntersectionRounding.getXIntersectionAxisAndStope();
        double yIntersectionAxisAndStope = coordinatesIntersectionRounding.getYIntersectionAxisAndStope();

        double azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;
        double phi = GeneralService.angleBetweenLines(xPointIntersectionExcavations,
                yPointIntersectionExcavations, xStartRounding, yStartRounding,
                0.0, 0.0, xIntersectionAxisAndStope, yIntersectionAxisAndStope);

        double startX = calculateStartX(xPointIntersectionExcavations, yPointIntersectionExcavations,
                xStartRounding, yStartRounding, xIntersectionAxisAndStope,
                yIntersectionAxisAndStope, width, height, formIndication, distanceBetweenRows, distanceLowerAnchor, step);
        double startY = calculateStartY(xPointIntersectionExcavations, yPointIntersectionExcavations,
                xStartRounding, yStartRounding, xIntersectionAxisAndStope,
                yIntersectionAxisAndStope, width, height, formIndication, distanceBetweenRows, distanceLowerAnchor, step);
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

    public static double[][] calculateCoordinatesAnchorPlanLine(double[][] anchorPlanRoundXY, CoordinatesIntersectionLine coordinatesIntersectionLine,
                                                                double distanceBetweenRows, double lengthAnchor) {

        double xStartRounding1 = coordinatesIntersectionLine.getXStartRounding1();
        double yStartRounding1 = coordinatesIntersectionLine.getYStartRounding1();
        double xStope1 = coordinatesIntersectionLine.getXStope1();
        double yStope1 = coordinatesIntersectionLine.getYStope1();
        double xIntersectionAxisAndStope = coordinatesIntersectionLine.getXIntersectionAxisAndStope();
        double yIntersectionAxisAndStope = coordinatesIntersectionLine.getYIntersectionAxisAndStope();
        double xStartRounding2 = coordinatesIntersectionLine.getXStartRounding2();
        double yStartRounding2 = coordinatesIntersectionLine.getYStartRounding2();
        double xStope2 = coordinatesIntersectionLine.getXStope2();
        double yStope2 = coordinatesIntersectionLine.getYStope2();

        double azimuthRadians = Math.atan2(yIntersectionAxisAndStope, xIntersectionAxisAndStope) + Math.PI / 2;

        double xExtremeAnchor = anchorPlanRoundXY[anchorPlanRoundXY.length - 1][0];
        double yExtremeAnchor = anchorPlanRoundXY[anchorPlanRoundXY.length - 1][1];

        double lengthRemainderRound = GeneralService.distanceBetweenPoint(xStartRounding1, yStartRounding1, xExtremeAnchor, yExtremeAnchor);
        double lengthSide = GeneralService.distanceBetweenPoint(xStope1, yStope1, xStartRounding1, yStartRounding1) - GeneralService.distanceBetweenPoint(xStope2, yStope2, xStartRounding2, yStartRounding2);

        int numberAnchorLine = (int) (Math.ceil(lengthRemainderRound + lengthSide) / distanceBetweenRows);

        if (numberAnchorLine >= 0) {
            double[][] anchorPlanLineXY = new double[numberAnchorLine + 1][4];

            double Beta = Math.atan2(yStope1 - yStartRounding1, xStope1 - xStartRounding1);

            double xStartAnchor = xStartRounding1 + (distanceBetweenRows - lengthRemainderRound) * Math.cos(Beta);
            double yStartAnchor = yStartRounding1 + (distanceBetweenRows - lengthRemainderRound) * Math.sin(Beta);

            // Условия ориентации анкеров для разных горных выработок
            double anchorLength = lengthAnchor;
            if (-Math.PI / 4 <= azimuthRadians && azimuthRadians <= Math.PI / 4 && xStartRounding1 > xStartRounding2 || Math.PI / 4 <= azimuthRadians && azimuthRadians <= Math.PI * 3 / 4 && yStartRounding1 > yStartRounding2 || Math.PI * 5 / 4 <= azimuthRadians && azimuthRadians <= Math.PI * 7 / 4 && yStartRounding1 < yStartRounding2) {
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

    public static double[][] testPlanStartXY(double intersectionAxisAndStopeX, double intersectionAxisAndStopeY, double distanceBetweenRows,
                                             double lengthLineTestAnchorsPlanIntersection) {

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

    public static double[][] calculateCoordinatesAnchorProjection(double increasedWidth, double increasedHeight, double formIndicationIntersection,
                                                                  double width, double height, double formIndication, double xPointContact,
                                                                  double yPointContact, double angleBetweenCenterRoofAndPointContactRadians,
                                                                  double xEndIntersectionRoof, double yEndIntersectionRoof,
                                                                  double distanceBetweenRows, double distanceLowerAnchor, double step,
                                                                  double lengthAnchor) {
        int i, j, k;

        double largeArcRadius = ServiceExcavation.largeArcRadius(increasedWidth, formIndicationIntersection);

        double arcLength = largeArcRadius * angleBetweenCenterRoofAndPointContactRadians; //Длина дуги

        double lineLength = GeneralService.distanceBetweenPoint(xPointContact, yPointContact, xEndIntersectionRoof, yEndIntersectionRoof); //Длина прямолинейного отрезка

        int numberAnchorProjection = (int) (Math.ceil((arcLength + lineLength) / distanceBetweenRows));

        //Проверка варианта расположения анкеров
        double totalArcLength = ServiceExcavation.lengthArc(width, formIndication);
        double archHeight = ServiceExcavation.archHeight(width, formIndication);
        int numberCrossSectionAnchors = (int) Math.ceil((totalArcLength + (height - archHeight - distanceLowerAnchor) * 2.0) / step);

        double xStartAnchor;
        double yStartAnchor;
        double beta;

        if ((numberCrossSectionAnchors + 1) % 2 == 0) {
            // Анкер по центру
            beta = 0.0;
            xStartAnchor = 0.0; //координата X установки первого анкера по дуге
            yStartAnchor = increasedHeight; //координата Y установки первого анкера по дуге
        } else {
            // Анкер со смещением
            beta = Math.asin(distanceBetweenRows / (2.0 * largeArcRadius));
            xStartAnchor = largeArcRadius * Math.sin(beta);
            yStartAnchor = increasedHeight - largeArcRadius + largeArcRadius * Math.cos(beta);
        }

        double[][] anchorProjectionXY = new double[numberAnchorProjection + 1][4];

        //определение координат установки анкеров по дуге большого радиуса
        if (xEndIntersectionRoof >= 0) {
            for (i = 0, j = 0; arcLength >= j * distanceBetweenRows; i++, j++) {
                anchorProjectionXY[i][0] = xStartAnchor + largeArcRadius * Math.sin(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][1] = -yStartAnchor * Math.cos(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][2] = xStartAnchor + (largeArcRadius + lengthAnchor) * Math.sin(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][3] = (-yStartAnchor - lengthAnchor) * Math.cos(j * distanceBetweenRows / largeArcRadius);
            }
        } else {
            for (i = 0, j = 0; arcLength >= j * distanceBetweenRows; i++, j++) {
                anchorProjectionXY[i][0] = -xStartAnchor - largeArcRadius * Math.sin(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][1] = -yStartAnchor * Math.cos(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][2] = -xStartAnchor - (largeArcRadius + lengthAnchor) * Math.sin(j * distanceBetweenRows / largeArcRadius);
                anchorProjectionXY[i][3] = (-yStartAnchor - lengthAnchor) * Math.cos(j * distanceBetweenRows / largeArcRadius);
            }
        }

        double remainderArc;
        if ((numberCrossSectionAnchors + 1) % 2 == 0) {
            // Анкер по центру
            remainderArc = arcLength - (i - 1) * distanceBetweenRows; //остаток дуги
        } else {
            // Анкер со смещением
            remainderArc = arcLength - distanceBetweenRows / 2.0 - (i - 1) * distanceBetweenRows; //остаток дуги
        }
        double omega = Math.atan(Math.abs((yEndIntersectionRoof - yPointContact) / (xEndIntersectionRoof - xPointContact))); //угол наклона прямолинейного отрезка кровли отностительно оси X

        //определение координат установки анкеров по прямолинейному участку кровли сопряжения
        double xStartAnchorToLine;
        double yStartAnchorToLine;

        if (xEndIntersectionRoof >= 0) {
            xStartAnchorToLine = xPointContact + (distanceBetweenRows - remainderArc) * Math.cos(omega); //координата X установки первого анкера по линии
            yStartAnchorToLine = yPointContact + (distanceBetweenRows - remainderArc) * Math.sin(omega); //координата Y установки первого анкера по линии
        } else {
            xStartAnchorToLine = xPointContact - (distanceBetweenRows - remainderArc) * Math.cos(omega); //координата X установки первого анкера по линии
            yStartAnchorToLine = yPointContact + (distanceBetweenRows - remainderArc) * Math.sin(omega); //координата Y установки первого анкера по линии
        }

        if (xEndIntersectionRoof >= 0) {
            for (k = 0; (remainderArc + lineLength) * Math.cos(omega) - distanceBetweenRows >= k * distanceBetweenRows; i++, k++) {
                anchorProjectionXY[i][0] = xStartAnchorToLine + k * distanceBetweenRows;
                anchorProjectionXY[i][1] = yStartAnchorToLine + k * distanceBetweenRows * Math.sin(omega);
                anchorProjectionXY[i][2] = xStartAnchorToLine + k * distanceBetweenRows + lengthAnchor * Math.cos(omega - Math.PI / 2.0);
                anchorProjectionXY[i][3] = yStartAnchorToLine + k * distanceBetweenRows * Math.sin(omega) + lengthAnchor * Math.sin(omega - Math.PI / 2.0);
            }
        } else {
            for (k = 0; (remainderArc + lineLength) * Math.cos(omega) - distanceBetweenRows >= k * distanceBetweenRows; i++, k++) {
                anchorProjectionXY[i][0] = xStartAnchorToLine - k * distanceBetweenRows;
                anchorProjectionXY[i][1] = yStartAnchorToLine + k * distanceBetweenRows * Math.sin(omega);
                anchorProjectionXY[i][2] = xStartAnchorToLine - k * distanceBetweenRows + lengthAnchor * Math.cos(omega + Math.PI / 2.0);
                anchorProjectionXY[i][3] = yStartAnchorToLine + k * distanceBetweenRows * Math.sin(omega) - lengthAnchor * Math.sin(omega + Math.PI / 2.0);
            }
        }
        return anchorProjectionXY;
    }

    public static double[][] calculateCoordinatesBasePlate(double[][] crossSectionAnchors,
                                                           double[][] projectionAnchors,
                                                           double plateSize,
                                                           double increasedWidth) {

        java.util.List<double[]> filteredProjections = new java.util.ArrayList<>();
        for (double[] anchor : projectionAnchors) {
            double x = anchor[0];
            if (x >= increasedWidth/2.0 || x <= -increasedWidth/2.0) {
                filteredProjections.add(anchor);
            }
        }

        double[][] filteredProjectionAnchors = filteredProjections.toArray(new double[0][4]);

        int numberCrossSectionAnchors = crossSectionAnchors.length;
        int numberProjectionAnchors = filteredProjectionAnchors.length;

        if (numberProjectionAnchors == 0) {
            return new double[0][2];
        }

        int numberBasePlateInRow;
        if (numberCrossSectionAnchors % 2 == 0) {
            numberBasePlateInRow = numberCrossSectionAnchors / 2;
        } else {
            numberBasePlateInRow = (int) Math.floor(numberCrossSectionAnchors / 2.0);
        }

        int numberBasePlateTotal = numberBasePlateInRow * numberProjectionAnchors;
        double[][] basePlateXY = new double[numberBasePlateTotal][2];

        int index = 0;
        for (int k = 0; k < numberProjectionAnchors; k++) {
            for (int j = 0; j < numberBasePlateInRow; j++, index++) {
                basePlateXY[index][0] = filteredProjectionAnchors[k][0] - plateSize / 2.0;
                basePlateXY[index][1] = crossSectionAnchors[j][1] - plateSize / 2.0;
            }
        }
        return basePlateXY;
    }
}