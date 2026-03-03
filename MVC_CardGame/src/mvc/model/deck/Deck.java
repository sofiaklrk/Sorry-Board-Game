package mvc.model.deck;

import javafx.scene.control.Labeled;
import mvc.model.board.Board;
import mvc.model.card.Card;
import mvc.model.card.NumberCard;
import mvc.model.card.NumberElevenCard;
import mvc.model.card.NumberTenCard;
import mvc.model.pawn.Pawn;
import mvc.model.pawn.PawnColor;
import mvc.model.player.Player;
import mvc.model.square.*;
import mvc.view.JLayeredPaneExtension;
import mvc.view.View;
import sun.java2d.loops.CustomComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.SocketImplFactory;
import java.net.URL;
import java.util.*;

import static mvc.model.deck.Deck.*;
import static mvc.model.deck.Deck.SquarePanel.CheckPositionsAtBoard;
import static mvc.model.deck.Deck.SquarePanel.CheckPositionsAtBoard2;
import static mvc.model.pawn.Pawn.colorPawn;
import static mvc.model.pawn.Pawn.number;
import static mvc.model.square.Square.direction;
import static mvc.model.square.Square.drawImageInCenter2;

/**
 * The main class representing the Square of Squares application.
 * It extends JFrame and contains the graphical user interface for the game.
 */
public class Deck extends JFrame {
    private BufferedImage backgroundImage;
    private JLabel backgroundLabel;
    public static String[] options = {"2 players", "3 players", "4 players"};
    public static String text85;
    public static int currX=-10;
    public static int currY=-47;
    public static int result11op;
    public static boolean flag85=false;
    public static boolean flag11=false;
    public static String[] options8 = {"8 moves front", "take new card"};
    public static String[] options12 = {"12 moves front", "take new card"};
    public static String[] options11 = {"11 moves front", "change positions with opponent"};
    public static int result11;
    public static int result85;

    public static String[] options10 = {"10 moves front", "1 move back"};
    public static String[] options7 = {"7 moves front with 1 pawn", "7 moves front with 2 pawns"};
    public static int result7=0;
    public static int sum=0;
    public static String[] options71 = {"1", "2","3","4","5","6"};
    public static int result71=0;
    public static int result711=0;

    public static boolean flag10=false;
    public static boolean flag8=false;

    public static boolean flag2=false;
    public static boolean flag7=false;
    public static boolean CurrStartPawn=false;


    public static int x=0;
    public static Random r = new Random();
    public static double rand;
    public static int Ci = 0;
    public static int[] plCardsLeft = new int[11];
    public static String[] Cards11 = new String[11];
    static int tx=0;
    public static int[] new1XY = new int[2];
    public static JButton playersCurrentCard = new JButton();
    public static Card CurrentCard = new Card();
    public static String CurrentC = new String();
    public static String[][] TextTurn = {{"Player 1 (Red)", "Player 2 (Blue)", "Player 3 (Yellow)", "Player 4 (Green)"}};
    public static String[][] Pawns  = new String[4][4];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PawnsName  = new String[4][4];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PawnsNameWOcurr3  = new String[2][2];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PawnsNameWOcurr2  = new String[1][2];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PawnsNameWOcurr4  = new String[3][2];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PlayersName = {{"Player 1 (Red)", "Player 2 (Blue)", "Player 3 (Yellow)", "Player 4 (Green)"}};//= new String[4][4];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};
    public static String[][] PawnsNme = {{"redPawn1", "redPawn2"}};//  = new String[4][4];//= {{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"}};

    public static int plPlayers=2;
    public static int CurrentPawnNum=0;

    public static int y=0;
    public static int position=-3;
    public static String image50;
    public static String[][] PawnsAtBoard = new String[16][16];//=Board.PawnsPositionsAtBoard();
    public static int[] X = new int[16];//=Board.MakeX();
    public static int[] Y = new int[16];//=Board.MakeY();
    public static int result=0;
    public static int result10=0;
    public static Graphics g;
    public static boolean flagStart = false;
    private JButton[] playerCards = new JButton[14];//*2
    private JButton playerLastCard = new JButton();
    private JLabel[] positions;
    static JLayeredPane basic_panel;
    private JLayeredPane player1;
    public static int sum1=0;
    public static int sum2=0;
    //ClassLoader for loading resources
    private static ClassLoader cldr;
    boolean enabled = true;
    static JLabel pawn;
    JTextArea infobox;
    public static boolean flag1 = false;
    public static boolean flag21 = false;
    private static final int SQUARE_SIZE = 40;
    private static final int SQUAREBIG_SIZE = 80;

    private static final int PERIMETER_SIZE = 1/2; // Black perimeter size
    private static final int GRID_SIZE = 16; // Number of squares per side

    Image image;
    public static boolean flag12=false;
    Card lastCardPlayed;
    public static int x21=0;
    public static int y21=0;
    Player Redplayer;
    Player Yellowplayer;

    Player Blueplayer;
    Player Greenplayer;
    public static int sum1red=0;
    public static int sum1yellow=0;
    public static int sum1blue=0;
    public static int sum1green=0;

    public static int sum2red=0;
    public static int sum2yellow=0;
    public static int sum2blue=0;
    public static int sum2green=0;
    static int turn=0;//1 red 2 yellow 3 blue 4 green
    public static int CardsLeft = 44;
    public static int DFRed1X = -55;
    public static int DFRed2X = 35;
    public static int DFYRed = 60;
    public static int DFYellow1X = 500;
    public static int DFYellow2X = 600;
    public static int DFYYellow = 1030;
    public static int DFBlue1X = 690;
    public static int DFBlue2X = 770;
    public static int DFYBlue = 300;
    public static int DFGreen1X = -225;
    public static int DFGreen2X = -130;
    public static int DFYGreen = 870;
    public static Pawn CurrPawn = new Pawn();
    public static Pawn red1 = new Pawn();
    public static Pawn red2 = new Pawn();
    public static Pawn yellow1 = new Pawn();
    public static Pawn yellow2 = new Pawn();
    public static String imgred1 = "";
    public static String imgred2;
    public static String imgyellow1;
    public static String imgyellow2;
    public static Pawn blue1 = new Pawn();
    public static Pawn blue2 = new Pawn();
    public static Pawn green1 = new Pawn();
    public static Pawn green2 = new Pawn();
    public static String imgblue1;
    public static String imgblue2;
    public static String imggreen1;
    public static String imggreen2;
    public static Pawn currentPawn;

    static Color color1;
    static Color color2;
    public static int xred = 0;
    public static int xblue= 0;
    public static int xyellow=0;
    public static int xgreen =0;
    public static int yred = 0;
    public static int yblue= 0;
    public static int yyellow=0;
    public static int ygreen =0;

    //int position;

    static ArrayList<Card> gameCards = new ArrayList<Card>();

/*
    */
/**
     * Gets the game cards.
     *
     * @return the ArrayList of game cards.
     *//*

    public ArrayList<Card> getGameCards() {
        return gameCards;
    }
*/
/*

    */
/**
     * Sets the game cards.
     *
     * @param gameCards the ArrayList of game cards to set.
     *//*

    public void setGameCards(ArrayList<Card> gameCards) {
        this.gameCards = gameCards;
    }
*/

    /**checks if cards have finished and shuffle them*/
    public static void checkCards(){
        if (Card.getCards().isEmpty()){
            Collections.shuffle(gameCards);
        }
    }
    /**
     * <b>Accessor:</b> checks if the game has finished
     * <b>Post-condition:</b> game's status has been set
     * @return true if it has finished, false otherwise*/
    public boolean EndGame(){
        if (Redplayer.isHasFinished() || Yellowplayer.isHasFinished()) {
            return true;
        } else {
            return false;
        }
    }
    /**<b>Accessor:</b> checks if player can move or change positions with his opponent
     * <b>Post-condition:<b/> player's choice has been set
     * @return  flag TRUE if he can move, FALSE otherwise*/
    public static boolean Move(Pawn red1, Pawn red2, Pawn yellow1, Pawn yellow2){
        //checks if player can move or doesn't want to
        boolean flag = false;
        //True if he wants to move , false otherwise
        return flag;

    }
    /**
     * presses the fold button to change the turn*/
    public static void foldB(){
        boolean flag =Move(red1, red2, yellow1, yellow2);
            if (!flag) {
            //press the button
        }
    }

    /**
     * <b>Transformer:</b> sets player's new position
     * <b>Post-condition:</b> player's new position has been set
     * @param position*/
    /*public static void MovePlayer(int position){
        if (Move(red1, red2, yellow1, yellow2)){
           // this.position = position;
        }
        //moves player
    }*/

    /**
     * <b>Accessor:</b> sets players' pawns, images and colors
     * <b>Post-condition:</b> players' pawns,images and colors have been set
     * @return red1 first pawn red player
     * @return red2 second pawn red player
     * @return yellow1 first pawn yellow player
     * @return yellow2 second pawn yellow player
     * @return color1 red player
     * @return color2 yellow player
     * @return imgred1 first pawn red player
     * @return imgred2 second pawn red player
     * @return imgyellow1 first pawn yellow player
     * @return imgyellow2 second pawn yellow player
     * */
    public static void initPawns(){
        //new Player();
        int p=0,j=0;

        for (int i = 0;i<11;i++){
            plCardsLeft[i]=4;
            Card card = new Card();
            card.setValue(i % 4 + 1);
            if (i==0){
                Cards11[j] = "images/cards/cardSorry.png";
                card.setImage("images/cards/cardSorry.png");
                j++;
                p++;
            }else if (i==6||i==8){
                p++;
                Cards11[j] = "images/cards/card" + (p) + ".png";
                card.setImage("images/cards/card" + (p ) + ".png");
                p++;
                j++;
            }else {
                Cards11[j] = "images/cards/card" + (p) + ".png";
                card.setImage("images/cards/card" + (p ) + ".png");
                p++;
                j++;
            }
        }
       /* do {
            rand = ((Math.random() * 12));
            Ci = (int)rand;
        }while (Cards11[Ci]!="69");
        */
        int pl0=0;
        for (int i=0;i<11;i++){
            if (plCardsLeft[i]<0){
                pl0++;
            }
        }
        if (pl0==11){
            for (int i=0;i<11;i++){
                plCardsLeft[i]=4;
            }
            CardsLeft=44;
        }
      //  System.out.println(CardsLeft);
        //Pawns[CurrentPawnNum-1][turn - 1]
        /*if (turn==1){
            CurrPawn.color = Color.RED;
        }else if (turn==2){
            if (plPlayers!=2) {
                CurrPawn.color = Color.BLUE;
            }else {
                CurrPawn.color = Color.YELLOW;
            }
        } else if (turn==3) {
            CurrPawn.color = Color.YELLOW;
        }else{
            CurrPawn.color = Color.GREEN;
        }
        if (CurrentPawnNum==1){
            CurrPawn.setNumber(1);
        }else {
            CurrPawn.setNumber(2);
        }*/
/*
        do {
            Ci = Math.abs(r.nextInt()) % 11;
            // rand = ((Math.random() * 11) + 1);
            //Deck.Ci = (int) rand;
            if (Deck.plCardsLeft[Deck.Ci] >= 0) {
                Deck.CurrentC = Deck.Cards11[Deck.Ci];
                plCardsLeft[Ci]--;
               // System.out.println(plCardsLeft[Ci]+Deck.CurrentC);
                break;
//
            }
        }while (Deck.plCardsLeft[Deck.Ci] >= 0);
*/

        Ci = Math.abs(r.nextInt()) % 11;
        plCardsLeft[Ci]--;
        CardsLeft--;
       // position=Ci;
        if (Cards11[Ci].equals("images/cards/card10.png")){
            flag10=true;
        }else {
            flag10=false;
        }
        if (Cards11[Ci].equals("images/cards/card11.png")){
            flag11=true;
        }else {
            flag11=false;
        }
      //  System.out.println(Ci);
        if (Ci==6||Ci==7){
            position=Ci+1;
        }else if (Ci>=8&&Ci<=10){
            position=Ci+2;
        }else {
            position = Ci;
        }
        if (position==4){
            direction=-1;
        }else{
            direction=1;
        }
        //  System.out.println(position);
        if (flag10){
            if (CurrStartPawn) {
                Choose10();
            }
            if (result10==0){
                direction=1;
                position=10;
            }else {
                direction=-1;
                position=1;
            }
            //   System.out.println(position);
        }
        if (result7==1){

        }

       //CurrStartPawn=CheckPositionsAtBoard2(CurrPawn,position,g);
      //  System.out.println(direction);
        pl0=0;
        for (int i=0;i<11;i++){
            if (plCardsLeft[i]<0){
                pl0++;
            }
        }
        if (pl0==11){
            for (int i=0;i<11;i++){
                plCardsLeft[i]=4;
            }
            CardsLeft=44;
        }
       // System.out.println(position);


       /* double rand = ((Math.random() * 11) + 1);
        Ci = (int)rand;
        plCardsLeft[Ci]--;*/

      /*  for (int i=0;i<11;i++){
            System.out.println(Cards11[i]);
        }*/
       // Player.getPawn(red1);
       // int[] red1xy=Pawn.setXY(red1,position,g);
        //setPawn(red2);
        /*Player.getPawn(red1);
        Player.getPawn(red2);
        Player.getPawn(yellow1);
       *//* red1.setImage("images/pawns/yellowPawn1.png");
        red1.x=150;
        red1.y=-47;*//*
        Player.getPawn(yellow2);
        Player.getPawnColor(color1);
        Player.getPawnColor(color2);
       *//* Player.getImage(imgred1);
        Player.getImage(imgred2);
        Player.getImage(imgyellow1);
        Player.getImage(imgyellow2);*//*
        currentPawn.name="redPawn1";*/
        if (result==1){
            //3 players
            blue1.setNumber(1);
            blue1.color =Color.BLUE;
            blue1.setX(DFBlue1X);
            blue1.setY(DFYBlue);
           // Pawn.setXY(blue1,position,g);
            blue1.setImage("images/pawns/bluePawn1.png");
            blue2.setNumber(2);
            blue2.color =Color.BLUE;
            blue2.setX(DFBlue2X);
            blue2.setY(DFYBlue);
          //  Pawn.setXY(blue2,position,g);
            blue2.setImage("images/pawns/bluePawn2.png");
        } else if (result==2) {
            //4 players
            blue1.setNumber(1);
            blue1.color =Color.BLUE;
            blue1.setX(DFBlue1X);
            blue1.setY(DFYBlue);
           // Pawn.setXY(blue1,position,g);
            blue1.setImage("images/pawns/bluePawn1.png");

            blue2.setNumber(2);
            blue2.color =Color.BLUE;
            blue2.setX(DFBlue2X);
            blue2.setY(DFYBlue);
           // Pawn.setXY(blue2,position,g);
            blue2.setImage("images/pawns/bluePawn2.png");

            green1.setNumber(1);
            green1.color =Color.GREEN;
            green1.setX(DFGreen1X);
            green1.setY(DFYGreen);
          //  Pawn.setXY(green1,position,g);
            green1.setImage("images/pawns/greenPawn1.png");
            green2.setNumber(2);
            green2.color =Color.GREEN;
            green2.setX(DFGreen2X);
            green2.setY(DFYGreen);
           // Pawn.setXY(green2,position,g);
            green2.setImage("images/pawns/greenPawn2.png");
            //System.out.println(Pawn.x);
        }else{
            //2 players
            /*red1.setNumber(1);
            red1.color =Color.RED;
            Pawn.setXY(red1,position,g);

            red2.setNumber(2);
            red2.color =Color.RED;
            Pawn.setXY(red2,position,g);
            yellow1.setNumber(1);
            yellow1.color= Color.YELLOW;
            Pawn.setXY(yellow1,position,g);
            yellow2.setNumber(2);
            yellow2.color= Color.YELLOW;
            Pawn.setXY(yellow2,position,g);*/
        }
        /* red1.setNumber(1);
        red1.color =Color.RED;
        Pawn.setXY(red1,position,g);
        red1.setName("redPawn1");
        red1.setX(-55);
        red1.setY(60);
        //System.out.println(red1.x);

        red2.setNumber(2);
        red2.color =Color.RED;
        Pawn.setXY(red2,position,g);
        red2.setName("redPawn2");
        red2.setX(35);
        red2.setY(60);
        System.out.println(red2.x);*/
        red1.setNumber(1);
        red1.color =Color.RED;
       // Pawn.setXY(red1,position,g);
        //System.out.println(red1.x);
        red1.setX(DFRed1X);
        red1.setY(DFYRed);
        red1.setImage("images/pawns/redPawn1.png");

        red2.setNumber(2);
        red2.color =Color.RED;
       // Pawn.setXY(red2,position,g);
        red2.setX(DFRed2X);
        red2.setY(DFYRed);
        red2.setImage("images/pawns/redPawn2.png");

        yellow1.setNumber(1);
        yellow1.color= Color.YELLOW;
       // Pawn.setXY(yellow1,position,g);
        yellow1.setX(DFYellow1X);
        yellow1.setY(DFYYellow);
        yellow1.setImage("images/pawns/yellowPawn1.png");

        yellow2.setNumber(2);
        yellow2.color= Color.YELLOW;
        yellow2.setX(DFYellow2X);
        yellow2.setY(DFYYellow);
       // Pawn.setXY(yellow2,position,g);
//        yellow2.setImage("images/pawns/yellowPawn2.png");

     //   System.out.println(Pawn.image);
        if (result!=0){
            plPlayers=result+2;
        }
        if (Deck.plPlayers!=2){
          //  Pawns[0] = new String[]{"images/pawns/redPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/greenPawn1.png"};
           // Pawns[1] = new String[]{"images/pawns/redPawn2.png", "images/pawns/bluePawn2.png", "images/pawns/yellowPawn2.png", "images/pawns/greenPawn2.png"};
            TextTurn[0] = new String[]{"Player 1 (Red)", "Player 2 (Blue)", "Player 3 (Yellow)", "Player 4 (Green)"};
        }else{
            //Pawns[0] = new String[]{"images/pawns/redPawn1.png", "images/pawns/yellowPawn1.png", "images/pawns/bluePawn1.png", "images/pawns/greenPawn1.png"};
          //  Pawns[1] = new String[]{"images/pawns/redPawn2.png", "images/pawns/yellowPawn2.png", "images/pawns/bluePawn2.png", "images/pawns/greenPawn2.png"};
            TextTurn[0] = new String[]{"Player 1 (Red)", "Player 2 (Yellow)", "Player 3 (Blue)", "Player 4 (Green)"};
        }
        rand = ((Math.random() * plPlayers) + 1);
        turn = (int)rand;

        if (turn==1){
            CurrPawn.color=Color.RED;
            if (CurrPawn.y!=DFYRed){
                //CurrStartPawn=true;
            }else {
                //CurrStartPawn=false;
            }
        }else if (turn==2){
            if (plPlayers!=2) {
                CurrPawn.color = Color.BLUE;
                if (CurrPawn.y!=DFYBlue){
                    //CurrStartPawn=true;
                }else {
                    //CurrStartPawn=false;
                }
            }else {
                CurrPawn.color = Color.YELLOW;
                if (CurrPawn.y!=DFYYellow){
                    //CurrStartPawn=true;
                }else {
                    //CurrStartPawn=false;
                }
            }
        } else if (turn == 3) {
            CurrPawn.color = Color.YELLOW;
            if (CurrPawn.y!=DFYYellow){
                //CurrStartPawn=true;
            }else {
                //CurrStartPawn=false;
            }
        }else{
            CurrPawn.color = Color.GREEN;
            if (CurrPawn.y!=DFYGreen){
                //CurrStartPawn=true;
            }else {
                ////CurrStartPawn=false;
            }
        }
        CurrentPawnNum=1;
        CurrPawn.setNumber(1);
        if (!CurrStartPawn) {
            if (position == 0 || position == 1 || position == 2) {
            //    CheckPositionsAtBoard2(CurrPawn,position,g);
            }
        }
     //   currX = CurrPawn.x;
       // currY = CurrPawn.y;
      //  CurrStartPawn=CheckPositionsAtBoard2(CurrPawn,position,g);


        if (turn!=0&&CardsLeft==44){
            flagStart=true;
        }
        if (plPlayers!=2){
            Pawns[0][0]="images/pawns/redPawn1.png";
            Pawns[1][0]="images/pawns/redPawn2.png";
            Pawns[0][1]="images/pawns/bluePawn1.png";
            Pawns[1][1]="images/pawns/bluePawn2.png";
            Pawns[0][2]="images/pawns/yellowPawn1.png";
            Pawns[1][2]="images/pawns/yellowPawn2.png";
            Pawns[0][3]="images/pawns/greenPawn1.png";
            Pawns[1][3]="images/pawns/greenPawn2.png";

            PawnsName[0][0]="redPawn1";
            PawnsName[1][0]="redPawn2";
            PawnsName[0][1]="bluePawn1";
            PawnsName[1][1]="bluePawn2";
            PawnsName[0][2]="yellowPawn1";
            PawnsName[1][2]="yellowPawn2";
            PawnsName[0][3]="greenPawn1";
            PawnsName[1][3]="greenPawn2";
        }else{
            Pawns[0][0]="images/pawns/redPawn1.png";
            Pawns[1][0]="images/pawns/redPawn2.png";
            Pawns[0][1]="images/pawns/yellowPawn1.png";
            Pawns[1][1]="images/pawns/yellowPawn2.png";
            Pawns[0][2]="images/pawns/bluePawn1.png";
            Pawns[1][2]="images/pawns/bluePawn2.png";
            Pawns[0][3]="images/pawns/greenPawn1.png";
            Pawns[1][3]="images/pawns/greenPawn2.png";
            PawnsName[0][0]="redPawn1";
            PawnsName[1][0]="redPawn2";
            PawnsName[0][2]="bluePawn1";
            PawnsName[1][2]="bluePawn2";
            PawnsName[0][1]="yellowPawn1";
            PawnsName[1][1]="yellowPawn2";
            PawnsName[0][3]="greenPawn1";
            PawnsName[1][3]="greenPawn2";
        }
        /*
        if (turn==1){
            CurrPawn.color = Color.RED;
        }else if (turn==2){
            if (plPlayers!=2) {
                CurrPawn.color = Color.BLUE;
            }else {
                CurrPawn.color = Color.YELLOW;
            }
        } else if (turn==3) {
            CurrPawn.color = Color.YELLOW;
        }else{
            CurrPawn.color = Color.GREEN;
        }*/
        if (CurrentPawnNum==1){
            CurrPawn.setNumber(1);
        }else {
            CurrPawn.setNumber(2);
        }
        CurrentPawnNum = CurrPawn.getNumber();

        if (CurrentPawnNum==1){
            if (turn==1){
                CurrPawn.setName("redPawn1");
            }else if (turn==2){
                if (plPlayers!=2) {
                    CurrPawn.setName("bluePawn1");
                }else {
                    CurrPawn.setName("yellowPawn1");
                }
            } else if (turn == 3) {
                CurrPawn.setName("yellowPawn1");
            }else{
                CurrPawn.setName("greenPawn1");
            }

        }else{
            if (turn==1){
                CurrPawn.setName("redPawn2");
            }else if (turn==2){
                if (plPlayers!=2) {
                    CurrPawn.setName("bluePawn2");
                }else {
                    CurrPawn.setName("yellowPawn2");
                }
            } else if (turn == 3) {
                CurrPawn.setName("yellowPawn2");
            }else{
                CurrPawn.setName("greenPawn2");
            }
        }
        if (CurrPawn.color==Color.RED){
            if (plPlayers==4){
                PawnsNameWOcurr4[0][0]="bluePawn1";
                PawnsNameWOcurr4[0][1]="bluePawn2";
                PawnsNameWOcurr4[1][0]="yellowPawn1";
                PawnsNameWOcurr4[1][1]="yellowPawn2";
                PawnsNameWOcurr4[2][0]="greenPawn1";
                PawnsNameWOcurr4[2][1]="greenPawn2";

            }else if (plPlayers==3){
                PawnsNameWOcurr3[0][0]="bluePawn1";
                PawnsNameWOcurr3[0][1]="bluePawn2";
                PawnsNameWOcurr3[1][0]="yellowPawn1";
                PawnsNameWOcurr3[1][1]="yellowPawn2";

            }else{
                PawnsNameWOcurr2[0][0]="yellowPawn1";
                PawnsNameWOcurr2[0][1]="yellowPawn2";

            }


        }else if (CurrPawn.color==Color.YELLOW){
            if (plPlayers==4){
                PawnsNameWOcurr4[1][0]="bluePawn1";
                PawnsNameWOcurr4[1][1]="bluePawn2";
                PawnsNameWOcurr4[0][0]="redPawn1";
                PawnsNameWOcurr4[0][1]="redPawn2";
                PawnsNameWOcurr4[2][0]="greenPawn1";
                PawnsNameWOcurr4[2][1]="greenPawn2";

            }else if (plPlayers==3){
                PawnsNameWOcurr3[1][0]="bluePawn1";
                PawnsNameWOcurr3[1][1]="bluePawn2";
                PawnsNameWOcurr3[0][0]="redPawn1";
                PawnsNameWOcurr3[0][1]="redPawn2";

            }else{
                PawnsNameWOcurr2[0][0]="redPawn1";
                PawnsNameWOcurr2[0][1]="redPawn2";

            }

        } else if (CurrPawn.color==Color.BLUE) {
            if (plPlayers==4){
                PawnsNameWOcurr4[0][0]="redPawn1";
                PawnsNameWOcurr4[0][1]="redPawn2";
                PawnsNameWOcurr4[1][0]="yellowPawn1";
                PawnsNameWOcurr4[1][1]="yellowPawn2";
                PawnsNameWOcurr4[2][0]="greenPawn1";
                PawnsNameWOcurr4[2][1]="greenPawn2";

            }else if (plPlayers==3){
                PawnsNameWOcurr3[0][0]="redPawn1";
                PawnsNameWOcurr3[0][1]="redPawn2";
                PawnsNameWOcurr3[1][0]="yellowPawn1";
                PawnsNameWOcurr3[1][1]="yellowPawn2";

            }
                    /*else{
                        PawnsNameWOcurr3[0][0]="yellowPawn1";
                        PawnsNameWOcurr3[0][1]="yellowPawn2";
                    }*/

        }else {
            if (plPlayers==4){
                PawnsNameWOcurr4[1][0]="bluePawn1";
                PawnsNameWOcurr4[1][1]="bluePawn2";
                PawnsNameWOcurr4[0][0]="redPawn1";
                PawnsNameWOcurr4[0][1]="redPawn2";
                PawnsNameWOcurr4[2][0]="yellowPawn1";
                PawnsNameWOcurr4[2][1]="yellowPawn2";

            }
                    /*else if (plPlayers==3){
                        PawnsNameWOcurr3[1][0]="bluePawn1";
                        PawnsNameWOcurr3[1][1]="bluePawn2";
                        PawnsNameWOcurr3[0][0]="yellowPawn1";
                        PawnsNameWOcurr3[0][1]="yellowPawn2";
                    }else{
                        PawnsNameWOcurr3[0][0]="redPawn1";
                        PawnsNameWOcurr3[0][1]="redPawn2";
                    }*/

        }

     //   currX = CurrPawn.x;
       // currY = CurrPawn.y;

        //g.drawString("Player 4 (Green)",735,459);

        //g.drawString(TextTurn[0][turn],textX-45,textY-50);

       // System.out.println(turn);
        //System.out.println(position);
        /*Random rand = new Random();
        rand.nextInt(4)+1;*/
        //position=0;

    }

    /**gives user the option to move or change positions with opponent*/
    public static void Choose11(){

        String[][] arr = new String[3][3];
        result11 = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options11,
                options11[0]
        );

        // Check the user's choice
        if (result11 == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + options11[result11]);
            if (result11==1){/*
                if (CurrPawn.color==Color.RED){
                    if (plPlayers==4){
                        PawnsNameWOcurr4[0][0]="bluePawn1";
                        PawnsNameWOcurr4[0][1]="bluePawn2";
                        PawnsNameWOcurr4[1][0]="yellowPawn1";
                        PawnsNameWOcurr4[1][1]="yellowPawn2";
                        PawnsNameWOcurr4[2][0]="greenPawn1";
                        PawnsNameWOcurr4[2][1]="greenPawn2";
                        ChooseOpponent(PawnsNameWOcurr4);
                        arr = PawnsNameWOcurr4;
                    }else if (plPlayers==3){
                        PawnsNameWOcurr3[0][0]="bluePawn1";
                        PawnsNameWOcurr3[0][1]="bluePawn2";
                        PawnsNameWOcurr3[1][0]="yellowPawn1";
                        PawnsNameWOcurr3[1][1]="yellowPawn2";
                        ChooseOpponent(PawnsNameWOcurr3);
                        arr = PawnsNameWOcurr3;
                    }else{
                        PawnsNameWOcurr2[0][0]="yellowPawn1";
                        PawnsNameWOcurr2[0][1]="yellowPawn2";
                        ChooseOpponent(PawnsNameWOcurr2);
                        arr = PawnsNameWOcurr2;
                    }


                }else if (CurrPawn.color==Color.YELLOW){
                    if (plPlayers==4){
                        PawnsNameWOcurr4[1][0]="bluePawn1";
                        PawnsNameWOcurr4[1][1]="bluePawn2";
                        PawnsNameWOcurr4[0][0]="redPawn1";
                        PawnsNameWOcurr4[0][1]="redPawn2";
                        PawnsNameWOcurr4[2][0]="greenPawn1";
                        PawnsNameWOcurr4[2][1]="greenPawn2";
                        ChooseOpponent(PawnsNameWOcurr4);
                        arr = PawnsNameWOcurr4;
                    }else if (plPlayers==3){
                        PawnsNameWOcurr3[1][0]="bluePawn1";
                        PawnsNameWOcurr3[1][1]="bluePawn2";
                        PawnsNameWOcurr3[0][0]="redPawn1";
                        PawnsNameWOcurr3[0][1]="redPawn2";
                        ChooseOpponent(PawnsNameWOcurr3);
                        arr = PawnsNameWOcurr3;
                    }else{
                        PawnsNameWOcurr2[0][0]="redPawn1";
                        PawnsNameWOcurr2[0][1]="redPawn2";
                        ChooseOpponent(PawnsNameWOcurr2);
                        arr = PawnsNameWOcurr2;
                    }

                } else if (CurrPawn.color==Color.BLUE) {
                    if (plPlayers==4){
                        PawnsNameWOcurr4[0][0]="redPawn1";
                        PawnsNameWOcurr4[0][1]="redPawn2";
                        PawnsNameWOcurr4[1][0]="yellowPawn1";
                        PawnsNameWOcurr4[1][1]="yellowPawn2";
                        PawnsNameWOcurr4[2][0]="greenPawn1";
                        PawnsNameWOcurr4[2][1]="greenPawn2";
                        ChooseOpponent(PawnsNameWOcurr4);
                        arr = PawnsNameWOcurr4;
                    }else if (plPlayers==3){
                        PawnsNameWOcurr3[0][0]="redPawn1";
                        PawnsNameWOcurr3[0][1]="redPawn2";
                        PawnsNameWOcurr3[1][0]="yellowPawn1";
                        PawnsNameWOcurr3[1][1]="yellowPawn2";
                        ChooseOpponent(PawnsNameWOcurr3);
                        arr = PawnsNameWOcurr3;
                    }
                    *//*else{
                        PawnsNameWOcurr3[0][0]="yellowPawn1";
                        PawnsNameWOcurr3[0][1]="yellowPawn2";
                    }*//*

                }else {
                    if (plPlayers==4){
                        PawnsNameWOcurr4[1][0]="bluePawn1";
                        PawnsNameWOcurr4[1][1]="bluePawn2";
                        PawnsNameWOcurr4[0][0]="redPawn1";
                        PawnsNameWOcurr4[0][1]="redPawn2";
                        PawnsNameWOcurr4[2][0]="yellowPawn1";
                        PawnsNameWOcurr4[2][1]="yellowPawn2";
                        ChooseOpponent(PawnsNameWOcurr4);
                        arr = PawnsNameWOcurr4;
                    }
                    *//*else if (plPlayers==3){
                        PawnsNameWOcurr3[1][0]="bluePawn1";
                        PawnsNameWOcurr3[1][1]="bluePawn2";
                        PawnsNameWOcurr3[0][0]="yellowPawn1";
                        PawnsNameWOcurr3[0][1]="yellowPawn2";
                    }else{
                        PawnsNameWOcurr3[0][0]="redPawn1";
                        PawnsNameWOcurr3[0][1]="redPawn2";
                    }*//*

                }*/

                /*if (plPlayers==4){
                    for (int i=0;i<4;i++){
                        for (int j=0;j<2;j++) {
                            arr[i][j] = PawnsNameWOcurr4[i][j];
                        }
                    }
                }else if (plPlayers==3){
                    for (int i=0;i<3;i++){
                        for (int j=0;j<2;j++) {
                            arr[i][j] = PawnsNameWOcurr3[i][j];
                        }
                    }
                }else{
                    for (int i=0;i<2;i++){
                        for (int j=0;j<2;j++) {
                            arr[i][j] = PawnsNameWOcurr2[i][j];
                        }
                    }
                }
*/
                result11op = JOptionPane.showOptionDialog(
                        null,
                        "Choose an opponent:",
                        "Choice",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        PlayersName,
                        PlayersName[0]
                );

                // Check the user's choice
                if (result11op == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Dialog closed without a choice");
                } else {
                    System.out.println("User chose: " + PlayersName[result11op]);
                    if (result11op==0){
                        PawnsNme[0][0]="redPawn1";
                        PawnsNme[0][1]="redPawn2";

                    }else if (result11op==1){
                        PawnsNme[0][0]="bluePawn1";
                        PawnsNme[0][1]="bluePawn2";

                    }else if (result11op==2){
                        PawnsNme[0][0]="yellowPawn1";
                        PawnsNme[0][1]="yellowPawn2";

                    }else {
                        PawnsNme[0][0]="greenPawn1";
                        PawnsNme[0][1]="greenPawn2";
                    }
                    result11op = JOptionPane.showOptionDialog(
                            null,
                            "Choose an opponent:",
                            "Choice",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            PawnsNme,
                            PawnsNme[0]
                    );

                    // Check the user's choice
                    if (result11op == JOptionPane.CLOSED_OPTION) {
                        System.out.println("Dialog closed without a choice");
                    } else {
                        System.out.println("User chose: " + PlayersName[result11op]);
                    }

                }
            }
        }
    }
    /**gives user the options of opponents to change positions*/
    public static void ChooseOpponent(String[][] arr){
        result11op = JOptionPane.showOptionDialog(
                null,
                "Choose an opponent:",
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                arr,
                arr[0]
        );

        // Check the user's choice
        if (result11op == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + arr[result11op]);
        }
    }
    /**gives user the options to make 10 moves front or 1 move back*/
    public static void Choose10(){
        if (Cards11[Ci].equals("images/cards/card10.png")){
            result10 = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Choice",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options10,
                    options10[0]
            );

            // Check the user's choice
            if (result10 == JOptionPane.CLOSED_OPTION) {
                System.out.println("Dialog closed without a choice");
            } else {
                System.out.println("User chose: " + options10[result10]);

            }
        }else if (Cards11[Ci].equals("images/cards/card7.png")){
            result7 = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Choice",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options7,
                    options7[0]
            );

            // Check the user's choice
            if (result7 == JOptionPane.CLOSED_OPTION) {
                System.out.println("Dialog closed without a choice");
            } else {
                System.out.println("User chose: " + options7[result7]);

            }
        }

    }
    /**gives user the option to make the move or take new card*/
    public static void Choose85(){
        String[] arr = new String[2];
        if (Cards11[Ci].equals("images/cards/card8.png")){
            arr = options8;
            text85="8 moves front";
        }else if (Cards11[Ci].equals("images/cards/card12.png")){
            text85="12 moves front";
            arr = options12;
        }
        result85 = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                arr,
                arr[0]
        );

        // Check the user's choice
        if (result85 == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + arr[result85]);
            if (result85==1){
                flag85 = true;
            }else{
                flag85 = false;
            }

        }
    }
    /**give user the options to make 7 moves with one pawn or 7 moves using two pawns
     * and the sum of pawn's moves must be 7*/
    public static void Choose7(){
        String text= "Choose an option:";
        int answer=0;
        sum=0;
        result7 = JOptionPane.showOptionDialog(
                null,
                text,
                "Choice",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options7,
                options7[0]
        );

        // Check the user's choice
        if (result7 == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a choice");
        } else {
            System.out.println("User chose: " + options7[result7]);
            if (result7==1){
/*
                do {
                    result71 = JOptionPane.showOptionDialog(
                            null,
                            text,
                            "Choice",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options71,
                            options71[0]
                    );

                    // Check the user's choice
                    if (result71 == JOptionPane.CLOSED_OPTION) {
                        System.out.println("Dialog closed without a choice");
                    } else {
                        System.out.println("User chose: " + options71[result71]);
                    }
                    result711 = JOptionPane.showOptionDialog(
                            null,
                            text,
                            "Choice",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options71,
                            options71[0]
                    );

                    // Check the user's choice
                    if (result711 == JOptionPane.CLOSED_OPTION) {
                        System.out.println("Dialog closed without a choice");
                    } else {
                        System.out.println("User chose: " + options71[result711]);

                    }
                    sum = result71 + result711 + 2;
                }while(sum==7);
*/

                answer = JOptionPane.showOptionDialog(
                        null,
                        text,
                        "Choice",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options71,
                        options71[0]
                );

                // Check the user's choice
                if (answer == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Dialog closed without a choice");
                } else {
                    System.out.println("User chose: " + options71[answer]);
                    JOptionPane.showMessageDialog(null, "1st pawn "+(1+answer)+" moves and 2nd pawn "+(6-answer)+" moves");


                    sum+=answer+1;
                    //System.out.println(answer+sum);
                }
                /*do {
                    for (int i = 0; i < 2; i++) {
                        if (i == 0) {
                            answer = result71;
                            text = "Choose how many moves you want for your 1st pawn:";
                        } else {
                            result711=answer;
                            answer = result711;
                            text = "Choose how many moves you want for your 2st pawn:";
                        }
                        answer = JOptionPane.showOptionDialog(
                                null,
                                text,
                                "Choice",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options71,
                                options71[0]
                        );

                        // Check the user's choice
                        if (answer == JOptionPane.CLOSED_OPTION) {
                            System.out.println("Dialog closed without a choice");
                        } else {
                            System.out.println("User chose: " + options71[answer]);

                            sum+=answer+1;
                            //System.out.println(answer+sum);
                        }
                    }
                }while(7-result711==answer);
*/
            }

        }

    }


    /**
     * Constructs a new SquareOfSquares instance.
     * Sets up the initial properties of the frame and adds a SquarePanel to it.
     */
    public Deck() {
        setTitle("Sorry Game");
        setSize(1035,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FoldButton foldButton = new FoldButton("Fold Button");
        foldButton.setBounds(680 - 12, 400 - 70, 200 + 112, 200 - 145);
        foldButton.setFontSize(18);
        add(foldButton);


       // drawImageInCenter2(g,"images/slides/foldb.png",1100,530,  250,70);


        /*backgroundLabel = new JLabel();
        try{
            ImageIcon backgroundImageIcon = new ImageIcon(ImageIO.read(new File("images/background.png")));
            backgroundLabel.setIcon(backgroundImageIcon);
        }catch (IOException e){
            e.printStackTrace();
        }
        backgroundLabel.setLayout(null);
        JButton button = new JButton("Click me");
        backgroundLabel.add(button);
        setContentPane(backgroundLabel);
        setVisible(true);*/

        /*URL imageURL2 = getClass().getResource("images/background.png");
        Image bakgroundImage = new ImageIcon(imageURL2).getImage();
        basic_panel = new JLayeredPaneExtension(bakgroundImage);
        SquarePanel squarePanel2 = new SquarePanel();
        basic_panel.add(squarePanel2, JLayeredPaneExtension.PALETTE_LAYER);
        setContentPane(basic_panel);
        setLocationRelativeTo(null);
        cldr = this.getClass().getClassLoader();
        URL imageURL = cldr.getResource("images/background.png");
        Image image = new ImageIcon(imageURL).getImage();
        basic_panel = new JLayeredPaneExtension(image);
        *///setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(Color.CYAN);
/*        assert cldr !=null;

        URL imageURL = cldr.getResource("images/background.png"); //image
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();
        basic_panel = new JLayeredPaneExtension(image);*/
/*        Square.drawSquareOfSquares();
        SafetyZoneSquare.drawSafetyZoneSquare();
        StartSquare.drawCustomSquare();
        HomeSquare.drawCustomSquare();
        StartSlideSquare.drawStartSlideSquare();
        InternalSlideSquare.drawInternalSlideSquare();
        EndSlideSquare.drawEndSlideSquare();*/

        Board.initCards();
         //PawnsAtBoard=Board.PawnsPositionsAtBoard();
        for (int i=0 ;i<16;i++){
            for (int j=0; j<16;j++){
                PawnsAtBoard[i][j]="69";
            }
        }
        /*position = Ci;
        position = 0;
        if (Ci==4){
            direction = -1;
        }else {
            direction = 1;
        }*/
        position = 1;

        /*if (FoldButton.clicked){
            plCardsLeft[Ci]--;
            if (plCardsLeft[Ci]>0){
                //emfanhse
            }else {
                Cards11[Ci]="69";
            }
        }*/

        /*for (int i=0;i<11;i++) {


            *//*if (Ci != 4 && Ci != 0) {
                position = i;
            } else if () {

            }*//*
        }*/
        /*playersCurrentCard.setBounds(1445,10,500,1300);
        add(playersCurrentCard);*/
         X=Board.MakeX();
         Y=Board.MakeY();
        checkCards();
        initPawns();
        //MovePlayer(position);
        foldB();
       // Ci=0;

        if (!flagStart) {
            if (Ci == 0 || Ci == 1 || Ci == 2) {
                //you can start
                CheckPositionsAtBoard(position, g);
            }else{
                //press fold button
            }
        }else{
           // CheckPositionsAtBoard(position,g);
        }
        //boolean fl=CheckPositionsAtBoard(position,g);
        SquarePanel squarePanel = new SquarePanel();
        add(squarePanel);

        //position=2;
       // UpdateCard();

        setLocationRelativeTo(null); // Center the JFrame
        /*Square.square(g);
        SafetyZoneSquare.safetyZoneSquare(g);
        StartSlideSquare.startSlideSquare(g);
        InternalSlideSquare.internalSlideSquare(g);
        EndSlideSquare.endSlideSquare(g);
        HomeSquare.homeSquare(g);

        StartSquare.startSquare(g);*/

    }



    /**
     * Gets the last card played on the board.
     *
     * @return the last card played.
     */
    public Card getLastCardPlayed() {
        return lastCardPlayed;
    }

    /**
     * Moves a player on the board based on a card's value.
     *
     * @param player the player to move.
     * @param c the card used for the movement.
     * @return {@code true} if the player successfully moved, {@code false} otherwise.
     */
    public boolean movePlayer(Player player, Card c){
        if(player.getPosition()+c.getValue()>9)
            return false;
        player.movePosition(c.getValue());
        return true;
    }

    /**
     * Sets the last card played on the board.
     *
     * @param lastCardPlayed the last card played.
     */
    public void setLastCardPlayed(Card lastCardPlayed) {
        String image = Board.lastCardPlayed.getImage();
        URL imageURL4 = cldr.getResource(lastCardPlayed.getImage());
        Image image5 = new ImageIcon(imageURL4).getImage();
        image5 = image5.getScaledInstance(60,70, Image.SCALE_SMOOTH);
        playersCurrentCard.setIcon(new ImageIcon(image5));
       // this.lastCardPlayed = lastCardPlayed;
    }

    /**
     * The main method to launch the SquareOfSquares application.
     * Creates an instance of SquareOfSquares and sets it to be visible.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
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
            SwingUtilities.invokeLater(() -> {

                new Deck().setVisible(true);

                //new NumberElevenCard(yellow1);
            });
        }

        /*SwingUtilities.invokeLater(() -> {
            new Deck().setVisible(true);
        });*/
    }

    /**
     * A nested class representing the panel within the SquareOfSquares frame.
     * It extends JPanel and handles custom painting of the panel.
     */
    public static class SquarePanel extends JPanel {
        private Image image1;
        private Image image2;
/*
        *//**
         * Constructs a new CyanPanel instance.
         * Loads two images for later use.
         *//*
        public void CyanPanel() {
            // Load the images
            loadImage("images/background.png");
            loadImage("images/sorryImage.png");
        }*/
/*

        */
/**
         * Loads an image from the specified file path and assigns it to one of two image variables (image1 or image2).
         * This method is used to load images for custom squares in the SquarePanel class.
         *
         * @param //imagePath The path to the image file.
         *//*

        private void loadImage(String imagePath) {
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                ImageIcon imageIcon = new ImageIcon(imageURL);
                if (image1 == null) {
                    image1 = imageIcon.getImage();
                } else if (image2 == null) {
                    image2 = imageIcon.getImage();
                }
            } else {
                // Handle image loading failure
                System.out.println("Image loading failed for: " + imagePath);
            }
        }
*/
/*@Override
public void UpdateCard(){
    if (Deck.position!=-3) {
        drawImageInCenter2(g, Cards11[Ci], 1405, 365, 100, 130);
    }
}*/
        //homeSquare(g);
        /**
         * Overrides the paintComponent method to paint the custom graphics on the panel.
         *
         * @param g The Graphics object used for painting.
         */
        @Override
        protected void paintComponent(Graphics g) {
            //plCardsLeft[Ci]--;
            //System.out.println("aaaaa");
            super.paintComponent(g);
            drawSquareOfSquares(g);
            drawCustomSquare(g, 490, 300, 100);//yellow
            drawCustomSquare(g, 53, 253, 100);//red
            drawCustomSquare(g, 135, 53, 90);//red
            drawCustomSquare(g, 415, 510, 90);//yellow
            //drawImageSquare(g,550,10,"images/background.png");
            drawImageInCenter2(g,"images/background.png",1405,10,500,1300);
            drawImageInCenter2(g,"images/cards/backCard.png",1100,365,100,130);
            drawCustomSquare(g,680,400,200);
           //drawImageInCenter2(g,"images/slides/foldb.png",1100,460,  250,70);


            //UpdateCard();
           // position=2;
            if (Deck.position!=-3) {
                drawImageInCenter2(g, Cards11[Ci], 1405, 365, 100, 130);
                repaint();
                //plCardsLeft[Ci]--;
                //System.out.println(plCardsLeft[Ci]);
            }
           // playersCurrentCard.setBounds(1445,10,500,1300);
           // add(playersCurrentCard);
           // plPlayers=2;
            if (Objects.equals(options[result], "3 players")){
                plPlayers=3;
                drawCustomSquare(g, 504, 143, 90);//blue start
                drawCustomSquare(g, 304, 60, 90);//blue house

            }else if (options[result].equals("4 players")){
                plPlayers=4;
                drawCustomSquare(g, 504, 143, 90);//blue start
                drawCustomSquare(g, 46, 417, 100);//green start
                drawCustomSquare(g, 304, 60, 90);//blue house
                drawCustomSquare(g, 247, 495, 90);//green house
            }




            //g.drawString("Player 4 (Green)",735,459);

            /*if (turn!=tx){
                g.drawString(TextTurn[0][turn-1]*//*Player "*//*,735,459);
                tx=turn;
            }*/
            /*g.drawString(TextTurn[0][turn-1],735,459);
            if (FoldButton.clicked){
                g.drawString(TextTurn[0][turn-1],735,459);

            }*/

            /*JButton buttonf = new JButton("Fold Botton");
            buttonf.setBounds(300,85,50,10);
            buttonf.setVisible(true);*/
            /*JLabel label = new JLabel("Last Card Played");
            label.setBounds(700, 85, 100, 10);
            setVisible(true);*/
/*
            Deck frame = new Deck();
            frame.setLayout(new FlowLayout());
            frame.setSize(new Dimension(300,50));
            frame.setTitle("Fold Button");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/


        }
        // Adjust the position and size as needed

        /**
         * Draws a custom square on the specified Graphics object at the given position and size.
         * The appearance and content of the square are determined by the provided parameters.
         *
         * @param g     The Graphics object on which to draw the custom square.
         * @param x     The x-coordinate of the top-left corner of the square.
         * @param y     The y-coordinate of the top-left corner of the square.
         * @param size  The size (width and height) of the square.
         */
        private void drawCustomSquare(Graphics g, int x, int y, int size) {
            String color = "";
            String text ="";
            int startX = (getWidth() - size * GRID_SIZE) / 2;
            int startY = (getHeight() - size * GRID_SIZE) / 2;
            boolean flag = true;



            //g.setColor(Color.RED);

            // Draw the perimeter of the custom square
            /*g.drawRect(x, y, size, size);

            // Set the color to a custom color (e.g., yellow) for the fill
            g.setColor(Color.WHITE);

            // Draw the custom square
            g.fillRect(x + 1, y + 1, size -1, size-1 );
*/
            if (x==680){
                //g.setColor(Color.BLACK);
                g.fillRect(x - 12, y, size+112, size-75);
                g.setColor(Color.WHITE);

                // Draw the custom square at the specified position and size
                g.fillRect(x-6, y+6, size+100, size-88);
                g.setColor(Color.BLACK);

            }
            if (x==490||x==415) {
                // Set the color to a custom color (e.g., red)
                color="YELLOW";
                g.setColor(Color.YELLOW);
            }else if (x==504||x==304){
                color="BLUE";
                g.setColor(Color.BLUE);
            }else if (x==46||x==247){
                color="GREEN";
                g.setColor(Color.GREEN);
            }else if (x!=680){
                color="RED";
                g.setColor(Color.RED);
            }
            if (x==490||x==53||x==304||x==247){
                text = "Home";
            }else if (x!=680){
                text="Start";
                /*ImageIcon a = new ImageIcon("images/pawns/yellowPawn1.png");
                Image b = a.getImage();
                ImageIcon c = new ImageIcon(b.getScaledInstance(40,40, Image.SCALE_DEFAULT));
                JLabel label = new JLabel();
                label.setIcon(c);
                label.setBounds(155,53, 40,40);
                add(label);*/
                /*if (color=="RED"){

                    drawImageInCenter2(g, "images/pawns/redPawn1.png",200,53,40,40);
                    //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                    //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                }else {
                    drawImageInCenter2(g, "images/pawns/yellowPawn1.png",490,800,40,40);
                }
*/


                //drawImageSquare(g, startX + x * size, startY + y * size, "images/pawns/redPawn1.png");
            }else {
                text = "Info Box";
            }

            if (x!=680) {

                // Draw the custom square at the specified position and size
                //g.fillRect(x, y, size, size);
                g.fillRect(x - 6, y - 6, size + 12, size + 12);
                g.setColor(Color.WHITE);

                // Draw the custom square at the specified position and size
                g.fillRect(x, y, size, size);
                g.setColor(Color.BLACK);
            }

            Font font = new Font("Arial", Font.BOLD, 24);
            g.setFont(font);

            // Calculate the position to center the text
            FontMetrics fontMetrics = g.getFontMetrics();
            int textX = x + (size - fontMetrics.stringWidth(text)) / 2;
            int textY = y + (size + fontMetrics.getAscent() - fontMetrics.getDescent()) / 2;

            if (color=="RED"){
                g.drawString(text, textX, textY+25);
                //drawImageSquare(g, startX + 155 * SQUARE_SIZE, startY + 53 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                //drawImageSquare(g, startX + 400 * SQUARE_SIZE, startY + 53 * SQUARE_SIZE, "images/pawns/redPawn1.png");

            }else if(x!=680){
                g.drawString(text, textX, textY-25);

            }else {
                Font font1 = new Font("Arial", Font.BOLD, 18);
                g.setFont(font1);
                g.drawString(text,textX-45,textY-80);
                g.drawString("Turn: ",textX-45,textY-50);
               // g.drawString("Turn: "+TextTurn[0][turn-1],735,459);
                g.drawString("Cards Left: "+CardsLeft,textX-45,textY-30);
               // repaint();

                g.drawString(TextTurn[0][turn-1],735,459);
               // repaint();
              // JLabel turnLabel = new JLabel("Turn: "+TextTurn[0][turn-1]);

               // repaint();
               //turnLabel.setText("Turn: "+TextTurn[0][turn-1]);
                /*JLabel textLabel = new JLabel(TextTurn[0][turn-1]);
                textLabel.paintImmediately(textLabel.getVisibleRect());
                */
                /*
                if (turn==1){
                    g.drawString("Player 1 (Red)",735,459);
                } else if (turn==2&& plPlayers!=2) {
                    g.drawString("Player 2 (Blue)",735,459);

                } else if (turn==2) {
                    g.drawString("Player 2 (Yellow)",735,459);

                } else if (turn==3) {
                    g.drawString("Player 3 (Yellow)",735,459);

                } else if (turn==4) {
                    g.drawString("Player 4 (Green)",735,459);

                }
*/
            }
            if (x==680) {
                Font font2 = new Font("Arial", Font.BOLD, 18);
                g.setFont(font2);
                g.drawString("Receive Card", textX -50, textY - 190);
                g.drawString("Current Card", textX +100, textY - 190);
                /*JButton button = new JButton("fold");
                button.setBounds(50,85,300,50);
                button.setVisible(true);*/

                /*FoldButton foldButton = new FoldButton("Fold Button");
                foldButton.setBounds(x-12, y-70, size+112, size-145);
                add(foldButton);*/
                //setVisible(true);
            }

           // drawImageInCenter2(g,"images/slides/foldb.png",1100,550,  250,70);

            if (position==1||position==2){
                //BasicPanel.paintComponent();
              //  CheckPositionsAtBoard2(CurrPawn,position,g);
              //  repaint();
               // drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);

            }
            /*int[] newXY = NumberCard.MaketheCheck();
            boolean flagCcheck = CheckPositionsAtBoard2(CurrPawn,position,g);
            //repaint();
            if (flagCcheck) {
              //  drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], newXY[0], newXY[1], 40, 40);
                //repaint();
            }else {
                //press the fold button
            }


            */
           /* int[] newXY1=new int[2];
           *//* if (position==1||position==2) {
                 newXY1 = MaketheCheck();
               // System.out.println(newXY1[0]);
            }*//*
            newXY1 = MaketheCheck();
            if (position==5){
               // System.out.println(newXY1[1]);
            }*/
          //  System.out.println(newXY1[0]);
            String imagePath;
            if (CurrentPawnNum==1) {
                if (turn == 1) {
                    imagePath = "images/pawns/redPawn1.png";
                } else if (turn==2) {
                    if (plPlayers!=2) {
                        imagePath = "images/pawns/bluePawn1.png";
                    }else {
                        imagePath = "images/pawns/yellowPawn1.png";
                    }
                } else if (turn==3) {
                    imagePath = "images/pawns/yellowPawn1.png";
                } else {
                    imagePath = "images/pawns/greenPawn1.png";
                }
            }else {
                if (turn == 1) {
                    imagePath = "images/pawns/redPawn2.png";
                } else if (turn==2) {
                    if (plPlayers!=2) {
                        imagePath = "images/pawns/bluePawn2.png";
                    }else {
                        imagePath = "images/pawns/yellowPawn2.png";
                    }
                } else if (turn==3) {
                    imagePath = "images/pawns/yellowPawn2.png";
                } else {
                    imagePath = "images/pawns/greenPawn2.png";
                }
            }
          //  currX = newXY1[0];
            //currY = newXY1[1];
          //  System.out.println(newXY1[1]);
          //  System.out.println(currX);//swsto
            int[] newXY1 = new int[2];
            boolean flagcke=CheckPositionsAtBoard(position,g);
            if ((((position==1||position==2)/*&&direction==1*/)&&!CurrStartPawn) ){
               drawImageInCenter2(g, imagePath, new1XY[0], new1XY[1], 40, 40);
                repaint();
                CurrStartPawn = true;
                CurrPawn.setImage(imagePath);
               // drawImageInCenter2(g,image50,new1XY[0],new1XY[1],40,40);
                int x2 = new1XY[0];
                int y2 = new1XY[1];
//                PawnsAtBoard[x2][y2]=imagePath;
//                PawnsAtBoard[currX][currY]="69";
             //   System.out.println(newXY1[1]);

            }else if (CurrStartPawn&&flagcke){
                flag12 = flag1&flag21;


                    if (position == 1/*&&(!flag1)*/) {
                        sum1++;
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            sum1red++;
                            if (sum1red==1){
                                xred=600-610;
                              //  drawImageInCenter2(g, imagePath, new1XY[0] - 610, new1XY[1] - 1077, 40, 40);
                                //repaint();
                            }else {
                                xred+=position*80;
                               // drawImageInCenter2(g, imagePath, xred, new1XY[1] - 1077, 40, 40);
                             //   repaint();
                            }

                            drawImageInCenter2(g, imagePath, new1XY[0] - 610, new1XY[1] - 1077, 40, 40);
                           repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            sum1yellow++;
                            if (sum1yellow==1){
                                xyellow=600-50;
                             //   drawImageInCenter2(g, imagePath, new1XY[0] - 50, new1XY[1] + 123, 40, 40);
                               // repaint();

                            }else {
                                xyellow-=position*80;
                               // drawImageInCenter2(g, imagePath, xyellow, new1XY[1] + 123, 40, 40);
                               // repaint();
                            }

                            drawImageInCenter2(g, imagePath, new1XY[0] - 50, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            sum1blue++;
                            if (sum1blue==1){
                                yblue=1030-757;
                              //  drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 757, 40, 40);
                                //repaint();
                            }else {
                                yblue+=position*80;
                               // drawImageInCenter2(g, imagePath, new1XY[0] + 270, yblue, 40, 40);
                               // repaint();
                            }
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 757, 40, 40);
                            repaint();
                        } else {
                            sum1green++;
                            if (sum1green==1){
                                ygreen=1030-197;
                               // drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 197, 40, 40);
                             //   repaint();
                            }else {
                                ygreen-=position*80;
                              //  drawImageInCenter2(g, imagePath, new1XY[0] - 930, ygreen, 40, 40);
                               // repaint();
                            }
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 197, 40, 40);
                            repaint();
                        }
                        flag1 = true;
                    } else if (position == 2/*&&(!flag21)*/) {
                        sum2++;
                        /*if (sum2==1){
                            x21=600-530;
                        }else {
                            x21+=position*80;
                        }*/
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            sum2red++;
                            if (sum2red==1){
                                xred=600-530;
                                //drawImageInCenter2(g, imagePath, new1XY[0]-530, new1XY[1] - 1077, 40, 40);
                                //repaint();
                            }else {
                                xred+=position*80;
                               // drawImageInCenter2(g, imagePath, xred, new1XY[1] - 1077, 40, 40);
                               // repaint();
                            }

                            drawImageInCenter2(g, imagePath, new1XY[0]-530, new1XY[1] - 1077, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            sum2yellow++;
                            if (sum2yellow==1){
                                xyellow=600-130;
                            //    drawImageInCenter2(g, imagePath, new1XY[0]-130, new1XY[1] + 123, 40, 40);
                              //  repaint();
                            }else {
                                xyellow-=position*80;
                             //   drawImageInCenter2(g, imagePath, xyellow, new1XY[1] + 123, 40, 40);
                               // repaint();
                            }
                            drawImageInCenter2(g, imagePath, new1XY[0]-130, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            sum2blue++;
                            if (sum2blue==1){
                                yblue=600-677;
                               // drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1]-677, 40, 40);
                               // repaint();
                            }else {
                                yblue+=position*80;
                               // drawImageInCenter2(g, imagePath, new1XY[0] + 270, yblue, 40, 40);
                               // repaint();
                            }
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1]-677, 40, 40);
                            repaint();
                        } else {
                            sum2green++;
                            if (sum2green==1){
                                ygreen=600-277;
                             //   drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1]-277, 40, 40);
                               // repaint();
                            }else {
                                ygreen-=position*80;
                               // drawImageInCenter2(g, imagePath, new1XY[0] - 930, ygreen, 40, 40);
                               // repaint();
                            }
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1]-277, 40, 40);
                            repaint();
                        }
                        flag21 = true;
                    }
/*
                    if (sum1red==1){
                        drawImageInCenter2(g, imagePath, 600-530, new1XY[1] - 1077, 40, 40);
                        repaint();
                    }else {
                        drawImageInCenter2(g, imagePath, xred, new1XY[1] - 1077, 40, 40);
                           repaint();
                    }
                    if (sum1yellow==1){
                        drawImageInCenter2(g, imagePath, new1XY[0] - 50, new1XY[1] + 123, 40, 40);
                         repaint();
                    }else {
                        drawImageInCenter2(g, imagePath, xyellow, new1XY[1] + 123, 40, 40);
                        repaint();
                    }
                    if (sum2red>1){
                        drawImageInCenter2(g, imagePath, xred, new1XY[1] - 1077, 40, 40);
                           repaint();
                    }*/

                    if (position==3&&flag1&&!flag21){
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 370, new1XY[1] - 1077, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 310, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 517, 40, 40);
                            repaint();
                        } else {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 560, 40, 40);
                            repaint();
                        }

                    } else if (position==3&&flag21) {
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 290, new1XY[1] - 1077, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 450, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 437, 40, 40);
                            repaint();
                        } else {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 517, 40, 40);
                            repaint();
                        }
                    }
                    if (position==4&&flag1&&!flag21){
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 690, new1XY[1] - 1077, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] +30, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 960, 40, 40);
                            repaint();
                        } else {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 240, 40, 40);
                            repaint();
                        }
                    }else if (flag21&&position==4){
                        if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 610, new1XY[1] - 1077, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/yellowPawn2.png") || imagePath.equals("images/pawns/yellowPawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] -50, new1XY[1] + 123, 40, 40);
                            repaint();
                        } else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")) {
                            drawImageInCenter2(g, imagePath, new1XY[0] + 270, new1XY[1] - 880, 40, 40);
                            repaint();
                        } else {
                            drawImageInCenter2(g, imagePath, new1XY[0] - 930, new1XY[1] - 320, 40, 40);
                            repaint();
                        }
                    }

                // System.out.println(newXY1[1]);
            }
            //System.out.println(imagePath);
             /*newXY = NumberCard.MaketheCheck();
             flagCcheck = CheckPositionsAtBoard2(CurrPawn,position,g);
            //repaint();
            if (flagCcheck) {
                //drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], newXY[0], newXY[1], 40, 40);
               // repaint();
            }else {

            }*/
                /*if (position == 1 || position == 2) {
                    drawImageInCenter2(g, "images/pawns/redPawn1.png", -10, -47, 40, 40);
                    repaint();
                }
*/

            if (!flag1&&!flag21/*!flagStart||!CurrStartPawn*/){
                if (color=="RED"){

                    //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                    //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
                    drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                    drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                   // repaint();
                    //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                    //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                }else if (color=="BLUE"){
                    drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                    drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

                }else if (color=="GREEN"){
                    drawImageInCenter2(g, "images/pawns/greenPawn1.png",-225,870,40,40);
                    drawImageInCenter2(g, "images/pawns/greenPawn2.png",-130,870,40,40);

                }else {
                    drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                    drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);
                }

            }else /*if (CurrStartPawn)*/{

                if (imagePath.equals("images/pawns/redPawn2.png") || imagePath.equals("images/pawns/redPawn1.png")){

                    //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                    //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
                  //  drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                    drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                    if (color=="BLUE"){
                        drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                        drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

                    }else if (color=="GREEN"){
                        drawImageInCenter2(g, "images/pawns/greenPawn1.png",-225,870,40,40);
                        drawImageInCenter2(g, "images/pawns/greenPawn2.png",-130,870,40,40);

                    }else {
                        drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                        drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);
                    }
                    // repaint();
                    //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                    //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                }else if (imagePath.equals("images/pawns/bluePawn2.png") || imagePath.equals("images/pawns/bluePawn1.png")){
                    //drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                    drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

                    if (color=="RED"){

                        //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                        //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
                        drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                        drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                        // repaint();
                        //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                        //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                    }else if (color=="GREEN"){
                        drawImageInCenter2(g, "images/pawns/greenPawn1.png",-225,870,40,40);
                        drawImageInCenter2(g, "images/pawns/greenPawn2.png",-130,870,40,40);

                    }else {
                        drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                        drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);
                    }
                }else if (imagePath.equals("images/pawns/greenPawn2.png") || imagePath.equals("images/pawns/greenPawn1.png")){
                    //drawImageInCenter2(g, "images/pawns/greenPawn1.png",-225,870,40,40);
                    drawImageInCenter2(g, "images/pawns/greenPawn2.png",-130,870,40,40);

                    if (color=="RED"){

                        //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                        //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
                        drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                        drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                        // repaint();
                        //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                        //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                    }else if (color=="BLUE"){
                        drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                        drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

                    }else  if (color=="YELLOW"){
                        drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                        drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);
                    }

                }else {
                   // drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                    drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);

                    if (color=="RED"){

                        //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                        //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
                        drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                        drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                        // repaint();
                        //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                        //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

                    }else if (color=="BLUE"){
                        drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                        drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

                    }else if (color=="GREEN") {
                        drawImageInCenter2(g, "images/pawns/greenPawn1.png", -225, 870, 40, 40);
                        drawImageInCenter2(g, "images/pawns/greenPawn2.png", -130, 870, 40, 40);
                    }

                }

                /* Square.drawImageInCenter2(g,image50,XY[0],XY[1],40,40);
                arr[k][l]=image50;
                arr[currX][currY]="69";
                PawnsAtBoard[k][l]=image50;
                PawnsAtBoard[currX][currY]="69";
              */
                // newXY = NumberCard.MaketheCheck();
                // flagCcheck = CheckPositionsAtBoard2(CurrPawn,position,g);
                //repaint();
               /* if (flagCcheck) {
                  //  drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], newXY[0], newXY[1], 40, 40);
                   // repaint();
                }else {
                    //press the fold button
                }*/

               // System.out.println(currX);
                /*
                if (CurrStartPawn) {
                    if (CheckPositionsAtBoard2(CurrPawn, position, g)) {
                        drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                        repaint();
                        *//*if (turn == 1) {
                        drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                    }*//*
                    } else {
                        //press fold button
                    }
                }else{
                    if (CheckPositionsAtBoard2(CurrPawn, position, g)) {
                        drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                        repaint();
                    }
                    *//* if (position==0||position==1||position==2){
                        if (CheckPositionsAtBoard2(CurrPawn, position, g)) {
                            drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                            repaint();
                    *//**//*if (turn == 1) {
                        drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                    }*//**//*
                        } else {
                            //press fold button
                        }
                    }else{
                        //press fold button
                    }*//*
                }*/
                //Deck.TextTurn[0][Deck.turn - 1]

            }
           // drawImageInCenter2(g, "images/pawns/redPawn1.png",550,1153,40,40);

            /*
            if (color=="RED"){

                //drawImageInCenter2(g, "images/pawns/bluePawn1.png",-329,433,40,40);

                //startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE
             //   drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
               // drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);
                if (!flagStart){
                    drawImageInCenter2(g, "images/pawns/redPawn1.png",-55,60,40,40);
                    drawImageInCenter2(g, "images/pawns/redPawn2.png",35,60,40,40);

                }else{
                    if (CheckPositionsAtBoard2(CurrPawn,position,g)) {
                        if (turn == 1) {
                            drawImageInCenter2(g, Pawns[CurrentPawnNum - 1][turn - 1], CurrPawn.x, CurrPawn.y, 40, 40);
                        }
                    }else{
                        //press fold button
                    }
                    //Deck.TextTurn[0][Deck.turn - 1]

                }



                //drawSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, Color.RED);
                //drawImageSquare(g, startX + 73 * SQUARE_SIZE, startY + 253 * SQUARE_SIZE, "images/pawns/redPawn1.png");

            }else if (color=="BLUE"){
                drawImageInCenter2(g, "images/pawns/bluePawn1.png",690,300,40,40);
                drawImageInCenter2(g, "images/pawns/bluePawn2.png",770,300,40,40);

            }else if (color=="GREEN"){
                drawImageInCenter2(g, "images/pawns/greenPawn1.png",-225,870,40,40);
                drawImageInCenter2(g, "images/pawns/greenPawn2.png",-130,870,40,40);

            }else {
                drawImageInCenter2(g, "images/pawns/yellowPawn1.png",500,1030,40,40);
                drawImageInCenter2(g, "images/pawns/yellowPawn2.png",600,1030,40,40);
            }*/
            // Draw the text in the center of the custom square
            //g.drawString(text, textX, textY-20);

            //g.drawString(TextTurn[0][turn-1]/*Player "*/,735,459);


            if (image1 != null) {
                g.drawImage(image1, x + 100, y + 100, size / 2 - 100, size - 2 * 100, this);
            }

            // Draw the second image
            if (image2 != null) {
                g.drawImage(image2, x + size / 2, y + 100, size / 2 - 100, size - 2 * 100, this);
            }



        }


        /*@Override
        public void paint(Graphics g) {
            super.paint(g);
            JLabel textLabel = new JLabel(TextTurn[0][turn-1]);
            textLabel.paintImmediately(textLabel.getVisibleRect());

            *//*super.paint(g);
            // Draw text based on the current value of turn
            g.drawString(TextTurn[0][turn-1], 735,459);*//*
        }*/

        /**
         * Draws a square grid with a cyan background and various images and squares on the specified Graphics object.
         * The grid includes a center image and custom squares along the perimeter and certain positions.
         *
         * @param g The Graphics object on which to draw the square grid.
         */

        private void drawSquareOfSquares(Graphics g) {

            g.setColor(Color.CYAN);
            g.fillRect(40, 40, 600, 600);


            // Set the color to white
            //g.drawString("images/background.png",10,10);
            g.setColor(Color.DARK_GRAY);
            //g.fillRect(50, 40, 710, 710);

            for (int i = 0; i < getWidth(); i += SQUARE_SIZE) {
                g.fillRect(i, 0, SQUARE_SIZE, SQUARE_SIZE); // Top row
                g.fillRect(i, getHeight() - SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE); // Bottom row
            }
            for (int j = 0; j < getHeight(); j += SQUARE_SIZE) {
                g.fillRect(0, j, SQUARE_SIZE, SQUARE_SIZE); // Left column
                g.fillRect(getWidth() - SQUARE_SIZE, j, SQUARE_SIZE, SQUARE_SIZE); // Right column
            }
            drawImageInCenter(g, "images/sorryImage.png",200,90);



            int startX = (getWidth() - SQUARE_SIZE * GRID_SIZE) / 2;
            int startY = (getHeight() - SQUARE_SIZE * GRID_SIZE) / 2;

            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (isOnPerimeter(i, j)) {
                        if ((i==1||i==9) && j==0) {
                            drawImageSquare(g, startX -188+ i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/redSlideStart.png");
                        } else if ((i==6||i==14)&& j!=0) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/yellowSlideStart.png");
                        } else if ((j==1||j==9) && i!=0) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/blueSlideStart.png");

                        } else if ((j==6||j==14)&& i==0) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/greenSlideStart.png");

                        }else {
                            drawSquare(g, startX + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, Color.WHITE);

                        }
                        if ((i==2||i==3||(i>=10&&i<=12)) && j==0){
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/redSlideMedium.png");

                        } else if ((i==13||i==12||(i<=5&&i>=3))&& j!=0) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/yellowSlideMedium.png");

                        } else if (((j==2||j==3)||(j<=12&&j>9)) && i!=0) {

                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/blueSlideMedium.png");

                        } else if ((j<6&&j>2||j==12||j==13)&& i==0) {

                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/greenSlideMedium.png");

                        }

                        if ((i==4||i==13)&&j==0){
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/redSlideEnd.png");

                        } else if ((i==2||i==11)&&j!=0) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/yellowSlideEnd.png");

                        } else if (i==0&&(j==2||j==11)) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/greenSlideEnd.png");

                        } else if (i!=0&&(j==4||j==13)) {
                            drawImageSquare(g, startX-188 + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, "images/slides/blueSlideEnd.png");

                        }


                    }else {
                        if (i==2&&j==1){
                            for (int k=1;k<6;k++){
                                drawSquare(g, startX+1 + i * SQUARE_SIZE, startY + k * SQUARE_SIZE, Color.RED);

                            }

                        } else if (i==13&&j==10) {
                            for (int k=10;k<15;k++){
                                drawSquare(g, startX+1 + i * SQUARE_SIZE, startY + k * SQUARE_SIZE, Color.YELLOW);

                            }
                        }else if (i==10&&j==2&&(options[result].equals("3 players")||options[result].equals("4 players"))){
                            for (int k=10;k<15;k++){
                                drawSquare(g, startX+1 + k * SQUARE_SIZE, startY + j* SQUARE_SIZE, Color.BLUE);

                            }
                        }else if (i==1&&j==13&&options[result].equals("4 players")){
                            for (int k=1;k<6;k++){
                                drawSquare(g, startX+1 + k * SQUARE_SIZE, startY + j* SQUARE_SIZE, Color.GREEN);

                            }
                        }
                        /*if (i==12&&j==8){
                            drawSquare(g, startX + i * SQUARE_SIZE, startY + j * SQUARE_SIZE, Color.WHITE);

                            //drawBIGSquare(g, startX + i * SQUAREBIG_SIZE, startY + j * SQUAREBIG_SIZE, Color.WHITE);

                        }*/
                    }
                }
            }
            /**
             * Draws an image at the specified grid position along the perimeter.
             * The type of image is determined by the position and specific conditions.
             *
             * @param g      The Graphics object on which to draw the image.
             * @param i      The x-coordinate (column) of the grid position.
             * @param j      The y-coordinate (row) of the grid position.
             * @param startX The starting x-coordinate for the grid.
             * @param startY The starting y-coordinate for the grid.
             */

        }

        /**
         * Draws an image at the specified grid position, along with a black border around it.
         *
         * @param g         The Graphics object on which to draw the image.
         * @param x         The x-coordinate (left) of the image position.
         * @param y         The y-coordinate (top) of the image position.
         * @param imagePath The path to the image resource.
         */
        private void drawImageSquare(Graphics g, int x, int y, String imagePath) {
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                Image image = new ImageIcon(imageURL).getImage();

                // Draw the image
                g.drawImage(image, x, y, SQUARE_SIZE, SQUARE_SIZE, this);

                // Draw a black border around the image
                g.setColor(Color.BLACK);
                g.drawRect(x - PERIMETER_SIZE, y - PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE);
            } else {
                // Handle image loading failure
                System.out.println("Image loading failed for: " + imagePath);
            }
        }
        /**
         * Draws a colored square at the specified grid position, along with a black border around it.
         *
         * @param g     The Graphics object on which to draw the square.
         * @param x     The x-coordinate (left) of the square position.
         * @param y     The y-coordinate (top) of the square position.
         * @param color The color of the square.
         */
        private void drawSquare(Graphics g, int x, int y, Color color) {
            g.setColor(color); // Set the color of the squares
            g.fillRect(x-189, y, SQUARE_SIZE, SQUARE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x - PERIMETER_SIZE-189, y - PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE, SQUARE_SIZE + 2 * PERIMETER_SIZE);

        }
        /**
         * Draws a colored square at the specified grid position, with a larger size, along with a black border around it.
         *
         * @param g     The Graphics object on which to draw the square.
         * @param x     The x-coordinate (left) of the square position.
         * @param y     The y-coordinate (top) of the square position.
         * @param color The color of the square.
         */
        private void drawBIGSquare(Graphics g, int x, int y, Color color) {
            g.setColor(color); // Set the color of the squares
            g.fillRect(x, y, SQUAREBIG_SIZE, SQUAREBIG_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x - PERIMETER_SIZE, y - PERIMETER_SIZE, SQUAREBIG_SIZE + 2 * PERIMETER_SIZE, SQUAREBIG_SIZE + 2 * PERIMETER_SIZE);

        }

        /**
         * Checks if the specified grid position is on the perimeter of the grid.
         *
         * @param i The x-coordinate (column) of the grid position.
         * @param j The y-coordinate (row) of the grid position.
         * @return True if the position is on the perimeter, false otherwise.
         */
        private boolean isOnPerimeter(int i, int j) {
            return i == 0 || j == 0 || i == GRID_SIZE - 1 || j == GRID_SIZE - 1;
        }
        /**
         * Draws an image in the center of the window with the specified dimensions.
         *
         * @param g             The Graphics object on which to draw the image.
         * @param imagePath     The path to the image resource.
         * @param desiredWidth  The desired width of the image.
         * @param desiredHeight The desired height of the image.
         */

        private void drawImageInCenter(Graphics g, String imagePath, int desiredWidth, int desiredHeight) {
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                Image image = new ImageIcon(imageURL).getImage();

                // Calculate the position to center the image
                int x = (getWidth() - desiredWidth) / 2 -185;
                int y = (getHeight() - desiredHeight) / 2;

                // Draw the image with the desired width and height
                g.drawImage(image, x, y, desiredWidth, desiredHeight, this);
            } else {
                // Handle image loading failure
                System.out.println("Image loading failed for: " + imagePath);
            }
        }
        /**
         * Draws an image at a specified position with the specified dimensions, adjusting for a custom center.
         *
         * @param g             The Graphics object on which to draw the image.
         * @param imagePath     The path to the image resource.
         * @param x             The x-coordinate (left) of the image position.
         * @param y             The y-coordinate (top) of the image position.
         * @param desiredWidth  The desired width of the image.
         * @param desiredHeight The desired height of the image.
         */
        static void drawImageInCenter2(Graphics g, String imagePath, int x, int y, int desiredWidth, int desiredHeight) {
            URL imageURL = SquarePanel.class.getResource(imagePath);
            if (imageURL != null) {
                Image image = new ImageIcon(imageURL).getImage();

                // Calculate the position to center the image
                /*int x = (getWidth() - desiredWidth) / 2;
                int y = (getHeight() - desiredHeight) / 2;
*/
                x=(x-desiredWidth)/2+185;
                y=(y-desiredHeight)/2+50;
                // Draw the image with the desired width and height
                if (g!=null) {
                    g.drawImage(image, x, y, desiredWidth, desiredHeight, null);
                }
            } else {
                // Handle image loading failure
                System.out.println("Image loading failed for: " + imagePath);
            }
        }
        /**returns the array with x and y coordinates based on the position=number of moves and direction = 1 front , - 1 back*/
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
            int x1=currX,y1=currY;
           // System.out.println(x1);
            if (position==1&&direction==1&&!CurrStartPawn) {
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
            }else if (position==2&&direction==1&&!CurrStartPawn){
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
                            x1=390;
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
            } else if (CurrStartPawn){
                int moves = position*80;
               // y1=moves-600;

                 int movesleft=0;
                if (!flagpros) {//0>
                    if (currY==-47){
                        if (currX==870){
                            //handle special case RU corner
                            y1=-47+moves;
                        } else if (currX==-330) {
                            //handle special case LU corner
                            x1=-330+moves;
                        }else {
                            if (position<=((870-currX)%80)){
                                x1=currX+moves;
                            }else {
                                x1 = currX+moves;
                                movesleft = (x1-870)%80;
                                x1 = 870;
                                y1 = -47+(movesleft*80);
                            }
                        }
                    }else if (currY==1153){
                        if (currX==870){
                            //handle special case RD corner
                            x1=870-moves;
                        } else if (currX==-330) {
                            //handle special case LD corner
                            y1=1153-moves;
                        }else {
                            if (position<=((330+currX)%80)){
                                x1=currX-moves;
                            }else {
                                x1 = currX-moves;
                                movesleft = (x1-330)%80;
                                x1 = -330;
                                y1 = 1153-(movesleft*80);
                            }
                        }
                    }


                    if (currX==-330){
                        if (currY==-47){
                            //handle special case LU corner
                            x1=-330+moves;
                        } else if (currY==1153) {
                            //handle special case LD corner
                            y1=1153-moves;
                        }else {
                            if (position<=((47+currY)%80)){
                                y1=currY-moves;
                            }else {
                                y1 = currY-moves;
                                movesleft = (y1+47)%80;
                                y1 = -47;
                                x1=movesleft*80-330;
                            }
                        }
                    }else if (currX==870){
                        if (currY==-47){
                            //handle special case RU corner
                            y1=-47+moves;
                        } else if (currY==1153) {
                            //handle special case RD corner
                            x1=870-moves;
                        }else {
                            if (position<=((1153-currY)%80)){
                                y1=currY+moves;
                            }else {
                                y1=currY+moves;
                                movesleft = (y1-1153)%80;
                                x1 = 870-(movesleft*80);
                                y1=1153;
                            }
                        }
                    }

                    /*if (currY == -47 && position <= ((330 + currX) % 80)) {
                        x1 -= moves;
                    } else if (currY==-47) {
                        x1-=moves;//x1=1190 >870
                        movesleft= (x1+330)%80;//1190-870=320 %80=4 movesleft
                        x1=-330;//on the edge
                        //currY+=movesleft*80;
                        //x1=-330;
                        y1+=movesleft*80;//4*80=320 +y1=-47+320=273 the last position(870,273)
                        //currY=y1;//update pawn
                    }else if (currY==1153 && (position <= (870 - currX) % 80)){//330+390=720
                        x1 += moves;
                    }else if (currY==1153) {

                        movesleft = position - (870- currX) % 80;
                        x1 = 870;
                        y1-=movesleft*80;
                    }
                    if (currX==870 && ((47+currY)%80)<=position){
                        y1-=moves;
                    }else if (currX==870){

                        movesleft=position-(47+currY)%80;
                        y1=-47;
                        x1-=movesleft*80;
                    }else if (currX==-330 && ((1153-currY)%80)<=position){
                        y1+=moves;
                    }else if (currX==-330){

                        movesleft=position-(1153-currY)%80;
                        y1=1153;
                        x1+=movesleft*80;
                    }*/
                }else {//<0
                    if (currY==-47){
                        if (currX==870){
                            //handle special case RU corner
                            x1=870-moves;
                        } else if (currX==-330) {
                            //handle special case LU corner
                            y1=-47+moves;
                        }else {
                            if (position<=((330+currX)%80)){
                                x1=currX-moves;
                            }else {
                                x1 = currX-moves;
                                movesleft = (x1+330)%80;
                                y1 = -47+(movesleft*80);
                                x1=-330;
                            }
                        }
                    }else if (currY==1153){
                        if (currX==870){
                            //handle special case RD corner
                            y1=1153-moves;
                        } else if (currX==-330) {
                            //handle special case LD corner
                            x1=-330+moves;
                        }else {
                            if (position<=((870-currX)%80)){
                                x1=currX+moves;
                            }else {
                                x1 = currX+moves;
                                movesleft = (x1-870)%80;
                                y1 = 1153-(movesleft*80);
                                x1=870;
                            }
                        }
                    }


                    if (currX==-330){
                        if (currY==-47){
                            //handle special case LU corner
                            y1=-47+moves;
                        } else if (currY==1153) {
                            //handle special case LD corner
                            x1=-330+moves;
                        }else {
                            if (position<=((1153-currY)%80)){
                                y1=currY+moves;
                            }else {
                                y1 = currY+moves;
                                movesleft = (y1-1153)%80;
                                x1=movesleft*80-330;
                                y1=1153;
                            }
                        }
                    }else if (currX==870){
                        if (currY==-47){
                            //handle special case RU corner
                            x1=870-moves;
                        } else if (currY==1153) {
                            //handle special case RD corner
                            y1=1153-moves;
                        }else {
                            if (position<=((currY+47)%80)){
                                y1=currY-moves;
                            }else {
                                y1=currY-moves;
                                movesleft = (y1+47)%80;
                                x1 = 870-(movesleft*80);
                                y1=-47;
                            }
                        }
                    }
                    /*
                    if (currY == -47 && position <= ((870 - currX) % 80)) {
                        x1 += moves;
                    } else if (currY==-47) {
                        x1+=moves;//x1=1190 >870
                        movesleft= (x1-870)%80;//1190-870=320 %80=4 movesleft
                        //currX=870;//on the edge
                        //currY+=movesleft*80;
                        x1=870;
                        y1+=movesleft*80;//4*80=320 +y1=-47+320=273 the last position(870,273)
                        //currY=y1;//update pawn
                    }else if (currY==1153 && ((330 + currX) % 80) > position){//330+390=720
                        x1 -= moves;
                    } else if (currY==1153) {

                        movesleft = position - (330 + currX) % 80;
                        x1 = -330;
                        y1+=movesleft*80;
                    }
                    if (currX==870 && ((1153-currY)%80)<=position){
                        x1+=moves;
                    }else if (currX==870){

                        movesleft=position-(1153-currY)%80;
                        y1=1153;
                        x1-=movesleft*80;
                    }else if (currX==-330 && ((47+currY)%80)<=position){
                        y1-=moves;
                    }else if (currX==-330){

                        movesleft=position-(47+currY)%80;
                        y1=-47;
                        x1+=movesleft*80;
                    }
*/
                }
            }
            XY[0]=x1;
            XY[1]=y1;
            currY=y1;
            currX=x1;
            return XY;
        }
        /**calls the CheckMove to return the new coordinates*/
        public static int[] MaketheCheck(){
            return CheckMove(CurrPawn,position,direction);
        }

        /**Checks if the player can move and moves it or returns false*/
        public static boolean CheckPositionsAtBoard(int position, Graphics g){
            //returns future x and y
            int[] XY = NumberCard.MaketheCheck();//movePosition(position);
        /*String[][] arr = new String[16][16];
        arr=Board.PawnsPositionsAtBoard();
        */
            String[][] arr = new String[16][16];
            //arr=Board.PawnsAtBoard;
            arr=PawnsAtBoard;
            //int[] X = new int[16];
            //int[] Y = new int[16];
            //X=Board.MakeX();
            //Y=Board.MakeY();
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
            if (arr[k][l]!="69"/*!Objects.equals(arr[k][l], "69")*/){

                //press the fold button
                //you cant move someone is on the position you were going to be
                return false;
            }else{
                if (number == 1) {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn1.png";
                        //setImage("images/pawns/redPawn1.png");

                    } else {
                        image50 = "images/pawns/yellowPawn1.png";
                        //setImage("images/pawns/yellowPawn1.png");
                    }
                } else {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn2.png";
                        //setImage("images/pawns/redPawn2.png");
                    } else {
                        image50 = "images/pawns/yellowPawn2.png";
                        //setImage("images/pawns/yellowPawn2.png");
                    }
                }
               // Square.drawImageInCenter2(g,image50,XY[0],XY[1],40,40);
              /*  arr[k][l]=image50;
                arr[currX][currY]="69";
                PawnsAtBoard[k][l]=image50;
                PawnsAtBoard[currX][currY]="69";*/
              //  currX=XY[0];
                //currY=XY[1];
                new1XY[0] = XY[0];
                new1XY[1] = XY[1];
                return true;
            }
            //return true;
        }

        /**for the cards that must move all the pawns*/
        public static boolean FB(int x, int y){
            //to move all the pawns
            boolean f1=false,f2=f1;
            //f1=CheckPositionsAtBoard(position,g);
            if(PawnsAtBoard[x][y]=="images/pawns/redPawn1.png"){
                f1=CheckPositionsAtBoard2(red1,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/redPawn2.png"){
                            f2=CheckPositionsAtBoard2(red2,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/redPawn2.png"){
                f1=CheckPositionsAtBoard2(red2,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/redPawn1.png"){
                            f2=CheckPositionsAtBoard2(red1,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/yellowPawn1.png"){
                f1=CheckPositionsAtBoard2(yellow1,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/yellowPawn2.png"){
                            f2=CheckPositionsAtBoard2(yellow2,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/yellowPawn2.png"){
                f1=CheckPositionsAtBoard2(yellow2,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/yellowPawn1.png"){
                            f2=CheckPositionsAtBoard2(yellow1,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/bluePawn1.png"){
                f1=CheckPositionsAtBoard2(blue1,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/bluePawn2.png"){
                            f2=CheckPositionsAtBoard2(blue2,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/bluePawn2.png"){
                f1=CheckPositionsAtBoard2(blue2,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/bluePawn1.png"){
                            f2=CheckPositionsAtBoard2(blue1,position,g);
                        }
                    }
                }
            }else if(PawnsAtBoard[x][y]=="images/pawns/greenPawn1.png"){
                f1=CheckPositionsAtBoard2(green1,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/greenPawn2.png"){
                            f2=CheckPositionsAtBoard2(green2,position,g);
                        }
                    }
                }
            }else {
                f1=CheckPositionsAtBoard2(green2,position,g);
                for (int i=0 ;i<16;i++){
                    for (int j=0; j<16;j++){
                        if (PawnsAtBoard[i][j]=="images/pawns/greenPawn1.png"){
                            f2=CheckPositionsAtBoard2(green1,position,g);
                        }
                    }
                }
            }
            return (f1&&f2);
        }


        /**Checks if the player can move and moves it or returns false*/
        public static boolean CheckPositionsAtBoard2(Pawn pawn,int position, Graphics g){
            //returns future x and y
            int[] XY = NumberCard.MaketheCheck();//movePosition(position);
        /*String[][] arr = new String[16][16];
        arr=Board.PawnsPositionsAtBoard();
        */
            String[][] arr = new String[16][16];
            //arr=Board.PawnsAtBoard;
            arr=PawnsAtBoard;
            //int[] X = new int[16];
            //int[] Y = new int[16];
            //X=Board.MakeX();
            //Y=Board.MakeY();
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
            if (arr[k][l]!="69"/*!Objects.equals(arr[k][l], "69")*/){

                //press the fold button
                //you cant move someone is on the position you were going to be
                return false;
            }else{
                if (number == 1) {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn1.png";
                        //setImage("images/pawns/redPawn1.png");

                    } else {
                        image50 = "images/pawns/yellowPawn1.png";
                        //setImage("images/pawns/yellowPawn1.png");
                    }
                } else {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn2.png";
                        //setImage("images/pawns/redPawn2.png");
                    } else {
                        image50 = "images/pawns/yellowPawn2.png";
                        //setImage("images/pawns/yellowPawn2.png");
                    }
                }
                drawImageInCenter2(Deck.g,image50,XY[0],XY[1],40,40);
               // repaint();
                arr[k][l]=image50;
               // arr[currX][currY]="69";
                PawnsAtBoard[k][l]=image50;
                PawnsAtBoard[k][l]="69";
              //  System.out.println(l);
              //  currX=XY[0];
                //currY=XY[1];

                if (basic_panel!=null) {
                    basic_panel.repaint();
                }
                return true;
            }
            //return true;
        }

        /**calls the CheckPositionosAtBoard to see if the player made a move*/
        public void CheckPMoves(){
            //checks and makes the move
            boolean flag = Player.CheckPositionsAtBoard(position,g);
        }


    }
}
/**
 * Custom JButton class representing a fold button in the game.
 * The button includes additional functionality for handling game logic,
 * such as generating random cards, updating pawns turn and infobox, and displaying messages based on the case.
 */
class FoldButton extends JButton{
    /**
     * Indicates whether the button has been clicked.
     */
    public static boolean clicked=false;
    double rand;
    /**
     * The text displayed on the button based on the cards
     */
    public static String text = " your turn to play! ";
    /**
     * Random number generator for card selection.
     */
    Random r = new Random();
    /**
     * Creates a new FoldButton with the specified text.
     *
     * @param text The text to be displayed on the button.
     */
    public FoldButton(String text){
        super(text);
        initButton();
    }
    /**
     * Initializes the button by setting its appearance and adding an ActionListener.
     * updates the turn, the text, the new card and the number of cards left, current pawn
     * based on the card calls the right function to handle the case and shows options to the user
     */
    private void initButton(){
        setBackground(Color.RED);
        setForeground(Color.BLACK);
        //final String[][] text = {{"(Red)", "(Blue)", "(Yellow)", "(Green)"}};

       // setContentAreaFilled(false); // Make the button not paint its content area
      //  setBorderPainted(false); // Make the button not paint its border

        //setOpaque(false);
        //setText("Fold Button");
        setFocusPainted(false);
        int pl0=0;
        for (int i=0;i<11;i++){
            if (plCardsLeft[i]<0){
                pl0++;
            }
        }
        if (pl0==11){
            for (int i=0;i<11;i++){
                plCardsLeft[i]=4;
            }
            CardsLeft=44;
        }

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag85&&(Cards11[Ci].equals("images/cards/card8.png")||Cards11[Ci].equals("images/cards/card12.png"))){
                    text = " your new card";
                }else {
                    /*text = " your turn to play! ";
                    if (Deck.turn==Deck.plPlayers){
                        Deck.turn=1;
                    }else{
                        Deck.turn++;
                    }*/
                }
                if (flag2){
                    //take new card and play again
                    text=" Play Again!";
                }else if (!flag85&& !flag2){
                    text = " your turn to play! ";
                    if (Deck.turn==Deck.plPlayers){
                        Deck.turn=1;
                    }else{
                        Deck.turn++;
                    }
                }

                /*if (Deck.turn==Deck.plPlayers){
                    Deck.turn=1;
                }else{
                    Deck.turn++;
                }*/
                clicked=true;
                if (turn==1){
                    CurrPawn.color=Color.RED;
                    if (CurrPawn.y!=DFYRed){
                        //CurrStartPawn=true;
                    }else {
                        //CurrStartPawn=false;
                    }
                }else if (turn==2){
                    if (plPlayers!=2) {
                        CurrPawn.color = Color.BLUE;
                        if (CurrPawn.y!=DFYBlue){
                            //CurrStartPawn=true;
                        }else {
                            //CurrStartPawn=false;
                        }
                    }else {
                        CurrPawn.color = Color.YELLOW;
                        if (CurrPawn.y!=DFYYellow){
                            //CurrStartPawn=true;
                        }else {
                            //CurrStartPawn=false;
                        }
                    }
                } else if (turn == 3) {
                    CurrPawn.color = Color.YELLOW;
                    if (CurrPawn.y!=DFYYellow){
                        //CurrStartPawn=true;
                    }else {
                        //CurrStartPawn=false;
                    }
                }else{
                    CurrPawn.color = Color.GREEN;
                    if (CurrPawn.y!=DFYGreen){
                        //CurrStartPawn=true;
                    }else {
                        //CurrStartPawn=false;
                    }
                }
                CurrentPawnNum=1;
                CurrPawn.setNumber(1);

                currX = CurrPawn.x;
                currY = CurrPawn.y;
                //Deck.plCardsLeft[Deck.Ci]--;
               // rand = ((Math.random() * 12) );
               // Ci = (int) rand;
               // Deck.CurrentC = Cards11[Ci];
               // Integer c2 = new Integer(Ci);

                /*if (FoldButton.clicked){
            plCardsLeft[Ci]--;
            if (plCardsLeft[Ci]>0){
                //emfanhse
            }else {
                Cards11[Ci]="69";
            }
        }*/
                int pl0=0;
                for (int i=0;i<11;i++){
                    if (plCardsLeft[i]<0){
                        pl0++;
                    }
                }
                if (pl0==11){
                    for (int i=0;i<11;i++){
                        plCardsLeft[i]=4;
                    }
                    CardsLeft=44;
                }
                do {
                    Ci = Math.abs(r.nextInt()) % 11;
                   // rand = ((Math.random() * 11) + 1);
                    //Deck.Ci = (int) rand;
                    if (Deck.plCardsLeft[Deck.Ci] != 0) {
                        Deck.CurrentC = Deck.Cards11[Deck.Ci];
                        plCardsLeft[Ci]--;
                        if (Cards11[Ci].equals("images/cards/card10.png")){
                            flag10=true;
                        }else {
                            flag10=false;
                        }
                        if (Cards11[Ci].equals("images/cards/card8.png")||Cards11[Ci].equals("images/cards/card12.png")){
                            flag8=true;
                        }else {
                            flag8=false;
                        }
                        if (Cards11[Ci].equals("images/cards/card7.png")){
                            flag7=true;
                        }else {
                            flag7=false;
                        }
                        if (Cards11[Ci].equals("images/cards/card11.png")){
                            flag11=true;
                        }else {
                            flag11=false;
                        }
                        if (Cards11[Ci].equals("images/cards/card2.png")){
                            flag2=true;
                        }else {
                            flag2=false;
                        }

                        CardsLeft--;
                        System.out.println(plCardsLeft[Ci]+" "+Deck.CurrentC);
                        break;
//
                    }
                }while (Deck.plCardsLeft[Deck.Ci] >= 0);

/*
                if ()
                if (Ci==4||Ci==10){
                    if (Ci==4){
                        direction=-1;
                    }else{
                        direction = 1;

                      //  Deck.Choose10();

                *//*result10 = JOptionPane.showOptionDialog(
                        null,
                        "Choose an option:",
                        "Choice",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options10,
                        options10[0]
                );

                // Check the user's choice
                if (result10 == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Dialog closed without a choice");
                } else {
                    System.out.println("User chose: " + options10[result10]);
                    *//**//*SwingUtilities.invokeLater(() -> {
                        new NumberTenCard();//.setVisible(true);
                    });*//**//*
                }*//*

                    }
                }else{
                    direction=1;
                }*/

              /*  if (c2!=null){
                  //  System.out.println(Cards11[c2]);
                }*/
                String img = Cards11[Ci];
              //  int p=0,j=0;
/*



               // for (int i = 0;i<11;i++){
                   // plCardsLeft[i]=4;
                    Card card = new Card();
                   // card.setValue(i % 4 + 1);
                    if (Ci==0){
                        System.out.println(Cards11[j]);
                        //Cards11[j] = "images/cards/cardSorry.png";
                        //card.setImage("images/cards/cardSorry.png");
                        j++;
                        p++;
                    //}else if (Ci==6||Ci==8){
                      //  p++;
                        //System.out.println(Cards11[j]);
                       // Cards11[j] = "images/cards/card" + (p) + ".png";
                        //card.setImage("images/cards/card" + (p + 1) + ".png");
                        p++;
                        j++;
                    }else {
                        System.out.println(Cards11[j]);
                       // Cards11[j] = "images/cards/card" + (p) + ".png";
                        //card.setImage("images/cards/card" + (p + 1) + ".png");
                        p++;
                        j++;
                    }
              //  }
*/

               /* if (Deck.Ci==3){
                    System.out.println("aaaaaaaaaaa");
                    System.out.println(Deck.Cards11[Deck.Ci]);
                }*/
               // System.out.println(Deck.CurrentC);
                /*do {
                    double rand = ((Math.random() * 11) + 1);
                    Deck.Ci = (int) rand;
                    if (Deck.plCardsLeft[Deck.Ci] != 0) {
                        Deck.CurrentC = Deck.Cards11[Deck.Ci];
                        System.out.println(Deck.CurrentC);
//
                    }
                }while (Deck.plCardsLeft[Deck.Ci] != 0);*/
              //  Board.gameCards.remove(Deck.CurrentCard);
               // Deck.CurrentCard = Board.gameCards;
               // Deck.plCardsLeft[Deck.Ci]--;
                //Deck.CurrentC = Deck.Cards11[Deck.Ci];//new Card();

                //System.out.println(Deck.CurrentC);
//                if (Deck.Ci!=null){
//
//                }
              //  Deck.position = 0;
                clicked=true;
                JOptionPane.showMessageDialog(null, Deck.TextTurn[0][Deck.turn - 1]+text);
                if (Ci==6||Ci==7){
                    position=Ci+1;
                }else if (Ci>=8&&Ci<=10){
                    position=Ci+2;
                }else {
                    position = Ci;
                }
                if (position==4){
                    direction=-1;
                }else{
                    direction=1;
                }


              //  System.out.println(position);
                if (flag10){
                    if (CurrStartPawn) {
                        Choose10();
                    }
                    if (result10==0){
                        direction=1;
                        position=10;
                    }else {
                        direction=-1;
                        position=1;
                    }
                 //   System.out.println(position);
                }
                int[] arrnew = NumberCard.MaketheCheck();
                boolean flagChek = BasicPanel.CheckPositionsAtBoard2(CurrPawn,position,g);
                if (flagChek){
                    SquarePanel.drawImageInCenter2(g,Pawns[CurrentPawnNum-1][turn-1],arrnew[0],arrnew[1],40,40);
                    repaint();
                }
               // System.out.println(flagChek);
                if (flag7){
                    Choose7();
                    /*do {
                        Choose7();
                    }while(sum==7);*/
                }
                if (flag8){
                    Choose85();
                }
                if (flag11){
                    Choose11();
                }


            }
        });


        // Example: Automatically press the button if a specific condition is false
        boolean fl= Deck.SquarePanel.FB(Deck.x,Deck.y);//Deck.SquarePanel.CheckPositionsAtBoard(Deck.position,Deck.g);
        ClickIfFalse(fl);
        /*if (false){
            doClick();
            //change the turn
        }*/
        /* if (!Click()) {
            doClick();
        }*/
    }
    /**
     * Sets the font size of the button text.
     *
     * @param size The size of the font.
     */
    public void setFontSize(int size){
        Font buttFont = getFont();
        setFont(new Font(buttFont.getName(),buttFont.getStyle(),size));
    }

    /**
     * Checks the player's position on the game board and returns true if he moved and false otherwise.
     *
     * @return {@code true}
     */
    private static boolean Click(){
        return Player.CheckPositionsAtBoard(Card.position,Deck.g);
        //return ClickIfFalse(Player.CheckPositionsAtBoard(Card.position,Deck.g));
    }
    /**
     * Manually performs a click on the button if a specific condition is false.
     *
     * @param x The condition to check before performing the click.
     */
    private void ClickIfFalse(boolean x) {
        //x=checks if pawn moved or not
        if (!x&&Deck.position!=-3){
            /*// Set a custom ButtonUI to control visual feedback
            setUI(new BasicButtonUI() {
                @Override
                protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
                    // Manually draw the button text without considering its state
                    g.setColor(b.getForeground());
                    g.setFont(b.getFont());
                    FontMetrics fm = g.getFontMetrics();
                    int x = (b.getWidth() - fm.stringWidth(text)) / 2;
                    int y = ((b.getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                    g.drawString(text, x, y);
                }
            });*/
   //         doClick();

            clicked=true;
         //   JOptionPane.showMessageDialog(null, Deck.TextTurn[0][Deck.turn - 1]+" your turn to play! ");

           /* // Perform the action directly without relying on doClick()
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getActionCommand(),
                    EventQueue.getMostRecentEventTime(), 0));;
*/
            // Override the standard doClick method to prevent visual changes
          //  performCustomClick();
            /*if (Deck.turn==Deck.plPlayers){
                Deck.turn=1;
            }else{
                Deck.turn++;
            }
            System.out.println(Deck.turn);*/
        }
    }
    // Override the doClick method
    private void performCustomClick() {
        int pl0=0;
        for (int i=0;i<11;i++){
            if (plCardsLeft[i]<0){
                pl0++;
            }
        }
        if (pl0==11){
            for (int i=0;i<11;i++){
                plCardsLeft[i]=4;
            }
            CardsLeft=44;
        }
        if (isEnabled() && isShowing()) {
            fireActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getActionCommand(),
                    EventQueue.getMostRecentEventTime(), 0));
        }
    }/*
    @Override
    protected void paintComponent(Graphics g) {
        // Manually draw the button content without considering its state
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(getForeground());
        g.setFont(getFont());
        FontMetrics fm = g.getFontMetrics();
        String buttonText = getText();
        int x = (getWidth() - fm.stringWidth(buttonText)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(buttonText, x, y);
    }*/
    /*@Override
    public ButtonModel getModel() {
        return new DefaultButtonModel();
    }*/
    /*@Override
    protected void paintComponent(Graphics g) {
        // Empty implementation to override the default painting behavior
        // This prevents the button from responding to repaint calls
    }*/

}
/**
 * Custom JPanel class representing the game board with pawns.
 */
class BasicPanel extends JPanel {
    /**
     * 2D array representing the positions of pawns on the board.
     */
    private String[][] PawnsAtBoard;
    /**
     * Constructs a BasicPanel with the specified array of pawn positions.
     *
     * @param pawnsAtBoard The 2D array representing the initial pawn positions on the board.
     */
    public BasicPanel(String[][] pawnsAtBoard) {
        this.PawnsAtBoard = pawnsAtBoard;
    }
    /**
     * Overrides the paintComponent method to paint the game board and check pawn positions.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        CheckPositionsAtBoard2(CurrPawn, position,Deck.g);
        repaint();
    }
    /**
     * Checks the positions on the game board for a pawn and updates the board accordingly.
     *
     * @param pawn The pawn to be checked on the board.
     * @param position The position to check on the board.
     * @param g The Graphics object used for painting.
     * @return {@code true} if the pawn can move to the specified position, {@code false} otherwise.
     */
    public static boolean CheckPositionsAtBoard2(Pawn pawn,int position, Graphics g){
        //returns future x and y
            int[] XY = NumberCard.MaketheCheck();//movePosition(position);
        /*String[][] arr = new String[16][16];
        arr=Board.PawnsPositionsAtBoard();
        */
            String[][] arr = new String[16][16];
            //arr=Board.PawnsAtBoard;
            arr=Deck.PawnsAtBoard;
            //int[] X = new int[16];
            //int[] Y = new int[16];
            //X=Board.MakeX();
            //Y=Board.MakeY();
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
            if (arr[k][l]!="69"/*!Objects.equals(arr[k][l], "69")*/){

                //press the fold button
                //you cant move someone is on the position you were going to be
                return false;
            }else{
                if (number == 1) {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn1.png";
                        //setImage("images/pawns/redPawn1.png");

                    } else {
                        image50 = "images/pawns/yellowPawn1.png";
                        //setImage("images/pawns/yellowPawn1.png");
                    }
                } else {
                    if (PawnColor.color == Color.RED) {
                        image50 = "images/pawns/redPawn2.png";
                        //setImage("images/pawns/redPawn2.png");
                    } else {
                        image50 = "images/pawns/yellowPawn2.png";
                        //setImage("images/pawns/yellowPawn2.png");
                    }
                }
                SquarePanel.drawImageInCenter2(Deck.g,image50,XY[0],XY[1],40,40);
                // repaint();
                arr[k][l]=image50;
                // arr[currX][currY]="69";
                Deck.PawnsAtBoard[k][l]=image50;
                Deck.PawnsAtBoard[k][l]="69";
                currX=XY[0];
                currY=XY[1];

                if (Deck.basic_panel!=null) {
                    basic_panel.repaint();
                }
                return true;
            }
            //return true;
        }


    }

