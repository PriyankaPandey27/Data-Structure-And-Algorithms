/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author admin
 */
public class Main {

     public static void main(String[] args) throws IOException {

        // Factory st=new Factory();
         System.out.println("enter your choice");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String c = br.readLine().toString();
         Shape k=Factory.shapeType(c);
         k.draw();

    }

}
