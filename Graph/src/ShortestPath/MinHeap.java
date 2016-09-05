/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ShortestPath;

/**
 *
 * @author admin
 */
class MinHeap {

   int capacity;
   int size;
   Node[] heap;
   int[] pos;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size=capacity;
        heap=new Node[capacity];
        pos=new int[capacity];
    }

}
