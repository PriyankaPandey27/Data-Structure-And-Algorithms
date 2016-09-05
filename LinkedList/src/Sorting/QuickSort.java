/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

import java.util.Random;

/**
 *
 * @author admin
 */
public class QuickSort {
    
    public static void main(String args[])
    {
        int a[]={5,5,6,6,6 ,1,1,2,2,2,3,4};
        System.out.println("before sorting "+ a.length);
        for(int i=0;i<a.length;i++)
        System.out.print( a[i] + " ");
        quickSort(a,0,a.length-1);
        System.out.println("after sorting");
        for(int j=0;j<a.length;j++)
        System.out.print( a[j] + " ");
        
    }


    public static void quickSort(int a[],int l,int h)
    {
//        
        if(a==null||a.length==0)
            return;

      //  System.out.println(" l = " + l + " h = " + h );
        int pivot=h;
        int pivotValue=a[pivot];
        int i=l,j=h;
        while(i<=j)
        {
            //System.out.println("i= " + i + "  j = " + j );
            while(a[i]<pivotValue)
            {
                i++;
            }

            while(a[j]>pivotValue)
            {
                j--;
            }

            if(i<j)
            {
                int t=a[j];
                a[j]=a[i];
                a[i]=t;
                i++;
                j--;
            }
            else if(i==j)
            {
                i++;
                j--;
            }
        }

        if(l<j)
        {
            quickSort(a,l,j);
        }

        if(i<h)
        {
            quickSort(a,i,h);
        }
    }

}
