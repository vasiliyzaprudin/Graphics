package com.mining.graphics.graphics.drawing;

import java.awt.*;
import java.util.ArrayList;

public class Drawing {
    private ArrayList<int[]> lines = new ArrayList<>();
    private int x1, y1;
    private int currentX, currentY;
    private boolean waitingForSecondPoint = false;

    public void mousePressed(int x, int y) {
        if (!waitingForSecondPoint) {
            // Первое нажатие - запоминаем первую точку
            x1 = x;
            y1 = y;
            // Устанавливаем текущую позицию в первую точку
            currentX = x;
            currentY = y;
            waitingForSecondPoint = true;
        } else {
            // Второе нажатие - рисуем отрезок
            lines.add(new int[]{x1, y1, x, y});
            waitingForSecondPoint = false;
        }
    }

    public void setCurrentX(int x) {
        this.currentX = x;
    }

    public void setCurrentY(int y) {
        this.currentY = y;
    }

    public boolean isWaitingForSecondPoint() {
        return waitingForSecondPoint;
    }

    public void draw(Graphics g) {
        // Рисуем все сохраненные отрезки
        for (int[] line : lines) {
            g.setColor(new Color(30, 50, 65));
            g.drawLine(line[0], line[1], line[2], line[3]);
        }

        // Рисуем "резиновую" линию при выборе второй точки
        if (waitingForSecondPoint) {
            g.setColor(new Color(132, 155, 179, 255));
            g.drawLine(x1, y1, currentX, currentY);
        }
    }

    public void clear() {
        lines.clear();
        waitingForSecondPoint = false;
    }
}