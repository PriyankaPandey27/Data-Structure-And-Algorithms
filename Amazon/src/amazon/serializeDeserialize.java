/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
class serializeDeserialize {
    
    public static ArrayList<Integer> list=new ArrayList<Integer>();
    public static int index=0;

    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        serialise(root);
        System.out.println(list.toString());
        Node p=deserialize();
        rInorer(p);
    }

    public static void rInorer(Node r)
    {
        if(r==null)
            return;
        rInorer(r.left);
        System.out.print(r.data+ " ");
        rInorer(r.right);
    }
    public static void serialise(Node root)
    {
        if(root==null)
        {
            list.add(-1);
            return;
        }
        list.add(root.data);
        serialise(root.left);
        serialise(root.right);
    }

    public static Node deserialize()
    {
        if(index==list.size()||list.get(index)==-1)
        {
            index++;
            return null;
        }
        
        //System.out.println("i  " + i);
        Node root=new Node(list.get(index));
        index++;
        root.left=deserialize();
        root.right=deserialize();
        return root;

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
