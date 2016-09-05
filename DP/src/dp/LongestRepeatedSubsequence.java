/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestRepeatedSubsequence {

    public static void main(String[] args) {

        String s1="aaaabb";
        longestRepeatedString(s1.toCharArray(), s1.length());

    }

    public static void longestRepeatedString(char[] s ,int n)
    {
        int dpLRS[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                {
                    dpLRS[i][j]=0;
                }
                else
                {
                  if(s[i-1]==s[j-1] && i!=j)
                  {
                    dpLRS[i][j]=dpLRS[i-1][j-1]+1;
                  }
                  else
                  {
                    dpLRS[i][j]=Math.max(dpLRS[i][j-1], dpLRS[i-1][j]);
                  }
                }
            }
        }

        System.out.println("the length of longest repeated substring is " + dpLRS[n][n]);
    }

}
