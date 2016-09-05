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
public class bubbleSort {
    
    public static void main(String args[])
    {
        int a[]={-1,20,12,2,4,14,3,1,0,-2,2,3};
        System.out.println("before sorting " + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("after sorting " + Arrays.toString(a));
    }

    public static void bubbleSort(int a[])
    {
        int pass;
        



        for(pass=a.length-1;pass>=0;pass--)
        {
            for(int i=1;i<=pass;i++)
            {
                if(a[i-1]>a[i])
                {
                    int temp=a[i-1];
                    a[i-1]=a[i];
                    a[i]=temp;
                }
            }
        }
    }

    public static void bubbleSortImp(int a[])
    {
         int pass;
         boolean swap=true;
        for(pass=a.length-1;pass>=0;pass--)
        {
            if(swap)
            {
                swap=false;
             for(int i=0;i<=pass-1;i++)
             {
                if(a[i]>a[i+1])
                {
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    swap=true;
                }
              }
            }
        }

    }

}
