/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author admin
 */
 class Graph {

    int V;
    AdjList array[];
    boolean[] visited;

    public Graph(int V) {
        this.V = V;
        array=new AdjList[V];
        visited=new boolean[V];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
            visited[i]=false;
        }

    }


    public void addEdge(int s,int d)
    {
        // directed graph
        AdjListNode newNode=new AdjListNode(d);
        newNode.next=array[s].head;
        array[s].head=newNode;

        //undirected graph
//        if(s!=d)
//        {
//            AdjListNode p=new AdjListNode(s);
//            p.next=array[d].head;
//            array[d].head=p;
//        }
    }

    public void printGraph()
    {
        for(int i=0;i<V;i++)
        {
            AdjListNode crawl=array[i].head;
            System.out.println("Adjacency list of vertex " + i + " \nhead");
            while(crawl!=null)
            {
                System.out.print(crawl.data + "-->");
                crawl=crawl.next;
            }
            System.out.println();
        }
    }


    public void dfs(int v)
    {
        for(int i=0;i<V;i++)
        {
            //System.out.println("visited value " +i);
            visited[i]=false;
        }

        dfsUtil(v, visited);

        for(int i=1;i<V;i++)
        {
            if(visited[i]==false)
                System.out.println("multiple root");
        }


    }

    public void dfsUtil(int v,boolean visited[])
    {
        visited[v]=true;
        System.out.print( v + " ");

        AdjListNode temp=array[v].head;
        //System.out.println("temp value " + temp.x);
        while(temp!=null)
        {
            if(visited[temp.data]==false)
            {
                dfsUtil(temp.data, visited);
            }
            temp=temp.next;
        }
    }

    //dfs for disconnected graph
    public void dfsDisconnected(int t)
    {
         for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }

        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                dfsUtil(i, visited);
            }
        }
    }


    //topological sort
    public void topologicalSort()
    {
        Stack s=new Stack();

         for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }

        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                topologicalUtil(i, visited, s);
            }
        }

        while(!s.isEmpty())
        {
            int p=(Integer)(s.pop());
            System.out.print(p + " ");
            //for character
           //System.out.print((char)(97+(Integer)s.pop())+ " ");
        }

    }

    public void topologicalUtil(int i,boolean visited[],Stack s)
    {
        visited[i]=true;        //POST call

        AdjListNode temp=array[i].head;
        while(temp!=null)
        {
            if(visited[temp.data]==false)  //GET
            {
                topologicalUtil(temp.data, visited, s);
            }
            temp=temp.next;
        }

        s.push(i);          // POST call
    }


    public void bfs(int s)
    {
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }

        Queue<Integer> q=new LinkedList();
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty())
        {
            int t=q.remove();
            System.out.print(t + " ");

            AdjListNode temp=array[t].head;
            while(temp!=null)
            {
                if(visited[temp.data]==false)
                {
                    visited[temp.data]=true;
                    q.add(temp.data);
                }
                temp=temp.next;
            }
        }


    }


    public boolean isCyclic()
    {
        boolean stack[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
            stack[i]=false;
        }

        for(int i=0;i<V;i++)
        {
            if(isCyclicUtil(i,visited,stack))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int i,boolean visited[],boolean stack[])
    {
        if(visited[i]==false)
        {
            visited[i]=true;
            stack[i]=true;
            AdjListNode temp=array[i].head;
            while(temp!=null)
            {
                if(visited[temp.data]==false && isCyclicUtil(temp.data,visited,stack))
                    return true;
                else if(stack[temp.data])
                    return true;

                temp=temp.next;
            }
        }

        stack[i]=false;
        return false;

    }





}
