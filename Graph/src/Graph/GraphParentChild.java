/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class GraphParentChild {

    int V;
    boolean visited[];
    AdjList array[];

    public static HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();

    public GraphParentChild(int v)
    {
        this.V=v;
        visited=new boolean[v];
        array=new AdjList[v];

        for(int i=0;i<v;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
            visited[i]=false;
        }

    }


    public boolean addEdge(int s,int d)
    {
        
          if(map.get(s)==null)
               {
                   //System.out.println("inside source");
                   map.put(s, new ArrayList<Integer>());
                   map.get(s).add(d);
                   AdjListNode newNode=new AdjListNode(d);
                   newNode.next=array[s].head;
                   array[s].head=newNode;
               }
          else
          {
            ArrayList<Integer> res=map.get(s);
            for(Integer r:res)
            {
                if(r==d)
                {
                   // System.out.println("false");
                    return false;
                }
            }
            
                   map.get(s).add(d);
                   AdjListNode newNode=new AdjListNode(d);
                   newNode.next=array[s].head;
                   array[s].head=newNode;
            
          }


        return true;
    }

   
    public String dfs(int v)
    {
        //visited[0]=true;
        for(int i=0;i<V;i++)
        {
            // System.out.println("visited value " + (char)(i+97));
            visited[i]=false;
        }

        dfsUtil(v, visited);

        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                //System.out.println("value " + (char)(i+97));
                return "E4";
            }
        }

        return "Success";


    }

    public void dfsUtil(int v,boolean visited[])
    {
        visited[v]=true;
        System.out.print( (char)(v+97) + " ");

        AdjListNode temp=array[v].head;
       // System.out.println("temp vale " + (char)(temp.x+97));
        while(temp!=null)
        {
            if(visited[temp.data]==false)
            {
                dfsUtil(temp.data, visited);
            }
            temp=temp.next;
        }
    }

     public void printGraph()
    {
        for(int i=0;i<V;i++)
        {
            AdjListNode crawl=array[i].head;
            System.out.println("Adjacency list of vertex " + (char)(97+i) + " \nhead");
            while(crawl!=null)
            {
                System.out.print((char)(97+crawl.data) + "-->");
                crawl=crawl.next;
            }
            System.out.println();
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

    public String checkChild()
    {
        
        for(int i=0;i<V;i++)
        {
            int count=0;
         AdjListNode temp=array[i].head;
       // System.out.println("temp vale " + (char)(temp.x+97));
        while(temp!=null)
        {
            //System.out.println("temp " + (char)(temp.x+97));
            
            temp=temp.next;
            count++;
            if(count>2)
                return "E1";
        }
        }
        return "Success";
    }

    public String multipleParent()
    {
        ArrayList<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<V;i++)
        {
//            int count=0;
         AdjListNode temp=array[i].head;
       // System.out.println("temp vale " + (char)(temp.x+97));
        while(temp!=null)
        {
            //System.out.println("temp " + (char)(temp.x+97));
            if(temp!=null)
            {
//                if(a.contains(temp.x))
//                {
//
//                }
                for(Integer h:a)
                {
                    if(h==temp.data)
                        return "E5";

                }
                a.add(temp.data);
            }
            temp=temp.next;

        }
        }
        return "Success";

    }




    public String parentChildError()
    {
        if(dfs('a'-97).equalsIgnoreCase("E4"))
            return "E4";
        if(multipleParent().equalsIgnoreCase("E5"))
            return "E5";
        if(checkChild().equalsIgnoreCase("E1"))
            return "E1";
        if(isCyclic()==true)
            return "E3";

        return "Success";
    }





}
