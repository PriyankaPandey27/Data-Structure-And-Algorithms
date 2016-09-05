/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Queues;

/**
 *
 * @author admin
 */
public class SlidingWindow {
    public static void main(String args[])
    {
        Queue q=new Queue();
        int a[]={1,2,3,1,4,5,2,3,6};
        int n=9;
        int k=3;
        q.maxElementWindow(a, n, k);
    }

}

class Queue{

    Node front;
    Node rear;

    public boolean isEmpty()
    {
        if(front==null)
            return false;
        else
            return true;
    }

    public void renqueue(int x)
    {
        if(front==null && rear ==null)
        {
            Node p=new Node(x);
            front=rear=p;
            p.next=p.prev=null;
        }
        else
        {
            Node t=new Node(x);

            t.next=null;
            t.prev=rear;
            rear.next=t;
            rear=t;

        }
    }

    public void rdequeue()
    {
        if(front==null && rear==null)
        {
            System.out.println("cannot find queue");;
        }
        else
        {

            if(rear==front)
            {
                front=rear=null;
            }
            else
            {

            rear=rear.prev;
            rear.next=null;
            }

        }
    }

    public int rback()
    {
         if(front==null && rear==null)
        {
            return 0;
        }
        else
        {
            Node tmp=front;
            if(rear==front)
            {
                front=rear=null;
                return tmp.data;
            }
            else
            {
             Node temp=rear;
            return temp.data;
            }

        }
    }

    public int rfront()
    {
         if(front==null && rear==null)
        {
            return 0;
        }
        else
        {
            Node tmp=rear;
            if(rear==front)
            {
                front=rear=null;
                return tmp.data;
            }
            else
            {
             Node temp=front;
            return temp.data;
            }

        }
    }


    public void fdequeue()
    {
        if(front==null && rear==null)
        {
            System.out.println("cannot find queue");
        }
        else
        {
            if(rear==front)
            {
                front=rear=null;
            }
            else
            {
            front=front.next;
            front.prev=null;
            }

        }
    }

    public void maxElementWindow(int[] arr,int n,int k)
    {
        int i;
        for(i=0;i<k;++i)
        {
            while(!isEmpty() && arr[i]>=arr[rback()])
            {
                rdequeue();
            }

            renqueue(i);
        }

//        for(;i<n;++i)
//        {
//            System.out.println(arr[rfront()]);
//            while(!isEmpty() && rfront()<=i-k)
//                fdequeue();
//
//            while(!isEmpty() && arr[i]>=arr[rback()])
//                rdequeue();
//
//            renqueue(i);
//
//        }
        System.out.println(arr[rfront()]);
    }

}

class Node{

    int data;
    Node next;
    Node prev;

    public Node(int x)
    {
        this.data=x;
    }

//    public Node(int x,Node n,Node p)
//    {
//        this.data=x;
//        this.next=n;
//        this.prev=p;
//    }
}
