

package practse;
//import java.util.Arrays;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




/**
 *
 * @author admin
 */
public class Practise {

    public static void main(String args[]) throws IOException
    {
//        int a[]={10,40,-10,50,200,-1000, 0, 30};
//        System.out.println("before sorting :::" + Arrays.toString(a));
//        mergeSort(a,0,a.length-1);
//        System.out.println("after sorting :::" + Arrays.toString(a));
        //int b[]={8, 12, 16, 4, 0, 20};
        int p[]={1,2,3,4,5,6,7,8,9,10};
       // sum(b,5);
        //sub(b,4);
       // int n=8;
       // countCell(n,8);

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedOutputStream bos = new BufferedOutputStream(System.out);
       String input[]= br.readLine().split(" ");
       int n=Integer.parseInt(input[0]);
       int k=Integer.parseInt(input[1]);
       countCell(n, k);

    }

    public static void sum(int b[],int k)
    {
        mergeSort(b,0,b.length-1);
        int i=0,j=b.length-1;
        while(i<=j)
        {
           if(b[i]+b[j]>k)
          {
            j--;
          }
           else if(b[i]+b[j]<k)
           {
               i++;
           }
           else if(b[i]+b[j]==k)
           {
               System.out.println("the pair are " +b[i] + " and " + b[j]);
              i++;
              j--;// break;

           }
        }

    }

     public static void sub(int b[],int k)
    {
        mergeSort(b,0,b.length-1);
        int i=0,j=b.length-1;
        while(i<=j && i<b.length && j<b.length)
        {
           if(b[j]-b[i]>k)
          {
            j--;
          }
           else if(b[j]-b[i]<k)
           {
              // j++;
               System.out.println("not possible");
               break;
           }
           else if(b[j]-b[i]==k)
           {
               System.out.println("the pair are " +b[i] + " and " + b[j]);
             i++;
             j++;// break;

           }
        }

    }

    public static void mergeSort(int a[],int l,int h)
    {
        if(l<h)
        {
            int m=(l+h)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,h);
            merge(a,l,m,h);
        }
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

    public static void countCell(int n,int k) throws IOException
    {
        int c=0;
        for(int x=1;x<=n;x++)
        {

            int y = k / x;

            if(y <= n && x* y == k){
                c++;
            }
        }
        BufferedWriter bos= new BufferedWriter(new OutputStreamWriter(System.out));
        bos.write(c +"\n");
        bos.flush();
    }


}
