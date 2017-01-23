/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShortestPathDirected;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {

        // Graph g = new Graph(6);
//        g.addEdge(0, 1, 5);
//        g.addEdge(0, 2, 3);
//        g.addEdge(1, 3, 6);
//        g.addEdge(1, 2, 2);
//        g.addEdge(2, 4, 4);
//        g.addEdge(2, 5, 2);
//        g.addEdge(2, 3, 7);
//        g.addEdge(3, 4, -1);
//        g.addEdge(4, 5, -2);
//
//        g.shortestPath(1);

//         g.addEdge(0, 1, 5);
//    g.addEdge(0, 2, 3);
//    g.addEdge(1, 3, 6);
//    g.addEdge(1, 2, 2);
//    g.addEdge(2, 4, 4);
//    g.addEdge(2, 5, 2);
//    g.addEdge(2, 3, 7);
//    g.addEdge(3, 5, 1);
//    g.addEdge(3, 4, -1);
//    g.addEdge(4, 5, -2);
//
//    g.longestPath(1);

        Graph g=new Graph(4);
         g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(0, 3, 10);
        for(int i=0;i<4;i++)
        {
        g.FloyedMarshal(i);
        }
    }

}
