/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */

public class ScannerExample {

    public static void main(String[] args)
    {
        String txt="ABABDDABA";
        String pat="ABABCA";
        process(txt.toCharArray(),pat.toCharArray());


    }



public static void process(char txt[],char pat[])
{
    if(txt.length==0||pat.length==0)
        return;

    int lps[]=new int[pat.length];
    lps=computeLps(pat, lps);
    //printArray(lps);
    int c=kmpSearch(txt,pat,lps);
    if(c==-1)
    {
        System.out.println("pattern not found");
    }


}

public static int[] computeLps(char pat[],int lps[])
{
    lps[0]=0;
    int i=1,len=0;
    while(i<lps.length)
    {
        if(pat[i]==pat[len])
        {
            len++;
            lps[i]=len;
            i++;
        }
        else
        {
            if(len!=0)
            {
                len=lps[len-1];
            }
            else
            {
                lps[i]=0;
                i++;
            }
        }
    }
    return lps;
}

public static void printArray(int lps[])
{
    for(int i=0;i<lps.length;i++)
    {
        System.out.print(lps[i] + " ");
    }
}

public static int kmpSearch(char txt[],char pat[],int lps[])
{
    int i=0,j=0;
    int flag=0;
    while(i<txt.length)
    {
        if(txt[i]==pat[j])
        {
            i++;
            j++;
            flag=1;
        }
        else
        {
            if(j==0)
                i++;
            else
            j=lps[j-1];

            flag=0;
        }

        if(j==pat.length && flag==1)
        {
            System.out.println("match occur at i" + (i-j));
            j=lps[j-1];
            //return i-j;
        }
    }

    if(flag==0)
    return -1;

    return 0;
}


}
