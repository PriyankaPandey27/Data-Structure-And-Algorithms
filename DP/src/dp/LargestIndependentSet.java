/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
 class LargestIndependentSet {

    public static void main(String[] args) {

        Node root = new Node(20);
    root.left = new Node(8);
    root.left.left  = new Node(4);
    root.left.right= new Node(12);
    root.left.right.left = new Node(10);
    root.left.right.right  = new Node(14);
    root.right  = new Node(22);
    root.right.right = new Node(25);

        System.out.println(LISS(root));


    }

    public static int LISS(Node root)
    {
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
        {
            return root.liss=1;
        }

        int lis_exc=LISS(root.left)+LISS(root.right);
        int lis_inc=1;
        if(root.left!=null)
            lis_inc+=LISS(root.left.left)+LISS(root.left.right);
        if(root.right!=null)
            lis_inc+=LISS(root.right.left)+LISS(root.right.right);
        root.liss=Math.max(lis_inc, lis_exc);
        return root.liss;
    }

}

class Node
{
    int data;
    Node left;
    Node right;
    int liss;

    public Node(int data) {
        this.data = data;
        this.liss=0;
        this.left=this.right=null;
    }

}
