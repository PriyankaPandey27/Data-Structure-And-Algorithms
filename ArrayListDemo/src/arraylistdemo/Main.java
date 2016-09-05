/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylistdemo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(12);
        a.add(11);
        a.add(new Integer(22));
        a.add(new Integer(25));



        a.remove(new Integer(22));
        for(Integer p: a)
        {
            System.out.println(p);
        }

         ArrayList<Employee> emp=new ArrayList<Employee>();
        emp.add(new Employee("nmndfj","we23"));
        emp.add(new Employee("priya","we24"));

        for(Employee p: emp)
        {
            System.out.println(p.toString());
        }

    }

}
