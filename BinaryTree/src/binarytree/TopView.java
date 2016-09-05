/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class TopView {

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        TopViewOfTree r=new TopViewOfTree(root);
        r.topView(root);
    }

}

class TopViewOfTree{

    TreeNode root;

    public TopViewOfTree(TreeNode r) {
        this.root = r;
    }


    public void topView(TreeNode root)
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
            if(!h.containsKey(hd))
            {
            h.put(hd, temp.x);
                System.out.print(temp.x + " ");
            }
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
//        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
//           System.out.print(entry.getValue() + " " );
//    }
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

