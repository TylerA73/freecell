/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;

/**
 * Manages the undo/redo feature of the FreeCell game. Stores each game state
 * into an undo array list, or redo array list if the move is undone.
 * 
 * @author Tyler
 */
public class UndoManager {
    private ArrayList<GameState> undo;
    private ArrayList<GameState> redo;
    private GameState gs;
    
    /**
     * Constructor for the UndoManager class.
     */
    UndoManager(){
        undo = new ArrayList();
        redo = new ArrayList();
    }
    
    /**
     * Saves the state of the game onto the undo array list.
     * 
     * @param gs    A new GameState after a move has been made.
     */
    public void saveMove(GameState gs){
        clearRedo();
        System.out.println(redo.size());
        undo.add(this.gs);
        this.gs = gs;
        
        
    }
    
    /**
     * Places the last move onto the redo stack, and pops off the previous move.
     * 
     * @return  The previous GameState;
     */
    public GameState undo(){
        redo.add(this.gs);
        System.out.println(redo.size());
        this.gs = undo.remove(undo.size() - 1);
        
        return this.gs;
    }
    
    /**
     * Places the last move placed onto the redo stack, and makes it the current state of the game.
     * 
     * @return  The last undone GameState;
     */
    public GameState redo(){
        undo.add(this.gs);
        this.gs = redo.remove(redo.size() - 1);
        System.out.println(redo.size());
        
        return this.gs;
    }
    
    /**
     * Clears the redo array list of all GameStates.
     */
    private void clearRedo(){
        
        redo.clear();
      
        
    }
    
    
}
