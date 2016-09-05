/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class rodCutting {

    public static void main(String[] args) {
        int p[]={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("the maximum sum of a rod is  " + naive(p, p.length));
        System.out.println("the maximum sum of a rod using dp " + dp_RodCutting(p, p.length));

    }

    public static int naive(int p[],int n)
    {
        if(n<=0)
            return 0;
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxValue=Math.max(maxValue, p[i]+naive(p, n-i-1));
        }

        return maxValue;

    }

    public static int dp_RodCutting(int p[],int n)
    {
        int v[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int maxValue=Integer.MIN_VALUE;
            for(int j=0;j<i;j++)
            {
                maxValue=Math.max(maxValue, p[j]+v[i-j-1]);
                v[i]=maxValue;

            }
        }

        for(int i=0;i<=n;i++)
        {
            System.out.println(v[i] + " ");
        }
        return v[n];
    }

}
