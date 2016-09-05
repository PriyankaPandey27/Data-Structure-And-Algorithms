/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class MinCost {

    public static void main(String[] args) {

        int m[][]={ {1,2,3},
                    {4,8,2},
                    {1,5,3}};

        printMatrix(m);

        int row=m.length;
        int col=m[0].length;
       // int d=naive(m,row,col);
       // System.out.println("the min cost is " + d);
        minCost_dp(m, row, col);


    }

    public static void printMatrix(int m[][])
    {
        int row=m.length;
        int col=m[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int naive(int m[][],int r,int c)
    {
        if(r<0||c<0)
            return Integer.MAX_VALUE;

        else if(r==0 && c==0)
            return m[r][c];
        else
            return m[r][c]+Math.min(naive(m,r-1,c-1), Math.min(naive(m,r,c-1), naive(m,r-1,c)));


    }


    public static void minCost_dp(int m[][],int r,int c)
    {
        int t[][]=new int[r][c];
        t[0][0]=m[0][0];

        for(int i=1;i<r;i++)
            t[i][0]= t[i-1][0]+m[i][0];
        for(int j=1;j<c;j++)
            t[0][j]= t[0][j-1]+m[0][j];

        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                t[i][j]=Math.min(t[i-1][j-1],Math.min(t[i][j-1],t[i-1][j]))+m[i][j];
            }
        }

        System.out.println("the min distance is " + t[r-1][c-1]);
    }

}
