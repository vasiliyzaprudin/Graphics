package com.mining.graphics.service.excavation;

import com.mining.graphics.graphics.GraphicsParameters;
import com.mining.graphics.service.GeneralService;

import static com.mining.graphics.service.excavation.ServiceExcavation.largeArcRadius;

public class ServiceIntersection {

    public static double distanceBetweenPoint(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static int radiansToDegrees(double angle) {
        return (int) (Math.round(angle * 180 / Math.PI));
    }


    /**
     * Этот метод считает координату X точки пересечения боков горных выработок.
     */
    public static double calculateIntersectionWallX(double width1, double width2, double azimuthRadians1, double azimuthRadians2) {
        double beta = Math.atan((width1 * Math.sin(azimuthRadians2 - azimuthRadians1)) / (width2 + width1 * Math.cos(azimuthRadians2 - azimuthRadians1)));
        return width1 / (2.0 * Math.sin(beta)) * Math.cos(azimuthRadians1 + beta - Math.PI / 2.0);
    }

    /**
     * Этот метод считает координату Y точки пересечения боков горных выработок.
     */
    public static double calculateIntersectionWallY(double width1, double width2, double azimuthRadians1, double azimuthRadians2) {
        double beta = Math.atan((width1 * Math.sin(azimuthRadians2 - azimuthRadians1)) / (width2 + width1 * Math.cos(azimuthRadians2 - azimuthRadians1)));
        return width1 / (2.0 * Math.sin(beta)) * Math.sin(azimuthRadians1 + beta - Math.PI / 2.0);
    }

    /**
     * Этот метод считает координату X точки забоя горной выработки.
     */
    public static double calculateStopeX(double length, double width, double azimuthRadians) {
        return length * Math.sin(azimuthRadians) - width / 2.0 * Math.cos(azimuthRadians);
    }

    /**
     * Этот метод считает координату Y точки забоя горной выработки.
     */
    public static double calculateStopeY(double length, double width, double azimuthRadians) {
        return (-1.0) * length * Math.cos(azimuthRadians) - width / 2.0 * Math.sin(azimuthRadians);
    }

    /**
     * Этот метод определяет величину закругления сопряжения
     * в зависимости от ширины сопрягаемых выработок и угла их поворота.
     */
    //todo  проверить без Math.abs
    public static double calculateRoundingRadius(double width1, double width2, double azimuthRadians1, double azimuthRadians2) {
        if (Math.abs(azimuthRadians2 - azimuthRadians1) <= Math.PI / 2) {
            return ((width1 + width2) / 8) / Math.abs(Math.sin(azimuthRadians2 - azimuthRadians1));
        } else {
            return ((width1 + width2) / 8) * Math.sin(azimuthRadians2 - azimuthRadians1);
        }
    }

    /**
     * Этот метод считает координату X точки пересечения боков выработок.
     */
    public static double calculatePointIntrsectionExcavationX(double xIntersectionWall, double yIntersectionWall, double RoundingRadius) {
        return xIntersectionWall + RoundingRadius * Math.cos(Math.atan2(yIntersectionWall, xIntersectionWall));
    }

    /**
     * Этот метод считает координату Y точки пересечения боков выработок.
     */
    public static double calculatePointIntrsectionExcavationY(double xIntersectionWall, double yIntersectionWall, double RoundingRadius) {
        return yIntersectionWall + RoundingRadius * Math.sin(Math.atan2(yIntersectionWall, xIntersectionWall));
    }

    /**
     * Этот метод считает координату X точек начала закругления выработок.
     */
    public static double calculateStartRoundingX(double xIntersectionWall, double RoundingLength, double azimuthRadians) {
        return xIntersectionWall + RoundingLength * Math.sin(azimuthRadians);
    }

    /**
     * Этот метод считает координату Y точек начала закругления выработок.
     */
    public static double calculateStartRoundingY(double yIntersectionWall, double RoundingLength, double azimuthRadians) {
        return yIntersectionWall - RoundingLength * Math.cos(azimuthRadians);
    }

    /**
     * Этот метод считает координату X точек пересечения осей и забоя выработок.
     */
    public static double calculateIntersectionAxisAndStopeX(double length, double azimuthRadians) {
        return length * Math.sin(azimuthRadians);
    }

    /**
     * Этот метод считает координату Y точек пересечения осей и забоя выработок.
     */
    public static double calculateIntersectionAxisAndStopeY(double length, double azimuthRadians) {
        return -length * Math.cos(azimuthRadians);
    }

    // @formatter:off
    public static double calculateIncreasedWidth(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                 double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft) {
        return distanceBetweenPoint(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft);
    }

    public static double calculateFormIndicationHeightIntersection(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                                   double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft,
                                                                   double width1) {
        double increasedWidth = calculateIncreasedWidth(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft);
        return increasedWidth / (2.0 * width1) + 0.5;
    }


    public static double calculateIncreasedHeight(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                  double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft,
                                                  double width1, double height1) {
        return height1 * calculateFormIndicationHeightIntersection(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft, width1);
    }

    /**
     * Этот метод считает координату X точки перехода
     * прямого отрезка кровли горной выработки к дуге окружности большого радиуса.
     */
    public static double calculateCoordinatePointContactX(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                          double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft,
                                                          double xStartRounding2, double height1, double width1, double formIndicationIntersection, double height2) {

        double increasedWidth = calculateIncreasedWidth(xPointIntersectionExcavationRight,yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft);
        double formIndicationHeightIntersection1 = calculateFormIndicationHeightIntersection(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft, width1);
        double increasedHeight1 = height1 * formIndicationHeightIntersection1;

        double largeArcRadius = largeArcRadius(increasedWidth, formIndicationIntersection);

        double coordinateCenterLargeCircleX = 0.0;
        double coordinateCenterLargeCircleY = -increasedHeight1 + largeArcRadius;

        double coordinateStartRoofExcavation2X = xStartRounding2;
        double coordinateStartRoofExcavation2Y = -height2;

        double hi = Math.acos(largeArcRadius / distanceBetweenPoint(coordinateCenterLargeCircleX, coordinateCenterLargeCircleY, coordinateStartRoofExcavation2X, coordinateStartRoofExcavation2Y));
        double psi = Math.atan(Math.abs((coordinateStartRoofExcavation2Y - coordinateCenterLargeCircleY) / (coordinateStartRoofExcavation2X - coordinateCenterLargeCircleX)));

        double coordinatePointContactX = largeArcRadius * Math.abs(Math.cos(hi + psi));

        if (coordinateStartRoofExcavation2X > 0) {
            return coordinatePointContactX;
        } else {
            return -coordinatePointContactX;
        }
    }

    public static double calculateCoordinatePointContactY(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                          double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft,
                                                          double xStartRounding2, double height1, double width1, double formIndicationIntersection, double height2) {

        double increasedWidth = calculateIncreasedWidth(xPointIntersectionExcavationRight,yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft);
        double formIndicationHeightIntersection1 = calculateFormIndicationHeightIntersection(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft, width1);
        double increasedHeight1 = height1 * formIndicationHeightIntersection1;

        double largeArcRadius = largeArcRadius(increasedWidth, formIndicationIntersection);

        double coordinateCenterLargeCircleX = 0.0;
        double coordinateCenterLargeCircleY = -increasedHeight1 + largeArcRadius;

        double coordinateStartRoofExcavation2X = xStartRounding2;
        double coordinateStartRoofExcavation2Y = -height2;

        double hi = Math.acos(largeArcRadius / distanceBetweenPoint(coordinateCenterLargeCircleX, coordinateCenterLargeCircleY, coordinateStartRoofExcavation2X, coordinateStartRoofExcavation2Y));
        double psi = Math.atan(Math.abs((coordinateStartRoofExcavation2Y - coordinateCenterLargeCircleY) / (coordinateStartRoofExcavation2X - coordinateCenterLargeCircleX)));

        double dy = largeArcRadius * Math.abs(Math.sin(hi + psi));

        double coordinatePointContactY = (-increasedHeight1 + largeArcRadius - dy);

        return coordinatePointContactY;
    }

    /**
     * Этот метод считает опорный угол дуги,
     * соединяющей центр кровли горной выработки и точку касания
     * (точку перехода от дуги к прямолинейному отрезку кровли сопрягаемой горной выработки).
     */
    public static double calculateAngleBetweenCenterRoofAndPointContactRadians(double xPointIntersectionExcavationRight, double yPointIntersectionExcavationRight,
                                                                               double xPointIntersectionExcavationLeft, double yPointIntersectionExcavationLeft,
                                                                               double xStartRounding2, double height1, double width1, double formIndicationIntersection, double height2) {
        double increasedWidth = calculateIncreasedWidth(xPointIntersectionExcavationRight,yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft);
        double formIndicationHeightIntersection1 = calculateFormIndicationHeightIntersection(xPointIntersectionExcavationRight, yPointIntersectionExcavationRight, xPointIntersectionExcavationLeft, yPointIntersectionExcavationLeft, width1);
        double increasedHeight1 = height1 * formIndicationHeightIntersection1;

        double largeArcRadius = largeArcRadius(increasedWidth, formIndicationIntersection);

        double coordinateCenterLargeCircleX = 0.0;
        double coordinateCenterLargeCircleY = -increasedHeight1 + largeArcRadius;

        double coordinateStartRoofExcavation2X = xStartRounding2;
        double coordinateStartRoofExcavation2Y = -height2;

        double hi = Math.acos(largeArcRadius / distanceBetweenPoint(coordinateCenterLargeCircleX, coordinateCenterLargeCircleY, coordinateStartRoofExcavation2X, coordinateStartRoofExcavation2Y));
        double psi = Math.atan(Math.abs((coordinateStartRoofExcavation2Y - coordinateCenterLargeCircleY) / (coordinateStartRoofExcavation2X - coordinateCenterLargeCircleX)));
        return (Math.PI / 2 - Math.abs(hi) - Math.abs(psi));
    }

    //@formatter:on
}










