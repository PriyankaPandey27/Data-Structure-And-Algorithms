/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enum;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        
       DeckOfCards d=new DeckOfCards();
       d.printDeck();
       d.shuffle();
       d.printDeck();
        System.out.println("----shuffle completed------");
    }

}
