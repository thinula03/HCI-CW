package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DesignPanel extends JPanel {

    private final JTextField widthField;
    private final JTextField lengthField;
    private final JComboBox<String> shapeBox;
    private final JComboBox<String> colorBox;
    private final JComboBox<String> furnitureDropdown;
    private final DrawingCanvas canvas;
    private final List<FurnitureItem> placedFurniture = new ArrayList<>();

    public DesignPanel() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Room Properties"));

        widthField = new JTextField("400");
        lengthField = new JTextField("300");
        shapeBox = new JComboBox<>(new String[]{"Rectangle", "Square", "Circle"});
        colorBox = new JComboBox<>(new String[]{"Blue", "Red", "Green", "Yellow"});
        furnitureDropdown = new JComboBox<>(new String[]{"Chair", "Table", "Lamp"});

        JButton drawButton = new JButton("Draw Room");
        JButton saveButton = new JButton("Save Design");
        JButton addFurnitureButton = new JButton("Add to Room");

        formPanel.add(new JLabel("Width (px):")); formPanel.add(widthField);
        formPanel.add(new JLabel("Length (px):")); formPanel.add(lengthField);
        formPanel.add(new JLabel("Shape:")); formPanel.add(shapeBox);
        formPanel.add(new JLabel("Color Scheme:")); formPanel.add(colorBox);
        formPanel.add(new JLabel("Furniture:")); formPanel.add(furnitureDropdown);
        formPanel.add(drawButton); formPanel.add(saveButton);
        formPanel.add(new JLabel("")); formPanel.add(addFurnitureButton);

        canvas = new DrawingCanvas();

        drawButton.addActionListener(e -> canvas.repaint());

        saveButton.addActionListener(e -> {
            String shape = (String) shapeBox.getSelectedItem();
            String color = (String) colorBox.getSelectedItem();
            int width, length;
            try {
                width = Integer.parseInt(widthField.getText());
                length = Integer.parseInt(lengthField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid width or length.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<String> furnitureList = new ArrayList<>();
            for (FurnitureItem item : placedFurniture) {
                furnitureList.add(item.getName());
            }

            DesignManager.saveDesign((JFrame) SwingUtilities.getWindowAncestor(this), shape, width, length, color, furnitureList);
        });

        addFurnitureButton.addActionListener(e -> {
            String item = (String) furnitureDropdown.getSelectedItem();
            Color c = switch (item) {
                case "Chair" -> Color.PINK;
                case "Table" -> Color.ORANGE;
                case "Lamp" -> Color.MAGENTA;
                default -> Color.GRAY;
            };
            placedFurniture.add(new FurnitureItem(item, 100, 100 + placedFurniture.size() * 60, 60, 40, c));
            canvas.repaint();
        });

        add(formPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    class DrawingCanvas extends JPanel {
        public DrawingCanvas() {
            setPreferredSize(new Dimension(800, 400));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width, length;
            try {
                width = Integer.parseInt(widthField.getText());
                length = Integer.parseInt(lengthField.getText());
            } catch (Exception e) {
                g.setColor(Color.BLACK);
                g.drawString("Invalid dimensions entered.", 20, 20);
                return;
            }

            String color = (String) colorBox.getSelectedItem();
            switch (color) {
                case "Red" -> g.setColor(Color.RED);
                case "Green" -> g.setColor(Color.GREEN);
                case "Blue" -> g.setColor(Color.BLUE);
                case "Yellow" -> g.setColor(Color.YELLOW);
            }

            int x = (getWidth() - width) / 2;
            int y = (getHeight() - length) / 2;

            String shape = (String) shapeBox.getSelectedItem();
            switch (shape) {
                case "Rectangle", "Square" -> g.fillRect(x, y, width, length);
                case "Circle" -> g.fillOval(x, y, width, width);
            }

            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, length);
            g.drawString("Preview: " + shape + " (" + width + " x " + length + ")", x + 10, y + 15);

            // Draw furniture
            for (FurnitureItem f : placedFurniture) {
                f.draw(g);
            }
        }
    }
}
