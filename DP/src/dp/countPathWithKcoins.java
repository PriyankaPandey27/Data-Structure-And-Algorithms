/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class countPathWithKcoins {
    
    public static int dp[][][];
    public static int max_k=1000;

    public static void main(String[] args) {

        int m[][]={{1, 2, 3},
                    {4, 6, 5},
                    {3, 2, 1}};

        int r=m.length;
        int c=m[0].length;
        int k=12;

        System.out.println("the total path is  " + countPathWithK(m,r,c,k));


    }

    public static int countPathWithK(int m[][],int r,int c,int k)
    {
        dp=new int[r+1][c+1][max_k];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                for(int l=0;l<max_k;l++)
                {
                    dp[i][j][l]=-1;
                }
            }
        }
        return countPath(m,r-1,c-1,k);
    }

    public static int countPath(int m[][],int r,int c,int k)
    {
        if(r<0||c<0)
            return 0;

        if(r==0 && c==0)
            return (k=m[r][c]);

        if(dp[r][c][k]!=-1)
            return dp[r][c][k];

        dp[r][c][k]=countPath(m, r-1, c, k-m[r][c])+countPath(m, r, c-1, k-m[r][c]);
        return dp[r][c][k];

    }

}
