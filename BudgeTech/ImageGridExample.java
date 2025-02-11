
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageGridExample extends JFrame {

    public ImageGridExample() {
        setTitle("Image Grid Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Load and add images to the grid
        String[] imagePaths = {"Logo.png"};
        int row = 0, col = 0;

        for (String imagePath : imagePaths) {
            try {
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
                JLabel imageLabel = new JLabel(imageIcon);

                gbc.gridx = col;
                gbc.gridy = row;
                add(imageLabel, gbc);

                col++;
                if (col == 1) { // Change 2 to the desired number of columns
                    col = 1;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageGridExample().setVisible(true);
            }
        });
    }
}