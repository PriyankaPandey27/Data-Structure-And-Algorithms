/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class LLMergeSort {
    
    public static void main(String[] args)
    {
    LinkListSort ll=new LinkListSort();
    ll.insert(10);
    ll.insert(0);
    ll.insert(50);
    ll.insert(-10);
    ll.insert(100);
    ll.insert(50);
    ll.insert(-90);
    ll.insert(555);
    System.out.println("the first linked list is given as ");
    ll.display();


    LinkListSort ll2=new LinkListSort();
     ll2.insert(100);
     ll2.insert(-89);
     ll2.insert(500);
     ll2.insert(-100);
     ll2.insert(66);
     ll2.insert(33);
     ll2.insert(-97);
     ll2.insert(555);
     System.out.println("the second linked list is given as ");
     ll2.display();

        System.out.println("after sorting first linked list ");
        Node h1=ll.mergeSort(ll.getFirst());
        ll.setHead(h1);
        ll.display();

         System.out.println("after sorting first linked list ");
        Node h2=ll2.mergeSort(ll2.getFirst());
        ll2.setHead(h2);
        ll2.display();
//
        LinkListSort ll3=new LinkListSort();
        System.out.println("after merging two linked list");
        Node h3=ll3.mergeRecursive(ll.getFirst(),ll2.getFirst());
        ll3.setHead(h3);
        ll3.display();

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

    public Node mergeSort(Node originalHead)
    {
        if(originalHead==null || originalHead.next ==null)
        {
            return originalHead;
        }
        Node a=originalHead;
        Node b=originalHead.next;
        while(b!=null && b.next!=null)
        {
            b=b.next.next;
            originalHead=originalHead.next;
        }

        b=originalHead.next;
        originalHead.next=null;

        return mergeIterative(mergeSort(a), mergeSort(b));
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
