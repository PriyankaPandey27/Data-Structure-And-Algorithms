/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PatternPrint;

/**
 *
 * @author admin
 */
public class SpiralPattern {

    public static void main(String[] args) {

        int x[][]={ {1,  2,  3,  4,  5,  6},
        {7,  8,  9,  10, 11, 12},
        {13, 14, 15, 16, 17, 18}};

        int r=x.length;
        int c=x[0].length;
        spiralPrint(r, c, x);

    }

    public static void spiralPrint(int row,int col,int m[][])
    {
        int r=0;
        int c=0;
        while(r<row && c<col)
        {
            for(int i=c;i<col;i++)
            {
                System.out.print(m[r][i] + " ");
            }
            r++;

            for(int i=r;i<row;i++)
            {
                System.out.print(m[i][col-1] + " ");
            }
            col--;

            if(r<row)
            {
                for(int i=col-1;i>=c;i--)
                {
                    System.out.print(m[row-1][i] + " ");
                }
                row--;
            }

            if(c<col)
            {
                for(int i=row-1;i>=r;i--)
                {
                    System.out.print(m[i][c]+ " ");
                }
                c++;
            }
        }
    }

}
