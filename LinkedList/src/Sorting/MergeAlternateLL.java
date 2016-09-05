/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sorting;

/**
 *
 * @author admin
 */
public class MergeAlternateLL {

    public static void main(String[] args) {

        LinkedList ll=new LinkedList();
        ll.insert(10);
        ll.insert(40);
        ll.insert(53);
        ll.insert(30);
        ll.insert(67);
        ll.insert(12);
        ll.insert(89);

        ll.display(ll.head);
        
        ll.alternateLL();
        ll.display(ll.head);

    }


}

class LinkedList
{
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
    
    public void  display(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + "--> ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void alternateLL()
    {
        Node a=head;
        Node b=head.next;
        Node temp=b;
        while(a!=null && a.next!=null && b!=null && b.next!=null)
        {
            a.next=b.next;
            a=a.next;
            b.next=a.next;
            b=b.next;
        }
       a=head;
       b=temp;

       b=reverse(b);
       
       head=mergeRecursive(a, b);




    }


    public Node reverse(Node h)
    {
        if(h==null)
            return null;
        if(h.next==null)
            return h;
        Node cur=h;
        Node prev=null;
        while(cur!=null)
        {
            Node next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

        }
        return prev;
    }

    public Node mergeRecursive(Node a,Node b)
    {
        if(a==null)
            return b;
        if(b==null)
            return a;

        Node result;
        if(a.data<b.data)
        {
            result=a;
            result.next=mergeRecursive(a.next,b);
        }
        else
        {
            result=b;
            result.next=mergeRecursive(a, b.next);
        }
        return result;
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
