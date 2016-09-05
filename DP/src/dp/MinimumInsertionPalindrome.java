/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class MinimumInsertionPalindrome {

    public static void main(String[] args) {
        String str="geeks";
        System.out.println(minInsertionToPalindrome(str.toCharArray(), 0, str.length()-1));
        System.out.println(minInsertionToPalindromeDP(str.toCharArray(),str.length()));

    }

    public static int minInsertionToPalindrome(char s[],int l,int h)
    {
        if(l>h)
            return -1;
        if(l==h)
            return 0;
        if(l==h-1)
        {
            return (s[l]==s[h])?0:1;
        }

        return (s[l]==s[h])?minInsertionToPalindrome(s, l+1, h-1):
            (Math.min(minInsertionToPalindrome(s, l, h-1), minInsertionToPalindrome(s, l+1, h))+1);
    }

    public static int minInsertionToPalindromeDP(char s[],int n)
    {
        if(s==null || n==0)
            return -1;
        int table[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                table[i][j]=0;
            }
        }
       for (int gap = 1; gap < n; ++gap)
        for (int l = 0, h = gap; h < n; ++l, ++h)
            table[l][h] = (s[l] == s[h])? table[l+1][h-1] :
                          (Math.min(table[l][h-1], table[l+1][h]) + 1);
        return table[0][n-1];
    }

}
