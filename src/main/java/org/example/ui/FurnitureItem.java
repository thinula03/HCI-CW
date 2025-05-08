package org.example.ui;

import java.awt.*;

public class FurnitureItem {
    private final String name;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;

    public FurnitureItem(String name, int x, int y, int width, int height, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.drawString(name, x + 5, y + 15);
    }

    public String getName() {
        return name;
    }
}