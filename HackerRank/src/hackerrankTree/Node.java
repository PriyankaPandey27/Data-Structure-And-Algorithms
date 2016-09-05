/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrankTree;

/**
 *
 * @author admin
 */
public class Node {

    Node right;
    Node left;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data,Node left,Node right) {

        this.data = data;
        this.left = left;
        this.right = right;
    }





}
