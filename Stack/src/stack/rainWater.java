/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author admin
 */
public class rainWater {

    public static void main(String[] args) {

        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        findWater(arr);

    }

    public static void findWater(int a[])
    {
        if(a==null || a.length==0)
            return;

        int left[]=new int[a.length];
        int right[]=new int[a.length];

        left[0]=a[0];
        for(int i=1;i<a.length;i++)
        {
            left[i]=Math.max(left[i-1], a[i]);
        }

        right[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1], a[i]);
        }

        int water=0;
        for(int i=0;i<a.length;i++)
        {
            water+=(Math.min(left[i], right[i])-a[i]);
        }

        System.out.println("the maximum water stored is " + water);
    }

}
