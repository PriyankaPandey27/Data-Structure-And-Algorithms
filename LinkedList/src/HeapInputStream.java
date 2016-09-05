
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
public class HeapInputStream {
   // private static int n=0;
    private static int topindex=0;
    private static int maxHeap[];
    private static int a[];
    private static int minHeap[];
    private static int topindexmin=0;
     private static int x=0;
      private static int y=0;
       private static int z=0;


//    private static void ConstructMaxHeap(int l,int p)
//    {
//
//        a=new int[l];
//       // maxHeap=new int[l+1];
//        maxHeap[0]=Integer.MIN_VALUE;
//        for(int i=0;i<l;i++)
//        {
//           // insert(i);
//            topindex++;
//        }
//
//    }

    public static void insert(int i,int data)
    {
        if(i==0)
        {
       // maxHeap[i+1]=a[i];
            maxHeap[i+1]=data;
        }
        else
        {
            swimUp(i+1,data);
        }

    }

    public static void swimUp(int p,int data)
    {
        //maxHeap[p]=a[p-1];
        maxHeap[p]=data;
        while(p/2>0 && maxHeap[p]>maxHeap[p/2])
        {
            int temp=maxHeap[p];
            maxHeap[p]=maxHeap[p/2];
            maxHeap[p/2]=temp;
            p=p/2;
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

    public static void insertMin(int i,int data)
    {
        if(i==0)
        {
            minHeap[1]=data;
        }
        else
        {
            swimUpMin(i+1,data);
        }
    }

    public static void swimUpMin(int i,int data)
    {
        minHeap[i]=data;
        while(i/2>0 && minHeap[i/2]>minHeap[i])
        {
            int t=minHeap[i/2];
            minHeap[i/2]=minHeap[i];
            minHeap[i]=t;
            i=i/2;
        }
    }

    public static void sinkDownMin()
    {
        int i=1;
        int minChild;
        while((getLeft(i)<=topindexmin || getRight(i)<=topindexmin)  && (minHeap[getLeft(i)]<minHeap[i]||minHeap[getRight(i)]<minHeap[i]))
        {
            if(getRight(i)<=topindexmin)
            {
                if(minHeap[getLeft(i)]<minHeap[getRight(i)])
                {
                    minChild=getLeft(i);
                }
                else
                {
                    minChild=getRight(i);
                }
            }
            else
            {
                minChild=getLeft(i);
            }

            if(minHeap[minChild]<minHeap[i])
            {
            int t=minHeap[minChild];
            minHeap[minChild]=minHeap[i];
            minHeap[i]=t;
            i=minChild;
            }
        }

        
    }

    public static void sinkDown()
    {
        int i=1;
        int maxChild;
        while((getLeft(i)<=topindex || getRight(i)<=topindex) && (maxHeap[getLeft(i)]>maxHeap[i] || maxHeap[getRight(i)]>maxHeap[i]))
        {
            if(getRight(i)<=topindex)
            {
                if(maxHeap[getLeft(i)]>maxHeap[getRight(i)])
                {
                    maxChild=getLeft(i);
                }
                else
                {
                    maxChild=getRight(i);
                }
            }
            else
            {
                maxChild=getLeft(i);
            }

            if(maxHeap[maxChild]>maxHeap[i])
            {
                int t=maxHeap[maxChild];
                maxHeap[maxChild]=maxHeap[i];
                maxHeap[i]=t;
                i=maxChild;
            }
        }
    }

    public static void print()
    {
        System.out.println("the elements are ");
        for(int i=1;i<=topindex;i++)
        {
            System.out.print(maxHeap[i]+ " ");
        }
        System.out.println();
    }

    public static void printLargest()
    {
        System.out.println("the elements are ");
        for(int i=1;i<=topindexmin;i++)
        {
            System.out.print(minHeap[i]+ " ");
        }
        System.out.println();
        System.out.println("the kth largest element is " + minHeap[1]);
        System.out.println();
    }

public static int inputFromUser(String s) throws IOException
{
    System.out.println(s);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.valueOf(br.readLine()).intValue();
    return len;
}

public static void findMinimum() throws IOException
{
    int len=inputFromUser("enter how many minimum numbers required");


     maxHeap = new int[len+1];
     maxHeap[0]=Integer.MIN_VALUE;

     int c=0;


     while(true)
     {
         int p=inputFromUser("enter the number");
         if(c<len)
         {
             insert(c,p);
             topindex++;
             c++;

         }
         else
         {
           if(maxHeap[1]>p)
             {
                 maxHeap[1]=p;
                 sinkDown();
             }

         }
         print();
     }
}

public static void findKthLargestElement() throws IOException
{
    int k=inputFromUser("Enter which largest number user requires");
    minHeap=new int[k+1];
    minHeap[0]=Integer.MAX_VALUE;
    int c=0;
    while(true)
    {
        int p=inputFromUser("Enter the number ");
        if(c<k)
        {
          insertMin(c, p);
          topindexmin++;
          c++;
        }
        else
        {
            if(minHeap[1]<p)
            {
                minHeap[1]=p;
                sinkDownMin();
            }
            System.out.println(minHeap[1]);
        }
        
    }
}



    public static void mergeArray(int a[],int b[],int c[],int x)
    {
        int n=a.length;
        int m=b.length;
        int l=c.length;

        int output[]=new int[n+m+l];
       // int arr[]=new int[x];
        minHeap=new int[x+1];
        minHeap[0]=Integer.MAX_VALUE;
        int i=0,j=0,k=0;
        int counter=x;

        if(i==0)
        {
            insertMin(i, a[i]);
            topindexmin++;
            insertMin(i+1, b[i]);
            topindexmin++;
            insertMin(i+2, c[i]);
            topindexmin++;
        }

//        for( j=1;j<n;j++)
//        {
//           // System.out.println("inside for");
//            arr[0]=a[j];
//            arr[1]=b[j];
//            arr[2]=c[j];
//
//            while(counter>0)
//            {
//               // System.out.println("inside counter");
//            int minVal=minValue(arr,x);
//            if(minVal>minHeap[1])
//            {
//                output[k]=minHeap[1];
//                minHeap[1]=minVal;
//                sinkDownMin();
//                k++;
//            }
//            counter--;
//            }
//            counter=3;
//        }
//
//        //System.out.println("top min index "  + topindexmin);
//        printHeap();
//        while(topindexmin>0 )
//        {
//           // System.out.println("inside while");
//            output[k]=minHeap[1];
//            minHeap[1]=minHeap[topindexmin];
//            topindexmin--;
//           // System.out.println(".....***....");
//            sinkDownMin();
//
//            k++;
//        }
//        int p[]= new int[3];
        while(k< n+m+l)
        {
            System.out.println("min heap  " + minHeap[1]);
        int r=arrayNext(minHeap[1], a, b, c);
            System.out.println("array next " +r);
        output[k]=minHeap[1];
        minHeap[1]=r;
        sinkDownMin();
        k++;
        }
        

        for(i=0;i<(3*n);i++)
        {
            System.out.print(output[i]+ " ");
        }



    }

    public static int arrayNext(int a,int n[],int m[],int l[])
    {
        
             if(a==n[x] && x+1<=n.length-1)
             {
                 return n[++x];
             }

            else if(a==m[y] && y+1<=m.length-1)
            {
                 System.out.println("y :: " + y);
                 return m[++y];
            }
            else if(a==l[z] && z+1<=l.length-1)
            {

                System.out.println("z :: " + z);
                 return l[++z];
            }


         return Integer.MAX_VALUE;
    }

    public static void printHeap()
    {
//        for(int x=1;x<=3;x++)
//        {
//            System.out.print(" x= " + minHeap[x]);
//        }
    }
    public static int minValue(int a[],int m)
    {
//        if(a<b)
//        {
//            if(a<c)
//                return a;
//        }
//        if(b<a)
//        {
//            if(b<c)
//                return b;
//        }
//        return c;



        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<m;i++)
        {
            if(min>a[i])
            {
                min=a[i];
                index=i;
            }
        }
        a[index]=Integer.MAX_VALUE;
        return min;



    }
    public static void main(String[] args) throws IOException {

       // findMinimum();
        findKthLargestElement();
//        int m[]={30,40,50, 60};
//        int n[]={35,45,55};
//        int l[]={10, 60, 70, 100, 120};
//       mergeArray(m, n, l,3);
//         int counter=3;
//         while(counter>0)
//         {
//             int min=minValue(m, 3);
//             System.out.println("min value " + min);
//             counter--;
//         }
     
    }




}



