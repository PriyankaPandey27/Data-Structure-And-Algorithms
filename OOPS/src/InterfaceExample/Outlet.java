/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceExample;

/**
 *
 * @author admin
 */
public class Outlet {

    public static void main(String[] args) {

        Magarita pz=new Magarita();
        pz.bakePizza("cheese");
        pz.serve("serving");
        BakePizza pf=new Farmhouse();
        pf.bakePizza("capsicum");
    }

}
