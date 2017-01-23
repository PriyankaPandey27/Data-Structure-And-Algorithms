/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class ShortestDistBank {

    public static int row[]={-1,0,1,0};
    public static int col[]={0,1,0,-1};
    public static int R;
    public static int C;



    public static void main(String[] args) {

         char matrix[][] = {
        {'O', 'O', 'O', 'O', 'G'},
        {'O', 'W', 'W', 'O', 'O'},
        {'O', 'O', 'O', 'W', 'O'},
        {'G', 'W', 'W', 'W', 'O'},
        {'O', 'O', 'O', 'O', 'G'}
    };
         int n=matrix.length;
         R=n-1;
         C=matrix[0].length-1;

         findDist(matrix);

    }


    public static boolean isValid(int i,int j)
    {
        if((i<0 || i>R) || (j<0 || j>C))
            return false;

        return true;

    }

    public static boolean isSafe(int i,int j,char m[][],int out[][])
    {
        if(m[i][j]!='O' || out[i][j]!=-1)
            return false;

        return true;
    }

    public static void findDist(char m[][])
    {
        int out[][]=new int[R+1][C+1];
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        for(int i=0;i<=R;i++)
        {
            for(int j=0;j<=C;j++)
            {
                out[i][j]=-1;
                if(m[i][j]=='G')
                {
                    QueueNode pos=new QueueNode(i, j, 0);
                    q.add(pos);
                    out[i][j]=0;
                }
            }
        }
        

        while(!q.isEmpty())
        {
            QueueNode curr=q.remove();
            int x=curr.x;
            int y=curr.y;
            int d=curr.dist;

            for(int i=0;i<4;i++)
            {
               //System.out.println("row addded " + x+row[i] + "col added " + y+col[i]);
                if(isValid(x+row[i], y+col[i]) && isSafe(x+row[i], y+col[i], m, out))
                {
                    out[x+row[i]][y+col[i]]=d+1;

                    QueueNode pos=new QueueNode(x+row[i], y+col[i], d+1);
                    q.add(pos);
                   
                }
            }
            
        }


        for(int i=0;i<=R;i++)
        {
            for(int j=0;j<=C;j++)
            {
                System.out.print(out[i][j] + " ");
            }
            System.out.println("");
        }
    }



}


class QueueNode{

    int x;
    int y;
    int dist;

    public QueueNode(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }


}
