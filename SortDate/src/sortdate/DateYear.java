/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sortdate;

import java.util.Comparator;

/**
 *
 * @author admin
 */
public class DateYear{

    int day;
    int month;
    int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public DateYear(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        String s = day + " :: "+ month + " :: " + year;
        return s;
    }





    public static final Comparator<DateYear> yearComparator=new Comparator<DateYear>(){

        public int compare(DateYear o1, DateYear o2) {
//            System.out.println("year o1 " + o1.getYear()+" year o2" + o2.getYear());
//            System.out.println("result " + (o1.getYear()-o2.getYear()));
            return o1.getYear()-o2.getYear();
        }

    };

     public static final Comparator<DateYear> monthComparator=new Comparator<DateYear>(){

        public int compare(DateYear o1, DateYear o2) {
            if(o1.getYear()==o2.getYear())
            return o1.getMonth()-o2.getMonth();
            else
              return yearComparator.compare(o1, o2);
        }

    };
      public static final Comparator<DateYear> dayComparator=new Comparator<DateYear>(){

        public int compare(DateYear o1, DateYear o2) {
                    //  System.out.println("o1 :: " + o1.toString() + " o2 :: " + o2.toString() );

             if(o1.getYear()!=o2.getYear())
            return yearComparator.compare(o1, o2);
            else
            {
            
            if(o1.getMonth()!=o2.getMonth())
            {
               return monthComparator.compare(o1, o2);
            }
            else
            {
             if(o1.getDay()!=o2.getDay())
            {
               return o1.getDay()-o2.getDay();
            }
             else
             {
                return 1;
             }
            }
        }
        }

    };

   

    

}
