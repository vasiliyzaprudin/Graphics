package com.mining.graphics.model.excavation;

import com.mining.graphics.service.excavation.ServiceIntersection;

public class ModelCoordinatesIntersection {
    private ModelIntersection modelIntersection;

    public ModelCoordinatesIntersection(ModelIntersection modelIntersection) {
        this.modelIntersection = modelIntersection;
        calculateAllCoordinates();
    }

    private double xIntersectionWall12, yIntersectionWall12;
    private double xIntersectionWall23, yIntersectionWall23;
    private double xIntersectionWall34, yIntersectionWall34;
    private double xIntersectionWall41, yIntersectionWall41;
    private double xIntersectionWall31, yIntersectionWall31;

    private int xScaleIntersectionWall12, yScaleIntersectionWall12;
    private int xScaleIntersectionWall23, yScaleIntersectionWall23;
    private int xScaleIntersectionWall34, yScaleIntersectionWall34;
    private int xScaleIntersectionWall41, yScaleIntersectionWall41;
    private int xScaleIntersectionWall31, yScaleIntersectionWall31;

    private double xStopeLeft1, yStopeLeft1, xStopeRight1, yStopeRight1;
    private double xStopeLeft2, yStopeLeft2, xStopeRight2, yStopeRight2;
    private double xStopeLeft3, yStopeLeft3, xStopeRight3, yStopeRight3;
    private double xStopeLeft4, yStopeLeft4, xStopeRight4, yStopeRight4;

    private int xScaleStopeLeft1, yScaleStopeLeft1, xScaleStopeRight1, yScaleStopeRight1;
    private int xScaleStopeLeft2, yScaleStopeLeft2, xScaleStopeRight2, yScaleStopeRight2;
    private int xScaleStopeLeft3, yScaleStopeLeft3, xScaleStopeRight3, yScaleStopeRight3;
    private int xScaleStopeLeft4, yScaleStopeLeft4, xScaleStopeRight4, yScaleStopeRight4;

    private double roundingRadius12, roundingRadius23,roundingRadius31;

    private double xStartRounding12, yStartRounding12, xStartRounding21, yStartRounding21;
    private double xStartRounding23, yStartRounding23, xStartRounding32, yStartRounding32;
    private double xStartRounding34, yStartRounding34, xStartRounding43, yStartRounding43;
    private double xStartRounding41, yStartRounding41, xStartRounding14, yStartRounding14;
    private double xStartRounding31, yStartRounding31, xStartRounding13, yStartRounding13;

    private int xScaleStartRounding12, yScaleStartRounding12, xScaleStartRounding21, yScaleStartRounding21;
    private int xScaleStartRounding23, yScaleStartRounding23, xScaleStartRounding32, yScaleStartRounding32;
    private int xScaleStartRounding34, yScaleStartRounding34, xScaleStartRounding43, yScaleStartRounding43;
    private int xScaleStartRounding41, yScaleStartRounding41, xScaleStartRounding14, yScaleStartRounding14;
    private int xScaleStartRounding31, yScaleStartRounding31, xScaleStartRounding13, yScaleStartRounding13;

    private double xIntersectionAxisAndStope1, yIntersectionAxisAndStope1;
    private double xIntersectionAxisAndStope2, yIntersectionAxisAndStope2;
    private double xIntersectionAxisAndStope3, yIntersectionAxisAndStope3;
    private double xIntersectionAxisAndStope4, yIntersectionAxisAndStope4;

    private int xScaleIntersectionAxisAndStope1, yScaleIntersectionAxisAndStope1;
    private int xScaleIntersectionAxisAndStope2, yScaleIntersectionAxisAndStope2;
    private int xScaleIntersectionAxisAndStope3, yScaleIntersectionAxisAndStope3;
    private int xScaleIntersectionAxisAndStope4, yScaleIntersectionAxisAndStope4;


    private double xPointIntrsectionExcavation12, yPointIntrsectionExcavation12;
    private double xPointIntrsectionExcavation23, yPointIntrsectionExcavation23;
    private double xPointIntrsectionExcavation34, yPointIntrsectionExcavation34;
    private double xPointIntrsectionExcavation41, yPointIntrsectionExcavation41;
    private double xPointIntrsectionExcavation31, yPointIntrsectionExcavation31;

    private int xScalePointIntrsectionExcavation12, yScalePointIntrsectionExcavation12;
    private int xScalePointIntrsectionExcavation23, yScalePointIntrsectionExcavation23;
    private int xScalePointIntrsectionExcavation34, yScalePointIntrsectionExcavation34;
    private int xScalePointIntrsectionExcavation41, yScalePointIntrsectionExcavation41;
    private int xScalePointIntrsectionExcavation31, yScalePointIntrsectionExcavation31;


    private void calculateAllCoordinates() {

        double width1 = modelIntersection.getWidth1();
        double width2 = modelIntersection.getWidth2();
        double width3 = modelIntersection.getWidth3();
        double width4 = modelIntersection.getWidth4();

        double height1 = modelIntersection.getHeight1();
        double height2 = modelIntersection.getHeight2();
        double height3 = modelIntersection.getHeight3();
        double height4 = modelIntersection.getHeight4();

        double length1 = modelIntersection.getLength1();
        double length2 = modelIntersection.getLength2();
        double length3 = modelIntersection.getLength3();
        double length4 = modelIntersection.getLength4();

        double azimuthRadians1 = modelIntersection.getAzimuthRadians1();
        double azimuthRadians2 = modelIntersection.getAzimuthRadians2();
        double azimuthRadians3 = modelIntersection.getAzimuthRadians3();
        double azimuthRadians4 = modelIntersection.getAzimuthRadians4();

        //Расчет координат точек пересечения боков горных выработок
        this.xIntersectionWall12 = ServiceIntersection.calculateIntersectionWallX(width1, width2, azimuthRadians1, azimuthRadians2);
        this.yIntersectionWall12 = ServiceIntersection.calculateIntersectionWallY(width1, width2, azimuthRadians1, azimuthRadians2);
        this.xScaleIntersectionWall12 = ServiceIntersection.toScaleParameter(xIntersectionWall12);
        this.yScaleIntersectionWall12 = ServiceIntersection.toScaleParameter(yIntersectionWall12);

        this.xIntersectionWall23 = ServiceIntersection.calculateIntersectionWallX(width2, width3, azimuthRadians2, azimuthRadians3);
        this.yIntersectionWall23 = ServiceIntersection.calculateIntersectionWallY(width2, width3, azimuthRadians2, azimuthRadians3);
        this.xScaleIntersectionWall23 = ServiceIntersection.toScaleParameter(xIntersectionWall23);
        this.yScaleIntersectionWall23 = ServiceIntersection.toScaleParameter(yIntersectionWall23);

        this.xIntersectionWall34 = ServiceIntersection.calculateIntersectionWallX(width3, width4, azimuthRadians3, azimuthRadians4);
        this.yIntersectionWall34 = ServiceIntersection.calculateIntersectionWallY(width3, width4, azimuthRadians3, azimuthRadians4);
        this.xScaleIntersectionWall34 = ServiceIntersection.toScaleParameter(xIntersectionWall34);
        this.yScaleIntersectionWall34 = ServiceIntersection.toScaleParameter(yIntersectionWall34);

        this.xIntersectionWall41 = ServiceIntersection.calculateIntersectionWallX(width4, width1, azimuthRadians4, azimuthRadians1);
        this.yIntersectionWall41 = ServiceIntersection.calculateIntersectionWallY(width4, width1, azimuthRadians4, azimuthRadians1);
        this.xScaleIntersectionWall41 = ServiceIntersection.toScaleParameter(xIntersectionWall41);
        this.yScaleIntersectionWall41 = ServiceIntersection.toScaleParameter(yIntersectionWall41);

        this.xIntersectionWall31 = ServiceIntersection.calculateIntersectionWallX(width3, width1, azimuthRadians3, azimuthRadians1);
        this.yIntersectionWall31 = ServiceIntersection.calculateIntersectionWallY(width3, width1, azimuthRadians3, azimuthRadians1);
        this.xScaleIntersectionWall31 = ServiceIntersection.toScaleParameter(xIntersectionWall31);
        this.yScaleIntersectionWall31 = ServiceIntersection.toScaleParameter(yIntersectionWall31);

        //Расчет координат точек забоя горных выработок
        this.xStopeLeft1 = ServiceIntersection.calculateStopeX(length1, width1,azimuthRadians1);
        this.yStopeLeft1 = ServiceIntersection.calculateStopeY(length1, width1,azimuthRadians1);
        this.xScaleStopeLeft1 = ServiceIntersection.toScaleParameter(xStopeLeft1);
        this.yScaleStopeLeft1 = ServiceIntersection.toScaleParameter(yStopeLeft1);

        this.xStopeRight1 = ServiceIntersection.calculateStopeX(length1, -width1,azimuthRadians1);
        this.yStopeRight1 = ServiceIntersection.calculateStopeY(length1, -width1,azimuthRadians1);
        this.xScaleStopeRight1 = ServiceIntersection.toScaleParameter(xStopeRight1);
        this.yScaleStopeRight1 = ServiceIntersection.toScaleParameter(xStopeRight1);

        this.xStopeLeft2 = ServiceIntersection.calculateStopeX(length2, width2, azimuthRadians2);
        this.yStopeLeft2 = ServiceIntersection.calculateStopeY(length2, width2, azimuthRadians2);
        this.xScaleStopeLeft2 = ServiceIntersection.toScaleParameter(xStopeLeft2);
        this.yScaleStopeLeft2 = ServiceIntersection.toScaleParameter(yStopeLeft2);

        this.xStopeRight2 = ServiceIntersection.calculateStopeX(length2, -width2, azimuthRadians2);
        this.yStopeRight2 = ServiceIntersection.calculateStopeY(length2, -width2, azimuthRadians2);
        this.xScaleStopeRight2 = ServiceIntersection.toScaleParameter(xStopeRight2);
        this.yScaleStopeRight2 = ServiceIntersection.toScaleParameter(yStopeRight2);

        this.xStopeLeft3 = ServiceIntersection.calculateStopeX(length3, width3, azimuthRadians3);
        this.yStopeLeft3 = ServiceIntersection.calculateStopeY(length3, width3, azimuthRadians3);
        this.xScaleStopeLeft3 = ServiceIntersection.toScaleParameter(xStopeLeft3);
        this.yScaleStopeLeft3 = ServiceIntersection.toScaleParameter(yStopeLeft3);

        this.xStopeRight3 = ServiceIntersection.calculateStopeX(length3, -width3, azimuthRadians3);
        this.yStopeRight3 = ServiceIntersection.calculateStopeY(length3, -width3, azimuthRadians3);
        this.xScaleStopeRight3 = ServiceIntersection.toScaleParameter(xStopeRight3);
        this.yScaleStopeRight3 = ServiceIntersection.toScaleParameter(yStopeRight3);

        this.xStopeLeft4 = ServiceIntersection.calculateStopeX(length4, width4, azimuthRadians4);
        this.yStopeLeft4 = ServiceIntersection.calculateStopeY(length4, width4, azimuthRadians4);
        this.xScaleStopeLeft4 = ServiceIntersection.toScaleParameter(xStopeLeft4);
        this.yScaleStopeLeft4 = ServiceIntersection.toScaleParameter(yStopeLeft4);

        this.xStopeRight4 = ServiceIntersection.calculateStopeX(length4, -width4, azimuthRadians4);
        this.yStopeRight4 = ServiceIntersection.calculateStopeY(length4, -width4, azimuthRadians4);
        this.xScaleStopeRight4 = ServiceIntersection.toScaleParameter(xStopeRight4);
        this.yScaleStopeRight4 = ServiceIntersection.toScaleParameter(yStopeRight4);

        //Расчет величины закругления выработок
        this.roundingRadius12 = ServiceIntersection.calculateRoundingRadius(width1, width2, azimuthRadians1, azimuthRadians2);
        this.roundingRadius23 = ServiceIntersection.calculateRoundingRadius(width2, width3, azimuthRadians2, azimuthRadians3);
        this.roundingRadius31 = ServiceIntersection.calculateRoundingRadius(width3, width1, azimuthRadians3, azimuthRadians1);

        //Расчет координат точек пересечения выработок
        this.xPointIntrsectionExcavation12 = ServiceIntersection.calculatePointIntrsectionExcavationX(xIntersectionWall12, yIntersectionWall12,roundingRadius12);
        this.yPointIntrsectionExcavation12 = ServiceIntersection.calculatePointIntrsectionExcavationY(xIntersectionWall12, yIntersectionWall12,roundingRadius12);
        this.xScalePointIntrsectionExcavation12 = ServiceIntersection.toScaleParameter(xPointIntrsectionExcavation12);
        this.yScalePointIntrsectionExcavation12 = ServiceIntersection.toScaleParameter(yPointIntrsectionExcavation12);

        this.xPointIntrsectionExcavation23 = ServiceIntersection.calculatePointIntrsectionExcavationX(xIntersectionWall23, yIntersectionWall23,roundingRadius23);
        this.yPointIntrsectionExcavation23 = ServiceIntersection.calculatePointIntrsectionExcavationY(xIntersectionWall23, yIntersectionWall23,roundingRadius23);
        this.xScalePointIntrsectionExcavation23 = ServiceIntersection.toScaleParameter(xPointIntrsectionExcavation23);
        this.yScalePointIntrsectionExcavation23 = ServiceIntersection.toScaleParameter(yPointIntrsectionExcavation23);

        this.xPointIntrsectionExcavation31 = ServiceIntersection.calculatePointIntrsectionExcavationX(xIntersectionWall31, yIntersectionWall31,roundingRadius31);
        this.yPointIntrsectionExcavation31 = ServiceIntersection.calculatePointIntrsectionExcavationY(xIntersectionWall31, yIntersectionWall31,roundingRadius31);
        this.xScalePointIntrsectionExcavation31 = ServiceIntersection.toScaleParameter(xPointIntrsectionExcavation31);
        this.yScalePointIntrsectionExcavation31 = ServiceIntersection.toScaleParameter(yPointIntrsectionExcavation31);

        //Расчет координат точек начала закругления выработок
        this.xStartRounding12 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall12, width1,azimuthRadians1);
        this.yStartRounding12 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall12, width1,azimuthRadians1);
        this.xScaleStartRounding12 = ServiceIntersection.toScaleParameter(xStartRounding12);
        this.yScaleStartRounding12 = ServiceIntersection.toScaleParameter(yStartRounding12);

        this.xStartRounding13 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall31, width1,azimuthRadians1);
        this.yStartRounding13 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall31, width1,azimuthRadians1);
        this.xScaleStartRounding13 = ServiceIntersection.toScaleParameter(xStartRounding13);
        this.yScaleStartRounding13 = ServiceIntersection.toScaleParameter(yStartRounding13);

        this.xStartRounding21 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall12, width2,azimuthRadians2);
        this.yStartRounding21 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall12, width2,azimuthRadians2);
        this.xScaleStartRounding21 = ServiceIntersection.toScaleParameter(xStartRounding21);
        this.yScaleStartRounding21 = ServiceIntersection.toScaleParameter(yStartRounding21);

        this.xStartRounding23 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall23, width2,azimuthRadians2);
        this.yStartRounding23 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall23, width2,azimuthRadians2);
        this.xScaleStartRounding23 = ServiceIntersection.toScaleParameter(xStartRounding23);
        this.yScaleStartRounding23 = ServiceIntersection.toScaleParameter(yStartRounding23);

        this.xStartRounding32 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall23, width3,azimuthRadians3);
        this.yStartRounding32 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall23, width3,azimuthRadians3);
        this.xScaleStartRounding32 = ServiceIntersection.toScaleParameter(xStartRounding32);
        this.yScaleStartRounding32 = ServiceIntersection.toScaleParameter(yStartRounding32);

        this.xStartRounding31 = ServiceIntersection.calculateStartRoundingX(xIntersectionWall31, width3,azimuthRadians3);
        this.yStartRounding31 = ServiceIntersection.calculateStartRoundingY(yIntersectionWall31, width3,azimuthRadians3);
        this.xScaleStartRounding31 = ServiceIntersection.toScaleParameter(xStartRounding31);
        this.yScaleStartRounding31 = ServiceIntersection.toScaleParameter(yStartRounding31);

        //Расчет координат точек пересечения осей и забоя выработок
        this.xIntersectionAxisAndStope1 = ServiceIntersection.calculateIntersectionAxisAndStopeX(length1, azimuthRadians1);
        this.xScaleIntersectionAxisAndStope1 = ServiceIntersection.toScaleParameter(xIntersectionAxisAndStope1);
        this.yIntersectionAxisAndStope1 = ServiceIntersection.calculateIntersectionAxisAndStopeY(length1, azimuthRadians1);
        this.yScaleIntersectionAxisAndStope1 = ServiceIntersection.toScaleParameter(yIntersectionAxisAndStope1);

        this.xIntersectionAxisAndStope2 = ServiceIntersection.calculateIntersectionAxisAndStopeX(length2, azimuthRadians2);
        this.xScaleIntersectionAxisAndStope2 = ServiceIntersection.toScaleParameter(xIntersectionAxisAndStope2);
        this.yIntersectionAxisAndStope2 = ServiceIntersection.calculateIntersectionAxisAndStopeY(length2, azimuthRadians2);
        this.yScaleIntersectionAxisAndStope2 = ServiceIntersection.toScaleParameter(yIntersectionAxisAndStope2);

        this.xIntersectionAxisAndStope3 = ServiceIntersection.calculateIntersectionAxisAndStopeX(length3, azimuthRadians3);
        this.xScaleIntersectionAxisAndStope3 = ServiceIntersection.toScaleParameter(xIntersectionAxisAndStope3);
        this.yIntersectionAxisAndStope3 = ServiceIntersection.calculateIntersectionAxisAndStopeY(length3, azimuthRadians3);
        this.yScaleIntersectionAxisAndStope3 = ServiceIntersection.toScaleParameter(yIntersectionAxisAndStope3);
    }
}



