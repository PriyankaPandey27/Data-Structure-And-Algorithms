/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Tree;

/**
 *
 * @author admin
 */
 class FlatteningInPlace {

    public static void main(String[] args) {

        Node root7=new Node(7,null,null);
        Node root6=new Node(6,null,null);
        Node root5=new Node(5,null,null);
        Node root4=new Node(4,null,null);
        Node root3=new Node(3,root6,root7);
        Node root2=new Node(2,root4,root5);
        Node root1=new Node(1,root2,root3);

       // System.out.println("lca is  " + LCA(root1, 4, 9));


        flatten(root1);
        display(root1);


    }

    public static void display(Node root)
    {
        if(root==null)
            return ;

        System.out.print(root.data + " ");
        display(root.right);
    }

    public static Node flatten(Node root)
    {
        if(root==null)
            return null;

        Node cur=root;
        Node prev=root;
        while(cur!=null)
        {
            if(cur.left!=null)
            {
            prev=cur.left;
            while(prev.right!=null)
            {
                prev=prev.right;
            }
            prev.right=cur.right;
            cur.right=cur.left;
            cur.left=null;
            }
            else
                cur=cur.right;
        }

        return root;


    }
    
    public static int LCA(Node root,int val1,int val2)
    {
        Node a=new Node(val1);
        Node b=new Node(val2);
        Node res=LCAUtil(root,a,b);
        if(res==null)
            return -1;
        
        return res.data;
    }

    public static Node LCAUtil(Node root,Node a,Node b)
    {
        if(root==null)
            return null;

        if(root.data==a.data||root.data==b.data)
            return root;


        Node left=LCAUtil(root.left,a,b);
        Node right=LCAUtil(root.right,a,b);
        if(left!=null && right!=null)
            return root;
        else
            return (left!=null)?left:right;
    }

}

class Node{

    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }
    public Node(int data,Node left,Node right) {
        this.data = data;
        this.left=left;
        this.right=right;
    }


}
