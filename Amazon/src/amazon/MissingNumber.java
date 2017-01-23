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


	//int a[] = {0,1,2,3,4,5,6,7,8,10};
        int a[]={1,2,3,4,5,6,7,9,10};
        System.out.println("missing number is " + missingNumber(a, 0, a.length-1,10));

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


    public static int missingNumber(int a[],int l,int h,int d)
    {
        if(l<=h)
        {

        if(a[0]!=1)
            return 1;

        if(a[a.length-1]!=d)
            return d;
        int m=l+(h-l)/2;

        if(l==h && (a[m]-m)==1)
            return -1;

        if(l+1==h)
        {
            if(a[h]-a[l]>1)
                return a[l]+1;
            else
                return -1;
        }

        

        if(a[m]-m==2)
            return missingNumber(a, l, m,d);
        else if(a[m]-m==1)
            return missingNumber(a, m, h,d);
        

        }

        return -1;
    }





}
