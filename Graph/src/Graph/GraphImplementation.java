/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

/**
 *
 * @author admin
 */
class GraphImplementation {
    
    public static void main(String[] args) {

    int v=9;
    Graph g=new Graph(v);
//    g.addEdge(1, 2);
    
    g.addEdge(1, 6);
    g.addEdge(2, 3);
//     g.addEdge(2, 7);
    g.addEdge(3, 4);
    g.addEdge(3, 7);
   g.addEdge(3, 6);
    g.addEdge(4, 5);
//     g.addEdge(5, 6);
    g.addEdge(7, 8);
    // g.addEdge(5, 7);
    g.addEdge(6, 2);
      g.printGraph();
     g.dfs(1);
//        System.out.println();
    //  g.dfsDisconnected(7);
        System.out.println();
        g.topologicalSort();
//
        System.out.println();
        g.bfs(1);

        if(g.isCyclic())
            System.out.println(" graph contains cycle");
        else
            System.out.println("graph doesnt contains cycle");
        
//        System.out.println();
//        String word[]={"baa", "abcd", "abca", "cab", "cad"};
//       characterWord(word, word.length, 4);

        ///////FOR PARENT CHILD TUPLES CHECK

      //  int v=4;
       // GraphParentChild pc=new GraphParentChild(v);
//        pc.addEdge('a'-97, 'b'-97);
//        pc.addEdge('a'-97, 'c'-97);
//        pc.addEdge('b'-97, 'g'-97);
//        pc.addEdge('c'-97, 'h'-97);
//        pc.addEdge('e'-97, 'f'-97);
//        pc.addEdge('b'-97, 'd'-97);
//        pc.addEdge('c'-97, 'e'-97);

//        pc.addEdge('a'-97, 'b'-97);
//       // pc.addEdge('b'-97, 'c'-97);
//        pc.addEdge('c'-97, 'd'-97);
//        if(pc.addEdge('a'-97, 'b'-97) && pc.addEdge('a'-97, 'c'-97)&& pc.addEdge('b'-97, 'd'-97))
//        {
//        pc.printGraph();
//       // System.out.println(pc.dfs('a'-97));
//        System.out.println(pc.parentChildError());
//        }
//        else
//        {
//            System.out.println("Error E2");
//        }





    }

        //find a given character in a dictionary of alien language
    public static void characterWord(String words[],int n,int v)
    {
        Graph f=new Graph(v);
        for(int i=0;i<n-1;i++)
        {
           String word1=words[i];
           String word2=words[i+1];
           for(int j=0;j<Math.min(word1.length(), word2.length());j++)
           {
               if(word1.charAt(j)!=word2.charAt(j))
               {
                   f.addEdge(word1.charAt(j)-97, word2.charAt(j)-97);
                   break;
               }
           }
        }
        f.topologicalSort();
    }
    
    
    







}
