/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FkSetThirtyEight;

/**
 *
 * @author admin
 */
public class MatrixMove {


    public static void main(String[] args) {

        int m[][]={{1,2,9},{4,3,8},{5,6,7}};

        int row=m.length;
        int col=m[0].length;
        System.out.println("the steps travelled " +countSteps(m, row, col));

    }
    

    public static int countSteps(int m[][],int r,int c)
    {
        if(m==null)
            return -1;
        int row=r+1;
        int col=c+1;int count=1;
        int temp[][]=new int[row][col];
        boolean visited[][]=new boolean[row][col];
        for(int i=0;i< col;i++)
        {
            temp[0][i]=1;
            visited[0][i]=true;
        }

        for(int j=0;j<row;j++)
        {
            temp[j][0]=1;
            visited[j][0]=true;
        }
         int j=1;int i=1;

        while(i+1<row || j+1<col)
        {
               
                while(j+1<col&& !visited[i][j+1])
                {
                    System.out.println("inside frst " + " i " + i + " j " + (j+1));
                    count++;
                    visited[i][j+1]=true;
                    j++;
                    
                }
                while(i+1<row && !visited[i+1][j])
                {
                    System.out.println("inside scnd " + " i " + (i+1) + " j " + j);
                    count++;
                    visited[i+1][j]=true;
                    i++;
                    while(!visited[i][j-1])
                    {
                    System.out.println("inside third " + " i " + i + " j " + (j-1));
                    count++;
                    visited[i][j-1]=true;
                    j--;
                    }

//                 
                }
                
            
        }

        return count;

    }

}
