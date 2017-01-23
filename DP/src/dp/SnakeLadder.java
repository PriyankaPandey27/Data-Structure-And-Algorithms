/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class SnakeLadder {

    public static void main(String[] args) {

        int N = 30;
    int moves[]=new int[N];
    for (int i = 0; i<N; i++)
        moves[i] = -1;

    // Ladders
    moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;

    // Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
    moves[18] = 6;

        System.out.println(getMinDiceThrow(moves, N));

    }

    public static int getMinDiceThrow(int move[],int n)
    {
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
            visited[i]=false;

        Queue<QueueEntry> q=new LinkedList();
        visited[0]=true;
        q.add(new QueueEntry(0,0));
        QueueEntry r=new QueueEntry();
        while(!q.isEmpty())
        {
            r=q.peek();
            int v=r.vertex;
            
            if(v==n-1)
                break;
            
            q.remove();
            
            for(int j=v+1;j<=v+6 && j<n;j++)
            {
                QueueEntry a=new QueueEntry();
                a.dist=(r.dist+1);
                visited[j]=true;
                
                if(move[j]!=-1)
                    a.vertex=move[j];
                else
                    a.vertex=j;
                q.add(a);
                
            }
        }
        
        return r.dist;






    }

}

class QueueEntry
{
    int vertex;
    int dist;

    public QueueEntry()
    {

    }


    public QueueEntry(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

}
