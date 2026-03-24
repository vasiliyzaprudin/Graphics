package com.mining.graphics.graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Drawing {
    private ArrayList<int[]> lines = new ArrayList<>();
    private int x1, y1;
    private boolean drawing = false;

    public void mousePressed(int x, int y) {
        x1 = x;
        y1 = y;
        drawing = true;
    }

    public void mouseReleased(int x, int y) {
        if (drawing) {
            lines.add(new int[]{x1, y1, x, y});
            drawing = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(65, 100, 130));
        for (int[] line : lines) {
            g.drawLine(line[0], line[1], line[2], line[3]);
        }
    }
}