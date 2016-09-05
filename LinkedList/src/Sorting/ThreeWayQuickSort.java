/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class ThreeWayQuickSort {
    
    public static void main(String[] args) {
        
        int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        printArray(a);
        quicksort(a, 0, a.length-1);
        printArray(a);
        
    }
    
    public static void printArray(int b[])
    {
        for(int i=0;i<b.length;i++)
        {
            System.out.print(b[i] + " ");
        }
    }
    
    public static void swap(int a,int b)
    {
        int t=a;
        a=b;
        b=t;
    }

   public static void partition(int a[], int l, int r)
{
   int i = l-1;
    int j = r;
    int p = l-1, q = r;
    int v = a[r];

    while (true)
    {
        // From left, find the first element greater than
        // or equal to v. This loop will definitely terminate
        // as v is last element
        while (a[++i] < v)
//        {
//            i++;
//        }

        // From right, find the first element smaller than or
        // equal to v
        while (v < a[--j])
//        {
//            j--;
//        }
            if (j == l)
                break;

        // If i and j cross, then we are don
        if (i >= j) break;

        // Swap, so that smaller goes on left greater goes on right
        swap(a[i], a[j]);

        // Move all same left occurrence of pivot to beginning of
        // array and keep count using p
        if (a[i] == v)
        {
            p++;
            //System.out.println("i ;;; "+i);
            swap(a[p], a[i]);
        }

        // Move all same right occurrence of pivot to end of array
        // and keep count using q
        if (a[j] == v)
        {
            q--;
            swap(a[j], a[q]);
        }
    }

    // Move pivot element to its correct index
    swap(a[i], a[r]);

    // Move all left same occurrences from beginning
    // to adjacent to arr[i]
    j = i-1;
    for (int k = l; k < p; k++, j--)
        swap(a[k], a[j]);

    // Move all right same occurrences from end
    // to adjacent to arr[i]
    i = i+1;
    for (int k = r-1; k > q; k--)
    {
        swap(a[i], a[k]);
        i++;
    }
}

// 3-way partition based quick sort
public static void quicksort(int a[], int l, int r)
{
    if (r <= l) return;

    int i=0, j=0;

    // Note that i and j are passed as reference
    partition(a, l, r);

    // Recur
    quicksort(a, l, j);
    quicksort(a, i, r);
}



}
