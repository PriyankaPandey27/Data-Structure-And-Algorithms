/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */
public class Horspol {
   public static final int no_of_char=127;

    public static void main(String[] args)
    {
        String txt="AABAACABAADAABAAABAA";
        String pat="ABA";
        int shift[]=new int[no_of_char];
        computeShift(shift, pat.toCharArray());
        search(shift, pat.toCharArray(), txt.toCharArray());


    }

    public static void computeShift(int shift[],char pat[])
    {
        int m=pat.length;
        int index;
        for(int i=0;i<shift.length;i++)
        {
            shift[i]=m;
        }

        for(int j=pat.length-2;j>=0;j--)
        {
            index=m-1-j;

            if(shift[pat[j]]>index ||shift[pat[j]]==m)
            {
                shift[pat[j]]=index;
            }
        }

    }

    public static void search(int shift[],char pat[],char txt[])
    {
        int i=0,j;
        int n=txt.length;
        int m=pat.length;
        System.out.println();

        while(i<n-m)
        {
            j=m-1;
            while(j>=0 && txt[i+j]==pat[j])
            {
                j--;
            }
            if(j==-1)
            {
                System.out.println("the matching is found at index " + i);
            }

            if(j==m-1)
            {
                i=i+shift[txt[i+j]];
            }
            else
                i=i+shift[txt[i+j+1]];
        }

    }



}
