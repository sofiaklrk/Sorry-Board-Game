package mvc.model.pawn;

import mvc.model.deck.Deck;
import mvc.model.square.Square;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to
 * create a player's pawn
 * @version 1.0
 * @author csd5153
 */
public class Pawn {
    public static int number;
    public static int position1=-3;//= -1;
    public static int x;
    public static int y;
    public static String name;
    public static String NAME="bluePawn";
    public static String Image;
    public static String image="images/pawns/";
    private boolean isAlive=false;
    public static Color color;
    public static PawnColor colorPawn;

    /**<b>Transformer:</b> sets the player's color
     * <b>Post-condition:</b> player's color has been set
     * @param color */
    public static void setPawnColor(Color color){

        PawnColor.color = color;
    }
    /**
     * <b>Accessor:</b> returns the player's color
     * <b>Post-condition:</b> player's color has been set
     * @param color */
    public static Color getPawnColor(Color color){
        return color;
    }

/**initializes the x and y of the pawn*/
    public static int[] setXY(Pawn pawn, int position,Graphics g){//for the initialization of the pawns
        int[] xy = new int[2];
        String Pnm=null;
        image="images/pawns/";
        if (Deck.position==-3) {
            if (number == 1) {
                if (pawn.color == Color.RED) {
                    x = -55;
                    y = 60;
                    Pnm="redPawn1";
                    name="redPawn1";
                    colorPawn.color = Color.RED;
                   // setName("redPawn1");
                    //image = "images/pawns/redPawn1.png";
                    //setImage("images/pawns/redPawn1.png");

                } else if (PawnColor.color == Color.YELLOW){
                    x = 500;
                    y = 1030;
                    Pnm="yellowPawn1";
                    name="yellowPawn1";
                    //image = "images/pawns/yellowPawn1.png";
                    //setImage("images/pawns/yellowPawn1.png");
                }else if (PawnColor.color == Color.BLUE){
                    x = 690;
                    y = 300;
                    Pnm="bluePawn1";
                    name="bluePawn1";
                    //image="images/pawns/bluePawn1.png";
                }else{
                    x = -225;
                    y = 870;
                    Pnm="greenPawn1";
                    name="greenPawn1";
                    //image="images/pawns/greenPawn1.png";
                }
            } else {
                if (PawnColor.color == Color.RED) {
                    x = 35;
                    y = 60;
                    Pnm="redPawn2";
                    name="redPawn2";
                    //image = "images/pawns/redPawn2.png";
                    //setImage("images/pawns/redPawn2.png");
                } else if (PawnColor.color==Color.YELLOW){
                    x = 600;
                    y = 1030;
                    Pnm="yellowPawn2";
                    name="yellowPawn2";
                    //image = "images/pawns/yellowPawn2.png";
                    //setImage("images/pawns/yellowPawn2.png");
                }else if (PawnColor.color == Color.BLUE){
                    x = 770;
                    y = 300;
                    Pnm="bluePawn2";
                    name="bluePawn2";
                    //image="images/pawns/bluePawn2.png";
                }else{
                    x = -130;
                    y = 870;
                    Pnm="greenPawn2";
                    name="greenPawn2";
                    //image="images/pawns/greenPawn2.png";
                }
            }
        }
        /*else {
            int moves = position*80;
            int movesleft=0;
            int left=0;
            if (y==-47) {
                if (((870 - x) % 80) <= position) {
                    x += moves;
                } else {
                    x=870;
                    movesleft = position - (870 - x) % 80;
                    if (((1153-y)%80)<=movesleft){
                        y+=movesleft*80;
                    }else{
                        y=1153;
                        left=movesleft-(1153-y)%80;
                        x-=left*80;
                    }
                }
            }else if (y==1153){
                if (((330 + x) % 80) <= position) {
                    x += moves;
                } else {
                    x=-330;
                    movesleft = position - (330 + x) % 80;
                    if (((47+y)%80)<=movesleft){
                        y+=movesleft*80;
                    }else{
                        y=-47;
                        left=movesleft-(47+y)%80;
                        x-=left*80;
                    }
                }
            }else {
                if (x==870){
                    if (((1153-y)%80)<=position){
                        y+=moves;
                    }else{
                        y=1153;
                        movesleft=position-(1153-y)%80;
                        x-=movesleft*80;
                    }
                }else if (x==330){
                    if (((47+y)%80)<=position){
                        y+=moves;
                    }else {
                        y=-47;
                        movesleft=position-(47+y)%80;
                        x-=movesleft*80;
                    }
                }
            }
            if (number == 1) {
                if (PawnColor.color == Color.RED) {

                    image = "images/pawns/redPawn1.png";
                    //setImage("images/pawns/redPawn1.png");

                } else {
                    image = "images/pawns/yellowPawn1.png";
                    //setImage("images/pawns/yellowPawn1.png");
                }
            } else {
                if (PawnColor.color == Color.RED) {
                    image = "images/pawns/redPawn2.png";
                    //setImage("images/pawns/redPawn2.png");
                } else {
                    image = "images/pawns/yellowPawn2.png";
                    //setImage("images/pawns/yellowPawn2.png");
                }
            }
        }*/
       // image+=Pnm;

        image+=name;
        image+=".png";
        Square.drawImageInCenter2(g,image,x,y,40,40);
        xy[0]=x;
        xy[1]=y;
        return xy;
    }
    /**
     * <b>Accessor:</b> returns the player's x
     * <b>Post-condition:</b> player's x has been set
     * @return  x */
    public int getX() {
        return x;
    }
    /**
     * <b>Accessor:</b> returns the player's y
     * <b>Post-condition:</b> player's y has been set
     * @return  y */
    public int getY() {
        return y;
    }
    /**
     * <b>Transformer:</b> returns the player's x
     * <b>Post-condition:</b> player's x has been set
     * @param   x1 */
    public static void setX(int x1){
        x=x1;
    }
    /**
     * <b>Transformer:</b> returns the player's y
     * <b>Post-condition:</b> player's y has been set
     * @param   y1 */
    public static void setY(int y1){
        y=y1;
    }

    /**
     * <b>Transformer:</b> returns the player's name
     * <b>Post-condition:</b> player's name has been set
     * @param   n */
    public static void setName(String n){
        name = n;
    }
    /**
     * <b>Accessor:</b> returns the player's name
     * <b>Post-condition:</b> player's name has been set
     * @return  name */
    public static String getName(){
        return name;
    }




    /**the image path for player's pawn */
    //private static String image;

    /**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     */
    public static String getImage() {
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
     * <b>Accessor:</b> sets the pawn's number (1,2)
     * <b>Post-condition:</b> number has been set
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * <b>Transormer:</b> sets the pawn's number
     * <b>Post-condition:</b> number has been set
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * <b>Accessor:</b> sets the pawn's position
     * <b>Post-condition:</b> pawn's position has been set
     * @return  position1*/
    public int getPosition() {
        return position1;
    }

    /**
     * <b>Transformer:</b> sets the pawn's new position
     * <b>Post-condition:</b> pawn's new position has been set
     * @param position*/
    public static void movePosition(int position) {

        //moves pawn
        /*this.position+=x;
        if (position==9)
            this.hasFinished=true;*/
    }
    /**
     * <b>Accessor:</b> sets the value of isAlive
     * <b>Post-condition:</b> the value of isAlive has been set
     * @return isAlive true if player is still on the game and false otherwise*/
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * <b>Transformer:</b> sets the value of isAlive
     * <b>Post-condition:</b> the value of isAlive has been set
     * @param isAlive
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }


}





