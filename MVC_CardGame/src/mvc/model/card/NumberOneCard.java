package mvc.model.card;


import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;

/**
 * this class containt the methods signatures needed in order to create
 * the number card 1
 * @version 1.0
 * @author csd5153
 */
public class NumberOneCard extends NumberCard{
    //Pawn pawn;
    //int position1=1;

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
     * @param direction *//*
    public int getDirection(int direction){
        return direction;
    }*/

    /**the image path for card 1*/
    //private String image = "images/cards/card1.png";
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
     * <b>Accessor:</b> checks player's position to see if he can move
     * <b>Post-condition:</b> player's position has been checked
     * @return true if he can move, false otherwise*/
    public static boolean PawnsPosition(Pawn pawn, Graphics g){
        //checks if pawn's position is on the start square or if he can move 1 position front
        int pos = Player.position=1;
        if (Player.Check(pos,g)){
            return false;
        }else{
            return true;
        }
        //return true;//if it is, false otherwise
    }
    /**Constructor for the implementation of card1 (1 position front)*/
    public NumberOneCard(Graphics g){
        Card.image+="1.png";
        NumberCard.direction = 1;
        setImage(image);
        getDirection(NumberCard.direction);
        if (PawnsPosition(pawn,g)){
            setPosition(Player.position+1);
        }else{
            //press the fold button
        }
    }
}
