/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author admin
 */
public class stackImplementation {
    public static void main(String args[])
    {
        //System.out.println("\"\"");
        linkedStack ll=new linkedStack();
        String S="()(()))))";
//        ll.push(12);
//        ll.push(13);
//        ll.push(14);
//        ll.push(15);
        //ll.deleteStack();
//        ll.display("elements in the stack");
      // ll.symbolCheck(S);
        System.out.println("longest valid substring " + ll.longestValidSubstring(S));
       // ll.insertAtBottom(11);
       // ll.insertAtBottom(10);
//        ll.reverseRecurr();
//        ll.display("after reversing the element");
       // ll.peek();
       // ll.pop();
       // ll.display();
       // ll.top();
//        
//        ll.display();
    }

}


 class linkedStack{

     Node start;

     public void symbolCheck(String r)
     {
         if(symbolCheckUtils(r)==true)
             System.out.println("symbols are balanced");
         else
             System.out.println("symbols are not balanced");
     }
     public boolean symbolCheckUtils(String S)
     {
         char arr[]=S.toCharArray();
         if(arr==null||arr.length==0)
             return true;
        //System.out.println(arr.length);
         for(int i=0;i<arr.length;i++)
         {
             //char t=top();
             if(arr[i]==')')
             {
                 if( start!=null && top()=='(')
                     pop();
                 else
                     return false;
             }
             else if(start!=null && arr[i]=='}')
             {
                 if( top()=='{')
                     pop();
                 else
                      return false;
             }
             else if(start!=null && arr[i]==']')
             {
                 if(top()=='[')
                     pop();
                 else
                      return false;
             }
             else
             {
                 push(arr[i]);
             }
         }
       //  System.out.println(start.p);
         if(start==null)
            return true;
         else
             return false;
         
     }


     public int longestValidSubstring(String S)
     {
         char arr[]=S.toCharArray();

         int count=0;
         if(arr==null||arr.length==0)
             return 0;
        //System.out.println(arr.length);
         for(int i=0;i<arr.length;i++)
         {
             char t=top();
             //System.out.println("top " + t);
             if(arr[i]==')')
             {
                // System.out.println("inside array");
                 if( start!=null && top()=='(')
                 {
                     
                     count+=2;
                     pop();
                     //System.out.println("count " + count);
                 }

             }

             else
             {
                 push(arr[i]);
             }
         }



         return count;
       //  System.out.println(start.p);
//         if(start==null)
//            return true;
//         else
//             return false;

     }




     public void push(char x)
     {
         if(start==null)
         {
             start=new Node(x,null);

         }
         else
         {
             Node temp=new Node(x,start);
             //temp.next=start;
             start=temp;

         }
     }

     public void peek()
     {
          Node temp=start;
          if(start!=null)
          {
              System.out.println(temp.p);
          }
     }

     public char pop()
     {
//         if(start==null)
//         {
//             //System.out.println("stack underflow");
//            return 0;
//         }
//         else
//         {
           Node temp=start;
           start=start.next;
//             //System.out.println("popped element is "+ start.p);
           return temp.p;
//
//         }
     }

     public char top()
     {
         Node temp=start;
         // if(temp==null)
//         {
//             System.out.println("stack underflow");
//         }
//         else
//         {
//             System.out.println("top element is "+ temp.data);
//         }
         if(temp!=null)
         return temp.p;
         else
             return 0;
     }
        
     

     public void deleteStack()
     {
         start=null;
     }

     public void reverseIterative()
     {
         if(start==null||start.next==null)
         {
             return;
         }
         else
         {
         Node curr=start;
         Node prev=null;
         Node next=null;
         while(curr!=null)
         {
             next=curr.next;
             curr.setnext(prev);
             prev=curr;
             curr=next;
         }
         start= prev;
        }

     }

     public void reverseRecurr()
     {
         if(start==null)
         {
             return;
         }
         else
         {
             int t=start.data;
             start=start.next;
             System.out.println(t);

             insertAtBottom(t);
             reverseRecurr();
            // push(t);
         }
     }

     public void insertAtBottom(int x)
     {
         if(start==null)
         {
           //  push(x);
         }
         else
         {
         int t=start.data;
         start=start.next;
         insertAtBottom(x);
       //  push(t);
         }
     }

     public void display(String s)
     {
         System.out.println(s);
         if(start==null)
         {
             System.out.println("stack underflow");
         }
         else
         {
             Node temp=start;
             while(temp!=null)
             {
             System.out.println(temp.data);
             temp=temp.next;
             }
         }
     }

     




}

 class Node{
    public int data;
    public char p;
    public Node next;

//    public Node(int x,Node next)
//    {
//        this.data=x;
//        this.next=next;
//    }

      public Node(char x,Node next)
    {
        this.p=x;
        this.next=next;
    }
//    public Node(int x)
//    {
//        this.data=x;
//
//    }

    public void setnext(Node newnext)
    {
        next=newnext;
    }

    public int getdata()
    {
        return data;
    }
}
