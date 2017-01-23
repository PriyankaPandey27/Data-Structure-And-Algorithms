/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShortestPathDirected;

import java.util.Stack;

/**
 *
 * @author admin
 */
public class Graph {

    int v;
    AdjList array[];
    public Graph(int V)
    {
        v=V;
        array=new AdjList[V];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
        }
    }

    public void addEdge(int s,int d,int w)
    {
        AdjListNode node=new AdjListNode(d, w);
        node.next=array[s].head;
        array[s].head=node;
    }

    public void topologicalSortUtil(int i,boolean visit[],Stack<Integer> s)
    {
        visit[i]=true;
        AdjListNode temp=array[i].head;
        while(temp!=null)
        {
            if(!visit[temp.dest])
            {
                topologicalSortUtil(temp.dest, visit, s);
            }
            temp=temp.next;
        }

        s.push(i);
    }

    public void shortestPath(int i)
    {
        Stack<Integer> s=new Stack<Integer>();
        int dist[]=new int[v];
        boolean visited[]=new boolean[v];
        for(int j=0;j<v;j++)
            visited[j]=false;

        for(int j=0;j<v;j++)
        {
            if(!visited[j])
            {
                topologicalSortUtil(j, visited, s);
            }
        }

        for(int j=0;j<v;j++)
        {
            dist[j]=Integer.MAX_VALUE;

        }

        dist[i]=0;

        while(!s.isEmpty())
        {
            int u=(Integer)s.pop();
            if(dist[u]!=Integer.MAX_VALUE)
            {
                AdjListNode temp=array[u].head;
                while(temp!=null)
                {
                    
                    
                    if(dist[temp.dest]>dist[u]+temp.weight)
                        dist[temp.dest]=dist[u]+temp.weight;
                    temp=temp.next;
                }
                
            }
        }

        for(int k=0;k<v;k++)
        {
            System.out.println("dist " + dist[k]);
        }


    }


    public void longestPath(int i)
    {
        Stack<Integer> s=new Stack<Integer>();
        int dist[]=new int[v];
        boolean visited[]=new boolean[v];
        for(int j=0;j<v;j++)
            visited[j]=false;

        for(int j=0;j<v;j++)
        {
            if(!visited[j])
            {
                topologicalSortUtil(j, visited, s);
            }
        }

        for(int j=0;j<v;j++)
        {
            dist[j]=Integer.MIN_VALUE;

        }

        dist[i]=0;

        while(!s.isEmpty())
        {
            int u=(Integer)s.pop();
            if(dist[u]!=Integer.MIN_VALUE)
            {
                AdjListNode temp=array[u].head;
                while(temp!=null)
                {


                    if(dist[temp.dest]<dist[u]+temp.weight)
                        dist[temp.dest]=dist[u]+temp.weight;
                    temp=temp.next;
                }

            }
        }

        for(int k=0;k<v;k++)
        {
            System.out.println("dist " + dist[k]);
        }


    }

        public void FloyedMarshal(int i)
    {
        Stack<Integer> s=new Stack<Integer>();
        int dist[]=new int[v];
        boolean visited[]=new boolean[v];
        for(int j=0;j<v;j++)
            visited[j]=false;

        for(int j=0;j<v;j++)
        {
            if(!visited[j])
            {
                topologicalSortUtil(j, visited, s);
            }
        }

        for(int j=0;j<v;j++)
        {
            dist[j]=Integer.MAX_VALUE;

        }

//        for(int i=0;i<v;i++)
//        {

        dist[i]=0;

        while(!s.isEmpty())
        {
            int u=(Integer)s.pop();
           // System.out.println("stack  " + u);
            if(dist[u]!=Integer.MAX_VALUE)
            {
                AdjListNode temp=array[u].head;
                while(temp!=null)
                {


                    if(dist[temp.dest]>dist[u]+temp.weight)
                        dist[temp.dest]=dist[u]+temp.weight;
                    temp=temp.next;
                }

            }
        }
       // }

        for(int k=0;k<v;k++)
        {
            System.out.println("dist " + dist[k]);
        }


    }


}
