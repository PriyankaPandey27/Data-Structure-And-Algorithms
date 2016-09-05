/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrankTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author admin
 */
public class SellTicket {

    public static void main(String[] args) throws IOException {

        //System.out.println(ticketToSell(4, 2, 5));
        BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
            String line = input.readLine();
            String[] splitLine = line.split(" ");
            int n= Integer.parseInt(splitLine[0].trim());
            int m= Integer.parseInt(splitLine[1]);

            int tickets[] = new int[n];

         line = input.readLine();
         splitLine = line.split(" ");
         int sum=0;
         for(int i=0;i<splitLine.length;i++)
         {
             tickets[i]= Integer.parseInt(splitLine[i]);
             sum+=tickets[i];
         }
        System.out.println(ticketToSell(n, m, tickets, sum));

    }

    public static int ticketToSell(int n,int m,int input[],int len)
    {

        if(n<0||m<0||n==0||m==0||input==null||input.length==1)
            return -1;

        int sum=0;int index=0;
//        int ticket[]=new int[len];
//        for(int i=0;i<input.length;i++)
//        {
//            for(int j=1;j<=input[i];j++)
//            {
//                ticket[index++]=j;
//            }
//        }

        
//       mergeSort(input, 0, input.length-1);
       for(int i=1;i<=m;i++)
       {
           if(input[input.length-2]<=input[input.length-1])
           {
               sum+=input[input.length-1];
               input[input.length-1]--;
           }
           else
           {
            quickSort(input, 0, input.length-1);
            sum+=input[input.length-1];
               input[input.length-1]--;
           }

       }

        return sum;


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

      public static void mergeSort(int a[],int l,int h)
    {
        if(l<h)
        {
            int m=l+(h-l)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,h);
            merge(a,l,m,h);
        }


        //iterative merge sort

    }

    public static void merge(int a[],int low,int mid,int high)
    {
        int l=low;
        int mid1=mid+1;
        int temp[]=new int[a.length];
        int indx=low;

        while((l<=mid) && (mid1<=high))
        {
            if(a[l]<a[mid1])
            {
                temp[indx]=a[l];
                l++;
            }
            else
            {
                temp[indx]=a[mid1];
                mid1++;
            }
            indx++;
        }

        if(l<=mid)
        {
            for(int i=l;i<=mid;i++)
            {
                temp[indx]=a[i];
                indx++;
            }

        }
        else
        {
            for(int j=mid1;j<=high;j++)
            {
                temp[indx]=a[j];
                indx++;
            }
        }

        for(int i=low;i<=high;i++)
        {
            a[i]=temp[i];
        }

    }


}
