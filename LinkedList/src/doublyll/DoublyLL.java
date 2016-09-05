
package doublyll;


public class DoublyLL {

    public static void main(String[] args) {
          LL obj=new LL();
           obj.insertAtLast(10);
           obj.insertAtLast(20);
           obj.insertAtLast(30);
             obj.insertAtLast(40);
             obj.insertAtLast(50);
             obj.display();
             System.out.println("----------Inserting at desired position-----------");
             obj.insertAtY(44, 3);

          obj.display();
           System.out.println("----------deletion-----------");
            obj.delete(44);
          obj.display();

//          obj.insertAtLast(7);
//          obj.insertAtLast(6);
//          obj.insertAtLast(5);
//          obj.insertAtLast(4);
//          obj.insertAtLast(3);
//          obj.insertAtLast(2);
//          obj.insertAtLast(1);
//          obj.display();
//          System.out.println("after nuilding into BST");
//          Node r=obj.sortedListToBST(obj.getFirst());
//          obj.rInOrder(r);
    }
    
}

 class Node
    {
        int data;
        Node next;    // Next pointer
        Node previous;  // previous pointer
        Node(int x)   
        {
            this.data=x;
        }
        // enjoying the polymorphism
        Node(int x,Node next)
        {
            this.data=x;
            this.next=next;
        }
        
         Node(int x,Node next, Node previous)
        {
            this.data=x;
            this.next=next;
            this.previous=previous;
        }
        
        public int getdata()
        {
            return data;
        }
    }

class LL
{
    Node start;   // Head Node
    
    // declaring the node structure
    
    public Node getFirst()
    {
        return start;
    }
    public void insertAtLast(int x)
    {
        if(start==null)  // List is empty
        {
           start=new Node(x,start,start);   // putting L and R nodes as NULL
        }
        
        else
        {
            Node temp=start;  //temporary Node
            while(temp.next!=null)
            { 
                temp=temp.next;
            }
            temp.next=new Node(x,null,temp);
        }
    }
    
    
     public void insertAtY(int x,int y)  // x=value; y=position
    {
        Node temp=start;
        if(temp==null)  // List is empty
        {
           temp=new Node(x,temp);   
        }
        
        else
        {
            int t=1;
            while(t<y-1)
            {
                temp=temp.next;
                t++;
            }
            
            if(temp.next==null) // the last element
            {
             temp.next=new Node(x,null);
            }
            else
            {
                Node temp2=temp.next;
                temp.next=new Node(x,temp2);
            }
        }
    }
    
       // Java has garbage collector which automatically collects the unrequired data
    public void delete(int x)  //value x is to be deleted
    {        
        Node temp=start;
        Node btemp=start;
                   
        if(temp.getdata()!= x)
        {
        while(temp.getdata()!=x)
        {
            btemp=temp;
            temp=temp.next;
            
        }
        
        btemp.next=temp.next;
        
        
         temp.previous=null;
         temp.next=null;
        }
        
        else
        {
            start=start.next;  // Head node is removed to second element if element to delete is the head node.
        }
    }
    
   
    public void display()
    {
        Node temp=start;
        Node btemp=start;
        if(temp==null)
            System.out.println("Linked List is empty");
        else
        {   do
            {
                
               System.out.print(temp.data + "<-->");
               btemp=temp;
             
               temp=temp.next;
                System.out.println("inside btemp " + btemp.data);
             
            }while((temp)!=null);   
        
        System.out.println("------ Reverse printing------");


        do
        {
             System.out.print(btemp.data + "<--->");


        }while((btemp=btemp.previous)!=null);
//
          }
    }

     public void rInOrder(Node r){

         if(r==null) return;

         rInOrder(r.previous);
         System.out.print(r.data+ " ");
         rInOrder(r.next);
     }

     public Node sortedListToBST(Node head)
     {
         int count=countNode(head);
         Node root=sortedListToBSTRecur(head,count);
         return root;
     }

     public Node sortedListToBSTRecur(Node head,int n)
     {
         if(head==null || n<=0)
             return null;

         Node headleft=sortedListToBSTRecur(head,n/2);
         Node root=new Node(head.data);
         root.previous=headleft;
         if(head.next!=null)
         {
             head.data=head.next.data;
             head.next=head.next.next;
         }
         root.next=sortedListToBSTRecur(head,n-n/2-1);
         return root;
     }

     public int countNode(Node head)
     {
         int c=0;
         Node temp=head;
         while(temp!=null)
         {
             temp=temp.next;
             c++;
         }
         return c;
     }
}


