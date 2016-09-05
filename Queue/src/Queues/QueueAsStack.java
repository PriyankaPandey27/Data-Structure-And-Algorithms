/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Queues;

/**
 *
 * @author admin
 */
public class QueueAsStack {

public static void main(String args[])
{
    Queue ob=new Queue();
    Queue os=new Queue();
//    Queue stack=new Queue();
//
//    stack.push(4);
//    stack.push(5);
//    stack.push(-2);
//    stack.push(-3);
//    stack.push(11);
//    stack.push(10);
//    stack.push(5);
//    stack.push(6);
//    stack.push(20);
//
//    boolean state=stack.pairwiseOrder(stack);
//    System.out.println("the given stack has successive cnsecutive elements :-" +state);

//    ob.enqueueStack(ob,1);
//    ob.enqueueStack(ob,2);
//    ob.enqueueStack(ob,3);
//    ob.enqueueStack(ob,4);
//    ob.enqueueStack(ob,5);
//    ob.enqueueStack(ob,6);
//    ob.enqueueStack(ob,7);
//    ob.enqueueStack(ob,8);
//    ob.enqueueStack(ob,9);

    ob.enqueue(1);
    ob.enqueue(2);
    ob.enqueue(3);
    ob.enqueue(4);
    ob.enqueue(5);
    ob.enqueue(6);
    ob.enqueue(7);
    ob.enqueue(8);
    ob.enqueue(9);
    ob.enqueue(10);
    ob.enqueue(11);
    ob.enqueue(12);
//    ob.interLeavingQueue(ob, os);
//    ob.display("queue after interleaved");

//    ob.display("\nafter queue one");
   // ob.displayStack("\nafter stack one");
//    os.dequeueStack(ob,os);
//    os.displayStack("\nafter stack two");
    
    ob.reverseQueuekElements(2,ob,ob);
    ob.display("queue after k reverse");
    //os.display(null);
   // ob.reverseQueue();
   // ob.display("after reverse");
//    ob.display("queue from front----------->end");
//    ob.dequeue();
//    ob.dequeue();
//    ob.display("after dequeue");
}

}



class Queue{
    Node start;
    Node front;
    Node rear;
    int len=0;

    public void push(int x)
    {
        if(start==null)
        {
            //System.out.println("stack underflow");
            Node t=new Node(x,start);
            start=t;
           // l++;
        }
        else
        {
            Node temp=new Node(x);
            temp.next=start;
            start=temp;
          //  l++;


        }
    }

    public int size()
    {
        return len;
    }

    public int pop()
    {
        if(start==null)
        {
            return 0;

        }
        else
        {
            Node temp=start;
            start=start.next;
            return temp.data;
        }
    }

    //implementing queue using two stacks
    public void enqueueStack(Queue s1,int p)
    {
        s1.push(p);
    }

    public void dequeueStack(Queue s1,Queue s2)
    {
//        if(start==null)
//        {

        while(s1.start!=null)
            {
                s2.push(s1.pop());
            }
        
           // return pop();
        //}
    }

    // reverse queue first k elements

    public void reverseQueuekElements(int k,Queue q1,Queue s1)
    {
        
        if((q1.rear==null && q1.front==null) || k > q1.size())
        {
            System.out.println("arguments are not proper");
        }
        else
        {
           // System.out.println(k);
            for(int i=0;i<k;i++)
            {
                s1.push(q1.dequeue());
            }
            while(s1.start!=null)
            {
                q1.enqueue(s1.pop());
            }
            int m=q1.size();
            for(int j=0;j< m-k;j++)
            {
               int p=q1.dequeue();
                //System.out.println(p);
                q1.enqueue(p);
            }
        }

    }

    // check each successive pair is consecutive or not in a givn stack

    public boolean pairwiseOrder(Queue s1)
    {
        boolean pairwse=true;
        while(s1.start!=null)
        {
            s1.enqueue(s1.pop());
        }
        while(s1.front!=null && s1.rear!=null)
        {
            s1.push(s1.dequeue());
        }
        while(s1.start!=null)
        {
            int n=s1.pop();
            s1.enqueue(n);
            if(s1.start!=null)
            {
                int m=s1.pop();
                s1.enqueue(m);
                if(Math.abs(n-m)!=1)
                {
                    pairwse=false;
                }

            }

        }
        while(s1.front!=null && s1.rear!=null)
        {
            s1.push(s1.dequeue());
        }
        return pairwse;
    }

    //Rearrange the elements by interleaving first half pf the list with the second half of the list

    public void interLeavingQueue(Queue q1,Queue s2)
    {
        if(q1.size()%2!=0)
        {
            System.out.println("cant interleave the elements as they are odd in number");

        }
        else
        {
            int half=q1.size()/2;
            for (int i=0 ; i<half ;i++)
            {
                q1.push(q1.dequeue());
            }
            while(q1.front!=null && q1.rear!=null)
            {
                s2.push(q1.dequeue());
            }
            while(s2.start!=null)
            {
                q1.enqueue(s2.pop());
                if(q1.start!=null)
                {
                    q1.enqueue(q1.pop());
                }
            }
            while(q1.front!=null && q1.rear!=null)
            {
                s2.push(q1.dequeue());
            }
            while(s2.start!=null)
            {
                q1.enqueue(s2.pop());
            }
        }
    }

    public void enqueue(int p)
    {
        if(front==null && rear==null)
        {
            Node t=new Node(p);
            t.next=t.prev=null;
            front=rear=t;
            len++;
        }
        else
        {
            Node g=new Node(p);
            g.next=rear;
            g.prev=null;
            rear.prev=g;
            rear=g;
            len++;

        }
    }

    public int dequeue()
    {
        if(front==null && rear==null)
        {
            return 0;
        }
        else
        {
            Node tmp=rear;
        if(front==rear)
            {
                front=rear=null;
                return tmp.data;
            }
            else
            {
            Node temp=front;
            front=front.prev;
            front.next=null;
            len--;
            return temp.data;

            }
        }
    }

    public boolean isEmpty()
    {
        if(front==null && rear==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void reverseQueue()
    {
        while(!isEmpty())
        {
            int d=dequeue();
            //System.out.println("deque element"+ d);
            push(d);
        }
        while(start!=null)
        {
            enqueue(pop());
        }

    }

    public void display(String s)
    {
        System.out.println(s);
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp=temp.prev;
        }
    }

    public void displayStack(String s)
    {
        System.out.print(s + " ");
        // System.out.println(s);
        if(start==null)
        {
            System.out.println("empty stack");
        }
        else
        {
        Node temp=start;
       while(temp!=null)
             {
             System.out.print(temp.data + " ");
             temp=temp.next;
             }
        }
    }
}
class Node
{
    int data;
    Node next;
    Node prev;

    public Node(int x)
    {
        this.data=x;
    }

    public Node(int x,Node newNode)
    {
        this.data=x;
        this.next=newNode;
    }

    public Node(int x,Node newNode,Node prevNode)
    {
        this.data=x;
        this.next=newNode;
        this.prev=prevNode;
    }
}