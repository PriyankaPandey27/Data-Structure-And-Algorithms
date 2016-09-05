/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceExample;

/**
 *
 * @author admin
 */
public class Magarita implements BakePizza,ServeToCustomer{

    public void bakePizza(String topping) {
        System.out.println("baking magarita with " + topping);
    }

    public void serve(String s) {
        System.out.println("magarita pizza is served " + s);
    }

}
