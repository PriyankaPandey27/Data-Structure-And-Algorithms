/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class maxSumIncreasingSubsequence {

    public static void main(String[] args) {

       int a[]= {1, 101, 2, 3, 100, 4, 5};
       maxSum(a, a.length);


    }

    public static void maxSum(int a[],int n)
    {
        int sum[]=new int[n];
        for(int i=0;i<n;i++)
        {
            sum[i]=a[i];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j]<=a[i] && sum[i]<sum[j]+a[i])
                {
                    sum[i]=sum[j]+a[i];
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<sum[i])
            {
                max=sum[i];
            }
        }

        System.out.println("the maxium sum is " + max);
    }

}
