/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryPatter2;

/**
 *
 * @author admin
 */
public class ComputerFactory {

    public static Computer getType(String t,String Ram,String Hdd,String Cpu)
    {
        if(t.equalsIgnoreCase("PC"))
            return new PC(Ram,Hdd,Cpu);
        else if(t.equalsIgnoreCase("Server"))
            return new Server(Ram,Hdd,Cpu);
        else
            return null;
    }

}
