/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PatternPrint;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class RectangularPattern {

    public static void main(String[] args) {

        int n=4;
        ArrayList<ArrayList<Integer>> rst=prettyPrint(n);
        for(ArrayList<Integer> t : rst)
        {
            System.out.println(t.toString()+ " ");
        }
    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int a)
    {
        int len=2*a-1;
        int rec[][]=new int[len][len];
        ArrayList<ArrayList<Integer>> lst=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<a;i++)
        {
            for(int j=0;j<a;j++)
            {
                if(j<=i)
                    rec[i][j]=a-j;
                else
                    rec[i][j]=a-i;

            }
        }


        for(int i=0;i<a;i++)
        {
            for(int j=len-1;j>=a;j--)
            {
                rec[i][j]=rec[i][len-1-j];
            }
        }

        for(int i=len-1;i>=a;i--)
        {
            for(int j=0;j<len;j++)
            {
                rec[i][j]=rec[len-1-i][j];
            }
        }


//        for(int i=0;i<len;i++)
//        {
//            for(int j=0;j<len;j++)
//            {
//                System.out.print(rec[i][j]+" ");
//            }
//            System.out.println("");
//        }

        for(int i=0;i<rec.length;i++)
        {
            lst.add(new ArrayList<Integer>());
            for(int j=0;j<rec[0].length;j++)
            {
                lst.get(i).add(rec[i][j]);
            }
        }

        return lst;

    }
}
