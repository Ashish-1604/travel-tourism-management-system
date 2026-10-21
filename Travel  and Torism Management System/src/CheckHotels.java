import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {

    Thread t1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[]{l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};
    JLabel caption;

    public void run() {
        String[] text = new String[]{
                "JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel",
                "Radisson Blue Hotel", "Classio Hotel", "The Bay Club Hotel",
                "Breeze Haven Hotel", "The Taj Hotel", "Happy Morning Motel", "River View Hotel"
        };

        try {
            for (int i = 0; i <= 9; i++) {
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500); // Image changes every 2.5 seconds
                label[i].setVisible(false);
            }
            setVisible(false); // Close frame after slideshow ends
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels() {
        setBounds(500, 200, 800, 600);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon i1 = null, i3 = null;
        Image i2 = null;

        // Loop to initialize 10 hotel images
        for (int i = 0; i <= 9; i++) {
            i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
            i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            i3 = new ImageIcon(i2);
            label[i] = new JLabel(i3);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckHotels();
    }
}