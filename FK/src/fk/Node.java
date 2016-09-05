/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fk;

/**
 *
 * @author admin
 */
public class Node {
    int x;
    Node next;
    Node down;

    public Node(int x) {
        this.x=x;
        this.next=next;

    }

    public Node( Node next, Node down) {
        this.next = next;
        this.down = down;
    }

    public Node(int x, Node next, Node down) {
        this.x = x;
        this.next = next;
        this.down = down;
    }









}
