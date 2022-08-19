/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author liangzeng
 */
public class WarGame extends Game{
    
    private String name = "War Game";//the title of the game
    private ArrayList<PlayerOfWarGame> players;// the players of the game
    
    public static void main(String[] args) {
        WarGame game = new WarGame();
        PlayerOfWarGame player1 = game.getPlayers().get(0);
        PlayerOfWarGame player2 = game.getPlayers().get(1);
        player1.setNumberOfCard(52);
        game.declareWinner();
    }
    

    @Override
    public void play() {
        /*PlayerOfWarGame player1 = new PlayerOfWarGame();
        PlayerOfWarGame player2 = new PlayerOfWarGame();
        int player1CardNumber = player1.getCard().getCardNumber();
        int player2CardNumber = player2.getCard().getCardNumber();
        int player1CardCount = 26;
        int player2CardCount = 26;
        if(player1CardNumber > player2CardNumber){
            player1.setNumberOfCard(player1CardCount + 1);
            player2CardCount--;
        }else if(player1CardNumber < player2CardNumber){
            player2.setNumberOfCard(player2CardCount + 1);
            player1CardCount--;
        }else{
            player1CardCount--;
            player2CardCount--;
        }*/
        
    }

    /**
     *
     */
    public void declareWinner() {
        PlayerOfWarGame player1 = getPlayers().get(0);
        PlayerOfWarGame player2 = getPlayers().get(1);
        boolean isEnd = false;
        while(!isEnd){
            player1.play();
            player2.play();
            if(player1.getNumberOfCard() == 52){
                System.out.println("Player1 win the game");
            }else if(player2.getNumberOfCard() == 52){
                System.out.println("Player 2 wins the game");
            }
            isEnd = true;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the players
     */
    @Override
    public ArrayList<PlayerOfWarGame> getPlayers() {
        return this.players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<PlayerOfWarGame> players) {
        this.players = players;
    }

   
}
