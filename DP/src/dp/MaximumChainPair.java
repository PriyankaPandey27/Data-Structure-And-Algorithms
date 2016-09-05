/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
class MaximumChainPair {

    public static void main(String[] args) {
        Pair input[]={new Pair(5, 24), new Pair(15, 25),new Pair(27, 40), new Pair(50, 60)};

        int n=input.length;
        maximumChainLength(input, n);

    }

    public static void maximumChainLength(Pair input[],int n)
    {
        if(input==null || n==0)
            return;

        int lis[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<lis.length;i++)
            lis[i]=1;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(input[j].b < input[i].a && lis[i]<lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(max<lis[i])
                max=lis[i];
        }

        System.out.println("the maximum length of the chain is  " + max);


    }


}

class Pair{

    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

}