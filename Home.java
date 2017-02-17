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
public class Home extends Pile {
    final int MAX_SIZE;
    final Suit SUIT;
    
    
    /**
     * 
     * Constructor for the Home class
     * 
     * @param s     The accepted suit of this Home pile (HEART, CLUB, DIAMOND, or SPADE)
     */
    Home(Suit s){
        cards = new ArrayList();
        MAX_SIZE = 13;
        SUIT = s;
    }
    
    /**
     * Creates a String of the cards in the Home pile.
     * 
     * @return      String containing all of the cards in the Home pile.
     */
    @Override
    public String toString(){
        String s = new String();
        if(cards.size() > 0){
            s = "[ " + cards.get(cards.size()-1).toString() + " ]";
        }
        return s;
    }
    /**
     * 
     * Checks to see if a move to the home pile is legal
     * 
     * @param c     The card to check to see if the move is legal with
     * @return      Returns true if the move is legal, false otherwise.
     */
    @Override
    public boolean isLegal(Card c){
        int last = cards.size() - 1;
        
        if(cards.isEmpty() && c.getRank().equals(Rank.ACE) &&
                this.SUIT.equals(c.getSuit())){
            return true;
        } else if(!cards.isEmpty() && !this.isComplete() && cards.get(last).isAfterInSuit(c)){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * Checks to see if the home pile is completed (full)
     * 
     * @return Return true if the pile is completed(full), false otherwise
     */
    public boolean isComplete(){
        return cards.size() == MAX_SIZE;
    }
    
    /**
     * 
     * Returns the suit of the Home pile.
     * 
     * @return The suit of the home pile.
     */
    public Suit getSuit(){
        return SUIT;
    }
    
}
