/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author admin
 */
public class AVLTree {

    public static void main(String args[])
    {
       
      AVLImplementation avl=new AVLImplementation();
      Node root=null;
     // root = avl.insert(root, 10);
//        root = avl.insert(root, 20);
//        root = avl.insert(root, 30);
//        root = avl.insert(root, 40);
//        root = avl.insert(root, 50);
//        root = avl.insert(root, 25);
//        root = avl.insert(root, 35);
      root=avl.insert(root, 10);
      root=avl.insert(root, 20);
      root=avl.insert(root, 30);
      root=avl.insert(root, 35);
      root=avl.insert(root, 25);
      root=avl.insert(root, 33);
      root=avl.insert(root, 40);
      root=avl.insert(root, 50);
      root=avl.insert(root, 60);
      root=avl.insert(root, 55);
      root=avl.insert(root, 52);

      avl.preOrder(root);


    }

}

class AVLImplementation
{
    public int getHeight(Node n)
    {
        if(n==null)
            return 0;
        return n.height;
    }
    
    public int getBalance(Node n)
    {
        if(n==null)
            return 0;
        return (getHeight(n.left)-getHeight(n.right));
    }
    
    public Node rightRotate(Node y)
    {
        Node x=y.left;
        Node t=x.right;
        
        //rotation
        
        x.right=y;
        y.left=t;

        y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
        

        return x;
        
    }


    public Node leftRotate(Node x)
    {
        if(x==null)
        {
            return null;
        }
        Node y=x.right;
        Node t=y.left;

        //rotation

        y.left=x;
        x.right=t;

        x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
        y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
        

        return y;
    }
    
    public Node insert(Node root,int d)
    {
        if(root==null)
        {
            
            return(new Node(d));
        }

        //System.out.println("root is " + root.k);
        if(d<root.k)
            root.left=insert(root.left, d);
        else
            root.right=insert(root.right, d);

        root.height=Math.max(getHeight(root.left), getHeight(root.right))+1;
        int balance=getBalance(root);
        // LL case
        if(balance>1 && d<root.left.k)
            return rightRotate(root);
        //RR case
        if(balance<-1 && d>root.right.k)
            return leftRotate(root);
        // LR case
        if(balance>1 && d>root.left.k)
        {
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }


        // RL case
        if(balance<-1 && d<root.right.k)
        {
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }
    
    public void preOrder(Node root)
    {
        if(root==null)
            return;
        
        System.out.print(root.k + " ");
        preOrder(root.left);
        preOrder(root.right);
        
    }



    
    
}

class Node
{
    int k;
    Node left;
    Node right;
    int height;

    public Node(int d)
    {
        this.k=d;
        height=1;
    }

}

