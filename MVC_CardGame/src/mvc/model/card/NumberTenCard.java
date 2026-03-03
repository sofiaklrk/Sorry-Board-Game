package mvc.model.card;


import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.player.Player;
import sun.java2d.windows.GDIRenderer;

import javax.swing.*;
import java.awt.*;

/**
 * this class containt the methods signatures needed in order to create
 * the number card 10
 * @version 1.0
 * @author csd5153
 */
public class NumberTenCard extends NumberCard{
    public static String[] options = {"10 moves front", "1 move back"};

    public static int result=0;
    /**
     *the player's pawn direction  */
    //private int direction= 1;// 1 for front
    /**<b>Transformer:</b> sets the direction of pawn
     * <b>Post-condition</b> the pawn's direction has been set
     * @param direction 1 for front */
    /*public void setDirection(int direction){
        this.direction = direction;
    }
    *//**
     * <b>Accessor:</b> returns the direction of pawn
     * <b>Post-condition:</b> the pawn's direction has been set
     * @param direction */
    /*public int getDirection(int direction){
        return direction;
    }
*/
    /**the image path for card 10*/
    //private String image = "images/cards/card10.png";
    /**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     */
  /*  public String getImage() {
        return image;
    }
*/
    /**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image
     */
  /*  public void setImage(String image) {
        this.image = image;
    }
*/
    /**
     * <b>Accessor:</b> checks if player can move 10 positions on front
     * <b>Post-condition:</b> the player's position has been cheked
     * @return true if he can move, false otherwise*/
    public boolean CheckPawnsPosition(Pawn pawn){
        //checks if pawn can move 10 positions on front
        return true;//if he can, false otherwise
    }
    /**
     * checks if he can move back 1 position and updates
     * the direction of movement*/
    public void BackMove(Pawn pawn){
        direction = -1;//to move back
        //moves pawn 1 position back if he can move
    }
    /**constructor for the implementation of card10*/
    public void Choose(Graphics g){
        new NumberTenCard();
    }
/*
    public static void main(String[] args) {
        //String[] options = {"2 players", "3 players", "4 players"};
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

   */
    /**gives user the option to make 10 moves front or 1 move back*/
    public NumberTenCard(){
        //na kanei check ta duo pionia an ginetai 10 theseis mprosta alliws 1 thesh pisw

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
                new NumberTenCard();//.setVisible(true);
            });
        }
        NumberCard.CheckMove(pawn,position,direction);
        if(Player.Check(position,Deck.g)){
            //you moved
        }else{
            //can't make a move
        }
        //setPosition(position+10);//or
        //setPosition(position-1);
    }
    /*public static void main(String[] args){

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
                new NumberTenCard(Deck.g);//.setVisible(true);
            });
        }
    }*/
}
