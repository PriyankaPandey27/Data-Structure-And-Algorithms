/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Searching;

/**
 *
 * @author admin
 */



public class TournamentMethod {

    public static void main(String[] args) {


        int a[]={8000, 11, 40045, 100, -330, 3000};
//        MinMax k= minMaxElement(a,0,a.length-1);
//        System.out.println("the minimum element is " + k.min);
//        System.out.println("the maximum element is " + k.max);

        firstMaxScndMax f=frstMaxScndMaxElement(a, 0, a.length-1);
         System.out.println("the second maximun element is " + f.smax);
        System.out.println("the first maximum element is " + f.fmax);
    }

// findmin and max element in an array using less comparision
    public static MinMax minMaxElement(int a[],int low,int high)
    {
        int mid=0;
        MinMax m=new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);
        MinMax lowMid,midHigh;

        if(low==high)
        {
            m.min=a[low];
            m.max=a[high];
            return m;
        }

        if(low==high-1)
        {
            if(a[low]>a[high])
            {
                m.max=a[low];
                m.min=a[high];
            }
            else
            {
                m.max=a[high];
                m.min=a[low];
            }
            return m;
        }

        mid=(high+low)/2;
        lowMid=minMaxElement(a,low,mid);
        midHigh=minMaxElement(a,mid+1,high);

        if(lowMid.min<midHigh.min)
        {
            m.min=lowMid.min;
        }
        else
        {
            m.min=midHigh.min;
        }

        if(lowMid.max>midHigh.max)
        {
            m.max=lowMid.max;
        }
        else
        {
            m.max=midHigh.max;
        }

        return m;




    }


    //find frst max and second max element from array
    public static firstMaxScndMax frstMaxScndMaxElement(int a[],int low,int high)
    {
        int mid=0;
        firstMaxScndMax m=new firstMaxScndMax();
        firstMaxScndMax lowMid,midHigh;

        if(low==high)
        {
            m.fmax=a[low];
            m.smax=a[high];
            return m;
        }

        if(low==high-1)
        {
            if(a[low]>a[high])
            {
                m.fmax=a[low];
                m.smax=a[high];
            }
            else
            {
                m.fmax=a[high];
                m.smax=a[low];
            }
            return m;
        }

        mid=(high+low)/2;
        lowMid=frstMaxScndMaxElement(a,low,mid);
        midHigh=frstMaxScndMaxElement(a,mid+1,high);

        

        if(lowMid.fmax>midHigh.fmax)
        {
            m.fmax=lowMid.fmax;
            m.smax=midHigh.fmax;
            if(lowMid.fmax>lowMid.smax && lowMid.smax>midHigh.fmax)
               {
                  m.fmax=lowMid.fmax;
                  m.smax=lowMid.smax;
               }
        }
        else
        {
            m.fmax=midHigh.fmax;
            m.smax=lowMid.fmax;
            if(midHigh.fmax>midHigh.smax && midHigh.smax>lowMid.fmax)
             {
                m.fmax=midHigh.fmax;
                m.smax=midHigh.smax;
             }
        }

        
       return m;




    }



}


