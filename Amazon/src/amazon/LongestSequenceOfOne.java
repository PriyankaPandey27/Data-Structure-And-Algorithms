/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class LongestSequenceOfOne {

    public static void main(String[] args) {

        int a[]={1,1,0,0,1,0,1,1,1,0,1,1,1};
        System.out.println("the index to be replaced by 1 is  " + longestContinuousSequence(a));

    }

    public static int longestContinuousSequence(int a[])
    {
        if(a==null || a.length==0)
            return -1;
        int n=a.length;

        int prev_zero=-1;
        int prev_prev_zero=-1;
        int max_count=0;
        int max_index=0;

        for(int i=0;i<n;i++)
        {
            if(a[i]==0)
            {
                if(i-prev_prev_zero>max_count)
                {
                    max_count=i-prev_prev_zero;
                    max_index=prev_zero;
                }

                prev_prev_zero=prev_zero;
                prev_zero=i;
            }
        }

        if(n-prev_prev_zero>max_count)
            max_index=prev_zero;

        return max_index;
    }

}
