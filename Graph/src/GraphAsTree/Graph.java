/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphAsTree;

/**
 *
 * @author admin
 */
public class Graph {

    int V;
    AdjList array[];
    boolean visited[];

    public Graph(int V) {
        this.V = V;
        array=new AdjList[V];
        visited=new boolean[V];

        for(int i =0;i<V;i++)
        {
            array[i]=new AdjList();
            array[i].head=null;
            visited[i]=false;
        }
    }

    public void addEdge(int s,int d)
    {
        AdjListNode newNode=new AdjListNode(d);
        newNode.next=array[s].head;
        array[s].head=newNode;

        AdjListNode p=new AdjListNode(s);
            p.next=array[d].head;
            array[d].head=p;
    }

   public boolean isTree()
   {
       for(int i=0;i<V;i++)
           visited[i]=false;

       if(isCycleUtil(0, visited, -1))
               return false;

       for(int j=0;j<V;j++)
       {
           if(!visited[j])
               return false;
       }

       return true;
   }


    // cycle detection in undirected graph O(E+V)
    public boolean isCycle()
    {
        
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
            if(isCycleUtil(i,visited,-1))
            {
                //System.out.println("inside cycle");
                return true;
            }
            }
        }

        return false;
    }


    public boolean isCycleUtil(int i,boolean visited[],int parent)
    {
        visited[i]=true;
          System.out.println("i " + i + " parent " + parent);
            AdjListNode temp=array[i].head;
            while(temp.next!=null)
            {
               
                 
                 if(!visited[temp.x])
                 {
                     if(isCycleUtil(temp.x, visited, i))
                         return true;
                 }

                 else if(temp.x!=parent)
                     return true;

                 temp=temp.next;

                 
                
            }

            return false;
       
    }



}
