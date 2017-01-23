/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryPatter2;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Computer obj=ComputerFactory.getType("Server", "2gb", "500gb", "2.4ghz");
        obj.getRAM();
        obj.getHDD();
        obj.getCPU();


    }

}
