/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class Knapsack {


    public static void main(String[] args) {


    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;

        System.out.println("the weight is " + knapSackPblm(W, wt, val));

    }


    public static int knapSackPblm(int W,int wt[],int val[])
    {
        if(W==0 || wt.length==0)
            return 0;
        
        int n=wt.length;

        int k[][]=new int[n][W+1];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(j==0)
                    k[i][j]=0;
                else if(i==0)
                    k[i][j]=wt[i];

                else if(wt[i]<=j)
                {
                    k[i][j]=Math.max(val[i]+k[i-1][j-wt[i]], k[i-1][j]);//including the last weight
                }
                else
                    k[i][j]=k[i-1][j];//excluding the last weight
            }
        }

        return k[n-1][W];
    }

}
