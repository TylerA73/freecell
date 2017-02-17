/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Card has-a suit
 * Card has-a rank
 *
 * @author Tyler
 */
public class Card {
    private final Rank RANK;
    private final Suit SUIT;
    
    /**
     * Constructor for the Card class.
     * 
     * @param r     Rank of the card.
     * @param s     Suit of the card.
     */
    Card(Rank r, Suit s){
        RANK = r;
        SUIT = s;
    }
    
    Card(Card other){
        this.RANK = other.getRank();
        this.SUIT = other.getSuit();
    }
    
    /**
     * Returns a string containing the Rank and suit of the card.
     * 
     * @return      String containing the Rank and Suit of the Card.
     */
    @Override
    public String toString(){
        return RANK.toString() + SUIT.toString();
    }
    
    /**
     * Returns the Rank of the card.
     * 
     * @return      The Rank of the card. 
     */
    public Rank getRank(){
        return RANK;
    }
    
    /**
     * Returns the Suit of the card.
     * 
     * @return      The suit of the Card. 
     */
    public Suit getSuit(){
        return SUIT;
    }
    
    /**
     * Checks to see if this card is after another in the same suit.
     * 
     * @param other     Another card.
     * @return          True if this card is after other Card, but suit is the same.
     */
    public boolean isAfterInSuit(Card other){
        return this.SUIT.equals(other.getSuit()) && this.RANK.isAfter(other.getRank());
    }
    
    /**
     * Checks to see if this Card is after another Card, but colours are opposite.
     * 
     * @param other     Another card.
     * @return          True if this Card is after other card, but the colour of the suits are opposite.
     */
    public boolean isAfter(Card other){
        return (this.SUIT.isRed() != other.getSuit().isRed()) &&
                this.RANK.isAfter(other.getRank());
    }
}
