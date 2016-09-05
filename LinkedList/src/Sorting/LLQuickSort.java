/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class LLQuickSort {


      public static void main(String[] args)
    {
    LinkListSort ll=new LinkListSort();
    ll.insert(10);
    ll.insert(0);
    ll.insert(50);
    ll.insert(6);
    ll.insert(11);
    ll.insert(9);
    ll.insert(15);
    ll.insert(7);
    System.out.println("the first linked list is given as ");
    ll.display();

    ll.quickSort(ll.getFirst());
        System.out.println("after quick sort of the linked list");
        ll.display();

    }

}




class LinkListSort{
    Node head;

    public void insert(int x)
    {
        if(head==null)
        {
            head=new Node();
            head.setData(x);
            head.setNext(null);
        }
        else
        {
            Node temp=head;
            Node before=head;
            while(temp!=null)
            {
                before=temp;
                temp=temp.next;
            }
            before.next=new Node();
            before.next.setData(x);
            before.next.setNext(temp);
        }
    }

    public void  display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public Node getTail(Node head)
    {
        Node temp=head;
        while(temp!=null && temp.next!=null)
        {
            temp=temp.next;
        }
        return temp;
    }

    public void quickSort(Node head)
    {
        head=quickSortRecur(head,getTail(head));
       return;
    }

    public Node quickSortRecur(Node h,Node end)
    {
        if(h==null || h==end)
            return h;

        Node newHead=null,newEnd=null;
        Node pivot=partition(h,end,newHead,newEnd);
        System.out.println("partion value " + pivot.data);
        System.out.println("new head " + newHead.data);
        System.out.println("new end " + newEnd.data);
        if(h!=pivot)
        {
            Node tmp=h;
            while(tmp.next!=pivot)
            {
                tmp=tmp.next;
            }
            tmp.next=null;

            newHead=quickSortRecur(h,tmp);
            tmp=getTail(newHead);
            tmp.next=pivot;
        }

        pivot.next=quickSortRecur(pivot.next,newEnd);
        return newHead;
    }

    public Node partition(Node head,Node end,Node newHead,Node newEnd)
    {
        Node pivot=end,prev=null,curr=head,tail=pivot;

        while(curr!=pivot)
        {
            if(curr.data<pivot.data)
            {
                if(newHead==null)
                    newHead=curr;

                prev=curr;
                curr=curr.next;
            }
            else
            {
                if(prev!=null)
                {
                    prev.next=curr.next;
                }

                    Node tmp=curr.next;
                    curr.next=null;
                    tail.next=curr;
                    tail=curr;
                    curr=tmp;
            }
        }


        if(newHead==null)
            newHead=pivot;

        newEnd=tail;
        System.out.println("new head " + newHead.data);
        System.out.println("new end " + newEnd.data);
        return pivot;
    }

    public Node mergeIterative(Node a,Node b)
    {
        Node start=new Node();
        Node c=start;
        while(a!=null && b!=null)
        {
            if(a.data<=b.data)
            {
            c.next=a;
            c=a;
            a=a.next;
            }
            else
            {
                c.next=b;
                c=b;
                b=b.next;
            }

        }

       c.next=(a==null)?b:a;
       return start.next;
    }

    public Node mergeRecursive(Node a,Node b)
    {
        if(a==null)
            return b;

        if(b==null)
            return a;

        Node result;

        if(a.data<=b.data)
        {
            result=a;
            result.setNext(mergeRecursive(a.next,b));
        }
        else
        {
            result=b;
            result.setNext(mergeRecursive(a,b.next));
        }
        return result;
    }



    public void setHead(Node a)
    {
        head=a;
    }

    public Node getFirst()
    {
        return head;
    }


}

class  Node{
    int data;
    Node next;
    public void setData(int x)
    {
        this.data=x;
    }
    public void setNext(Node n)
    {
         next=n;
    }

    public int getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }
}

