/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceSegregation;

/**
 *
 * @author admin
 */
public class Manager {

    IWorkable w;

    public void setWorker(IWorkable worker)
    {
        this.w=worker;
    }

    public void manage()
    {
        w.work();
    }

}
