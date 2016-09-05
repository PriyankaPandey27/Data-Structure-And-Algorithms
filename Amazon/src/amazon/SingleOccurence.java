/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class SingleOccurence {


    public static void main(String[] args) {

        int a[]={4, 4, 5, 5, 6, 6,7,8,8,9,9};
        System.out.println("the element is " + findSingleOccurenceElement(a, 0, a.length-1));

    }

    public static int findSingleOccurenceElement(int a[],int l,int h)
    {
        if(l>h)
            return -1;
        if(l==h)
            return a[l];

        int m=l+(h-l)/2;

        if(m%2==0)
        {
            if(a[m]==a[m+1])
                return findSingleOccurenceElement(a, m+2, h);
            else
                return findSingleOccurenceElement(a, l, m);
        }
        else
        {
            if(a[m]==a[m-1])
                return findSingleOccurenceElement(a, m+1, h);
            else
                return findSingleOccurenceElement(a, l, m-1);
        }
    }

}
