/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practse;
//import java.io.*;
//import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MissingAP {

    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 16, 21, 31};
        int n=arr.length;
        System.out.println(n);
        System.out.println("the missing number is " + missingUtil(arr,n));
        


    }


    public static int missingUtil(int a[],int n)
    {
        int diff=(a[n-1]-a[0])/n;
        int p=findMissing(a,0,n-1,diff);
        System.out.println("element inside util " + p);
        return p;
    }

    public static int findMissing(int a[],int low,int high,int d)
    {
        if(high<=low)
            return Integer.MAX_VALUE;

        int mid=low+(high-low)/2;
        if((a[mid+1]-a[mid])!=d)
        {
           System.out.println("element 1 " +(a[mid]+d));
            return(a[mid+1]+d);
        }

        else if(mid>0 && a[mid]-a[mid-1]!=d)
        {
           System.out.println("element 2" +(a[mid-1]+d));
            return (a[mid-1]+d);
        }

        else if(a[mid]==a[0]+mid*d && low<=high)
        {
            System.out.println("element 3" +findMissing(a,mid+1,high,d));
            return findMissing(a,mid+1,high,d);
        }
        return findMissing(a,low,mid-1,d);
        

    }

}
