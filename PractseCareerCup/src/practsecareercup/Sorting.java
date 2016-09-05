/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practsecareercup;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       // int a[]={2,7,11,10,5};
       // int s=0;
       // mergeSort(a, 0, a.length-1);
       // int cost=minimumCostRope(a);
        //System.out.println("minimum cost is " + cost);
        // TODO code application logic here

        Integer p[]={1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println("the length is " + longestConsecutive(Arrays.asList(p)));

//       
    }

    	public static int longestConsecutive(final List<Integer> a) {
            if(a.size()==1)
            {
                return 1;
            }



            Integer input[]=a.toArray(new Integer[a.size()]);
           // Integer output[]=a.toArray(new Integer[a.size()]);
           // int max=Integer.MIN_VALUE;
//            for(int i=0;i<input.length;i++)
//            {
//                if(input[i]>max)
//                {
//                    max=input[i];
//                }
//            }
            mergeSort(input, 0, input.length-1);
           // countingSort(output, input, max+1);
            Integer res[]=a.toArray(new Integer[a.size()]);
            for(int i=0;i<res.length;i++)
            {
                res[i]=1;
            }
            int temp=Integer.MIN_VALUE;
            for(int i=0;i<input.length-1;i++)
            {
                if(input[i+1]-input[i]==1)
                {
                    res[i+1]=res[i]+res[i+1];


                }
                 else if(input[i]==input[i+1])
                    {
                        res[i+1]=res[i];
                    }
                
                if(res[i+1]>temp)
                    {
                        temp=res[i+1];
                    }

            }

            return temp;



	}

    public static void countingSort(Integer output[],Integer input[],int range)
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
        
    public static void mergeSort(Integer a[],int l,int h)
    {
        if(l<h)
        {
            int m=(l+h)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,h);
            merge(a,l,m,h);
        }

    }

    public static void merge(Integer a[],int low,int mid,int high)
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

    
    public static int minimumCostRope(int a[])
    {
        int c=1;
        int n=a.length;
        int sum=0;int cost=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+a[i];
            if(i>=1 && i<=n)
            {
                a[c]=sum;
                cost=cost+a[c];
                c++;
            }

        }
        return cost;
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


        //iterative merge sort

    }

    public static void mergeSortIterative(int a[],int n)
    {
        int cur_size;
        int left_start;
        for(cur_size=1;cur_size<n-1;cur_size=2*cur_size)
        {
            for(left_start=0;left_start<n-1;left_start+=2*cur_size)
            {
                int mid=left_start+cur_size-1;
                int right_end=Math.min(left_start+2*cur_size-1,n-1);
                merge(a,left_start,mid,right_end);
            }
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


    


}
