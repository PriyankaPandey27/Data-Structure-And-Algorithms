/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enum;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class DeckOfCards {

    public static int noOfCards=52;
    Cards deck[]=new Cards[noOfCards];

    public DeckOfCards() {

        int i=0;
        for(Suites s: Suites.values())
        {
            for(Rank r: Rank.values())
            {
                deck[i]=new Cards(s, r);
                i++;
            }
        }
    }

    public void printDeck()
    {
        for(int i=0;i<noOfCards;i++)
        {
            System.out.println(deck[i].cardInfo() + " ");
        }
    }

    public void shuffle()
    {
        System.out.println("-----before shuffling------");
        Collections.shuffle(Arrays.asList(deck));

    }



}
