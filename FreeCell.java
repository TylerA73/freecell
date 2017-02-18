/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.Scanner;

/**
 *
 * @author Tyler Arseneault
 */
public class FreeCell {

    /**
     * Initialize the Tableau piles.
     * 
     * @param d     Dealer.
     * @return      An array containing the Tableau piles.
     */
    public static Tableau[] initTab(Dealer d){
        return d.deal();
    }
    
    /**
     * Initializes the Free piles.
     * 
     * @return      An array containing all of the Free piles. 
     */
    public static Free[] initFree(){
        Free[] f = new Free[4];
        for(int i = 0; i < f.length; i++){
            f[i] = new Free();
        }
        return f;
    }
    
    /**
     * Initializes the home pile.
     * 
     * @return      An array containing the Home piles.
     */
    public static Home[] initHome(){
        Home[] h = new Home[4];
        
        //Sets each home pile with its own suit.
        for(int i = 0; i < h.length; i++){
            switch(i){
                case 0:
                    h[i] = new Home(Suit.HEART);
                    break;
                case 1:
                    h[i] = new Home(Suit.DIAMOND);
                    break;
                case 2:
                    h[i] = new Home(Suit.SPADE);
                    break;
                case 3:
                default:
                    h[i] = new Home(Suit.CLUB);
                    break;
            }
        }
        
        return h;
    }
    
    /**
     * Displays the cards in the tableau piles.
     * 
     * @param t      An array containing theTableau piles. 
     */
    public static void printTab(Tableau[] t){
        for(int i = 0; i < t.length; i++){
            System.out.println("T" + (i+1) + ": " + t[i].toString());
        }
        System.out.println();
    }
    
    /**
     * Displays the cards in the Free piles. 
     * 
     * @param f     An array containing all of the Free piles.
     */
    public static void printFree(Free[] f){
        for(int i = 0; i < f.length; i++){
            System.out.println("F" + (i+1) + ": " + f[i].toString());
        }
        System.out.println();
    }
    
    /**
     * Displays the cards in the Home piles.
     * 
     * @param h     An array containing all of the home piles. 
     */
    public static void printHome(Home[] h){
        for(int i = 0; i < h.length; i++){
            System.out.println("H" + h[i].getSuit().toString() + ": " + h[i].toString());
        }
        System.out.println();
    }
    
    /**
     * Displays the row numbers.
     * 
     * @param t     An array containing the Tableau piles. 
     */
    public static void printRows(Tableau[] t){
        System.out.print("    ");
        for( int i = 1; i <= findMax(t); i++){
            System.out.print("  "+ i + " ");
        }
        System.out.println("\n");
    }
    
    /**
     * Finds the max number of cards between all of the Tableau piles.
     * 
     * @param t     An array containing all of the Tableau piles.
     * @return      The max number of cards in a single Tableau pile.
     */
    public static int findMax(Tableau[] t){
        int max = 0;
        
        for(int i = 0; i < t.length; i++){
            if(t[i].getSize() > max)
                max = t[i].getSize();
        }
        
        return max;
    }
    
    /**
     * Checks to see if the user chose to quit.
     * 
     * @param s     The user input to check.
     * @return      Return true if the user wants to keep playing, else return false.
     */
    public static boolean checkQuit(String s){
        if(s.equals("q") || s.equals("Q")){
            System.out.println("Thanks for playing!");
            return false;
        }    
        
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;
        Move move;
        GameState gs;
        UndoManager um;
        
        /** Tableau Piles **/
        Tableau[] t = initTab(new Dealer());
        
        /** Free Cells **/
        Free[] f = initFree();
        
        /** Home Cells **/
        Home[] h = initHome();
        
        boolean cont = true;
        
        gs = new GameState(t, h, f);
        um = new UndoManager();
        um.saveMove(gs);
        
        //Start of the game.
        //Loops until user wins, or chooses to quit.
        while(cont)
        {
            
            printHome(h);
            printFree(f);
            printTab(t);
            printRows(t);
            
            System.out.println("Move format <From col [optional: row] : To col>");
            System.out.println("Ex: T32 T4, T4 T6, T1 H1");
            
            //User input for their choice or move.
            System.out.print("Pick a move (or 'q' to quit): ");
            input = in.nextLine();
            cont = checkQuit(input);
            
            System.out.println();
            
            //If user is still playing, make the move.
            if(cont){
                if(input.length() > 1){
                    move = new Move(input, t, f, h, cont);
                    move.makeMove();
                    gs = new GameState(t, h, f);
                    um.saveMove(gs);
                }else{
                    switch(input){
                        case "u":
                            if(!um.isUndoEmpty()){
                                gs = um.undo();
                                t = gs.t;
                                h = gs.h;
                                f = gs.f;
                            }else{
                                System.out.println("CANNOT UNDO!");
                            }
                            break;
                        case "r":
                            if(!um.isRedoEmpty()){
                                gs = um.redo();
                                t = gs.t;
                                h = gs.h;
                                f = gs.f;
                            }else{
                                System.out.println("CANNOT REDO!");
                            }
                            break;
                        default:
                    }
                }
            }
            
            //If the game is finished, stop the game.
            if(h[0].isComplete() && h[1].isComplete() &&
               h[3].isComplete() && h[3].isComplete())
            {
                cont = false;
                System.out.println("You win!");
            }
        }
        
        
    }
    
}
