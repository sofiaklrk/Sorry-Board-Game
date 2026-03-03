/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.card;

import mvc.model.board.Board;
import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.player.Player;

import java.util.ArrayList;

/**
 * this class contains the methods signatures needed in order to create either
 * a simple number card(3,5,8,12), a number card(1,2,4,7,10,11), or a sorry card
 * @version 1.0
 * @author csd5153
 */

public class Card {

    public static Pawn pawn;
    public static Board board;
    /**The pawns position*/
    public static int position=-3;
    /**
     * the card's value*/
    public static int value;

    /**the image path for cards*/
    public static String image="images/cards/card";

    /**checks if game has started*/
    static boolean startFlag= false;
    /**checks if cards has finished*/
    static boolean flag = false;
    /**pawn's position*/
    /*int position = -1;*/
    public static ArrayList<Card> cards = new ArrayList<>();

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
     * <b>Accessors:</b> sets the card's value
     * <b>Post-condition:</b> card's value has been set
     * @return value*/
    public int getValue() {
        return value;
    }

    /**
     * <b>Transformer:</b> sets the card's value
     * <b>Post-condition:</b> card's value has been set
     * @param value*/
    public void setValue(int value) {
        this.value = value;
    }



    /**
     * <b>Accessor:</b> sets the card's value
     * <b>Post-condition:</b> card's value has been set
     * @return  cards*/
    public static ArrayList<mvc.model.card.Card> getCards() {
        return cards;
    }

    /**
     * <b>Transformer:</b> adds new card
     * <b>Post-condition:</b> new card have been added
     * */
    public static void addCards(Card card) {
        cards.add(card);
    }

    /**
     * <b>Accessors:</b> sets the card's position
     * <b>Post-condition:</b> card's position has been set
     * @return position
     * */
    public static int getPosition(int position){
        return position;
    }
    /**
     * <b>Transformer:</b> sets the card's position
     * <b>Post-condition:</b> card's position has been set
     * @param position*/
    public static void setPosition(int position){
        Player.position = position;
    }


    /**
     * Constructor for the pawn's move on the board*/
    public static void movePawn(Pawn pawn, Board board){
        if (Deck.position==-3){
            startFlag = true;
        }else {
            startFlag = false;
        }
        if (startFlag)

            if (value == 1 || value == 2|| value == 13){
                flag = true;
            }else {
                flag = false;
            }
        else
            flag = false;
        /*this.position+=pawn;
        if (position==9)
            this.hasFinished=true;*/
    }

    /**constructor for the card*/
    public Card(){
        setImage(image);
        setValue(value);
        setPosition(position);
        movePawn(pawn,board);

    }

}
