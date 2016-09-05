
package linkedlistown;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LinkedListOwn {

    public static void main(String[] args) {
       // Node t1=new Node(50,null);
        Node t2=new Node(11,null);
        LinkedList ll3=new LinkedList();
        LinkedList ll4=new LinkedList();
        LinkedList ll5=new LinkedList();


//        ll3.insert(1);
//        ll3.insert(4);
//        ll3.insert(3);
//         ll3.insert(2);
//          ll3.insert(5);
//          ll3.insert(2);
//          ll3.display("above is the given number");
      
         // ll3.display(null);
//          ll3.insert(3);
//          ll3.insert(5);
//          ll3.insert(6);
//          ll3.insert(8);
//          ll3.insert(9);
//           ll3.insert(10);
//           ll3.insert(11);
//           ll3.display("linked list");
//           ll3.reverseK(-1);
//           System.out.println("");

//           ll4.insert(1);
//        ll4.insert(15);
//        ll4.insert(19);
//        ll4.insert(22);
//        ll4.insert(-1);
//        ll4.insert(25);
//        ll4.insert(28);
//        ll4.insert(29);
          // ll3.loopUsingMap();
             //ll3.palindromeNode();
//        ll3.insert(5);
//        ll3.insert(7);
//        ll3.insert(9);
//        ll3.insert(10);
//        ll3.insert(11);
       // ll3.Duplicate();
        //ll3.partition_k(15);
       // ll3.insert(22);
       // ll3.insert(23);
        //ll3.display("Before alternate deletion");
         //ll3.rotate(2);
          //---------------- **** Revising all the code****-----------------
           //Node r=new Node(4,null);
         //ll3.display("first linked list");
         //ll3.insertAtbeginnig(2);
        // ll3.display("inserying at beginning");
         //ll3.insertNode(r);
//         ll3.display("after deletion");
//         System.out.println();
//         ll3.middleElement();
        // ll3.NthElementRecursive(4);
         //System.out.println();
        // ll3.insertInSortedLinkdList(r);
//         ll3.display("after insertion");
//         System.out.println();
//         ll4.display("second linked list");
//         System.out.println();
//         ll3.display("after partition");
//         System.out.println();
//         ll3.printLLfromEnd(ll3.head);   ll3.Duplicate();
//         ll3.display("after partition");
//         System.out.println();
//         ll3.printLLfromEnd(ll3.head);
//          Node temp=ll5.recursiveMergeSort(ll3.head,ll4.head);
//         while(temp!=null)
//         {
//             System.out.print(temp.data + "-->");
//             temp=temp.next;
//         }

         //-----------------------------------------------------------------

//        ll4.insert(1);
//        ll4.insert(5);
//        ll4.insert(19);
//        ll4.insert(22);
//        ll4.insert(-1);
//        ll4.insert(25);
//        ll4.insert(28);
//        ll4.insert(29);
       // ll4.display("second linked list");
//        System.out.println("******");
      // ll5.mergeTwoSortedList(null, ll4.head);
//        Node n=ll5.recursiveMergeSort(ll3.head, ll4.head);
      //ll5.displayNode(n);
        //ll5.display("third linked list");
       // ll3.elementBfreHead(12);
       // ll3.evenOddList();
        //ll3.endRecursive();
       // ll3.NthElementRecursive(10);
     //   ll4.iterativeReverseK(-1);
       //  ll4.display("After 2 reveres");
         System.out.println("");
//        ll3.deleteAlternateNode(3,2);
//        ll3.display("After alternate deletion");
       // ll3.display();
//        ll3.display();
      //  ll3.reverse();
      // ll3.display("After reversing....");
       // ll3.insertInSortedLinkdList(t2);
      //3.display();
        
//        LinkedList ll=new LinkedList();
//        ll.insert(10);
//      ll.insert(20);
//     ll.insert(25);
//        ll.insert(50);
//       // ll.createNode(60, null);
//       ll.connectll(ll3);
       
      // ll3.display();
      
     //  ll.middleElement2();
       // ll.printLLfromEnd(ll.head);
//      System.out.println("--------After deleting------");
//        ll.delete(10);
      //  ll.display("display node");
        
       //  System.out.println("--------After reversing------");
       //  ll.reverse_3_pointer();
       // ll.reverse_try_2();
          
      //   ll.display();

//    System.out.println("--------After reversing in pair------");
     // ll.reverse_k(3);
//
//         ll.display();
//
       // ll.nthNodeFromEnd(7);
       // ll.insertCycle(60);
      //  ll.cycleDetection();
       // ll.cycleStartingPoint();
     // ll.lengthofCycle();
      
        LinkedList ll2=new LinkedList();
        ll2.insert(5);
        ll2.insert(8);
        ll2.insert(15);
        ll2.insert(20);
        ll2.insert(25);
        ll2.insert(50);
//        ll2.insert(50);
//        ll2.insert(25);
//        ll2.insert(20);
//        ll2.insert(65);
         //ll2.connectll(ll3);
//         ll2.insertNode(t1);
 //       ll2.insertNode(t2);
      //  System.out.println("LinkedList 2.....");
         ll2.display("node of second linked list");
        ll2.deleteAltNode();
        ll2.display("node of second linked list");
//     
       // ll.merge2ll(ll,ll2);
       // ll2.palindrome(ll2);
       // ll2.display();
       // ll3.intersectingNode(ll,ll2);
    //    ll3.intersectingNode2(ll, ll2);
    }
}


class LinkedList
{
    public Node head;
    
        // means inserting at the end
    public void insert(int x)
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

    // recursive insert - we have to do it latter
//    public Node recursionInsert(Node x)
//    {
//        if (x.next==null)
//        {
//            System.out.println(x.data);
//            return x;
//        }
//        else
//        {
//            if(head == null)
//            {
//                head=x;
//                x=new Node(x.data-1,null);
//                recursionInsert(x);
//            }
//            else
//            {
//                if(x.data==1)
//                {
//                    x.next=null;
//                    recursionInsert(x);
//                }
//                else
//                {
//                x=new Node(x.data-1,null);
//                Node p=recursionInsert(x);
//                System.out.println(p.next.data);
//                return (p.next.data);
//                }
//            }
//        }
//
//    }

    public void insertAtbeginnig(int x)
    {
          if(head==null)
          {
              head=new Node(x,null);
          }
          else
          {
              Node temp=new Node(x,null);
              temp.next=head;
              head=temp;
//              while(temp.next!=null)
//              {
//                  temp=temp.next;
//              }

          }


    }

    public void insertInSortedLinkdList(Node x)
    {
        Node temp=null;

        if(head==null)
        {
           head=x;
        }
        else
        {
            Node current=head;
            while(current!=null && current.data < x.data)
            {
            temp=current;
            current=current.next;
            }
            x.setNext(current);
            temp.setNext(x);
            
        }
    }

    public void deleteAltNode()
    {
        if(head==null && head.next==null)
            return;

        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow.next=fast;
            slow=slow.next;
            
            
            
        }


    }

    public void deleteAlternateNode(int m,int n)
    {
        if(m==0)
        {
            System.out.println("Enter valid value for m");
            return;
        }
        if(head==null)
        {
            System.out.println("Cant find linked list");
            return;
        }
        else
        {
                 Node curr=head;
                 Node prev;
                 while(curr!=null)
                 {
                     int k=m;
                     int l=n;
                 while(curr!=null && k>=1)
                 {
                     curr=curr.next;
                     k--;
                     if(curr==null)
                         return;
                 }
                 prev=curr;
                 while(curr!=null && l>=1)
                 {
                     curr=curr.next;
                     l--;
                     if(curr==null)
                     {
                         prev.next=null;
                         return;
                     }
                 }
                 curr=curr.next;
                 prev.next=curr;
                 
                 }
                 
        
        }
    }

    public void reverse()
    {
        head=reverseUtil(head);
    }
    public Node reverseUtil(Node head)
    {
        Node prev=null;
        Node current=head;
        while(current!=null)
        {
            Node next=current.next;
            current.setNext(prev);
            prev=current;
            current=next;
        }
        return prev;
        // System.out.println(prev.data);
        
        
    }

    public void loopUsingMap()
    {
        Node temp=head;
        int flag=0;
        Map<Node,Node> hash=new HashMap<Node,Node>();
        while(temp!=null)
        {
            if(hash.get(temp)==null)
            {
            hash.put(temp, temp);
            }
            else
            {
                System.out.println("loop exist");
                flag=1;
                break;
            }
            temp=temp.next;
        }

        if(flag==0)
        {
            System.out.println("loop does not exist");
        }
    }

    public void cycleDetectionLoop()
    {
        Node slow=head;
        Node fast=head;
        Node temp=null;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            if(fast!=null)
            {
            temp=fast;
            }
            slow=slow.next;
        }
        temp.next=slow;
    }
    public void middleElement()
    {
        if(head==null)
          {

          }
          else
          {
            Node Fst= head;
            Node Slow=head;
            while(Fst!=null && Fst.next!=null)
            {
                Fst=Fst.next.next;
                Slow=Slow.next;
            }
            System.out.println(Slow.data);
          }

    }

     public void NthElementFromEnd(int x)
    {

            Node nthNode=null;
            Node temp=head;
            Node tmp=head;
            int l=0;
            while(temp!=null)
            {
                temp=temp.next;
                l++;

            }
            if(x>l || x<0)
            {
                System.out.println("cannot find the node");
            }
            else
            {
            for(int c=1;c<x;c++)
            {
                
                if(tmp!=null)
                {
                    tmp=tmp.next;
                }
                
            }
            //System.out.println(temp.data);
            
            while(tmp!=null)
            {
                if(nthNode==null)
                {
                    nthNode=head;
                }
                else
                {
                    nthNode=nthNode.next;
                }
                tmp=tmp.next;
            }

            if(nthNode!=null)
            {
            System.out.println(" nth Node :: "+ nthNode.data);
            }
            }
            
        
        
    }

    public void insertAfterHead(int x)
    {
        if(head==null)
          {
              head=new Node(x,null);
          }
          else
          {
            Node temp=new Node(x,null);
            temp.next=head.next;
            head.next=temp;
          }
    }

    public void NthElementRecursive(int x)
    {
        int c=0;
        //System.out.println("head :: "+ head.data);
       // Node temp=head;
        //recur(head, x);
         c=recursiveNth(head, x,c);
      
    }
     public void endRecursive()
    {

         recursiveDisplay(head);

    }
    public void insertCycle(int x)
    {
         if(head==null)
        {
           head=new Node(x,null);
            //head=n;            
        }        
        else
        {
            Node temp=head;
            
            while(temp.next!=null)
            {                
                temp=temp.next;
            }
            temp.next=new Node(x,head.next);
        }
    }
    
    // Insert the particular Node
    public void insertNode(Node t)
    {
        if(t==null) return;
        Node start=head;
        while(start.next!=null)
        {
            start=start.next;
        }
        start.next=new Node(t.data,null);
    }
  
    public void connectll(LinkedList l4)
    {
       Node start=head;
       
       while(start.next!=null)
           start=start.next;
       
       start.next=l4.head;
       
    }
    
  public void printLLfromEnd(Node h)
    {
       // Node temp=head;
        if(h!=null){
            this.printLLfromEnd(h.next);
            System.out.println(h.data);
          }
        //else
          //  System.out.println(h.data);
        return;
    }
    
    public void middleElement2()
    {
         Node a=head;
        Node b=head;
        
        while((b!=null) && (b.next!=null))
        {
            a=a.next;
            b=b.next.next;
        }

        System.out.println("Middle element = "+a.data);
    } 
            
    public void merge2ll(LinkedList l1,LinkedList l2)
    {
        if(l1==null && l2==null) {
            return;
        }
        
        LinkedList result=new LinkedList();
        Node h3=null;
        int flag=0;
        
        Node h1=l1.head,h2=l2.head;
        
     //   System.out.println("Value = "+h2.data);
        while(true)
        {
            while(h1!=null && h2!=null && h1.data<=h2.data)
            {
                if(result.head==null)
                {
                    // create the head
                    result.head=new Node(h1.data,null);
                    h3=result.head;
                }
                else
                {
                    h3.next=new Node(h1.data,null);
                    h3=h3.next;
                }
                h1=h1.next;
           
            }
            
            while(h2!=null && h1!=null && h1.data>h2.data)
            {
                if(result.head==null)
                {
                    // create the head
                   result.head=new Node(h2.data,null);
                   h3=result.head;
                }
                else
                {                    
                    h3.next=new Node(h2.data,null);
                    h3=h3.next;
                }
                h2=h2.next;
                
           // System.out.println("Check 2");
            }
            
            if(h1==null){
                flag=1;
                break;
            }
            else if(h2==null)
            {
                flag=2;
                break;
            }
                     
        }
       
        if(flag==1){
            while(h2!=null){
                  h3.next=new Node(h2.data,null);
                  h2=h2.next;
                  h3=h3.next;
            }
        }
        else if(flag==2){
            while(h1!=null){
                  h3.next=new Node(h1.data,null);
                  h1=h1.next;
                  h3=h3.next;
            }
        }
        
        Node temp=result.head;
        System.out.println("Merged List");
        
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void palindrome(LinkedList l)
    {
        if(l.head==null)    // || l.head.next==null){
        {
            System.out.println("Empty LinkedList");
            return;
        }
        if(l.head!=null && l.head.next==null)
        {
            System.out.println("Palindrome");
            return;
        }
        // finding the even and odd list length
       int even=0;
        Node slow=l.head,fast=l.head;
        while(true)
        {
            if(fast.next!=null)
                fast=fast.next;
            else
            {
                even=0;
                System.out.println("Odd length");
               
                break;
            }
            
             if(fast.next!=null)
                fast=fast.next;
            else
            {
               System.out.println("Even length");
                even=1;
                break;
            }
             
             slow=slow.next;
            
        }
        // now reversing the second half of the list
        // Node start=slow.next;
             if(slow.next==null)
                return;
        
        Node start=slow.next,nextNode,temp=null;
       
        while(start!=null)
        {
            nextNode=start.next;
            start.next=temp;
            temp=start;
            start=nextNode;
        }
        start=temp;
        Node head2=temp;
       
        Node startfirst=head;
        // chekcing first half with reversed second half
       
        
        while(start!=null && startfirst.data==start.data)
        {            
          //  System.out.println("List 1:"+startfirst.data);
          //  System.out.println("List 2:"+start.data);
                                
            start=start.next;
            startfirst=startfirst.next;
          
        }
        
        if(start!=null)
            System.out.println("NOT palindrome");
        else
            System.out.println("Palindrome");
            
       // attaching the second half
         if(slow.next==null)
                return;
        
        Node start2=head2;
        Node temp2=null;
        //nextNode,temp=null;
       
        while(start2!=null)
        {
            nextNode=start2.next;
            start2.next=temp2;
            temp2=start2;
            start2=nextNode;
        }
        
        slow.next=temp2;
        
      //  System.out.println("Temp="+temp2.data);        
    }
    
 /*   public void evenOddLength()
    {
        Node slow=head,fast=head;
        while(true)
        {
            slow=slow.next;
            
            fast=fast.next;
            
            if(fast.next!=null)
                fast=fast.next;
            else
            {
                System.out.println("Even length");
                break;
            }
        }
    }
   */ 
    public void intersectingNode(LinkedList l1,LinkedList l2)
    {
        if(l1==null || l2==null) {
            System.out.println("No intersecting node");
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
      //  Stack<Node> s1=new Stack<>();
       // Stack<Node> s2=new Stack<>();
        
        // putting all nodes in LnikedList 1
        Node t1=l1.head;
        
        while(t1.next!=null)
        {
            s1.push(t1);
            t1=t1.next;
        }
        s1.push(t1);
        System.out.println("Size = "+s1.size());
        l2.reverse_3_pointer();
        
        Node t=l2.head;
         Node p=s1.pop();
         Node temp=null;
        while(true)
        {                   
            if(t==p) {
                 temp=t;                
                 p=s1.pop();
                 t=t.next;
            }
            else if(t==null || p==null)
                break;
            else
            {
                System.out.println("Intersecting node = "+temp.data);
               return;
            }    
            
        }
        
        System.out.println("No interseting Node");
    }
    
    public void intersectingNode2(LinkedList l1,LinkedList l2)
    {
        if(l1==null || l2==null) return;
        
        int len1=0,len2=0,diff=0;
        
        Node h1=l1.head;
        Node h2=l2.head;
        
        
        while(h1!=null)
        {
            len1++;
            h1=h1.next;
        }
           while(h2!=null)
        {
            len2++;
            h2=h2.next;
        }
         if(len1>len2)
         {
             diff=len1-len2;
             h1=l1.head;
             
             for(int i=1;i<=diff;i++)
             {
                 h1=h1.next;
             }
             h2=l2.head;
             
         }
         else
         {
             System.out.println("inside else");
             diff=len2-len1;
                h2=l2.head;
             for(int i=1;i<=diff;i++)
             {
                 h2=h2.next;
             } 
             h1=l1.head;
         }
         
         while(h1!=h2)
         {
             h1=h1.next;
             h2=h2.next;
         }
         System.out.println("Intersecting Node = "+h1.data);
    }
    // deleting the node
    public void delete(int x)
    {
        if(head.data==x)
            head=head.next;
        else
        {
            Node temp=head;
            Node prevTemp=null;
        while(temp.data !=x)
        {
            prevTemp=temp;
            temp=temp.next;
        }
        prevTemp.next=temp.next;
        }
        
    }
  
    
    // i think it is 3 pointer strategy
    public void reverse_3_pointer()
    {
        if(head==null || head.next==null)
            return;
        
        Node prev=null;
        Node current=head;
        Node next;
        
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        
    }
   
    //Source: http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
    public void reverse_try_2()
    {
        if(head==null || head.next==null)
            return;
        
        int i=0,flag=-1;
        Node node=head,nextnode=node.next,nextNextNode;
        
        while(true)
        {            
            if(i==0)
            {
               i++;
                node.next=null;
            }
            
                if(nextnode.next==null)
                {
                    nextNextNode=null;
                    flag=1;
                }
                else
                {
                     nextNextNode=nextnode.next;
                }
               
                nextnode.next=node;
                node=nextnode;
                nextnode=nextNextNode;
                
                if(flag==1)
                    break;
            
        }
        head=node;
            
    }
   
    
     public void reverse_k(int k)
    {
        head=reverse_size_k(head,k);
    }
    
    public Node reverse_size_k(Node head,int k)
    {
        if(head==null || head.next==null || k<=1)
            return head;
        
        Node current=head,next=null,prev=null;
        int count=0;
        
        // reverse first k nodes of the linked list
        while(current!=null && count<k)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        
        if(next!=null)
        {
            head.next=reverse_size_k(next,k);
        }
        
        return prev;
    }
   
    public void nthNodeFromEnd(int n)
    {
        if(n<=0) return;
       
        int i;
        Node slow=head,fast=head;
        
        for(i=1;i<=n;i++)
        {
            fast=fast.next;
            
            if(fast==null)
            {System.out.println("Parameter out of LinkedList length");
                return;
            }
        }
        
        
        // travsering each node at a time of slow and fast
        while(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        
        System.out.println(n+"th Node from the end = "+slow.data);
    }
  
    public void cycleDetection()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1) System.out.println("Cycle detected");
        else     System.out.println("Cycle NOT detected"); 
            
    }
    
     public void cycleStartingPoint()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1)
        {
            System.out.println("Cycle detected");
            slow=head;
            while(true)
            {
                if(slow==fast)
                {
                    System.out.println("Starting point of cycle="+slow.data);
                    break;
                }
                slow=slow.next;
                fast=fast.next;
            }
            
        }
        else     System.out.println("Cycle NOT detected"); 
            
    }
    
    public void lengthofCycle()
    {
        Node slow=head,fast=head;
        int cycle=0;
        
        while(true)
        {
            fast=fast.next;
   
            fast=fast.next;
            slow=slow.next;
            
            if(fast==null || slow==null)
             break;
            
            if(fast==slow)
            {     
                cycle=1;
                break;
            }
        }
        
        if(cycle==1)
        {
            int length=0;
          //  System.out.println("Cycle detected");
            slow=head;
            while(true)
            {
                if(slow==fast)
                {
            //        System.out.println("Starting point of cycle="+slow.data);
                   // System.out.println("Length of cycle="+length*2);
                    break;
                }
                slow=slow.next;
                fast=fast.next;
                //length++;
            }
            
            // length of cycle
            while(true)
            {
               fast=fast.next;
               if(fast==slow)
               {
                 length++;
                 System.out.println("Length of cycle="+length);  
                 break;
               }
               else
               {
                  // fast=fast.next;
                   length++;
               }
            }
            
        }
        else     
            System.out.println("Cycle NOT detected"); 
            
    }
    
     
    public void display(String s)
    {
        System.out.println(s);
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + "-->");
            temp=temp.next;
        }
    }
    
       public void displayNode(Node s)
    {
        
        Node temp=s;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

       public void displayfromEnd(Node head)
       {
           if(head==null)
               return;
           
           displayfromEnd(head.next);
           //head=head.next;
           System.out.print(head.data+ "-->");
           
       }




    public Node recur(Node head , int n)
    {
        if(head == null) // means reached end of LL
        {
            System.out.println("Inside if :: head is null");
            if( n ==0)
            {
                System.out.println(head);
                return head;
            }
            else
            {
                n--;
                return head;
            }
        }
        else
        {
            System.out.println(" inside else :: "+ head.data);
            return recur(head.next, n);
        }
    }
    public int recursiveNth(Node head,int n,int c)
    {
        if (head==null)
        {
            return 0;
        }
            // count= count+1;
           
           c= recursiveNth(head.next,n,c);
           c=c+1;
//              System.out.println("after recursn head :: "+ head.next.data);
//           System.out.println(c);
             
            if(c==n)
            {
                
                System.out.println(head.data);
              return 11;
               // System.out.println(c);
                //return head.data;

            }
          else
              return c;
             
          
             
        }

//    public Node recursiveEnd(Node head)
//    {
//        if(head==null)
//        {
//
//        }
//        recursiveEnd(head.next);
//            System.out.println(head.data);
//    }
//        System.out.println("head :: "+head.data + " n = "+n);
//        int count=0;
//        if(head!=null)
//        {
//            recursiveNth(head.next,n);
//            count++;
//            if(count==n)
//            {
//                System.out.println(head.data);
//                return head;
//            }
//        }
//        return null;

   
    // recursive version of display
    public Node recursiveDisplay(Node h)
    {
        if(h == null)
        {
           // 
            return h;
        }
       // System.out.println(h.data);
        recursiveDisplay(h.next);
        System.out.println(h.data);
        return h;
    }

    public void evenOddList()
    {

        Node temp=head;
        while(temp!=null && temp.next!=null)
        {
            temp=temp.next.next;
            
        }
        if(temp!=null)
        {
            System.out.println("odd list");
        }
        else
        {
            System.out.println("even list");
        }


//        int l=0;
//        Node temp=head;
//        while(temp!=null)
//        {
//            temp =temp.next;
//            l=l+1;
//
//        }
//        if (l%2==0)
//        {
//            System.out.println("even list");
//        }
//        else
//        {
//            System.out.println("odd list");
//        }
    }


    public void elementBfreHead(int n)
    {
        if(n<=0)
        {
            System.out.println("Cant find linked list");
        }
        else
        {
        int l=0;
        Node temp=head;
        while(temp!=null)
        {
            l++;
            if(l==n)
            {
                break;
            }
            System.out.println(temp.data);
            temp=temp.next;

        }
        }
    }

    public void mergeTwoSortedList(Node h1,Node h2)
    {
        // TODO :: Bug Number 1
        if(h1.data < h2.data)
        {
            head=h1;
            h1=h1.next;
        }
        else
        {
           head=h2;
           h2=h2.next;
        }

      //  System.out.println("head outsde if :" +head.data);
       // Node head = new Node();
       Node c=head;
       while(h1!=null && h2!=null)
       {
           if(h1.data<=h2.data)
           {
               c.next=h1;
               c=h1;
               h1=h1.next;
           }
           else
           {
               c.next=h2;
               c=h2;
               h2=h2.next;
           }
          
       }
       c.next=(h1==null)?h2:h1;
      // return head;
    }

    public Node recursiveMergeSort(Node h1,Node h2)
    {
        Node Curr=null;
        if(h1==null)
        {
            return h2;
        }
        else if (h2==null)
        {
            return h1;
        }
            if (h1.data<=h2.data)
            {
                Curr=h1;
                Curr.next=recursiveMergeSort(h1.next,h2);
            }
            else
            {
                Curr=h2;
                Curr.next=recursiveMergeSort(h1,h2.next);
            }
           // System.out.println(Curr.next.data);
        
        return Curr;
    }

    public Node swapPairWise(Node head)
    {
        Node temp1=null;
        Node temp2=null;
        while(head!=null && head.next!=null)
        {
            if(temp1!=null)
            {
                temp1.next.next=head.next;
            }
            temp1=head.next;
            head.next=head.next.next;
            temp1.next=head;
            if(temp2==null)
            {
                temp2=temp1;
            }
            head=head.next;
        }
        return temp2;

    }

    public Node recursvePairSwap(Node head)
    {
        Node temp=null;
        if(head==null||head.next==null)
        {
            return head;
        }
        else
        {
        temp=head.next;
        head.next=temp.next;
        temp.next=head;
        head=temp;
        head.next.next=recursvePairSwap(head.next.next);
        return temp;
        }

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

    public void reverseK(int k)
    {
       head= reverseKNodesUtilis(head,k);
    }

    public Node reverseKNodesUtilis(Node head,int k)
    {
        if(head==null || head.next==null ||k<1)
        {
            return head;
        }
        int p=k;
        Node curr=head;
        Node prev=null;
        Node next=null;
       
        while(curr!=null && p>0)
        {
            next=curr.next;
            curr.setNext(prev);
            prev=curr;
            curr=next;
            p--;
        }

        if(next!=null)
        {
            head.setNext(reverseKNodesUtilis(next,k));
        }

        return prev;


    }

    public void iterativeReverseK(int k)
    {
        head=iterativeKReverse(head,k);
    }

    public Node iterativeKReverse(Node head,int k)
    {
        Node curr=head;
        Node prevTail=null;
        Node prevCurr=head;
        
        while(curr!=null)
        {
            int c=k;
            Node next=null;
            Node prev=null;
            while(curr!=null && c>0)
            {
                next=curr.next;
                curr.setNext(prev);
                prev=curr;
                curr=next;
                c--;
            }

            if(prevTail!=null)
            {
                prevTail.setNext(prev);
            }
            else
            {
                head=prev;
            }

            prevTail=prevCurr;
            prevCurr=curr;
        }

        return head;

    }
    public void rotate(int k)
    {
        head=rotation(head,k);
    }

    public Node rotation(Node head,int k)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node rotEnd=head;
        Node rotStart=head;
        while(rotEnd!=null && k>0)
        {
            rotEnd=rotEnd.next;
            k--;
//            if(rotEnd==null)
//            {
//                return head;
//            }
        }

        if(rotStart==rotEnd)
        {
            return head;
        }
        while(rotEnd.next!=null)
        {
            rotEnd=rotEnd.next;
            rotStart=rotStart.next;
        }
        Node temp=rotStart.next;
        rotEnd.next=head;
        rotStart.next=null;
        return temp;


    }
    
    public void partition_k(int k)
    {
        head=partitionK(head,k);
    }

    public Node partitionK(Node head,int k)
    {
        Node root=new Node(0,null);
        Node pivot= new Node(k,null);
        Node rootnxt=root;
        Node pivotnxt=new Node(k,null);
        Node curr=head;
        Node next=null;
        while(curr!=null)
        {
            next=curr.next;
            if(curr.data>=k)
            {
                pivotnxt.next=curr;
                pivotnxt=curr;
                pivotnxt.next=null;
                if(pivot.data==k)
                {
                    pivot=pivotnxt;
                }
            }
            else
            {
                rootnxt.next=curr;
                rootnxt=curr;
            }
              curr=next;

        }

        rootnxt.next=pivot;
        return root.next;
    }

     public void Duplicate()
    {
        Node curr=null;
        curr=head;
        Node prev,curr2=null;
        while(curr!=null)
        {
            curr2=curr.next;
            prev=curr;
            while(curr2!=null)
            {
            if(curr2.data==curr.data)
            {
                prev.setNext(curr2.next);

            }
            prev=curr2;
            curr2=curr2.next;
            
            }

            curr=curr.next;
        }

    }

      public void DuplicateUsingMap()
    {
        Node temp=head;
        Node prev=null;
        int flag=0;
        Map<Node,Node> hash=new HashMap<Node,Node>();
        while(temp!=null)
        {
            prev=temp;
            if(hash.get(temp)==null)
            {
            hash.put(temp, temp);
            }
            else
            {
                prev.next=temp.next;

//                System.out.println("loop exist");
//                flag=1;
//                break;
            }
            temp=temp.next;
        }

        if(flag==0)
        {
            System.out.println("loop does not exist");
        }
    }

    void insertInSortedLinkdList(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
 class Node{
   public Node next;
    public int data;
    
    public Node(int x,Node next)
    {
        this.data=x;
        this.next=next;
    }

    public void setNext(Node newNext)
    {
        next=newNext;
    }
}