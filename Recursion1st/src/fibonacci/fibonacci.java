/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacci;


public class fibonacci {
    public static int x =0;
     public static  boolean isPrint2=false;
    public static void main(String[] args) {
        System.out.println("fibonacci series");
        func(3);
        //System.out.println(func(3));

    }

    public static int func(int n)
    {
       // isPrint=false;
           if(n == 0 && x==1)
           {
               System.out.println(n);
              x++;
               return n;
           }
           else if( n ==1 && x==0)
           {
               System.out.println(n);
               x++;
               return n;
           }

           else
           {
               int x1= func(n-1);
               int x2 = func(n-2);
               int r=x1 + x2;
             System.out.println( r);
            return r;
           }
        
           
     
   
    }

}
