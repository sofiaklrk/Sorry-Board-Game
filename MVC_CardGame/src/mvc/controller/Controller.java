/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import javax.swing.*;

import mvc.model.pawn.Pawn;
import mvc.model.player.Player;
import mvc.model.square.HomeSquare;
import mvc.view.View;
import mvc.model.card.Card;
import mvc.model.deck.Deck;
import mvc.model.board.Board;

import static java.awt.AWTEventMulticaster.add;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import static mvc.model.card.Card.position;


/**
 *The Controller class manages the game logic and user interactions.
 * @author csd5153
 */
public class Controller {

    /**
     * the game board*/
    Board board;
    /**
     * the graphical class for the game's view*/
    View view;
    /**
     * the first player in the game*/
    Player player1;
    /**The options for the user to choose how many players he wants to play*/
    public static String[] options = {"2 players", "3 players", "4 players"};
    /**The result of the options*/
    public static int result;
    /**The second player in the game*/
    Player player2;
    /**The current Player*/
    Player currentPlayer;
    /**the colors of current player and his opponent*/
    Color currentColor,vsColor;
    /**the current player's pawn and his opponent's pawn*/
    Pawn currentPawn,vsPawn;
    /**the number of current pawn and his opponent's*/
    int currentPawnN,vsNumb;
    /**
     * the current card being used*/
    Card card1;


    /*public Controller(){
        Deck d = new Deck();
        *//*view.setTitle("Sorry Game");
        view.setSize(1035,700);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board.initCards();
        Deck.checkCards();
        Deck.initPawns();
        Deck.MovePlayer(position);
        Deck.foldB();
        Deck.SquarePanel squarePanel = new Deck.SquarePanel();
        //add(squarePanel);
        view.setLocationRelativeTo(null); // Center the JFrame

*//*
    }*/
    /**
     * initializes the game components and starts the game*/

    public void initialize(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        //Deck deck = new Deck();
        board.initCards();
        Deck deck = new Deck();
        Deck.initPawns();
        deck.setVisible(true);
        //view = new View();
        //view.setVisible(true);
        //setListeners();
    }
   /* public void initialize() {

        player1 = new Player();
        player2 = new Player();
        board = new Board();
        Deck deck = new Deck();
        board.initCards();
        view = new View();
        view.initComponents(player1.getCards());
        view.setVisible(true);
        setListeners();
        view.updateInfobox("player red");*/
   /*
        try {
            //Deck d = new Deck();
            // Initialize player, board, and view
            player1 = new Player();
            player2 = new Player();
            board = new Board();
            view = new View();
            Deck deck = new Deck();
            Card card =  new Card();


            currentPlayer = player1;
            currentPlayer.setPawnColor(RED);
            currentPlayer.isPlayerturn();
            currentColor = RED;
            vsColor = YELLOW;
            vsNumb = 2;
            currentPawnN = 1;
            // Initialize board cards
            board.initCards();

            // Add cards to player1
            *//**//*for (int i = 0; i < 4; i++) {
                player1.addCard(board.drawCard());
            }*//**/
   /*

            // Set up the view with necessary components and update info box
            view.initComponents(player1.getCards());
            view.setVisible(true);
            setListeners();
            updateInfoBox();
            *//**//*Deck d = new Deck();
            d.setVisible(true);*//**/
   /*
            view.setTitle("Sorry Game");
            view.setSize(1035,700);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Board.initCards();
            Deck.checkCards();
            Deck.initPawns();
            Deck.MovePlayer(position);
            Deck.foldB();
            //Deck.SquarePanel squarePanel = new Deck.SquarePanel();
            //add(squarePanel);
            view.setLocationRelativeTo(null); // Center the JFrame


        } catch (Exception e) {
            // Handle any exceptions that might occur during initialization
            e.printStackTrace();
        }
*//*
  }*/
    /**Updates the info box*/
    private void updateInfoBox() {
        if (currentPlayer.isPlayerturn()){
            currentPawnN = currentPawn.number;
        }else{
            currentPawnN = vsNumb;
        }
        // Assuming you have a method to get the current player's turn color
        String turnInfo = "Turn: " + currentPawnN+"("+getCurrentPlayerTurnColor() + ")";

        // Display the remaining number of cards in the board
        String cardsLeftInfo = "Cards Left: " + board.getGameCards().size();

        // Update the info box in the view
        view.updateInfobox("Info Box\n" + turnInfo + "\n" + cardsLeftInfo);
    }
    /**returns the color of the player whose turn is*/

    private Color getCurrentPlayerTurnColor() {
        if (currentPlayer.isPlayerturn()){
            return currentColor;
        }else {
            return vsColor;
            /*if (currentColor==RED){
                return YELLOW;
            }else {
                return RED;
            }*/
        }
    }

    /**
     * <b>Transformer:</b> sets up event listeners for user interactions
     * <b>Post-condition:</b> event listeners for user interactions have been set
     **/
    public void setListeners() {
        for (int i = 0; i < view.getPlayerCards().length; i++) {
            view.getPlayerCards()[i].addMouseListener(new CardListener());
        }
    }
    /**<b>Transformer:</b> removes a card from the player's hand and replaces it
     * with a new one from the board
     * <b>Post-condition:</b> the card has been removed from player's hand
     * @param positionOfCard the position of the card in th player's hand*/

    public void removeAndReplaceCard(int positionOfCard) {
        if (board.getGameCards().isEmpty()) {
            view.updateInfobox("Game Has Finished. Available Cards 0");
        } else {
            player1.getCards().remove(positionOfCard);
            player1.getCards().add(positionOfCard, board.getGameCards().remove(0));
            Card c = player1.getCards().get(positionOfCard);
            view.updateCard(c, positionOfCard);
            if (board.getGameCards().isEmpty()) {
                view.updateInfobox("Game Has Finished. Available Cards 0");
            } else {
                view.updateInfobox("Card Replaced: Available Cards:" + board.getGameCards().size());
            }
        }
    }

    /**<b>Transformer:</b> checks if a card can be played by the player and
     * performs the necessary actions
     * @param positionOfCard the position of the card in the player's hand
     * */
    public void checkIfItCanBePlayed(int positionOfCard) {
        Card cardToPlay = player1.getCards().get(positionOfCard);
        if (board.movePlayer(player1, cardToPlay)==true) {
            player1.setHasStarted(true);
            board.setLastCardPlayed(cardToPlay);
            view.setLastCard(board.getLastCardPlayed());
            view.updatePawn(player1.getPosition());
            boolean gameFinished = checkIfGameFinished();
            if (!gameFinished) {
                removeAndReplaceCard(positionOfCard);
            } else {
                view.updateInfobox("Game Has Finished! Player Reached the End!!");
                view.showWinningMessage("You are the winner!");
            }
        }

        else{
            board.setLastCardPlayed(cardToPlay);
            view.setLastCard(board.getLastCardPlayed());
            removeAndReplaceCard(positionOfCard);
            view.updateInfobox("Invalid Move!! You should select a card having a lower value");
        }


    }

    /**
     * the main method to start the game
     * @param args the command line arguments */
    public static void main(String[] args) {

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

               /* Controller c = new Controller();
                c.initialize();*/
               // HomeSquare.homeSquare(Deck.g);
                new Deck().setVisible(true);

                //new NumberElevenCard(yellow1);
            });
        }

       /* Controller c = new Controller();
        c.initialize();*/
        /*SwingUtilities.invokeLater(() -> {
            new SquareOfSquares().setVisible(true);
        });*/

    }


        /**<b>Accessor:</b> checks if the game has finished by examining the player's
         * status and the availability of cards
         * @return True if the game has finished, false otherwise*/
    public boolean checkIfGameFinished() {
        if (player1.isHasFinished() || board.getGameCards().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * private inner class that implements a mouse listener for
     * card interactions*/

    private class CardListener implements MouseListener {

        /**
         * <b>Transformer:</b> invoked when the mouse button has been clicked (pressed and released)
         * @param e The MouseEvent representing the click event*/
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton but = ((JButton) e.getSource());
            System.out.println(but.getName());
            if (checkIfGameFinished()) {
                return;
            }
            int cardInPlayerPosition=Integer.parseInt(but.getName());
            //Perform actions based on the mouse button pressed
            if (SwingUtilities.isRightMouseButton(e)) {
                removeAndReplaceCard(cardInPlayerPosition);
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                checkIfItCanBePlayed(cardInPlayerPosition);
            }

        }

        /**<b>Transformer:</b> invoked then a mouse button has been pressed on a component
         * @param e The MouseEvent representing the press event
         * */
        @Override
        public void mousePressed(MouseEvent e) {
        }

        /**<b>Transformer:</b> invoked when a mouse button has been released on a component
         * @param e The MouseEvent representing the release event
         * */
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        /**<b>Transformer:</b> invoked when the mouse enters a component
         * @param e The MouseEvent representing the enter event*/

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        /**<b>Transformer:</b> invoked when the mouse exits a component
         * @param e The MouseEvent representing the exit event*/
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
