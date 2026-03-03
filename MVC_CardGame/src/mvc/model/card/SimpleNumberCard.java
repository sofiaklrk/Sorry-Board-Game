package mvc.model.card;


import mvc.model.board.Board;
import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import javax.swing.*;

import static mvc.model.deck.Deck.Cards11;
import static mvc.model.deck.Deck.Ci;

/**
 * this class containt the methods signatures needed in order to create
 * a simple number card (3,5,8,12)
 * @version 1.0
 * @author csd5153
 */
public class SimpleNumberCard extends NumberCard{
    public static String text85;
    public static boolean flag85=false;
    public static String[] options8 = {"8 moves front", "take new card"};
    public static String[] options12 = {"12 moves front", "take new card"};
    public static int result85;
    public static boolean flag8=false;


    public static int numberofPawns=1;
    /**the image path for card (3,5,8,12)*/
    public static String numberC ;
    /**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }


    /**
     *the player's pawn direction  */
    private int direction= 1;// 1 for front
    /**<b>Transformer:</b> sets the direction of pawn
     * <b>Post-condition</b> the pawn's direction has been set
     * @param direction 1 for front */
    public void setDirection(int direction){
        this.direction = direction;
    }
    /**
     * <b>Accessor:</b> returns the direction of pawn
     * <b>Post-condition:</b> the pawn's direction has been set
     * @param direction */
    public int getDirection(int direction){
        return direction;
    }

    /**
     * <b>Transformer:</b> sets the simple card's value (3,5,8,12)
     * <b>Post-condition:</b> simple card's value has been set
     * @param card*/
    public void CardValue(Card card){
        value =3;
    }
    /**Constructor for the simple number card (3,5,8,12)
     * initializes the image, position , direction and the number of pawns that must move*/
    public SimpleNumberCard(Card card){
        switch (value){
            case 3:
                numberC = "3";
                position=3;
                direction=1;
                numberofPawns=2;
                //move +3 all
                break;
            case 5:
                numberC = "5";
                position=5;
                direction=1;
                numberofPawns=2;
                //move +5 all
                break;
            case 8:
                numberC = "8";
                position=8;
                direction=1;
                //or new card
                //numberofPawns=2;
                //move a pawn +8 or get new card
                break;
            default:
                numberC = "12";
                position=12;
                direction=1;
                //or new card
                //numberofPawns=1;
                //move a pawn +12 or get new card
        }
        image=numberC+".png";
    }
    /**the player can take new card if he doesnt want to move*/
    public static void Card8or12(Card card){

        if (value==8||value==12){
            Choose85();
            Player.CheckPositionsAtBoard(position, Deck.g);
            for (int i=0;i<16;i++){
                for (int j=0;j<16;j++){
                    if (Board.PawnsAtBoard[i][j].equals((Pawn.image))){

                    }
                }
            }
        }
        //move or new card
    }

    /**gives user the choice to move or take new card*/
    public static void Choose85(){
        String[] arr = new String[2];
        if (Cards11[Ci].equals("images/cards/card8.png")){
            arr = options8;
            text85="8 moves front";
        }else if (Cards11[Ci].equals("images/cards/card12.png")){
            text85="12 moves front";
            arr = options12;
        }
        result85 = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                arr,
                arr[0]
        );

        // Check the user's choice
        if (result85 == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + arr[result85]);
            if (result85==1){
                flag85 = true;
            }else{
                flag85 = false;
            }

        }
    }
    /**the cards 3 and 5 moves both player's pawns*/
    public static void Card3or5(){
        //all pawns or 1 that can move
        if (value==3||value==5){
            Player.CheckPositionsAtBoard(position, Deck.g);
            for (int i=0;i<16;i++){
                for (int j=0;j<16;j++){
                    if (Board.PawnsAtBoard[i][j].equals((Pawn.image))){

                    }
                }
            }
        }

    }

}


