/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package circularll;

//import Circularll2222.*;


/**
 *
 * @author admin
 */
public class CircularLL2 {

    public static void main(String[] args)
    {
        LL ob=new LL();
        ob.insertLast(1);
        ob.insertLast(2);
        ob.insertLast(3);
        ob.insertLast(4);
        ob.insertLast(5);
        ob.insertLast(6);
        ob.insertLast(7);
        ob.insertLast(8);
        //ob.insertLast(9);
        ob.display();
      // ob.josephus(8,4);
        ob.splitCircular();
       // ob.insertLast(10);
       // ob.display();
    }

}
class Node{
    public int x;
    public Node next;

    public Node(int x,Node next)
    {
        this.x=x;
        this.next=next;
    }

    public void setnext(Node newnext)
    {
        next=newnext;
    }

    public int getdata()
    {
        return x;
    }
}

class LL{

    Node start;

    public void display()
    {
        Node temp=start;
        if (temp==null)
        {
            System.out.println("Linked list is empty");
        }do
        {
            System.out.println(temp.x);
            temp=temp.next;
        }


        while(temp!=start);
//            Node temp=start;
//        int x= 1;
//
//        if (temp==null)
//        {
//            System.out.println("Linked list is empty");
//        }
//        while(temp!=start || x ==1)
//        {
//             System.out.println(temp.x);
//            temp=temp.next;
//            x=0;
//        }
    }

    public void insertLast(int x)
    {

        if(start==null)
        {
            Node t=new Node(x,start);
            start=t;
            start.setnext(t);

        }

        else
        {
             Node temp=start;
             while(temp.next!=start)
             {
                 temp=temp.next;

             }
             Node t=new Node(x,start);
             temp.setnext(t);
            // System.out.println(temp.x);


        }


    }

    public void splitCircular()
    {
        Node fst=start;
        Node slow=start;
        Node head1=start;
        Node head2=null;
        while(fst.next!=start && fst.next.next!=start)
        {
            fst=fst.next.next;
            slow=slow.next;
        }

       // System.out.println(slow.x);

        if(fst.next.next==start)
        {
            fst=fst.next;
        }
        head2=slow.next;
        slow.setnext(start);
        System.out.println("first circular list");
        do{
            System.out.println(head1.x);
             head1=head1.next;
        }
        while(head1!=start);
        

        
        Node temp=head2;
        fst.setnext(temp);
        System.out.println("second circular list");
        do{
            System.out.println(temp.x);
            temp=temp.next;
        }
        while(temp!=head2);
    }

 public void josephus(int n,int m)
 {
     int l=1;
     Node p=start;
     while(p.next!=start)
     {
         l=l+1;
         p=p.next;
         
     }
     System.out.println(l);
     System.out.println(p.getdata());
     if(n>l || n<0)
     {
         System.out.println("Linked list cannot be found");
     }
     else if(n==l)
     {
         Node q=null;
         for(int c=n;c>0;c--)
         {
             for(int i=0;i<m;i++)
             {
                 q=p;
                 p=p.next;
             }
             System.out.println("insde outer for loop"+ p.getdata());
             q.setnext(p.next);
         }
         System.out.println(p.getdata());
     }
 }


}
