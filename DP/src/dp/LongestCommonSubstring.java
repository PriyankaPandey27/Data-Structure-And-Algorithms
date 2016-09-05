/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestCommonSubstring {
    
    public static void main(String[] args) {
        
        
    String s1="OldSite:GeeksforGeeks.org";
    String s2="NewSite:GeeksQuiz.com";
    int n=s1.length();
    int m=s2.length();
    longestCommonSubstring(s1.toCharArray(),s2.toCharArray(),n,m);
    
    
    }
    
    
    public static void longestCommonSubstring(char s1[],char s2[],int n,int m)
    {
        int result=0;
        int dpLCS[][]=new int[n+1][m+1];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0||j==0)
                {
                    dpLCS[i][j]=0;
                }
                else if(s1[i-1]==s2[j-1])
                {
                    dpLCS[i][j]=dpLCS[i-1][j-1]+1;
                    result=Math.max(result, dpLCS[i][j]);
                }
                else
                    dpLCS[i][j]=0;
            }
        }
        
        System.out.println("the length of longest commonn substring is " + result);
    }




}
