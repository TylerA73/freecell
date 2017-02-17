
package freecell;

/**
 * Card has-a suit
 * The suit of a Card.
 *
 * @author Tyler
 */
public enum Suit {
    HEART(0, "\u2665", true), DIAMOND(1, "\u2666", true), 
    SPADE(2, "\u2660", false), CLUB(3, "\u2663", false);
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private final int ordinal;
    private final String display;
    private final boolean isRed;
    
    /**\
     * Constructor for the suit Enum.
     * 
     * @param o     An int as the ordinal of the suit.
     * @param d     String of the display of the suit.
     * @param r     Boolean as true if the suit is red, false if not.
     */
    Suit(int o, String d, boolean r){
        ordinal = o;
        if(ordinal == 0 || ordinal == 1){
            display = ANSI_RED + d + ANSI_RESET;
        }else
            display = d;
            isRed = r;
    }
    
    /**
     * Creates a String of the suit.
     * 
     * @return  Returns the String display.
     */
    @Override
    public String toString(){
        return display;
    }
    
    /**
     * Checks to see if two separate suits are equal.
     * 
     * @param other     Another suit.
     * @return          True if the suits are the same, false otherwise.
     */
    public boolean equals(Suit other){
        return this.ordinal == other.getOrdinal();
    }
    
    /**
     * Check to see if this suit is red.
     * 
     * @return      True if the suit is red, false otherwise.
     */
    public boolean isRed(){
        return isRed;
    }
    
    /**
     * Returns the ordinal of the suit.
     * 
     * @return      The ordinal of the suit.
     */
    public int getOrdinal(){
        return ordinal;
    }
    
    
    
}
