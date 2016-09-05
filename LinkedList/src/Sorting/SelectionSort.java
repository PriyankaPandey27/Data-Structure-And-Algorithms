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
public class SelectionSort {


    public static void main(String args[])
    {
        int a[]={10,40,-10,50,200,-1000, -3,-19};
        System.out.println("before sorting " +  Arrays.toString(a));
        selectionSort(a);
        System.out.println("after sorting " + Arrays.toString(a));
    }


    public static void selectionSort(int a[])
    {
        int i,j,min=0,temp;
        for(i=0;i<=a.length-1;i++)
        {
            min=i;
            for(j=i+1;j<a.length;j++)
            {
                if(a[j]<a[min])
                {
                    min=j;
                }
            }

            temp=a[min];
            a[min]=a[i];
            a[i]=temp;
        }
    }
}
