/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author admin
 */
public class stackAsLL {
    public static void main(String args[])
    {
        LL ob=new LL();
        LL S2=new LL();
       
        //int g=Integer.MAX_VALUE;

         int[] input={6,3,4,5,2};
//       int index=ob.removeDuplicate(input);
//        for(int j=0;j<=index;j++)
//        {
//            System.out.println(input[j]);
//        }
         //ob.largestRect(input);
        ob.spanMax(input);
       // ob.display();
       // ob.palindromStack(S);
//        ob.push(6);
//        ob.push(21);
//        ob.push(12);
//        ob.push(3);
//        ob.push(8);
//        ob.display("stack is given as");
//       ob.displaySortStack(ob, S2);
//
//        ob.display("sorted stack is given as ");
////
//        ob.display("the stack is given as");
//        ob.pop();
//        ob.pop();
//        //ob.display();
//        ob.getminimum();
    }

}



class LL{
    Node start;
    Node minstart;
   // Node newstart;
    
    public void getminimum()
    {
        System.out.println("minimum element is :"+ minstart.data);
    }

    public void palindrome(String S)
    {
        char a[]=S.toCharArray();
        int i=0,j=a.length-1;
        System.out.println(j);
        while(i<j && a[i]==a[j])
        {
            i++;
            j--;

        }
        if(i>j)
        {
            System.out.println("string is not palindrome");
        }
        else
        {
            System.out.println("string is palindrome");
        }
    }

    public int top()
    {
        Node temp=start;
        return temp.data;
    }

    public void palindromStack(String S)
    {
        char r[]=S.toCharArray();
        int l=r.length;
        //System.out.println(l);
        for(int i=0;i<l;i++)
        {
            pushChar(S.charAt(i));
        }
        int j=0;
       // Node temp=start;
        while(start!=null)
        {
            if(start.p==r[j])
            {
                popChar();
                j++;
            }
            else
            {
                break;
            }

        }
       // System.out.println(temp.p);
        if(start==null)
        {
            System.out.println("palindrome");
        }
        else
        {
            System.out.println("not palindrome");
        }
    }

    public int removeDuplicate(int arry[])
    {
        int s=-1;
        int i =0;
        while(i < arry.length)
        {
            if(s==-1||arry[s]!=arry[i])
            {
                s++;
                arry[s]=arry[i];
                i++;
            }
            else
            {
                while(i<arry.length && arry[s]==arry[i])
                {
                    i++;
                    s--;
                }
            }

        }
        return s;
    }

    //calculating span
    public void span(int[] inputArry)
    {
        int[] spans=new int[inputArry.length];
        for(int i=0;i<spans.length;i++)
        {
            int s=1;
            int j=i-1;
            while(j>=0 && inputArry[j]<=inputArry[j+1])
            {
                s++;
                j--;
            }
            spans[i]=s;
        }
        for(int k=0;k<spans.length;k++)
        {
            System.out.println(spans[k]);
        }

    }

    public void spanMax(int[] inputArry)
    {
        int[] spans=new int[inputArry.length];
        int p=0;
        for(int i=0;i<spans.length;i++)
        {
            if(start!=null && inputArry[i]>inputArry[top()])
                 pops();
            
             
            if(start!=null)
            {
                p=top ();
                //System.out.println("the value of p:"+ p);
            }
            else
            {
               p=-1 ;
            }
            System.out.println("the value of p:"+ p);
            spans[i]=i-p;
            push(i);
        }
      
         for(int k=0;k<spans.length;k++)
        {
            System.out.println(spans[k]);
        }
    }


    public void largestRect(int[] input)
    {
        if(input==null||input.length==0)
            return;
        int maxArea=0;
        int i=0;
        while(i<input.length)
        {
            if(isEmpty()||input[top()]<=input[i])
                push(i++);
            else
            {
                int p=pop();
                maxArea=Math.max(maxArea, input[p]*(isEmpty()?i:i-top()-1));
                System.out.println("area inside frst while " + maxArea);

            }
        }
        while(!isEmpty())
        {
            int t=pop();
            maxArea=Math.max(maxArea, input[t]*(isEmpty()?i:i-top()-1));
            System.out.println("area inside 2 while " + maxArea);
        }
        System.out.println("maximum area is " + maxArea);

    }
    public boolean isEmpty()
    {
        if(start==null)
        {
            return true;
        }
        else
            return false;
    }

    public Node sortStack(LL S,LL A)
    {
        while(!S.isEmpty())
        {
            int tmp=pop();
            while(!A.isEmpty() && A.top()>tmp)
            {
                S.push(A.pop());
                
            }
            A.push(tmp);
        }
       return A.start;
    }
    public void displaySortStack(LL S,LL A)
    {
        start=sortStack(S,A);
    }

    public int pops()
    {
      //  System.out.println("POPPED ELEMENT"+ start.data);
        Node temp=start;
        start=start.next;
        return temp.data;
    }


    
    public void push(int x)
    {
        Node temp;
        Node tmp;
        if(start==null)
        {
            start=new Node(x,start);
            minstart=new Node(x,minstart);
        }
        else
        {
            temp=new Node(x,start);
            //temp=new Node(x,start);
           // temp.next=start;
            
            
            if(start.data>x)
            {
                tmp=new Node(x);
                tmp.next=minstart;
                minstart=tmp;
            }
            start=temp;
        }
    }

    




   // sorting stack in ascending order
//    public void push2(int x)
//    {
//        Node temp=newstart;
//        if(newstart==null)
//        {
//            newstart=new Node(x,newstart);
//        }
//        else
//        {
//            temp=new Node(x);
//            temp.next=newstart;
//            newstart=temp;
//        }
//    }
//    public void pop2()
//    {
//
//        newstart=newstart.next;
//    }

//    public int top2()
//    {
//        Node temp=newstart;
//        return temp.data;
//    }

    public void pushChar(char a)
    {
       // Node temp=start;
        if(start==null)
        {
            start=new Node(a,start);
        }
        else
        {
           Node temp=new Node(a,start);
          // temp.next=start;
           start=temp;

        }
    }

    public void popChar()
    {
       
            //System.out.println("popped element is"+ start.p);
            start=start.next;
        
    }
    
    public int pop()
    {
        if(start==null)
        {
            return 0;
        }
        else
        {
           // System.out.println("the popped element is :"+ start.data);
//            if(minstart.data == start.data)
//            {
//                start=start.next;
//                minstart=minstart.next;
//            }
//            else
//            {
//                start=start.next;
//            }
            Node temp=start;
            start=start.next;
            return temp.data;
        }
                
    }
    
    public void display(String s)
    {
        System.out.println(s);
        if(start==null)
        {
            System.out.println("empty stack");
        }
        else
        {
        Node temp=start;
       while(temp!=null)
             {
             System.out.println(temp.data);
             temp=temp.next;
             }
        }
    }


    }


class Node{
    public int data;
    public char p;
    public Node next;

    public Node(int x,Node next)
    {
        this.data=x;
        this.next=next;
    }

//      public Node(char x,Node next)
//    {
//        this.p=x;
//        this.next=next;
//    }
    public Node(int x)
    {
        this.data=x;

    }

    public void setnext(Node newnext)
    {
        next=newnext;
    }

    public int getdata()
    {
        return data;
    }
}

