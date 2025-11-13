package com.mining.graphics.graphics;

import com.mining.graphics.service.ServiceIntersection;

import java.awt.*;

public class GraphicsIntersection extends ServiceIntersection {
    public void paint(Graphics g) {

        int t = 2;
        switch (t) {
            case 0: //одиночная выработка
                break;
            case 1: //сопряжение двух выработок (поворот)
                break;
            case 2: //сопряжение трех выработок
                //Построение осей выработок
                g.drawLine(0, 0, (int) (L1sc * Math.sin(alpha1Rad)), (int) (-L1sc * Math.cos(alpha1Rad)));
                g.drawLine(0, 0, (int) (L2sc * Math.sin(alpha2Rad)), (int) (-L2sc * Math.cos(alpha2Rad)));
                g.drawLine(0, 0, (int) (L3sc * Math.sin(alpha3Rad)), (int) (-L3sc * Math.cos(alpha3Rad)));
                //Линии, соединяющие точку пересечения осей выработок с точками пересечения боков выработок
//                g.drawLine(0, 0, x1sc, y1sc);
//                g.drawLine(0, 0, x2sc, y2sc);
//                g.drawLine(0, 0, x3sc, y3sc);
                //Бока и торцевые части выработок
                //Выработка 1
                g.drawLine((int) (L1sc * Math.sin(alpha1Rad)), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad)), (int) (L1sc * Math.sin(alpha1Rad) + b1sc / 2.0 * Math.cos(alpha1Rad)), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad) + b1sc / 2.0 * Math.sin(alpha1Rad)));
                g.drawLine(((int) (L1sc * Math.sin(alpha1Rad) + b1sc / 2.0 * Math.cos(alpha1Rad))), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad) + b1sc / 2.0 * Math.sin(alpha1Rad)), x1sc, y1sc);
                g.drawLine((int) (L1sc * Math.sin(alpha1Rad)), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad)), (int) (L1sc * Math.sin(alpha1Rad) - b1sc / 2.0 * Math.cos(alpha1Rad)), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad) - b1sc / 2.0 * Math.sin(alpha1Rad)));
                g.drawLine(((int) (L1sc * Math.sin(alpha1Rad) - b1sc / 2.0 * Math.cos(alpha1Rad))), (int) ((-1.0) * L1sc * Math.cos(alpha1Rad) - b1sc / 2.0 * Math.sin(alpha1Rad)), x3sc, y3sc);

                //Выработка 2
                g.drawLine((int) (L2sc * Math.sin(alpha2Rad)), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad)), (int) (L2sc * Math.sin(alpha2Rad) + b2sc / 2.0 * Math.cos(alpha2Rad)), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad) + b2sc / 2.0 * Math.sin(alpha2Rad)));
                g.drawLine((int) (L2sc * Math.sin(alpha2Rad) + b2sc / 2.0 * Math.cos(alpha2Rad)), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad) + b2sc / 2.0 * Math.sin(alpha2Rad)), x2sc, y2sc);
                g.drawLine((int) (L2sc * Math.sin(alpha2Rad)), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad)), (int) (L2sc * Math.sin(alpha2Rad) - b2sc / 2.0 * Math.cos(alpha2Rad)), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad) - b2sc / 2.0 * Math.sin(alpha2Rad)));
                g.drawLine(((int) (L2sc * Math.sin(alpha2Rad) - b2sc / 2.0 * Math.cos(alpha2Rad))), (int) ((-1.0) * L2sc * Math.cos(alpha2Rad) - b2sc / 2.0 * Math.sin(alpha2Rad)), x1sc, y1sc);

                //Выработка 3
                g.drawLine((int) (L3sc * Math.sin(alpha3Rad)), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad)), (int) (L3sc * Math.sin(alpha3Rad) + b3sc / 2.0 * Math.cos(alpha3Rad)), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad) + b3sc / 2.0 * Math.sin(alpha3Rad)));
                g.drawLine((int) (L3sc * Math.sin(alpha3Rad) + b3sc / 2.0 * Math.cos(alpha3Rad)), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad) + b3sc / 2.0 * Math.sin(alpha3Rad)), x3sc, y3sc);
                g.drawLine((int) (L3sc * Math.sin(alpha3Rad)), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad)), (int) (L3sc * Math.sin(alpha3Rad) - b3sc / 2.0 * Math.cos(alpha3Rad)), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad) - b3sc / 2.0 * Math.sin(alpha3Rad)));
                g.drawLine(((int) (L3sc * Math.sin(alpha3Rad) - b3sc / 2.0 * Math.cos(alpha3Rad))), (int) ((-1.0) * L3sc * Math.cos(alpha3Rad) - b3sc / 2.0 * Math.sin(alpha3Rad)), x2sc, y2sc);
//                System.out.println("x1sc " + x1sc);
//                System.out.println("x2sc " + x2sc);
//                System.out.println("x3sc " + x3sc);
//                System.out.println("y1sc " + y1sc);
//                System.out.println("y2sc " + y2sc);
//                System.out.println("y3sc " + y3sc);
        }
    }
}
