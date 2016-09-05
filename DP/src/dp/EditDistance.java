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
public class EditDistance {

    public static void main(String[] args) {

        char s1[]="sunday".toCharArray();
        char s2[]="saturday".toCharArray();

        System.out.println("string s1 " + Arrays.toString(s1));
        System.out.println("string s2 " + Arrays.toString(s2));

        int d=naive(s1,s2,s1.length,s2.length);

        System.out.println("the distance is " +d);

        dp_editDistance(s1, s2, s1.length-1, s2.length-1);



    }

    public static int naive(char s1[],char s2[],int m,int n)
    {
        if(m==0)
            return n;
        if(n==0)
            return m;

        if(s1[m-1]==s2[n-1])
        {
            return naive(s1,s2,m-1,n-1);
        }
        else
        {
            int p=naive(s1,s2,m-1,n);
            int q=Math.min(naive(s1,s2,m,n-1),naive(s1,s2,m-1,n-1));
            return 1+Math.min(p, q);

        }

    }

    public static void dp_editDistance(char s1[],char s2[],int m,int n)
    {
        int x[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                    x[i][j]=j;
                else if(j==0)
                    x[i][j]=i;
                else if(s1[i]==s2[j])
                {
                    x[i][j]=x[i-1][j-1];
                }
                else
                {
                    x[i][j]=1 + Math.min(x[i][j-1], Math.min(x[i-1][j],x[i-1][j-1]));
                }
            }
        }

        System.out.println("the dp distance is " + x[m-1][n-1]);

    }

}
