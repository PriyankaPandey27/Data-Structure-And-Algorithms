/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practse;

/**
 *
 * @author admin
 */
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {

    public static void main(String[] args) {

        int arr[] ={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
          int k = 3;
         System.out.println(Arrays.toString(arr));

          printMaxInWindow(arr,k);
    }

    public static void printMaxInWindow(int a[],int k)
    {
        Deque<Integer> q=new LinkedList();
        int temp[]=new int[k];
        int N=a.length;
        q.addLast(a[0]);

        int i;
        for(i=1;i<k;i++)
        {
            if(q.getLast()<a[i] )
            {
                q.clear();
                q.addLast(a[i]);
            }
            else  // incoming elment less than last element
            {
                if(q.getFirst()>a[i])
                {
                    //System.out.println("size = "+q.size());
                    if(q.size()==k)
                    {
                        q.removeLast();
                        q.addFirst(a[i]);
                    }
                    else
                    {
                       q.addFirst(a[i]);
                    }
                }
                else
                {
                    q.removeFirst();
                    q.addFirst(a[i]);
                }
            }

        }
      // System.out.println(q.size());
        System.out.println(q.getLast());

        for(;i<N;i++)
        {
            //System.out.println("element = "+a[i]);
            if(q.getLast()<a[i])
            {
                q.clear();
                q.addLast(a[i]);

               // System.out.println("If "+q.getLast());
            }
            else  // incoming elment less than last element
            {
                if(q.getFirst()>a[i])
                {

                    if(q.size()==k)
                    {

                        q.removeLast();
                        q.addFirst(a[i]);
                    }
                    else
                    {
                       q.addFirst(a[i]);
                    }
                }
                else
                {
                    int j=0;

                    //System.out.println("Check ");
                   while(true)
                   {
                       int e=q.removeFirst();

                       if(e<a[i])
                       {
                           temp[j]=e;
                           j++;
                       }
                       else
                       {
                           q.addFirst(e);
                           break;
                       }
                   }

                    q.addFirst(a[i]);
                    j--;

                    while(j>=0)
                    {
                        q.addFirst(temp[j]);

                        if(q.size()==k)
                        {
                            q.removeLast();
                        }

                        j--;
                    }

                }
           // System.out.println(q.getLast());
            }
           // System.out.println("Size = "+q.size());
             System.out.println(q.getLast());

        }

    }
}
