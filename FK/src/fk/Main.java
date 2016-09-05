/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fk;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Node root21=new Node(21,null,null);

        Node root20=new Node(20,root21,null);

        Node root16=new Node(16,null,null);


         Node root15=new Node(15,root16,root20);

        Node root14=new Node(14,root15,null);

        Node root8=new Node(8,null,null);


        Node root7=new Node(7,root8,root14);

        Node root11=new Node(11,null,null);


        Node root10=new Node(10,root11,null);

        Node root4=new Node(4,null,null);


        Node root3=new Node(3,root4,root10);

        Node root2=new Node(2,root3,null);
        Node root1=new Node(1,root2,root7);

        ////////Test case 2

//        Node root5=new Node(5,null,null);
//        Node root4=new Node(4,null,root5);
//
//        Node root3=new Node(3,null,root4);
//
//        Node root2=new Node(2,null,root3);
//
//        Node root1=new Node(1,null,root2);

        ////////Test case 3
//          Node root6=new Node(6,null,null);
//          Node root5=new Node(5,root6,null);
//          Node root4=new Node(4,null,root5);
//          Node root3=new Node(3,root4,null);
//          Node root2=new Node(2,null,root3);
//          Node root1=new Node(1,root2,null);



        
        Tree  t=new Tree();
//        t.display(root1);
      // Node tmp= ;
       // t.displayLL(t.binaryTreetoLL(root1));
        //t.binaryTreetoLLOutPlace(root1);
          t.displayLL(t.binaryTreetoLLinorder(root1));




    }


}

class Tree

{
    Node root;
   // Node head=null;
     public void display(Node root)
    {
        if(root!=null)
        {
            System.out.print(root.x + " ");
            display(root.down);
            display(root.next);
        }
        else
            return;
    }

// binart tree to linked list preorder iterative
    public Node binaryTreetoLL(Node root)
    {
        if(root==null)
            return null;
        Node prev=null;
        Node cur=root;
        while(cur!=null)
        {
            if(cur.down!=null)
            {
//                if(cur.next!=null)
//                {
                    prev=cur.down;
                    while(prev.next!=null)
                    {
                        prev=prev.next;
                    }
                    prev.next=cur.next;
                //}
                cur.next=cur.down;
                cur.down=null;
            }
            else
            {
                cur=cur.next;
            }

        }
        return root;

    }

    //binary tree to linked list inorder iterative

    public Node binaryTreetoLLinorder(Node root)
    {
        if(root==null)
        return null;
        Node prev=null;
        Node last=null;
        Node head=null;

        while(root!=null)
        {
            if(root.down!=null)
            {
                prev=root.down;
                while(prev.next!=null)
                {
                    prev=prev.next;
                }
                prev.next=root;
                prev=prev.next;
                root=root.down;
                prev.down=null;
                if(last!=null)
                {
                    last.next=root;
                }
            }
            else
            {
                if(head==null)
                    head=root;
                last=root;
                root=root.next;
            }

        }
        return head;
    }

    public void binaryTreetoLLOutPlace(Node root)
    {
        Stack s=new Stack();
       if(root==null)
           return ;
       else
       {
            
            while(root!=null)
            {
                System.out.print(root.x + "--->");
                if(root.next!=null && root.down!=null)
                {
                if(root.next!=null)
                    s.push(root.next);
                if(root.down!=null)
                    root=root.down;
                }
                else if(root.next!=null)
                {
                    root=root.next;
                }
                else if(root.down!=null)
                {
                    root=root.down;

                }
                else
                {
                    Node temp = null;
                     if(!s.isEmpty())
                     {
                    temp=(Node)s.pop();

                     }
                    root.next=temp;
                    root=temp;
                }




            }
           // return root;
       }
    }

//    public void BTtoLLinorder(Node root)
//    {
//        if(root==null)
//            return;
//        Node prev=null;
//       // Node head=null;
//        BTtoLLinorder(root.down);
//        if(head==null)
//            head=root;
//        if(prev!=null)
//        {
//            prev.next=root;
//        }
//
//        root.down=null;
//        prev=root;
//        BTtoLLinorder(root.next);
//        //return head;
//    }


    public void displayLL(Node root)
    {
        Node temp=root;
        while(temp!=null)
        {
            System.out.print(temp.x+ "----> ");
            temp=temp.next;
        }
    }
}



///http://www.zrzahid.com/transformflatten-binary-tree-tofrom-linked-list/