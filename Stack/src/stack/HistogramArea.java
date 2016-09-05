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
public class HistogramArea {

    public static void main(String[] args) {

        int a[]={6, 2, 5, 4, 5, 1, 6};
        largestAreaRectangle(a);

    }

    public static void largestAreaRectangle(int a[])
    {
        Stack<Integer> s=new Stack<Integer>();
        if(a==null||a.length==0)
            return;

        int maxArea=Integer.MIN_VALUE;
        int area=0;int i=0;

        while(i<a.length)
        {
            if(s.isEmpty()||(a[s.peek()]<=a[i]))
                s.push(i++);
            else
            {
                int top=s.pop();
                if(s.isEmpty())
                {
                    area=i*a[top];
                }
                else
                {
                    area=a[top]*(i-s.peek()-1);
                }

                if(area>maxArea)
                    maxArea=area;
            }
        }

        while(!s.isEmpty())
        {
            int top=s.pop();
                if(s.isEmpty())
                {
                    area=i*a[top];
                }
                else
                {
                    area=a[top]*(i-s.peek()-1);
                }

                if(area>maxArea)
                    maxArea=area;

        }

        System.out.println("the maximum area is " + maxArea);


    }

}
