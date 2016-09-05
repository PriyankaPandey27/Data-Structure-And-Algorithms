
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class HeapInLinearTime {
    
   // private static int a[]={1,1,2,3,4,4,6,7};
    private static int a[]={10,14,5,7,1,-1,4,12,22,23,44};
    private static int topindex=0;
    private static int maxHeap[]=new int[a.length+1];
    
    public static void main(String args[]) throws IOException
    {
       //constructMaxHeap(8);
     //  maxHeapLinearTime(a.length);
      // printOut("max heap is given as");
      // constructMinHeap(12);
      // printOutMin("the min heap is given as");
       // System.out.println();
        
       findMax(a.length);


//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int len = Integer.valueOf(br.readLine()).intValue();
//     int maxHeap[]=new int[len+1];

    }


    public static void findMax(int k)
    {
        maxHeapLinearTime(k);
        int res=maxHeap[1];
        maxHeap[1]=maxHeap[topindex];
        topindex--;
        sinkDown(1);
        

        System.out.println("max element is " + res);
        printOut("heap is ");
    }



    public static void printOut(String s)
    {
        System.out.println(s);
        for(int i=1;i<=topindex;i++)
        {
            System.out.print(maxHeap[i] + " ");
        }
    }

    
    
    public static void constructMaxHeap(int k)
    {
       maxHeap[0]=Integer.MIN_VALUE;
       for(int i=0;i<k;i++)
       {
           topindex++;
           maxHeap[i+1]=a[i];
           
       }
        System.out.println("topindex " + topindex);
    }

    public static void maxHeapLinearTime(int k)
    {
        constructMaxHeap(k);
        for(int i=(topindex)/2;i>0;i--)
        {
            System.out.println("i vale :: " + i);
           // int r=maxHeap[i];
            //maxHeap[i]=maxHeap[topindex];
            //maxHeap[topindex]=r;
            sinkDown(i);
          //  printOut("heap at index");



        }
    }
    
    public static void insert(int p)
    {
        if(p==0)
        {
            maxHeap[1+p]=a[p];
        }
        else
        {
            swimUp(p+1);
        }
    }
    
    public static void swimUp(int p)
    {
        maxHeap[p]=a[p-1];
        while(p/2>0 && maxHeap[p/2]<maxHeap[p])
        {
            int temp=maxHeap[p/2];
            maxHeap[p/2]=maxHeap[p];
            maxHeap[p]=temp;
            p=p/2;
        }
    }
    
    public static void sinkDown(int i)
    {
        int p=i;
        int maxchild;
        //System.out.println("p " + p + " topindex " +topindex);
      //  System.out.println("left " + getLeft(p));
       // System.out.println("rigth " + getRight(p));
       // System.out.println("parent " + maxHeap[p]);
        if(getRight(p)<=topindex)
        {
           // System.out.println("right child inside " + getRight(p));
        while((getLeft(p)<=topindex || getRight(p)<=topindex ) && (maxHeap[getLeft(p)]>maxHeap[p] || maxHeap[getRight(p)]>maxHeap[p]))
        {
            // System.out.println("inside while p = " +p);

            if(getRight(p)<=topindex)
            {
                if(maxHeap[getLeft(p)]>maxHeap[getRight(p)])
                {
                    maxchild=getLeft(p);
                }
                else
                    maxchild=getRight(p);
            }
            else

                   maxchild=getLeft(p);
            //System.out.println("max child " + maxchild);
            if(maxHeap[maxchild]>maxHeap[p])
            {
                int t=maxHeap[maxchild];
                maxHeap[maxchild]=maxHeap[p];
                maxHeap[p]=t;
                p=maxchild;
            }
//            else
//            {
//                System.out.println("inside else p = " +p);
//                break;
//            }

            if(getRight(p)>topindex && getLeft(p)<=topindex)
            {
                //System.out.println("inside insider if " + p);
                if(maxHeap[p]<maxHeap[getLeft(p)])
                {
                    int k=maxHeap[getLeft(p)];
                    maxHeap[getLeft(p)]=maxHeap[p];
                    maxHeap[p]=k;

                }
                 break;
            }
        
        }
        }

        else 
        {
             maxchild=getLeft(p);

            if(maxHeap[maxchild]>maxHeap[p])
            {
                int t=maxHeap[maxchild];
                maxHeap[maxchild]=maxHeap[p];
                maxHeap[p]=t;
                p=maxchild;
            }
        }
        
       
    }
    
    
     public static int getLeft(int i)
    {
        return 2*i;
    }

    public static int getRight(int i)
    {
        return 2*i + 1;
    }

   

    

   

}
