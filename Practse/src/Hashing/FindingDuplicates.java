

package Hashing;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class FindingDuplicates {

    public static void main(String[] args) {

//        int input[]={3, 34, 4, 12, 5, 2};
//
        int s[]={2,5,5,8,10,8,8,5,6,6};
        //int p[]=new int[s.length];
        //sortingByMaxFrequency(s,p);
        //{2,5,6,8,10,2,2,7,9,8};
        int p[]={2,5,5,8,10,5,6};
       // int l[]={1,1,5,5,3,4,9};
//
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        hash.put(1, 9);
        hash.put(2, 6);
        hash.put(3, 5);
        hash.put(7, 4);
        hash.put(5, 3);
        hash.put(8, 4);

    checkPairs( hash);
 // sameSets(s, p);
//    //sameSetsFrequency(s, p);
//       //uniqueCharacter("Priyanka");
     //  lastRepeatedDuplicate("Neliilleppe");
     //  System.out.println("Input elements:");

       // printArray(input);

    //   duplicates(input);
    //   maxFrequency(input);

       // first repeating element
    //   firstRepetetedElement(input);

    //  sumNearToZero(input);

     //  firstOccuranceOfElement(input,0,input.length-1,-80);
      // lastOccuranceOfElement(input,0,input.length-1,85);

      // subSetSum(input,9);
    }

    /* finding duplicated using O(N) complexity and O(1) space complexity
    / three limitations of this method
    * (1) applicable for write array only
    * (2) all values lies 0 to n-1
    * (3) all elements should be positive
    */

    public static void subSetSum(int a[],int s)
    {
        // first sort the elements
        quickSort(a,0,a.length-1);

        // Now check from starting and ending
        int lo=0,hi=a.length-1;

        System.out.println("Sum = "+s);
        while(lo<hi)
        {
            int v=a[lo]+a[hi];

            if(v==s)
            {
                System.out.println("Set = "+a[lo]+" , "+a[hi]);
                lo++;
                //if(a[lo+1]+a[hi])
            }

            else if(v<s) lo++;

            else hi--;
        }
    }

    public static void duplicates(int input[])
    {

        if(input.length==0)
            return ;

        int i;
        System.out.println("\nDuplicate elements:");
       for(i=0;i<input.length;i++)
       {
         //  v=input[Math.abs(input[i])];

          if(Math.abs(input[i])<input.length)
          {
           if(input[Math.abs(input[i])]<0)
           {
               System.out.println(Math.abs(input[i]));
               input[Math.abs(input[i])]=input.length;
           }
           else if(input[Math.abs(input[i])]==0)
               input[Math.abs(input[i])]=2*input.length;

           else if(input[Math.abs(input[i])]==input.length)
               continue;

           else
           input[Math.abs(input[i])]=-input[Math.abs(input[i])];
          }

          else if(input[Math.abs(input[i])]==2*input.length)
          {
              System.out.print(Math.abs(input[i]));
              input[Math.abs(input[i])]=input.length;
          }
          else
              continue;
       }

    }


    // Time Complexity O(logn) Space Complexity O(1)
    public static void firstOccuranceOfElement(int a[],int lo,int hi,int data)
    {
        while(lo<=hi)
        {
          int mid=lo+(hi-lo)/2;

          if((mid==hi && a[mid]==data) || (a[mid]==data && a[mid-1]<data))
          {
              System.out.println("\nFirst Occurance = "+mid);
              break;
          }
          else if(a[mid]<=data)
          {
              lo=mid+1;
          }
          else
          {
              hi=mid-1;
          }

        }


    }


      // Time Complexity O(logn) Space Complexity O(1)
    public static void lastOccuranceOfElement(int a[],int lo,int hi,int data)
    {
        while(lo<=hi)
        {
           //  System.out.println("Low = "+lo);
             //  System.out.println("High = "+hi);
          int mid=lo+(hi-lo)/2;

          if((a[mid]==data && a[mid+1]>data)||( mid==hi && a[mid]==data))
          {
              System.out.println("\n Last Occurance = "+mid);
              break;
          }
          else if(a[mid]<data)
          {
              lo=mid+1;
          }
          else
          {
              hi=mid-1;
          }

        }


    }


    public static void maxFrequency(int input[])
    {
        if(input.length==0)
            return;
        int i,max=0,maxindex=-1;
        int l=input.length;
        for(i=0;i<input.length;i++)
        {
            input[input[i]%l] +=l;
        }

        for(i=0;i<l;i++)
        {
            int v=(int) input[i]/l;
            if(v>max)
            {
                max=v;
                maxindex=i;
            }
        }

        System.out.println("\nMaximum frequency of element="+maxindex);
    }



    /*Method 1: Use BST and before inserting any node check whether it is <,>, or = root node
     *          The first element which become = root is first repeated element
     *          O(nlogn) and O(n)
     * Method 2: Use hashTable
     *          O(n) and O(n)
    */
    // Using Method 2

    public static void findingFrequency(String s){

        char[] t = s.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
              // a , 2    --> a , 3
        for(char c : t){
            if(hashMap.get(c)!=null){ // element is present
                hashMap.put(c, hashMap.get(c)+1);
            }
            else   // character found for first time
                 hashMap.put(c, 1);

        }

        System.out.println("Printing frequncy ...... ");
        System.out.println("Key    Value ");


      for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
           System.out.println(entry.getKey() + "  "+ entry.getValue());
   }

    }


    public static void sortingByMaxFrequency(int s[],int p[]){

        int j=0;
        int k=0;
        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
              // a , 2    --> a , 3
        for(int c : s){
            if(hashMap.get(c)!=null){ // element is present
                hashMap.put(c, hashMap.get(c)+1);
            }
            else   // character found for first time
                 hashMap.put(c, 1);



        }

//        System.out.println("Printing frequncy ...... ");
//        System.out.println("Key    Value ");

    while(!hashMap.isEmpty())
    {
        int max=Integer.MIN_VALUE;
      for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
          if(entry.getValue()>max)
          {
              max=entry.getValue();
              k=entry.getKey();

          }
          
         // System.out.println(entry.getKey() + "  "+ entry.getValue());
   }
      //System.out.println("max key " + k + " max value " +max);
      while(max>0 && j<s.length)
      {
          //System.out.println("max valus " + max + "j ::: " + j);
          max--;
          p[j]=k;
          j++;
      }
      hashMap.remove(k);
    }
        for(int l=0;l<s.length;l++)
        {
            System.out.print(p[l]+ " ");
        }

    }





    // check whether two arrays have same sets of number with frequency insignificant
    public static void sameSets(int s[],int p[])
    {
        Map<Integer,Integer> h1=new HashMap<Integer,Integer>();
      //  Map<Integer,Integer> h2=new HashMap<Integer,Integer>();
        for(Integer c : s)
        {
            if(h1.get(c)!=null)
            {
                h1.put(c, h1.get(c)+1);
            }
            else
            {
                h1.put(c, 1);
            }
        }

//        for(Integer c : p)
//        {
//            if(h2.get(c)!=null)
//            {
//                h2.put(c, h2.get(c)+1);
//            }
//            else
//            {
//                h2.put(c, 1);
//            }
//        }

        for(Integer i : p)
        {
            if(h1.get(i)!=null)
            {
                h1.put(i, h1.get(i)-1);
            }
            else
            {
                System.out.println("both arrays doesnt have same set");
                return;
            }
        }
//
//        System.out.println("Printing frequncy for first array...... ");
//        System.out.println("Key    Value ");
        int flag=0;
        for(Map.Entry<Integer,Integer> entry : h1.entrySet())
        {
            System.out.println(entry.getKey()+ " " + entry.getValue());

            if(entry.getValue()==0)
            {
                flag=1;
            }
            else
            {
                flag=0;
            break;
            }
        }

        if(flag==1)
            System.out.println("arrays have same set");
        else
            System.out.println("arrays doesnt have same set");

//        System.out.println("Printing frequncy for second array...... ");
//        System.out.println("Key    Value ");
//
//        for(Map.Entry<Integer,Integer> entry : h2.entrySet())
//        {
//            System.out.println(entry.getKey()+ " " + entry.getValue());
//        }

      //  Map.Entry<Integer,Integer> entry1 = (Entry<Integer, Integer>) h2.entrySet();

        
      //  System.out.println("values in h1===" +h1.entrySet());
//        Set<Integer> s1 =h1.keySet();
//        Set<Integer> s2=h2.keySet();
//     //   System.out.println("s1=====" + s1 + "s2====" + s2);
//        Set<Integer> inS1notS2=new HashSet<Integer>(s1);
//        inS1notS2.removeAll(s2);
//        Set<Integer> inS2notS1=new HashSet<Integer>(s2);
//        inS2notS1.removeAll(s1);
//
//        if(inS1notS2.size()>0 || inS2notS1.size()>0)
//        {
//            System.out.println("both the arrays do not have the same sets");
//        }
//        else
//        {
//            System.out.println("both the given arrays have the same sets ");
//        }



    }





     public static void uniqueCharacter(String s){

        char[] t = s.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
              // a , 2    --> a , 3
        for(char c : t){
            if(hashMap.get(c)!=null){ // element is present
                hashMap.put(c, hashMap.get(c)+1);

            }
            else   // character found for first time
                 hashMap.put(c, 1);


        }

        System.out.println("unique character in the given string ");
       // System.out.println("Key    Value ");


      for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
          if( entry.getValue()==1)
          {
           System.out.println(entry.getKey() + "  "+ entry.getValue());
          }
   }

    }

     // check whether the two arrays have same frequency
      public static void sameSetsFrequency(int s[],int p[])
     {
         Map<Integer,Integer> h1=new HashMap<Integer,Integer>();
         Map<Integer,Integer> h2=new HashMap<Integer,Integer>();
         for(Integer c : s)
         {

             if(h1.get(c)!=null)
             {
                 h1.put(c, h1.get(c)+1);
             }
             else
             {
                 h1.put(c, 1);
             }
         }

         for(Integer c : p)
         {
             if(h2.get(c)!=null)
             {
                 h2.put(c,h2.get(c)+1);
             }
             else
             {
                 h2.put(c, 1);
             }
         }

         if(h1.size()!=h2.size())
         {
             System.out.println(" two maps are not equal");
             return;
         }
            boolean flag =false;
       for(Integer i : h1.keySet()){
           if(h2.containsKey(i)){
               if(h2.get(i) ==null || h1.get(i)!= h2.get(i) ){
                  flag =true;
                   System.out.println("two maps are not equal");
                   break;
               }
           }
       }

       if(!flag)
             System.out.println("Two maps are equal");
     }



      public static void maxElementIn_m_Sets(int s[],int p[],int l[])
      {
          Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
          for(int i=0;i<s.length;i++)
          {
             hashMap.put(s[i], hashMap.get(s[i]+1));

          }

          for(int j=0;j<p.length;j++)
          {

          }
      }



      public static void firstRepeatedDuplicate(String s){

        char[] t = s.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
              // a , 2    --> a , 3
        for(char c : t){
            if(hashMap.get(c)!=null){ // element is present
                hashMap.put(c, hashMap.get(c)+1);
                System.out.println(c);
                break;
            }
            else   // character found for first time
                 hashMap.put(c, 1);

        }

       // System.out.println("first repeated character in the given string ");
       // System.out.println("Key    Value ");


      

    }


      public static void checkPairs(Map<Integer,Integer> h)
      {
         if(h==null || h.size()==0)
         {
             System.out.println("hash map is empty");
         }

         if(h.size()==1)
         {
             System.out.println(" hash map has only one element");
         }

         for(Map.Entry<Integer,Integer> entry : h.entrySet())
         {
             int key=entry.getKey();
             int value=entry.getValue();
             if(h.containsValue(key) && h.containsKey(value))
             {
                 System.out.println( key + " " +value);
                 h.put(key,Integer.MAX_VALUE);
             }
         }
      }
      
      

      public static void lastRepeatedDuplicate(String s){

        char[] t = s.toCharArray();
        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
              // a , 2    --> a , 3
        for(int j=t.length-1;j>=0;j--){
            if(hashMap.get(t[j])!=null){ // element is present
                hashMap.put(t[j], hashMap.get(t[j])+1);
                System.out.println(t[j]);
                break;
            }
            else   // character found for first time
                 hashMap.put(t[j], 1);

        }

       // System.out.println("first repeated character in the given string ");
       // System.out.println("Key    Value ");


      

    }






    public static void firstRepetetedElement(int input[])
    {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

        int i=0;
        while(i<input.length)
        {
               Integer freq=hm.get(input[i]);
                if(freq==null)
                    freq=1;
                else
                     freq++;

                hm.put(input[i], freq);

               i++;
        }

        for(i=0;i<input.length;i++)
        {
            Integer f=hm.get(input[i]);

            if(f>1)
            {
                System.out.println("First repeating element="+input[i]);
                break;
            }
        }
    }


    public static void sumNearToZero(int input[])
    {
        // in-place sorting algo: quick Sort
        quickSort(input,0,input.length-1);

   // System.out.println("Array after sorting");
    //  printArray(input);

        int lo=0,hi=input.length-1;

        int sum=input[0]+input[input.length-1];

        int loIndex=0,hiIndex=input.length-1;

        while(lo<hi)
        {
            if(sum>Math.abs(input[lo]+input[hi]))
            {
                sum=Math.abs(input[lo]+input[hi]);
                loIndex=lo;
                hiIndex=hi;
            }

            if(input[lo]+input[hi]>0)
            {
                hi--;
            }
            else
                lo++;
        }

        System.out.println("Two elements whose sum is nearest to Zero= "+input[loIndex]+" , "+input[hiIndex]);
    }


public static void quickSort(int A[], int l, int h)
{
    if (l < h)
    {
        int p = partition(A, l, h);
        quickSort(A, l, p - 1);
        quickSort(A, p + 1, h);
    }


}


// in-place partition algo
public static int partition (int arr[], int l, int h)
{
    int pivot = arr[h];
    int i = (l - 1);

    for (int j = l; j <= h- 1; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
           int a=arr[i];
           arr[i]=arr[j];
           arr[j]=a;
            //swap (arr[i], arr[j]);
        }
    }
    //swap (arr[i + 1],arr[h]);
    int t=arr[i+1];
    arr[i+1]=arr[h];
    arr[h]=t;
    return (i + 1);
}

public static void printArray(int input[])
{
    int i;
    System.out.println();

    for(i=0;i<input.length;i++)
    {
        System.out.print(input[i]+"  ");
    }
}

}







