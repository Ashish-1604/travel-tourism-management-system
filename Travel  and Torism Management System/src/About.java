import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT PROJECT");
        l1.setBounds(150, 10, 400, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        String s = "                     Travel and Tourism Management System\n\n"
                + "The objective of the Travel and Tourism Management System project is to "
                + "develop a system that automates the processes and activities of a travel "
                + "agency.\n\n"
                + "This application will help in accessing the information related to "
                + "travel to the particular destination with ease. The users can track "
                + "the information regarding their tickets, hotels, and packages.\n\n"
                + "Key Features:\n"
                + "- User Login and Signup\n"
                + "- Personal Details Management\n"
                + "- Dynamic Package Selection\n"
                + "- Hotel Booking with Price Calculation\n"
                + "- Destination Slideshow\n"
                + "- Payment Gateway Simulation\n\n"
                + "Developed by: Ashish Sonawane\n"
                + "M.Tech Data Analytics, IIT (ISM) Dhanbad";

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        t1.setFont(new Font("RaleWay", Font.PLAIN, 16));
        add(t1);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}