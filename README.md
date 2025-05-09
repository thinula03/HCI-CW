# 🛋️ RoomCraft – Interior Design Visualisation Tool

RoomCraft is a professional Java Swing-based desktop application designed for interior designers to create, customize, and visualize room layouts in 2D. This project was built as part of the PUSL3122 final year coursework.

## 🎯 Features

- 🔐 Designer login authentication
- 🛠️ Room Designer tab with:
  - Width, length, shape, and color input
  - Live 2D room rendering
  - Furniture placement (Chair, Table, Lamp, etc.)
- 🪑 Furniture Manager tab
  - Add/remove custom furniture items
- 📂 Saved Designs tab
  - Load `.roomcraft` text-based design files
- 💾 Save Design functionality (file-based export)
- 👤 Profile tab with logout support

## 🖥️ Technologies Used

- Java 17
- Java Swing (GUI)
- AWT Graphics2D
- JFileChooser for file saving/loading

## 📂 File Structure

```
src/
└── org/
    └── example/
        ├── Main.java
        └── ui/
            ├── LoginScreen.java
            ├── Dashboard.java
            ├── DesignPanel.java
            ├── FurniturePanel.java
            ├── SavedDesignsPanel.java
            ├── ProfilePanel.java
            ├── DesignManager.java
            └── FurnitureItem.java
```

## 📸 Screenshots

> Screenshots and `.roomcraft` file examples can be found in the report.

## 📹 Demo Video

Watch the full demo on YouTube: **https://youtu.be/4o0mvj_risI**

## 📑 Report

Download the final report (PDF): **https://drive.google.com/file/d/1g2EO-jcVBoBBWXOnrWw9S8d-JbJroD1t/view?usp=sharing Also available in the DLE Submission**

## ✅ How to Run

1. Install Java 17+ and IntelliJ IDEA (Community Edition is fine)
2. Clone or download this repository
3. Open the project in IntelliJ
4. Run `Main.java`

## 🙋 Author

**Suduwa Damsith - 10899283**  
**Jaindu Gamage - 10899309**  
University of Plymouth – Final Year Coursework  
Module: PUSL3122 – HCI, Graphics, and Visualisation

---

© 2025 RoomCraft. Created for academic use only.