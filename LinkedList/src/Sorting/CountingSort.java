/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class CountingSort {

    public static int min=Integer.MAX_VALUE;
    public static int max=Integer.MIN_VALUE;
    
    public static void main(String args[])
    {
//        int a[]={1,7,3,6,3,9,9,9,9,9,1,1,1,1,5,5,5,50,2,2,2,2,4,4,4,4,7,7,7,34,5,27,12,77,23,78,65,34,71,45};
//          int b[]=new int[a.length];
//        int k=100;
//        printOut(a,a.length,"before sorting");
//        countingSort(b,a,k);
//        printOut(b,b.length,"After sorting ");
//        maxNumber(b);

        int p[]={-500,-3,-1,-2,-3000,-2};
        int b[]=new int[p.length];
        printOut(p, p.length, "before sorting");
        countingSortNegative(p, b);
        printOut(b, b.length, "after sorting");

//        int a[]={1,1,1,2,2,3,4,4,4,4,5,5};
//        findMaxNumber(a);

        
    }

    public static void findMaxNumber(int a[])
    {
        int max=Integer.MIN_VALUE;
        int number=0;
        int counter=1;
        int j=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[j]==a[i])
            {
                counter++;

            }
            else
            {
                if(counter>max)
                {
                    max=counter;
                    number=a[j];
                }
                counter=1;

            }
            j=i;

        }
        System.out.println(" Number is  " + number);
    }

    public static void printOut(int a[],int r,String s)
    {
        System.out.println(s);
        for(int i=0;i<r;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void countingSort(int output[],int input[],int range)
    {
       int n=input.length;
       int freq[]=new int[range];
       for(int i=0;i<range;i++)
       {
           freq[i]=0;
       }

       for(int j=0;j<n;j++)
       {
           freq[input[j]]=freq[input[j]]+1;
       }

       for(int k=1;k<range;k++)
       {
           freq[k]=freq[k]+freq[k-1];
       }

       for(int i=0;i<n;i++)
       {
           output[--freq[input[i]]]=input[i];
       }

    }

    public static void maxNumber(int output[])
    {
        int a=output.length;
        int number=0;
        int c=0;
        int max=0;
        for(int i=0;i<a;i++)
        {
            number=output[i];
            c=0;
            for(int j=i+1;j<a;j++)
            {
                if(output[i]==output[j])
                {
                    c++;
                }
            }

            if(c>max)
            {
                max=c;
                number=output[i];
            }
        }
        System.out.println("Number is " + number +"count is " + c);
    }


    // counting sort for negative array

    public static void countingSortNegative(int a[],int b[])
    {
        findMinMax(a);
        int n=max-min+1;
        int freq[]=new int[n];
        for(int i=0; i<a.length; i++)
            freq[a[i]-min]++;
        for(int i=1; i<freq.length; i++)
           freq[i]=freq[i]+freq [i-1];
          for(int i=0;i<a.length; i++)
          {
             b[--freq[a[i]-min]] = a[i];
          }
    }

    public static void findMinMax(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<min)
                min=a[i];

            max=Math.max(a[i], Math.max(min, max));

        }

        System.out.println("min number " + min);
        System.out.println("max number " + max);
    }

}
