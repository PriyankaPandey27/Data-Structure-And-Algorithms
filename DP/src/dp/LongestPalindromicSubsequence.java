/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String s="BBABCBCAB";
        System.out.println("the length is " + naive(s.toCharArray(), 0, s.length()-1));
        lps_Dp(s.toCharArray(), s.length());
        //naive(s.toCharArray(), 0, s.length()-1);

    }

    public static int naive(char s[],int i,int j)
    {
        if(i==j)
            return 1;
        if(s[i]==s[j] && i+1==j)
            return 2;
        if(s[i]==s[j])
            return naive(s, i+1, j-1)+2;
        else
            return Math.max(naive(s, i+1, j), naive(s, i, j-1));
    }


    public static void lps_Dp(char s[],int n)
    {
        int m[][]=new int[n][n];

        for(int i=0;i<n;i++)
            m[i][i]=1;

        for(int c=2;c<=n;c++)
        {
            for(int i=0;i<n-c+1;i++)
            {
                int j=i+c-1;

                if(s[i]==s[j] && c==2)
                {
                    m[i][j]=2;
                }
                else if(s[i]==s[j])
                    m[i][j]=m[i+1][j-1]+2;
                else
                {
                    m[i][j]=Math.max(m[i+1][j], m[i][j-1]);
                }
            }
        }

        System.out.println("the length is " + m[0][n-1]);
    }

}
