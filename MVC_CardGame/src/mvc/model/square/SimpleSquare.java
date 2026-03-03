package mvc.model.square;

import java.awt.*;

/**
 * The SimpleSquare class represents a colored square with a black border.
 * It extends the Square class and provides a static method for drawing such squares.
 */
public class SimpleSquare extends Square{
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
     * Overrides the paintComponent method of the parent class (Square).
     * This method is intentionally left empty in this subclass.
     *
     * @param g The Graphics object to paint on.
     */

    @Override
    protected void paintComponent(Graphics g) {

    }
}
