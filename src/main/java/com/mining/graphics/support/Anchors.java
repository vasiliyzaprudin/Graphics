package com.mining.graphics.support;

import com.mining.graphics.mineexcavation.MineExcavation;

class Anchors {

    public static void main(String[] args) {

        double l = 2.0; // l - длина анкера
        double b = 1.0; // b - шаг анкерования

        double x1; // Координата x начала анкера
        double y1; // Координата y начала анкера
        double x2; // Координата x конца анкера
        double y2; // Координата y конца анкера

        MineExcavation MineExcavation = new MineExcavation();

        double B = MineExcavation.getB();
        double hr = MineExcavation.gethr();
        double alpha = MineExcavation.getalpha();
        double beta = MineExcavation.getbeta();
        double r = MineExcavation.getr();
        double R = MineExcavation.getR();
        double rl = MineExcavation.getrl();
        double Rl = MineExcavation.getRl();
        double Lroof = MineExcavation.getLroof();

        System.out.println("Геометрические параметры поперечного сечения горной выработки:");
        System.out.println("Опорный угол alpha дуги окружности большого радиуса равен " + alpha);
        System.out.println("Опорный угол beta дуги окружности малого радиуса равен " + beta);
        System.out.println("Радиус малой окружности равен " + r);
        System.out.println("Радиус большой окружности равен " + R);
        System.out.println("Длина дуги малой окружности равна " + rl);
        System.out.println("Длина дуги большой окружности равна " + Rl);
        System.out.println("Длина свода равна " + Lroof);

        // Расчет координат расположения анкеров
        int n = (int) Math.floor(Lroof / b);

        switch (n % 2) {

            //Вариант 1 - анкер устанавливатеся по центру кровли горной выработки
            case 0:
                System.out.println("Начинаем с вершины, количество анкеров в ряду равно " + (n + 1));
                int i, j;
                for (i = 0; Rl / 2.0 > i * b; i++) {
                    x1 = B / 2.0 - R * Math.sin(i * b / R);
                    y1 = R * (1 - Math.cos(i * b / R));
                    x2 = B / 2.0 - (R + l) * Math.sin(i * b / R);
                    y2 = (R + l) * (1 - Math.cos(i * b / R)) - l;
                    System.out.print("Анкер " + (i + 1) + " : ");
                    System.out.print("x1 = " + x1 + ", ");
                    System.out.print("y1 = " + y1 + ", ");
                    System.out.print("x2 = " + x2 + ", ");
                    System.out.println("y2 = " + y2);
                }
                //System.out.println("i = " + i);

                double phi0 = (i * b - R * alpha) / r; /* phi0 - это опорный угол дуги малого радиуса lbeg,
                которая является продолжением остатка дуги большого радиуса Lrem.
                Их сумма равна шагу анкерования Lrem + lbeg = b */

                double Lrem = R * alpha - b * (i - 1);
                double lbeg = r * phi0;

                for (j = 0; rl - lbeg > + j * b; j++, i++) {
                    x1 = r * (1.0 - Math.cos(beta - phi0 - j * b / r));
                    y1 = hr - r * Math.sin(beta - phi0 - j * b / r);
                    x2 = x1 - l * (Math.cos(beta - phi0 - j * b / r));
                    y2 = y1 - l * (Math.sin(beta - phi0 - j * b / r));
                    System.out.print("Анкер " + (i + 1) + " : ");
                    System.out.print("x1 = " + x1 + ", ");
                    System.out.print("y1 = " + y1 + ", ");
                    System.out.print("x2 = " + x2 + ", ");
                    System.out.println("y2 = " + y2);
                }
                System.out.println("Дополнительные геометрические параметры для проверки");
                System.out.println("phi0 = " + phi0);
                System.out.println("Lrem = " + Lrem);
                System.out.println("lbeg = " + lbeg);
                break;
            //Вариант 2 - анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки
            case 1:
                System.out.print("Начинаем сo сдвигом , количество анкеров в ряду равно " + (n + 1));

                break;
        }
    }
}


