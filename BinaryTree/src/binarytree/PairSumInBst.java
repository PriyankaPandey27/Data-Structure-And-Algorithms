/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.Stack;

/**
 *
 * @author admin
 */
 class PairSumInBst {

    public static void main(String[] args) {

        Node root =  new Node(15);
    root.left = new Node(10);
    root.right = new Node(20);
    root.left.left = new Node(8);
    root.left.right = new Node(12);
    root.right.left = new Node(16);
    root.right.right = new Node(25);
    int sum=33;
    
    findPair(root, sum);


    }


    //time complexity O(n) & space (log(n))

    public static boolean findPair(Node root,int sum)
    {
        if(root==null)
            return false;

        Stack s1=new Stack();
        Stack s2=new Stack();

        boolean done1=false;
        boolean done2=false;
        int val1=0;int val2=0;
        Node cur1=root;
        Node cur2=root;

        while(true)
        {
            while(done1==false)
            {
                if(cur1!=null)
                {
                    s1.push(cur1);
                    cur1=cur1.left;
                }
                else
                {
                    if(s1.isEmpty())
                        done1=true;
                    else
                    {
                        cur1=(Node)s1.pop();
                        val1=cur1.data;
                        cur1=cur1.right;
                        done1=true;
                    }
                }
            }

            while(done2==false)
            {
                if(cur2!=null)
                {
                    s2.push(cur2);
                    cur2=cur2.right;
                }
                else
                {
                    if(s2.isEmpty())
                        done2=true;
                    else
                    {
                        cur2=(Node)s2.pop();
                        val2=cur2.data;
                        cur2=cur2.left;
                        done2=true;
                    }
                }
            }

            if((val1!=val2) && val1+val2==sum)
            {
                System.out.println("the pairs are " + val1 +" ," + val2);
                return true;
            }

            else if(val1+val2<sum)
            {
                done1=false;
            }
            else
                done2=false;

            if(val1>=val2)
                return false;

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
