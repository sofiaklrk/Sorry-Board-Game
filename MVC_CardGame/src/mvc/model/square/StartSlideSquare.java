package mvc.model.square;

import mvc.model.pawn.Pawn;
import mvc.model.pawn.PawnColor;
import mvc.model.player.Player;

import java.awt.*;

/**
 * The StartSlideSquare class represents a slide square at the starting positions.
 * It extends the SlideSquare class and provides a method to draw the slide square with specific images.
 */
public class StartSlideSquare extends SlideSquare{

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

    public void drawStartSlideSquare(Graphics g) {

        imageT="Start.png";
        imageR+=imageT;
        imageY+=imageT;
        imageB+=imageT;
        imageG+=imageT;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (isOnPerimeter(i, j)) {
                    if ((i==1||i==9) && j==0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageR);
                    } else if ((i==6||i==14)&& j!=0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageY);

                    } else if ((j==1||j==9) && i!=0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageB);

                    } else if ((j==6||j==14)&& i==0) {
                        drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, imageG);

                    }else {
                        drawSquare(g, startX + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, Color.WHITE);

                    }
                }
            }
            if (current!= PawnColor.color){
                Pawn.movePosition(position);
                //moves pawn to the end of slide (+3 or +4 moves)
            }
            if (true){//pawn,pawn2,pawnv,pawnv2 positoins are on the slide){
                //pawns go to start
            }
    }
   /* public static void startSlideSquare(Graphics g){
        StartSlideSquare sslsq = new StartSlideSquare();
        sslsq.drawStartSlideSquare(g);
    }*/
    }
}
