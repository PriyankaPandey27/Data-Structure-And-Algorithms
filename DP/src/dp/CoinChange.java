/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class CoinChange {

    public static void main(String[] args) {
        int a[]={1,2,3};
        int l=count(a,a.length,4);
        System.out.println("the coin change is " + l);
        count_dp(a, a.length, 4);

    }

    public static int count(int a[],int m,int n)
    {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(m<=0 && n>=1)
            return 0;

//        for(int i=0;i<m-1;i++)
//        {
//            System.out.print(a[i] + " ");
//        }
       // System.out.println( count(a,m-1,n) + " ");

        return count(a,m-1,n) + count(a,m,n-a[m-1]);
    }

    public static void count_dp(int a[],int n,int sum)
    {
        int table[][]=new int[n][sum+1];
        //int x,y;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=sum;j++)
              {
                  if(i==0||j==0)
                      table[i][j]=1;
              }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=sum;j++)
            {

                if(j<a[i])
                {
                    table[i][j]=table[i-1][j];
                }
                else
                    table[i][j]=table[i-1][j]+table[i][j-a[i]];
            }
        }
        System.out.println("the dp count is " + table[n-1][sum]);
    }

}
