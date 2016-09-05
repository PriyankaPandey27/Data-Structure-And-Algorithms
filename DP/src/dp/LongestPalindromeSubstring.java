/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        //String s="forgeeksskeegforpriyankapanddnapaknayirpfgdfugnikhilagrawallawargalihkin";
        String s="aabbccbb";
        String p=palindromeSubstring(s.toCharArray());
        System.out.println(p.toString());

    }


    public static String palindromeSubstring(char s[])
    {
       
        int n=s.length;
        int max=1;
        boolean table[][]=new boolean[n][n];
        int maxLength=1;
        int start=0;

        // for 1 string
        for(int i=0;i<n;i++)
        {
            table[i][i]=true;
        }

        //for 2 string
        for(int i=0;i<n-1;i++)
        {
            if(s[i]==s[i+1])
            {
                table[i][i+1]=true;
                maxLength=2;
                if(max<maxLength)
                {
                    max=maxLength;
                    start=i;
                }
            }
        }

        //for string more then 2
        for(int k=3;k<=n;k++)
        {
            for(int i=0;i<n-k+1;i++)
            {
                int j=i+k-1;
                if(table[i+1][j-1] && s[i]==s[j])
                {
                    table[i][j]=true;
                    maxLength=k;
                    if(max<maxLength)
                {
                    max=maxLength;
                    start=i;
                }

                }
            }
        }

        //System.out.println("the length of the longest palindrome substring is " + max);

       // printString(s, start, start+maxLength-1);

        String p="";
        for(int i=start;i<=start+max-1;i++)
        {
            p+=s[i];
        }

        return p;


    }

    public static void printString(char s[],int start,int end)
    {
        for(int i=start;i<=end;i++)
        {
            System.out.print(s[i]+ " ");
        }
    }



}
