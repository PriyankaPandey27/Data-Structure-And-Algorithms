/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author admin
 */
public class BottomView {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        BottomViewOfTree tree = new BottomViewOfTree(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView(root);
        //tree.verticalOrder(root);
        //tree.iPostorder(root);
    }



}

class BottomViewOfTree{
    
    TreeNode root;

    public BottomViewOfTree(TreeNode r) {
        this.root = r;
    }
    
    
    public void bottomView(TreeNode root)
    {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        if(root==null)
            return;
        
        int hd=0;
        root.hd=hd;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp=q.remove();
            hd=temp.hd;
            h.put(hd, temp.x);
            if(temp.left!=null)
            {
                temp.left.hd=hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }

      //  System.out.println(h.get(hd));
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
           System.out.print(entry.getValue() + " " + entry.getKey()+"   ");
    }
    }


    public static void verticalOrder(TreeNode root)
    {
        if(root==null)
            return ;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        int hd=0;
        verticalOrderUtil(root,h,hd);

        for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
        {
            if(entry.getValue()!=null)
            {
                for(Integer i:entry.getValue())
                {
                    System.out.print(i+" ");
                }
                System.out.println("");
            }
        }

    }

    public static void verticalOrderUtil(TreeNode root,HashMap<Integer,ArrayList<Integer>> h,int hd)
    {
        if(root==null)
            return;
        if(h.get(hd)==null)
        {
            h.put(hd, new ArrayList<Integer>());
            h.get(hd).add(root.x);
        }
        else
            h.get(hd).add(root.x);

        verticalOrderUtil(root.left, h, hd-1);
        verticalOrderUtil(root.right, h, hd+1);

    }

    public void iInorder(TreeNode root)
    {
        if(root==null)
            return;

        Stack s=new Stack();
        while(true)
        {
            if(root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else
            {
                if(s.isEmpty())
                    break;
                else
                {
                    root=(TreeNode)s.pop();
                    System.out.print(root.x+" ");
                    root=root.right;
                }
            }
        }

    }

    public void iPreorder(TreeNode root)
    {
        Stack s=new Stack();
        while(true)
        {
            if(root!=null)
            {
                System.out.print(root.x+ " ");
                if(root.right!=null)
                    s.push(root.right);
                root=root.left;

            }
            else
            {
                if(s.isEmpty())
                    break;
                else
                {
                    root=(TreeNode)s.pop();
                }
            }
        }
    }

    public void iPostorder(TreeNode root)
    {
        Stack s=new Stack();
        do
        {
            while(root!=null)
            {
                //System.out.print(root.x+ " ");
                if(root.right!=null)
                    s.push(root.right);
                    s.push(root);
                root=root.left;

            }  root=(TreeNode)s.pop();
                if(!s.isEmpty())
                {
                    TreeNode top=(TreeNode)s.peek();
                    if(root.right!=null && root.right==top)
                     {
                             s.pop();
                             s.push(root);
                             root=root.right;
                     }
                    else
                    {
                        System.out.print(root.x+" ");
                        root=null;
                    }

           


                  }
        }while(!s.isEmpty());
    }
    

}

class TreeNode
{
    int x;
    int hd;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.x = x;
        this.hd = Integer.MAX_VALUE;
        this.left = null;
        this.right = null;
    }


}

class Node
{
    int s;
    Node left;
    Node right;

    public Node(int s) {
        this.s = s;
    }


}