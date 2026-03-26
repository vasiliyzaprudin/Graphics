package com.mining.graphics.service.support;

public class ServiceShotcreteExcavation {

    public double getWidthExcavationWithShotcrete(double width, double thicknessShorcrete) {
        return width - 2.0 * thicknessShorcrete;
    }

    public double getHeightExcavationWithShotcrete(double width, double thicknessShorcrete) {
        return width - thicknessShorcrete;
    }

    public int getScaleWidthExcavationWithShotcrete(double width, double thicknessShorcrete, int scale) {
        return (int) (Math.round((width - 2.0 * thicknessShorcrete) * scale));
    }

    public int getScaleHeightExcavationWithShotcrete(double height, double thicknessShorcrete, int scale) {
        return (int) (Math.round((height - thicknessShorcrete) * scale));
    }
}