package com.mining.graphics.controlpanel;

import com.mining.graphics.model.excavation.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.AnchorsExcavation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ControlPanelIntersection extends JPanel {

    private final ModelIntersection model;
    private final CoordinatesIntersection modelCoordinates;
    private final AnchorsExcavation anchors;
    private final JPanel drawingPanel;

    // Поля для выработки №1
    private JTextField widthField;
    private JTextField heightField;
    private JTextField azimuthField;
    private JTextField formField;

    // Поля для анкеров
    private JTextField lengthAnchorField;
    private JTextField stepField;
    private JTextField distanceBetweenRowsField;
    private JTextField distanceLowerAnchorField;

    private static final Color PANEL_BG = new Color(238, 234, 226, 255);
    private static final Color FIELD_BG = Color.WHITE;
    private static final Color BUTTON_BG = new Color(85, 109, 88);
    private static final Color BUTTON_FG = Color.WHITE;

    public ControlPanelIntersection(ModelIntersection model, CoordinatesIntersection modelCoordinates, AnchorsExcavation anchors,
                                    JPanel drawingPanel) {
        this.model = model;
        this.modelCoordinates = modelCoordinates;
        this.anchors = anchors;
        this.drawingPanel = drawingPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 25, 710, 25), BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(125, 149, 128), 1), "Параметры сопряжения", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14), new Color(60, 60, 60))));
        setBackground(PANEL_BG);
        setPreferredSize(new Dimension(320, 550));

        add(Box.createVerticalStrut(10));
        add(Box.createHorizontalStrut(30));

        // Горная выработка №1
        add(createSectionLabel("Горная выработка №1"));
        add(Box.createVerticalStrut(5));

        add(createLabel("Ширина горной выработки №1 (м):"));
        add(Box.createVerticalStrut(5));
        widthField = createTextField(String.valueOf(model.getWidth1()));
        add(widthField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Высота горной выработки №1 (м):"));
        add(Box.createVerticalStrut(5));
        heightField = createTextField(String.valueOf(model.getHeight1()));
        add(heightField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Азимут горной выработки №1 (градусы):"));
        add(Box.createVerticalStrut(5));
        azimuthField = createTextField(String.valueOf(model.getAzimuthDegrees1()));  // Исправлено: отдельное поле
        add(azimuthField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Коэффициент формы сопряжения:"));
        add(Box.createVerticalStrut(5));
        formField = createTextField(String.valueOf(model.getFormIndicationIntersection()));
        add(formField);
        add(Box.createVerticalStrut(15));

        // Анкерное крепление
        add(createSectionLabel("Анкерное крепление"));
        add(Box.createVerticalStrut(5));

        add(createLabel("Длина анкера (м):"));
        add(Box.createVerticalStrut(5));
        lengthAnchorField = createTextField(String.valueOf(anchors.getLengthAnchor()));
        add(lengthAnchorField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Шаг установки анкеров (м):"));
        add(Box.createVerticalStrut(5));
        stepField = createTextField(String.valueOf(anchors.getStep()));
        add(stepField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Расстояние между рядами анкеров (м):"));
        add(Box.createVerticalStrut(5));
        distanceBetweenRowsField = createTextField(String.valueOf(anchors.getDistanceBetweenRows()));
        add(distanceBetweenRowsField);
        add(Box.createVerticalStrut(10));

        add(createLabel("Подъем анкерного крепления (м):"));
        add(Box.createVerticalStrut(5));
        distanceLowerAnchorField = createTextField(String.valueOf(anchors.getDistanceLowerAnchor()));
        add(distanceLowerAnchorField);
        add(Box.createVerticalStrut(20));

        JButton applyButton = createButton("Применить");
        applyButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        applyButton.addActionListener(e -> applyChanges());
        add(applyButton);

        add(Box.createVerticalStrut(15));
    }

    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(new Color(60, 60, 60));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(new Color(60, 60, 60));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JTextField createTextField(String value) {
        JTextField field = new JTextField(value);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBackground(FIELD_BG);
        field.setForeground(new Color(60, 60, 60));
        field.setPreferredSize(new Dimension(150, 32));
        field.setMaximumSize(new Dimension(150, 32));
        field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(125, 149, 128), 1), BorderFactory.createEmptyBorder(4, 5, 4, 5)));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        return field;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BUTTON_BG);
        button.setForeground(BUTTON_FG);
        button.setFocusPainted(false);

        button.setPreferredSize(new Dimension(150, 40));
        button.setMinimumSize(new Dimension(150, 40));
        button.setMaximumSize(new Dimension(150, 40));

        button.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(65, 89, 68));  // Немного темнее при наведении
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_BG);
            }
        });

        return button;
    }

    private void applyChanges() {
        boolean excavationValid = true;
        boolean anchorsValid = true;
        StringBuilder errorMessage = new StringBuilder();

        // Применяем параметры выработки №1 и коэффициента формы сопряжения
        try {
            double width = Double.parseDouble(widthField.getText().trim());
            double height = Double.parseDouble(heightField.getText().trim());
            int azimuth = Integer.parseInt(azimuthField.getText().trim());
            double formIntersection = Double.parseDouble(formField.getText().trim());

            if (width >= 2 && width <= 8 && height >= 2 && height <= 8 && formIntersection >= 1.5 && formIntersection <= 8 && azimuth >= -45 && azimuth <= 45) {
                model.setWidth1(width);
                model.setHeight1(height);
                model.setAzimuthDegrees1(azimuth);
                model.setFormIndicationIntersection(formIntersection);
                modelCoordinates.updateCoordinates();
            } else {
                if (width <= 0 || height <= 0) errorMessage.append("Ширина и высота должны быть положительными!\n");
                if (formIntersection <= 0) errorMessage.append("Коэффициент формы сопряжения должен быть положительным!\n");
                if (azimuth <= -45 || azimuth >= 45) errorMessage.append("Азимут должен быть в диапазоне от -45 до 45 градусов!\n");
                excavationValid = false;
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Параметры выработки: введите корректные числа!\n");
            excavationValid = false;
        }

        // Применяем параметры анкерного крепления
        try {
            double lengthAnchor = Double.parseDouble(lengthAnchorField.getText().trim());
            double step = Double.parseDouble(stepField.getText().trim());
            double distanceBetweenRows = Double.parseDouble(distanceBetweenRowsField.getText().trim());
            double distanceLowerAnchor = Double.parseDouble(distanceLowerAnchorField.getText().trim());

            if (lengthAnchor > 0 && step > 0 && distanceBetweenRows > 0 && distanceLowerAnchor > 0) {
                anchors.setLengthAnchor(lengthAnchor);
                anchors.setStep(step);
                anchors.setDistanceBetweenRows(distanceBetweenRows);
                anchors.setDistanceLowerAnchor(distanceLowerAnchor);
            } else {
                errorMessage.append("Параметры анкеров: все значения должны быть положительными!\n");
                anchorsValid = false;
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Параметры анкеров: введите корректные числа!\n");
            anchorsValid = false;
        }

        if (excavationValid && anchorsValid) {
            drawingPanel.repaint();
        } else {
            showError(errorMessage.toString());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }
}