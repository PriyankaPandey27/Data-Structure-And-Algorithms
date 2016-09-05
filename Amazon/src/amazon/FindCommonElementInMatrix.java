/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.HashMap;
import java.util.Map;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author admin
 */
public class FindCommonElementInMatrix {
    
    public static void main(String[] args) {
        
        int m[][]={{1, 2, 3, 4, 5},
                    {2, 3, 5, 8, 10},
                    {2, 5, 5, 9, 11},
                    {1, 3, 5, 7, 9} };
        
        System.out.println("the common number is " + findCommonElement(m));
        findCommonHashMap(m);
        
    }

    //o(nm) complexity with o(m) space
    
    public static int findCommonElement(int m[][])
    {
        int row=m.length;
        int col=m[0].length;
        
        int column[]=new int[col+1];
        int min_row=0;
        for(int i=0;i<row;i++)
            column[i]=col-1;
        
        while(column[min_row]>=0)
        {
            //finding minimum in last column
            for(int i=0;i<row;i++)
            {
                if(m[i][column[i]]<m[min_row][column[min_row]])
                {
                    min_row=i;
                }
            }
            
            int count=0;
            
            for(int i=0;i<row;i++)
            {
                if(m[i][column[i]]<m[min_row][column[min_row]])
                {
                    if(column[i]==0)
                        return -1;
                    
                    column[i]-=1;
                }
                else
                    count+=1;
            }
            
            if(count==row)
                return m[min_row][column[min_row]];
        }
        return -1;
        
    }


    public static void findCommonHashMap(int m[][])
    {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int row=m.length;
        int col=m[0].length;

        for(int i=0;i<col;i++)
            h.put(m[0][i], 0);

        for(int i=1;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(h.containsKey(m[i][j]) && h.get(m[i][j])!=i)
                {
                    h.put(m[i][j], h.get(m[i][j])+1);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry: h.entrySet())
        {
            if(entry.getValue()==row-1)
            {
                System.out.println(entry.getKey());
                return;
            }
            
        }
        System.out.println("no common element");
    }



}
