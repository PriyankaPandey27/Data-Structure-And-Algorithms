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


}
