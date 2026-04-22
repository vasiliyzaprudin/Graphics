package com.mining.graphics.service.support.excavation;

public class ServiceShotcreteExcavation {

    public static double getWidthExcavationWithShotcrete(double width, double thicknessShorcrete) {
        return width - 2.0 * thicknessShorcrete;
    }

    public static double getHeightExcavationWithShotcrete(double width, double thicknessShorcrete) {
        return width - thicknessShorcrete;
    }

    public static int getScaleWidthExcavationWithShotcrete(double width, double thicknessShorcrete, int scale) {
        return (int) (Math.round((width - 2.0 * thicknessShorcrete) * scale));
    }

    public static int getScaleHeightExcavationWithShotcrete(double height, double thicknessShorcrete, int scale) {
        return (int) (Math.round((height - thicknessShorcrete) * scale));
    }
}