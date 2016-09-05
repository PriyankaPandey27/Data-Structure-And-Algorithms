/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class overlappingSubstructureP1 {
    private static int lookup[];
    public static void main(String[] args) {

        int n=5;
        
        initialize(n);
        int p=fib_dp(n);
        System.out.println(p);

    }
    
    public static int fib(int n)
    {
        if(n<=1)
            return n;
        System.out.println("1st :: " + n);
        int x=fib(n-1);

        System.out.println("2nd :: "+n);
        int y=fib(n-2);
        return x+y;

    }


    public static void initialize(int n)
    {
        lookup=new int[n+1];
        for(int i=0;i<lookup.length;i++)
            lookup[i]=-1;
    }
    public static int fib_dp(int n)
    {

       if(n<=1)
       {
          
           lookup[n]=n;
          // System.out.println("recurr end " +lookup[n]);
       
       }
       else
       {
           
           int x=0,y=0;
           if(lookup[n-1]==-1)
           {
            x=fib_dp(n-1);
           System.out.println("1st:: "+n);
           }
           else if(lookup[n-1]!=-1)
           {
               x=lookup[n-1];
           }
           if(lookup[n-2]==-1)
           {
            y=fib_dp(n-2);
           System.out.println("2nd:: "+n);
           }
           else if(lookup[n-2]!=-1)
           {
               y=lookup[n-2];
           }
           lookup[n]=x+y;
           System.out.println("final " +lookup[n]);

       
       }

       return lookup[n];


    }


}
