/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package combination;

import java.util.HashSet;

/**
 *
 * @author admin
 */
public class colorful {


     public static int index=3;
    public static void main(String[] args) {

        int t[]={1,2,3,4};
        char p[]={'A','B','C','D'};
        int b[]=new int[t.length];
       // findCombination(b,p, 0, t.length-1);

        int g=234;
        System.out.println("check " + colorful(g));


    }

    static HashSet<Integer> hm = new HashSet<Integer>();

    public static int findCombination(int a[],int b[],int k,int n )
    {

        if(k>n)
            return -1;
        if(k==n)
        {
            a[k]=0;

//            if(printComb(a,b,n)==0)
//            {
//                return 0;
//            }

            a[k]=1;
           // printComb(a,b,n);


//            if(printComb(a,b,n)==0)
//            {
//                return 0;
//            }
        }
        a[k]=0;
        if(findCombination(a,b, k+1, n) ==0) return 0;
        a[k]=1;
         if(findCombination(a,b, k+1, n) ==0) return 0;

        return 1;
    }

    public static int  printComb(int a[],int b[],int n)
    {
        
        int s=0;
            int product = 1;
       // ArrayList<Integer> p=new ArrayList<Integer>();
        
        for(int i=0;i<=n;i++)
        {
            if(a[i]==1)
            {
                product *= b[i];

             //  System.out.print(b[i]+" ");
                    
                s++;
               //p.add(b[i]*1);
            }

        }

           // System.out.println("");
            if(s!=0 )
            {
                //System.out.println("product :: " + product);
              if(hm.contains(product))
              {
                  return 0;
              }
              else
              {
                  hm.add(product);
                  return 2;
              }
            }
                return 2;
//        if(s==index)
//        {
//            for(Character c:p)
//            {
//                System.out.print(c);
//            }
//            System.out.println(" ");
//        }
//        if(s==0)
//        {
//            System.out.println("null set");
//        }

    }

    public static int colorful(int a)
    {

    int len = Integer.toString(a).length();
    int[] p = new int[len];
    for (int i = 0; i < len; i++)
    {
        p[i] = a % 10;
        a =a/ 10;
    }

//    for(int j=0;j<p.length;j++)
//    {
//        System.out.println(p[j] );
//    }

    int b[]=new int[len];
    if(findCombination(b, p, 0, len-1)==0)
    {
         //System.out.println("bla 00  ..");
        return 0;
    }
    else
    {
       // System.out.println("bla . 111.");
        return 1;
    }
    }

}
