/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author admin
 */
class BoxStackingProblem {

    public static void main(String[] args) {

        Box arr[]={new Box(4, 6, 7),new Box(1, 2, 3),new Box(4, 5, 6),new Box(10, 12, 32)};
        maxStackHeight(arr, arr.length);
        
    }

    public static void maxStackHeight(Box a[],int n)
    {
        if(a==null || n==0)
            return;

        Box rot[]=new Box[3*n];
        int index=0;
        for(int i=0;i<n;i++)
        {
            rot[index]=a[i];
            index++;
//             System.out.println("width " + a[i].width);
//             System.out.println("depth " + a[i].depth);
//             System.out.println("height " + a[i].height);
//             System.out.println("index heigth " +rot[index].height );
            //first rotation
            rot[index] = new Box();
            rot[index].height=a[i].width;
            rot[index].depth=Math.max(a[i].height, a[i].depth);
            rot[index].width=Math.min(a[i].height, a[i].depth);
            index++;

            //second rotation
            rot[index] = new Box();
            rot[index].height=a[i].depth;
            rot[index].depth=Math.max(a[i].height, a[i].width);
            rot[index].width=Math.min(a[i].height, a[i].width);
            index++;



        }
        n=3*n;
       // ArrayList<Box> ls=new ArrayList<Box>();

        Collections.sort(Arrays.asList(rot), Box.baseComparator);
        //System.out.println(Arrays.asList(rot));

        int m[]=new int[n];
        for(int i=0;i<n;i++)
        {
            m[i]=rot[i].height;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(rot[i].width<rot[j].width && rot[i].depth<rot[j].depth && m[i]<m[j] + rot[i].height)
                    m[i]=m[j]+rot[i].height;
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<m[i])
                max=m[i];
        }

        System.out.println("the maximum length of the box stacked " + max);

    }

}

class Box
{
    int height;
    int width;
    int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

//    public Box() {
//    }


    public static final Comparator<Box> baseComparator=new Comparator<Box>() {

        public int compare(Box o1, Box o2) {
            return (o2.depth*o2.width)-(o1.depth*o1.width);
        }
    };

    Box() {


    }

    @Override
    public String toString() {
        return String.valueOf(height) + " : " + String.valueOf(width) + " : " + String.valueOf(depth);
    }





}
