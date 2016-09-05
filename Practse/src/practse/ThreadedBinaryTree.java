/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practse;

import java.util.Stack;

/**
 *
 * @author admin
 */
class ThreadedBinaryTree {
    
    public static void main(String[] args) {
        
        
       // Node n10=new Node(10,null,null);
        Node n9=new Node(9,null,null);
        Node n8=new Node(8,null,null);
        Node n7=new Node(7,null,null);
        Node n5=new Node(5,n9,null);
        Node n4=new Node(4,n7,n8);
        Node n2=new Node(2,n4,n5);
        Node n6=new Node(6,null,null);
        Node n3=new Node(3,null,n6);
        
//        Node n12=new Node(12,null,null);
//        Node n13=new Node(13,null,null);
//        Node n11=new Node(11,null,null);
//        Node n3=new Node(3,n11,null);
//       Node n4=new Node(4,n12,null);
//       Node n2=new Node(2,n4,n13);
       Node n1=new Node(1,n2,n3);
       diameter(n1);
        System.out.println("");
        System.out.println("height is " + findHeight(n1));

      //  morrisTraversalInorder(n1);
       // System.out.println("");
       // preorderSuccessor(n1, 2);
       // preorderPredecessor(n1,6);
        //IpostOrder1stack(n1);
       //morrisInorderTraversalSuccessor(n1, 2);
      // System.out.println("successor is " + inorderSuccessorWithoutParent(n1, 9).x);
        
    }

    public static void morrisInorderTraversalSuccessor(Node root,int data)
    {
        if(root==null)
            return;

        Node curr,prev;
        curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                    prev=prev.right;
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    //System.out.println(curr.x);
                    if(curr.x==data)
                    {
                        System.out.println(curr.right.x);
                        return;
                    }
                    curr=curr.right;
                }
            }
            else
            {
                //System.out.println(curr.x + " ");
                if(curr.x==data && curr.right==null)
                {
                    System.out.println("no successor for this");
                    return;
                }

                if(curr.x==data)
                {
                    System.out.println(curr.right.x);
                    return;
                }
                curr=curr.right;
            }
        }
    }

    public static void morrisInorderTraversalPredessecor(Node root,int data)
    {
        if(root==null)
            return;
        
        Node curr,prev;
        curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                    prev=prev.right;
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    //System.out.println(curr.x);
                    if(curr.right.x==data)
                    {
                        System.out.println(curr.x);
                        return;
                    }
                    curr=curr.right;
                }
            }
            else
            {
                if(curr.x==data)
                 {
                    System.out.println("No predecessor");
                     return ;
                 }
                //System.out.println(curr.x + " ");
                if(curr.right.x==data)
                {
                    System.out.println(curr.x);
                    return;
                }
                curr=curr.right;
            }
        }
    }
    
    public static void morrisTraversalPreorder(Node root)
    {
        if(root==null)
            return;
        Node prev,curr;
        curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                System.out.print( curr.x+ " ");
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                    prev=prev.right;
                
                if(prev.right==null)
                {
                    prev.right=curr.right;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    curr=curr.right;
                    
                }
            }
            else
            {
                System.out.print(curr.x + " ");
                curr=curr.right;
            }
        }
    }

    public static void preorderSuccessor(Node root,int data)
    {
        if(root==null)
            return;
        if(root.x==data && root.left==null && root.right==null)
        {
            System.out.println(" no predessecor " + " no successor ");
            return;
        }
       // else if(root.x==data)
        Node prev,curr;
        curr=root;
        while(curr!=null)
        {
             //temp=curr;
            if(curr.left!=null)
            {
                //System.out.print(curr.x+ " ");

                prev=curr.left;
                if(curr.x==data)
                {
                    System.out.println("successor is " + prev.x );
                    return;
                }
                
                while(prev.right!=null && prev.right!=curr)
                    prev=prev.right;

              //  System.out.println("before prev");

                if(prev.right==null)
                {
                    prev.right=curr.right;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    curr=curr.right;

                }
            }
            else
            {
               // temp=curr;
              //System.out.print(curr.x + " ");
                if(curr.x==data && curr.right==null)
                {
                    System.out.println("no successor as it is end of the preorer");
                    return;
                }
                else if(curr.x==data)
                {
                    System.out.println("successor is " + curr.right.x);
                    return;
                }
                curr=curr.right;
            }
        }
    }

    public static void preorderPredecessor(Node root,int data)
    {
        if(root==null)
            return;
        if(root.x==data )
        {
            System.out.println(" no predessecor " );
            return;
        }
       // else if(root.x==data)
        Node prev,curr;
        curr=root;
        while(curr!=null)
        {
             //temp=curr;
            if(curr.left!=null)
            {
                //System.out.print(curr.x+ " ");

                prev=curr.left;
                if(prev.x==data)
                {
                    System.out.println("Predecessor is " + curr.x );
                    return;
                }

                while(prev.right!=null && prev.right!=curr)
                    prev=prev.right;

              //  System.out.println("before prev");

                if(prev.right==null)
                {
                    prev.right=curr.right;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    curr=curr.right;

                }
            }
            else
            {

                if(curr.right.x==data)
                {
                    System.out.println("predecessor is " + curr.x);
                    return;
                }
                curr=curr.right;
            }
        }
    }


    public static void IpostOrder1stack(Node rt)
{

  if(rt==null)
      return;

  Stack s1=new Stack();

 // s1.push(rt);

do
{
    while(rt!=null)
    {
        if(rt.right!=null)
            s1.push(rt.right);

        s1.push(rt);

        rt=rt.left;
    }


    rt=(Node) s1.pop();

    Node top=null;

    if(!s1.isEmpty())
        top=(Node) s1.peek();


    if(rt.right!=null && rt.right==top)
    {
        s1.pop();
        s1.push(rt);
        rt=rt.right;
    }
    else
    {
        System.out.print(rt.x+"  ");
        rt=null;
    }

}while(!s1.isEmpty());


}

    public static Node inorderSuccessorWithoutParent(Node root,int d)
    {
        if(root==null)
            return null;
        if(root.x==d && root.right!=null)
        {
            return getLeft(root.right);
        }

        Node succ=null;
        while(root!=null)
        {
        if(d<root.x)
        {
            succ=root;
            root=root.left;
        }
        else if(d>root.x)
            root=root.right;
        else
            break;
        }

        return succ;
    }

    public static Node getLeft(Node root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }

    public static int calDiameter(Node root,Height height)
    {
        if(root==null)
        {
            height.h=0;
            return 0;
        }

        Height lh=new Height();
        Height rh=new Height();

        lh.h++;
        rh.h++;
        int ldia=calDiameter(root.left, lh);
        int rdia=calDiameter(root.right, rh);

        height.h=Math.max(lh.h, rh.h)+1;

        return Math.max(1+lh.h+rh.h, Math.max(ldia, rdia));




    }

    public static void diameter(Node root)
    {
        Height h=new Height();
        int d=calDiameter(root, h);
        System.out.println("diameter is  " + d);
        System.out.println("height is " + h.h);
    }

    public static int findHeight(Node root)
    {
        if(root==null)
            return 0;

        int lh=findHeight(root.left);
        int rh=findHeight(root.right);
        return Math.max(lh, rh)+1;

    }



}

class Node
{
    int x;
    Node left;
    Node right;

    public Node(int x, Node left, Node right) {
        this.x = x;
        this.left = left;
        this.right = right;
    }

}

class Height
{
    int h;
}
