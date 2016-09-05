/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author admin
 */
public class MaxProfitShare {
    
    public static void main(String[] args) {

        int a[]={10,22,5,75,65,80};
        maxProfit(a);

    }

    public static void maxProfit(int a[])
    {
        if(a==null || a.length==0)
            return;
        int n=a.length;
        int profit[]=new int[n];
        for(int i=0;i<n;i++)
            profit[i]=0;

        int max=a[n-1];
        for(int j=n-2;j>=0;j--)
        {
            if(a[j]>max)
                max=a[j];

            profit[j]=Math.max(profit[j+1], max-a[j]);
        }

        int min=a[0];

        for(int i=1;i<n;i++)
        {
            if(a[i]<min)
                min=a[i];

            profit[i]=Math.max(profit[i-1], profit[i]+a[i]-min);
        }

        System.out.println("the maximum profit attained is " + profit[n-1]);
    }

}
