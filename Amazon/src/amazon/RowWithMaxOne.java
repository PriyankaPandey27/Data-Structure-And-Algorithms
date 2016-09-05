/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class RowWithMaxOne {

    public static void main(String[] args) {

        int m[][]={ {0, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };

        int r=m.length;
        int c=m[0].length;

        System.out.println("the row number is " + returnRowNumber(r, c, m));

    }

    public static int returnRowNumber(int row,int col,int m[][])
    {
        int index=-1;
        int max=Integer.MIN_VALUE;
        int maxRow=Integer.MIN_VALUE;
        for(int i=0;i<row;i++)
        {
            index=binarySearch(m[i], 0, col-1);
            if(index!=-1 && col-index>max)
            {
                max=col-index;
                maxRow=i;
            }
        }

        return maxRow;
    }

    public static int binarySearch(int a[],int l,int h)
    {
        if(l<=h)
        {
            int m=l+(h-l)/2;

            if((m==0||a[m-1]==0) && a[m]==1)
                return m;

            if(a[m]==0)
                return binarySearch(a, m+1, h);
            else
                return binarySearch(a, l, m-1);
        }
        return -1;
    }



}
