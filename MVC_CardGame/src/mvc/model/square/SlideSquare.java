package mvc.model.square;

import java.awt.*;

import static java.awt.Color.*;

/**
 * this class contains the methods signatures needed in order to create
 * the slide of square
 * @version 1.0
 * @author csd5153
 */
public class SlideSquare extends Square{
    int startX = (getWidth() - SQUARE_SIZE * GRID_SIZE) / 2;
    int startY = (getHeight() - SQUARE_SIZE * GRID_SIZE) / 2;

    String imageR = "/images/slides/redSlide";
    String imageG = "/images/slides/greenSlide";
    String imageB = "/images/slides/blueSlide";
    String imageY = "/images/slides/yellowSlide";
    String imageT;
    Color colorR = RED;
    Color colorG = GREEN;
    Color colorB = BLUE;
    Color colorY = YELLOW;
    Color current;


    @Override
    protected void paintComponent(Graphics g) {

    }
}
