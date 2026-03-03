package mvc.model.card;


import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import java.awt.*;

/**
 * this class containt the methods signatures needed in order to create
 * the number card 2
 * @version 1.0
 * @author csd5153
 */
public class NumberTwoCard extends NumberCard{
    //Pawn pawn;
    Card card;
    /**the image path for card 2*/
    //private static String image = "images/cards/card2.png";
     /*
    *//**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     *//*
    public String getImage() {
        return image;
    }

    *//**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image
     *//*
    public void setImage(String image) {
        this.image = image;
    }*/

    /**
     *the player's pawn direction  */
    //private int direction= 1;// 1 for front
/*    *//**<b>Transformer:</b> sets the direction of pawn
     * <b>Post-condition</b> the pawn's direction has been set
     * @param direction 1 for front *//*
    public void setDirection(int direction){
        this.direction = direction;
    }
    *//**
     * <b>Accessor:</b> returns the direction of pawn
     * <b>Post-condition:</b> the pawn's direction has been set
     * @param direction *//*
    public int getDirection(int direction){
        return direction;
    }*/


    /**
     * <b>Accessor:</b> checks player's position to see if he can move
     * <b>Post-condition:</b> player's position has been checked
     * @return true if he can move, false otherwise*/
    public boolean PawnsPosition(Pawn pawn, Graphics g){
        //checks if pawn's position is on the start square or if he can move 2 position front
        int pos = Player.position=2;
        do {
            if (Player.Check(pos,g)){
                //moves
            }else{
                //press the fold button ?????? ksanapairnei karta o idios paikths
            }
            card = new Card();

            //take new card and play again
        }while(value!=2);
        if (value!=2){
            if (Player.Check(pos,g)){
                //moves
            }else{
                //press the fold button
            }
        }
        return true;//if it is, false otherwise
    }
    /**
     * <b>Transformer:</b> sets new card's value
     * <b>Post-condition:</b> new card's value has been set
     * @param card*/
    public void PlayAgain(Pawn pawn, Card card){
        do {
            card = new Card();
            //take new card and play again
        }while(card.value!=2);

    }
    /**Constructor for the implementation of card2 (2 position front). initializes the image,position and direction
     * in this case the player has to play again until the new card is not 2*/
    public NumberTwoCard(Graphics g){

        image+="2.png";
        setImage(image);
        NumberCard.direction = 1;
        setDirection(NumberCard.direction);
        if (PawnsPosition(Card.pawn,g)){
            setPosition(Player.position+2);
            //move +2
        }else{
            //press the fold button
        }
        //card = new Card();
        PlayAgain(Card.pawn, card);
    }

}
