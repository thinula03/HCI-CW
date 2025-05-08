package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private final String designerName;

    public Dashboard(String designerName) {
        this.designerName = designerName;

        setTitle("RoomCraft – Designer Dashboard");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        // Add tab panels (you'll create these classes next)
        tabs.addTab("🛋 Room Designer", new DesignPanel());
        tabs.addTab("🪑 Furniture", new FurniturePanel());
        tabs.addTab("📂 Saved Designs", new SavedDesignsPanel());
        tabs.addTab("👤 Profile", new ProfilePanel(designerName));

        add(tabs);
    }
}
