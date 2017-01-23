/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class MinCostPath {
    
    public static int row;
    public static int col;

    public static void main(String[] args) {
        int grid[][] = { {31, 100, 65, 12, 18},
        {10, 13, 47, 157, 6},
        {100, 113, 174, 11, 33},
        {88, 124, 41, 20, 140},
        {99, 32, 111, 41, 20} };
        row=grid.length;
        col=grid[0].length;

        shortestDistPath(grid);
    }

    public static boolean isInGrid(int i,int j)
    {
        if(i>=0 && i<row && j>=0 && j<col)
            return true;

        return false;
    }

    public static void shortestDistPath(int g[][])
    {
        int d[][]=new int[row][col];
        boolean f[][]=new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                d[i][j]=Integer.MAX_VALUE;
            }
        }
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};

        Queue<Cell> q=new LinkedList<Cell>();
        q.add(new Cell(0, 0, 0));
        d[0][0]=g[0][0];
        f[0][0]=true;


        while(!q.isEmpty())
        {
            Cell k=q.remove();
            Cell arr[]= new Cell[4];
            for(int i=0;i<4;i++)
            {
                if(isInGrid(k.x+x[i], k.y+y[i]) && !f[k.x+x[i]][k.y+y[i]])
                arr[i]=new Cell(k.x+x[i],k.y+y[i],g[k.x+x[i]][k.y+y[i]]);
                else
                    arr[i]=new Cell(k.x+x[i],k.y+y[i],Integer.MAX_VALUE);
            }
             int minVal=arr[0].dist ;
              int tx=arr[0].x;
              int ty=arr[0].y;
            for(int i=0;i<arr.length-1;i++)
            {
              //  System.out.println("array " + arr[i].dist);
              
                
               if(minVal>arr[i+1].dist)
               {
                 tx=arr[i+1].x;
                 ty=arr[i+1].y;
                 minVal=arr[i+1].dist;
               }
             }
               System.out.println("min " + minVal + " x " + tx + " y " + ty );
               if(minVal+d[k.x][k.y]<d[tx][ty])
                {
                        d[tx][ty]=minVal+d[k.x][k.y];
                        System.out.println("final d " + d[tx][ty]);
                        f[tx][ty]=true;
                        q.add(new Cell(tx,ty,d[tx][ty]));
                }
                

        }

        System.out.println("the shortest distance is " + d[row-1][col-1]);


    }

    


}


class Cell{

    int x;
    int y;
    int dist;

    public Cell(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}