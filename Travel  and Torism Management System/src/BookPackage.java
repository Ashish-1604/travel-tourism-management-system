import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    JButton btnCheck, btnBook, btnBack;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
    JTextField tfPersons;
    JComboBox<String> comboPackage;
    String username;

    BookPackage(String username) {
        this.username = username;
        setBounds(150, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setFont(new Font("Yu Mincho", Font.BOLD, 30));
        text.setBounds(100, 10, 300, 50);
        add(text);


        JLabel lbluser = new JLabel("Username:");
        lbluser.setBounds(40, 70, 150, 20);
        add(lbluser);

        labelusername = new JLabel(username);
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package:");
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        comboPackage = new JComboBox<>(new String[]{"Gold Package", "Silver Package", "Bronze Package"});
        comboPackage.setBounds(250, 110, 200, 20);
        add(comboPackage);

        JLabel lblpersons = new JLabel("Total Persons:");
        lblpersons.setBounds(40, 150, 150, 20);
        add(lblpersons);

        tfPersons = new JTextField("1");
        tfPersons.setBounds(250, 150, 200, 20);
        add(tfPersons);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(40, 190, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 20);
        add(labelid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(40, 230, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 200, 20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 20);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price:");
        lbltotal.setBounds(40, 310, 150, 20);
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setForeground(Color.RED);
        labeltotal.setBounds(250, 310, 200, 20);
        add(labeltotal);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()) {
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Buttons ---
        btnCheck = new JButton("Check Price");
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setBounds(60, 380, 120, 25);
        btnCheck.addActionListener(this);
        add(btnCheck);

        btnBook = new JButton("Book Package");
        btnBook.setBackground(Color.BLACK);
        btnBook.setForeground(Color.WHITE);
        btnBook.setBounds(200, 380, 150, 25);
        btnBook.addActionListener(this);
        add(btnBook);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(370, 380, 120, 25);
        btnBack.addActionListener(this);
        add(btnBack);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCheck) {
            String pack = (String) comboPackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 25000;
            } else {
                cost += 32000;
            }

            int persons = Integer.parseInt(tfPersons.getText());
            cost *= persons;
            labeltotal.setText("Rs " + cost);

        } else if (ae.getSource() == btnBook) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+comboPackage.getSelectedItem()+"', '"+tfPersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("tomcruse007");
    }
}