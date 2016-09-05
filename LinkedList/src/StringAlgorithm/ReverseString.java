/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */
public class ReverseString {

    public static void main(String[] args)
    {
        String s="Priyanka is a nice girl";
      String p=reverse(s);
        for(int i=0;i<p.length();i++)
            System.out.print(p.charAt(i) + " ");
        System.out.println();
        //String s1=reverseCnst(s);
//        String s2=reverseXor(s);
//        for(int i=0;i<s2.length();i++)
//            System.out.print( s2.charAt(i));
       String ps=reverseWord(s);
       for(int i=0;i<ps.length();i++)
       {
           System.out.print(ps.charAt(i));

       }
//        System.out.println("");

        String y="ABCCBCBA";
        removeAdjacentPairs(y);
        System.out.println();
//
//        String str="ABCD";
//        //permutationOrder(str);
////        char m[]=str.toCharArray();
////        permutationNotInOrder(m, m.length);
//        combination(str);
//        String t="ABBACBAAC";
//        String c="AAB";
//        minWindow(t, c);
//



    }

    public static String reverse(String str)
    {
        char temp;
        char p[]=str.toCharArray();
        int end=p.length-1;
        for(int i=0;i<p.length/2;i++)
        {
           temp=p[i];
           p[i]=p[end-i];
           p[end-i]=temp;
        }

        return new String(p);


    }

    /// for constant string

    public static String reverseCnst(String str)
    {
        int len=str.length();
        StringBuffer s=new StringBuffer(len);
        for(int i=len-1;i>=0;i--)
        {
            s.append(str.charAt(i));
        }

        return s.toString();


    }

    public static String reverseXor(String str)
    {
        char p[]=str.toCharArray();
        int strt=0;
        int end=p.length-1;
        while(strt<=end)
        {
            p[strt]=(char) (p[strt] ^ p[end]);
            p[end]=(char)(p[end]^p[strt]);
            p[strt]=(char)(p[strt]^p[end]);
            strt++;
            end--;
        }
        return new String(p);

    }


    public static String reverseWord(String s)
    {
        if(s==null ||s.length()==0)
            return " ";

        int curr=0,strt=0;
        s=reverse(s);
        StringBuilder sb=new StringBuilder();
        while(curr<s.length())
        {
            if(s.charAt(curr)!=' ')
            {
                curr++;
            }
            else
            {
                if(strt!=curr)
                {
                    sb.append(reverse(s.substring(strt, curr)) + " ");
                    strt=curr;
                }
                else
                {
                    curr++;
                    strt++;
                }
            }

        }

        if(strt!=curr)
            sb.append(reverse(s.substring(strt, curr)) + " ");

        return sb.toString().substring(0, sb.length()-1);

    }


    public static void removeAdjacentPairs(String s)
    {
        char[] p=s.toCharArray();
        int l=p.length;
        int j=0;
        for(int i=1;i<=l-1;i++)
        {
            while((p[i]==p[j]) && (j>=0))
            {
                i++;
                j--;
            }
            p[++j]=p[i];
        }
        for(int k=0;k<=j;k++)
        {
            System.out.print(p[k] + " ");
        }
    }

    public static void permutationOrder(String s)
    {
        permutationInOrder("",s);
    }

    public static void permutationInOrder(String prefx,String s)
    {
        int len=s.length();
        if(len==0)
        {
            System.out.println(prefx);
        }
        else
        {
            for(int i=0;i<len;i++)
            permutationInOrder(prefx+s.charAt(i),s.substring(0,i)+s.substring(i+1, len));
        }
    }

    public static void swap(char s[],int i,int j)
    {
        char c;
        c=s[i];
        s[i]=s[j];
        s[j]=c;
    }

    public static void permutationNotInOrder(char str[],int n)
    {
        if(n==1)
        {
            System.out.println(str);
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                swap(str,i,n-1);
                permutationNotInOrder(str, n-1);
                swap(str,i,n-1);
            }
        }
    }

    public static void combination(String s)
    {
        combinationTwo("",s);
    }

    public static void combinationTwo(String prefx,String str)
    {
        System.out.println(prefx);
        for(int i=0;i<str.length();i++)
        {
            combinationTwo(prefx+str.charAt(i), str.substring(i+1));
        }
    }


    // sliding window approach

    public static void minWindow(String input,String chars)
    {
        int inputLen=input.length();
        int charLen=chars.length();
        int[] toFind=new int[256];
        int[] hasFound=new int[256];
        for(int i=0;i<charLen;i++)
        {
            toFind[chars.charAt(i)]++;
        }
        int mWinLen=Integer.MAX_VALUE;
        int mWinBegin=0;
        int mWinEnd=0;
        int count=0;
        int begin=0;
        for(int end=0;end<inputLen;end++)
        {
            
            if(toFind[input.charAt(end)]==0)
                continue;
            hasFound[input.charAt(end)]++;
            if(hasFound[input.charAt(end)]<=toFind[input.charAt(end)])
                count++;
            if(count==charLen)
            {
                while(toFind[input.charAt(begin)]==0||hasFound[input.charAt(begin)]>toFind[input.charAt(begin)])
                {
                    if(hasFound[input.charAt(begin)]>toFind[input.charAt(begin)])
                    {
                        hasFound[input.charAt(begin)]--;
                        
                    }
                    begin++;
                }
            int windowLen=end-begin+1;
            if(windowLen<mWinLen)
            {

                mWinBegin=begin;
                mWinEnd=end;
                mWinLen=windowLen;
            }
            }
            
           // System.out.println(end);
        }
        System.out.println("strt " + mWinBegin);
        System.out.println("end " + mWinEnd);

        for(int i=mWinBegin;i<=mWinEnd;i++)
        {
            System.out.print(input.charAt(i)+ " ");
        }
    }



}
