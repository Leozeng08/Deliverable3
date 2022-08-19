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
public class PlayerOfWarGame extends Player {
    
    private String name;
    private Hand hand;

    public PlayerOfWarGame(String name) {
        super(name);
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public void play() {
       
    }
}
