/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Card has-a rank
 * The rank of a Card.
 *
 * @author Tyler
 */
public enum Rank {
    ACE(1, "A"),    TWO(2, "2"),
    THREE(3, "3"),  FOUR(4, "4"),
    FIVE(5, "5"),   SIX(6, "6"),
    SEVEN(7, "7"),  EIGHT(8, "8"),
    NINE(9, "9"),   TEN(10, "T"),
    JACK(11, "J"),  QUEEN(12, "Q"),
    KING(13, "K");
    
    private final int value;
    private final String display;
    
    /**
     * Constructor for the Rank.
     * 
     * @param v     Value of the Rank.
     * @param d     Display String of the Rank.
     */
    Rank(int v, String d){
        value = v;
        display = d;
    }
    
    /**
     * Checks to see if two Ranks are the same.
     * 
     * @param r     Another Rank.
     * @return      Returns true if the values are the same, false otherwise.
     */
    public boolean equals(Rank r){
        return value == r.getValue();
    }
    
    /**
     * Creates a String with the display of the rank.
     * 
     * @return      The display of the Rank.
     */
    @Override
    public String toString(){
        return display;
    }
    
    /**
     * Checks to see if a Rank is after another Rank.
     * 
     * @param other     Another Rank.
     * @return          True if this Rank is after other Rank.
     */
    public boolean isAfter(Rank other){
        return this.value == (other.value - 1); 
    }
    
    /**
     * Returns the value of the Rank.
     * 
     * @return      The value of the Rank.
     */
    public int getValue(){
        return value;
    }
    
    
}
