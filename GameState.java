/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 *
 * @author Tyler
 */
public class GameState {
    Tableau[] t;
    Home[] h;
    Free[] f;
    
    
    GameState(Tableau[] t, Home[] h, Free[] f){
        this.t = new Tableau[8];
        this.h = new Home[4];
        this.f = new Free[4];
        
        for(int i = 0; i < this.t.length; i++){
            this.t[i] = new Tableau();
        }
        
        this.h[0] = new Home(Suit.HEART);
        this.h[1] = new Home(Suit.DIAMOND);
        this.h[2] = new Home(Suit.SPADE);
        this.h[3] = new Home(Suit.CLUB);
        
        for(int i = 0; i < this.f.length; i++){
            this.f[i] = new Free();
        }
        
        copyTabs(t);
        copyHome(h);
        copyFree(f);
    }
    
    public void copyTabs(Tableau[] t){
        
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[i].getSize(); j++){
                this.t[i].placeCard(new Card(t[i].getCard(j)));
            }
        }
        
    }
    
    public void copyHome(Home[] h){
        for(int i = 0; i < h.length; i++){
            for(int j = 0; j < h[i].getSize(); j++){
                this.h[i].placeCard(new Card(h[i].getCard(j)));
            }
        }
    }
    
    public void copyFree(Free[] f){
        for(int i = 0; i < f.length; i++){
            for(int j = 0; j < f[i].getSize(); j++){
                this.f[i].placeCard(new Card(f[i].getCard(j)));
            }
        }
    }
    
}
