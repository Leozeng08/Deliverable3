/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liangzeng
 * Representative of an individual cards of cards. War specifically starts with 26 cards.
 */
public class Hand {

    private List<CardWarGame> cards; //players individual cards


    public Hand() {
        this.cards = new ArrayList<CardWarGame>();
    }

    /**
     * Merge another hand into this one
     *
     * @param other
     */
    public void mergeHand(Hand other) {
        for (CardWarGame c : other.cards) {
            this.addCardToBottom(c);
        }
    }


    /**
     * Take N cards
     *
     * @param numCards
     * @return
     */
    public List<CardWarGame> take(int numCards) {
        if (numCards > this.handSize()) {
            return null;
        }

        List<CardWarGame> out = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            out.add(this.cards.remove(this.handSize() - 1));
        }

        return out;
    }

    /**
     * @param: c single Card object added to end of Array
     */
    public void addCardToTop(CardWarGame c) {
        if (c == null) {
            throw new NullPointerException("Can't add a null card to a cards.");
        }
        cards.add(c);
    }

    /**
     * adds more than one card at a time to hand
     *
     * @param cds cards added to hand as array
     */
    public void addCardsToTop(List<CardWarGame> cds) {
        this.cards.addAll(cds);
    }

    /**
     * @param c single Card object added to beginning of Array
     */
    public void addCardToBottom(CardWarGame c) {
        cards.add(0, c);
    }

    /**
     * removes the card from the last index of the array
     * @return 
     */
    public CardWarGame removeCardFromTop() {
        if (handSize() < 1) {
            return null;
        }
        return cards.remove(handSize() - 1);
    }

    /**
     * removes card from the first index of the array
     */
    public CardWarGame removeCardFromBottom() {
        if (handSize() < 1) {
            return null;
        }
        return cards.remove(0);
    }

    /**
     * Returns the number of cards in the cards.
     */
    public int handSize() {
        return cards.size();
    }

}

