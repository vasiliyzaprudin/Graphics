package com.mining.graphics.model.excavation;

public class ModelExcavation {
    //Исходные геометрические параметры выработки
    public double B = 4.2; //ширина
    public double H = 3.7; //высота
    public double hr = B / 3.0; //высота закругления
    public int scaleEx = 80; //масштаб построений
    public int distance = 600; //расстояние между поперечным разрезом и видом сбоку в графическом окне

    //Расчетные геометрические параметры выработки
    public double alpha = Math.atan(2.0 * hr / B); //опорный угол дуги большого радиуса
    public double beta = Math.PI / 2.0 - alpha; //опорный угол дуги малого радиуса

    public double R = (hr / Math.cos(alpha) - B / 2 - hr * Math.tan(alpha)) / (1 / Math.cos(alpha) - 1 - Math.tan(alpha)); //радиус большой окружности
    public double r = R - (R - hr) / Math.cos(alpha); // радиус малой окружности

    public double rl = r * beta; //длина дуги малой окружности
    public double Rl = 2.0 * R * alpha; //длина дуги большой окружности
    public double LroofAc = 2.0 * rl + Rl; //длина свода в плоскости поперечного сечения горной выработки

    //Расчетные геометрические параметры выработки в масштабе
    public int rsc = (int) (r * scaleEx);
    public int Rsc = (int) (R * scaleEx);
    public int rlsc = (int) (rl * scaleEx);
    public int Rlsc = (int) (Rl * scaleEx);
    public int LroofAcsc = (int) (LroofAc * scaleEx);

    //Исходные геометрические параметры выработки в масштабе
    public int Bsc = (int) (B * scaleEx);
    public int Hsc = (int) (H * scaleEx);
    public int hrsc = (int) (hr * scaleEx);
}