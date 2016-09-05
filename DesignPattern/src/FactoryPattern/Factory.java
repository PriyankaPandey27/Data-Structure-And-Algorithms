/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FactoryPattern;

/**
 *
 * @author admin
 */
public class Factory {

    public static Shape shapeType(String s)
    {
        if(s.equalsIgnoreCase("Rectangle"))
        return new Rectangle();

        if(s.equalsIgnoreCase("Circle"))
        return new Circle();

        if(s.equalsIgnoreCase("Square"))
            return new Square();

        return null;
    }

}
