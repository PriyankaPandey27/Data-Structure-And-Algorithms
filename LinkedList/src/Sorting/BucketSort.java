/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class BucketSort {

    public static void sort(int a[],int max)
    {
        int buck[]=new int[max+1];

        for(int i=0;i<buck.length;i++)
            buck[i]=0;

        for(int j=0;j<a.length;j++)
            buck[a[j]]++;

        print(buck,buck.length,"Bucket");
        int post=0;

        for(int i=0;i<buck.length;i++)
        {
            for(int j=0;j<buck[i];j++)
            {
                a[post++]=i;
            }
        }


    }


    public static void main(String[] args)
    {
        int max=3;
        int a[]={1,0,1,2,3,1,0,3,1,0,1,3};
        print(a,a.length,"input array is given as");
        sort(a,max);
        print(a,a.length,"sorted input array");
    }

    public static void print(int a[],int len,String s)
    {
        System.out.println(s);
        for(int i=0;i<len;i++)
        {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

}
