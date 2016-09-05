/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.HashMap;

/**
 *
 * @author admin
 */
 class VerticalSumTree {

    public static void main(String[] args) {


        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        verticalSumLL(root);

    }


    public static void verticalSumLL(Node root)
    {
        if(root==null)
        {
            System.out.println("no vertical sum");
            return;
        }
        DLLnode node=new DLLnode(0);
        verticalSumLLUtil(root, node);

        while(node.prev!=null)
        {
            node=node.prev;
        }

        while(node!=null)
        {
            System.out.print(node.d+" ");
            node=node.next;
        }

    }

    public static void verticalSumLLUtil(Node root,DLLnode n)
    {
        n.d=n.d+root.data;
        System.out.println("dll node "+ n.d);
        if(root.left!=null)
        {
            if(n.prev==null)
            {
                n.prev=new DLLnode(0);
                n.prev.next=n;
            }
        verticalSumLLUtil(root.left, n.prev);
        }

        if(root.right!=null)
        {
            if(n.next==null)
            {
                n.next=new DLLnode(0);
                n.next.prev=n;
            }
            verticalSumLLUtil(root.right, n.next);
        }
    }

    public static void verticalSum(Node root)
    {
        if(root==null)
            return;

        HashMap<Integer,Integer> h =new HashMap<Integer,Integer>();

        findVertcalSum(root, 0, h);

        if(h!=null)
            System.out.println(h.entrySet());


    }

    public static void findVertcalSum(Node root,int hd,HashMap<Integer,Integer> h)
    {
        if(root==null)
            return;

        findVertcalSum(root.left, hd-1, h);
        int prevSum=(h.get(hd)==null)?0:h.get(hd);
        h.put(hd, prevSum+root.data);

        findVertcalSum(root.right, hd+1, h);
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

class DLLnode
{
    int d;
    DLLnode next;
    DLLnode prev;

    public DLLnode(int d) {
        this.d = d;
        this.prev=null;
        this.next=null;
    }

    
}