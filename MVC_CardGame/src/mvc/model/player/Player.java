/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import mvc.model.board.Board;
import mvc.model.card.Card;
import mvc.model.card.NumberCard;
import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;
import mvc.model.pawn.PawnColor;
import mvc.model.square.Square;

import static mvc.model.deck.Deck.*;
import static mvc.model.pawn.Pawn.setXY;

/**
 * this class contains the methods signatures needed in order to
 * create a player
 * @version 1.0
 * @author csd5153
 */
public class Player {
    ArrayList<mvc.model.card.Card> cards=new ArrayList<mvc.model.card.Card>();
    public static int position=-3;
    boolean hasStarted=false,hasFinished=false;

    Pawn pawn, pawn2;
    public static Color color;
    public static PawnColor pawnColor;
    boolean playerturn=false;
    String name;
    public static int value;//number?
    public static int number;

    /**<b>Transformer:</b> sets the player's  pawn
     * <b>Post-condition:</b> player's  pawn has been set
     * @param pawn */
    public void setPawn(Pawn pawn){

        this.pawn = pawn;
    }
    /**
     * <b>Accessor:</b> returns the player's  pawn
     * <b>Post-condition:</b> player's  pawn has been set
     * @param pawn */
    public static Pawn getPawn(Pawn pawn){
        return pawn;
    }/*
    *//**<b>Transformer:</b> sets the player's second pawn
     * <b>Post-condition:</b> player's second pawn has been set
     * @param pawn2 *//*
    public void setPawn2(Pawn pawn2){
        this.pawn2 = pawn2;
    }
    *//**
     * <b>Accessor:</b> returns the player's second pawn
     * <b>Post-condition:</b> player's second pawn has been set
     * @param pawn2 *//*
    public Pawn getPawn2(Pawn pawn2){
        return pawn2;
    }
*/
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

    /**<b>Transformer:</b> sets the player's name
     * <b>Post-condition:</b> player's name has been set
     * @param name */
    public void setName(String name){
        this.name = name;
    }
    /**
     * <b>Accessor:</b> returns the player's name
     * <b>Post-condition:</b> player's name has been set
     * @param name */
    public String getName(String name){
        return name;
    }

    /**the image path for player's  pawn */
    public static String image ;//= "images/pawns/redPawn1.png";

    /**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image
     */
   /* public void setImage(String image) {
        this.image = image;
    }
   */ /**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image
     */
    /*public static String getImage(String image) {
        return image;
    }
*/

    /**the image path for player's second pawn *//*
    private String image2 = "images/pawns/redPawn2.png";
    *//**
     * <b>Accessor:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @return image2
     *//*
    public String getImage2() {
        return image2;
    }

    *//**
     * <b>Transormer:</b> sets the image
     * <b>Post-condition:</b> image has been set
     * @param image2
     *//*
    public void setImage2(String image2) {
        this.image2 = image2;
    }

*/
    /**
     * <b>Accessor:</b> sets the pawn's position
     * <b>Post-condition:</b> pawn's position has been set
     * @return  position*/
    public int getPosition() {
        return position;
    }

    /**
     * <b>Transformer:</b> sets the pawn's new position
     * <b>Post-condition:</b> pawn's new position has been set
     * @param position*/
    public void setPosition(int position){
        this.position = position;
    }

    /*public int[] movePosition(int position) {
        int[] XY = new int[2];
        int x = 0, y = 0;
        if (position != -3) {
            int moves = position * 80;
            int mod = moves % 320; // 320 = 80 (side length) * 4 (number of sides)
            int rotation = moves / 320; // 0 <= rotation < 4
            int rotationMoves = mod / 80; // 0 <= rotationMoves < 4
            int moveWithinRotation = mod % 80; // 0 <= moveWithinRotation < 80
            switch (rotation) {
                case 0: // moving along the bottom side
                    x = 870 - moveWithinRotation;
                    y = -47;
                    break;
                case 1: // moving along the right side
                    x = 870;
                    y = -47 + rotationMoves * 80 + moveWithinRotation;
                    break;
                case 2: // moving along the top side
                    x = 330 + moveWithinRotation;
                    y = 1153;
                    break;
                case 3: // moving along the left side
                    x = -330;
                    y = 1153 - rotationMoves * 80 - moveWithinRotation;
                    break;
            }
        }
        XY[0] = x;
        XY[1] = y;
        return XY;
    }*/
    public static int[] movePosition(int position) {

        int[] XY = new int[2];
        //int x=0,y=0;
        int x1=Pawn.x,y1=Pawn.y;
        if (position!=-3){
            int moves = position*80;
            int movesleft=0;
            int left=0;
            /*//Handle special cases when the pawn is on the edge of the square
            if (Pawn.x==870 && Pawn.y==-47){

            }
            */

            if (Pawn.y==-47 && position<=((870 - Pawn.x) % 80) ) {//pawn's x=390 position<=6 , from pawn's x to the edge (870-x)%80=6 moves
                Pawn.x += moves;
            } else if (Pawn.y==-47){//pawn's x=390 position=10, from pawn's x to the edge 870-x=6 <position
                x1+=moves;//x1=1190 >870
                movesleft= (x1-870)%80;//1190-870=320 %80=4 movesleft
                Pawn.x=870;//on the edge
                //Pawn.y+=movesleft*80;
                x1=870;
                y1+=movesleft*80;//4*80=320 +y1=-47+320=273 the last position(870,273)
                if (movesleft<=((1153-y1)%80)){//(1153-y1)%80=11 >movesleft(4)
                    Pawn.y+=movesleft*80;//update pawn
                }else{//if movesleft>(1153-y1)%80 estw 13>11
                    y1+=movesleft*80;//273+13*80=1313
                    left=(y1-1153)%80;//1313-1153=160 %80=2
                    Pawn.y=1153;//on the edge
                    y1=1153;
                    x1-=left*80;//870-2*80=710
                    if (left<=(330+x1)%80){//(330+710=1040)%80=13>left(2)
                        Pawn.x-=left*80;
                    }else {//left=15>13
                        Pawn.x=-330;
                        x1-=left*80;//-490
                        int left2=(x1+330)%80;//-160%80=-2
                        x1=-330;
                        y1+=left2*80;//993
                        if ((-1)*left2<=(47+y1)%80){//1040%80=13
                            Pawn.y+=left2*80;//993
                        }

                    }
                    /*left=movesleft-(1153-Pawn.y)%80;
                    Pawn.y=1153;
                    Pawn.x-=left*80;*/
                }
            }else if (Pawn.y==1153 && ((330 + Pawn.x) % 80) > position){//330+390=720
                Pawn.x += moves;
            } else if (Pawn.y==1153){

                movesleft = position - (330 + Pawn.x) % 80;
                Pawn.x=-330;
                if (((47+Pawn.y)%80)<=movesleft){
                    Pawn.y+=movesleft*80;
                }else{

                    left=movesleft-(47+Pawn.y)%80;
                    Pawn.y=-47;
                    Pawn.x-=left*80;
                }
            }else if (Pawn.x==870 && ((1153-Pawn.y)%80)<=position){
                Pawn.y+=moves;
            }else if (Pawn.x==870){

                movesleft=position-(1153-Pawn.y)%80;
                Pawn.y=1153;
                Pawn.x-=movesleft*80;
            }else if (Pawn.x==330 && ((47+Pawn.y)%80)<=position){
                Pawn.y+=moves;
            }else if (Pawn.x==330){

                movesleft=position-(47+Pawn.y)%80;
                Pawn.y=-47;
                Pawn.x-=movesleft*80;
            }
        }
        //moves pawn
        /*this.position+=Pawn.x;
        if (position==9)
            this.hasFinished=true;*/
        XY[0]=Pawn.x;
        XY[1]=Pawn.y;
        return XY;//oxi prosthesh, na epistrefei pinaka[2]
    }

    public static boolean Check(int position, Graphics g){
        int[] XY = NumberCard.MaketheCheck();//movePosition(position);
        boolean[][] arr = new boolean[16][16];
        arr=Board.CheckPawnss();
        int[] X = new int[16];
        int[] Y = new int[16];
        X=Board.MakeX();
        Y=Board.MakeY();
        int k=0,l=0;
        boolean cardsact=false;
        for (int i=0;i<16;i++){
            if (X[i]==XY[0]){
                k=i;
            }
        }
        for (int i=0;i<16;i++){
            if (Y[i]==XY[1]){
                l=i;
            }
        }
        if (cardsact){

        }
        if (arr[k][l]){
            //press the fold button
            //you cant move someone is on the position you were going to be
            return false;
        }else{
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
            Square.drawImageInCenter2(Deck.g,image,XY[0],XY[1],40,40);
            arr[k][l]=true;
            arr[Pawn.x][Pawn.y]=false;
            Pawn.x=XY[0];
            Pawn.y=XY[1];
            return true;
        }
        //return true;
    }




    //*****************************
    public static boolean CheckPositionsAtBoard(int position, Graphics g){
        //returns future x and y
        int[] XY = NumberCard.MaketheCheck();//movePosition(position);
        /*String[][] arr = new String[16][16];
        arr=Board.PawnsPositionsAtBoard();
        */
        String[][] arr = new String[16][16];
        arr=Board.PawnsAtBoard;
        int[] X = new int[16];
        int[] Y = new int[16];
        X=Board.MakeX();
        Y=Board.MakeY();
        int k=0,l=0;
        boolean cardsact=false;
        for (int i=0;i<16;i++){
            if (X[i]==XY[0]){
                k=i;
            }
        }
        for (int i=0;i<16;i++){
            if (Y[i]==XY[1]){
                l=i;
            }
        }
        if (cardsact){

        }
        if (!Objects.equals(arr[k][l], "69")){

            //press the fold button
            //you cant move someone is on the position you were going to be
            return false;
        }else{
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
            Square.drawImageInCenter2(Deck.g,image,XY[0],XY[1],40,40);
            arr[k][l]=image;
            arr[Pawn.x][Pawn.y]="69";
            Board.PawnsAtBoard[k][l]=image;
            Board.PawnsAtBoard[Pawn.x][Pawn.y]="69";
            Pawn.x=XY[0];
            Pawn.y=XY[1];
            return true;
        }
        //return true;
    }


    //************************


    public boolean cardsAct(Card card){




        return false;
    }

    /*public ArrayList<mvc.model.card.Card> getCards() {
        return cards;
    }
*/
    /*public void addCards(Card card) {
        this.cards.add(card);
    }*/

    /**
     * <b>Accessor:</b> sets the value of hasStarted
     * <b>Post-condition:</b> the value of hasStarted has been set
     * @return hasStarted true if player have started the game and false otherwise*/
    public boolean isHasStarted() {
        return hasStarted;
    }

    /**
     * <b>Transformer:</b> sets the value of hasStarted
     * <b>Post-condition:</b> the value of hasStarted has been set
     * @param hasStarted
     */
    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    /**
     * <b>Transformer:</b> sets the value of hasFinished
     * <b>Post-condition:</b> the value of hasFinished has been set
     * @param hasFinished
     */

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    /**
     * <b>Accessor:</b> sets the value of hasFinished
     * <b>Post-condition:</b> the value of hasFinished has been set
     * @return hasFinished true if player have finished the game and false otherwise*/

    public boolean isHasFinished() {
        return hasFinished;
    }

    /**
     * <b>Accessor:</b> sets the value of card
     * <b>Post-condition:</b> the value of card has been set
     * @return cards
     * */
    public ArrayList<Card> getCards() {
        return cards;
    }


    /**
     * <b>Accessor:</b> checks if it's player's turn
     * <b>Post-condition:</b> player's turn has been checked
     * @return playerturn true if it's his turn, false otherwise*/
    public boolean isPlayerturn(){
        return playerturn;
    }

    /**
     * <b>Transformer:</b> sets cards
     * <b>Post-condition:</b> cards have been set
     **/

    public Player() {
        cards = new ArrayList<>();
        /*
        if (Objects.equals(options[result], "3 players")){
            setPawn(Deck.blue1);
            setPawn(Deck.blue2);
            blue1.setPawnColor(Color.BLUE);
            blue2.setPawnColor(Color.BLUE);
            int[] xyblue1 = setXY(blue1,Deck.position,Deck.g);
            int[] xyblue2 = setXY(blue2,Deck.position,Deck.g);
        }else if (options[result].equals("4 players")){
            setPawn(Deck.blue1);
            setPawn(Deck.blue2);
            setPawn(Deck.green1);
            setPawn(Deck.green2);
            blue1.setPawnColor(Color.BLUE);
            blue2.setPawnColor(Color.BLUE);
            green1.setPawnColor(Color.GREEN);
            green2.setPawnColor(Color.GREEN);
            int[] xyblue1 = setXY(blue1,Deck.position,Deck.g);
            int[] xyblue2 = setXY(blue2,Deck.position,Deck.g);
            int[] xygreen1 = setXY(green1,Deck.position,Deck.g);
            int[] xygreen2 = setXY(green2,Deck.position,Deck.g);
        }
*/
        setPawn(red1);
        setPawn(red2);
        setPawn(Deck.yellow1);
        setPawn(Deck.yellow2);
        setPawn(Deck.blue1);
        setPawn(Deck.blue2);
        setPawn(Deck.green1);
        setPawn(Deck.green2);
        red1.setPawnColor(Color.RED);//setPawnColor(Color.RED);
        red2.setPawnColor(Color.RED);
        yellow1.setPawnColor(Color.YELLOW);
        yellow2.setPawnColor(Color.YELLOW);
        blue1.setPawnColor(Color.BLUE);
        blue2.setPawnColor(Color.BLUE);
        green1.setPawnColor(Color.GREEN);
        green2.setPawnColor(Color.GREEN);
        int[] xyred1 = setXY(red1,Deck.position,Deck.g);
        int[] xyred2 = setXY(red2,Deck.position,Deck.g);
        int[] xyyellow1 = setXY(yellow1,Deck.position,Deck.g);
        int[] xyyellow2 = setXY(yellow2,Deck.position,Deck.g);
        int[] xyblue1 = setXY(blue1,Deck.position,Deck.g);
        int[] xyblue2 = setXY(blue2,Deck.position,Deck.g);
        int[] xygreen1 = setXY(green1,Deck.position,Deck.g);
        int[] xygreen2 = setXY(green2,Deck.position,Deck.g);
    }

    /**
     * <b>Transformer:</b> sets cards
     * <b>Post-condition:</b> cards have been set
     *@param card */
    public void addCard(Card card) {
        cards.add(card);
    }


}
