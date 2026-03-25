package com.mining.graphics.graphics.drawing;

import javax.swing.*;
import java.awt.event.*;

public class DrawingMouse {
    private final Drawing drawing;
    private final JPanel panel;

    public DrawingMouse(Drawing drawing, JPanel panel) {
        this.drawing = drawing;
        this.panel = panel;
    }

    public void install() {
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                drawing.mousePressed(e.getX(), e.getY());
                panel.repaint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                if (drawing.isWaitingForSecondPoint()) {
                    drawing.setCurrentX(e.getX());
                    drawing.setCurrentY(e.getY());
                    panel.repaint();
                }
            }
        });
    }
}
