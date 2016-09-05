/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Queues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {

    public static void main(String[] args) {

        int arr[] ={8, 5, 10, 17, 9, 4, 15, 12, 90, 13};
          int k = 3;
         System.out.println(Arrays.toString(arr));

          printMaxInWindow(arr,k);
    }

    public static void printMaxInWindow(int a[],int k)
    {
        Deque<Integer> q=new LinkedList();
        //int temp[]=new int[k];
        int N=a.length;
       // q.addLast(a[0]);
        int i;

        for(i=0;i<k;i++)
        {
            while(!q.isEmpty() && a[i]>=a[q.getLast()])
                q.removeLast();

            q.addLast(i);
        }

        for(;i<N;i++)
        {
            System.out.println(a[q.getFirst()]);

            while(!q.isEmpty() && a[i]>=a[q.getLast()])
                q.removeLast();

            while(!q.isEmpty() && q.getFirst()<=i-k)
                q.removeFirst();

            q.addLast(i);
        }

        System.out.println(a[q.getFirst()]);

//        
    }
}
