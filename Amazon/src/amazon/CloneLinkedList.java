/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.HashMap;

/**
 *
 * @author admin
 */
 class CloneLinkedList {

    public static void main(String[] args) {

        LinkedLists list = new LinkedLists();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
            list.head.next.next.next;
        list.head.next.next.random =
            list.head.next.next.next.next;
        list.head.next.next.next.random =
            list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
            list.head.next;
        
        printLL(list.head);
        
        System.out.println("after cloning data " );

        printLL(cloneLL(list.head));


    }

    public static Node cloneLL(Node head)
    {
        HashMap<Node,Node> h=new HashMap<Node,Node>();
        Node x=head;
        Node y=null;
        while(x!=null)
        {
            y = new Node(x.data);
            y.next=null;
            y.random=null;
            h.put(x, y);
            x=x.next;
        }

        x=head;
        while(x!=null)
        {
            y=h.get(x);
            y.next=h.get(x.next);
            y.random=h.get(x.random);
            x=x.next;
        }

        return h.get(head);

    }

    public static void printLL(Node h)
    {
        Node temp=h;
        while(temp!=null)
        {
            int r=-1;
            if(temp.random!=null)
            r=temp.random.data;
            System.out.println(temp.data +" " + r);
            temp=temp.next;
        }
    }



}
 
 class LinkedLists{
     
     Node head;
     
     
     
     public void push(int x)
     {
         if(head ==null)
         {
             head=new Node(x);
             head.next=null;
             
         }
         else
         {
             Node temp=new Node(x);
             temp.next=head;
             head=temp;
         }
     }
 }

class Node
{
    int data;
    Node next;
    Node random;

    public Node(int data) {
        this.data = data;
    }

}
