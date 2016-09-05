/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doublyll;

/**
 *
 * @author admin
 */
public class BinaryTreetoDLL {

    public static void main(String[] args) {

        Tree t=new Tree();
         t.root = new Node(10);
        t.root.left = new Node(12);
        t.root.right = new Node(15);
        t.root.left.left = new Node(25);
        t.root.left.right = new Node(30);
        t.root.right.left = new Node(36);

        Node head=t.binaryTreetoDll(t.root);
        t.printDLL(head);
    


    }


}

class Tree
{
    
    Node root;
    public Node binaryTreetoDll(Node node)
    {
        if(node==null)
            return node;
        
         node=binaryTreetoDllUtil(node);
         while(node.left!=null)
             node=node.left;
         
         return node;
        
        
    }
    
    @SuppressWarnings("empty-statement")
    public Node binaryTreetoDllUtil(Node node)
    {
        if(node==null)
            return node;
        
        if(node.left!=null)
        {
            Node leftNode=binaryTreetoDllUtil(node.left);
            for( ;leftNode.right!=null;leftNode=leftNode.right);
            leftNode.right=node;
            node.left=leftNode;
        }
        if(node.right!=null)
        {
            Node rightNode=binaryTreetoDllUtil(node.right);
            for( ;rightNode.left!=null;rightNode=rightNode.left);
            rightNode.left=node;
            node.right=rightNode;
        }
        
        return node;
        
    }


   
    
    public void printDLL(Node node)
    {
        Node temp=node;
        while(temp!=null)
        {
            System.out.print(temp.data + "<-->");
            temp=temp.right;
        }
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
