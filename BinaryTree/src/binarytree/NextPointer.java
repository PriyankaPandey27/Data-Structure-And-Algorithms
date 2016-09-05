/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
 class NextPointer {

    public static void main(String[] args) {

//         TreeLinkNode root7=new TreeLinkNode(7,null,null);
        TreeLinkNode root6=new TreeLinkNode(6,null,null);
       TreeLinkNode root5=new TreeLinkNode(5,null,null);
        TreeLinkNode root4=new TreeLinkNode(4,null,null);
        TreeLinkNode root3=new TreeLinkNode(3,root6,null);
        TreeLinkNode root2=new TreeLinkNode(2,root4,root5);
        TreeLinkNode root1=new TreeLinkNode(1,root2,root3);
        connect(root1);
        
//        System.out.println("inorder traversal");
//        rInorder(invertTree(root1));
//        int p=isBalanced(root1);
//        System.out.println(" p is " + p);


    }

    public static TreeLinkNode invertTree(TreeLinkNode root) {

        if(root==null)
            return null;

        TreeLinkNode temp=null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static int isBalanced(TreeLinkNode a) {

        if(a==null)
            return 1;

        if(a.left==null && a.right==null)
            return 1;

        int l=Height(a.left);
        int r=Height(a.right);

        if(Math.abs(l-r)>1)
            return 0;



        if(isBalanced(a.left)==1 && isBalanced(a.right)==1)
        {
            return 1;
        }
        return 0;


	}

       public static int Height(TreeLinkNode root)
      {
          if(root==null)
          {
              return 0;
          }
          else
          {
              int l= Height(root.left);
              int r= Height(root.right);

//              System.out.println("root " + root.val+ " left " + l);
//              System.out.println("root " + root.val+ " right " + r);



                   return (1+Math.max(l,r));
            //  return (Math.max(l,r)+1);
          }
      }

     public static void rInorder(TreeLinkNode root)
    {
        if(root!=null)
        {
            rInorder(root.left);
            System.out.print(root.val + " ");
            //System.out.println("max value is" + max);

            rInorder(root.right);
        }
        else
            return;
    }

    public static void connect(TreeLinkNode root)
    {
        Queue<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
        TreeLinkNode res=null;
        if(root==null)
            return;
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            TreeLinkNode t=q.remove();
            if(t!=null)
            {
               // System.out.print(t.val);
                if(t.left!=null)
                {
                    q.add(t.left);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                }

                if(q.peek()==null)
                {
                    if(res==null)
                    {
                        res=t;
                    }
                    t.next=null;
                }
                else
                {
                    if(res==null)
                    {
                        res=t;
                    }
                    t.next=q.peek();
                }
                    
            }
            else
            {
                if(!q.isEmpty())
                q.add(null);
                while(res!=null)
                {
                    System.out.print(res.val+ "--> ");
                    res=res.next;
                }
               // System.out.println("");
                res=null;
            }
            System.out.println();
        }

    }

}

 class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x,TreeLinkNode l,TreeLinkNode r) { val = x;
    this.left=l;
    this.right=r;}
}
