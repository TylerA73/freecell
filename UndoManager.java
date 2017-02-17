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
public class UndoManager {
    private ArrayList<GameState> undo;
    private ArrayList<GameState> redo;
    private GameState gs;
    
    UndoManager(){
        undo = new ArrayList();
        redo = new ArrayList();
    }
    
    public void saveMove(GameState gs){
        undo.add(this.gs);
        this.gs = gs;
        clearRedo();
        
    }
    
    public GameState undo(){
        redo.add(this.gs);
        this.gs = undo.remove(undo.size() - 1);
        
        return this.gs;
    }
    
    public GameState redo(){
        undo.add(this.gs);
        this.gs = redo.remove(redo.size() - 1);
        
        return this.gs;
    }
    
    private void clearRedo(){
        
        redo.clear();
      
        
    }
    
    
}
