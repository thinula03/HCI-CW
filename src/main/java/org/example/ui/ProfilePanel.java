package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProfilePanel extends JPanel {
    private final String designerName;

    public ProfilePanel(String designerName) {
        this.designerName = designerName;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Designer Profile"));

        JLabel welcomeLabel = new JLabel("Logged in as: " + designerName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);

        logoutButton.addActionListener((ActionEvent e) -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to log out?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.dispose(); // Close dashboard
                new LoginScreen().setVisible(true); // Back to login
            }
        });

        add(Box.createRigidArea(new Dimension(0, 30)));
        add(welcomeLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(logoutButton);
    }
}