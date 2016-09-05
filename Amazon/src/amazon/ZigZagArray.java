/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class ZigZagArray {

    public static void main(String[] args) {

        int a[]={4, 3, 7, 8, 6, 2, 1};
        zigZag(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i] + " ");

    }

    public static void zigZag(int a[])
    {
        boolean flag=true;

        for(int i=0;i<a.length-2;i++)
        {
            if(flag)
            {
                if(a[i]>a[i+1])
                    swap(a, i, i+1);
            }
            else
            {
                if(a[i]<a[i+1])
                    swap(a, i, i+1);
            }
            flag=!flag;

        }
    }

    public static void swap(int a[],int i,int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}
