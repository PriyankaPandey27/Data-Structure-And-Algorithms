/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doublyll;

/**
 *
 * @author admin
 */
public class BinaryLeafToDLL {

    public static void main(String[] args) {

          Tree t=new Tree();
         t.root = new Node(30);
        t.root.left = new Node(32);
        t.root.right = new Node(45);
        t.root.left.left = new Node(10);
        t.root.left.right = new Node(11);
        t.root.right.left = new Node(40);
        t.root.right.right = new Node(23);

        t.leafToDll(t.root, null,false,false);
        
        System.out.println("Printing LL...");
        t.printLeafToDll(t.headStart);

        System.out.println("\nInorder traversal ....");
        t.rInorder(t.root);
       // System.out.println("the given tree is bst " + t.checkBST(t.root));


    }



}

class Tree{
    
    Node root;
    Node head;
    Node headStart;
    public void leafToDll(Node node , Node parentOfRoot, boolean l , boolean r)
    {
      // Node headStart=null;
        if(node==null)
            return ;
        
        if(node.left==null && node.right==null)
        {
        
            if(head==null)
            {
                head=node;
                headStart=head;

                if(parentOfRoot!=null && l)
                {
//                    System.out.println("Check 1 "  + parentOfRoot.left.data);
                   parentOfRoot.left=null;
                }
                else if(parentOfRoot!=null && r)
                {
//                     System.out.println("Check 2 " + parentOfRoot.right.data);
                     parentOfRoot.right=null;
                }


            }
            else if(head!=null)
            {
                
                node.left=head;
                head.right=node;
                if(parentOfRoot!=null && l)
                {
//                    System.out.println("Check 1 "  + parentOfRoot.left.data);
                   parentOfRoot.left=null;  
                }
                else if(parentOfRoot!=null && r)
                {
//                     System.out.println("Check 2 " + parentOfRoot.right.data);
                     parentOfRoot.right=null; 
                }

              //  node.right=null;
                head=node;
            }

          return;
        }
      leafToDll(node.left, node,true,false);
      leafToDll(node.right,node,false,true);
    }
    
    public static void printLeafToDll(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data + " ");
            node=node.right;
        }
    }

    public boolean checkBST(Node node)
    {
         int prev=Integer.MIN_VALUE;
         return checkBSTUtil(node,prev);
    }


    public boolean checkBSTUtil(Node node,int prev)
    {
       
        if(node==null)
            return true;

        if(!checkBSTUtil(node.left,prev))
            return false;

        //System.out.println("previous " + prev);

        if(node.data < prev)
            return false;

        prev=node.data;

        return checkBSTUtil(node.right,prev);


    }

    public static void rInorder(Node root)
    {
        if(root==null) return;

        rInorder(root.left);
        System.out.println(root.data);
        rInorder(root.right);
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

//    public Node() {
//    }


}
