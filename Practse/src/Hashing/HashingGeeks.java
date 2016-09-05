/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HashingGeeks {
    
    public static void main(String[] args)
    {
//        Map<String,String> hash=new HashMap<String,String>();
//        hash.put("Chennai", "Bengalore");
//        hash.put("Bombay", "Delhi");
//        hash.put("Goa", "Chennai");
//        hash.put("Delhi", "Goa");
//        itinararyTicket(hash);

//        int arr[]={4, 6, 9, 2, 3, 4, 9, 6, 10, 4};
//        printGroup(arr);

        int a[]={1,2,4,6,3,8,7};
        int d[]={10, 5, 2, 4, 1, 5, 6};
        int c[]={0,2,8,6,3,4,10};
        MissingNum(a,8);

//        int k=3;
//        checkDuplicate_K_Distance(d, k);

      //  int sum=10;
       // arraysHaveSum(d,c,sum);
      //  arraySum(c,sum);

    }


    // finding the missing number from n-1 array element
    public static void MissingNum(int a[],int n)
    {
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=1;i<=n;i++)
        {

                h.put(i, 0);

        }

        for(int i=0;i<a.length;i++)
        {
            if(h.get(a[i])!=null)
            {
                h.put(a[i], h.get(a[i])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : h.entrySet())
        {
           // System.out.println(entry.getKey() + " " + entry.getValue());

           if(entry.getValue()==0)
            System.out.println("missing number is " + entry.getKey());
        }



    }

    // display pairs in an array which computes to the given sum
    public static void arraySum(int b[],int s)
    {
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<b.length;i++)
        {
            if(h.get(b[i])!=null)
            {
                h.put(b[i], h.get(b[i])+1);
            }
            else
            {
                h.put(b[i], 1);
            }

            int k=s-b[i];

            if(h.containsKey(k))
            {
                System.out.println(k + " " + b[i] + ", ");
            }


        }
    }


    public static void arraysHaveSum(int a[],int b[],int k)
    {
        int n=a.length;
        int m=b.length;
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        if(n<m)
        {
            for(Integer c : a)
            {
                if(h.get(c)!=null)
                {
                    h.put(c, h.get(c)+1);
                }
                else
                {
                    h.put(c, 1);
                }
            }

            for(int i=0;i<m;i++)
            {
                int d=k-b[i];
                if(h.containsKey(d))
                {
                    System.out.print(d + " " +b[i]);
                }

            }
        }
        else
        {
            for(Integer c : b)
            {
                if(h.get(c)!=null)
                {
                    h.put(c, h.get(c)+1);
                }
                else
                {
                    h.put(c, 1);
                }
            }

             for(int i=0;i<n;i++)
            {
                int d=k-a[i];
                if(h.containsKey(d))
                {
                    System.out.println(d + " " +a[i] + ", ");
                }

            }
        }



    }

    public static void printGroup(int a[])
    {
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(Integer c : a)
        {
            if(h.get(c)!=null)
            {
                h.put(c, h.get(c)+1);
            }
            else
            {
                h.put(c, 1);
            }

        }

        for(Map.Entry<Integer,Integer> entry : h.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for(int i=0;i<a.length;i++)
        {
            if(h.containsKey(a[i]))
            {
                for(int j=1;j<=h.get(a[i]);j++)
                {
                    System.out.print(a[i] + " ");
                }

                    h.put(a[i], -1);
            }
        }
    }


    public static void checkDuplicate_K_Distance(int a[],int k)
    {
        Map<Integer,Integer> h=new HashMap<Integer,Integer>();
        Boolean flag=false;
        for(int i=0;i<a.length;i++)
        {
           if(!h.containsKey(a[i]))
           {
               h.put(a[i], i);
           }
           else
           {
               int d=i-h.get(a[i]);
               if(d<=k)
               {
                   flag=true;
                   continue;
               }
               else
               {
                   flag=false;
               }

           }

        }
        if(flag)
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("No");
        }

    }



    public static void itinararyTicket(Map<String,String> h)
    {
        Map<String,String> reverseHash=new HashMap<String,String>();

        for(Map.Entry<String,String> entry : h.entrySet())
        {
            reverseHash.put(entry.getValue(), entry.getKey());
        }
        
        String start=null;
        for(Map.Entry<String,String> entry: h.entrySet())
        {
            if(!reverseHash.containsKey(entry.getKey()))
            {
                start=entry.getKey();
                break;
            }
        }

        if(start==null)
        {
            System.out.println("Invalid start point");
        }

        String to=h.get(start);
        while(to!=null)
        {
            System.out.println(start+ "-->" +to+ " ,");
            start=to;
            to=h.get(start);
        }
    }

}
