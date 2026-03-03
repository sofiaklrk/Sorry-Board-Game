package mvc.model.card;

import mvc.model.pawn.Pawn;

/**
 * this class contains the methods signatures needed in order to
 * create a sorry card's interactions
 * checks if the player can change position with the player against him
 * @version 1.0
 * @author csd5153
 */
public class SorryCard extends Card{

    /**the image path for sorry card */
    private String image = "images/cards/cardSorry.png";
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
     * checks if opponent's position is on the safety zone
     * to see if it's possible to change positions with the player
     * @param pawnv the player's opponent*/
    public void SorryCard(Pawn pawnv){
        //checks if player can change position with opponent
    }
    /**
     * checks if the player's pawns are on start
     * to see if it's possible to change positions with his opponent*/
    public void ChangePositionV(Pawn pawnv, Pawn pawn){

        //checks if player has pawns on start square
    }
    /**constructor for the sorry card*/
    public SorryCard(){
        //if you have a pawn on the start square you can change it with the opponent
    }
}
