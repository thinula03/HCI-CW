package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class SavedDesignsPanel extends JPanel {
    private final JTextArea displayArea;

    public SavedDesignsPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Saved Room Designs"));

        JButton loadButton = new JButton("Load Design File");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        loadButton.addActionListener(e -> loadDesignFile());

        add(loadButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadDesignFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Saved Design (.roomcraft)");
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (Scanner scanner = new Scanner(selectedFile)) {
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                displayArea.setText(content.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to load file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
