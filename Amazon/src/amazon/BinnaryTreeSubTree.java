/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
class BinnaryTreeSubTree {

    public static void main(String[] args) {

        Node root1=new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);
        System.out.println("first tree ");
        rPreorder(root1);

        Node root2=new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);
        System.out.println("second tree ");
        rPreorder(root2);

        System.out.println(" second tree is subtree of the first tree " + isSubTree(root1, root2));



    }

    public static void rPreorder(Node r)
    {
        if(r==null)
            return;
        System.out.print(r.data + " ");
        rPreorder(r.left);
        rPreorder(r.right);
    }

    public static boolean isSubTree(Node root1,Node root2)
    {
        if(root1 == null)
            return false;
        if(root2==null)
            return true;

        if(isIdentical(root1,root2))
            return true;

        return isSubTree(root1.left, root2.left) || isSubTree(root1.right, root2.right);
    }

    public static boolean isIdentical(Node r1,Node r2)
    {
        if(r1==null && r2==null)
            return true;
        if(r1==null || r2==null)
            return false;
        if(r1.data==r2.data)
            return true;
        return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
    }

}

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }


}
