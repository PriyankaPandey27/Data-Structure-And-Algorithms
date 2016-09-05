/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author admin
 */
public class stackAsArray {

    public static void main(String args[])
    {
       // System.out.println("a="+ Integer.MAX_VALUE);
        ArrayWithThreeStack ob=new ArrayWithThreeStack(8);
//        ob.push(false, true, 10);
//         ob.push(false, true, 11);
//          ob.push(false, true, 12);
//           ob.push(false, true, 13);
//            ob.push(false, true, 14);
//             ob.push(false, true, 15);
//             ob.push(false, true, 16);
//              ob.push(false, true, 17);
//              ob.push(false, true, 18);
//              ob.push(false, true, 19);



        ob.push(false, true, 11);
        ob.push(true, false, 12);
        ob.push(false, true, 13);
        ob.push(true, false, 14);
        ob.push(true, false, 15);
        ob.push(true, false, 16);

        ob.display();
//        ob.pop(true, false);
//        ob.display();
      // ob.top(true, false);
//        ob.push3(true,false,false,10);
//        ob.push3(false,true,false,11);
//        ob.push3(false,false,true,12);
//        ob.push3(false,true,false,13);
//        ob.push3(true,false,false,14);
//        ob.push3(false,false,true,15);
//        ob.push3(true,false,false,16);
//        ob.push3(false,true,false,17);
//        ob.display();
    }

}

class ArrayWithThreeStack{
    int[] dataArry;
    int size;
    int topstack1;
    int topstack2;
    int topstack3;
    int basethree;

    public ArrayWithThreeStack(int size)
    {
        if(size<2)
        {
            System.out.println("this size is not permissible");
        }
        else
        {
            dataArry=new int[size];
            this.size=size;
            topstack1=-1;
            topstack2=size;
            basethree=size/3+1;
            topstack3=basethree;
        }

    }

    public void push(boolean stack1,boolean stack2,int x)
    {
        if(topstack2!=(topstack1+1))
        {
            if(stack1==true && stack2==false)
            {
                dataArry[++topstack1]=x;
               // topstack1++;
            }
            else if(stack1==false && stack2==true)
            {
                dataArry[--topstack2]=x;
                //topstack2--;
            }

            
        }
        else
        {
            System.out.println("stack overlapps");
        }
       // display();
    }

    //pushing into three stack

    public void push3(boolean stack1,boolean stack2,boolean stack3,int x)
    {
        if(stack1)
        {
            if(topstack1+1==basethree)
            {
                if(stack3Rightshiftable())
                {
                    stack3RightShift();
                    dataArry[++topstack1]=x;
                }
                else
                {
                    System.out.println("stack1 reached its highest limit");
                }
            }
            else
            {
                dataArry[++topstack1]=x;
            }
        }

        else if(stack2)
        {
            if(topstack2-1==topstack3)
            {
                if(stack3LeftShiftable())
                {
                    stack3LeftShift();
                    dataArry[--topstack2]=x;
                }
                else
                {
                    System.out.println("stack 2 reached its highest limit");
                }
            }
            else
            {
                dataArry[--topstack2]=x;
            }
        }

        else if( stack3)
        {
            if(topstack2-1==topstack3)
            {
                if(stack3LeftShiftable())
                {
                    stack3LeftShift();
                    dataArry[++topstack3]=x;
                }
                else
                {
                    System.out.println("stack3 has reached its max limit");
                }
            }
            else
            {
                dataArry[++topstack3]=x;
            }
        }
    }

    //popping from three stack

    public void pop(boolean stack1,boolean stack2,boolean stack3)
    {
        if(stack1==true && stack2==true && stack3==true)
        {
            if(topstack1==-1)
            {
                System.out.println("stack 1 is empty");
            }
            else if(topstack2==size)
            {
                System.out.println("stack 2 is empty");
            }
            else if(topstack3==size && dataArry[topstack3]==0)
            {
                System.out.println("stack 3 is empty");
            }
            else
            {
                int pop=dataArry[topstack1];
                dataArry[topstack1--]=0;
                int pop2=dataArry[topstack2];
                dataArry[topstack2++]=0;
                int pop3=dataArry[topstack3];
                if(topstack3>basethree)
                    dataArry[topstack3--]=0;
                if(topstack3==basethree)
                    dataArry[topstack3]=0;

            }
        }
    }

    public void top( boolean stack1,boolean stack2)
    {
        if(stack1==true && stack2==false)
        {
            if(topstack1==-1)
            {
                System.out.println("first stack is empty");
            }
            else
            {
            System.out.println("the top element for stack1 is: "+ dataArry[topstack1]);
            }
        }
        else if(stack1==false && stack2==true)
        {
            if(topstack2==size)
            {
                System.out.println("second stack is empty");
            }
            else
            {
            System.out.println("the top element for stack2 is: "+ dataArry[topstack2]);
            }
        }
        else if(stack1==true && stack2==true)
        {

            if(topstack1==-1 && topstack2==size)
            {
                System.out.println("both the stacks are empty");
            }
            else
            {
             System.out.println("the top element for stack1 is: "+ dataArry[topstack1]);
             System.out.println("the top element for stack2 is: "+ dataArry[topstack2]);
            }
        }
    }

    public void pop(boolean stack1,boolean stack2)
    {
        if(stack1==true && stack2==false)
        {
            if(topstack1==-1)
            {
                System.out.println("first stack is empty");
            }
            else
            {
             int pop=dataArry[topstack1];
             dataArry[topstack1--]= 0;
            System.out.println("the popped element for stack1 is: "+ pop);
            }
        }
        else if(stack1==false && stack2==true)
        {
            if(topstack2==size)
            {
                System.out.println("second stack is empty");
            }
            else
            {
             int pop=dataArry[topstack2];
             dataArry[topstack2--]= 0;
            System.out.println("the popped element for stack2 is: "+ pop);
            }
        }
        else if(stack1==true && stack2==true)
        {

            if(topstack1==-1 && topstack2==size)
            {
                System.out.println("both the stacks are empty");
            }
            else
            {
             int pop1=dataArry[topstack1];
             dataArry[topstack1--]= 0;
             int pop2=dataArry[topstack2];
             dataArry[topstack2--]= 0;
             System.out.println("the popped element for stack1 is: "+ pop1);
             System.out.println("the popped element for stack2 is: "+ pop2);
            }
        }

    }

    // implementation of the third stack

    private void stack3RightShift()
    {
        for(int i=topstack3+1;i>=basethree+1;i--)
        {
            dataArry[i]=dataArry[i-1];
        }
        dataArry[basethree++]=Integer.MAX_VALUE;
        topstack3++;
    }

    private void stack3LeftShift()
    {
        for(int i=basethree-1;i<=topstack3-1;i++)
        {
            dataArry[i]=dataArry[i+1];
        }
        dataArry[topstack3--]=Integer.MAX_VALUE;
        basethree--;
    }

    private boolean stack3Rightshiftable()
    {
        if(topstack2>topstack3+1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean stack3LeftShiftable()
    {
        if(topstack1+1 < basethree)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void display()
    {
        for(int i=0;i<=topstack1;i++)
        {
            System.out.println(dataArry[i]);
        }
        System.out.println("stack2 comes as");
        for(int j=topstack2;j<=size-1;j++)
        {
            System.out.println(dataArry[j]);
        }
    }
}
