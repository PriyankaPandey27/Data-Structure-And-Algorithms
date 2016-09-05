/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class BuildingBridge {

    public static void main(String[] args) {

        int N[] = {8, 1, 4, 3, 5, 2, 6, 7};
	int S[] = {1, 2, 3, 4, 5, 6, 7, 8};
	System.out.println("the maximum length of the bridge will be " + LISBuilding_Bridge(N, S));

    }

    public static int[] initialise(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            a[i]=1;
        }
        return a;
    }

    public static void fillIndices(int n[],int s[],int index[])
    {
        for(int i=0;i<n.length;i++)
        {
            for(int j=0;j<s.length;j++)
            {
                if(n[i]==s[j])
                {
                    index[i]=j;
                    break;
                }
            }
        }
    }

    public static int LISBuilding_Bridge(int n[],int s[])
    {
        if(n==null||s==null||n.length==0||s.length==0)
            return -1;

        int lis[]=new int[n.length];
        lis=initialise(lis);
        int ans=1;
        int index[]=new int[n.length];
        fillIndices(n, s, index);

        for(int i=1;i<index.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(index[j]<index[i])
                {
                    lis[i]=Math.max(lis[i], lis[j]+1);
                    ans=Math.max(lis[i], ans);
                }
            }
        }

        return ans;






    }

}
