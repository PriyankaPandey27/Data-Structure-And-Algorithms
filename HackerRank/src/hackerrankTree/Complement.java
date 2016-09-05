/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrankTree;

/**
 *
 * @author admin
 */
public class Complement {
    
    public static void main(String[] args) {

        int x=10;
        System.out.println(getIntegerComplement(x));
        
    }
    
    public static int getIntegerComplement(int n) {

     if(n<0||n>Integer.MAX_VALUE)
         return -1;
     if(n==0)
         return 0;
     if(n==1)
         return 1;
     if(n==2)
         return 1;
     String s="";
     while(n>2)
     {
         s+=n%2;
         n=n/2;
     }
     s+=n;
//        System.out.println("s = " +s);
     char a[]=s.toCharArray();
     char b[]=new char[a.length];
     int pp=a.length-1;
     for(int i=0;i<s.length();i++)
     {
        if(a[i]=='0')
        {
//         sout
                 a[i]='1';

        }
        else if(a[i]=='1')
        {
            a[i]='0';
        }
         b[pp--]=a[i];
//         System.out.println(a[i] + " " + b[i] );
     }

//        System.out.println(""+ b)
     int sum=0;
     int m = b.length-1;

     for(int i=0;i<=b.length-1;i++)
     {
//         System.out.print(b[i] + " ");
//         Character.getNumericValue('3');
         sum+=(Character.getNumericValue(b[i]))*(Math.pow(2, m));
         m--;
     }

     return sum;



     
     
     
    }

}
