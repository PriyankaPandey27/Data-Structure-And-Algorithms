/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class MergeSort {

    public static void main(String args[])
    {
       // int a[]={14,-1, 32, 67, 76, 23, 41, 58, 85,-1,14,12,12,12,12,14,13,32};
        int a[]={4, 5, 100, 9, 10, 11, 12, 15, 200};
        System.out.println("before sorting :::" + Arrays.toString(a));
        mergeSort(a,0,a.length-1);
        //mergeSortIterativeInPlace(a);
        System.out.println("after sorting :::" + Arrays.toString(a));
        

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
    
    static void mergeSortIterativeInPlace(int arr[])
{
   int curr_size;  // For current size of subarrays to be merged
                   // curr_size varies from 1 to n/2
   int left_start; // For picking starting index of left subarray
                   // to be merged
 int n=arr.length;
   // Merge subarrays in bottom up manner.  First merge subarrays of
   // size 1 to create sorted subarrays of size 2, then merge subarrays
   // of size 2 to create sorted subarrays of size 4, and so on.
   for (curr_size=1; curr_size<=n-1; curr_size = 2*curr_size)
   {
       // Pick starting point of different subarrays of current size
       for (left_start=0; left_start<n-1; left_start += 2*curr_size)
       {
           // Find ending point of left subarray. mid+1 is starting
           // point of right
           int mid = left_start + curr_size - 1;

           int right_end = Math.min(left_start + 2*curr_size - 1, n-1);

           // Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end]
           mergeInPlace(arr, left_start, mid, right_end);
       }
   }
}


static void mergeInPlace(int arr[], int l, int m, int r)
{

        int i, j, k;
	int n1 = m - l + 1;
	int n2 = r - m;

        if( n1<0 || n2 <0)
            return;


      //  System.out.println(n1 + " :: " + n2);
	/* create temp arrays */
	int L[] = new int[n1];
        int R[] = new int[n2];


	/* Copy data to temp arrays L[] and R[] */
	for (i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (j = 0; j < n2; j++)
		R[j] = arr[m + 1+ j];

	/* Merge the temp arrays back into arr[l..r]*/
	i = 0;
	j = 0;
	k = l;
	while (i < n1 && j < n2)
	{
		if (L[i] <= R[j])
		{
			arr[k] = L[i];
			i++;
		}
		else
		{
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	/* Copy the remaining elements of L[], if there are any */
	while (i < n1)
	{
		arr[k] = L[i];
		i++;
		k++;
	}

	/* Copy the remaining elements of R[], if there are any */
	while (j < n2)
	{
		arr[k] = R[j];
		j++;
		k++;
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
