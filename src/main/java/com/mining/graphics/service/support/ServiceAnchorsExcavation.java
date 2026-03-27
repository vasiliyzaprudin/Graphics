package com.mining.graphics.service.support;

public class ServiceAnchorsExcavation {
    //Методы расчета шага установки анкеров по дугам большого радиуса
    public double calculateStepLargeArcX(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * Math.sin(omega + j * step / largeArcRadius);
    }

    public double calculateStepLargeArcY(int j, double step, double largeArcRadius, double omega) {
        return largeArcRadius * (1.0 - Math.cos(omega + j * step / largeArcRadius));
    }

    public double calculateStepLargeArcAnchorsX(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return (largeArcRadius + lengthAnch) * Math.sin(omega + j * step / largeArcRadius);
    }

    public double calculateStepLargeArcAnchorsY(int j, double step, double largeArcRadius, double lengthAnch, double omega) {
        return largeArcRadius - (largeArcRadius + lengthAnch) * Math.cos(omega + j * step / largeArcRadius);
    }


    //Методы расчета шага установки анкеров по дугам малого радиуса
    public double calculateStepSmallArcX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian) {
        return width / 2.0 - smallArcRadius + smallArcRadius * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian) {
        return -height + archHeight - smallArcRadius * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcAnchorsX(int j, double width, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return width / 2.0 - smallArcRadius + (smallArcRadius + lengthAnch) * Math.cos(betaRadian - phi - j * step / smallArcRadius);
    }

    public double calculateStepSmallArcAnchorsY(int j, double height, double archHeight, double smallArcRadius, double step, double phi, double betaRadian, double lengthAnch) {
        return -height + archHeight - (smallArcRadius + lengthAnch) * Math.sin(betaRadian - phi - j * step / smallArcRadius);
    }


    //Методы расчета шага установки анкеров по боку горной выработки
    public double calculateStepWallX(double width) {
        return width / 2.0;
    }

    public double calculateStepWallY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }

    public double calculateStepWallAnchorsX(double width, double lengthAnch) {
        return width / 2.0 + lengthAnch;
    }

    public double calculateStepWallAnchorsY(int j, double height, double archHeight, double step, double delta) {
        return -height + archHeight + delta + j * step;
    }
}
