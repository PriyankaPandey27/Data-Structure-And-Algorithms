/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */
public class PermutationString {

    public static String temp="";

    public static void main(String[] args) {

//        String s="AABC";
//        char p[]=s.toCharArray();
//        permutation(p, 0, p.length-1);
        
         String s="123";
        char p[]=s.toCharArray();
        String o="312";
        
        permutation(p, 0, p.length-1,o);



        //CHECKING PALINDROME PERMUTAION
//        String s="aabbcadad";
//        char p[]=s.toCharArray();
//        permutation(p, 0, p.length-1);

    }

    public static void permutation(char s[],int k,int n,String p)
    {
       // String temp="";
        if(k==n)
        {
           // String res="";
//            for(int i=0;i<=n;i++)
//            {
//                System.out.print(s[i]+ " ");
//            }
//            System.out.println("");


            // printing nxt number

            String res="";
            for(int i=0;i<=n;i++)
            {
                res+=s[i];
               // System.out.print(s[i]+ " ");
            }
            System.out.println(res);
            if(temp!=null)
            {
                if(temp.equalsIgnoreCase(p))
                {
                      System.out.println(res);
                        if(res.equalsIgnoreCase(temp))
                        {
                            System.out.println(-1);
                            return;
                        }
                }
                   
            }

            temp=res;

            // for checking palindrome
//            for(int i=0;i<=n;i++)
//            {
//                res+=s[i];
//            }
//            //System.out.println("res " + res);
//            if(isPalindromeCheck(res))
//            {
//               int i=0,j=res.length();
//               while(i<res.length() && j>=0)
//               {
//                   if(res.charAt(i)==res.charAt(j-1))
//                   {
//                       i++;
//                       j--;
//                   }
//                   else
//                   {
//                       return;
//                   }
//
//
//               }
//
//                System.out.println(res);
//            }
//            else
//            {
//                //System.out.println("not palindrome");
//                return;
//            }
        }
        for(int i=k;i<=n;i++)
        {
            if(containsDuplicate(s, k, i))
            {
            swap(s,i,k);
            permutation(s, k+1, n,p);
            swap(s,i,k);
            }
        }

    }

    public static boolean containsDuplicate(char s[],int start,int end)
    {
        for(int i=start;i<=end-1;i++)
        {
            if(s[i]==s[end])
                return false;
        }
        return true;
    }

    public static void swap(char s[],int i,int j)
    {
        char t=s[i];
        s[i]=s[j];
        s[j]=t;
    }

    public static boolean isPalindromeCheck(String s)
    {
        int l=s.length();
        int odd=0;
        char arr[]=s.toCharArray();
        int freq[]=new int[26];
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]-'a']++;
        }

        for(int i=0;i<26;i++)
        {
            if(freq[i]%2==1)
                odd++;

        }

        if(l%2==1 && odd==1 || l%2==0 && odd==0)
            return true;
        else
            return false;
    }

}
