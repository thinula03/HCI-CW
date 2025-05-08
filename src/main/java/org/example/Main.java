package org.example;

import javax.swing.*;
import org.example.ui.LoginScreen;

public class Main {
    public static void main(String[] args) {
        // Set a nice look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            LoginScreen login = new LoginScreen();
            login.setVisible(true);
        });
    }
}
