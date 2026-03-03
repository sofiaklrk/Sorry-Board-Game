/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.board;
import mvc.model.card.Card;
import mvc.model.player.Player;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this class contains the methods signatures needed in order to create the board of the game
 * It manages game cards, the last card played, and player movements.
 * @version 1.0
 * @author csd5153
 */
public class Board {
/**The last card played on the board*/
    public static Card lastCardPlayed;
    /**index for the Cards11 array*/
    public static int Ci = 0;
    /**array of the number of each card*/
    public static int[] plCardsLeft = new int[11];
    /**array of cards*/
    public static String[] Cards11 = new String[11];
    /**array with the pawn's position at board*/
    public static String[][] PawnsAtBoard = PawnsPositionsAtBoard();
    /**array with the possible x*/
    public static int X[]=MakeX();
    /**array with the possible y*/
    public static int Y[]=MakeY();

    /**
     * Gets the game cards.
     *
     * @return the ArrayList of game cards.
     */
    public static ArrayList<Card> getGameCards() {
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

    /**The ArrayList of game cards*/
    public static ArrayList<Card> gameCards = new ArrayList<Card>();

    /**
     * Initializes the game cards and shuffles them.
     */
    public static void initCards() {
        for (int i = 0; i <11; i++) {
            plCardsLeft[i]=4;
            Card card = new Card();
            card.setValue(i % 4 + 1);
            if (i==5){
                Cards11[i] = "images/cards/cardSorry.png";
                card.setImage("images/cards/cardSorry.png");
            }else if (i!=5&&i!=8){
                Cards11[i] = "images/cards/card" + (i % 4 + 1) + ".png";
                card.setImage("images/cards/card" + (i % 4 + 1) + ".png");
            }
            //card.setImage("images/cards/card" + (i % 4 + 1) + ".png");
            gameCards.add(card);
        }
        Collections.shuffle(gameCards);
        double rand = ((Math.random() * 11) + 1);
        Ci = (int)rand;
        //gameCards.remove(card);
       // lastCardPlayed.setBounds(350,10,60,70);
    }
    /**
     * Gets the last card played on the board.
     *
     * @return the last card played.
     */
    public static Card getLastCardPlayed() {
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
        if(player.getPosition()+c.getValue()>12)
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


    /**<b>Accessor:</b> checks the cards
     * <b>Post-condition:</b> cards has been checked
     * @return null (if there are no more cards in the board) initialize cards and shuffles them*/
    public static Card drawCard() {
        if (!gameCards.isEmpty()) {
            return gameCards.remove(0);
        } else {
            // Handle case when there are no more cards in the board
            initCards();
            return null;
        }
    }

/**Creates a boolean array in order to help with the movements
 * @return arr a boolean array indicating the positions of pawns on the board*/
    public static boolean[][] CheckPawnss(){
        boolean[][] arr = new boolean[16][16];
        for (int i=0 ;i<16;i++){
            for (int j=0; j<16;j++){
                arr[i][j]=false;
            }
        }
        return arr;
    }

    /**Creates a String array with the pawn's position at board.
     * In the beginning of the game initializes the array with "69" because the pawns are on the start squares */
    public static String[][] PawnsPositionsAtBoard(){
        String[][] arr = new String[16][16];
        for (int i=0 ;i<16;i++){
            for (int j=0; j<16;j++){
                arr[i][j]="69";
            }
        }
        //arr[][]=
        return arr;
    }
    /**Creates an array with X coordinates
     * @return X*/
    public static int[] MakeX(){
        int[] X = new int[16];
        X[0]=-330;
        X[1]=-250;
        X[2]=-170;
        X[3]=-90;
        X[4]=-10;
        X[5]=70;
        X[6]=150;
        X[7]=230;
        X[8]=310;
        X[9]=390;
        X[10]=470;
        X[11]=550;
        X[12]=630;
        X[13]=710;
        X[14]=790;
        X[15]=780;
        return X;
    }
    /**Creates an array with Y coordinates
     * @return Y*/
    public static int[] MakeY(){
        int[] Y = new int[16];
        Y[0]=-47;
        Y[1]=33;
        Y[2]=113;
        Y[3]=193;
        Y[4]=273;
        Y[5]=353;
        Y[6]=433;
        Y[7]=513;
        Y[8]=593;
        Y[9]=673;
        Y[10]=753;
        Y[11]=833;
        Y[12]=913;
        Y[13]=993;
        Y[14]=1073;
        Y[15]=1153;
        return Y;
    }


    /**constructor: for the creation of the game's board*/
    public Board(){

    }


        
}
