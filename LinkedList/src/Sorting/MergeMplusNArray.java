/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class MergeMplusNArray {

    public static void moveToEnd(int mn[],int size)
    {
        int j=size-1;

        for(int i= size-1;i>=0;i--)
        {
            if(mn[i]!=-100)
            {
                mn[j]=mn[i];
                j--;
            }

        }
    }

    public static void printOut(int mn[],String S)
    {
        System.out.println(S);
        for(int i=0;i<mn.length;i++)
        {
            System.out.print(mn[i] + " ");
        }
        System.out.println();

    }

    public static void merge(int mn[],int n[],int m,int b)
    {
        int i=b,j=0,k=0;
        while(b < m+b && k< m+b)
        {
           if((i < m+b) && mn[i]<n[j] || j==b)
           {
               mn[k]=mn[i];
               k++;
               i++;
           }
           else
           {
               mn[k]=n[j];
               k++;
               j++;
           }
        }

    }

    public static void main(String[] args)
    {
        int mn[]={2, 8, -100, -100, -100, 13, -100, 15, 20};
        int n[]={5, 7, 9, 25};
        printOut(mn," first array list");
        printOut(n,"Second array list");
        moveToEnd(mn,mn.length);
        int l=mn.length-n.length;
        merge(mn,n,l,n.length);
        printOut(mn,"after merging ");

    }

}
