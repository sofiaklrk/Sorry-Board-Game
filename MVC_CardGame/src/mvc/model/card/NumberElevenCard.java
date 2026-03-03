package mvc.model.card;

import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;

import javax.swing.*;

/**
 * this class contains the methods signatures needed in order to create
 * the number card 11
 * @version 1.0
 * @author csd5153
 */
public class NumberElevenCard extends NumberCard{
    public static String[] options = {"11 moves front", "change with opponent"};
    public static String[] CP ;//= {"11 moves front", "change with opponent"};
    public static int re=0;
    //public static String[] opponents = {"bluePawn1","bluePawn2","greenPawn1","greenPawn2","redPawn1","redPawn2","yellowPawn1","yellowPawn2"};
    public static String[] Pawns12 = {"bluePawn1","bluePawn2","greenPawn1","greenPawn2","redPawn1","redPawn2","yellowPawn1","yellowPawn2"};
    public static String[] opponents = new String[6] ;//= Pawns12;//{"bluePawn1","bluePawn2","greenPawn1","greenPawn2","redPawn1","redPawn2","yellowPawn1","yellowPawn2"};
    public static String[] colors = {"blue","blue","green","green","red","red","yellow","yellow"};
    public static int[] numbers = {1,2,1,2,1,2,1,2};
    public static int numb;

    public static int opon=0;
    public static Pawn curr11;
    public static Pawn curr;//=Deck.currentPawn;
    public static Pawn pawnv;
    public static String npo="redPawn1";
    public static int result=0;
    //Pawn pawnv,pawn;
    /**the image path for card 11*/
    //private String image = "images/cards/card11.png";
    /**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     */
    /*public String getImage() {
        return image;
    }
*/
    /**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image
     */
   /* public void setImage(String image) {
        this.image = image;
    }
*/
    /**
     * checks if opponent's pawn's position is
     * on the safety zone of on start or home square
     * to see if it's possible to change positions with the player
     * @param //pawnv*/
    public Pawn NumberElevenCard(Pawn curren){
        curr=curren;
        return curr;
        //checks the opponent positions
    }
    /**
     * checks if player's position is on the start or home square
     * to see if it's possible to change positions with his opponent
     * @param //pawn */
    public void CheckPositionPawn(){
        //checks player's position
    }
    /**<b>Accessor:</b> checks if player can move or change positions with his opponent
     * <b>Post-condition:<b/> player's choice has been set
     * @return  flag TRUE if he can move, FALSE otherwise*/
    public boolean Move(Pawn pawn1, Pawn pawn2, Pawn pawnv1, Pawn pawnv2){
        //checks if player can move or doesn't want to
        boolean flag = false;
        //True if he wants to move , false otherwise
        return flag;

    }
    /**
     * presses the fold button to change the turn*/
    public void foldB(){

    }
    /**constructor for elenen card*/
    public NumberElevenCard(Pawn pawnv){
        /*result = JOptionPane.showOptionDialog(
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
                new NumberElevenCard(pawnv);//.setVisible(true);
            });
        }*/
        /*for (int i=0;i<8;i++){
            if (Deck.currentPawn.name.equals(Pawns12[i])){
                opponents[i]=null;
            }
        }*/
        if (options[result].equals("change with opponent")){

        }
        if (true/*Move(Pawn pawn1, Pawn pawn2, Pawn pawnv1, Pawn pawnv2)*/) {
            setPosition(position + 11);//or exchange positions with opponent
            NumberElevenCard(pawnv);
            CheckPositionPawn();
        }else{
            //press the fold button
        }
    }
    public static void main(String[] args) {
        int j=0;
        String color=null;
        for (int i=0;i<8;i++){
            if ((npo.equals(Pawns12[i]))){
                color=colors[i];
                numb=numbers[i];
                /*CP[j]=Pawns12[i];
                j++;*/

                //opponents[i]=null;
            }/*else{
                opponents[j]=;//Pawns12[i];
                j++;
            }*/
        }

            if (color.equals("red")){
                CP=new String[]{"redPawn1","redPawn2"};
                opponents = new String[]{"bluePawn1", "bluePawn2", "greenPawn1", "greenPawn2", "yellowPawn1", "yellowPawn2"};
            }else if (color.equals("blue")){
                CP=new String[]{"bluePawn1","bluePawn2"};
                opponents = new String[]{"greenPawn1","greenPawn2","redPawn1","redPawn2","yellowPawn1","yellowPawn2"};
            }else if (color.equals("green")){
                CP=new String[]{"greenPawn1","greenPawn2"};
                opponents = new String[]{"bluePawn1","bluePawn2","redPawn1","redPawn2","yellowPawn1","yellowPawn2"};
            }else {
                CP=new String[]{"yellowPawn1","yellowPawn2"};
                opponents = new String[]{"bluePawn1","bluePawn2","greenPawn1","greenPawn2","redPawn1","redPawn2"};
            }

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
            if (options[result].equals("change with opponent")) {
                opon = JOptionPane.showOptionDialog(
                        null,
                        "Choose an opponent:",
                        "Choice",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opponents,
                        opponents[0]
                );
                if (opon == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Dialog closed without a choice");
                } else {
                    System.out.println("User chose: " + opponents[opon]);
                    /*SwingUtilities.invokeLater(() -> {
                        new NumberElevenCard(pawnv);//.setVisible(true);
                    });*/
                    re = JOptionPane.showOptionDialog(
                            null,
                            "Choose an option:",
                            "Choice",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            CP,
                            CP[0]
                    );
                    if (opon == JOptionPane.CLOSED_OPTION) {
                        System.out.println("Dialog closed without a choice");
                    } else {
                        if (re!=-1) {
                            System.out.println("User chose: " + CP[re]);
                        }
                    }

                    }
            }

            //System.out.println("User chose: " + options[result]);
            SwingUtilities.invokeLater(() -> {
                new NumberElevenCard(pawnv);//.setVisible(true);
            });
        }


    }
}