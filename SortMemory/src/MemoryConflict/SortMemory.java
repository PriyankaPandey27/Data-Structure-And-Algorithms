/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoryConflict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class SortMemory {

    public static void main(String[] args) {

        List<Thread> arr=new ArrayList<Thread>();

        Thread a[] = {new Thread(1, 512, 1, 'R'),
            new Thread(2, 432, 2, 'W'),
            new Thread(3, 512, 3, 'R'),
            new Thread(4, 932, 4, 'R'),
            new Thread(5, 512, 5, 'W'),
            new Thread(6, 932, 6, 'R'),
            new Thread(7, 835, 7, 'R'),
            new Thread(8, 432, 8, 'R')};

        arr.addAll(Arrays.asList(a));

        memoryConflict(arr);





    }

    public static void memoryConflict(List<Thread> arr)
    {
        if(arr==null)
            return;
        if(arr.size()==0||arr.size()==1)
            return;

        Collections.sort(arr, Thread.memoryBlock);
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i).getMryblock()==arr.get(i-1).getMryblock())
            {
                if(arr.get(i).getTime()<=arr.get(i-1).time+5)
                {
                int j=i-1;

                while((arr.get(i).getMryblock()==arr.get(j).getMryblock()) && (arr.get(i).getTime()<=arr.get(j).getTime()+5)
                        && j>=0)
                {
                    if(arr.get(i).getAccess()=='W'||arr.get(j).getAccess()=='W')
                    {
                        System.out.println("thread " + arr.get(i).getId() + " and " + arr.get(j).getId()+ " are getting conflict");
                    }
                    j--;
                }
                }
            }

        }
    }
}