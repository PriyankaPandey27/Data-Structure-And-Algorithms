/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractExample;

/**
 *
 * @author admin
 */
public class Outlet {

    public static void main(String[] args) {

        BakePizza pz=new Magarita();
        pz.bakePizza("cheese");
        BakePizza pf=new Farmhouse();
        pf.bakePizza("capsicum");
    }

}
