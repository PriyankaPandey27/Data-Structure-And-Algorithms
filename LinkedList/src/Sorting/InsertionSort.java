/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class InsertionSort {
    
    
    public static void main(String args[])
    {
        int a[]={10,20,7,2,8,1,0};
        System.out.println("before sorting " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("after sorting " + Arrays.toString(a));
    }

    public static void insertionSort(int a[])
    {
        if(a.length==0||a.length==1)
            return;

        for(int i=1;i<a.length;i++)
        {
            int key=a[i];
            int j=i-1;

            while(j>=0 && a[j]>key)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }

}
