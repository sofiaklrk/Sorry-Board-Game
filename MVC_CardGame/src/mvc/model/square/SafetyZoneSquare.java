package mvc.model.square;

import mvc.model.pawn.PawnColor;

import java.awt.*;

//import static oracle.jrockit.jfr.Process.current;

/**
 * this class contains the methods signatures needed in order to create
 * the Safety Zone Square of each player's pawns
 * @version 1.0
 * @author csd5153
 */
public class SafetyZoneSquare extends Square{


    /**
     * Draws the safety zone squares at the specified grid position.
     * @param g      The Graphics object on which to draw the image.
      i      The x-coordinate (column) of the grid position.
      j      The y-coordinate (row) of the grid position.
      startX The starting x-coordinate for the grid.
      startY The starting y-coordinate for the grid.
     */
    public void drawSafetyZoneSquare(Graphics g) {

        int startX = (getWidth() - SQUARE_SIZE * GRID_SIZE) / 2;
        int startY = (getHeight() - SQUARE_SIZE * GRID_SIZE) / 2;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!isOnPerimeter(i, j)){
                    if (i==2&&j==1){
                        for (int k=1;k<6;k++){
                            drawSquare(g, startX + i * SQUARE_SIZE, startY + k * SQUARE_SIZE, Color.RED);

                        }

                    } else if (i==13&&j==10) {
                        for (int k=10;k<15;k++){
                            drawSquare(g, startX + i * SQUARE_SIZE, startY + k * SQUARE_SIZE, Color.YELLOW);

                        }
                    }
                }
            }
        }
        if ((PawnColor.color==currentColor)&&(direction == 1)){
            //pawn can go to safety zone
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

    }
    /**
     * The safetyZoneSquare method is a utility method that draws and paints
     * the SafetyZoneSquare component on the specified Graphics object.
     * It creates an instance of the SafetyZoneSquare class and invokes its
     * drawSafetyZoneSquare method to render the SafetyZoneSquare on the graphics
     * context.
     *
     * @param g The Graphics object on which the SafetyZoneSquare is to be drawn.
     *          It represents the drawing surface.
     */
    public static void safetyZoneSquare(Graphics g){
        SafetyZoneSquare szsq = new SafetyZoneSquare();
        szsq.drawSafetyZoneSquare(g);
    }
}
