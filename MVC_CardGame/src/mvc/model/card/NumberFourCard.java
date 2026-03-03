package mvc.model.card;


import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import java.awt.*;

/**
 * this class containt the methods signatures needed in order to create
 * the number card 4
 * @version 1.0
 * @author csd5153
 */
public class NumberFourCard extends NumberCard {
    //public static int position=4;
    /**
     *the player's pawn direction  */
    /*private int direction=-1;//-1 for back
    *//**<b>Transformer:</b> sets the direction of pawn
     * <b>Post-condition</b> the pawn's direction has been set
     * @param direction -1 for back *//*
    public void setDirection(int direction){
        this.direction = direction;
    }
    *//**
     * <b>Accessor:</b> returns the direction of pawn
     * <b>Post-condition:</b> the pawn's direction has been set
     * @param direction *//*
    public int getDirection(int direction){
        return direction;
    }

    *//**the image path for card 4*//*
    private String image = "images/cards/card4.png";
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
    }
*/
    /**
     * Constructor for the pawn's moves
     * @param pawn */
    public void NumberFourCard(Pawn pawn, Graphics g){
        image+="4.png";
        setImage(image);
        position = 4;
        NumberCard.direction=-1;
        NumberCard.CheckMove(pawn,position,direction);
        if (Player.Check(position,g)){
            //moves
        }else{
            //presses the fold button
        }
        //setPosition(position-4);
        //4 moves to the direction (-1 back)
    }
}
