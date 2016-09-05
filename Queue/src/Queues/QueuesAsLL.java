/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Queues;

/**
 *
 * @author admin
 */
public class QueuesAsLL {
    
    public static void main(String args[])
    {

    Queues ob=new Queues();
    ob.enqueue(1);
    ob.enqueue(2);
    ob.enqueue(3);
    ob.enqueue(4);
    ob.enqueue(5);
    ob.enqueue(6);
   
    ob.display();
    ob.dequeue();
    ob.dequeue();
//    ob.enqueue(7);
//    ob.dequeue();
//    ob.dequeue();
//    ob.dequeue();
//    ob.dequeue();
//    ob.dequeue();
//    ob.dequeue();
     ob.display();
    }

}


class Queues{
    int length;
    Node front;
    Node rear;
    int f=0;
    public Boolean isEmpty()
    {
        if(front==null)
            return true;
        else
            return false;
    }

    public void enqueue(int a)
    {
        if(front==null && rear==null)
        {
            Node t=new Node(a);
            front=rear=t;
            t.next=t.prev=null;
        }
        else
        {
//             if(f==0)
//            {
//                front.prev=rear;
//            }
            Node p=new Node(a);
            p.prev=rear;
            p.next=null;
            rear.next=p;
            rear=p;
            //length++;

           
           // System.out.println("elements are"+ rear);
        }

    }

    public void dequeue()
    {
        if(front==null && rear==null)
        {
            System.out.println("queue is underflow");
        }
        else
        {
            if(front==rear)
            {
                front=rear=null;
            }
            else
            {
            front=front.next;
            front.prev=null;
          // System.out.println("front element is" +front.data);
            }
        }

    }

    public void display()
    {
        System.out.println("\nfront---------->back");
        if(front==null && rear==null)
        {
            System.out.println("queue underflow");
        }
        else
        {
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        }
    }

}

class Node
{
    int data;
    Node prev;
    Node next;

    public Node(int data)
    {
        this.data=data;
    }

    public Node(int a,Node newnext)
    {
        this.data=a;
        this.next=newnext;
    }

    public Node(int a,Node next,Node prev)
    {
        this.data=a;
        this.next=next;
        this.prev=prev;
    }

}
