/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class SubsetSumProblem {

    public static void main(String[] args) {

        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 13;
        System.out.println(subSetSum(set, sum));

    }

    public static boolean subSetSum(int a[],int sum)
    {
        boolean subset[][]=new boolean[a.length][sum+1];

        for(int i=0;i<a.length;i++)// when sum is zero
        {
            subset[i][0]=true;
        }
        
        for(int i=1;i<=sum;i++)//subset is null
        {
            if(a[0]<i)
            subset[0][i]=false;
            else if(a[0]==i)
            subset[0][i]=true;
        }



        for(int i=1;i<a.length;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j<a[i])
                {
                    subset[i][j]=subset[i-1][j];
                }
                else
                {
                    subset[i][j]=subset[i-1][j]||subset[i-1][j-a[i]];
                }
            }
        }

        return subset[a.length-1][sum];

    }

}
