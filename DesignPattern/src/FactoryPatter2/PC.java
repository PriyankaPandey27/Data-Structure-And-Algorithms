/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryPatter2;

/**
 *
 * @author admin
 */
public class PC extends Computer{

    String RAM;
    String HDD;
    String CPU;

    public PC(String x,String y,String z)
    {
        RAM=x;
        HDD=y;
        CPU=z;
    }

    @Override
    public void getRAM() {
        System.out.println("Ram is " + RAM);
    }

    @Override
    public void getHDD() {
        System.out.println("hdd is " + HDD);
    }

    @Override
    public void getCPU() {
        System.out.println("CPU is " + CPU);
    }

}
