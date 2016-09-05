/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int a[]={11,13,21,34,3,2,4};
        findElement(a, a.length);
        
    }

    public static void findElement(int a[],int n)
    {
        if(a==null || n==0)
            return;

        Stack<Integer> s=new Stack<Integer>();
        int x=0;
        s.push(a[0]);
        for(int i=1;i<n;i++)
        {
            int next=a[i];
            if(!s.isEmpty())
            {
            int element=s.pop();

            while(element<next)
            {
                System.out.println( element + " " + next);
                if(s.isEmpty())
                    break;
                element=s.pop();

            }

            if(element>next)
             s.push(element);

            }

            s.push(next);
        }

        while(!s.isEmpty())
        {
            x=s.pop();
            System.out.println(x + " " + -1);
        }


    }

}
