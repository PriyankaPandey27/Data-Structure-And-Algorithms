/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceSegregation;

/**
 *
 * @author admin
 */
public class Infrastructure {

    IFeedable eaters;

    public void setEaters(IFeedable eater)
    {
        this.eaters=eater;
    }

}
