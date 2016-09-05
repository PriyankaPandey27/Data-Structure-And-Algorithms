/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */
public class RabinKarp {

    public static void main(String[] args)
    {
        String txt="ppttppnjdgvgvgjvhjvhjvhjvjhvhbvhjvhjvhjvbfjppsdffbwdpbp";
        String pat="pp";
        
        System.out.println("text:--- " + txt );
        System.out.println("pattern:-- " + pat);
        int q=131;
        RKsearch(txt.toCharArray(),pat.toCharArray(),q);
    }

    public static void RKsearch(char txt[],char pat[],int q)
    {
        if(txt.length==0 || pat.length==0)
            System.out.println("invalid input");

        int p=0,t=0,j,h=1,d=256;
        int n=txt.length;
        int m=pat.length;

        h=(int)Math.pow(d, m-1)%q;
        for(int i=0;i<m;i++)
        {
            p=(d*p+pat[i])%q;
            t=(d*t+txt[i])%q;

        }

        for(int i=0;i<n-m;i++)
        {
            if(p==t)
            {
                for(j=0;j<m;j++)
                {
                    if(pat[j]!=txt[i+j])
                        break;
                }
                if(j==m)
                {
                    System.out.println("the match occured at index " + i);
                }
            }
            if(i<n-m)
            {
                t=(d*(t-txt[i]*h)+txt[i+m])%q;
                if(t<0)
                    t=t+q;
            }
        }

    }

}
