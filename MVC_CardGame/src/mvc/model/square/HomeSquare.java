package mvc.model.square;

import mvc.model.deck.Deck;

import java.awt.*;
import java.util.Objects;

import static mvc.controller.Controller.options;
import static mvc.controller.Controller.result;
import static sun.audio.AudioPlayer.player;


/**
 * this class contains the methods signatures needed in order to create
 * the Home Square of each player's pawns
 * @version 1.0
 * @author csd5153
 */
public class HomeSquare extends Square {

    private String image1 = "images/pawn/redPawn1.png";
    private String image2 = "images/pawn/redPawn2.png";
    /**
     * Overrides the paintComponent method to paint the custom graphics on the panel.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        drawSquareOfSquares(g);
        drawCustomSquare(g, 490, 300, 100);//yellow
        drawCustomSquare(g, 53, 253, 100);//red
        //drawCustomSquare(g, 155, 53, 90);//red
        //drawCustomSquare(g, 435, 510, 90);//yellow
        if (Objects.equals(options[result], "3 players")){
            Deck.plPlayers=3;
            drawCustomSquare(g, 504, 143, 90);//blue start
            drawCustomSquare(g, 304, 60, 90);//blue house

        }else if (options[result].equals("4 players")){
            Deck.plPlayers=4;
            drawCustomSquare(g, 504, 143, 90);//blue start
            drawCustomSquare(g, 46, 417, 100);//green start
            drawCustomSquare(g, 304, 60, 90);//blue house
            drawCustomSquare(g, 247, 495, 90);//green house
        }

    }
    // Adjust the position and size as needed

    /**
     * Draws a custom square on the specified Graphics object at the given position and size.
     * The appearance and content of the square are determined by the provided parameters.
     *
     * @param g     The Graphics object on which to draw the custom square.
     * @param x     The x-coordinate of the top-left corner of the square.
     * @param y     The y-coordinate of the top-left corner of the square.
     * @param size  The size (width and height) of the square.
     */
    public void drawCustomSquare(Graphics g, int x, int y, int size) {
        String color = "";
        String text ="";
        int startX = (getWidth() - size * GRID_SIZE) / 2;
        int startY = (getHeight() - size * GRID_SIZE) / 2;

        if (x==490) {
            // Set the color to a custom color (e.g., red)
            color="YELLOW";
            g.setColor(Color.YELLOW);
        }else {
            color="RED";
            g.setColor(Color.RED);
        }

        text = "Home";
        if (!player.isAlive()) {
            if (color == "RED") {
                drawImageInCenter2(g, "images/pawns/redPawn1.png", 73, 253, 40, 40);
                drawImageInCenter2(g, "images/pawns/redPawn2.png", 60, 253, 40, 40);

                //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

            } else {
                drawImageInCenter2(g, "images/pawns/yellowPawn1.png", 510, 300, 40, 40);
                drawImageInCenter2(g, "images/pawns/yellowPawn2.png", 500, 300, 40, 40);

            }
        }
        // Draw the custom square at the specified position and size
        //g.fillRect(x, y, size, size);
        g.fillRect(x - 6, y - 6, size + 12, size + 12);
        g.setColor(Color.WHITE);

        // Draw the custom square at the specified position and size
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);

        Font font = new Font("Arial", Font.BOLD, 24);
        g.setFont(font);

        // Calculate the position to center the text
        FontMetrics fontMetrics = g.getFontMetrics();
        int textX = x + (size - fontMetrics.stringWidth(text)) / 2;
        int textY = y + (size + fontMetrics.getAscent() - fontMetrics.getDescent()) / 2;

        if (color=="RED"){
            g.drawString(text, textX, textY+25);
            //drawImageSquare(g, startX + 155 * SQUARE_SIZE, startY + 53 * SQUARE_SIZE, "images/pawns/redPawn1.png");

            //drawImageSquare(g, startX + 400 * SQUARE_SIZE, startY + 53 * SQUARE_SIZE, "images/pawns/redPawn1.png");

        }else {
            g.drawString(text, textX, textY-25);

        }
        // Draw the text in the center of the custom square
        //g.drawString(text, textX, textY-20);

        if (image1 != null) {
            drawImageSquare(g,510,300,image1);
            //g.drawImage(image1, x + 100, y + 100, size / 2 - 100, size - 2 * 100, this);
        }

        // Draw the second image
        if (image2 != null) {
            drawImageSquare(g,73,253,image2);
            //g.drawImage(image2, x + size / 2, y + 100, size / 2 - 100, size - 2 * 100, this);
        }
        if (currentPosition1==490||currentPosition1==53||currentPosition2==490||currentPosition2==53){
            //player is not alive, he cant move anymore
        }
        if ((currentPosition1==490||currentPosition1==53)&&(currentPosition2==490||currentPosition2==53)){
            //the player wins the game
        }
    }
    /*public void main(String[] args) {
        *//*paintComponent();
        drawCustomSquare();*//*
        *//*SwingUtilities.invokeLater(() -> {
            new SquareOfSquares().setVisible(true);
        });*//*
    }*/

    /**
     * The homeSquare method is a utility method that draws and paints
     * the HomeSquare component on the specified Graphics object.
     * It creates an instance of the HomeSquare class and invokes its
     * paintComponent method to render the HomeSquare on the graphics
     * context.
     *
     * @param g The Graphics object on which the HomeSquare is to be drawn.
     *          It represents the drawing surface.
     */
    public static void homeSquare(Graphics g){
        HomeSquare hmsq = new HomeSquare();
        hmsq.paintComponent(g);
       // hmsq.drawCustomSquare(g, 490, 300, 100);//yellow
       // hmsq.drawCustomSquare(g, 53, 253, 100);//red
       // hmsq.drawCustomSquare(g, 135, 53, 90);//red
       // hmsq.drawCustomSquare(g, 415, 510, 90);//yellow
        //drawImageSquare(g,550,10,"images/background.png");
        drawImageInCenter2(g,"images/background.png",1405,10,500,1300);
        drawImageInCenter2(g,"images/cards/backCard.png",1100,365,100,130);
        hmsq.drawCustomSquare(g,680,400,200);
        /*if (Objects.equals(Deck.options[Deck.result], "3 players")){
            Deck.plPlayers=3;
            hmsq.drawCustomSquare(g, 504, 143, 90);//blue start
            hmsq.drawCustomSquare(g, 304, 60, 90);//blue house

        }else if (Deck.options[Deck.result].equals("4 players")){
            Deck.plPlayers=4;
            hmsq.drawCustomSquare(g, 504, 143, 90);//blue start
            hmsq.drawCustomSquare(g, 46, 417, 100);//green start
            hmsq.drawCustomSquare(g, 304, 60, 90);//blue house
            hmsq.drawCustomSquare(g, 247, 495, 90);//green house
        }
*/
        /*hmsq.drawCustomSquare(g,490, 300, 100);
        hmsq.drawCustomSquare(g, 53, 253, 100);
        *//*paintComponent(g);
        drawCustomSquare(g,);*/
    }
}
