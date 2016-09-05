/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class PartitionProblem {

    public static void main(String[] args) {

         int arr[] = {3, 1, 5, 9, 12};
         int n=arr.length;
         boolean s=findPartition(arr, n);
         if(s==true)
         {
             System.out.println("the given array can be divided into two sets of same sum");
         }
         else
         {
             System.out.println("the array cannot be divided into two sets of same sum");
         }

         boolean dp=dp_partition(arr, n);
         if(dp==true)
         {
             System.out.println("partion cn b done");
         }
         else
         {
             System.out.println("no partition can b done");
         }


    }

    public static boolean findPartition(int a[],int n)
    {
       int sum=0;
       for(int i=0;i<n;i++)
       {
           sum+=a[i];
       }

       if(sum%2!=0)
           return false;

       return isSubsetSum(a,n,sum/2);
    }

    public static boolean isSubsetSum(int a[],int n,int sum)
    {
        if(sum==0)
            return true;
        if(n==0 && sum!=0)
            return false;

        if(a[n-1]>sum)
            return isSubsetSum(a, n-1, sum);

        return isSubsetSum(a, n-1, sum)|| isSubsetSum(a, n-1, sum-a[n-1]);
    }

    public static boolean dp_partition(int a[],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
        }

        if(sum%2!=0)
            return false;
        boolean t[][]=new boolean[n][sum/2+1];

        for(int i=0;i<n;i++)//sum is zero
        {
            t[i][0]=true;
        }


        for(int i=1;i<=sum/2;i++)
        {
            if(a[0]==i)
                t[0][i]=true;
            else
                t[0][i]=false;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=sum/2;j++)
            {

                if(j<a[i])
                {
                    t[i][j]=t[i-1][j];
                }
                else
                    t[i][j]=t[i-1][j]||t[i-1][j-a[i]];
            }
        }

//         for(int i=0;i<=sum/2;i++)
//        {
//            for(int j=0;j<=n;j++)
//            {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println("");
//        }


        return t[n-1][sum/2];


    }



}
