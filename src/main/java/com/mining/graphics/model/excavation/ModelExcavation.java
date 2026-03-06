package com.mining.graphics.model.excavation;

public class ModelExcavation {
    //Исходные геометрические параметры выработки
    public double B = 4.9; //ширина
    public double H = 4.5; //высота
    public double K = 3.0; //тип формы свода
    public double hr = B / K;
    public int scaleEx = 80; //масштаб построений
    public int distance = 600; //расстояние между поперечным разрезом и видом сбоку в графическом окне

    public double b = 4.7;
    public double h = 4.2;
    public double k = 3.0;

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