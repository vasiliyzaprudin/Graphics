package com.mining.graphics.service.support.intersection;

public class ServiceShotcreteIntersection {

    public static double getWidthExcavationWithShotcrete(double width, double thicknessShorcrete) {
        return width - 2.0 * thicknessShorcrete;
    }
}
