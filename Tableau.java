/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;

/**
 *
 * @author Tyler
 */
public class Tableau extends Pile {
    
    /**
     * Constructor for the Tableau class.
     */
    Tableau(){
        cards = new ArrayList();
    }
    
    /**
     * Returns the total number of cards in the pile.
     * 
     * @return      Integer number of the size of the pile. 
     */
    public int getSize(){
        return cards.size();
    }
    
    /**
     * Checks to see if a card can legally be placed on top.
     * 
     * @param c     Card being checked.
     * @return      True if the card can be placed on this Tableau pile, false otherwise.
     */
    @Override
    public boolean isLegal(Card c){
        return (this.cards.isEmpty() || c.isAfter(this.cards.get(cards.size()-1)));
    }
}
