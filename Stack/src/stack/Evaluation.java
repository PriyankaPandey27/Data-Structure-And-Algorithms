/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class Evaluation {
    public static void main(String args[])
    {
    FixEvaluation of=new FixEvaluation();
    String s="123*+5-";
    int res=of.postfixEvaluation(s);
        System.out.println("postfix evaluation is " + res);
    
    }
    


}

class FixEvaluation
{
    public int postfixEvaluation(String s)
    {
    Stack<Integer> p=new Stack<Integer>();
     for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)=='+')
             {
                 int op1=p.pop();
                 int op2=p.pop();
                 int r=op1+op2;
                 p.push(r);
             }
             else if(s.charAt(i)=='*')
             {
                 int op1=p.pop();
                 int op2=p.pop();
                 int r=op1*op2;
                p.push(r);
             }
             else if(s.charAt(i)=='-')
             {
                 int op1=p.pop();
                 int op2=p.pop();
                 int r=op2-op1;
                 p.push(r);
             }
             else if(s.charAt(i)=='/')
             {
                 int op1=p.pop();
                 int op2=p.pop();
                 int r=op2/op1;
                 p.push(r);
             }
             else
             {
                 if(s.charAt(i)>='0' && s.charAt(i)<='9')
                 {
                 p.push((int)(s.charAt(i)-'0'));
                 }
             }
         }
         return p.pop();
     }

}
