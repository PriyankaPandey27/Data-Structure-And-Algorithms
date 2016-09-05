/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package microsoft;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class MximumSubMatrix {

    public static void main(String[] args) {

        int m[][]= {{0,  1,  1,  0,  1},{1,  1,  0,  1,  0},{ 0,  1,  1 ,1,  0},
                    { 1,  1,  1,  1,  0},{ 1,  1,  1,  1,  1},{ 0,  0,  0,  0,  0}};

        int k[][]={{0, 0, 0 ,0 ,1 ,0},{ 0, 0, 1, 0, 0, 1},{0, 0, 0 ,0 ,0 ,0},{1, 0, 0, 0, 0, 0},
        { 0 ,0 ,0 ,0 ,0 ,1},{ 0, 0, 1, 0, 0, 0}};

        int col=k[0].length;
        int row=k.length;
        //findMaxSubMatrix(m, row, col);
        findSubMatrix(k, row, col);
    }

    public static void findMaxSubMatrix(int m[][],int row,int col)
    {
        int temp[][]=new int[row][col];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<col;i++)
            temp[0][i]=m[0][i];
        for(int j=0;j<row;j++)
        {
            temp[j][0]=m[j][0];
        }

        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(m[i][j]==1)
                {
                    temp[i][j]=Math.min(temp[i][j-1], Math.min(temp[i-1][j-1], temp[i-1][j]))+1;
                }
                else
                {
                    temp[i][j]=0;
                }

                if(temp[i][j]>max)
                    max=temp[i][j];
            }
        }

        System.out.println("the value is " + max);

        for(int i=0;i<max;i++)
        {
            for(int j=0;j<max;j++)
            {
                System.out.print(1 + " ");
            }
            System.out.println("");
        }
    }


    // matrix when n not equal to m
    public static void findSubMatrix(int k[][],int row,int col)
    {
        int temp[][]=new int[row+1][col];
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<col;i++)
            temp[0][i]=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(k[i][j]==0)
                {
                    temp[i+1][j]=1+temp[i][j];
                }
                else
                {
                    temp[i+1][j]=0;
                }
            }
        }


        for(int i=0;i<row+1;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println("");
        }

        for(int i=1;i<row+1;i++)
        {
            int a[]=new int[col];
            for(int j=0;j<col;j++)
            {

                a[j]=temp[i][j];

            }
            int area=largestAreaRectangle(a);
            System.out.println("area is " + area);
            if(area>maxArea)
                maxArea=area;

        }

        System.out.println("maximum area is  " + maxArea);




    }


     public static int largestAreaRectangle(int a[])
    {
        Stack<Integer> s=new Stack<Integer>();
        if(a==null||a.length==0)
            return -1;

        int maxArea=Integer.MIN_VALUE;
        int area=0;int i;

        for(i=0;i<a.length;)
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

       return maxArea;


    }
  }