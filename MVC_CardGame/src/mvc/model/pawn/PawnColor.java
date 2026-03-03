package mvc.model.pawn;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to
 * create a player's pawn color
 * @version 1.0
 * @author csd5153
 */
public class PawnColor extends Pawn {
    public static Color color;
    //private Color color;
    /**<b>Transformer:</b> sets the player's color
     * <b>Post-condition:</b> player's color has been set
     * @param Newcolor */
    public static void setPawnColor(Color Newcolor){
        color = Newcolor;
    }
    /**
     * <b>Accessor:</b> returns the player's color
     * <b>Post-condition:</b> player's color has been set
     * @param color */
    public static Color getPawnColor(Color color){
        return color;
    }

}
