/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class NumberOfPaths {

    public static void main(String[] args) throws UnsupportedEncodingException
    {
        System.out.println(PossiblePaths(3, 3));
    }

   public static int countPath(int m,int n)
    {
        
        int count[][]=new int[m][n];
        for (int i = 0; i < m; i++)
        count[i][0] = 1;

    // Count of paths to reach any cell in first column is 1
    for (int j = 0; j < n; j++)
        count[0][j] = 1;

        for (int i = 1; i < m; i++)
    {
        for (int j = 1; j < n; j++)

            // By uncommenting the last part the code calculatest he total
            // possible paths if the diagonal Movements are allowed
            count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];

    }
    return count[m-1][n-1];
    }


   public static int PossiblePaths(int m,int n){
	int Table[][]=new int[m+1][n+1];
	int i,j;

	for(i=0;i<=m; i++){
		Table[i][0] =1;
	}
	for(i=0;i<=n; i++){
		Table[0][i] =1;
	}
	for(i=1; i<=m; i++ ){
		for(j=1; j<=n; j++){
			Table[i][j] = Table[i-1][j] + Table[i][j-1] + Table[i-1][j-1];
                       // System.out.println("table " + Table[i][j]);
		}
	}
	return Table[m][n];
}


}
