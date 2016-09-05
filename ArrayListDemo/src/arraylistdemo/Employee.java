/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylistdemo;

/**
 *
 * @author admin
 */
public class Employee {

    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       super.toString();
       return "name = "+ name +" "+ "id =" +id;
    }



}
