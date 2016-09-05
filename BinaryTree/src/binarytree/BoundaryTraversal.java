/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author admin
 */
class BoundaryTraversal {

    public static void main(String[] args) {

        Node root=new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        printBoundaryTree(root);
    }

    public static void printLeaves(Node root)
    {
        if(root==null)
            return;

        if(root.left==null && root.right==null)
            System.out.print(root.data + " ");

        printLeaves(root.left);
        printLeaves(root.right);

    }

    public static void printLeftBorder(Node root)
    {
        if(root==null)
            return;

        if(root.left!=null)
        {
        System.out.print(root.data + " ");
        printLeftBorder(root.left);
        }
        else if(root.right!=null)
        {
            printLeftBorder(root.right);
        }

    }

    public static void printRightBorder(Node root)
    {
        if(root==null)
            return;

        if(root.right!=null)
        {
            System.out.print(root.data + " ");
            printRightBorder(root.right);
        }
        else if(root.left!=null)
        {
            printRightBorder(root.left);
        }
    }

    public static void printBoundaryTree(Node root)
    {
        if(root==null)
            return;

        System.out.print(root.data + " ");
        printLeftBorder(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBorder(root.right);
    }

    public static void topView(Node root)
    {
        if(root==null)
            return;

        System.out.println(root.data + " ");
        printLeftBorder(root.left);
        printRightBorder(root.right);
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
