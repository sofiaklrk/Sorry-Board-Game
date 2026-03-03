package mvc.model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * A Swing application that loads an image, changes red pixels to blue or green,
 * and displays the modified image in a JFrame.
 */
public class ChangeRedToBlueExample extends JFrame {

    private BufferedImage originalImage;
    private BufferedImage modifiedImage;


    /**
     * Constructs a new instance of the ChangeRedToBlueExample class.
     * Loads the original image and initializes the modified image.
     * Changes red pixels to blue and red to green.
     */
    public ChangeRedToBlueExample() {
        loadImage();
        changeRedToBlue();

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(modifiedImage, 0, 0, this);
            }
        };

        setContentPane(contentPane);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        loadImage1();
        changeRedToGreen();

        JPanel contentPane1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(modifiedImage, 10, 10, this);
            }
        };

        setContentPane(contentPane1);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Loads the original image from a file or resource.
     * Creates a copy of the original image for modification.
     */
    private void loadImage() {
        // Load the image from a file or resource
        URL imageURL = getClass().getResource("images/pawns/redPawn2.png");
        try {
            originalImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            System.out.println("Image loading failed");
        }

        // Create a copy of the original image for modification
        modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = modifiedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, null);
        g.dispose();
    }

    /**
     * Changes red pixels to blue in the modified image.
     */
    private void changeRedToBlue() {
        for (int y = 0; y < modifiedImage.getHeight(); y++) {
            for (int x = 0; x < modifiedImage.getWidth(); x++) {
                int rgb = modifiedImage.getRGB(x, y);

                // Extract individual color components
                int alpha = (rgb >> 24) & 0xFF;
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Check if the pixel is red (you can adjust the threshold based on your image)
                if (red > 150 && green < 100 && blue < 100) {
                    // Change red to blue
                    red = 0;
                    blue = 255;
                }

                // Combine color components and set the modified pixel
                int newRgb = (alpha << 24) | (red << 16) | (green << 8) | blue;
                modifiedImage.setRGB(x, y, newRgb);
            }
        }
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChangeRedToBlueExample());
    }
*/

    private BufferedImage originalImage1;
    private BufferedImage modifiedImage1;

    /**
     * Loads the original image from a file or resource.
     * Creates a copy of the original image for modification.
     */
    private void loadImage1() {
        // Load the image from a file or resource
        URL imageURL = getClass().getResource("images/pawns/redPawn2.png");
        try {
            originalImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            System.out.println("Image loading failed");
        }

        // Create a copy of the original image for modification
        modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = modifiedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, null);
        g.dispose();
    }

    /**
     * Changes red pixels to green in the modified image.
     */
    private void changeRedToGreen() {
        for (int y = 0; y < modifiedImage.getHeight(); y++) {
            for (int x = 0; x < modifiedImage.getWidth(); x++) {
                int rgb = modifiedImage.getRGB(x, y);

                // Extract individual color components
                int alpha = (rgb >> 24) & 0xFF;
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Check if the pixel is red (you can adjust the threshold based on your image)
                if (red > 150 && green < 100 && blue < 100) {
                    // Change red to green
                    red = 0;
                    green = 255;
                }

                // Combine color components and set the modified pixel
                int newRgb = (alpha << 24) | (red << 16) | (green << 8) | blue;
                modifiedImage.setRGB(x, y, newRgb);
            }
        }
    }

    /**
     * Main method to create an instance of the ChangeRedToBlueExample class.
     * Invoked on the event dispatching thread to ensure thread safety.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChangeRedToBlueExample());
    }

}
