package com.mining.graphics.model.excavation;

public class ModelIntersection {
    public double bb12, bb23, bb34, bb41, bb31;
    public double bb;

    public double L0 = 5.0; //длина перпендикуляров для теста X0

    public int scaleInt = 40; //масштаб построений
    public int distance = 200; //отступ проекции от плана сопряжения

    //ширина горных выработок
    public double
            b1 = 4.2,
            b2 = 4.2,
            b3 = 4.2,
            b4 = 4.2;

    //высота горных выработок
    public double
            h1 = 4.2,
            h2 = 4.2,
            h3 = 4.2,
            h4 = 4.2;

    //высота закругления горных выработок
    public double
            hr1 = b1 / 3.0,
            hr2 = b2 / 3.0,
            hr3 = b3 / 3.0,
            hr4 = b4 / 3.0;

    //угол поворота оси горных выработок относительно севера в градусах
    public int
            alpha1 = 30,
            alpha2 = 90,
            alpha3 = 270,
            alpha4 = 270;
    //угол поворота оси горных выработок относительно севера в радианах
    public double
            alpha1Rad = alpha1 * Math.PI / 180,
            alpha2Rad = alpha2 * Math.PI / 180,
            alpha3Rad = alpha3 * Math.PI / 180,
            alpha4Rad = alpha4 * Math.PI / 180;

    //длина авыработок
    public double
            L1 = 10.0,
            L2 = 10.0,
            L3 = 10.0,
            L4 = 10.0;

    //длина горной выработки на закруглении
    public double
            b12 = b1,
            b21 = b2,
            b23 = b2,
            b32 = b3,
            b34 = b3,
            b43 = b4,
            b41 = b4,
            b14 = b1,
            b13 = b1,
            b31 = b3;

    public void CalculateBB(double B2, double B1, double ALPHARad2, double ALPHARad1) {
        if (Math.abs(ALPHARad2 - ALPHARad1) <= Math.PI / 2) {
            bb = ((B2 + B1) / 8) / Math.abs(Math.sin(ALPHARad2 - ALPHARad1));
        } else {
            bb = ((B2 + B1) / 8) * Math.sin(ALPHARad2 - ALPHARad1);
        }
    }

    //расчетные геометрические параметры горных выработок
    //опорный угол дуги большого радиуса
    public double
            al1 = Math.atan(2.0 * hr1 / b1),
            al2 = Math.atan(2.0 * hr2 / b2),
            al3 = Math.atan(2.0 * hr3 / b3),
            al4 = Math.atan(2.0 * hr4 / b4);

    //опорный угол дуги малого радиуса
    public double
            beta1 = Math.PI / 2.0 - al1,
            beta2 = Math.PI / 2.0 - al2,
            beta3 = Math.PI / 2.0 - al3,
            beta4 = Math.PI / 2.0 - al4;

    //радиус большой окружности
    public double
            R1 = (hr1 / Math.cos(al1) - b1 / 2 - hr1 * Math.tan(al1)) / (1 / Math.cos(al1) - 1 - Math.tan(al1)),
            R2 = (hr2 / Math.cos(al2) - b2 / 2 - hr2 * Math.tan(al2)) / (1 / Math.cos(al2) - 1 - Math.tan(al2)),
            R3 = (hr3 / Math.cos(al3) - b3 / 2 - hr3 * Math.tan(al3)) / (1 / Math.cos(al3) - 1 - Math.tan(al3)),
            R4 = (hr4 / Math.cos(al4) - b4 / 2 - hr4 * Math.tan(al4)) / (1 / Math.cos(al4) - 1 - Math.tan(al4));

    // радиус малой окружности
    public double
            r1 = R1 - (R1 - hr1) / Math.cos(al1),
            r2 = R2 - (R2 - hr2) / Math.cos(al2),
            r3 = R3 - (R3 - hr3) / Math.cos(al3),
            r4 = R4 - (R4 - hr4) / Math.cos(al4);

    //длина дуги малой окружности
    public double
            rl1 = r1 * beta1,
            rl2 = r2 * beta2,
            rl3 = r3 * beta3,
            rl4 = r4 * beta4;

    //длина дуги большой окружности
    public double
            Rl1 = 2.0 * R1 * al1,
            Rl2 = 2.0 * R2 * al2,
            Rl3 = 2.0 * R3 * al3,
            Rl4 = 2.0 * R4 * al4;

    //длина свода в плоскости поперечного сечения горной выработки
    public double
            LroofAc1 = 2.0 * rl1 + Rl1,
            LroofAc2 = 2.0 * rl2 + Rl2,
            LroofAc3 = 2.0 * rl3 + Rl3,
            LroofAc4 = 2.0 * rl4 + Rl4;
}