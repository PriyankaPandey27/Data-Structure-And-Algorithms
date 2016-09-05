/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
class CousinNotSibling {


    public static void main(String[] args) {

    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);
    root.right.left.left=new Node(8);

    Tree r=new Tree();
    r.isCousinNotsibling(root, new Node(4), new Node(5));


    }



}


class Tree
{
    public void isCousinNotsibling(Node root , Node n1 , Node n2)
{
//    int LCA= isCousinNotsiblingUtil(root, n1, n2);
////    System.out.println("LCA == " + LCA);
//    if(LCA==-1)
//    {
//        System.out.println("nodes not found");
//        return;
//    }

        Node lca=LCA(root, n1, n2);
        System.out.println("lca " +lca.value);
        if(lca==null)
        {
             System.out.println("nodes not found");
             return;
        }


    Queue<Node> q = new LinkedList();
    q.add(root);
    q.add(null);

    Node t=null;

    while(!q.isEmpty())
    {
         t = q.remove();
         if(t==null)
         {
             q.add(null);
             continue;
         }

        if(t!=null && t.value==lca.value)
        {
            break;
        }
         q.add(t.left);
         q.add(t.right);

    }
    if(t!=null && t.left!=null && t.right!=null)
    {
    if((t.left.value==n1.value && t.right.value==n2.value)
            || (t.right.value==n1.value && t.left.value==n2.value))
    {
        System.out.println("n1 and n2 are siblings NOT cousins");
    }
    else
    {
         System.out.println("n1 and n2 are cousins  NOT siblings   ");
    }

    }

}

public int isCousinNotsiblingUtil( Node root , Node n1 , Node n2)
{

    if(root==null || n1==null || n2 ==null) {
        System.out.println("Invalid input params");
        return -1;
    }


    int[] p1= new int[10];

    int[] p2= new int[10];

    Node temp1 = root , temp2 = root;

    int t1 = pathFromRootToThatNode(temp1, p1, n1, 0);
    int t2 = pathFromRootToThatNode(temp2, p2, n2, 0);


    if(t1==-1 || t2==-1)
    {
        System.out.println("LCA does not exist for given combination !!");
        return -1;
    }

    if(t1==0)
    {
        System.out.println("LCA == " + p1[t1]);
        return -1;
    }
    if(t2==0)
    {
        System.out.println("LCA == " + p2[t2]);
        return -1;
    }

    return LCA_value(p1, p2, t1, t2);

}

int counter=0;

//public void LCAUsingPathFromRootToThatNode( Node root , Node n1 , Node n2)
//{
//
//    if(root==null || n1==null || n2 ==null) {
//        System.out.println("Invalid input params");
//        return;
//    }
//
//
//    int[] p1= new int[10];
//
//    int[] p2= new int[10];
//
//    Node temp1 = root , temp2 = root;
//
//    int t1 = pathFromRootToThatNode(temp1, p1, n1, 0);
//
////    System.out.println("counter 1 st : " + counter);
//    int t2 = pathFromRootToThatNode(temp2, p2, n2, 0);
//
////    System.out.println("counter 2 nd : " + counter);
//
//    if(t1==-1 || t2==-1)
//    {
//        System.out.println("LCA does not exist for given combination !!");
//        return;
//    }
//
//    if(t1==0)
//    {
//        System.out.println("LCA == " + p1[t1]);
//        return;
//    }
//    if(t2==0)
//    {
//        System.out.println("LCA == " + p2[t2]);
//        return;
//    }
//
//    int value = LCA_value(p1, p2, t1, t2);
//    if(value==-1)
//    {
//        System.out.println("LCA does not exist");
//    }
//    else
//    {
//        System.out.println("LCA == " + value);
//    }
//
//}

public Node LCA(Node root,Node n1,Node n2)
{
   if(root==null)
   {
       return root;
   }

   if(root.value==n1.value||root.value==n2.value)
   {
       return root;
   }

   Node left=LCA(root.left,n1,n2);
 // System.out.println("left inside LCA "+ left.data);
   Node right=LCA(root.right,n1,n2);
  //  System.out.println("right inside LCA "+ right.data);
   if(left!=null && right!=null)
   {
       return root;
   }
   else
   {
       return(left!=null?left:right);
   }
}



public int pathFromRootToThatNode(Node root, int[] p , Node n , int length)
{

   // counter++;
    if(root==null || n==null)
    {
        return -1;
    }

    p[length] = root.value;

    if(root.value==n.value)
        return length;

    int l1= pathFromRootToThatNode(root.left, p, n, length+1);

    if(l1 !=-1)
    {
        return l1;
    }

    int l2= pathFromRootToThatNode(root.right, p, n, length+1);

    if(l2 !=-1)
    {
        return l2;
    }
    return -1;

}


public int LCA_value(int[] n1 , int[] n2 , int t1, int t2)
{

    for(int i=Math.min(t1,t2);i>=0 ;i--)
    {

        if(n1[i] == n2[i]) {
            return n1[i];
        }
    }
//
    return -1;
}

}

class Node
{
    int value;
    Node left;
    Node right;

    public Node(int data) {
        this.value = data;
    }


}
