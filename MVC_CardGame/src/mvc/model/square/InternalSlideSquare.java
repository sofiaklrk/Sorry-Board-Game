package mvc.model.square;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to create
 * the Internal slide square
 * @version 1.0
 * @author csd5153
 */
public class InternalSlideSquare extends SlideSquare{
    /**
     * Draws an image at the specified grid position along the perimeter.
     * The type of image is determined by the position and specific conditions.
     *
     g      The Graphics object on which to draw the image.
     i      The x-coordinate (column) of the grid position.
     j      The y-coordinate (row) of the grid position.
     startX The starting x-coordinate for the grid.
     startY The starting y-coordinate for the grid.
     */

    public void drawInternalSlideSquare(Graphics g) {


        imageT="Medium.png";
        imageR+=imageT;
        imageY+=imageT;
        imageB+=imageT;
        imageG+=imageT;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (isOnPerimeter(i, j)) {

                    if ((i==2||i==3||(i>=10&&i<=12)) && j==0){
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageR);

                    } else if ((i==13||i==12||(i<=5&&i>=3))&& j!=0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageY);

                    } else if (((j==2||j==3)||(j<=12&&j>9)) && i!=0) {

                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageB);

                    } else if ((j<6&&j>2||j==12||j==13)&& i==0) {

                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageG);

                    }
                }
            }
        }
    }
    /**
     * The internalSlideSquare method is a utility method that draws and paints
     * the InternalSlideSquare component on the specified Graphics object.
     * It creates an instance of the InternalSlideSquare class and invokes its
     * drawInternalSlideSquare method to render the InternalSlideSquare on the graphics
     * context.
     *
     * @param g The Graphics object on which the InternalSlideSquare is to be drawn.
     *          It represents the drawing surface.
     */
    public static void internalSlideSquare(Graphics g){
        InternalSlideSquare inslsq = new InternalSlideSquare();
        inslsq.drawInternalSlideSquare(g);
    }
}
