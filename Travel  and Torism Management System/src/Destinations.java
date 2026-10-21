import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread t1;
    // Creating an array of 10 labels to hold the images
    JLabel[] label = new JLabel[10];

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (label[i] != null) {
                    label[i].setVisible(true);
                    Thread.sleep(2500); // Wait 2.5 seconds
                    label[i].setVisible(false);
                }
            }
            this.setVisible(false); // Close the frame after slideshow ends
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        String[] extensions = {".jpg", ".jpeg", ".png", ".JPG", ".PNG"};

        for (int i = 0; i < 10; i++) {
            ImageIcon i1 = null;
            java.net.URL imageURL = null;

            // Smart Loop: Try different extensions for each image
            for (String ext : extensions) {
                imageURL = getClass().getResource("/icons/dest" + (i + 1) + ext);
                if (imageURL != null) {
                    break; // Stop looking once the file is found
                }
            }

            if (imageURL != null) {
                i1 = new ImageIcon(imageURL);
                Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                label[i] = new JLabel(i3);
                label[i].setBounds(0, 0, 800, 600);
                add(label[i]);
                label[i].setVisible(false); // Hide all initially
            } else {
                // Fallback: If no image is found, create a blank label to avoid NullPointer in run()
                System.out.println("Warning: Could not find dest" + (i + 1) + " with any supported extension.");
                label[i] = new JLabel();
            }
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}