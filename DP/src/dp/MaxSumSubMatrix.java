/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubRectangularMatrixWithMaximumSum.java
//KADEN'S Algorithm

package dp;

/**
 *
 * @author admin
 */
class MaxSumSubMatrix {


    public static void main(String[] args) {

        int input[][] = {{1, 2, -1, -4, -20},
                       {-8, -3, 4, 2, 1},
                       {3, 8, 10, 1, 3},
                       {-4, -1, 1, 7, -6}
                      };
        maxSumMatrix(input);
        //System.out.println("the sum is " + maxSum(input));

    }

    public static void maxSumMatrix(int m[][])
    {
        int row=m.length;
        int col=m[0].length;
        int result[]=new int[3];
        int left=0;
        int top=0;
        int right=0;
        int bottom=0;
        int maxsum=Integer.MIN_VALUE;
        for(int leftCol=0;leftCol<col;leftCol++)
        {
            int temp[]=new int[row];
            for(int rightCol=leftCol;rightCol<col;rightCol++)
            {

                for(int i=0;i<row;i++)
                {
                    temp[i]+=m[i][rightCol];
                }

                result=Kadane2(temp);
                if(result[0]>maxsum)
                {
                    maxsum=result[0];
                    left=leftCol;
                    top=result[1];
                    right=rightCol;
                    bottom=result[2];
                }
            }
        }

        System.out.println("max sum " + maxsum + "range : ( " + left + "," + top + ") and (" + right + "," + bottom + ")");

    }

    public static int[] Kadane2(int s[])
    {
        int result[]=new int[]{Integer.MIN_VALUE,0,-1};
        int curSum=0;
        int start=0;

        for(int i=0;i<s.length;i++)
        {
            curSum+=s[i];
            if(curSum<0)
            {
                curSum=0;
                start=i+1;
            }
            else if(curSum>result[0])
            {
                result[0]=curSum;
                result[1]=start;
                result[2]=i;
            }
        }

        return result;

    }


    public static int maxSum(int m[][])
    {
        int rows=m.length;
        int col=m[0].length;
        int temp[]=new int[rows];
        int maxsum=-1;
        int leftBound;
        int rightBound;
        int up;
        int down;
        int left;
        int right;

        for(left=0;left<col;left++)
        {
            for(int i=0;i<rows;i++)
            {
                temp[i]=0;
            }
        

        for(right=left;right<col;right++)
        {
            for(int i=0;i<rows;i++)
            {
                temp[i]+=m[i][right];
            }
        

//        for(int j=0;j<col;j++)
//        {
//            System.out.println(temp[j] + " ");
//        }

        KadaneResult result=kadane(temp);
        if(result.maxsum>maxsum)
        {
            System.out.println("max sum " + result.maxsum);
            maxsum=result.maxsum;
            leftBound=left;
            rightBound=right;
            up=result.start;
            down=result.end;

        }
        }
        }

        return maxsum;
    }


    public static KadaneResult kadane(int a[])
    {
        int max=0;
        int maxstart=-1;
        int maxend=-1;
        int curstart=0;
        int maxsofar=0;
        for(int i=0;i<a.length;i++)
        {
            maxsofar+=a[i];
            if(maxsofar<0)
            {
                maxsofar=0;
                curstart=i+1;
            }

            if(max<maxsofar)
            {
                max=maxsofar;
                maxstart=curstart;
                maxend=i;
            }
        }

        return new KadaneResult(max, maxstart, maxend);
    }

}


class KadaneResult
{
    int maxsum;
    int start;
    int end;

    public KadaneResult(int maxsum, int start, int end) {
        this.maxsum = maxsum;
        this.start = start;
        this.end = end;
    }

}




