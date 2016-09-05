/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
class DistanceBtwnTwoNodes {
    
    
    public static void main(String[] args) {
  
    
    Node r8=new Node(8,null,null);
    Node r7=new Node(7,null,null);
    Node r4=new Node(4,null,null);
    Node r5=new Node(5,null,null);
    Node r6=new Node(6,null,r8); 
    Node r3=new Node(3,r6,r7);
    Node r2=new Node(2,r4,r5);
    Node  root = new Node(1,r2,r3);
    
        System.out.println("distance btwn two nodes is " + distBtwnNodes(root, r8, r5));
        
        
    }
    
    
    public static int distBtwnNodes(Node root,Node n1,Node n2)
    {
        Node lca=LCA(root, n1, n2);
        if(lca!=null)
            return findDistance(lca, n1)+findDistance(lca, n2);
        else
            return -1;
    }


    public static Node LCA(Node root,Node n1,Node n2)
    {
        if(root==null)
            return null;

        if(root.data==n1.data || root.data==n2.data)
            return root;

        Node leftroot=LCA(root.left, n1, n2);
        Node rightroot=LCA(root.right, n1, n2);

        if(leftroot!=null && rightroot!=null)
            return root;
        else
            return (leftroot!=null)?leftroot:rightroot;


    }


    public static int findDistance(Node root,Node n)
    {
        if(root==null)
            return -1;
        if(root.data==n.data)
            return 0;

        int left=findDistance(root.left, n);
        int right=findDistance(root.right, n);

        if(left!=-1)
            return left+1;
        else if(right!=-1)
            return right+1;
        else
            return -1;
    }


}

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data,Node left,Node right) {
        this.data = data;
        this.left=left;
        this.right=right;
    }

}
