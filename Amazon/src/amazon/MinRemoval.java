/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class MinRemoval {


    public static void main(String[] args) {

        int a[]={20, 4, 1, 3};
        //System.out.println(minRemoval(a, 0, a.length-1));
        System.out.println(minRemovalSorting(a));
        

    }

    public static int minElement(int a[],int l,int h)
    {
        int min=a[l];
        for(int i=l+1;i<=h;i++)
            if(min>a[i])
                min=a[i];

        return min;
    }

    public static int maxElement(int a[],int l,int h)
    {
        int max=a[l];
        for(int i=l+1;i<=h;i++)
        {
            if(max<a[i])
                max=a[i];
        }

        return max;
    }

    public static int minRemoval(int a[],int l,int h)
    {
        if(a==null||a.length==0)
            return -1;

        if(l>=h)
            return 0;

        int min=minElement(a,l,h);
        int max=maxElement(a,l,h);

        if(2*min>max)
            return 0;

        return Math.min(minRemoval(a, l+1, h), minRemoval(a, l, h-1))+1;

    }


    // another method using sorting

    public static void merge(int a[],int l,int h)
    {
        if(l<h)
        {
            int m=l+(h-l)/2;
            merge(a, l, m);
            merge(a, m+1, h);
            mergeSort(a,l,m,h);

        }
    }

    public static void mergeSort(int a[],int l,int m,int h)
    
    {   int low=l;
        int temp[]=new int[a.length];
        int mid=m+1;
        int index=l;

        while(low<=m && mid<=h)
        {
            if(a[low]<a[mid])
            {
                temp[index]=a[low];
                low++;
            }
            else
            {
                temp[index]=a[mid];
                mid++;
            }
            index++;
        }
        if(low<=m)
        {
            for(int i=low;i<=m;i++)
            {
                temp[index]=a[i];
                index++;
            }

        }
        else
        {
            for(int i=mid;i<=h;i++)
            {
                temp[index]=a[i];
                index++;
            }
        }

        for(int i=l;i<=h;i++)
        a[i]=temp[i];


    }


    public static int minRemovalSorting(int a[])
    {
        if(a==null || a.length==0)
            return -1;
        int counter=0;
        merge(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
        int i=0;
        int j=a.length-1;
        while(i<j)
        {
           // System.out.println("inside while");
            if(2*a[j-1]>a[j])
            {
                if(2*a[i]<=a[j])
                {
                    counter+=1;
                    i++;
                }
                else
                    return counter;
            }
            else
            {
              //  System.out.println("inside else");
                counter+=1;
                j--;
            }

        }

        return -1;

    }

}
