class Graphics {
    public static void main(String args[]) {

        //Параметры сечения горной выработки
        double B; // B - ширина выработки
        double H; // H - высота выработки
        double hr; //hr - высота закругления выработки
        B = 5.0;
        hr = B / 3.0;

        //Вычисляемые параметры сечения горной выработки
        double alpha = Math.atan(2.0 * hr / B); // alpha - опорный угол дуги большого радиуса
        double beta = Math.PI / 2.0 - alpha; // beta - опорный угол дуги малого радиуса
        //System.out.println("Опорный угол alpha дуги окружности большого радиуса равен " + alpha);
        //System.out.println("Опорный угол beta дуги окружности малого радиуса равен " + beta);

        double r = B * (2.0 / 3.0 * Math.sin(alpha) + Math.cos(alpha) - 1.0) / (2.0 * (Math.sin(alpha) + Math.cos(alpha) - 1.0)); // Радиус малой окружности
        double R = B * (1.0 / 3.0 - Math.cos(alpha) / (2.0 * (1.0 - Math.sin(alpha)))) / (1 - Math.cos(alpha) - Math.sin(2.0 * alpha) / (2.0 * (1.0 - Math.sin(alpha)))); // Радиус большой окружности
        //System.out.println("Радиус малой окружности равен " + r);
        //System.out.println("Радиус большой окружности равен " + R);

        double rl = r * beta; // rl - длина дуги малой окружности
        double Rl = 2.0 * R * alpha; // Rl - длина дуги большой окружности
        //System.out.println("Длина дуги малой окружности равна " + rl);
        //System.out.println("Длина дуги большой окружности равна " + Rl);

        double Lroofcr = 2.0 * rl + Rl; // Lroof - длина свода в плоскости поперечного сечения горной выработки;
        //System.out.println("Длина свода в плоскости поперечного сечения горной выработки равна " + Lroofcr);


        //Параметры крепления
        double l; // l - длина анкера
        double b; // b - шаг анкерования
        l = 2.0;
        b = 0.65;

        //Координаты начала и конца анкеров
        double x1; // Координата x начала анкера
        double y1; // Координата y начала анкера
        double x2; // Координата x конца анкера
        double y2; // Координата y конца анкера

        // Расчет для построения
        int n = (int) Math.floor(Lroofcr / b);


        switch (n % 2) {

            //Вариант 1 - анкер устанавливатеся по центру кровли горной выработки
            case 0:
                //System.out.println("Начинаем с вершины, количество анкеров в ряду равно " + (n + 1));
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
                System.out.println("i = " + i);

                double L = R*alpha-(i-1.0)*b;
                double phi0 = (i*b-R*alpha)/r;
                double lm = phi0*r;


                System.out.println("phi0 = " + phi0);
                System.out.println("L = " + L);
                System.out.println("lm = " + lm);


                for (j = 0; rl > j * b; j++) {
                    //x1 =
                    //y1 =
                    //x2 = x1 - l * (Math.cos(beta - j * b / r));
                    //y2 = y1 - l * (Math.sin(beta - j * b / r));
                    //System.out.print("Анкер " + (i + 1) + " : ");
                    //System.out.print("x1 = " + x1 + ", ");
                    //System.out.print("y1 = " + y1 + ", ");
                    //System.out.print("x2 = " + x2 + ", ");
                    //System.out.println("y2 = " + y2);
                }
                break;

            //Вариант 2 - анкер устанавливатеся со смещением на b/2 (половина шага анкерования) от центра кровли выработки
            case 1:
                //System.out.print("Начинаем сo сдвигом , количество анкеров в ряду равно " + (n + 1));


                break;

        }
    }
}

