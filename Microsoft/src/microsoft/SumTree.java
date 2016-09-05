/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
 class SumTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Node rootD=new Node(8,null,null);
        Node rootE=new Node(-4,null,null);
        Node rootF=new Node(7,null,null);
        Node rootG=new Node(5,null,null);
        Node rootB=new Node(-2,rootD,rootE);
        Node rootC=new Node(6,rootF,rootG);
        Node rootA=new Node(10,rootB,rootC);
        int s=0;
      // rInorder(rootA);

        sumTreeValue(rootA);
        System.out.println("");
        rInorder(rootA);
//        System.out.println("");
        inorder(rootA);







     }


    public static void sumTreeValue(Node root)
    {
       // Node temp=null;
        if(root==null)
            return ;

        if(root.left!=null && root.right!=null)
        {
          root.data=(root.left.data+root.right.data);
        }
        else
        {
            root.data=0;
        }


        sumTreeValue(root.left);
        sumTreeValue(root.right);
    }


    public static void inorder(Node n)
    {
        if(n==null)
            return;
       Queue<Node> q=new LinkedList<Node>();
       q.add(n);
       while(!q.isEmpty())
       {
           Node r=q.remove();
           if(r.left!=null && r.right!=null)
           {
           
           r.data=r.left.data+ r.right.data+r.data;
           System.out.print(r.data + " ");
           }

           if(r.left!=null)
               q.add(r.left);
           if(r.right!=null)
               q.add(r.right);

           if(r.left==null && r.right==null)
               System.out.print(r.data + " ");
       }
        
    }

    public static void rInorder(Node root)
    {
        if(root!=null)
        {
            rInorder(root.left);
            System.out.println(root.data + " ");
            rInorder(root.right);
        }
    }

}


class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }



}
