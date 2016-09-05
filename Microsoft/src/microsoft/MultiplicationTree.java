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
 class MultiplicationTree {

     public static void main(String[] args) {


         Node r1=new Node(1,null,null);
         Node r11=new Node(11,null,null);
         Node r4=new Node(4,null,null);
         Node r10=new Node(10,null,null);
         Node r6=new Node(6,r1,r11);
         Node r9=new Node(9,r4,r10);
         Node r8=new Node(8,null,null);
         Node r7=new Node(7,r8,r6);
         Node r5=new Node(5,null,r9);
         Node root=new Node(2,r7,r5);

         multiplicationOfAllSum(root);


     }

     public static void multiplicationOfAllSum(Node root)
     {
         int p=multiplicationOfAllSumUtil(root);
         System.out.println("total product of the sum of leaves at each level is " + p);
     }

     public static int multiplicationOfAllSumUtil(Node root)
     {
         if(root==null)
             return 0;

         Queue<Node> q=new LinkedList<Node>();
         q.add(root);
         q.add(null);
         int product=1;
         int s=0;
         while(!q.isEmpty())
         {
             Node t=q.remove();

             if(t!=null)
             {
                 if(t.left!=null)
                     q.add(t.left);
                 if(t.right!=null)
                     q.add(t.right);

                 if(t.left==null && t.right==null)
                     s=s+t.data;
             }
             else
             {
                 if(s!=0)
                 {
                 product=product*s;
                 }
                 if(!q.isEmpty())
                 {
                     q.add(null);
                     s=0;
                 }
             }
         }

         return product;

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
