
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MaxSubArray;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MaxSubAarray {

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {

        if(a==null||a.size()==0)
                return null;

        ArrayList<Integer> b=new ArrayList<Integer>();
        int startindex=0;
        int start=0;
        int endindex=0;
        int max_soFar=Integer.MIN_VALUE;
        int curr=a.get(0);

        for(int i=1;i<a.size();i++)
        {
            curr=Math.max(a.get(i), curr+a.get(i));
            if(curr>max_soFar)
            {
                max_soFar=curr;
                start=startindex;
                endindex=i;
            }
            else
            {
                startindex=i;
            }
        }
        if(max_soFar>=0)
        {
        
        for(int i=start;i<=endindex;i++)
        {
            b.add(new Integer(a.get(i)));
        }
        }
        return b;

	}

    public static void main(String[] args) {

        ArrayList<Integer> b=new ArrayList<Integer>();
//        b.add(1);
//        b.add(2);
//        b.add(5);
//        b.add(-7);
//        b.add(2);
//        b.add(3);

        b.add(-1);
        b.add(-1);
        b.add(-1);
        b.add(-1);
        b.add(-1);
        b.add(-1);

//        b.add(0);
//        b.add(0);
//        b.add(-1);
//        b.add(0);

        System.out.println(maxset(b).toString());


    }


}
