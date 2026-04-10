package com.mining.graphics.model.excavation;

import static com.mining.graphics.service.excavation.ServiceIntersection.*;

public class CoordinatesIntersection {
    private ModelIntersection modelIntersection;

    public CoordinatesIntersection(ModelIntersection modelIntersection) {
        this.modelIntersection = modelIntersection;
        calculateAllCoordinates();
    }

    public void updateCoordinates() {
        calculateAllCoordinates();
    }

    private void calculateAllCoordinates() {
        calculateAllScaleParameters();
        calculateAllCoordinatesPlanIntersection();
        calculateAllCoordinatesProfileIntersection();
    }
    private int scaleWidth1, scaleWidth2, scaleWidth3;
    private int scaleHeight1, scaleHeight2, scaleHeight3;
    private int scaleLength1, scaleLength2, scaleLength3;

    private double xIntersectionWall12, yIntersectionWall12;
    private double xIntersectionWall23, yIntersectionWall23;
    private double xIntersectionWall31, yIntersectionWall31;

    private int xScaleIntersectionWall12, yScaleIntersectionWall12;
    private int xScaleIntersectionWall23, yScaleIntersectionWall23;
    private int xScaleIntersectionWall31, yScaleIntersectionWall31;

    private double xStopeLeft1, yStopeLeft1, xStopeRight1, yStopeRight1;
    private double xStopeLeft2, yStopeLeft2, xStopeRight2, yStopeRight2;
    private double xStopeLeft3, yStopeLeft3, xStopeRight3, yStopeRight3;


    private int xScaleStopeLeft1, yScaleStopeLeft1, xScaleStopeRight1, yScaleStopeRight1;
    private int xScaleStopeLeft2, yScaleStopeLeft2, xScaleStopeRight2, yScaleStopeRight2;
    private int xScaleStopeLeft3, yScaleStopeLeft3, xScaleStopeRight3, yScaleStopeRight3;


    private double roundingRadius12, roundingRadius23, roundingRadius31;

    private double xStartRounding12, yStartRounding12, xStartRounding21, yStartRounding21;
    private double xStartRounding23, yStartRounding23, xStartRounding32, yStartRounding32;
    private double xStartRounding31, yStartRounding31, xStartRounding13, yStartRounding13;

    private int xScaleStartRounding12, yScaleStartRounding12, xScaleStartRounding21, yScaleStartRounding21;
    private int xScaleStartRounding23, yScaleStartRounding23, xScaleStartRounding32, yScaleStartRounding32;
    private int xScaleStartRounding31, yScaleStartRounding31, xScaleStartRounding13, yScaleStartRounding13;

    private double xIntersectionAxisAndStope1, yIntersectionAxisAndStope1;
    private double xIntersectionAxisAndStope2, yIntersectionAxisAndStope2;
    private double xIntersectionAxisAndStope3, yIntersectionAxisAndStope3;

    private int xScaleIntersectionAxisAndStope1, yScaleIntersectionAxisAndStope1;
    private int xScaleIntersectionAxisAndStope2, yScaleIntersectionAxisAndStope2;
    private int xScaleIntersectionAxisAndStope3, yScaleIntersectionAxisAndStope3;

    private double xPointIntrsectionExcavation12, yPointIntrsectionExcavation12;
    private double xPointIntrsectionExcavation23, yPointIntrsectionExcavation23;
    private double xPointIntrsectionExcavation31, yPointIntrsectionExcavation31;

    private int xScalePointIntrsectionExcavation12, yScalePointIntrsectionExcavation12;
    private int xScalePointIntrsectionExcavation23, yScalePointIntrsectionExcavation23;
    private int xScalePointIntrsectionExcavation31, yScalePointIntrsectionExcavation31;

    private double xCalculateCoordinatePointContact21, xCalculateCoordinatePointContact31;
    private double yCalculateCoordinatePointContact21, yCalculateCoordinatePointContact31;

    private int xScaleCalculateCoordinatePointContact21, xScaleCalculateCoordinatePointContact31;
    private int yScaleCalculateCoordinatePointContact21, yScaleCalculateCoordinatePointContact31;

    private double angleBetweenCenterRoofAndPointContactRadians21, angleBetweenCenterRoofAndPointContactRadians31;
    private int angleBetweenCenterRoofAndPointContactDegrees21, angleBetweenCenterRoofAndPointContactDegrees31;

    private double increasedWidth1, increasedHeight1, formIndicationHeightIntersection1;

    // @formatter:off
    private void calculateAllScaleParameters (){
        double width1 = modelIntersection.getWidth1();
        double width2 = modelIntersection.getWidth2();
        double width3 = modelIntersection.getWidth3();

        double height1 = modelIntersection.getHeight1();
        double height2 = modelIntersection.getHeight2();
        double height3 = modelIntersection.getHeight3();

        double length1 = modelIntersection.getLength1();
        double length2 = modelIntersection.getLength2();
        double length3 = modelIntersection.getLength3();

        this.scaleWidth1 = toScaleParameter(width1);
        this.scaleWidth2 = toScaleParameter(width2);
        this.scaleWidth3 = toScaleParameter(width3);

        this.scaleHeight1 = toScaleParameter(height1);
        this.scaleHeight2 = toScaleParameter(height2);
        this.scaleHeight3= toScaleParameter(height3);

        this.scaleLength1 = toScaleParameter(length1);
        this.scaleLength2 = toScaleParameter(length2);
        this.scaleLength3 = toScaleParameter(length3);
    }

    private void calculateAllCoordinatesPlanIntersection() {
        double width1 = modelIntersection.getWidth1();
        double width2 = modelIntersection.getWidth2();
        double width3 = modelIntersection.getWidth3();

        double height1 = modelIntersection.getHeight1();
        double height2 = modelIntersection.getHeight2();
        double height3 = modelIntersection.getHeight3();

        double length1 = modelIntersection.getLength1();
        double length2 = modelIntersection.getLength2();
        double length3 = modelIntersection.getLength3();

        double azimuthRadians1 = modelIntersection.getAzimuthRadians1();
        double azimuthRadians2 = modelIntersection.getAzimuthRadians2();
        double azimuthRadians3 = modelIntersection.getAzimuthRadians3();

        //Расчет координат точек пересечения боков горных выработок
        this.xIntersectionWall12 = calculateIntersectionWallX(width1, width2, azimuthRadians1, azimuthRadians2);
        this.yIntersectionWall12 = calculateIntersectionWallY(width1, width2, azimuthRadians1, azimuthRadians2);
        this.xScaleIntersectionWall12 = toScaleParameter(xIntersectionWall12);
        this.yScaleIntersectionWall12 = toScaleParameter(yIntersectionWall12);

        this.xIntersectionWall23 = calculateIntersectionWallX(width2, width3, azimuthRadians2, azimuthRadians3);
        this.yIntersectionWall23 = calculateIntersectionWallY(width2, width3, azimuthRadians2, azimuthRadians3);
        this.xScaleIntersectionWall23 = toScaleParameter(xIntersectionWall23);
        this.yScaleIntersectionWall23 = toScaleParameter(yIntersectionWall23);


        this.xIntersectionWall31 = calculateIntersectionWallX(width3, width1, azimuthRadians3, azimuthRadians1);
        this.yIntersectionWall31 = calculateIntersectionWallY(width3, width1, azimuthRadians3, azimuthRadians1);
        this.xScaleIntersectionWall31 = toScaleParameter(xIntersectionWall31);
        this.yScaleIntersectionWall31 = toScaleParameter(yIntersectionWall31);

        //Расчет координат точек забоя горных выработок
        this.xStopeLeft1 = calculateStopeX(length1, width1, azimuthRadians1);
        this.yStopeLeft1 = calculateStopeY(length1, width1, azimuthRadians1);
        this.xScaleStopeLeft1 = toScaleParameter(xStopeLeft1);
        this.yScaleStopeLeft1 = toScaleParameter(yStopeLeft1);

        this.xStopeRight1 = calculateStopeX(length1, -width1, azimuthRadians1);
        this.yStopeRight1 = calculateStopeY(length1, -width1, azimuthRadians1);
        this.xScaleStopeRight1 = toScaleParameter(xStopeRight1);
        this.yScaleStopeRight1 = toScaleParameter(yStopeRight1);

        this.xStopeLeft2 = calculateStopeX(length2, width2, azimuthRadians2);
        this.yStopeLeft2 = calculateStopeY(length2, width2, azimuthRadians2);
        this.xScaleStopeLeft2 = toScaleParameter(xStopeLeft2);
        this.yScaleStopeLeft2 = toScaleParameter(yStopeLeft2);

        this.xStopeRight2 = calculateStopeX(length2, -width2, azimuthRadians2);
        this.yStopeRight2 = calculateStopeY(length2, -width2, azimuthRadians2);
        this.xScaleStopeRight2 = toScaleParameter(xStopeRight2);
        this.yScaleStopeRight2 = toScaleParameter(yStopeRight2);

        this.xStopeLeft3 = calculateStopeX(length3, width3, azimuthRadians3);
        this.yStopeLeft3 = calculateStopeY(length3, width3, azimuthRadians3);
        this.xScaleStopeLeft3 = toScaleParameter(xStopeLeft3);
        this.yScaleStopeLeft3 = toScaleParameter(yStopeLeft3);

        this.xStopeRight3 = calculateStopeX(length3, -width3, azimuthRadians3);
        this.yStopeRight3 = calculateStopeY(length3, -width3, azimuthRadians3);
        this.xScaleStopeRight3 = toScaleParameter(xStopeRight3);
        this.yScaleStopeRight3 = toScaleParameter(yStopeRight3);

        //Расчет величины закругления выработок
        this.roundingRadius12 = calculateRoundingRadius(width1, width2, azimuthRadians1, azimuthRadians2);
        this.roundingRadius23 = calculateRoundingRadius(width2, width3, azimuthRadians2, azimuthRadians3);
        this.roundingRadius31 = calculateRoundingRadius(width3, width1, azimuthRadians3, azimuthRadians1);

        //Расчет координат точек пересечения выработок
        this.xPointIntrsectionExcavation12 = calculatePointIntrsectionExcavationX(xIntersectionWall12, yIntersectionWall12, roundingRadius12);
        this.yPointIntrsectionExcavation12 = calculatePointIntrsectionExcavationY(xIntersectionWall12, yIntersectionWall12, roundingRadius12);
        this.xScalePointIntrsectionExcavation12 = toScaleParameter(xPointIntrsectionExcavation12);
        this.yScalePointIntrsectionExcavation12 = toScaleParameter(yPointIntrsectionExcavation12);

        this.xPointIntrsectionExcavation23 = calculatePointIntrsectionExcavationX(xIntersectionWall23, yIntersectionWall23, roundingRadius23);
        this.yPointIntrsectionExcavation23 = calculatePointIntrsectionExcavationY(xIntersectionWall23, yIntersectionWall23, roundingRadius23);
        this.xScalePointIntrsectionExcavation23 = toScaleParameter(xPointIntrsectionExcavation23);
        this.yScalePointIntrsectionExcavation23 = toScaleParameter(yPointIntrsectionExcavation23);

        this.xPointIntrsectionExcavation31 = calculatePointIntrsectionExcavationX(xIntersectionWall31, yIntersectionWall31, roundingRadius31);
        this.yPointIntrsectionExcavation31 = calculatePointIntrsectionExcavationY(xIntersectionWall31, yIntersectionWall31, roundingRadius31);
        this.xScalePointIntrsectionExcavation31 = toScaleParameter(xPointIntrsectionExcavation31);
        this.yScalePointIntrsectionExcavation31 = toScaleParameter(yPointIntrsectionExcavation31);

        //Расчет координат точек начала закругления выработок
        this.xStartRounding12 = calculateStartRoundingX(xIntersectionWall12, width1, azimuthRadians1);
        this.yStartRounding12 = calculateStartRoundingY(yIntersectionWall12, width1, azimuthRadians1);
        this.xScaleStartRounding12 = toScaleParameter(xStartRounding12);
        this.yScaleStartRounding12 = toScaleParameter(yStartRounding12);

        this.xStartRounding13 = calculateStartRoundingX(xIntersectionWall31, width1, azimuthRadians1);
        this.yStartRounding13 = calculateStartRoundingY(yIntersectionWall31, width1, azimuthRadians1);
        this.xScaleStartRounding13 = toScaleParameter(xStartRounding13);
        this.yScaleStartRounding13 = toScaleParameter(yStartRounding13);

        this.xStartRounding21 = calculateStartRoundingX(xIntersectionWall12, width2, azimuthRadians2);
        this.yStartRounding21 = calculateStartRoundingY(yIntersectionWall12, width2, azimuthRadians2);
        this.xScaleStartRounding21 = toScaleParameter(xStartRounding21);
        this.yScaleStartRounding21 = toScaleParameter(yStartRounding21);

        this.xStartRounding23 = calculateStartRoundingX(xIntersectionWall23, width2, azimuthRadians2);
        this.yStartRounding23 = calculateStartRoundingY(yIntersectionWall23, width2, azimuthRadians2);
        this.xScaleStartRounding23 = toScaleParameter(xStartRounding23);
        this.yScaleStartRounding23 = toScaleParameter(yStartRounding23);

        this.xStartRounding32 = calculateStartRoundingX(xIntersectionWall23, width3, azimuthRadians3);
        this.yStartRounding32 = calculateStartRoundingY(yIntersectionWall23, width3, azimuthRadians3);
        this.xScaleStartRounding32 = toScaleParameter(xStartRounding32);
        this.yScaleStartRounding32 = toScaleParameter(yStartRounding32);

        this.xStartRounding31 = calculateStartRoundingX(xIntersectionWall31, width3, azimuthRadians3);
        this.yStartRounding31 = calculateStartRoundingY(yIntersectionWall31, width3, azimuthRadians3);
        this.xScaleStartRounding31 = toScaleParameter(xStartRounding31);
        this.yScaleStartRounding31 = toScaleParameter(yStartRounding31);

        //Расчет координат точек пересечения осей и забоя выработок
        this.xIntersectionAxisAndStope1 = calculateIntersectionAxisAndStopeX(length1, azimuthRadians1);
        this.xScaleIntersectionAxisAndStope1 = toScaleParameter(xIntersectionAxisAndStope1);
        this.yIntersectionAxisAndStope1 = calculateIntersectionAxisAndStopeY(length1, azimuthRadians1);
        this.yScaleIntersectionAxisAndStope1 = toScaleParameter(yIntersectionAxisAndStope1);

        this.xIntersectionAxisAndStope2 = calculateIntersectionAxisAndStopeX(length2, azimuthRadians2);
        this.xScaleIntersectionAxisAndStope2 = toScaleParameter(xIntersectionAxisAndStope2);
        this.yIntersectionAxisAndStope2 = calculateIntersectionAxisAndStopeY(length2, azimuthRadians2);
        this.yScaleIntersectionAxisAndStope2 = toScaleParameter(yIntersectionAxisAndStope2);

        this.xIntersectionAxisAndStope3 = calculateIntersectionAxisAndStopeX(length3, azimuthRadians3);
        this.xScaleIntersectionAxisAndStope3 = toScaleParameter(xIntersectionAxisAndStope3);
        this.yIntersectionAxisAndStope3 = calculateIntersectionAxisAndStopeY(length3, azimuthRadians3);
        this.yScaleIntersectionAxisAndStope3 = toScaleParameter(yIntersectionAxisAndStope3);
    }
    private void calculateAllCoordinatesProfileIntersection() {
        double width1 = modelIntersection.getWidth1();
        double width2 = modelIntersection.getWidth2();
        double width3 = modelIntersection.getWidth3();

        double height1 = modelIntersection.getHeight1();
        double height2 = modelIntersection.getHeight2();
        double height3 = modelIntersection.getHeight3();

        double length1 = modelIntersection.getLength1();
        double length2 = modelIntersection.getLength2();
        double length3 = modelIntersection.getLength3();

        double azimuthRadians1 = modelIntersection.getAzimuthRadians1();
        double azimuthRadians2 = modelIntersection.getAzimuthRadians2();
        double azimuthRadians3 = modelIntersection.getAzimuthRadians3();

        double formIndicationIntersection = modelIntersection.getFormIndicationIntersection();

        this.increasedWidth1 = calculateIncreasedWidth(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31);
        this.formIndicationHeightIntersection1 = calculateFormIndicationHeightIntersection(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, width1);
        this.increasedHeight1 = calculateIncreasedHeight(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, width1, height1);

        this.xCalculateCoordinatePointContact21 = calculateCoordinatePointContactX(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, xStartRounding21, height1, width1, formIndicationIntersection, height2);
        this.yCalculateCoordinatePointContact21 = calculateCoordinatePointContactY(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, xStartRounding21, height1, width1, formIndicationIntersection, height2);

        this.xScaleCalculateCoordinatePointContact21 = toScaleParameter(xCalculateCoordinatePointContact21);
        this.yScaleCalculateCoordinatePointContact21 = toScaleParameter(yCalculateCoordinatePointContact21);

        this.angleBetweenCenterRoofAndPointContactRadians21 = calculateAngleBetweenCenterRoofAndPointContactRadians(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, xStartRounding21, height1, width1, formIndicationIntersection, height2);
        this.angleBetweenCenterRoofAndPointContactDegrees21 = radiansToDegrees(angleBetweenCenterRoofAndPointContactRadians21);

        this.xCalculateCoordinatePointContact31 = calculateCoordinatePointContactX(xPointIntrsectionExcavation31, yPointIntrsectionExcavation31,
                xPointIntrsectionExcavation12, yPointIntrsectionExcavation12, xStartRounding31, height1, width1, formIndicationIntersection, height3);
        this.yCalculateCoordinatePointContact31 = calculateCoordinatePointContactY(xPointIntrsectionExcavation31, yPointIntrsectionExcavation31,
                xPointIntrsectionExcavation12, yPointIntrsectionExcavation12, xStartRounding31, height1, width1, formIndicationIntersection, height3);

        this.xScaleCalculateCoordinatePointContact31 = toScaleParameter(xCalculateCoordinatePointContact31);
        this.yScaleCalculateCoordinatePointContact31 = toScaleParameter(yCalculateCoordinatePointContact31);

        this.angleBetweenCenterRoofAndPointContactRadians31 = calculateAngleBetweenCenterRoofAndPointContactRadians(xPointIntrsectionExcavation31, yPointIntrsectionExcavation31,
                xPointIntrsectionExcavation12, yPointIntrsectionExcavation12, xStartRounding31, height1, width1, formIndicationIntersection, height3);
        this.angleBetweenCenterRoofAndPointContactDegrees31 = radiansToDegrees(angleBetweenCenterRoofAndPointContactRadians31);

        this.increasedWidth1 = calculateIncreasedWidth(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31);
        this.formIndicationHeightIntersection1 = calculateFormIndicationHeightIntersection(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, width1);
        this.increasedHeight1 = calculateIncreasedHeight(xPointIntrsectionExcavation12, yPointIntrsectionExcavation12,
                xPointIntrsectionExcavation31, yPointIntrsectionExcavation31, width1, height1);
    }

    public int getScaleWidth1 () {return scaleWidth1;}
    public int getScaleWidth2 () {return scaleWidth2;}
    public int getScaleWidth3 () {return scaleWidth3;}

    public int getScaleHeight1 () {return  scaleHeight1;}
    public int getScaleHeight2 () {return  scaleHeight2;}
    public int getScaleHeight3 () {return  scaleHeight3;}

    public int getScaleLength1 () {return  scaleLength1;}
    public int getScaleLength2 () {return  scaleLength2;}
    public int getScaleLength3 () {return  scaleLength3;}

    public double getXIntersectionWall12() {return xIntersectionWall12;}
    public double getYIntersectionWall12() {return yIntersectionWall12;}
    public int getXScaleIntersectionWall12() {return xScaleIntersectionWall12;}
    public int getYScaleIntersectionWall12() {return yScaleIntersectionWall12;}

    public double getXIntersectionWall23() {return xIntersectionWall23;}
    public double getYIntersectionWall23() {return yIntersectionWall23;}
    public int getXScaleIntersectionWall23() {return xScaleIntersectionWall23;}
    public int getYScaleIntersectionWall23() {return yScaleIntersectionWall23;}

    public double getXIntersectionWall31() {return xIntersectionWall31;}
    public double getYIntersectionWall31() {return yIntersectionWall31;}
    public int getXScaleIntersectionWall31() {return xScaleIntersectionWall31;}
    public int getYScaleIntersectionWall31() {return yScaleIntersectionWall31;}

    public double getXStopeLeft1() {return xStopeLeft1;}
    public double getYStopeLeft1() {return yStopeLeft1;}
    public double getXStopeRight1() {return xStopeRight1;}
    public double getYStopeRight1() {return yStopeRight1;}
    public int getXScaleStopeLeft1() {return xScaleStopeLeft1;}
    public int getYScaleStopeLeft1() {return yScaleStopeLeft1;}
    public int getXScaleStopeRight1() {return xScaleStopeRight1;}
    public int getYScaleStopeRight1() {return yScaleStopeRight1;}

    public double getXStopeLeft2() {return xStopeLeft2;}
    public double getYStopeLeft2() {return yStopeLeft2;}
    public double getXStopeRight2() {return xStopeRight2;}
    public double getYStopeRight2() {return yStopeRight2;}
    public int getXScaleStopeLeft2() {return xScaleStopeLeft2;}
    public int getYScaleStopeLeft2() {return yScaleStopeLeft2;}
    public int getXScaleStopeRight2() {return xScaleStopeRight2;}
    public int getYScaleStopeRight2() {return yScaleStopeRight2;}

    public double getXStopeLeft3() {return xStopeLeft3;}
    public double getYStopeLeft3() {return yStopeLeft3;}
    public double getXStopeRight3() {return xStopeRight3;}
    public double getYStopeRight3() {return yStopeRight3;}
    public int getXScaleStopeLeft3() {return xScaleStopeLeft3;}
    public int getYScaleStopeLeft3() {return yScaleStopeLeft3;}
    public int getXScaleStopeRight3() {return xScaleStopeRight3;}
    public int getYScaleStopeRight3() {return yScaleStopeRight3;}

    public double getRoundingRadius12() {return roundingRadius12;}
    public double getRoundingRadius23() {return roundingRadius23;}
    public double getRoundingRadius31() {return roundingRadius31;}

    public double getXStartRounding12() {return xStartRounding12;}
    public double getYStartRounding12() {return yStartRounding12;}
    public int getXScaleStartRounding12() {return xScaleStartRounding12;}
    public int getYScaleStartRounding12() {return yScaleStartRounding12;}

    public double getXStartRounding21() {return xStartRounding21;}
    public double getYStartRounding21() {return yStartRounding21;}
    public int getXScaleStartRounding21() {return xScaleStartRounding21;}
    public int getYScaleStartRounding21() {return yScaleStartRounding21;}

    public double getXStartRounding23() {return xStartRounding23;}
    public double getYStartRounding23() {return yStartRounding23;}
    public int getXScaleStartRounding23() {return xScaleStartRounding23;}
    public int getYScaleStartRounding23() {return yScaleStartRounding23;}

    public double getXStartRounding32() {return xStartRounding32;}
    public double getYStartRounding32() {return yStartRounding32;}
    public int getXScaleStartRounding32() {return xScaleStartRounding32;}
    public int getYScaleStartRounding32() {return yScaleStartRounding32;}

    public double getXStartRounding31() {return xStartRounding31;}
    public double getYStartRounding31() {return yStartRounding31;}
    public int getXScaleStartRounding31() {return xScaleStartRounding31;}
    public int getYScaleStartRounding31() {return yScaleStartRounding31;}

    public double getXStartRounding13() {return xStartRounding13;}
    public double getYStartRounding13() {return yStartRounding13;}
    public int getXScaleStartRounding13() {return xScaleStartRounding13;}
    public int getYScaleStartRounding13() {return yScaleStartRounding13;}

    public double getXPointIntrsectionExcavation12() {return xPointIntrsectionExcavation12;}
    public double getYPointIntrsectionExcavation12() {return yPointIntrsectionExcavation12;}
    public int getXScalePointIntrsectionExcavation12() {return xScalePointIntrsectionExcavation12;}
    public int getYScalePointIntrsectionExcavation12() {return yScalePointIntrsectionExcavation12;}

    public double getXPointIntrsectionExcavation23() {return xPointIntrsectionExcavation23;}
    public double getYPointIntrsectionExcavation23() {return yPointIntrsectionExcavation23;}
    public int getXScalePointIntrsectionExcavation23() {return xScalePointIntrsectionExcavation23;}
    public int getYScalePointIntrsectionExcavation23() {return yScalePointIntrsectionExcavation23;}

    public double getXPointIntrsectionExcavation31() {return xPointIntrsectionExcavation31;}
    public double getYPointIntrsectionExcavation31() {return yPointIntrsectionExcavation31;}
    public int getXScalePointIntrsectionExcavation31() {return xScalePointIntrsectionExcavation31;}
    public int getYScalePointIntrsectionExcavation31() {return yScalePointIntrsectionExcavation31;}

    public double getXIntersectionAxisAndStope1() {return xIntersectionAxisAndStope1;}
    public double getYIntersectionAxisAndStope1() {return yIntersectionAxisAndStope1;}
    public int getXScaleIntersectionAxisAndStope1() {return xScaleIntersectionAxisAndStope1;}
    public int getYScaleIntersectionAxisAndStope1() {return yScaleIntersectionAxisAndStope1;}

    public double getXIntersectionAxisAndStope2() {return xIntersectionAxisAndStope2;}
    public double getYIntersectionAxisAndStope2() {return yIntersectionAxisAndStope2;}
    public int getXScaleIntersectionAxisAndStope2() {return xScaleIntersectionAxisAndStope2;}
    public int getYScaleIntersectionAxisAndStope2() {return yScaleIntersectionAxisAndStope2;}

    public double getXIntersectionAxisAndStope3() {return xIntersectionAxisAndStope3;}
    public double getYIntersectionAxisAndStope3() {return yIntersectionAxisAndStope3;}
    public int getXScaleIntersectionAxisAndStope3() {return xScaleIntersectionAxisAndStope3;}
    public int getYScaleIntersectionAxisAndStope3() {return yScaleIntersectionAxisAndStope3;}

    public double getIncreasedWidth1 () {return increasedWidth1;}
    public double getIncreasedHeight1 () {return increasedHeight1;}
    public double getFormIndicationHeightIntersection1 () {return formIndicationHeightIntersection1;}

    public double getXCalculateCoordinatePointContact21 () {return xCalculateCoordinatePointContact21;}
    public double getYCalculateCoordinatePointContact21 () {return yCalculateCoordinatePointContact21;}
    public int getXScaleCalculateCoordinatePointContact21 () {return xScaleCalculateCoordinatePointContact21;}
    public int getYScaleCalculateCoordinatePointContact21 () {return yScaleCalculateCoordinatePointContact21;}
    public double getAngleBetweenCenterRoofAndPointContactRadians21 () {return angleBetweenCenterRoofAndPointContactRadians21;}
    public int getAngleBetweenCenterRoofAndPointContactDegrees21 () {return angleBetweenCenterRoofAndPointContactDegrees21;}

    public double getXCalculateCoordinatePointContact31 () {return xCalculateCoordinatePointContact31;}
    public double getYCalculateCoordinatePointContact31 () {return yCalculateCoordinatePointContact31;}
    public int getXScaleCalculateCoordinatePointContact31 () {return xScaleCalculateCoordinatePointContact31;}
    public int getYScaleCalculateCoordinatePointContact31 () {return yScaleCalculateCoordinatePointContact31;}
    public double getAngleBetweenCenterRoofAndPointContactRadians31 () {return angleBetweenCenterRoofAndPointContactRadians31;}
    public int getAngleBetweenCenterRoofAndPointContactDegrees31 () {return angleBetweenCenterRoofAndPointContactDegrees31;}


    public CoordinatesIntersectionRounding getRoundingParameters12() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation12(),
                this.getYPointIntrsectionExcavation12(),
                this.getXStartRounding12(),
                this.getYStartRounding12(),
                this.getXIntersectionAxisAndStope1(),
                this.getYIntersectionAxisAndStope1()
        );
    }

    public CoordinatesIntersectionRounding getRoundingParameters21() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation12(),
                this.getYPointIntrsectionExcavation12(),
                this.getXStartRounding21(),
                this.getYStartRounding21(),
                this.getXIntersectionAxisAndStope2(),
                this.getYIntersectionAxisAndStope2()
        );
    }

    public CoordinatesIntersectionRounding getRoundingParameters23() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation23(),
                this.getYPointIntrsectionExcavation23(),
                this.getXStartRounding23(),
                this.getYStartRounding23(),
                this.getXIntersectionAxisAndStope2(),
                this.getYIntersectionAxisAndStope2()
        );
    }

    public CoordinatesIntersectionRounding getRoundingParameters32() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation23(),
                this.getYPointIntrsectionExcavation23(),
                this.getXStartRounding32(),
                this.getYStartRounding32(),
                this.getXIntersectionAxisAndStope3(),
                this.getYIntersectionAxisAndStope3()
        );
    }

    public CoordinatesIntersectionRounding getRoundingParameters31() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation31(),
                this.getYPointIntrsectionExcavation31(),
                this.getXStartRounding31(),
                this.getYStartRounding31(),
                this.getXIntersectionAxisAndStope3(),
                this.getYIntersectionAxisAndStope3()
        );
    }

    public CoordinatesIntersectionRounding getRoundingParameters13() {
        return new CoordinatesIntersectionRounding(
                this.getXPointIntrsectionExcavation31(),
                this.getYPointIntrsectionExcavation31(),
                this.getXStartRounding13(),
                this.getYStartRounding13(),
                this.getXIntersectionAxisAndStope1(),
                this.getYIntersectionAxisAndStope1()
        );
    }

    public CoordinatesIntersectionLine getLineParametersLeft1() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding13(),
                this.getYStartRounding13(),
                this.getXStopeLeft1(),
                this.getYStopeLeft1(),
                this.getXIntersectionAxisAndStope1(),
                this.getYIntersectionAxisAndStope1(),
                this.getXStartRounding12(),
                this.getYStartRounding12(),
                this.getXStopeRight1(),
                this.getYStopeRight1()
        );
    }
    public CoordinatesIntersectionLine getLineParametersRight1() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding12(),
                this.getYStartRounding12(),
                this.getXStopeRight1(),
                this.getYStopeRight1(),
                this.getXIntersectionAxisAndStope1(),
                this.getYIntersectionAxisAndStope1(),
                this.getXStartRounding13(),
                this.getYStartRounding13(),
                this.getXStopeLeft1(),
                this.getYStopeLeft1()
        );
    }

    public CoordinatesIntersectionLine getLineParametersLeft2() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding21(),
                this.getYStartRounding21(),
                this.getXStopeLeft2(),
                this.getYStopeLeft2(),
                this.getXIntersectionAxisAndStope2(),
                this.getYIntersectionAxisAndStope2(),
                this.getXStartRounding23(),
                this.getYStartRounding23(),
                this.getXStopeRight2(),
                this.getYStopeRight2()
        );
    }

    public CoordinatesIntersectionLine getLineParametersRight2() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding23(),
                this.getYStartRounding23(),
                this.getXStopeRight2(),
                this.getYStopeRight2(),
                this.getXIntersectionAxisAndStope2(),
                this.getYIntersectionAxisAndStope2(),
                this.getXStartRounding21(),
                this.getYStartRounding21(),
                this.getXStopeLeft2(),
                this.getYStopeLeft2()
        );
    }

    public CoordinatesIntersectionLine getLineParametersLeft3() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding32(),
                this.getYStartRounding32(),
                this.getXStopeLeft3(),
                this.getYStopeLeft3(),
                this.getXIntersectionAxisAndStope3(),
                this.getYIntersectionAxisAndStope3(),
                this.getXStartRounding31(),
                this.getYStartRounding31(),
                this.getXStopeRight3(),
                this.getYStopeRight3()
        );
    }

    public CoordinatesIntersectionLine getLineParametersRight3() {
        return new CoordinatesIntersectionLine(
                this.getXStartRounding31(),
                this.getYStartRounding31(),
                this.getXStopeRight3(),
                this.getYStopeRight3(),
                this.getXIntersectionAxisAndStope3(),
                this.getYIntersectionAxisAndStope3(),
                this.getXStartRounding32(),
                this.getYStartRounding32(),
                this.getXStopeLeft3(),
                this.getYStopeLeft3()
        );
    }
// @formatter:on
}