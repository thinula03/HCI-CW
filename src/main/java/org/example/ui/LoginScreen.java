package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginScreen() {
        setTitle("RoomCraft – Designer Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JLabel statusLabel = new JLabel(" ", JLabel.CENTER);
        statusLabel.setForeground(Color.RED);

        panel.add(labeledField("Username:", usernameField));
        panel.add(labeledField("Password:", passwordField));
        panel.add(loginButton);
        panel.add(statusLabel);

        loginButton.addActionListener((ActionEvent e) -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.equals("admin") && pass.equals("password123")) {
                new Dashboard(user).setVisible(true);
                dispose();
            } else {
                statusLabel.setText("Invalid username or password.");
            }
        });

        add(panel);
    }

    private JPanel labeledField(String label, JComponent field) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(label), BorderLayout.NORTH);
        p.add(field, BorderLayout.CENTER);
        return p;
    }
}
