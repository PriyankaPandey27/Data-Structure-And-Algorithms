/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class zSort {

   public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		int n = br.nextInt();
		int[] nums = new int[n];
		for(int i = 0;i<n;i++){
			nums[i] = br.nextInt();
		}

                int res[]=new int[n];

		mergeSort(nums, 0, n-1);

		int left = 0;
		int right = n-1;
		for(int i = 0;i<n;i++){
			if(i%2 == 0){

                                res[i]=nums[left];
                                left++;
			}
			else{
                               //swap(nums, left, right);

                                res[i]=nums[right];
                                right--;
//                                left++;
                            
			}
		}

                for(int i=0;i<n;i++)
                {
                    System.out.print(res[i] + " ");
                }
		System.out.println();
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
//1 9 1 8 2 7 3 7 4 6
