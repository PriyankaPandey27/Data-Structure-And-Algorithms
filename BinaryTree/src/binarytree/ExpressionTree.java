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
 class ExpressionTree {

    public static void main(String[] args) {

        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root =constructTree(charArray);
        System.out.println("infix expression is");
        rInorder(root);

    }

    public static void rInorder(Node root)
    {
        if(root!=null)
        {
            rInorder(root.left);
            System.out.print(root.data + " ");
            rInorder(root.right);
        }
    }

    public static boolean isOperator(char c)
    {
        if(c=='+' || c=='-' || c=='*' || c=='^' || c=='/')
            return true;

        return false;
    }

    public static Node constructTree(char[] postfix)
    {
        Stack st=new Stack();
        Node t;
        Node rightChild;
        Node leftChild;
        for(int i=0;i<postfix.length;i++)
        {
            if(!isOperator(postfix[i]))
            {
                t=new Node(postfix[i]);
                st.push(t);
            }
            else
            {
                t=new Node(postfix[i]);
                rightChild=(Node)st.pop();
                leftChild=(Node)st.pop();

                t.left=leftChild;
                t.right=rightChild;

                st.push(t);
            }
        }

        t=(Node)st.peek();

        return t;


    }

}

class Node
{
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }


}
