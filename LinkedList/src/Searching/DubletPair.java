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
public class DubletPair {

    public static void main(String[] args) {

        int a[]={1,2,8,6,3,4,5,0,4,4,3,6,5};
        findDublet(a, 8);



    }

    public static void findDublet(int a[],int k)
    {
        if(a==null)
            return;
        int n=a.length;
        if(n==0||n==1)
            return ;

        Arrays.sort(a);
        Set<Pair<Integer,Integer>> map=new HashSet();
        int l=0;
        int h=n-1;
        while(l<h)
        {
            if(a[l]+a[h]>k)
                h--;
            else if(a[l]+a[h]<k)
                l++;
            else
            {
                Pair<Integer,Integer> p=new Pair<Integer,Integer>();
                p.first=a[l];
                p.second=a[h];
                if(!map.contains(p))
                {
                    System.out.println(a[l] + " "+ a[h]);
                    map.add(p);
                }
                else
                {
                    System.out.println("else " +a[l] + " "+ a[h]);
                }
                l++;
                h--;
            }
        }

    }

}

class Pair<T,U>
{
    T first;
    U second;

    @Override
    public boolean equals(Object o)
    {
        System.out.println("class "+ getClass());
        System.out.println("object " + o.getClass());
        if(o==null||getClass()!=o.getClass())
            return false;

        Pair<?,?> pair=(Pair<?,?>)o;
        if(first!=null)
        {
            if(!first.equals(pair.first))
                return false;
            if(second==null)
                return false;
            if(!second.equals(pair.second))
                return false;

            return true;
        }
        return false;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.first != null ? this.first.hashCode() : 0);
        hash = 59 * hash + (this.second != null ? this.second.hashCode() : 0);
        return hash;
    }
    

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 73 * hash + (this.first != null ? this.first.hashCode() : 0);
//        hash = 73 * hash + (this.second != null ? this.second.hashCode() : 0);
//        return hash;
//    }
 }

