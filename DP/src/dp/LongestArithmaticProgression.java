/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class LongestArithmaticProgression {

    public static void main(String[] args) {

        int s[]={1, 7, 10, 13, 14, 19};
        System.out.println(LAP(s,s.length));

        int set2[] = {2, 4, 6, 8, 10};
        System.out.println(LAP_dp(set2, set2.length));

    }

    //Time complexity o(n^3)
    public static boolean LAP(int s[],int n)
    {
        if(s==null||n==0)
            return false;

        for(int j=1;j<=n-2;j++)
        {
            int i=j-1;int k=j+1;
            while(i>=0 && k<=n-1)
            {
            if(s[i]+s[k]==2*s[j])
                return true;
            if(s[i]+s[k]>2*s[j])
                i--;
            else
                k++;
            }

        }

        return true;
    }

    // o(n^2)
    public static int LAP_dp(int s[],int n)
    {
        if(n<=2)
            return 2;
        int lp[][]=new int[n][n];
        int llap=2;
        for(int i=0;i<n;i++)
        {
            lp[i][n-1]=2;
        }
        for(int j=n-1;j>=1;j--)
        {
            int i=j-1;int k=j+1;
            while(i>=0 && k<=n-1)
            {
                if(s[i]+s[k]>2*s[j])
                {
                    lp[i][j]=2;
                    i--;
                }
                else if(s[i]+s[k]<2*s[j])
                {
                    k++;
                }

                else
                {
                    lp[i][j]=lp[j][k]+1;
                    llap=Math.max(lp[i][j], llap);
                    i--;
                    k++;
                }
            }

            while(i>=0)
            {
                lp[i][j]=2;
                i--;
            }
        }

        return llap;


    }

}




