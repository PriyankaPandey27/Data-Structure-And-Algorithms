/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class AddNropes {
    
    public static int minHeap[];
    public static int topindex=0;

    public static void main(String[] args) {

        int rope[]={5,6,7,8};
        printHeap(rope);
        System.out.println("");
        System.out.println("minimum cost of the rope is " + getLengthOfRope(rope));


    }

    public static void createHeap(int a[])
    {
        minHeap=new int[a.length+1];
        minHeap[0]=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
        {
            minHeap[i+1]=a[i];
            topindex++;
        }

        for(int i=(topindex-1)/2;i>=1;i--)
        {
            sinkDown(i);
        }

    }

    public static void printHeap(int a[])
    {
        createHeap(a);
        while(topindex>0)
        {
        int r=minHeap[1];
        minHeap[1]=minHeap[topindex];
        topindex--;
        sinkDown(1);
        System.out.print(r+" ");
        }
    }
    
    public static int getLengthOfRope(int a[])
    {
        int sum=0;
        createHeap(a);
        while(topindex>1)
        {
            int s=0;
            int c=2;
            System.out.println("topindex value start " + topindex);
            while(c>0)
            {
                int r=minHeap[1];
                
                minHeap[1]=minHeap[topindex];
                topindex--;
                sinkDown(1); 
                s+=r;
                c--;
            }
            sum+=s;
            System.out.println("sum "+ sum);
            minHeap[++topindex]=s;
            sinkDown(1);
            System.out.println("topindex value last " + topindex);
        }

        
        return sum;
    }



    public static void sinkDown(int i)
    {
        int p=i;
        int minChild;

        if(getRight(p)<=topindex)
        {
            while((getLeft(p)<=topindex||getRight(p)<=topindex) && (minHeap[getLeft(p)]<minHeap[p] || minHeap[getRight(p)] <minHeap[p] ))
            {
                if(getRight(p)<=topindex)
                {
                    if(minHeap[getLeft(p)]< minHeap[getRight(p)])
                    {
                        minChild=getLeft(p);
                    }
                    else
                        minChild=getRight(p);
                }
                else
                    minChild=getLeft(p);

                if(minHeap[minChild]<minHeap[p])
                {
                    int k=minHeap[minChild];
                    minHeap[minChild]=minHeap[p];
                    minHeap[p]=k;
                    p=minChild;
                }

                if(getRight(p)>topindex && getLeft(p)<=topindex)
                {
                    minChild=getLeft(p);
                    if(minHeap[minChild]<minHeap[p])
                {
                    int k=minHeap[minChild];
                    minHeap[minChild]=minHeap[p];
                    minHeap[p]=k;
                }
                    break;
                }
            }
        }

        else
        {
            minChild=getLeft(p);
            if(minHeap[minChild]<minHeap[p])
                {
                    int k=minHeap[minChild];
                    minHeap[minChild]=minHeap[p];
                    minHeap[p]=k;
                    p=minChild;
                }

        }
    }

    public static int getLeft(int i)
    {
        return 2*i;
    }

    public static int getRight(int i)
    {
        return 2*i+1;
    }





}
