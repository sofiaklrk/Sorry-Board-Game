


package mvc.view;

import mvc.model.board.Board;
import mvc.model.card.Card;
import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.player.Player;
import mvc.model.square.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static mvc.model.deck.Deck.options;
import static mvc.model.deck.Deck.result;

/**
 * The main class representing the Square of Squares application.
 * It extends JFrame and contains the graphical user interface for the game.
 */
public class View extends JFrame {
    private BufferedImage backgroundImage;
    private JLabel backgroundLabel;
    Graphics g;
    /**the cards button: shows the current card*/
    private JButton[] playerCards = new JButton[14];//*2
    /**the player's last card*/
    private JButton playerLastCard = new JButton();
    private JLabel[] positions;
    private static JLayeredPane basic_panel;
    private JLayeredPane player1;
    //ClassLoader for loading resources
    private static ClassLoader cldr;
    boolean enabled = true;
    static JLabel pawn;
    JTextArea infobox;
    private static final int SQUARE_SIZE = 40;
    private static final int SQUAREBIG_SIZE = 80;

    private static final int PERIMETER_SIZE = 1/2; // Black perimeter size
    private static final int GRID_SIZE = 16; // Number of squares per side

    Image image;
    Card lastCardPlayed;
    Player Redplayer;
    Player Yellowplayer;

    static Pawn pawn1;
    static Pawn pawn2;
    static Pawn pawnv1;
    static Pawn pawnv2;
    static String imgpawn1;
    static String imgpawn2;
    static String imgpawnv1;
    static String imgpawnv2;

    static Color color1;
    static Color color2;
    int position;

    static ArrayList<Card> gameCards = new ArrayList<Card>();

    /*
     */
/**
 * Gets the game cards.
 *
 * @return the ArrayList of game cards.
 */
    public ArrayList<Card> getGameCards() {
        return gameCards;
    }

/**
 * Sets the game cards.
 *
 * @param gameCards the ArrayList of game cards to set.
 */
    public void setGameCards(ArrayList<Card> gameCards) {
        this.gameCards = gameCards;
    }

    /**checks if cards have finished and shuffle them*/
    public static void checkCards(){
        if (Card.getCards().isEmpty()){
            Collections.shuffle(gameCards);
        }
    }
    /**
     * Updates the display for a specific player card
     * @param c the card to be desplayed
     * @param position the position of the card in the player's hand*/
    public void updateCard(Card c, int position) {
        URL imageURL2 = cldr.getResource(c.getImage()); //image
        Image image2 = new ImageIcon(imageURL2).getImage();
        image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
        playerCards[position].setIcon(new ImageIcon(image2));
        basic_panel.repaint();

    }
    /**
     * gets the player cards
     * @return the array of player cards*/

    public JButton[] getPlayerCards() {
        return playerCards;
    }


/**
 * <b>Transformer:</b> sets the player's last Card
 * <b>Post-condition:</b> player's last Card has been set
 * @param  c
 */

    public void setLastCard(Card c) {
        URL imageURL2 = cldr.getResource(c.getImage()); //image
        Image image2 = new ImageIcon(imageURL2).getImage();
        image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
        playerLastCard.setIcon(new ImageIcon(image2));
    }

    /**
     * Initializes the player cards based ono the provided list of cards
     * @param cards the list of cards to initialize*/

    public void initCards(ArrayList<Card> cards) {
        int numberOfCards = Math.min(cards.size(), 11);
        for (int i = 0; i <= 3; i++) {
            playerCards[i] = new JButton();
            playerCards[i].setName(Integer.toString(i));
            playerCards[i].setBounds(10 + i * 70, 10, 60, 70);
            if (i<cards.size()){
                URL imageURL2 = cldr.getResource(cards.get(i).getImage()); //image
                assert imageURL2 != null;
                Image image2 = new ImageIcon(imageURL2).getImage();
                image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
                playerCards[i].setIcon(new ImageIcon(image2));
            }

URL imageURL2 = cldr.getResource(cards.get(i).getImage()); //image
            Image image2 = new ImageIcon(imageURL2).getImage();
            image2 = image2.getScaledInstance(60, 70, java.awt.Image.SCALE_SMOOTH);
            playerCards[i].setIcon(new ImageIcon(image2));

            //playerCards[i].setBackground(Color.white);
            player1.add(playerCards[i], 0);
        }
        playerLastCard.setBounds(550, 210, 60, 70);
        player1.add(playerLastCard);

        JLabel label = new JLabel("Receive Card");
        label.setBounds(550, 300, 100, 10);
        player1.add(label);
    }

    /**
     * Updates the display to show the player's pawn at a specific position
     * @param position the position on the game board*/

    public void updatePawn(int position) {
        pawn.setBounds(5, 5,50, 60);
        positions[position].add(pawn, 0);
        basic_panel.repaint();
    }

/**
 * initializes the game board with player pawns and labels*/


    public void updateInfobox(String message) {
        infobox.setText(message);
        basic_panel.repaint();
    }

    /**
     * Displays a winning message using a dialog box.
     *
     * @param message The message to be displayed in the dialog box.
     */

    public void showWinningMessage(String message) {
        JOptionPane.showMessageDialog(this, message);

    }




    /**
     * <b>Accessor:</b> checks if the game has finished
     * <b>Post-condition:</b> game's status has been set
     * @return true if it has finished, false otherwise*/
    public boolean EndGame(){
        if (Redplayer.isHasFinished() || Yellowplayer.isHasFinished()) {
            return true;
        } else {
            return false;
        }
    }
    /**<b>Accessor:</b> checks if player can move or change positions with his opponent
     * <b>Post-condition:<b/> player's choice has been set
     * @return  flag TRUE if he can move, FALSE otherwise*/
    public static boolean Move(Pawn pawn1, Pawn pawn2, Pawn pawnv1, Pawn pawnv2){
        //checks if player can move or doesn't want to
        boolean flag = false;
        //True if he wants to move , false otherwise
        return flag;

    }
    /**
     * presses the fold button to change the turn*/
    public static void foldB(){
        boolean flag =Move(pawn1, pawn2, pawnv1, pawnv2);
        if (!flag) {
            //press the button
        }
    }

    /**
     * <b>Transformer:</b> sets player's new position
     * <b>Post-condition:</b> player's new position has been set
     * @param position*/
    public static void MovePlayer(int position){
        if (Move(pawn1, pawn2, pawnv1, pawnv2)){
            // this.position = position;
        }
        //moves player
    }

    /**
     * <b>Accessor:</b> sets players' pawns, images and colors
     * <b>Post-condition:</b> players' pawns,images and colors have been set
     * @return pawn1 first pawn red player
     * @return pawn2 second pawn red player
     * @return pawnv1 first pawn yellow player
     * @return pawnv2 second pawn yellow player
     * @return color1 red player
     * @return color2 yellow player
     * @return imgpawn1 first pawn red player
     * @return imgpawn2 second pawn red player
     * @return imgpawnv1 first pawn yellow player
     * @return imgpawnv2 second pawn yellow player
     * */
    public static void initPawns(){
        Player.getPawn(pawn1);
        Player.getPawn(pawn2);
        Player.getPawn(pawnv1);
        Player.getPawn(pawnv2);
        Player.getPawnColor(color1);
        Player.getPawnColor(color2);
        /*Player.getImage(imgpawn1);
        Player.getImage(imgpawn2);
        Player.getImage(imgpawnv1);
        Player.getImage(imgpawnv2);*/

    }


    /**
     * Constructs a new SquareOfSquares instance.
     * Sets up the initial properties of the frame and adds a SquarePanel to it.
     */
    public View() {
        //new Deck().setVisible(true);

        setTitle("Sorry Game");
        setSize(1035,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //new Deck().setVisible(true);
        Board.initCards();
        checkCards();
        initPawns();
        MovePlayer(position);
        foldB();

        SquarePanel squarePanel = new SquarePanel();
        add(squarePanel);
        squarePanel.setVisible(true);
        //squarePanel.view();
        //add(squarePanel.view());

        setLocationRelativeTo(null); // Center the JFrame
        /*Square.square(g);
        SafetyZoneSquare.safetyZoneSquare(g);
        StartSlideSquare.startSlideSquare(g);
        InternalSlideSquare.internalSlideSquare(g);
        EndSlideSquare.endSlideSquare(g);
        HomeSquare.homeSquare(g);

        StartSquare.startSquare(g);*/

    }

    /**
     * Gets the last card played on the board.
     *
     * @return the last card played.
     */
    public Card getLastCardPlayed() {
        return lastCardPlayed;
    }

    /**
     * Moves a player on the board based on a card's value.
     *
     * @param player the player to move.
     * @param c the card used for the movement.
     * @return {@code true} if the player successfully moved, {@code false} otherwise.
     */
    public boolean movePlayer(Player player, Card c){
        if(player.getPosition()+c.getValue()>9)
            return false;
        player.movePosition(c.getValue());
        return true;
    }

    /**
     * Sets the last card played on the board.
     *
     * @param lastCardPlayed the last card played.
     */
    public void setLastCardPlayed(Card lastCardPlayed) {
        this.lastCardPlayed = lastCardPlayed;
    }

    /**
     * The main method to launch the SquareOfSquares application.
     * Creates an instance of SquareOfSquares and sets it to be visible.
     *
     * @param args Command-line arguments .
     */
    public static void main(String[] args) {
        result = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        // Check the user's choice
        if (result == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + options[result]);
            SwingUtilities.invokeLater(() -> {
                 new Deck().setVisible(true);
            });
        }
        /*SwingUtilities.invokeLater(() -> {
            new View().setVisible(true);
        });*/
    }

    /**The SquarePanel class represents a JPanel that encapsulates various square components
     * such as HomeSquare,StartSquare,Square,StartSlideSquare,InternalSlideSquare,EndSlideSquare
     * and SafetyZoneSquare. It provides a method {@code squarePanel()} to draw and paint these
     * square components on the panel*/
    public class SquarePanel extends JPanel {

        /**Instances of square components*/
        HomeSquare homeSquare = new HomeSquare();
        StartSquare startSquare = new StartSquare();
        Square square = new Square() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                /*square.drawImageInCenter2(g,"images/background.png",1405,10,500,1300);
                square.drawImageInCenter2(g,"images/cards/backCard.png",1070,380,100,130);
                homeSquare.drawCustomSquare(g,680,400,200);
*/
            }
        };
        StartSlideSquare startSlideSquare = new StartSlideSquare();
        InternalSlideSquare internalSlideSquare = new InternalSlideSquare();
        EndSlideSquare endSlideSquare = new EndSlideSquare();
        SafetyZoneSquare safetyZoneSquare = new SafetyZoneSquare();

        /**Draws and paints the square components on the panel.This method is responsible
         * for rendering the various square elements on the panel, including the HomeSquare,
         * StartSquare,Square,StartSlideSquare, InternalSlideSquare, EndSlideSquare and SafetyZoneSquare.*/
        public void squarePanel(){
            /**Draw and paint each square component on the panel*/
            square.drawSquareOfSquares(g);
            homeSquare.paintComponent(g);
            startSquare.paintComponent(g);
            startSlideSquare.drawStartSlideSquare(g);
            internalSlideSquare.drawInternalSlideSquare(g);
            endSlideSquare.drawEndSlideSquare(g);
            safetyZoneSquare.drawSafetyZoneSquare(g);
        }
    }
}