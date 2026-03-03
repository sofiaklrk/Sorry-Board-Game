package mvc.model.square;

import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


/**
 * this class contains the methods signatures needed in order to create
 * the  Square
 * @version 1.0
 * @author csd5153
 */
public abstract class Square extends JFrame{
    public static final int SQUARE_SIZE = 40;
    public static final int SQUAREBIG_SIZE = 80;

    public static final int PERIMETER_SIZE = 1/2; // Black perimeter size
    public static final int GRID_SIZE = 16; // Number of squares per side

    public static int position;
    public static Color currentColor;
    public static int direction;
    public static Pawn currentPawn;
    public static Player currentPlayer;
    public static int currentPosition1;//na to kanw klash me x,y
    public static int currentPosition2;
    /**
     * Draws a colored square at the specified grid position, along with a black border around it.
     *
     * @param g     The Graphics object on which to draw the square.
     * @param x     The x-coordinate (left) of the square position.
     * @param y     The y-coordinate (top) of the square position.
     * @param color The color of the square.
     */
    static void drawSquare(Graphics g, int x, int y, Color color) {
        g.setColor(color); // Set the color of the squares
        g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x - PERIMETER_SIZE, y - PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE);

    }


    /**
     * Checks if the specified grid position is on the perimeter of the grid.
     *
     * @param i The x-coordinate (column) of the grid position.
     * @param j The y-coordinate (row) of the grid position.
     * @return True if the position is on the perimeter, false otherwise.
     */
    boolean isOnPerimeter(int i, int j) {
        return i == 0 || j == 0 || i == GRID_SIZE - 1 || j == GRID_SIZE - 1;
    }
    /**
     * Draws an image in the center of the window with the specified dimensions.
     *
     * @param g             The Graphics object on which to draw the image.
     * @param imagePath     The path to the image resource.
     * @param desiredWidth  The desired width of the image.
     * @param desiredHeight The desired height of the image.
     */


    void drawImageInCenter(Graphics g, String imagePath, int desiredWidth, int desiredHeight) {
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            Image image = new ImageIcon(imageURL).getImage();

            // Calculate the position to center the image
            int x = (getWidth() - desiredWidth) / 2;
            int y = (getHeight() - desiredHeight) / 2;

            // Draw the image with the desired width and height
            g.drawImage(image, x, y, desiredWidth, desiredHeight, this);
        } else {
            // Handle image loading failure
            System.out.println("Image loading failed for: " + imagePath);
        }
    }
    /**
     * Draws an image at a specified position with the specified dimensions, adjusting for a custom center.
     *
     * @param g             The Graphics object on which to draw the image.
     * @param imagePath     The path to the image resource.
     * @param x             The x-coordinate (left) of the image position.
     * @param y             The y-coordinate (top) of the image position.
     * @param desiredWidth  The desired width of the image.
     * @param desiredHeight The desired height of the image.
     */
    public static void drawImageInCenter2(Graphics g, String imagePath, int x, int y, int desiredWidth, int desiredHeight) {
        URL imageURL = Square.class.getResource(imagePath);
        if (imageURL != null) {
            Image image = new ImageIcon(imageURL).getImage();

            // Calculate the position to center the image
                /*int x = (getWidth() - desiredWidth) / 2;
                int y = (getHeight() - desiredHeight) / 2;
*/
            x=(x-desiredWidth)/2+185;
            y=(y-desiredHeight)/2+50;
            // Draw the image with the desired width and height
            Deck.g.drawImage(image, x, y, desiredWidth, desiredHeight,null);//this instead of null
        } else {
            // Handle image loading failure
            System.out.println("Image loading failed for: " + imagePath);
        }


    }

    /**
     * Draws a square grid with a cyan background and various images and squares on the specified Graphics object.
     * The grid includes a center image and custom squares along the perimeter and certain positions.
     *
     * @param g The Graphics object on which to draw the square grid.
     */

    public void drawSquareOfSquares(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(40, 40, 600, 600);


        // Set the color to white
        g.setColor(Color.WHITE);
        //g.fillRect(50, 40, 710, 710);

        for (int i = 0; i < getWidth(); i += SQUARE_SIZE) {
            g.fillRect(i, 0, SQUARE_SIZE, SQUARE_SIZE); // Top row
            g.fillRect(i, getHeight() - SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE); // Bottom row
        }
        for (int j = 0; j < getHeight(); j += SQUARE_SIZE) {
            g.fillRect(0, j, SQUARE_SIZE, SQUARE_SIZE); // Left column
            g.fillRect(getWidth() - SQUARE_SIZE, j, SQUARE_SIZE, SQUARE_SIZE); // Right column
        }
        drawImageInCenter(g, "images/sorryImage.png",200,90);

    }

    /**
     * Draws an image at the specified grid position, along with a black border around it.
     *
     * @param g         The Graphics object on which to draw the image.
     * @param x         The x-coordinate (left) of the image position.
     * @param y         The y-coordinate (top) of the image position.
     * @param imagePath The path to the image resource.
     */
    void drawImageSquare(Graphics g, int x, int y, String imagePath) {
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            Image image = new ImageIcon(imageURL).getImage();

            // Draw the image
            g.drawImage(image, x, y, SQUARE_SIZE, SQUARE_SIZE, this);

            // Draw a black border around the image
            g.setColor(Color.BLACK);
            g.drawRect(x - PERIMETER_SIZE, y - PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE);
        } else {
            // Handle image loading failure
            System.out.println("Image loading failed for: " + imagePath);
        }
    }
    /**
     * Draws a background image, a back card image, and a custom square on the panel.
     *
     * @param g The Graphics object on which to draw the components.
     */

    protected void paintComponent(Graphics g){
        HomeSquare homeSquare = new HomeSquare();
        drawImageInCenter2(g,"images/background.png",1405,10,500,1300);
        drawImageInCenter2(g,"images/cards/backCard.png",1070,380,100,130);
        homeSquare.drawCustomSquare(g,680,400,200);

    }

    /**
     * Draws a square of squares on the panel.
     *
     * @param g The Graphics object on which to draw the square of squares.
     */
/*
    protected void paintComponent(Graphics g) {
    }*/
    public static void square(Graphics g){
        Square sq = new Square() {
            @Override
            protected void paintComponent(Graphics g) {

            }
        };
        sq.drawSquareOfSquares(g);
    }
}


