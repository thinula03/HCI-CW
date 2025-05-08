package org.example.ui;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class DesignManager {

    public static void saveDesign(JFrame parentFrame, String shape, int width, int length, String color, List<String> furnitureList) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Room Design");
        fileChooser.setSelectedFile(new File("my_design.roomcraft"));

        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileToSave))) {
                writer.println("Room Shape: " + shape);
                writer.println("Width: " + width);
                writer.println("Length: " + length);
                writer.println("Color: " + color);
                writer.println("Furniture:");
                for (String item : furnitureList) {
                    writer.println("- " + item);
                }

                JOptionPane.showMessageDialog(parentFrame, "Design saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void loadDesign(JFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Room Design");

        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileToLoad))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                JTextArea textArea = new JTextArea(content.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(parentFrame, new JScrollPane(textArea), "Loaded Design", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Error loading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}