/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FkSetThirtyEight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author admin
 */
public class ElementInConstantTime {

    public static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public static ArrayList<Integer> arr=new ArrayList<Integer>();

    public static void main(String args[])
    {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        System.out.println();
        //System.out.println("the element as at index " +search(30));
       // delete(30);
       // System.out.println("the element as at index " +search(40));
        System.out.println("the random element is " + getRandom());
    }

    public static void insert(int x)
    {
        if(map.get(x)==null)
        {
            arr.add(x);
            int size=arr.size()-1;
            map.put(x, size);

        }
        else
            return;
    }

    public static void delete(int x)
    {
        if(map.get(x)!=null)
        {
            int index=map.get(x);
            map.remove(x);
            int lastElemnt=arr.get(arr.size()-1);
            arr.set(index, lastElemnt);
            arr.set(arr.size()-1, x);
            arr.remove(arr.size()-1);
            map.put(lastElemnt, index);
        }
        else
            return;
    }

    public static int search(int x)
    {
        if(map.get(x)!=null)
        return map.get(x);
        else
            return -1;
    }

    public static int getRandom()
    {
        Random rand=new Random();
        int index=rand.nextInt(arr.size());
        //System.out.println("print index " + index);
        return arr.get(index);

    }



}
