/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class OptimalBST {

    public static void main(String[] args) {

        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        System.out.println(optimalBinarySearchTree(keys, freq));
    }

    public static int optimalBinarySearchTree(int input[],int freq[])
    {
        if(input==null || input.length==0 ||freq==null ||freq.length==0)
            return -1;

        int T[][] = new int[input.length][input.length];

        for(int i=0; i < T.length; i++){
            T[i][i] = freq[i];
        }

        for(int l = 2; l <= input.length; l++){
            for(int i=0; i <= input.length-l; i++){
                int j = i + l -1;
               // System.out.println("i " + i + " j "+ j);
                T[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i, j);

                for(int k=i; k <= j; k++){
                   System.out.println("k " + k + " j "+ j);
                     int val = sum + (k-1 < i ? 0 : T[i][k-1]) +
                            (k+1 > j ? 0 : T[k+1][j]) ;
                     System.out.println("val  " + val);
                     if(val < T[i][j]){
                         T[i][j] = val;
                     }
                }
            }
        }
        return T[0][input.length-1];
    }

    public static int getSum(int freq[],int i,int j)
    {
        int s=0;
        for(int k=i;k<=j;k++)
        {
            s+=freq[k];
        }
        return s;
    }

}
