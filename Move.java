/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Move Class
 * Moves Cards between Piles based on the instruction of the player.
 * 
 * @author Tyler
 */
public class Move {
    
    char fromPile;
    char toPile;
        
    int fromCol;
    int toCol;
    
    int fromRow;
    
    Tableau[] t;
    Free[] f;
    Home[] h;
    boolean cont;
    
    /**
     * Constructor for the Move Class.
     * 
     * @param s     String containing the user's input move.
     * @param t     An array containing Tableau piles.
     * @param f     An array containing Free piles.
     * @param h     An array containing Home piles.
     */
    Move(String s, Tableau[] t, Free[] f, Home[] h, boolean cont){
        String[] move = s.split(" ");
        
        try{
            //Break input up into separate variables to work with.
            fromPile = Character.toLowerCase(move[0].charAt(0));
            toPile = Character.toLowerCase(move[1].charAt(0));

            fromCol = Character.getNumericValue(move[0].charAt(1)) - 1;
            toCol = Character.getNumericValue(move[1].charAt(1)) - 1;

            //If Row was not given in input, initialize it to 0.
            if(move[0].length() == 3){
                fromRow = Character.getNumericValue(move[0].charAt(2)) - 1;
            }else{
                fromRow = 0;
            }
        }catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException ie){
            System.out.println("INVALID INPUT! \n");
        }
        
        
        this.t = t;
        this.f = f;
        this.h = h;
        this.cont = cont;
    }
    
    /**
     * Makes the move based on the instructions of the player.
     */
    public void makeMove(){
        
        if(fromPile == 't'){
            switch(toPile){
                case 't':
                    if(fromRow == 0)
                        fromTabtoTab();
                    else
                        multiMove();
                    break;
                case 'f':
                    fromTabtoFree();
                    break;
                case 'h':
                    fromTabtoHome();
                    break;
                default:
            }
        }else if(fromPile == 'f'){
            switch(toPile){
                case 't':
                    fromFreetoTab();
                    break;
                case 'f':
                    fromFreetoFree();
                    break;
                case 'h':
                    fromFreetoHome();
                    break;
                default:
            }
        }
    }
    
    /**
     * Moves last Card from one Tableau to a free pile.
     */
    public void fromTabtoFree(){
        if(f[toCol].isLegal(t[fromCol].topCard()))
           f[toCol].placeCard(t[fromCol].takeCard());
        else
           System.out.println("INVALID MOVE! \n");
    }
    
    /**
     * Moves last Card from one Tableau pile to another Tableau pile.
     */
    public void fromTabtoTab(){
        if(t[toCol].isLegal(t[fromCol].topCard()))
           t[toCol].placeCard(t[fromCol].takeCard());
        else
           System.out.println("INVALID MOVE! \n");
    }  
    
    /**
     * Moves last Card from a Tableau pile to a home pile.
     */
    public void fromTabtoHome(){
        if(h[toCol].isLegal(t[fromCol].topCard()))
           h[toCol].placeCard(t[fromCol].takeCard());
        else
           System.out.println("INVALID MOVE! \n");
    }
    
    /**
     * Moves last Card from a free pile to a Tableau pile.
     */
    public void fromFreetoTab(){
        if(t[toCol].isLegal(f[fromCol].topCard()))
           t[toCol].placeCard(f[fromCol].takeCard());
        else
           System.out.println("INVALID MOVE! \n");
        
    }
    
    /**
     * Moves Card from a free slot to another free slot.
     */
    public void fromFreetoFree(){
        if(f[toCol].isLegal(f[fromCol].topCard()))
           f[toCol].placeCard(f[fromCol].takeCard());
        else
            System.out.println("INVALID MOVE! \n");
    }
    
    /**
     * Moves Card from a Free slot to a Home pile.
     */
    public void fromFreetoHome(){
        if(h[toCol].isLegal(f[fromCol].topCard()))
           h[toCol].placeCard(f[fromCol].takeCard());
        else
           System.out.println("INVALID MOVE! \n");
    }
    
    /**
     * Moves multiple Cards from one Tableau to another Tableau.
     */
    public void multiMove(){
        boolean legal = true;
        
        //Check to make sure all Cards can be moved legally.
        for(int i = fromRow; i < t[fromCol].getSize() - 1; i++){
            if(!legal){
                break;
            }
            else{
                if(t[fromCol].getCard(i + 1).isAfter(t[fromCol].getCard(i))){
                    legal = true;
                }else{
                    legal = false;
                }
            }
        }
        
        //If the Cards can all be moved legally, move the cards.
        //If not, move is invalid.
        if(legal){
            if(t[toCol].isEmpty()){
                while(!t[fromCol].getCard(fromRow).equals(t[fromCol].topCard())){
                    t[toCol].placeCard(t[fromCol].takeCard(fromRow));
                }
                fromTabtoTab();
            }else{
                if(t[fromCol].getCard(fromRow).isAfter(t[toCol].topCard())){
                    while(!t[fromCol].getCard(fromRow).equals(t[fromCol].topCard())){
                        t[toCol].placeCard(t[fromCol].takeCard(fromRow));
                    }
                    fromTabtoTab();
                }
            }  
        }else{
            System.out.println("INVALID MOVE!");
        }
        
    }
    
}
