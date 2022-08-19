/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author liangzeng
 */
public class PlayerOfWarGame extends Player {
    
    private CardOfWarGame card;
    private int numberOfCard;

    @Override
    public void play() {
        System.out.println("start playing");
    }

    /**
     * @return the card
     */
    public CardOfWarGame getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(CardOfWarGame card) {
        this.card = card;
    }

    /**
     * @return the numberOfCard
     */
    public int getNumberOfCard() {
        return numberOfCard;
    }

    /**
     * @param numberOfCard the numberOfCard to set
     */
    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }
    
}
