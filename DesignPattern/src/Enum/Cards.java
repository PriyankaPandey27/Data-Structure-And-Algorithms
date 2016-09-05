/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enum;

/**
 *
 * @author admin
 */
public class Cards {



    public Suites suite;
    public Rank rank;

    public Cards(Suites suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public String cardInfo()
    {
        return suite +" " + rank;
    }





}
