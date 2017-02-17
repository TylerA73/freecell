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
public class Free extends Pile{
    final int MAX_SIZE;
    
    /**
     * 
     * Constructor for the Free class
     * 
     */
    Free(){
        cards = new ArrayList();
        MAX_SIZE = 1;
    }
    
    /**
     * 
     * Checks to see if a move made to or from the Free pile is legal or not
     * 
     * @return Returns true if the move is legal, false otherwise.
     */
    @Override
    public boolean isLegal(Card c){
        return cards.isEmpty();
    }
    
}
