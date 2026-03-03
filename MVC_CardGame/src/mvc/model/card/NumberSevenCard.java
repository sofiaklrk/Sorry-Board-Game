package mvc.model.card;


import mvc.model.pawn.Pawn;

/**
 * this class containt the methods signatures needed in order to create
 * the number card 7
 * @version 1.0
 * @author csd5153
 */
public class NumberSevenCard extends NumberCard{
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

    /**the image path for card 7*/
    private String image = "images/cards/card7.png";
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

    /**<b>Transformer:</b> checks if player can split the
     * 7 positions with his two pawns or if he wants to move
     * 7 positions with one pawn
     * <b>Post-condition:</b> player's choice has been set
     * @param pawn1
     * @param pawn2
     * @param x positions of pawn1
     * @param y positions of pawn2 */
    public void NumberSevenCard(Pawn pawn1, Pawn pawn2, int x, int y){
        //checks if can play
        if ((x+y)==7){
            setPosition(position+7);//or
            setPosition(position+x);
            setPosition(position+y);
            //check if pawns can move
        }
    }
}
