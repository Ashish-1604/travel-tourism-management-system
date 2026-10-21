import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setTitle("Travel Management System - Packages");
        setBounds(450, 200, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();

        // Define our packages
        String[] p1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000/-", "package1.jpg"};
        String[] p2 = {"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free Entrance", "Meet and Greet at Aiport", "Welcome Drinks", "Night Safari", "Cruise with Dinner", "English Speaking Guide", "BOOK NOW", "Winter Special", "Rs 24000/-", "package2.jpg"};
        String[] p3 = {"BRONZE PACKAGE", "3 Days and 4 Nights", "Return Airfare", "Free Hotel Stay", "Horse Riding & Activities", "River Rafting", "Hard Drinks Free", "Daily Guide", "BOOK NOW", "Monsoon Special", "Rs 32000/-", "package3.jpg"};

        tab.addTab("Package 1", createPackage(p1));
        tab.addTab("Package 2", createPackage(p2));
        tab.addTab("Package 3", createPackage(p3));

        add(tab);
        setVisible(true);
    }

    public JPanel createPackage(String[] data) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(250, 250, 250));

        // Package Title
        JLabel l1 = new JLabel(data[0]);
        l1.setBounds(50, 20, 400, 45);
        l1.setForeground(new Color(44, 62, 80));
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));
        p1.add(l1);

        // Styling the list of features
        int yPos = 100;
        for (int i = 1; i <= 7; i++) {
            JLabel lbl = new JLabel("✔  " + data[i]);
            lbl.setBounds(50, yPos, 400, 30);
            lbl.setForeground(new Color(39, 174, 96));
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            p1.add(lbl);
            yPos += 40;
        }

        // Action Text
        JLabel l9 = new JLabel(data[8]);
        l9.setBounds(50, 440, 300, 30);
        l9.setForeground(new Color(192, 57, 43));
        l9.setFont(new Font("Segoe UI", Font.BOLD, 25));
        p1.add(l9);

        // Seasonal Offer
        JLabel l10 = new JLabel(data[9]);
        l10.setBounds(50, 480, 300, 30);
        l10.setForeground(new Color(142, 68, 173));
        l10.setFont(new Font("Segoe UI", Font.ITALIC, 22));
        p1.add(l10);

        // Price Tag
        JLabel l11 = new JLabel(data[10]);
        l11.setBounds(600, 430, 250, 50);
        l11.setForeground(new Color(41, 128, 185));
        l11.setFont(new Font("Segoe UI", Font.BOLD, 32));
        p1.add(l11);

        // Image Handling with error check
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + data[11]));
            Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l12 = new JLabel(i3);
            l12.setBounds(400, 80, 450, 300);
            // Adding a thin border to the image
            l12.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
            p1.add(l12);
        } catch (Exception e) {
            System.out.println("Image not found: " + data[11]);
        }

        return p1;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { }

        new CheckPackage();
    }
}