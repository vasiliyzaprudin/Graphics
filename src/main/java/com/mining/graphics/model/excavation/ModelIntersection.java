package com.mining.graphics.model.excavation;

public class ModelIntersection {
    private double width1 = 4.2, width2 = 4.2, width3 = 4.2;

    private double height1 = 4.2, height2 = 4.2, height3 = 4.2;

    private double length1 = 10.0, length2 = 10.0, length3 = 10.0;

    private double formIndicationIntersection = 4.0;

    private double formIndication1 = 3.0, formIndication2 = 3.0, formIndication3 = 3.0;

    private int azimuthDegrees1 = 0, azimuthDegrees2 = 90, azimuthDegrees3 = 270;



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

    public double getHeight1() {return height1;}
    public void setHeight1(double height1) {this.height1 = height1;}

    public double getHeight2() {return height2;}
    public void setHeight2(double height2) {this.height2 = height2;}

    public double getHeight3() {return height3;}
    public void setHeight3(double height3) {this.height3 = height3;}

    public double getLength1() {return length1;}
    public void setLength1(double length1) {this.length1 = length1;}

    public double getLength2() {return length2;}
    public void setLength2(double length2) {this.length2 = length2;}

    public double getLength3() {return length3;}
    public void setLength3(double length3) {this.length3 = length3;}

    public double getFormIndication1() {return formIndication1;}
    public void setFormIndication1(double formIndication1) {this.formIndication1 = formIndication1;}

    public double getFormIndication2() {return formIndication2;}
    public void setFormIndication2(double formIndication2) {this.formIndication2 = formIndication2;}

    public double getFormIndication3() {return formIndication3;}
    public void setFormIndication3(double formIndication3) {this.formIndication3 = formIndication3;}

    public int getAzimuthDegrees1() {return azimuthDegrees1;}
    public void setAzimuthDegrees1(int azimuthDegrees1) {this.azimuthDegrees1 = azimuthDegrees1;}
    public double getAzimuthRadians1() {return azimuthDegrees1 * Math.PI / 180.0;}

    public int getAzimuthDegrees2() {return azimuthDegrees2;}
    public void setAzimuthDegrees2(int azimuthDegrees2) {this.azimuthDegrees2 = azimuthDegrees2;}
    public double getAzimuthRadians2() {return azimuthDegrees2 * Math.PI / 180.0;}

    public int getAzimuthDegrees3() {return azimuthDegrees3;}
    public void setAzimuthDegrees3(int azimuthDegrees3) {this.azimuthDegrees3 = azimuthDegrees3;}
    public double getAzimuthRadians3() {return azimuthDegrees3 * Math.PI / 180.0;}


    public double getFormIndicationIntersection() {return formIndicationIntersection;}
    public void setFormIndicationIntersection(double formIndicationIntersection) {this.formIndicationIntersection = formIndicationIntersection;}
}