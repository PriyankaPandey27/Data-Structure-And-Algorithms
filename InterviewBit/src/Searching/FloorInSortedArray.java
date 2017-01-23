/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Searching;

/**
 *
 * @author admin
 */
public class FloorInSortedArray {

    public static void main(String[] args) {

    int arr[] = {1, 2, 4, 6, 10, 12, 14};
    int n = arr.length;
    int x = 11;
    int index = floorSearch(arr, 0, n-1, x);
    if(index==-1)
    {
        System.out.println("floor doesnt exist");
    }
    else
    {
        System.out.println("floor exist at " +arr[index]);
    }

    }

    public static int floorSearch(int a[],int l,int h,int x)
    {
        if(l>h)
            return -1;
        if(x>a[h])
            return a[h];
        int m=l+(h-l)/2;

        if(a[m]==x)
            return m;
        if(m>0 && a[m-1]<=x && x<a[m])
            return m-1;

        if(x<a[m])
            return floorSearch(a, l, m-1, x);

        return floorSearch(a, m+1, h, x);

    }


}

