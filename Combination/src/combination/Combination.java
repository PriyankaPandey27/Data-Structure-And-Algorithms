/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package combination;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Combination {

    public static void main(String[] args) {
        int t[]={1,2,3};
       char p[]={'A','B','C','D'};
        int b[]=new int[4];
        findCombination(b, 0, b.length-1,p,3);
    }

    public static void findCombination(int a[],int k,int n,char b[],int c)
    {
         if(k>n)
            return;
        if(k==n)
        {
            a[k]=0;

            printCombk(b,a,n,c);
            a[k]=1;
            printCombk(b,a,n,c);
            
//
        }
        a[k]=0;
        findCombination(a, k+1, n,b,c) ;
        a[k]=1;
        findCombination(a, k+1, n,b,c);


    }

    public static void printComb(char b[],int a[],int n)
    {
        int s=0;
        boolean flag=false;
        for(int i=1;i<=n;i++)
        {

             if(a[i]==1 && a[i-1]==1)
                 return;

            // System.out.print(a[i-1] + " ");
        }

        System.out.println(Arrays.toString(a));
        System.out.println("");

//        for(int i=0;i<=n;i++)
//        {
//            //System.out.print("a " + a[i]+ " ");
//            if(a[i]==1)
//            {
//                System.out.print(b[i] + " " );
//                s++;
//            }
//
//        }
//        System.out.println("");
//
//        if(s==0)
//        {
//            System.out.println("null set");
//        }
    }

    public static void printCombk(char b[],int a[],int n,int k)
    {
        int s=0;int count=0;
        //boolean flag=false;
         for(int i=0;i<=n;i++)
        {
            //System.out.print("a " + a[i]+ " ");
            if(a[i]==1)
            {
                count++;
            }

        }
        if(count==k)
        {
            for(int i=0;i<=n;i++)
            {
                if(a[i]==1)
                System.out.print(b[i]+ " ");
            }
        }
        System.out.println("");
//        if(s==0)
//        {
//            System.out.println("null set");
//        }

    }


}
