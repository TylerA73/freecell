/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Tyler
 */
public class Dealer extends Pile{
    final int MAX_SIZE;
    final int MAX_RANKS;
    final int MAX_SUITS;
    Tableau[] t;
    
    /**
     * 
     * Constructor for the Dealer class.
     * 
     * @param Array of tableau piles
     * @param Array of free piles
     * @param Array of home piles
     */
    Dealer(){
        cards = new ArrayList();
        MAX_SIZE = 52;
        MAX_RANKS = 13;
        MAX_SUITS = 4;
        t = new Tableau[8];
        
        this.initDeck();
        this.shuffle();
        this.initTab();
        
    }
    
    /**
     * 
     * Initializes the deck to be dealt by the dealer.
     * 
     */
    private void initDeck(){
        for(int j = 0; j < MAX_SUITS; j++){
            Suit s;
            
            switch(j){
                case 0:
                    s = Suit.HEART;
                    break;
                case 1:
                    s = Suit.DIAMOND;
                    break;
                case 2:
                    s = Suit.SPADE;
                    break;
                case 3:
                default:
                    s = Suit.CLUB;
                    break;
            }
            
            for(int i = 1; i <=  MAX_RANKS; i++){
                Card c;
                Rank r;
                switch(i){
                    case 1:
                        r = Rank.ACE;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 2:
                        r = Rank.TWO;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 3:
                        r = Rank.THREE;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 4:
                        r = Rank.FOUR;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 5:
                        r = Rank.FIVE;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 6:
                        r = Rank.SIX;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 7:
                        r = Rank.SEVEN;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 8:
                        r = Rank.EIGHT;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 9:
                        r = Rank.NINE;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 10:
                        r = Rank.TEN;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 11:
                        r = Rank.JACK;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 12:
                        r = Rank.QUEEN;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                    case 13:
                    default:
                        r = Rank.KING;
                        c = new Card(r, s);
                        cards.add(c);
                        break;
                }
            }
            
        }
    }
    
    /**
     * 
     * Initializes the tableau array with 8 new tableaus.
     * 
     */
    private void initTab(){
        for(int i = 0; i < t.length; i++){
            t[i] = new Tableau();
        }
    }
    
    /**
     * 
     * Shuffles the deck before being dealt by the dealer.
     * 
     */
    private void shuffle(){
        Collections.shuffle(cards);
    }
    
    /**
     * 
     * Deals the deck between the eight Tableau piles.
     * 
     * @return Returns an array of 8 Tableau piles.
     */
    public Tableau[] deal(){
        int i = 0;
        
        while(!cards.isEmpty()){
            t[i].placeCard(cards.remove(cards.size()-1));
            if(i == 7){
                i = 0;
            }else{
                i++;
            }
        }
        
        
        return t;
    }
    
}
