/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestRepeatedSubstring {

    public static void main(String[] args) {

    String s="aaaahgjfgsssdhdb";
    longestRepeatedSubstring(s.toCharArray(), s.length());
    }

    public static void longestRepeatedSubstring(char[] s,int n)
    {
        int m[][]=new int[n+1][n+1];
        int res=0;

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                {
                    m[i][j]=0;
                }
                else if(s[i-1]==s[j-1] && i!=j)
                {
                    m[i][j]=m[i-1][j-1]+1;
                    res=Math.max(res, m[i][j]);
                }
                else
                    m[i][j]=0;
            }
        }

        System.out.println("the length of longest repeated substring is " + res);
    }

}

