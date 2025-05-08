package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class FurniturePanel extends JPanel {
    private final DefaultListModel<String> furnitureModel;
    private final JList<String> furnitureList;
    private final JTextField newItemField;

    public FurniturePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Furniture Manager"));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newItemField = new JTextField(20);
        JButton addButton = new JButton("Add");
        inputPanel.add(new JLabel("New Furniture:"));
        inputPanel.add(newItemField);
        inputPanel.add(addButton);

        furnitureModel = new DefaultListModel<>();
        furnitureList = new JList<>(furnitureModel);
        JScrollPane scrollPane = new JScrollPane(furnitureList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Available Furniture"));

        JButton removeButton = new JButton("Remove Selected");
        removeButton.setEnabled(false);

        furnitureList.addListSelectionListener(e -> removeButton.setEnabled(!furnitureList.isSelectionEmpty()));

        addButton.addActionListener(e -> {
            String item = newItemField.getText().trim();
            if (!item.isEmpty() && !furnitureModel.contains(item)) {
                furnitureModel.addElement(item);
                newItemField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = furnitureList.getSelectedIndex();
            if (selectedIndex != -1) {
                furnitureModel.remove(selectedIndex);
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);
    }

    public java.util.List<String> getFurnitureList() {
    return new ArrayList<>(Collections.list(furnitureModel.elements()));
}
}
