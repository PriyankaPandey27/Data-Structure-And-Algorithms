/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        char s1[]="AGGTAB".toCharArray();
        char s2[]="GXTXAYB".toCharArray();

        System.out.println("1st string " + Arrays.toString(s1));
        System.out.println("2nd string " + Arrays.toString(s2));

        int lcs_length=naive(s1,s2,s1.length-1,s2.length-1);
        System.out.println("the LCS is " + lcs_length);
        
        LCS_dp(s1, s2, s1.length, s2.length);


    }

    public static int naive(char s1[],char s2[],int m,int n)
    {
        if(m<0||n<0)
            return 0;

        if(s1[m]==s2[n])
            return 1 + naive(s1,s2,m-1,n-1);
        else
            return Math.max(naive(s1,s2,m,n-1), naive(s1,s2,m-1,n));
    }

    public static void LCS_dp(char s1[],char s2[],int m,int n)
    {
        if(m==0||n==0)
            return;
        int x[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                {
                    x[i][j]=0;
                }
                else
                {
                    if(s1[i-1]==s2[j-1])
                    {
                        x[i][j]=x[i-1][j-1]+1;

                       //  System.out.println(s1[i-1]);
                    }
                    else
                    {
                        x[i][j]=Math.max(x[i][j-1], x[i-1][j]);
                    }
                }
            }
        }

        System.out.println("the Lcs is " + x[m][n]);
    }
}

