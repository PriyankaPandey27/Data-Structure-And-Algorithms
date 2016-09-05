/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SingletonPattern;

/**
 *
 * @author admin
 */
public class SingleObject {

    public static SingleObject single1=new SingleObject();
    private SingleObject()
    {

    }

    public void showMessage()
    {
        System.out.println("show the message inside singleton");
    }

}
