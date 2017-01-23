/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.Vector;

/**
 *
 * @author admin
 */
 class SameContact {

    public static void main(String[] args) {

     Contact arr[] = {new Contact("Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"),
                     new Contact("Lucky", "lucky@gmail.com", "+1234567"),
                     new Contact("gaurav123", "+5412312", "gaurav123@skype.com"),
                     new Contact("gaurav1993", "+5412312", "gaurav@gfgQA.com"),
                     new Contact("raja", "+2231210", "raja@gfg.com"),
                     new Contact("delhi", "+878312", "raja")
                     };

       // System.out.println(arr.length);
     
    findSameContact(arr, arr.length);
     


    }


    public static void findSameContact(Contact a[],int n)
    {
        Vector<Integer> sol=new Vector(n);
        int mat[][]=new int[n][n];
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
            visited[i]=false;

        buildGraph(a, n, mat);

        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                dfsVisit(i, n, mat, sol, visited);
                sol.add(-1);
            }
            
        }

        for(int k=0;k<sol.size();k++)
        {
            if(sol.elementAt(k)!=-1)
            {
                System.out.print(sol.get(k) + " ");
            }
            else
                System.out.println();
        }


    }

    public static void dfsVisit(int i,int n,int m[][],Vector<Integer> sol,boolean visited[])
    {
        visited[i]=true;
        sol.add(i);
        for(int j=0;j<n;j++)
        {
            
            if(m[i][j]==1 && !visited[j])
            {
                dfsVisit(j, n, m, sol, visited);
            }
        }
    }

    public static void buildGraph(Contact a[],int n,int m[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                m[i][j]=0;
            }
        }

        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(a[i].field1.equalsIgnoreCase(a[j].field1)||a[i].field1.equalsIgnoreCase(a[j].field2)||a[i].field1.equalsIgnoreCase(a[j].field3)||
                   a[i].field2.equalsIgnoreCase(a[j].field1)||a[i].field2.equalsIgnoreCase(a[j].field2)||a[i].field2.equalsIgnoreCase(a[j].field3)||
                   a[i].field3.equalsIgnoreCase(a[j].field1)||a[i].field3.equalsIgnoreCase(a[j].field2)||a[i].field3.equalsIgnoreCase(a[j].field3))
                {
                    m[i][j]=1;
                    m[j][i]=1;
                    break;
                }
            }
        }
    }

}




class Contact
{
    String field1;
    String field2;
    String field3;

    public Contact(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

}
