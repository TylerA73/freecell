/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;

/**
 *  Abstract class Pile that cannot be instantiated. Simply creates a foundation.
 * 
 * @author Tyler
 */
public abstract class Pile {
    ArrayList<Card> cards;
    
    /**
     * Constructor for the Pile class.
     */
    Pile(){
        cards = new ArrayList();
    }
    
    /**
     * Creates a String of all of the cards in the pile.
     * 
     * @return 
     */
    @Override
    public String toString(){
        String s = new String();
        for(int i = 0; i < cards.size()-1; i++){
            s = s + "[ " + cards.get(i).toString();
        }
        if(!cards.isEmpty()){
            s = s + "[ " + cards.get(cards.size() - 1).toString() + " ]";
        }
        
        return s;
    }
    
    /**
     * Returns a card at a given index.
     * 
     * @param i     Index of the Card.
     * @return      Card at index i.
     */
    public Card getCard(int i){
        return cards.get(i);
    }
    
    /**
     * Takes the last card of the Pile.
     * 
     * @return      The last card of the pile.
     */
    public Card takeCard(){
        return cards.remove(cards.size()-1);
    }
    
    /**
     * Takes a card at a given index.
     * 
     * @param i     Index of the card to be taken.
     * @return      The card at index i.
     */
    public Card takeCard(int i){
        return cards.remove(i);
    }
    
    /**
     * Places a card on the pile.
     * 
     * @param c     The card to be placed on the pile.
     */
    public void placeCard(Card c){
        cards.add(c);
    }
    
    /**
     * Checks to see if it is legal to put a card on this pile.
     * 
     * @param c     The card to check legality with.
     * @return      True.
     */
    public boolean isLegal(Card c){
        return true;
    }
   
    /**
     * Checks to see if the pile is empty or not.
     * 
     * @return      True if the pile is empty, false otherwise.
     */
    public boolean isEmpty(){
        return cards.isEmpty();
    }

    /**
     * Peeks st the top card of the pile.
     * 
     * @return      The last card on the pile.
     */
    public Card topCard(){
        return cards.get(cards.size()-1);
    }
    
    public int getSize(){
        return cards.size();
    }
    
}
