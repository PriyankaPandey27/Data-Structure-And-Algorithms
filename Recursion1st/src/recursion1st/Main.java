/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recursion1st;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
//        int x =10;
        recursion(10);
    }

    public static int recursion(int x)
    {
        if(x==1)
        {
            System.out.println(x);
            return x;
        }
        else
        {
          //  int p=0;
            int p=recursion(x-1);
            System.out.println(p+1);
            return(p+1);
        }
    }
}
