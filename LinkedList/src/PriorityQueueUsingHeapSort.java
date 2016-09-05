/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class PriorityQueueUsingHeapSort {

    private static int a[]={1,12,30,11,4,8,3,5};
    private static int topindex=0;
    private static int topminidx=0;
    private static int maxHeap[]=new int[a.length+1];
    private static int minHeap[]=new int[a.length+1];
    private static int auxHeap[]=new int[a.length+1];
    
    public static void main(String args[])
    {
        constructMaxHeap();
        printOut("maximum heap is ");
//        constructMinHeap();
//        printOutMin("the given min heap is");
       // printOut("the given array is");

       System.out.println();
       kSmallerInPlaceMax(1,12);
      // kSmallerInPlace(0, 31);
//        heapSortMin();
//        printOutMin("after heap sort");
        //System.out.println();
        // findkSmaller(11);
//          System.out.println("the kth smallest element is ");
         // kthSmallerElement(4);

       // System.out.println("using max heap ");
       // kthSmallElementMaxHeap(4);

//          System.out.println("kth largest element is");
        //  kthLargestElement(5);
       //System.out.println("the deleted element is " + delAtIndex(4));
//        printOutMin("after deleting element at ith index");
      //  System.out.println();
       // findMax();
       // heapSort();
       // printOut("after heap sort");
    }

    public static void printOut(String s)
    {
        System.out.println(s);
        for(int i=1;i<=topindex;i++)
        {
            System.out.print(maxHeap[i]+ " ");
            //System.out.println();
        }
    }

    public static void constructMaxHeap()
    {
        maxHeap[0]=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            insert(i);
            topindex++;
        }
    }

    public static void insert(int i)
    {
        if(i==0)
        {
            maxHeap[i+1]=a[i];
        }
        else
        {
            swimUp(i+1);
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

    public static void heapSort()
    {
        while(topindex>0)
        {
            System.out.print(delMax()+ " ");
        }

    }

    public static int delMax()
    {
        int r=maxHeap[1];
        maxHeap[1]=maxHeap[topindex];
        topindex--;
        sinkDown();
        return r;
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
                {
                    maxchild=getRight(p);
                }
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


/// constructing minimum heap

    public static void constructMinHeap()
    {
        minHeap[0]=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            insertMin(i);
            topminidx++;
        }
       // System.out.println(topminidx);
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

    public static void findMax()
    {
        int maxElmnt=Integer.MIN_VALUE;
        for(int i=(topminidx/2);i<=topminidx;i++)
        {
            if(minHeap[i]>maxElmnt)
            {
                maxElmnt=minHeap[i];
            }
        }
        System.out.println("maximum element in minHeap" + maxElmnt);
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

      public static int delMin()
    {
        int r=minHeap[1];
        minHeap[1]=minHeap[topminidx];
        topminidx--;
        sinkDownMin();
        return r;
    }

       public static void heapSortMin()
    {
        while(topminidx>0)
        {
            System.out.print(delMin()+ " ");
        }

    }

       public static int delAtIndex(int i)
       {
           System.out.println(topminidx);
           if(topminidx<i)
           {
               System.out.println("index cannot be found");
           }

           int ret=minHeap[i];
           minHeap[i]=minHeap[topminidx];
           topminidx--;
           sinkDownMinAtIndx(i);
           return ret;

       }

        public static void sinkDownMinAtIndx(int i)
    {
        int p=i;
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

        public static void findkSmaller(int k)
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

        public static void kSmallerInPlace(int i,int k)
        {

            if(i==0)
            {
                kSmallerInPlace(1, k);
            }
            if(i<=topminidx && i!=0)
            {
                if(minHeap[i]<k)
                    System.out.println(minHeap[i]);
                kSmallerInPlace(getLeft(i), k);
                kSmallerInPlace(getRight(i), k);

            }

        }

        public static void kSmallerInPlaceMax(int i,int k)
        {
//            if(i==0)
//                kSmallerInPlaceMax(1, k);

            if(i<=topindex)
            {
                if(maxHeap[i]<k)
                    System.out.println(maxHeap[i]);
                kSmallerInPlaceMax(getLeft(i), k);
                kSmallerInPlaceMax(getRight(i), k);
            }
        }

        public static void kthSmallerElement(int k)
        {
            int count=0;
            while(topminidx>0)
            {
                
                int r=minHeap[1];
                minHeap[1]=minHeap[topminidx];
                topminidx--;
                count++;
                sinkDownMin();

                 if(count==k)
                {
                    System.out.println(r);
                }
               
            }
        }

        public static void kthSmallElementMaxHeap(int k)
        {
            for(int i=k;i<topindex;i++)
            {
                if(maxHeap[i]<maxHeap[1])
                {
                    maxHeap[1]=maxHeap[i];
                    topindex--;
                    sinkDown();
                }

            }
            System.out.println("the kth smallest number is " + maxHeap[1]);
        }
        
        
        public static void kthLargestElement(int k)
        {
            int count=0;
            while(topindex>0)
            {
                int r=maxHeap[1];
                maxHeap[1]=maxHeap[topindex];
                topindex--;
                count++;
                sinkDown();
                if(count==k)
                {
                    System.out.println(r);
                }
            }
        }







}
