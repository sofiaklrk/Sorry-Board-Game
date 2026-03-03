package mvc.model.square;

import mvc.model.card.Card;
import mvc.model.player.Player;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to create
 * the Start Square of each player's pawns
 * @version 1.0
 * @author csd5153
 */
public class StartSquare extends Square {
        private static String image1 = "images/pawn/redPawn1.png";
        private static String image2 = "images/pawn/redPawn2.png";

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SquareOfSquares().setVisible(true);
        });
    }*/
        /**
         * Overrides the paintComponent method to paint the custom graphics on the panel.
         *
         * @param g The Graphics object used for painting.
         */
        @Override
        public void paintComponent(Graphics g) {
            //super.paintComponent(g);
            drawSquareOfSquares(g);
            //drawCustomSquare(g, 510, 300, 100);//yellow
            //drawCustomSquare(g, 73, 253, 100);//red
            drawCustomSquare(g, 135, 53, 90);//red
            drawCustomSquare(g, 415, 510, 90);//yellow
            if(true/*currentPlayer.getCards().value==1||2||sorry*/){
                //you can start the game
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
        private void drawCustomSquare(Graphics g, int x, int y, int size) {
            String color = "";
            String text ="";
            int startX = (getWidth() - size * GRID_SIZE) / 2;
            int startY = (getHeight() - size * GRID_SIZE) / 2;

            if (x==415) {
                // Set the color to a custom color (e.g., red)
                color="YELLOW";
                g.setColor(Color.YELLOW);
            }else {
                color="RED";
                g.setColor(Color.RED);
            }
                text="Start";
                /*ImageIcon a = new ImageIcon("images/pawns/redPawn1.png");
                Image b = a.getImage();
                ImageIcon c = new ImageIcon(b.getScaledInstance(40,40, Image.SCALE_DEFAULT));
                JLabel label = new JLabel();
                label.setIcon(c);
                label.setBounds(155,53, 40,40);
                add(label);*/
                if (color=="RED"){
                    drawImageInCenter2(g, "images/pawns/redPawn1.png",155,53,40,40);
                    drawImageInCenter2(g, "images/pawns/redPawn2.png",165,53,40,40);

                    //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                    //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                }else {
                    drawImageInCenter2(g, "images/pawns/yellowPawn1.png",435,510,40,40);
                    drawImageInCenter2(g, "images/pawns/yellowPawn2.png",465,510,40,40);

                }
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
                drawImageSquare(g,155,55,image1);
                //g.drawImage(image1, x + 100, y + 100, size / 2 - 100, size - 2 * 100, this);
            }

            // Draw the second image
            if (image2 != null) {

                drawImageSquare(g,455,510,image2);
                //g.drawImage(image2, x + size / 2, y + 100, size / 2 - 100, size - 2 * 100, this);
            }



        }
    /**
     * Draws the starting square on the board and handles the player's position based on the drawn card value.
     *
     * @param g The Graphics object on which to draw the starting square.
     */
        public static void startSquare(Graphics g){
            StartSquare stsq = new StartSquare();
            stsq.paintComponent(g);
            if (Card.value==1){
                Player.position=1;
                //you can move
            }else if(Card.value==2){
                Player.position=2;
                //you can move
            }else{
                //you can't
                //press fold button
            }
        }

}

