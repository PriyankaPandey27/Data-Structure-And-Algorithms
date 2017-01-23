/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Searching;

/**
 *
 * @author admin
 */
public class SmallerGreaterElement {
    public static void main(String[] args) {

    int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
    int n = arr.length;
        System.out.println("element is " + arr[findElement(arr, n)]);

    }

    public static int findElement(int a[],int n)
    {
        int left[]=new int[n];
        left[0]=Integer.MIN_VALUE;
        
        for(int i=1;i<n;i++)
        {
            left[i]=Math.max(left[i-1], a[i-1]);
        }

        int right=Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--)
        {
            if(left[i]<a[i] && right>a[i])
                return i;

            right=Math.min(right, a[i]);
        }
        return -1;
    }

}
