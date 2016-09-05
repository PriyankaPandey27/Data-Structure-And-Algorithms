/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class TripletPair {

    public static void main(String[] args) {

        int a[]={1,2,8,6,3,4,5,0,4,4,3,6};
        findTriplet(a, 10);
    }

    public static void findTriplet(int a[],int k)
    {
        int n=a.length;
        if(n==0||n==1)
            return;
        Arrays.sort(a);
        Set<Triplet<Integer,Integer,Integer>> map=new HashSet();
        for(int i=0;i<=n-3;i++)
        {
            int l=a[i+1];
            int h=a[n-1];
            while(l<h)
            {
                int sum=a[i]+a[l]+a[h];
                if(sum<k)
                    l++;
                else if(sum>k)
                    h--;
                else
                {
                    Triplet<Integer,Integer,Integer> p=new Triplet<Integer,Integer,Integer>();
                    p.first=a[i];
                    p.second=a[l];
                    p.third=a[h];
                    if(!map.contains(p))
                    {
                        System.out.println(a[i]+ " "+a[l] + " "+a[h]);
                        map.add(p);
                    }
                    l++;
                    h--;
                }


            }
        }
    }

}

class Triplet<T,U,X>
{
    T first;
    U second;
    X third;

    @Override
    public boolean equals(Object o)
    {
       if(o==null||getClass()!=o.getClass())
           return false;

       Triplet<?,?,?> pair=(Triplet<?, ?, ?>)o;

       if(first!=null)
       {
           if(!first.equals(pair.first))
               return false;
           if(second==null||!second.equals(pair.second))
               return false;
           if(third==null||!third.equals(pair.third))
               return false;

           return true;
       }
       return false;
     }

}
