/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphAsTree;

/**
 *
 * @author admin
 */
public class GraphTree {

        public static void main(String[] args) {

        Graph g1=new Graph(5);

       g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);


        if(g1.isCycle())
        {
            System.out.println("graph contains cycle");
        }
        else
        {
            System.out.println("graph is not a tree");
        }

          Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
//
//
           if(g2.isCycle())
        {
            System.out.println("graph not a tree");
        }
        else
        {
            System.out.println("graph is  a tree");
        }




    

    }

        public static void checkTree(int v)
        {
            Graph g1=new Graph(v+1);
        }

}

