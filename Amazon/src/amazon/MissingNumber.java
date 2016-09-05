/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class MissingNumber {


    public static void main(String[] args) {


	int a[] = {0,1,2,3,4,5,6,7,8,10};
        System.out.println("missing number is " + missing(a, 0, 10));

    }
    
    public static int missing(int A[], int begin, int end)
{
int mid = (begin + end)/2;

if (begin +1 == end)
return (A[begin] != begin)? begin:end;

if (mid < A[mid]) 
return missing(A, begin, mid);
else
return missing(A, mid, end);
}





}
