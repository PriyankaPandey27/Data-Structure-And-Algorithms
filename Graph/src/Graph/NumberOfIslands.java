/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

/**
 *
 * @author admin
 */



public class NumberOfIslands {
    
    public static int row;
    public static int col;
    public static void main(String[] args) {
        
     int m[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
     row=m.length;
     col=m[0].length;
     
        System.out.println("the number of island is " + countIsland(m, row, col));
     
     
     
    }
    
    public static int countIsland(int m[][],int r,int c)
    {
        boolean visited[][]=new boolean[r][c] ;
        int count=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(m[i][j]==1 && !visited[i][j])
                {
                    dfs(m, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int m[][],int r,int c,boolean visited[][])
    {
        visited[r][c]=true;
        
        int rowNumber[]={-1,-1,-1,0,0,1,1,1};
        int colNumber[]={-1,0,1,-1,1,-1,0,1};
        
        for(int k=0;k<8;k++)
        {
            if(isSafe(m,r+rowNumber[k],c+colNumber[k],visited))
            {
                dfs(m,r+rowNumber[k],c+colNumber[k],visited);
            }
        }
    }
    
    public static boolean isSafe(int m[][],int r,int c,boolean visited[][])
    {
        if(r>=0 && r<row && c>=0 && c<col && m[r][c]==1 && !visited[r][c])
            return true;
        
        return false;
    }


}


