package com.mining.graphics.controlpanel;

import com.mining.graphics.model.excavation.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.AnchorsIntersection;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ControlPanelIntersection extends JPanel {

    private final ModelIntersection model;
    private final CoordinatesIntersection modelCoordinates;
    private final AnchorsIntersection anchors;
    private final JPanel drawingPanel;

    // Поля для выработок
    private JTextField width1Field;
    private JTextField height1Field;
    private JTextField azimuth1Field;

    // Выработка №2
    private JTextField width2Field;
    private JTextField height2Field;

    // Общий коэффициент формы сопряжения
    private JTextField formField;

    // Поля для анкеров
    // Выработка №1
    private JTextField lengthAnchor1Field;
    private JTextField step1Field;
    private JTextField distanceBetweenRows1Field;
    private JTextField distanceLowerAnchor1Field;

    // Выработка №2
    private JTextField lengthAnchor2Field;
    private JTextField step2Field;
    private JTextField distanceBetweenRows2Field;
    private JTextField distanceLowerAnchor2Field;

    private static final Color PANEL_BG = new Color(238, 234, 226, 255);
    private static final Color FIELD_BG = Color.WHITE;
    private static final Color BUTTON_BG = new Color(85, 109, 88);
    private static final Color BUTTON_FG = Color.WHITE;

    public ControlPanelIntersection(ModelIntersection model, CoordinatesIntersection modelCoordinates, AnchorsIntersection anchors,
                                    JPanel drawingPanel) {
        this.model = model;
        this.modelCoordinates = modelCoordinates;
        this.anchors = anchors;
        this.drawingPanel = drawingPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(125, 149, 128), 1),
                        "Параметры сопряжения",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 14),
                        new Color(60, 60, 60)
                )
        ));
        setBackground(PANEL_BG);
        setPreferredSize(new Dimension(320, 580));

        // Горная выработка №1
        add(createSectionPanel("Выработка №1"));
        add(Box.createVerticalStrut(3));
        add(createParameterRow("Ширина (м):", width1Field = createTextField(String.valueOf(model.getWidth1()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Высота (м):", height1Field = createTextField(String.valueOf(model.getHeight1()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Азимут (градусы):", azimuth1Field = createTextField(String.valueOf(model.getAzimuthDegrees1()))));
        add(Box.createVerticalStrut(10));

        // Горная выработка №2
        add(createSectionPanel("Выработка №2"));;
        add(Box.createVerticalStrut(3));
        add(createParameterRow("Ширина (м):", width2Field = createTextField(String.valueOf(model.getWidth2()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Высота (м):", height2Field = createTextField(String.valueOf(model.getHeight2()))));
        add(Box.createVerticalStrut(10));

        // Коэффициент формы сопряжения
        add(createSectionPanel("Параметры сопряжения"));
        add(Box.createVerticalStrut(3));
        add(createParameterRow("Коэффициент формы:", formField = createTextField(String.valueOf(model.getFormIndicationIntersection()))));
        add(Box.createVerticalStrut(10));

        // Анкерное крепление выработки №1
        add(createSectionPanel("Анкеры - Выработка №1"));
        add(Box.createVerticalStrut(3));
        add(createParameterRow("Длина анкера (м):", lengthAnchor1Field = createTextField(String.valueOf(anchors.getLengthAnchor1()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Шаг анкеров (м):", step1Field = createTextField(String.valueOf(anchors.getStep1()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Между рядами (м):", distanceBetweenRows1Field = createTextField(String.valueOf(anchors.getDistanceBetweenRows1()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Подъем анкера (м):", distanceLowerAnchor1Field = createTextField(String.valueOf(anchors.getDistanceLowerAnchor1()))));
        add(Box.createVerticalStrut(10));

        // Анкерное крепление выработки №2
        add(createSectionPanel("Анкеры - Выработка №2"));
        add(Box.createVerticalStrut(3));
        add(createParameterRow("Длина анкера (м):", lengthAnchor2Field = createTextField(String.valueOf(anchors.getLengthAnchor2()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Шаг анкеров (м):", step2Field = createTextField(String.valueOf(anchors.getStep2()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Между рядами (м):", distanceBetweenRows2Field = createTextField(String.valueOf(anchors.getDistanceBetweenRows2()))));
        add(Box.createVerticalStrut(5));
        add(createParameterRow("Подъем анкера (м):", distanceLowerAnchor2Field = createTextField(String.valueOf(anchors.getDistanceLowerAnchor2()))));
        add(Box.createVerticalStrut(15));

        JButton applyButton = createButton("Применить");
        applyButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        applyButton.addActionListener(e -> applyChanges());

// Оборачиваем кнопку в панель с отступом
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(PANEL_BG);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        buttonPanel.add(applyButton);
        add(buttonPanel);

        add(Box.createVerticalStrut(5));
    }

    private JPanel createParameterRow(String labelText, JTextField field) {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(PANEL_BG);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        row.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Добавляем отступы

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(new Color(60, 60, 60));

        row.add(label, BorderLayout.WEST);
        row.add(field, BorderLayout.EAST);

        return row;
    }

    private JPanel createSectionPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PANEL_BG);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(new Color(60, 60, 60));

        panel.add(label, BorderLayout.WEST);
        return panel;
    }

    private JTextField createTextField(String value) {
        JTextField field = new JTextField(value);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBackground(FIELD_BG);
        field.setForeground(new Color(60, 60, 60));
        field.setPreferredSize(new Dimension(120, 28));
        field.setMinimumSize(new Dimension(120, 28));
        field.setMaximumSize(new Dimension(120, 28));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(125, 149, 128), 1),
                BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
        return field;
    }



    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BUTTON_BG);
        button.setForeground(BUTTON_FG);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(140, 35));
        button.setMinimumSize(new Dimension(140, 35));
        button.setMaximumSize(new Dimension(140, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(65, 89, 68));
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

        // Применяем параметры выработок
        try {
            double width1 = Double.parseDouble(width1Field.getText().trim());
            double height1 = Double.parseDouble(height1Field.getText().trim());
            int azimuth1 = Integer.parseInt(azimuth1Field.getText().trim());
            double width2 = Double.parseDouble(width2Field.getText().trim());
            double height2 = Double.parseDouble(height2Field.getText().trim());
            double formIntersection = Double.parseDouble(formField.getText().trim());

            if (width1 >= 2 && width1 <= 8 && height1 >= 2 && height1 <= 8 &&
                    width2 >= 2 && width2 <= 8 && height2 >= 2 && height2 <= 8 &&
                    formIntersection >= 1.5 && formIntersection <= 8 &&
                    azimuth1 >= -45 && azimuth1 <= 45) {

                model.setWidth1(width1);
                model.setHeight1(height1);
                model.setAzimuthDegrees1(azimuth1);
                model.setWidth2(width2);
                model.setHeight2(height2);
                model.setWidth3(width2);
                model.setHeight3(height2);
                model.setFormIndicationIntersection(formIntersection);
                modelCoordinates.updateCoordinates();
            } else {
                errorMessage.append("Ошибка в параметрах выработок!\n");
                errorMessage.append("Ширина и высота должны быть в диапазоне 2-8 м\n");
                errorMessage.append("Азимут должен быть в диапазоне от -45 до 45 градусов\n");
                errorMessage.append("Коэффициент формы сопряжения должен быть 1.5-8\n");
                excavationValid = false;
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Параметры выработок: введите корректные числа!\n");
            excavationValid = false;
        }

        // Применяем параметры анкерного крепления
        try {
            double lengthAnchor1 = Double.parseDouble(lengthAnchor1Field.getText().trim());
            double step1 = Double.parseDouble(step1Field.getText().trim());
            double distanceBetweenRows1 = Double.parseDouble(distanceBetweenRows1Field.getText().trim());
            double distanceLowerAnchor1 = Double.parseDouble(distanceLowerAnchor1Field.getText().trim());

            double lengthAnchor2 = Double.parseDouble(lengthAnchor2Field.getText().trim());
            double step2 = Double.parseDouble(step2Field.getText().trim());
            double distanceBetweenRows2 = Double.parseDouble(distanceBetweenRows2Field.getText().trim());
            double distanceLowerAnchor2 = Double.parseDouble(distanceLowerAnchor2Field.getText().trim());

            if (lengthAnchor1 > 0 && step1 > 0 && distanceBetweenRows1 > 0 && distanceLowerAnchor1 > 0 &&
                    lengthAnchor2 > 0 && step2 > 0 && distanceBetweenRows2 > 0 && distanceLowerAnchor2 > 0) {

                anchors.setLengthAnchor1(lengthAnchor1);
                anchors.setStep1(step1);
                anchors.setDistanceBetweenRows1(distanceBetweenRows1);
                anchors.setDistanceLowerAnchor1(distanceLowerAnchor1);

                anchors.setLengthAnchor2(lengthAnchor2);
                anchors.setStep2(step2);
                anchors.setDistanceBetweenRows2(distanceBetweenRows2);
                anchors.setDistanceLowerAnchor2(distanceLowerAnchor2);

                anchors.setLengthAnchor3(lengthAnchor2);
                anchors.setStep3(step2);
                anchors.setDistanceBetweenRows3(distanceBetweenRows2);
                anchors.setDistanceLowerAnchor3(distanceLowerAnchor2);
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