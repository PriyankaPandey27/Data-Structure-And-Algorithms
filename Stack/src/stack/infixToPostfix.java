/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

import java.util.Stack;
import sun.security.krb5.internal.KDCOptions;

/**
 *
 * @author admin
 */
public class infixToPostfix {

    public static void main(String[] args) {


    String s = "a+b*(c^d-e)^(f+g*h)-i";
    char exp[]=s.toCharArray();
    char p[]=new char[exp.length];
    infixToPostfix(exp,p);
        System.out.println(p);
    }

    public static boolean isOperand(char ch)
    {
        return (ch>='a' && ch<='z')||(ch>='A' && ch<='Z');
    }

    public static int prec(char s)
    {
        switch(s)
        {
            case '+':
            case '-':
               return 1;

            case '*':
            case '/':
             return 2;

            case '^':
                return 3;

        }
        return -1;
    }

    public static void infixToPostfix(char exp[],char p[])
    {
        Stack<Character> s=new Stack<Character>();
        int i,k;
        for(i=0,k=-1;i<exp.length;i++)
        {
            if(isOperand(exp[i]))
            {
                p[++k]=exp[i];
            }

            else if(exp[i]=='(')
            {
                s.push(exp[i]);
            }
            else if(exp[i]==')')
            {
                while(!s.isEmpty() && s.peek()!='(')
                {
                    p[++k]=s.pop();
                }
                if(!s.isEmpty() && s.peek()!='(')
                    return;
                else
                    s.pop();
            }
            else
            {
                while(!s.isEmpty() && prec(exp[i])<=prec(s.peek()))
                    p[++k]=s.pop();

                s.push(exp[i]);
            }
        }

        while(!s.isEmpty())
        {
            p[++k]=s.pop();
        }
       // p[++k]='\0';

    }

}
