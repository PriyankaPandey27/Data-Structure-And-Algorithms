/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sortdate;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class Main {

    
    public static void main(String[] args) {

       List<DateYear> t=new ArrayList<DateYear>();
       DateYear d=new DateYear(20, 1, 2014);
       DateYear d1=new DateYear(25, 3, 2010);
       DateYear d2=new DateYear(3, 12, 2000);
       DateYear d3=new DateYear(18, 11, 2001);
       DateYear d4=new DateYear(19, 4, 2015);
       DateYear d5=new DateYear(9, 7, 2005);
       
       DateYear d6=new DateYear(5, 3, 2005);
       DateYear d7=new DateYear(5, 3, 2005);
       DateYear d8=new DateYear(5, 3, 2017);

          t.add(d8);
       t.add(d);
       t.add(d1);
       t.add(d2);
       t.add(d3);
       t.add(d4);
       t.add(d5);
       t.add(d6);
       t.add(d7);
    

//       printDate(t,"before sorting---------");
//       Collections.sort(t, DateYear.yearComparator);
//        printDate(t,"after sorting by year---------");
        
        printDate(t,"before sorting---------");
       Collections.sort(t, DateYear.dayComparator);
        printDate(t,"after sorting by day---------");

        String s1="";
        String s2=null;




    }


    public static void printDate(List<DateYear> t,String s)
    {
        System.out.println(s);
        for(DateYear d: t)
        {
            System.out.println(d.getDay()+" "+ d.getMonth()+ " " +  d.getYear());
        }
    }

   



}
