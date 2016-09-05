/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practsecareercup;

/**
 *
 * @author admin
 */
public class LinkedListPractse {

    public static void main(String[] args) {

        LinkedList l=new LinkedList();
        l.insert('A');
        l.insert('B');
        l.insert('C');
        l.insert('B');
        l.insert('A');

        l.palindromeNode();


    }

}

class LinkedList{

    private Node head;

      public void insert(char x)
    {
        if(head==null)
        {
           head=new Node(x,null);
            //head=n;
        }
        else
        {
            Node temp=head;

//            for( temp = null ; temp.next!= null ; temp=temp.next)
//            {
//
//            }
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node(x,null);
        }

           // System.out.println(head);
    }
    public void palindromeNode()
    {
        Node slow=head;
        Node fast=head;
        Node slowMid=head;
        Node midNode;
        Node temp;

        Node prev=null;
        Node nexts;
        if(head!=null && head.next!=null)
        {
            while(fast!=null && fast.next!=null)
            {
                fast=fast.next.next;
                slowMid=slow;
                slow=slow.next;

            }
             if(fast!=null)
                {
                    midNode=slow;
                    slow=slow.next;
                }
            slowMid.next=null;
            temp=slow;
            while(temp!=null)
            {
                nexts=temp.next;
                temp.next=prev;
                prev=temp;
                temp=nexts;

            }

            Node start=head;
            Node start2=prev;
            Node head2=prev;
            while(start2!=null && (start.data==start2.data))
            {
                start2=start2.next;
                start=start.next;
            }
            if(start2!=null)
            {
                System.out.println("not palindrome");
            }
            else
            {
                System.out.println("palindrome");
            }
            Node curr=head2;
            Node tmp=null;
            //Node nxt;

            while(curr!=null)
            {
                nexts=curr.next;
                curr.next=tmp;
                tmp=curr;
                curr=nexts;
            }
            slowMid.next=tmp;


        }
    }

}

class Node
{
    char data;
    Node next;
    public Node(char v,Node next)
    {
        this.data=v;
        this.next=next;
    }
}
