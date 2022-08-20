/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author liangzeng
 */
public class WarGame extends Game{
    
    private final String name = "War Game";
    
    WarGame(String name){
        super(name);
    }
    
    private GroupOfCards deck;
    /**
     * Human Player
     */
    private PlayerOfWarGame humanPlayer;

    /**
     * CPU Player
     */
    private PlayerOfWarGame cpuPlayer;

    /**
     * start the game
     */
    public void play() {
        //print opening message
        
        System.out.println("It's a war of cards!\n" +
                "This Game is automated and will play until one deck is empty or the game reaches 25 rounds.\n" +
                "It's you against the CPU.\n");
        //System.out.println("This Game is automated and will play until one deck is empty or the game reaches 25 rounds.");
        //System.out.println("It's you against the CPU.");
        System.out.println("Please enter your name.");
        System.out.println("Indicate that you are ready by hitting enter.");
        // get player 1 name from stdin
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        this.humanPlayer = new PlayerOfWarGame(name);
        this.cpuPlayer = new PlayerOfWarGame("CPU");

        //start Game Message
        System.out.println("let's Play!\n"+ humanPlayer.getName());

        //create fresh deck
        deck = new GroupOfCards();

        //shuffle deck
        deck.shuffleDeck();

        //Create and set hands
        humanPlayer.setHand(new Hand());
        cpuPlayer.setHand(new Hand());

        //dealCards to hand
        dealCards(humanPlayer.getHand());
        dealCards(cpuPlayer.getHand());

        String header = "#CardsInHand";
        String winner = "Round Winner";
        System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", humanPlayer.getName(), header, cpuPlayer.getName(), header, winner);

        // show result
        int maxRounds = 27;
        
        PlayerOfWarGame finalWinner = null;
        while (battle(humanPlayer, cpuPlayer, null)) {
            maxRounds--;
            

            // check hands for winner
            if (humanPlayer.getHand().handSize() == 0) {

                // cpu is winner
                finalWinner = cpuPlayer;
                break;
            } else if (cpuPlayer.getHand().handSize() == 0) {

                // player is winner
                finalWinner = humanPlayer;
                break;
            }

            if (maxRounds < 0) {
                break;
            }
        }

        if (finalWinner != null) {

            // someone won
        } else if (humanPlayer.getHand().handSize() > cpuPlayer.getHand().handSize()) {
            finalWinner = humanPlayer;
        } else if (cpuPlayer.getHand().handSize() > humanPlayer.getHand().handSize()) {
            finalWinner = cpuPlayer;
        } else {

            // draw
            System.out.printf("Sorry, the game ended in a draw.");
            return;
        }
        this.declareWinner(finalWinner);
        
    }
    

    // Deal 26 cards to each hand in alternating order
    public void dealCards(Hand hand) {
        for (int i = 0; i < 26; i++) {
            hand.addCardToTop(deck.dealCard());
        }
    }

    // Models a battle between player1 and player2. If the battle
    // results in a war, three cards from each player are placed
    // in the prize queue and the battle is continued recursively.
    public boolean battle(PlayerOfWarGame playerOne, PlayerOfWarGame playerTwo, Hand pot) {

        // both players show top card from deck, each player draws from top of deck
        //store cards that are in play in an array.
        CardWarGame playerOneFaceUp = playerOne.getHand().removeCardFromTop();
        if (playerOneFaceUp == null) {
            return false;
        }

        CardWarGame playerTwoFaceUp = playerTwo.getHand().removeCardFromTop();
        if (playerTwoFaceUp == null) {
            return false;
        }

        //In case of war each player adds 3 cards to pot and the forth card is evaluated
        if (pot == null) {
            pot = new Hand();
        }
        pot.addCardToTop(playerOneFaceUp);
        pot.addCardToTop(playerTwoFaceUp);

        int result = playerOneFaceUp.compareTo(playerTwoFaceUp);
        switch (result) {
            case 0:
                System.out.println("WAR! There was a tie and War was initiated.");

                //each player adds three cards to the prize hand
                List<CardWarGame> warPlayerOnePot = playerOne.getHand().take(3);
                if (warPlayerOnePot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerOnePot);

                List<CardWarGame> warPlayerTwoPot = playerTwo.getHand().take(3);
                if (warPlayerTwoPot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerTwoPot);

                return battle(playerOne, playerTwo, pot);
            case 1:
                //Give all cards on table to player 1
                //player1 adds both face up cards to bottom of her deck
                playerOne.getHand().mergeHand(pot);
                
                System.out.printf("%-20s %-20s %-20s %-20s %s is winner.\n", 
                        playerOneFaceUp.toString(), playerOne.getHand().handSize(), 
                        playerTwoFaceUp.toString(), playerTwo.getHand().handSize(), humanPlayer.getName());
                break;         
            case -1:
                //Give all cards on table to player 2
                //player2 adds both face up cards to bottom of his deck
                playerTwo.getHand().mergeHand(pot);
                System.out.printf("%-20s %-20s %-20s %-20s %s is winner.\n", 
                        playerOneFaceUp.toString(), playerOne.getHand().handSize(), 
                        playerTwoFaceUp.toString(), playerTwo.getHand().handSize(), cpuPlayer.getName());
                break;
        }

        return true;
    }

  

    @Override
    public void declareWinner(Player player) {
        PlayerOfWarGame player1 = (PlayerOfWarGame) player;
        System.out.printf("The winner of the game is %s!", player1.getName());
    }
    
    public static String declareWinner(PlayerOfWarGame player){
        return "The winner of the game is ," + player.getName();
    }



  

    
   

   
}
