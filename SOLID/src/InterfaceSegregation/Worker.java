/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceSegregation;

/**
 *
 * @author admin
 */
public class Worker implements IFeedable,IWorkable{

    public void eat() {
        System.out.println("inside worker eating");
    }

    public void work() {
        System.out.println("inside worker working");
    }

}
