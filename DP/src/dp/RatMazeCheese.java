/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class RatMazeCheese {
    public static int row;
    public static int col;

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        row=maze.length;
        col=maze[0].length;

        System.out.println(Paths(0, 0, maze));

    }

    public static boolean isSafe(int i,int j,int m[][])
    {
        if(i>=0 && i<row && j>=0 && j<col && m[i][j]==1)
            return true;

        return false;
    }

    public static int Paths(int i,int j,int m[][])
    {
        

        if(i==row-1 && j==col-1)
            return 1;
       if(isSafe(i, j, m))
       {
        m[i][j]=1;

        return Paths(i+1, j, m)+Paths(i-1, j, m)+Paths(i, j+1, m)+Paths(i, j-1, m);
       

       }
        m[i][j]=0;
       // return 0;



       
        
    }



}
