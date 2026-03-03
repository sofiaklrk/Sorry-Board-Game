package mvc.model.card;

import mvc.model.deck.Deck;
import mvc.model.pawn.Pawn;

import java.awt.*;

/**
 * this class contains the methods signatures needed in order to create
 *a number card(1,2,4,7,10,11)
 * @version 1.0
 * @author csd5153
 */
public class NumberCard extends Card{
    /**the player's turn*/
    public static int turn = -1;//1 for red 2 for yellow 3 for blue 4 for green

    /**
     *the player's pawn direction  */
    public static int direction;//1 for front, -1 for back

    /**<b>Transformer:</b> sets the direction of pawn
     * <b>Post-condition</b> the pawn's direction has been set
     * @param direction -1 for back */
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

    /**
     * <b>Transformer:</b> sets the card's position
     * <b>Post-condition:</b> card's position has been set
     * @param position*/
   /* public void setPosition(int position){
        this.position = position;
    }
*/    /**
     * <b>Transformer:</b> sets the turn
     * <b>Post-condition:</b> turn has been set
     * @param turn*/
    public void setTurn(int turn){
        this.turn = turn;
    }
    /**
     * <b>Accessors:</b> sets the card's position
     * <b>Post-condition:</b> card's position has been set
     * @return position
     * */
    /*public int getPosition(int position){
        return position;
    }
*/    /**
     * <b>Accessor:</b> sets the turn
     * <b>Post-condition:</b> turn has been set
     * @return turn*/
    public int getTurn(int turn){
        return turn;
    }
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
     * @param //image
     *//*
    public void setImage(String image) {
        this.image = image;
    }*/

/**makes the new x and y coordinates based on the position=the number of moves and the direction=front or back
 * @return XY the array with the new coordinates */
    public static int[] CheckMove(Pawn pawn , int position, int direction){
        boolean flagpros=false;
        int[] XY = new int[2];
        if (direction*(-1)==1){
            //arnhtiko<0
            flagpros=true;
        }else {
            //thetiko>0
            flagpros=false;
        }
        int x1=pawn.x,y1=pawn.y;
        if (position==1) {
            if (turn == 1) {
                pawn.color = Color.RED;
                // image50 = "images/pawns/redPawn1.png";
                if (pawn.y == Deck.DFYRed) {
                    x1=-10;
                    y1=-47;
                    //CurrStartPawn=true;
                }
            } else if (turn == 2) {
                if (Deck.plPlayers != 2) {
                    pawn.color = Color.BLUE;
                    if (pawn.y == Deck.DFYBlue) {
                        x1=870;
                        y1=273;
                        //CurrStartPawn=true;
                    }
                } else {
                    pawn.color = Color.YELLOW;
                    if (pawn.y == Deck.DFYYellow) {
                        x1=550;
                        y1=1153;
                        //CurrStartPawn=true;
                    }
                }
            } else if (turn == 3) {
                pawn.color = Color.YELLOW;
                if (pawn.y == Deck.DFYYellow) {
                    x1=550;
                    y1=1153;

                    //CurrStartPawn=true;
                }
            } else {
                pawn.color = Color.GREEN;
                if (pawn.y == Deck.DFYGreen) {
                    x1=-330;
                    y1=833;
                    //CurrStartPawn=true;
                }
            }
        }else if (position==2){
            if (turn == 1) {
                // image50 = "images/pawns/redPawn1.png";
                if (pawn.y == Deck.DFYRed) {
                    x1=70;
                    y1=-47;
                    //CurrStartPawn=true;
                }
            } else if (turn == 2) {
                if (Deck.plPlayers != 2) {
                    if (pawn.y == Deck.DFYBlue) {
                        x1=870;
                        y1=353;
                        //CurrStartPawn=true;
                    }
                } else {
                    if (pawn.y == Deck.DFYYellow) {
                        x1=470;
                        y1=1153;
                        //CurrStartPawn=true;
                    }
                }
            } else if (turn == 3) {
                if (pawn.y == Deck.DFYYellow) {
                    x1=470;
                    y1=1153;

                    //CurrStartPawn=true;
                }
            } else {
                if (pawn.y == Deck.DFYGreen) {
                    x1=-330;
                    y1=753;
                    //CurrStartPawn=true;
                }
            }
        } else if (position!=-3){
            int moves = position*80;
            int movesleft=0;
            if (flagpros) {
                if (Pawn.y == -47 && position <= ((330 + Pawn.x) % 80)) {
                    x1 -= moves;
                } else if (Pawn.y==-47) {
                    x1-=moves;//x1=1190 >870
                    movesleft= (x1+330)%80;//1190-870=320 %80=4 movesleft
                    x1=-330;//on the edge
                    //Pawn.y+=movesleft*80;
                    //x1=-330;
                    y1+=movesleft*80;//4*80=320 +y1=-47+320=273 the last position(870,273)
                    //Pawn.y=y1;//update pawn
                }else if (Pawn.y==1153 && (position <= (870 - Pawn.x) % 80)){//330+390=720
                    x1 += moves;
                }else if (Pawn.y==1153) {

                    movesleft = position - (870- Pawn.x) % 80;
                    x1 = 870;
                    y1-=movesleft*80;
                }
                if (Pawn.x==870 && ((47+Pawn.y)%80)<=position){
                    y1-=moves;
                }else if (Pawn.x==870){

                    movesleft=position-(47+Pawn.y)%80;
                    y1=-47;
                    x1-=movesleft*80;
                }else if (Pawn.x==-330 && ((1153-Pawn.y)%80)<=position){
                    y1+=moves;
                }else if (Pawn.x==-330){

                    movesleft=position-(1153-Pawn.y)%80;
                    y1=1153;
                    x1+=movesleft*80;
                }
            }else {
                if (Pawn.y == -47 && position <= ((870 - Pawn.x) % 80)) {
                    x1 += moves;
                } else if (Pawn.y==-47) {
                    x1+=moves;//x1=1190 >870
                    movesleft= (x1-870)%80;//1190-870=320 %80=4 movesleft
                    //Pawn.x=870;//on the edge
                    //Pawn.y+=movesleft*80;
                    x1=870;
                    y1+=movesleft*80;//4*80=320 +y1=-47+320=273 the last position(870,273)
                    //Pawn.y=y1;//update pawn
                }else if (Pawn.y==1153 && ((330 + Pawn.x) % 80) > position){//330+390=720
                    x1 -= moves;
                } else if (Pawn.y==1153) {

                    movesleft = position - (330 + Pawn.x) % 80;
                    x1 = -330;
                    y1+=movesleft*80;
                }
                if (Pawn.x==870 && ((1153-Pawn.y)%80)<=position){
                    x1+=moves;
                }else if (Pawn.x==870){

                    movesleft=position-(1153-Pawn.y)%80;
                    y1=1153;
                    x1-=movesleft*80;
                }else if (Pawn.x==-330 && ((47+Pawn.y)%80)<=position){
                    y1-=moves;
                }else if (Pawn.x==-330){

                    movesleft=position-(47+Pawn.y)%80;
                    y1=-47;
                    x1+=movesleft*80;
                }

            }
        }
        XY[0]=x1;
        XY[1]=y1;
        return XY;
    }
    /**Constructor for implementation of the number card*/
    public NumberCard(){
        super();
        setDirection(direction);
        setTurn(turn);
    }
    /**calls the CheckMove to make the new x y*/
    public static int[] MaketheCheck(){
        return CheckMove(pawn,position,direction);
    }



}
