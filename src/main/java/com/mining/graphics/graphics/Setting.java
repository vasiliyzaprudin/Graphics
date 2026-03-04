package com.mining.graphics.graphics;

import java.awt.*;

public class Setting {
    public void setGraph(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //Сглаживание
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //Толщина линий
        ((Graphics2D) g).setStroke(new BasicStroke(1));
    }
}
