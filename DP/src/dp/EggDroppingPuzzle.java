/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class EggDroppingPuzzle {

    public static void main(String[] args) {

        eggDropping(2, 36);
        


    }

    public static void eggDropping(int n,int k)
    {
        int m[][]=new int[n+1][k+1];
        for(int i=1;i<=n;i++)
        {
            m[i][1]=1;
            m[i][0]=0;
        }
        for(int i=1;i<=k;i++)
        {
            m[1][i]=i;
        }


        for(int i=2;i<=n;i++)
        {
            for(int j=2;j<=k;j++)
            {
                m[i][j]=Integer.MAX_VALUE;
                for(int b=1;b<=j;b++)
                {
                int res=1+Math.max(m[n-1][b-1], m[n][j-b]);
                if(res<m[i][j])
                    m[i][j]=res;
                }

            }
        }

        System.out.println("the minimum trial required is " + m[n][k]);
    }

}
