/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class StringInterleaving {

    public static void main(String[] args) {

        String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";

        System.out.println(StringInterleavingDP(str1.toCharArray(),str2.toCharArray(),str3.toCharArray()));
        
    }

    public static boolean StringInterleavingDP(char s1[],char s2[],char s3[])
    {
        if(s1==null || s2==null || s3==null)
            return false;
        int n=s1.length;
        int m=s2.length;
        boolean table[][]=new boolean[n+1][m+1];
        if((n+m)!=s3.length)
            return false;

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0||j==0)
                    table[i][j]=true;

                else if(i==0 && s3[i+j-1]==s2[j-1])
                    table[i][j]=table[i][j-1];

                else if(j==0 && s3[i+j-1]==s1[i-1])
                    table[i][j]=table[i-1][j];
                else
                    table[i][j]=(s1[i-1]==s3[i+j-1])?table[i-1][j]:false || (s2[j-1]==s3[i+j-1])?table[i][j-1]:false;
            }
        }

        return table[n][m];



    }


}
