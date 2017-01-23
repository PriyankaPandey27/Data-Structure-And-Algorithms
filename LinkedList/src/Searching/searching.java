/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Searching;

/**
 *
 * @author admin
 */
public class searching {

    public static void main(String[] args)
    {
        int a[]={3,2,1,2,2,3};
        int b[]={8,9,10,4,7,5,11};
        int s[]={1,2,4,6,3,7,5};
       //int p=MissingNumXor(s,8);
        //System.out.println(p);
        //int g[]={1,2,3,4,5,6,7,8,9,10};
//        int y=binarySearchFinal(g, 1);
//        if(y==-1)
//            System.out.println("element is not found");
//        else
//            System.out.println("element is found at index " + y);

//        int p=ternarySearch(g, 0, g.length-1, 7);
//        if(p==-1)
//        {
//            System.out.println("element is not found");
//        }
//        else
//            System.out.println("element is found at index " + p);

       // int c[]={0,5,1,4,11,6,2};
       // int p[]={15,16,19,20,25,1,3,4,5,7,10,14};
        //int d=search(p, 12, 5);
       // int d=SearchOneScan(a, 0, 11, 5);
        //System.out.println("the index is " + d);
        //SumThreeSearch(c, 11);
        //System.out.println("missing number is " + p);
       // MaxRepetition(a);

        int l[]={1,1,1,2,3,3,4,5,5,5,7,7,8,8};
      //  System.out.println(" second smallest element is "+ findPrevSmallestFreq(l, 0, l.length-1, 7,0,l.length-1));
        int m=LastOccurrance(l,0,l.length-1,8);
        System.out.println(m);
      // occurrrence(l, 0, 9, 5);

//        int swap[]={12, 34, 45, 9, 8, 90, 3};
        // SwapEvenOdd(swap);
//        System.out.println();
//        int swp[]={0,1,1,0,1,2,1,2,0,0,0,1};
//        SwapZeroOneTwo(swp);
//        System.out.println();
//
        int n[]={34, 8, 10, 3, 2, 80, 30, 33, 1};
      //  int dff=MaxIndexDiff(n);
      //  System.out.println("maximum difference btween index " + dff);
//        mergeSort(s, 0, s.length-1);
//        for(int i=0;i<s.length;i++)
//        {
//            System.out.println(s[i]);
//        }
//        addTwoArray(b,s,16);

        int r[]={1,1,1,3,3,4,5,5,5,5,6,6,7,8,8,8,8,8,8,9,9,9,11,11,11};
       // System.out.println("array is rotated by " + timesOfRotation(r, 0, r.length-1,0,r.length-1));
      // System.out.println("the array is rotated by " + findAfterRotation(r, 0, r.length-1, 8));
       // System.out.println("next greater element " + findNextLargest(r, 0, r.length-1,9,r.length-1,0));


    }

    public static void mergeSort(int a[],int l,int h)
    {
        if(l<h)
        {
            int m=(l+h)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,h);
            merge(a,l,m,h);
        }
    }

    public static void merge(int a[],int low,int mid,int high)
    {
        int l=low;
        int mid1=mid+1;
        int temp[]=new int[a.length];
        int indx=low;

        while((l<=mid) && (mid1<=high))
        {
            if(a[l]<a[mid1])
            {
                temp[indx]=a[l];
                l++;
            }
            else
            {
                temp[indx]=a[mid1];
                mid1++;
            }
            indx++;
        }

        if(l<=mid)
        {
            for(int i=l;i<=mid;i++)
            {
                temp[indx]=a[i];
                indx++;
            }

        }
        else
        {
            for(int j=mid1;j<=high;j++)
            {
                temp[indx]=a[j];
                indx++;
            }
        }

        for(int i=low;i<=high;i++)
        {
            a[i]=temp[i];
        }

    }

      public static void mergeSortDesc(int a[],int l,int h)
    {
        if(l<h)
        {
            int m=(l+h)/2;
            mergeSortDesc(a,l,m);
            mergeSortDesc(a,m+1,h);
            mergeDesc(a,l,m,h);
        }
    }

    public static void mergeDesc(int a[],int low,int mid,int high)
    {
        int l=low;
        int mid1=mid+1;
        int temp[]=new int[a.length];
        int indx=low;

        while((l<=mid) && (mid1<=high))
        {
            if(a[l]>a[mid1])
            {
                temp[indx]=a[l];
                l++;
            }
            else
            {
                temp[indx]=a[mid1];
                mid1++;
            }
            indx++;
        }

        if(l<=mid)
        {
            for(int i=l;i<=mid;i++)
            {
                temp[indx]=a[i];
                indx++;
            }

        }
        else
        {
            for(int j=mid1;j<=high;j++)
            {
                temp[indx]=a[j];
                indx++;
            }
        }

        for(int i=low;i<=high;i++)
        {
            a[i]=temp[i];
        }

    }


    public static void addTwoArray(int b[],int s[],int k)
    {
        mergeSort(b, 0, b.length-1);
        mergeSort(s, 0, s.length-1);
        int i=0,j=0;
       // System.out.println(k);
        for(int p=0;p<b.length;p++)
        {
            // without using searching
//            if(b[i]+s[j]==k)
//            {
//                System.out.println("pairs are " + b[i]+" ," +s[j]);
//                i++;
//                j++;
//            }
//            else if(b[i]+s[j]<k)
//            {
//                i++;
//            }
//            else
//            {
//                j++;
//            }
            int c=k-b[p];
            int l=search(s, s.length-1, c);
            System.out.println(c);
            System.out.println("with searching " + l);
//            if(search(s, s.length, c)!=-1)
//            {
//                System.out.println("the pair is " + b[p]+ " ," + search(s, s.length, c) );
//            }
        }

    }

    public static void negateDuplicate(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[Math.abs(arr[i])]<0)
            {
                System.out.println("duplicate exist " + arr[i]);
                return;
            }
            else
            {
                arr[arr[i]]= - arr[arr[i]];
            }
        }

        System.out.println("No duplicates in the given array ");
    }

     public static void MaxRepetition(int arr[])
    {
         int n=arr.length;
         int max=0,index=0;
        for(int i=0;i<arr.length;i++)
        {
            arr[arr[i]%n]+=n;
        }

         for(int i=0;i<n;i++)
         {
             System.out.println(arr[i]);
         }

         for(int j=0;j<n;j++)
         {
             if(arr[j]/n>max)
             {
                 max=arr[j]/n;
                 index=j;
             }
         }
         System.out.println("maximum repetition " + index);
         System.out.println("times " + max);


        //System.out.println("No duplicates in the given array ");
    }

    // using xor functionality

     public static int MissingNumXor(int a[],int l)
     {
         System.out.println("Arrays :: "+ a.length);
         int X=0,Y=0;
         int n=a.length;
         for(int i=0;i< n;i++)
         {
             X^=a[i];
            // System.out.println( X);
         }
         for(int j=1;j<=l;j++)
         {
             Y^=j;
         }
           
           //System.out.println(Y);
         return X^Y;
     }

     // SUM OF THREE NUMMBERS EQUALS TO K PRESENT IN THE ARRAY

     public static void SumThreeSearch(int s[],int c)
     {
         int n=s.length;
         mergeSort(s, 0, n-1);
         for(int j=0;j<n;j++)
         {
             System.out.print(s[j]+ " ");
         }
         for(int k=0;k<n;k++)
         {
             for(int i=k+1,j=n-1;i<j; )
             {
                 if(s[i]+s[j]+s[k]==c)
                 {
                     System.out.println("the numbers are " +s[i]+ " " +s[j]+" "+s[k]);
                     break;
                   //return;
                 }
                 else if(s[i]+s[j]+s[k]>c){
                     j=j-1;
                 }
                 else
                 {
                     i=i+1;
                 }
             }
         }
     }


     public static int IncDecSeq(int s[],int f,int l)
     {
        int mid=0;
        f=0;
        l=s.length-1;
        while(f<=l)
        {
            if(f==l)
                return s[f];
            else if(f==l-1)
                return Math.max(s[f],s[l]);
            else
            {
                mid=f+(l-f)/2;
                if(s[mid-1]<s[mid] && s[mid]>s[mid+1])
                {
                    return s[mid];
                }
                else if(s[mid-1]<s[mid] && s[mid]<s[mid+1])
                {
                    f=mid+1;
                }
                else if(s[mid-1]>s[mid] && s[mid]>s[mid+1])
                {
                    l=mid-1;
                }
                else
                    return Integer.MIN_VALUE;
            }
        }
        return -1;
     }


     public static int FindPivot(int a[],int strt,int last)
     {
         if(strt==last)
             return strt;
         else if(strt==last-1)
         {
             if(a[strt]>=a[last])
                 return strt;
             else
                 return last;
         }
         else
         {
             int mid=strt+(last-strt)/2;
             if(a[strt]>=a[mid])
             {
                 return FindPivot(a, strt, mid);
             }
             else
             {
                 return FindPivot(a, mid, last);
             }

         }
     }

     public static int search(int a[],int n,int x)
     {
         int pivot=FindPivot(a, 0, n-1);
         if(a[pivot]==x)
             return pivot;
         if(a[pivot]<x)
         {
             return BinarySearch(a, 0, pivot-1, x);
         }
         else
         {
             return BinarySearch(a, pivot+1, n-1, x);
         }
     }

     public static int BinarySearch(int a[],int l,int h,int x)
     {
         if(h>=l)
         {
             int mid=l+(h-l)/2;
             if(a[mid]==x)
                 return mid;
             if(a[mid]>x)
                 return BinarySearch(a, mid+1, h, x);
             else
                 return BinarySearch(a, l, mid-1, x);
         }
         return -1;
     }

     public static int SearchOneScan(int a[],int left,int right,int x)
     {
         if(left>right)
         {
             return -1;
         }
         int mid=left+(right-left)/2;
         if(x==a[mid])
             return mid;
         else if(a[left]<=a[mid])
         {

             if(x>=a[left] && x<a[mid])
                 return SearchOneScan(a, left,mid-1, x);
             else
                 return SearchOneScan(a, mid+1, right, x);
         }
         else if(a[mid]<=a[right])
         {

             if(x>a[mid] && x<=a[right])
             {
                 return SearchOneScan(a, mid+1, right, x);
             }
             else
             {
                 return SearchOneScan(a, left, mid-1, x);
             }
         }
         return 0;
     }


     /// first occurrence of a number

     public static int FirstOccurrance(int a[],int l,int h,int d)
     {
         if(h>=l)
         {
             int mid=l+(h-l)/2;
             if(mid==l && a[mid]==d || a[mid]==d && a[mid-1]<d)
                 return mid;
             else if(a[mid]>=d)
                 return FirstOccurrance(a,l,mid-1,d);
             else
                 return FirstOccurrance(a,mid+1,h,d);
         }
         return -1;
     }

     /// last occurrence of a number
     public static int LastOccurrance(int a[],int l,int h,int d)
     {
         if(h>=l)
         {
             int mid=l+(h-l)/2;
//             if(mid+1 > h)
//                 return -1;
             if(mid==h && a[mid]==d || a[mid]==d && a[mid+1]>d)
                 return mid;
             else if(a[mid]>d)
                 return LastOccurrance(a,l,mid-1,d);
             else
                 return LastOccurrance(a,mid+1,h,d);
         }



         return -1;
     }

     // calculating the number of occurrence of a particular number

     public static void occurrrence(int a[],int l,int h,int d)
     {
         int frst=0,last=0,fnl=0;
         frst=FirstOccurrance(a, l, h, d);
         last=LastOccurrance(a, l, h, d);

         fnl=last-frst+1;
         System.out.println("number of occurence of " + d + "is " + fnl);
     }

     public static void SwapEvenOdd(int a[])
     {
         int left=0;
         int right=a.length-1;
          while(left<right)
          {
              while(a[left]%2==0 && left<right)
              {
                  left++;
              }
              while(a[right]%2==1 && left<right)
              {
                  right--;
              }

              if(left<right)
              {
                  int temp=a[left];
                  a[left]=a[right];
                  a[right]=temp;
                  left++;
                  right--;
              }
          }
         for(int i=0;i<a.length;i++)
         {
             System.out.print(a[i]+ " ");
         }


     }


     //dutch national flag problem
     public static void SwapZeroOneTwo(int a[])
     {
         int l=0,m=0,h=a.length-1;
         int temp=0;
         while(m<=h)
         {
             switch(a[m])
             {
                 case 0:
                     temp=a[l];
                     a[l]=a[m];
                     a[m]=temp;
                     m++;
                     l++;
                     break;

                 case 1:
                     m++;
                     break;

                 case 2:
                     temp=a[m];
                     a[m]=a[h];
                     a[h]=temp;
                     h--;
                     break;
             }
         }
         for(int i=0;i<a.length;i++)
         {
             System.out.print(a[i] + " ");
         }
     }

     public static int MaxIndexDiff(int a[])
     {
         int n=a.length;
         int i,j,dff=-1;
         int leftMin[]=new int[a.length];
         int rghtMax[]=new int[a.length];

         leftMin[0]=a[0];
         for( i=1;i<n;i++)
             leftMin[i]=Math.min(a[i], leftMin[i-1]);

         rghtMax[n-1]=a[n-1];
         for( j=n-2;j>=0;j--)
             rghtMax[j]=Math.max(a[j], rghtMax[j+1]);

         i=0;j=0;
         while(i<n && j<n)
         {
             if(leftMin[i]<rghtMax[j])
             {
                 dff=Math.max(dff,j-i);
                 j++;
             }
             else
                 i++;
         }
         return dff;


     }


     public static int binarySearchFinal(int a[],int k)
     {
         int low=0;
         int high=a.length-1;
         while(low<=high)
         {
             int mid=low+(high-low)/2;
             if(a[mid]==k)
                 return mid;
             else if (a[mid]<k)
                 low=mid+1;
             else
                 high=mid-1;
         }
         return -1;
     }

     public static int ternarySearch(int g[],int l,int h,int k)
     {
         if(l<=h)
         {
             int mid1=l+(h-l)/3;
             System.out.println("a.length == "+(g.length-1));
             System.out.println("mid1 ;;" + mid1);
             int mid2=mid1+(h-l)/3;
             System.out.println("mid2 ;; " + mid2);

             if(g[mid1]==k)
                 return mid1;
             if(g[mid2]==k)
                 return mid2;
             if(k<g[mid1])
                 return ternarySearch(g, l, mid1-1, k);
             if(k>g[mid2])
             {
                 return ternarySearch(g, mid2+1,h, k);
             }
             

             return ternarySearch(g, mid1+1, mid2-1, k);
         }
         else
         {
             return -1;
         }
     }
     
     
     public static int findNextSmallest(int a[],int l,int h,int d,int strt,int end)
     {
         if(l<=h)
         {
         if(d>a[end])
             return a[end];
         
         if(d<a[strt])
             return -1;
         
         int mid=l+(h-l)/2;
             System.out.println("mid "+ mid);

         if(mid==strt && a[mid]==d)
             return -1;

         if(mid==l && d<a[mid])
             return a[mid-1];

         if(mid==h && d>a[mid])// if the element is nt present in d array nd we have to find its previous element
             return a[mid];
         
         if(a[mid]==d && a[mid-1]!=d)
             return a[mid-1];
         
         
         else if(d<=a[mid])
             return findNextSmallest(a, l, mid-1, d,strt,end);
         else
             return findNextSmallest(a, mid+1, h, d,strt,end);
         }
         
         return -1;
     }

     public static int findNextLargest(int a[],int l,int h,int d,int end,int strt)
     {
         if(l<=h)
         {
             if(d<a[strt])
                 return a[strt];

             if(d>a[end])
                 return -1;

             
             int m=l+(h-l)/2;

             System.out.println("mid " + m);

             if(m==end && d==a[m])// for checking the end case when mid is equal to end(a.length-1)
                 return -1;


             if(a[m]==d && a[m+1]!=d)
                 return a[m+1];

//             if( m==l && d<a[m])//for elements not present and if they are less then middle element
//                 return a[m];
//
//             if(m==h && a[m+1]>d)//for elements not present and if they are more then middle element
//                 return a[m+1];

             if(d<a[m])
                 return findNextLargest(a, l, m-1, d,end,strt);
             else
                 return findNextLargest(a, m+1, h, d,end,strt);
         }

         return -1;
     }


     public static int findAfterRotation(int a[],int l,int h,int d)
     {

         if(a.length==0)
             return -1;
         if(h>=l)
         {
             int m=l+(h-l)/2;
             System.out.println("mid " + m);
             
             if(m==l && a[m]==d)
                 return m;

             if(a[m]==d && a[m]!=a[m-1])
                 return m;
             if(a[l]<=a[m])
             {
                 if(a[l]<=d && d<=a[m])
                     return findAfterRotation(a, l, m-1, d);
                 else
                     return findAfterRotation(a, m+1, h, d);
             }

             else if(a[h]>=a[m])
             {
                 if(a[m]<=d && d<=a[h])
                     return findAfterRotation(a, m+1, h, d);
                 else
                     return findAfterRotation(a, l, m-1, d);
             }
         }

         return -1;
     }


     public static int timesOfRotation(int a[],int l,int h,int strt,int end)
     {
         if(a.length==0)
             return -1;
         if(strt==end)
             return 0;
         if(l<=h)
         {
             int m=l+(h-l)/2;
             System.out.println("mid "+ m);

             if(m==end && a[m]>=a[m-1])
                 return 0;

             if(m==strt)
             {
                 if(a[m]==a[m+1])
                     return m+2;
                 else if(a[m]>a[m+1])
                     return m+1;
             }
                 

             if(a[m]>=a[m-1] && a[m]>a[m+1])
                 return m+1;
             

             
             if(a[l]<=a[m])
                 return timesOfRotation(a, m+1, h,strt,end);

             else if(a[m]<=a[h])
                 return timesOfRotation(a, l, m-1,strt,end);

         }
         return -1;


     }



     public static int findPrevSmallestFreq(int a[],int l,int h,int d,int strt,int end)
     {
         if(l<=h)
         {
         if(d>a[end])
             return end;

         if(d<a[strt])
             return -1;

         int mid=l+(h-l)/2;
             System.out.println("mid "+ mid);

         if(mid==strt && a[mid]==d)
             return -1;

         if(mid==l && d<a[mid])
             return mid-1;

         if(mid==h && d>a[mid])
             return mid;

         if(a[mid]==d && a[mid-1]!=d)
             return mid;


         else if(d<=a[mid])
             return findPrevSmallestFreq(a, l, mid-1, d,strt,end);
         else
             return findPrevSmallestFreq(a, mid+1, h, d,strt,end);
         }

         return -1;
     }









}
