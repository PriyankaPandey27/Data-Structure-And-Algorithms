/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.HashMap;
import java.util.Queue;
import java.util.Vector;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
 class CloneUndirectedGraph {

    public static void main(String[] args) {
        //Graph graph = new Graph();
        GraphNode source = buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        bfs(source);
        GraphNode newSource = cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        bfs(newSource);
    }


    public static GraphNode cloneGraph(GraphNode s)
    {
        Queue<GraphNode> q= new LinkedList<GraphNode>();
        q.add(s);
        HashMap<GraphNode,GraphNode> h=new HashMap<GraphNode,GraphNode>();
        h.put(s, new GraphNode(s.v));
        while(!q.isEmpty())
        {
            GraphNode u=q.remove();
            GraphNode clone=h.get(u);
            if(u.neighbour!=null)
            {
                for(GraphNode g:u.neighbour)
                {
                    GraphNode c=h.get(g);
                    if(c==null)
                    {
                        q.add(g);
                        c=new GraphNode(g.v);
                        h.put(g, c);
                    }
                    clone.neighbour.add(c);
                }
            }
        }

        return h.get(s);
    }

    public static GraphNode buildGraph()
    {
        GraphNode n1=new GraphNode(1);
        GraphNode n2=new GraphNode(2);
        GraphNode n3=new GraphNode(3);
        GraphNode n4=new GraphNode(4);
        Vector<GraphNode> v=new Vector<GraphNode>();
        v.add(n2);
        v.add(n4);
        n1.neighbour=v;
        v=new Vector<GraphNode>();
        v.add(n1);
        v.add(n3);
        n2.neighbour=v;
        v=new Vector<GraphNode>();
        v.add(n2);
        v.add(n4);
        n3.neighbour=v;
        v=new Vector<GraphNode>();
        v.add(n3);
        v.add(n1);
        n4.neighbour=v;
        return n1;

    }

    public static void bfs(GraphNode s)
    {
        Queue<GraphNode> q= new LinkedList<GraphNode>();
        q.add(s);
        HashMap<GraphNode,Boolean> visit=new HashMap<GraphNode,Boolean>();
        visit.put(s, true);
        while(!q.isEmpty())
        {
            GraphNode u=q.remove();
            System.out.println("value "+ u.v);
            if(u.neighbour!=null)
            {
                for(GraphNode g : u.neighbour)
                {
                    if(visit.get(g)==null)
                    {
                        q.add(g);
                        visit.put(g, true);
                    }
                }
            }
            System.out.println("");
        }


    }

}

class GraphNode
{
    int v;
    Vector<GraphNode> neighbour;

    public GraphNode(int v) {
        this.v = v;
        this.neighbour=new Vector<GraphNode>();
    }


}
