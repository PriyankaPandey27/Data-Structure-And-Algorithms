
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
public class Heap {
    
   // private static int a[]={1,1,2,3,4,4,6,7};
    private static int a[]={10,3,-1,-3,5,3,6,7};
    private static int topindex=0;
    private static int topminidx=0;
    private static int maxHeap[]=new int[a.length+1];
    private static int minHeap[]=new int[a.length+1];
    
    public static void main(String args[]) throws IOException
    {
      constructMinHeap(8);
      findMax();
      // printOut("max heap is given as");
      // constructMinHeap(12);
      // printOutMin("the min heap is given as");
       // System.out.println();
       //printValueLessK(2);
       // System.out.println();
        // printOut("max heap is given as");
      // kthSmallestElement(3);
     // kthLargestElement(4);
       // medianHeap(a);
        //slidingMaxElement(a, 3);


//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int len = Integer.valueOf(br.readLine()).intValue();
//     int maxHeap[]=new int[len+1];

    }

    public static void printValueLessK(int k)
    {
        while(topminidx>0)
            {
                int r=minHeap[1];
                minHeap[1]=minHeap[topminidx];
                topminidx--;
                sinkDownMin();
                if(r<=k)
                {
                    System.out.println(r);
                }
                else
                    break;
            }
    }

     public static void findMax()
    {
        int maxElmnt=Integer.MIN_VALUE;
        for(int i=(topminidx/2)+1;i<=topminidx;i++)
        {
            if(minHeap[i]>maxElmnt)
            {
                maxElmnt=minHeap[i];
            }
        }
        System.out.println("maximum element in minHeap" + maxElmnt);
    }

    public static void printOut(String s)
    {
        System.out.println(s);
        for(int i=1;i<=topindex;i++)
        {
            System.out.print(maxHeap[i] + " ");
        }
    }

    public static void constructMinHeap(int k)
    {
        minHeap[0]=Integer.MIN_VALUE;
       for(int i=0;i<k;i++)
       {
           insertMin(i);
           topminidx++;
       }
    }
    
    
    public static void constructMaxHeap(int k)
    {
       maxHeap[0]=Integer.MIN_VALUE;
       for(int i=0;i<k;i++)
       {
           insert(i);
           topindex++;
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
    
    public static void sinkDown()
    {
        int p=1;
        int maxchild;
        while((getLeft(p)<=topindex || getRight(p)<=topindex) && (maxHeap[getLeft(p)]>maxHeap[p] || maxHeap[getRight(p)]>maxHeap[p]))
        {
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

    public static void insertMin(int p)
    {
        if(p==0)
        {
            minHeap[p+1]=a[p];
        }
        else
        {
            swimUpMin(p+1);
        }
    }

    public static void swimUpMin(int i)
    {
        minHeap[i]=a[i-1];
        while(i/2>0 && minHeap[i/2]>minHeap[i])
        {
            int t=minHeap[i/2];
            minHeap[i/2]=minHeap[i];
            minHeap[i]=t;
            i=i/2;

        }
       // System.out.println(minHeap[i]);

    }

     public static void printOutMin(String s)
    {
        System.out.println(s);
        for(int i=1;i<=topminidx;i++)
        {
            System.out.print(minHeap[i]+ " ");
            //System.out.println();
        }
    }

     public static void sinkDownMin()
    {
        int p=1;
        int minchild;
        while((getLeft(p)<=topminidx || getRight(p)<=topminidx) && (minHeap[getLeft(p)]<minHeap[p] || minHeap[getRight(p)]<minHeap[p]))
        {
            if(getRight(p)<=topminidx)
            {
                if(minHeap[getLeft(p)]<minHeap[getRight(p)])
                {
                    minchild=getLeft(p);
                }
                else
                {
                    minchild=getRight(p);
                }
            }
            else
                minchild=getLeft(p);


            if(minHeap[minchild]<minHeap[p])
            {
                int t=minHeap[minchild];
                minHeap[minchild]=minHeap[p];
                minHeap[p]=t;
                p=minchild;
            }
        }
    }

    public static void kthSmallestElement(int k)
    {
      for(int i=k;i<a.length;i++)
      {
         if( maxHeap[1]>a[i])
         {
            System.out.println(maxHeap[1]);
             maxHeap[1]=a[i];
             sinkDown();
         }
         else
             break;
      }

        System.out.println("kth smallest element is " + maxHeap[1]);
    }

    public static void kthLargestElement(int k)
    {
        for(int i=k;i<a.length;i++)
        {
            if(minHeap[1]<a[i])
            {
                minHeap[1]=a[i];
                sinkDownMin();
            }
            else
                continue;
        }
        System.out.println("kth largest element is " + minHeap[1]);
    }

    public static void medianHeap(int a[])
    {
        int n=a.length;
        if(n%2==0)
        {   maxHeap[0]=Integer.MIN_VALUE;
           for(int i=0;i<n/2;i++)
           {
            insert(i);
            topindex++;
           }

            int r=maxHeap[1];

            minHeap[0]=Integer.MIN_VALUE;
            System.out.println(n/2);
           for(int i=n/2;i<n;i++)
           {
               System.out.println(" inside for" +i);
           insertMin(i);
           topminidx++;
           }
            printOutMin("min heap ");
            int p=minHeap[1];
            System.out.println(r);
            System.out.println(p);
            int y=(r+p)/2;

            System.out.println("the median is " + y);

        }
        else
        {
             maxHeap[0]=Integer.MIN_VALUE;
           for(int i=0;i<=n/2;i++)
           {
            insert(i);
            topindex++;
           }

            int r=maxHeap[1];

            System.out.println("the median is " + r);

        }
    }

    public static void slidingMaxElement(int arr[],int k)
    {
        int n=arr.length;
        constructMaxHeap(k);
        int r=maxHeap[1];
        System.out.println(r);
        for(int i=k;i<n;i++)
        {
            maxHeap[1]=arr[i];
            sinkDown();
            int p=maxHeap[1];
            System.out.println(p);
        }

    }

   

}
