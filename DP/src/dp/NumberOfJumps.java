/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class NumberOfJumps {

    public static void main(String[] args) {

        int a[]={1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        System.out.println("minimum jumps required is " + jumpsToEnd(a));

    }

    public static int jumpsToEnd(int a[])
    {
        if(a==null||a.length==0||a[0]==0)
            return Integer.MAX_VALUE;

        int jumps[]=new int[a.length];
        jumps[0]=0;

        for(int i=1;i<a.length;i++)
        {
            jumps[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++)
            {
                if(i<=j+a[j] && jumps[j]!=Integer.MAX_VALUE)
                {
                    jumps[i]=Math.min(jumps[i], jumps[j]+1);
                    break;
                }
            }
        }
        for(int i=0;i<a.length;i++)
            System.out.print(jumps[i]+ " ");

        return jumps[a.length-1];


    }

}
