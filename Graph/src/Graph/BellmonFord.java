/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

/**
 *
 * @author admin
 */



class AdjListNodeBellmond
{
    int dest;
    AdjListNodeBellmond next;

        public AdjListNodeBellmond()
        {
        }
    // creating new adjancy list node
    public AdjListNodeBellmond(int d) {
        dest=d;
        next=null;
    }

}

// adjnacy list class
class AdjListBellmond
{
    AdjListNodeBellmond head; // pointer to head node of the list
}


class GraphBellmond
{
    int V;
    AdjListBellmond[] array;
    int edgeWeight[][];
    public static int distance[]=null;

    public GraphBellmond(int v) {
        V=v;
        // create an array of adjancey list . Size of the list is V
        array=new AdjListBellmond[V];

        for(int i=0;i<V;i++)
        {
            array[i]=new AdjListBellmond();

        }

        // initialze each list as empty by making head as null
        for(int i=0;i<V;i++)
        {
            array[i].head=null;  //new AdjListNode();
            //null;
        }
        edgeWeight = new int[V][V];

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                edgeWeight[i][j]=0;
            }
        }
    }

     // Add edge to an undirected graph
    public void addEdgeBellmond(int s,int d ,int w)
    {
     // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining

        AdjListNodeBellmond newNode=new AdjListNodeBellmond(d);
        newNode.next=array[s].head;
        array[s].head=newNode;

        edgeWeight[s][d] = w;
//        if(u!=d)
//        {
//         //Case 1 : UnDirected graph
//        newNode= new AdjListNode(u);
//        newNode.next=array[d].head;
//        array[d].head=newNode;
//        }
        // Case 2 : Directed Graph
    // Since graph is directed, NO NEED TO ADD an edge from dest to src also
//        newNode= new AdjListNode(u);
//        newNode.next=array[d].head;
//        array[d].head=newNode;

    }

     public void removeEdge(int s)
    {
     // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining

        array[s].head=array[s].head.next;

     }

    public void printGraph(String message)
    {
        System.out.println("** "+ message+ " **");
        int v;
        for(v=0;v<V;v++)
        {
            AdjListNodeBellmond pCrawl=array[v].head;
            System.out.print("Adjancey list of vertex: "+v+" \nhead");
            while(pCrawl!=null)
            {
                System.out.print(" -> "+pCrawl.dest + " (W="+edgeWeight[v][pCrawl.dest]+ ")");
                pCrawl=pCrawl.next;
            }

            System.out.println();
        }
    }

    public int addNewEdge(int s,int w,int end)
    {
        boolean visit[]=new boolean[V];

        AdjListNodeBellmond pCrawl=array[s].head;
//        System.out.println("pCrawal " + pCrawl.dest);
        visit[s]=true;
        while(pCrawl!=null)
        {
            visit[pCrawl.dest]=true;
            pCrawl=pCrawl.next;

        }
        int min=distance[end];
//        System.out.println("min intitial  " + min);
        for(int i=1;i<V;i++)
        {
//            System.out.println("visit[i] = " + visit[i]);
            if(visit[i]==false && i!=s)
            {
                addEdgeBellmond(s,i, w);
                AdjListNodeBellmond dude=array[s].head;
//        System.out.println("pCrawal " + pCrawl.dest);
        visit[s]=true;
        while(dude!=null)
        {
            visit[dude.dest]=true;
            System.out.println(dude.dest);
            dude=dude.next;

        }
                bellmanFord(s);
                 System.out.println("min insde loop " + distance[end]);
                System.out.println("enfd " + end);
                if(min>distance[end])
                {
                   
                    min=distance[end];
                }
                removeEdge(s);
            }

        }

//        System.out.println("min cost path " + min);
        return min;

    }


    public void bellmanFord(int source){
            distance = new int[V];

        // Step 1 : initlizing an array with some weights
        for(int i=0;i<=V-1;i++)
            distance[i]= Integer.MAX_VALUE;

        distance[source]=0;

        // Step 2 : Relaxation  step
        for(int u=0;u<=V-1;u++) // For all vertices
        {
            AdjListNodeBellmond pCrawl=array[u].head;
            while(pCrawl!=null)
            {

             if(distance[u] != Integer.MAX_VALUE &&
                     distance[u]+ edgeWeight[u][pCrawl.dest] < distance[pCrawl.dest] &&
                     edgeWeight[u][pCrawl.dest]>0)
             {
                distance[pCrawl.dest] = distance[u]+ edgeWeight[u][pCrawl.dest];
                // System.out.println("distance insde bellmond "+ distance[pCrawl.dest] + " dest is " + pCrawl.dest);
             }
                pCrawl=pCrawl.next;
            }
        }

        for(int j=1;j<V;j++)
        {
            System.out.println("distance from 1 " + distance[j]);
        }
        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.

        for(int u=0;u<V;u++)
        {
            for(int v=0;v<V;v++)
            {
                if(edgeWeight[u][v]!=0)
                {
                    if(distance[u]!=Integer.MAX_VALUE &&
                            distance[u]+edgeWeight[u][v]<distance[v])
                    {
                        System.out.println("Graph contains negative weight cycle");
                    }
                }
            }
        }
    }

    public void isGraphContainsNegativeWeightCycle(){

        if(isGraphContainsNegativeWeightCycleUtils()!=-1)
            System.out.println("Graph contains -ive weight cycle");
         else
             System.out.println("Graph does NOT contains -ive weight cycle");

    }

    int cycle[] ;
    public int isGraphContainsNegativeWeightCycleUtils(){

        cycle = new int[V+1];
        for(int i=0;i<=V;i++)
            cycle[i]=-1;

        for(int s=1;s<=V-1;s++) // For source vertices
        {
            AdjListNodeBellmond pCrawl=array[s].head;
            while(pCrawl!=null)   // for sink vertices
            {
                cycle[s]=pCrawl.dest;  // source index contains dest vetex
             if(distance[s]+ edgeWeight[s][pCrawl.dest] < distance[pCrawl.dest])
             {
                return s;
             }
                pCrawl=pCrawl.next;
            }
        }
        return -1;
    }

    public void printNegativeWeightCycle(){
        int sourceVertex = isGraphContainsNegativeWeightCycleUtils();
        if(sourceVertex != -1){
            System.out.println("Printing cycle");

            while(sourceVertex!=-1 && sourceVertex!=cycle[sourceVertex]){
                System.out.print(sourceVertex+ "    ");
                sourceVertex=cycle[sourceVertex];
            }
              System.out.print(sourceVertex+ "  ");
        }
        else
        {
             System.out.println("Negative weight cycle is not present");
        }
    }


    public void printBellmanFordDistance(String s){
        System.out.println("******* " + s +" *******");
        System.out.println("Vertex      Distance from Source Vertex");
        for(int i=1;i<=V-1;i++){
            System.out.println(i+"      "+ distance[i]);
        }
    }

}


class BellmanFord {
 public static void main(String[] args) {
      int v=6;
      GraphBellmond g=new GraphBellmond(v);

      // Directed Graph
      g.addEdgeBellmond(1, 2,1);
      //g.addEdge(1, 3,4);
      g.addEdgeBellmond(3, 1, 10);
      g.addEdgeBellmond(2, 3,3);
      g.addEdgeBellmond(2, 4, 2);
      g.addEdgeBellmond(4, 2, 1);
      g.addEdgeBellmond(4, 3, 5);
      g.addEdgeBellmond(2, 5, 2);
      g.addEdgeBellmond(5, 4, 3);

     // g.printGraph("Graph");
      g.bellmanFord(1);
//      g.printBellmanFordDistance("After Bellman Ford algo");
//      g.isGraphContainsNegativeWeightCycle();
//      g.printNegativeWeightCycle();
//     int a[]={2,4,3,4,5};
//     int b[]={1,1,2,3,4};
//     int w[]={2,4,1,3,1};
//     minCost(5, a, b, w, 1, 4, 2);
 }

 public static int minCost(int g_nodes, int[] g_from, int[] g_to, int[] g_weight, int start, int end, int w_extra)
 {

     GraphBellmond g=new GraphBellmond(g_nodes+1);
     for(int i=0;i<g_from.length;i++)
     {
         g.addEdgeBellmond(g_to[i],g_from[i] ,g_weight[i]);
     }
     g.bellmanFord(start);
     return  g.addNewEdge(start, w_extra, end);
//     System.out.println(g.distance[end]);
//     return g.distance[end];
 }
}