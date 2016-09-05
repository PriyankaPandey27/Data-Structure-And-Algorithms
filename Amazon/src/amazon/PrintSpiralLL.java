/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class PrintSpiralLL {

    public static void main(String[] args) {

        LinkedList l=new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(6);
        l.insert(7);

       // l.displayNode();
        Node h=l.spiralPrint();
        System.out.println("");
        l.display(h);
    }
}

class LinkedList
{
    Node head;


    public void insert(int x)
    {
        if(head==null)
        {
            head=new Node(x);
            head.next=null;
        }
        else
        {
            Node tmp=head;
            while(tmp.next!=null)
                tmp=tmp.next;
            Node temp=new Node(x);
            tmp.next=temp;
            temp.next=null;

        }
    }

    public Node spiralPrint()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;//o(n)
        }
        Node temp=slow.next;
        slow.next=null;

        display(head);

        Node prev=null;
        while(temp!=null)
        {
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;

        }

        System.out.println("display prev");
        display(prev);

        Node strt=head;
        Node tmp=null;
        while(strt!=null)
        {
            if(prev!=null)
            {
                 tmp=prev;
                Node var=prev.next;
                prev=var;


            }
            else
                return head;
            Node s=strt.next;
            strt.next=tmp;
            tmp.next=s;
            strt=strt.next.next;

        }
        return head;



    }
    
    public void display(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.d + "-->");
            temp=temp.next;
        }
    }
}

class Node
{
    int d;
    Node next;

    public Node(int d)
    {
        this.d=d;
    }
}
