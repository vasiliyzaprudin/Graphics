package com.mining.graphics.model.excavation;

public class ModelIntersection {
    private double width1 = 4.2, width2 = 4.2, width3 = 4.2, width4 = 4.2;

    private double height1 = 4.2, height2 = 4.2, height3 = 4.2, height4 = 4.2;

    private double length1 = 10.0, length2 = 10.0, length3 = 10.0, length4 = 10.0;

    private double formIndicationIntersection = 4.0;

    private double formIndication1 = 3.0, formIndication2 = 3.0, formIndication3 = 3.0, formIndication4 = 3.0;

    private int azimuthDegrees1 = 0, azimuthDegrees2 = 110, azimuthDegrees3 = 225, azimuthDegrees4 = 270;

    // @formatter:off
    public ModelIntersection(){}

    public ModelIntersection(double width1, double height1, double length1, double formIndication1, int azimuthDegrees1,
                      double width2, double height2, double length2, double formIndication2, int azimuthDegrees2,
                      double formIndicationIntersection) {
        this.width1 = width1;
        this.height1 = height1;
        this.length1 = length1;
        this.formIndication1 = formIndication1;
        this.azimuthDegrees1 = azimuthDegrees1;
        this.width2 = width2;
        this.height2 = height2;
        this.length2 = length2;
        this.formIndication2 = formIndication2;
        this.azimuthDegrees2 = azimuthDegrees2;
        this.formIndicationIntersection = formIndicationIntersection;
    }

    public ModelIntersection(double width1, double height1, double length1, double formIndication1, int azimuthDegrees1,
                      double width2, double height2, double length2, double formIndication2, int azimuthDegrees2,
                      double width3, double height3, double length3, double formIndication3, int azimuthDegrees3,
                      double formIndicationIntersection) {
        this.width1 = width1;
        this.height1 = height1;
        this.length1 = length1;
        this.formIndication1 = formIndication1;
        this.azimuthDegrees1 = azimuthDegrees1;
        this.width2 = width2;
        this.height2 = height2;
        this.length2 = length2;
        this.formIndication2 = formIndication2;
        this.azimuthDegrees2 = azimuthDegrees2;
        this.width3 = width3;
        this.height3 = height3;
        this.length3 = length3;
        this.formIndication3 = formIndication3;
        this.azimuthDegrees3 = azimuthDegrees3;
        this.formIndicationIntersection = formIndicationIntersection;
    }
    // @formatter:on

    public double getWidth1() {return width1;}
    public void setWidth1(double width1) {this.width1 = width1;}

    public double getWidth2() {return width2;}
    public void setWidth2(double width2) {this.width2 = width2;}

    public double getWidth3() {return width3;}
    public void setWidth3(double width3) {this.width3 = width3;}

    public double getWidth4() {return width4;}
    public void setWidth4(double width4) {this.width4 = width4;}

    public double getHeight1() {return height1;}
    public void setHeight1(double height1) {this.height1 = height1;}

    public double getHeight2() {return height2;}
    public void setHeight2(double height2) {this.height2 = height2;}

    public double getHeight3() {return height3;}
    public void setHeight3(double height3) {this.height3 = height3;}

    public double getHeight4() {return height4;}
    public void setHeight4(double height4) {this.height4 = height4;}

    public double getLength1() {return length1;}
    public void setLength1(double length1) {this.length1 = length1;}

    public double getLength2() {return length2;}
    public void setLength2(double length2) {this.length2 = length2;}

    public double getLength3() {return length3;}
    public void setLength3(double length3) {this.length3 = length3;}

    public double getLength4() {return length4;}
    public void setLength4(double length4) {this.length4 = length4;}

    public double getFormIndication1() {return formIndication1;}
    public void setFormIndication1(double formIndication1) {this.formIndication1 = formIndication1;}

    public double getFormIndication2() {return formIndication2;}
    public void setFormIndication2(double formIndication2) {this.formIndication2 = formIndication2;}

    public double getFormIndication3() {return formIndication3;}
    public void setFormIndication3(double formIndication3) {this.formIndication3 = formIndication3;}

    public double getFormIndication4() {return formIndication4;}
    public void setFormIndication4(double formIndication4) {this.formIndication4 = formIndication4;}

    public int getAzimuthDegrees1() {return azimuthDegrees1;}
    public void setAzimuthDegrees1(int azimuthDegrees1) {this.azimuthDegrees1 = azimuthDegrees1;}
    public double getAzimuthRadians1() {return azimuthDegrees1 * Math.PI / 180.0;}

    public int getAzimuthDegrees2() {return azimuthDegrees2;}
    public void setAzimuthDegrees2(int azimuthDegrees2) {this.azimuthDegrees2 = azimuthDegrees2;}
    public double getAzimuthRadians2() {return azimuthDegrees2 * Math.PI / 180.0;}

    public int getAzimuthDegrees3() {return azimuthDegrees3;}
    public void setAzimuthDegrees3(int azimuthDegrees3) {this.azimuthDegrees3 = azimuthDegrees3;}
    public double getAzimuthRadians3() {return azimuthDegrees3 * Math.PI / 180.0;}

    public int getAzimuthDegrees4() {return azimuthDegrees4;}
    public void setAzimuthDegrees4(int azimuthDegrees4) {this.azimuthDegrees4 = azimuthDegrees4;}
    public double getAzimuthRadians4() {return azimuthDegrees4 * Math.PI / 180.0;}

    public double getFormIndicationIntersection() {return formIndicationIntersection;}
    public void setFormIndicationIntersection(double formIndicationIntersection) {this.formIndicationIntersection = formIndicationIntersection;}

//    public double bb12, bb23, bb34, bb41, bb31;
//    public double bb;

    //public double L0 = 5.0; //длина перпендикуляров для теста X0Y0

//    public int scaleInt = 40; //масштаб построений
//    public int distance = 650; //отступ проекции сопряжения от плана сопряжения по оси Y

//    private double b1sc = width1 * scaleInt, b2sc = width2 * scaleInt, b3sc = width3 * scaleInt, b4sc = width4 * scaleInt;
//
//
//    public int h1sc = (int) (height1 * scaleInt), h2sc = (int) (height2 * scaleInt), h3sc = (int) (height3 * scaleInt), h4sc = (int) (height4 * scaleInt);

    //высота закругления горных выработок
    //   public double hr1 = width1 / 3.0, hr2 = width2 / 3.0, hr3 = width3 / 3.0, hr4 = width4 / 3.0;


    //угол поворота оси горных выработок относительно севера в радианах
    //   public double alpha1Rad = azimuthDegrees1 * Math.PI / 180.0, alpha2Rad = azimuthDegrees2 * Math.PI / 180.0, alpha3Rad = azimuthDegrees3 * Math.PI / 180.0, alpha4Rad = azimuthDegrees4 * Math.PI / 180.0;


    //длина горной выработки на закруглении
//    public double b12 = width1,
//            b21 = width2,
//            b23 = width2,
//            b32 = width3,
//            b34 = width3,
//            b43 = width4,
//            b41 = width4,
//            b14 = width1,
//            b13 = width1,
//            b31 = width3;


//    //расчетные геометрические параметры горных выработок
//    //опорный угол дуги большого радиуса
//    public double al1 = Math.atan(2.0 * hr1 / width1), al2 = Math.atan(2.0 * hr2 / width2), al3 = Math.atan(2.0 * hr3 / width3), al4 = Math.atan(2.0 * hr4 / width4);
//
//    //опорный угол дуги малого радиуса
//    public double beta1 = Math.PI / 2.0 - al1, beta2 = Math.PI / 2.0 - al2, beta3 = Math.PI / 2.0 - al3, beta4 = Math.PI / 2.0 - al4;
//
//    //радиус большой окружности
//    public double R1 = (hr1 / Math.cos(al1) - width1 / 2 - hr1 * Math.tan(al1)) / (1 / Math.cos(al1) - 1 - Math.tan(al1)), R2 = (hr2 / Math.cos(al2) - width2 / 2 - hr2 * Math.tan(al2)) / (1 / Math.cos(al2) - 1 - Math.tan(al2)), R3 = (hr3 / Math.cos(al3) - width3 / 2 - hr3 * Math.tan(al3)) / (1 / Math.cos(al3) - 1 - Math.tan(al3)), R4 = (hr4 / Math.cos(al4) - width4 / 2 - hr4 * Math.tan(al4)) / (1 / Math.cos(al4) - 1 - Math.tan(al4));
//
//    // радиус малой окружности
//    public double r1 = R1 - (R1 - hr1) / Math.cos(al1), r2 = R2 - (R2 - hr2) / Math.cos(al2), r3 = R3 - (R3 - hr3) / Math.cos(al3), r4 = R4 - (R4 - hr4) / Math.cos(al4);
//
//    //длина дуги малой окружности
//    public double rl1 = r1 * beta1, rl2 = r2 * beta2, rl3 = r3 * beta3, rl4 = r4 * beta4;
//
//    //длина дуги большой окружности
//    public double Rl1 = 2.0 * R1 * al1, Rl2 = 2.0 * R2 * al2, Rl3 = 2.0 * R3 * al3, Rl4 = 2.0 * R4 * al4;
//
//    //длина свода в плоскости поперечного сечения горной выработки
//    public double LroofAc1 = 2.0 * rl1 + Rl1, LroofAc2 = 2.0 * rl2 + Rl2, LroofAc3 = 2.0 * rl3 + Rl3, LroofAc4 = 2.0 * rl4 + Rl4;
}