/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrankTree;

import java.util.LinkedList;
import java.util.Queue;
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
        //Node root9=new Node(9,null,null);
       // Node root8=new Node(8,null,null);
//        Node root7=new Node(7,null,null);
//        Node root6=new Node(6,null,null);
//        Node root5=new Node(5,null,null);
//        Node root4=new Node(4,null,null);
//        Node root3=new Node(3,root6,root7);
//        Node root2=new Node(2,root4,root5);
//        Node root1=new Node(1,root2,root3);
//
        Tree t=new Tree();
//       // t.zigZag(root1);
//        int h=t.height(root1);
//        System.out.println("height is " + h);
//        int d=t.diameter(root1);
//        System.out.println("diameter is " + d);

//        Node root12=new Node(1,null,null);
//        Node root8=new Node(1,root12,null);
//        Node root9=new Node(1,null,null);
//        Node root10=new Node(1,null,null);
//        Node root11=new Node(1,null,null);
//        Node root7=new Node(1,root10,root11);
//        Node root6=new Node(1,root8,root9);
//        Node root5=new Node(1,null,null);
//        Node root4=new Node(0,null,null);
//        Node root3=new Node(1,root6,root7);
//        Node root2=new Node(0,root4,root5);
//        Node root1=new Node(0,root2,root3);

       Node root7=new Node(6,null,null);
        Node root6=new Node(5,null,null);
       Node root5=new Node(4,null,null);
        Node root4=new Node(3,null,null);
        Node root3=new Node(2,root6,root7);
        Node root2=new Node(1,root4,root5);
        Node root1=new Node(0,root2,root3);

        int d=t.univaluedTree(root1);
        System.out.println("the count is " + d);

        int d1 = t.univaluedTreeR(root1);
        System.out.println(" count 2 == " + d1);
    }

}

class Tree{

    Node root;

    public void zigZag(Node root)
    {
        Stack s1=new Stack();
        Stack s2=new Stack();
       // Node temp=root;
        s1.add(root);
        while(true)
        {
            while(!s1.isEmpty())
            {
                Node temp=(Node) s1.pop();
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                    s2.add(temp.left);
                if(temp.right!=null)
                    s2.add(temp.right);

            }
            while(!s2.isEmpty())
            {
                Node tmp=(Node) s2.pop();
                System.out.print(tmp.data + " ");
                if(tmp.right!=null)
                    s1.add(tmp.right);
                if(tmp.left!=null)
                    s1.add(tmp.left);

            }
        }
    }

        public int height(Node root)
        {
            int left=0;
            int right=0;
            if(root==null)
                return 0;
            left=height(root.left);
            right=height(root.right);
            return Math.max(left, right) + 1;

        }

        public int diameter(Node root)
        {
            int left,right,leftDia,rightDia=0;
            if(root==null)
                return 0;
            else
            {
            left=height(root.left);
            right=height(root.right);

            leftDia=diameter(root.left);
            rightDia=diameter(root.right);

            return Math.max((left+right+1), Math.max(leftDia, rightDia));
            }

        }



        public int univaluedTreeR(Node root)
        {

            if(root==null) return 0;

            if(root.left == null){

                if(root.right ==null) return 1;

                else
                {
                    if(root.right.data== root.data)
                    {
                       return  1 + univaluedTreeR(root.right);
                    }
                    else
                    {
                        return univaluedTreeR(root.right);
                    }
                }
                }
            else if(root.right == null)
            {
                 if(root.left ==null) return 1;

                else
                {
                    if(root.left.data== root.data)
                    {
                       return  1 + univaluedTreeR(root.left);
                    }
                    else
                    {
                        return univaluedTreeR(root.left);
                    }
                }
            }
            else
            {

                if(root.left.data == root.data && root.right.data == root.data)
                {
                    return 1 + univaluedTreeR(root.left) + univaluedTreeR(root.right);
                }
                else
                {
                    return univaluedTreeR(root.left) + univaluedTreeR(root.right);
                }
            }


            }


 public int univaluedTree(Node root)
{
    int count=0;
     
        if(root==null)
            return -1;

        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node t=q.remove();
            if(t.left!=null || t.right!=null)
            {
            if(t.left!=null && t.right==null )
            {
                q.add(t.left);
                if(t.left.data==t.data)
                    count++;
            }
            else if(t.right!=null && t.left==null)
            {
              q.add(t.right);
              if(t.right.data==t.data)
                    count++;
            }

            else if(t.left!=null && t.right!=null)
            {
                q.add(t.left); 
                q.add(t.right);
                if(t.data==t.left.data && t.data==t.right.data)
                    count++;

            }
            }
            else
                count++;

           // System.out.print(t.data + " ");
        }

    return count;

}



    
}
