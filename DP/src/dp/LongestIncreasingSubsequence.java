/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
import java.util.Arrays;


 class LongestIncresingSubsequence {

     public static void main(String args[])
     {
         int a[]={0, 8, 4, 12, 2, 10, 6, 14};
         System.out.println("Initial Array " + Arrays.toString(a));
         Lis(a);

     }

     public static int[] initialise(int n[])
     {
         for(int i=0;i<n.length;i++)
             n[i]=1;

         return n;
     }

     public static void Lis(int a[])
     {
         System.out.println("the value is " + LISSecond(a));
     }

     public static int LISUtil_bottumUp(int a[])
     {
         int max=Integer.MIN_VALUE;
         int lis[]=new int[a.length];
         lis=initialise(lis);

         for(int i=1;i<a.length;i++)
         {
             int maxIndex=-1;
             int maxValue=-1;

             for(int j=0;j<i;j++)
             {
                 if(a[j]<=a[i] && maxValue<lis[j]){
                     maxValue=lis[j];
                     maxIndex=j;
                 }
             }

             if(maxIndex!=-1)
             {
                 lis[i]=lis[maxIndex]+1;
             }
         }

         System.out.println("the list is " +Arrays.toString(lis));

         for(int k=0;k<lis.length;k++)
         {
             if(max<lis[k])
                 max=lis[k];
         }

         return max;
     }


     public static int LISSecond(int a[])
     {
         if(a==null||a.length==0)
             return -1;
         int max=Integer.MIN_VALUE;
        int lis[]=new int[a.length];
        lis=initialise(lis);

        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[i]>a[j] && lis[i]<lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }

         System.out.println("the list is " +Arrays.toString(lis));
        for(int k=0;k<lis.length;k++)
         {
             if(max<lis[k])
                 max=lis[k];
         }

         return max;

     }
}
