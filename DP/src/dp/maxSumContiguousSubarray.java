/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class maxSumContiguousSubarray {

    public static void main(String[] args) {

        int a[]={1,10,-3,-4,-5,-6,-1};
        maxSum(a);

    }

    public static void maxSum(int a[])
    {
       int max_start=0;
       int max_end=0;
       int sum=a[0];
       int index=0;
       int maxS=a[0];

       for(int i=1;i<a.length;i++)
       {
       if(sum>0)
       {
           sum=sum+a[i];
       }
       else
       {
           sum=a[i];
           index=i;
       }

       if(maxS<sum)
       {
           maxS=sum;
           max_start=index;
           max_end=i;
       }
       }

//        System.out.println(max_start);
//        System.out.println(max_end);

        for(int k=max_start;k<=max_end;k++)
        {
            System.out.print(a[k] + " ");
        }
    }

}
