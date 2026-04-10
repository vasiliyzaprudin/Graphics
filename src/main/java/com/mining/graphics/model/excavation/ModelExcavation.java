package com.mining.graphics.model.excavation;

public class ModelExcavation {
    private String id;
    private double width = 4.2;
    private double height = 4.7;
    private double length = 5.0;
    private double formIndication = 3.0;
    private double azimuthDegrees = 0.0;

    public ModelExcavation() {
    }

    public ModelExcavation(String id, double width, double height, double length, double formIndication, double azimuthDegrees) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.length = length;
        this.formIndication = formIndication;
        this.azimuthDegrees = azimuthDegrees;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public double getWidth() {return width;}

    public void setWidth(double width) {this.width = width;}

    public double getHeight() {return height;}

    public void setHeight(double height) {this.height = height;}

    public double getLength() {return length;}

    public void setLength(double length) {this.length = length;}

    public double getFormIndication() {return formIndication;}

    public void setFormIndication(double formIndication) {this.formIndication = formIndication;}

    public double getAzimuthDegrees() {return azimuthDegrees;}

    public void setAzimuthDegrees(double azimuthDegrees) {this.azimuthDegrees = azimuthDegrees;}

    public double getAzimuthRadians() {return Math.toRadians(azimuthDegrees);}
}