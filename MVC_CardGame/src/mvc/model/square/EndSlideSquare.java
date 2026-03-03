package mvc.model.square;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to create
 * the end of the slide
 * @version 1.0
 * @author csd5153
 */
public class EndSlideSquare extends SlideSquare{
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

    public void drawEndSlideSquare(Graphics g) {


        imageT="End.png";
        imageR+=imageT;
        imageY+=imageT;
        imageB+=imageT;
        imageG+=imageT;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (isOnPerimeter(i, j)) {

                    if ((i==4||i==13)&&j==0){
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageR);

                    } else if ((i==2||i==11)&&j!=0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageY);

                    } else if (i==0&&(j==2||j==11)) {
                        drawImageSquare(g, startX-188+ i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageG);

                    } else if (i!=0&&(j==4||j==13)) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageB);

                    }
                }
            }
        }
    }

    /**
     * The endSlideSquare method is a utility method that draws and paints
     * the EndSlideSquare component on the specified Graphics object.
     * It creates an instance of the EndSlideSquare class and invokes its
     * drawEndSlideSquare method to render the EndSlideSquare on the graphics
     * context.
     *
     * @param g The Graphics object on which the EndSlideSquare is to be drawn.
     *          It represents the drawing surface.
     */
    public static void endSlideSquare(Graphics g){
        //Create an instance of EndSlideSquare
        EndSlideSquare endslsq = new EndSlideSquare();
        //Draw the EndSlideSquare
        endslsq.drawEndSlideSquare(g);
    }
}
