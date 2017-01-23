/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShortestPathDirected;

/**
 *
 * @author admin
 */
public class AdjListNode {
    int dest;
    int weight;
    AdjListNode next;

    public AdjListNode(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
        this.next=null;
    }



}
