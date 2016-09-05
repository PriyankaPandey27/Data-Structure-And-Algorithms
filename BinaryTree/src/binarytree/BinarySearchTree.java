/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTree;

//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

      public static void main(String args[])
    {
        BinaryTree bt=new BinaryTree();
        Node root = new Node(1);
       // bt.insertBST(root,1);
      //   System.out.println("**"+ root.data);
        bt.insertBST(root,3);
        bt.insertBST(root,6);
        bt.insertBST(root,2);
        bt.insertBST(root,4);
        bt.insertBST(root,7);
        //bt.insertBST(root,8);
        bt.insertBST(root,-4);
        bt.insertBST(root,-2);
        bt.insertBST(root,-5);
        bt.insertBST(root,12);

//         System.out.println("level order representation");
//         bt.ilevelOrder(root);

         //System.out.println("root " + root.data);
        // bt.twoNodedIsDisplay();
//        System.out.println(bt.searchBST(root, 6));
//        bt.searchTwoNodeSum(root, 10);
        // bt.iInorder(root);
//         Node t=bt.findMinimum(root);
//         System.out.println("the minimum element is " + t.data);
//          Node p=bt.findMax(root);
//         System.out.println("the maximum element is " + p.data);

      //   Node l=bt.LCA(root, 4, 12);
//         System.out.println("LCA IS " + l.data);
//         int d=bt.ShortPath(root, 4, 12);
//         System.out.println("shortest distance is " + d);
//
//         boolean s=bt.isBST(root);
//        // boolean s=bt.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//         System.out.println("is the given tree BST " +s);
//
//         int arr[]={1,2,3,4,5,6,7};
//         bt.printOut(arr, "Below is the given array");
//         int lp=arr.length-1;
//         Node r=bt.buildBST(arr, 0,lp);
//         System.out.println("the inorder presentation is given as ");
//         bt.iInorder(r);

//         Node f=bt.KthSmallestInBST(root, 3, 0);
//         System.out.println("the kthe smallest element of tree is " +f.data);
         

         bt.insert(1);
         bt.insert(2);
         bt.insert(3);
         bt.insert(4);
         bt.insert(5);
         bt.insert(6);
         bt.insert(7);
         bt.display("singly linked list");
         System.out.println("after converting singly linked list to BST");
//
         Node pp=bt.sortedLLToBST(bt.getFirstLL());
         bt.iInorder(pp);

       
//         Node d=bt.Delete(root, 3);
//         System.out.println("after deletion");
//         bt.iInorder(d);

//        System.out.println("inorder traversal of bst");
//        System.out.println();
//        bt.rInOrder(root);
        
//        System.out.println();
//        Node p=bt.preorderSuccessor(root, -5);
//        if(p==null)
//        {
//            System.out.println("end of the treee");
//        }
//        else
//        {
//        System.out.println("preorder successor of node " + p.data);
//        }
        
//        Node pre=null;
//        Node suc=null;
////
//         bt.inOrderPreSuc(root,pre,suc,6);

//          int pre[] = new int[]{10, 5, 1, 7, 40, 50};
//        int size = pre.length;
//        Node n = bt.constructBSTFromPreorder(pre, size);
//        bt.rInOrder(n);
//        System.out.println("");
//        int post[] = {1, 7, 5, 50, 40, 10};
//        Node pst=bt.construcctBSTFromPostorder(post, post.length);
//        bt.rInorder(pst);
       

        


       

      }
}

class BinaryTree{

    Node root;
    Node head;

    Queue<Node> twoNodes = new LinkedList<Node>();

        // means inserting at the end
    public void insert(int x)
    {
        if(head==null)
        {
           head=new Node(x);
           head.right=null;
           head.left=null;

        }
        else
        {
            Node temp=head;
            while(temp.right!=null)
            {
                temp=temp.right;
            }
            Node t=new Node(x);
            temp.right=t;
            t.left=temp;
           // temp.next.next=null;

        }
    }


    public boolean searchBST(Node root,int t)
    {
        if(root==null)
            return false;

        if(root.data==t)
            return true;
        if(t>root.data)
        {
            return searchBST(root.right,t);
        }
        else if(t<root.data)
        {
            return searchBST(root.left, t);
        }

        return false;
    }


    public void searchTwoNodeSum(Node root,int k)
    {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        if(root==null)
            return ;
       while(!twoNodes.isEmpty())
       {
           Node t=(Node)twoNodes.remove();
           int l=k-t.data;
           if(searchBST(root, l))
           {
               if(!h.containsValue(t.data))
               {
               System.out.println("the first Node is  " + t.data + " the second Node is " + l);
               h.put(t.data, l);
               }
           }

       }

    }



    public void ilevelOrder(Node root)
    {
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<Node>();

        q.add(root);
        while(!q.isEmpty())
        {
            Node r=(Node)q.remove();
            twoNodes.add(r);
            System.out.print(r.data + " ");
            
                if(r.left!=null)
                    q.add(r.left);
                if(r.right!=null)
                    q.add(r.right);
            
        }

    }

    public void twoNodedIsDisplay()
    {
       while(!twoNodes.isEmpty())
       {
           Node t=twoNodes.remove();
           System.out.print(t.data + " ");
       }
    }
    public void display(String s)
    {
        System.out.println(s);
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + "<-->");
            temp=temp.right;
        }
        System.out.println();
    }

      public void insertBST(Node root,int r)
    {
        if(root==null)
        {
            root=new Node(r);
           // root.left=root.right=null;
            
        }
       // System.out.print(root.data + " ");
        if(r<root.data)
        {
            if(root.left!=null)
            {
                insertBST(root.left,r);
            }
            else
            {
                root.left=new Node(r);
            }
        }
        else// if(r>root.data)
        {
            if(root.right!=null)
            {
                insertBST(root.right,r);
            }
            else
            {
                root.right=new Node(r);
            }
        }
    }

     public void rInOrder(Node r){

         if(r==null) return;

         rInOrder(r.left);
         System.out.print(r.data+ " ");
         rInOrder(r.right);
     }


   public void iInorder(Node root)
    {
        Stack s=new Stack();
        while(true)
        {
            while(root!=null)
            {
                s.push(root);
                root=root.left;
            }

            if(s.isEmpty())
            {
                break;
            }
            else
            {
                root=(Node)s.pop();
//                if(root.data>max)
//                    max=root.data;
                System.out.print(root.data + " ");
               // System.out.println("the max element" + max);
                root=root.right;
            }
        }

    }

    public void rPreorder(Node root)
    {
        if(root!=null)
        {
            System.out.print(root.data + " ");
            rPreorder(root.left);
            rPreorder(root.right);
        }
        else
        {
            return;
        }
    }

        public void rInorder(Node root)
    {
        if(root!=null)
        {

            rPreorder(root.left);
             System.out.print(root.data + " ");
            rPreorder(root.right);
        }
        else
        {
            return;
        }
    }


   public Node findMinimum(Node root)
   {

       //recursive
//       if(root==null)
//       {
//           return null;
//       }
//       else
//       {
//           if(root.left==null)
//           {
//              return root;
//           }
//           else
//              return findMinimum(root.left);
//       }

       //iterative representation

       if(root==null)
           return null;
       while(root.left!=null)
       {
           root=root.left;
       }
       return root;
   }

   public Node findMax(Node root)
   {
       //recursive representation
//       if(root==null)
//           return null;
//       else
//       {
//           if(root.right==null)
//           {
//               return root;
//           }
//           else
//           {
//               return findMax(root.right);
//           }
//       }

       // iterative representation

       if(root==null)
           return null;

       while(root.right!=null)
       {
           root=root.right;
       }
       return root;
   }


   public Node Delete(Node root,int data)
   {
       Node temp=null;
       if(root==null)
           return null;
       else if(data<root.data)
           root.left=Delete(root.left,data);
       else if(data>root.data)
           root.right=Delete(root.right,data);
       else
       {
           if(root.left!=null && root.right!=null)
           {
               temp=findMinimum(root.right);
               root.data=temp.data;
               root.right=Delete(root.right,root.data);
           }
           else if (root.left!=null || root.right!=null)
           {
               temp=root;
               if(root.left==null)
                   root=root.right;
               if(root.right==null)
                   root=root.left;
               if(root.left==null && root.right==null)
               temp=null;
           }
           else
           {
              Node tmp=root;
               tmp=null;
           }
       }
       return root;
   }


   public Node LCA(Node root,int n1,int n2)
   {
       if(root==null)
           return null;
       else if(n1>root.data && n2>root.data)
           return LCA(root.right,n1,n2);
       else if(n1<root.data && n2<root.data)
           return LCA(root.left,n1,n2);
       else
           return root;
   }

   public int ShortPath(Node root,int n1,int n2)
{
              int d=0;
   Node temp=null;
       if (root==null)
           return -1;
       else if(n1>root.data && n2>root.data)
          root= LCA(root.right,n1,n2);
       else if(n1<root.data && n2<root.data)
           root= LCA(root.left,n1,n2);
    System.out.println(root.data);
   temp=root;
    while(temp!=null)
    {
      if(temp==null)
          return -1;
      else if(temp.data==n1)
          break;
      else if(temp.data>n1)
          temp=temp.left;
      else
          temp=temp.right;
      d++;
    }
   temp=root;
   while(temp!=null)
   {
       if(temp==null)
          return -1;
      else if(temp.data==n2)
          break;
      else if(temp.data<n2)
          temp=temp.right;
      else
          temp=temp.left;
      d++;
   }
   return d;


}

// basic solution where time complexity o(n^2)
//   public boolean isBST(Node root)
//   {
//       if(root==null)
//           return true;
//       if(root.left!=null && findMax(root.left).data>root.data)
//           return false;
//       if(root.right!=null && findMinimum(root.right).data<root.data)
//           return false;
//       if(!isBST(root.left) || !isBST(root.right))
//           return false;
//
//       return true;
//   }

   // time complexity o(n)
//   public boolean isBST(Node root,int min,int max)
//   {
//       if(root==null)
//           return true;
//       return (root.data>min && root.data<max && isBST(root.left,min,root.data) && isBST(root.right,root.data,max) );
//   }
   
   private int prev=Integer.MIN_VALUE;

   public boolean isBST(Node root)
   {
       if(root==null)
           return true;
       if(!isBST(root.left))
           return false;
       if(root.data<prev)
           return false;
       prev=root.data;
       return isBST(root.right);

   }


   // Converting sorted array into balanced BST

   public Node buildBST(int arr[],int strt,int end)
   {
       if(strt>end)
           return null;

     //  Node newNode=new Node();

       if(strt==end)
       {
           Node newNode=new Node(arr[strt]);
           newNode.setLeft(null);
           newNode.setRight(null);
           return newNode;
       }
       else
       {
           int mid=(strt+end)/2;
           Node newNode=new Node(arr[mid]);
           newNode.setLeft(buildBST(arr,strt,mid-1));
           newNode.setRight(buildBST(arr,mid+1,end));
           return newNode;
       }

       
   }

   public void printOut(int arr[],String s)
   {
       System.out.println(s);
       for(int i=0;i<arr.length;i++)
       {
           System.out.print(arr[i] + " ");
       }
       System.out.println();
   }

   public Node sortedLLToBST(Node head)
   {
       int count=countNode(head);

       return sortedLLToBSTRecur(head,count);
   }

   public Node sortedLLToBSTRecur(Node head,int n)
   {
       if( n<=0)
           return null;

      // int mid=strt+(end-strt)/2;
      System.out.println("len " +n/2);
       
       Node headleft=sortedLLToBSTRecur(head,n/2);
       if(headleft!=null)
       System.out.println("left " + headleft.data);
       System.out.println("head " +head.data);
       Node root1=new Node(head.data);
       root1.setLeft(headleft);
       if(head.right!=null)
       {
           head.data=head.right.data;
           head.right=head.right.right;
       }
      // head=head.right;
       
       root1.setRight(sortedLLToBSTRecur(head,n-n/2-1));
       return root1;
   }

    public int countNode(Node head)
     {
         int c=0;
         Node temp=head;
         while(temp!=null)
         {
             c++;
             temp=temp.right;
             
         }
         return c;
     }

    public Node getFirstLL()
    {
        return head;
    }

    public Node KthSmallestInBST(Node root,int k,int c)
    {
        if(root==null)
            return null;
        Node left=KthSmallestInBST(root.left,k,c);
        
        if(left==null)
            return left;


    System.out.println("left data " +left.data);
        if(++c==k)
            return root;
        return KthSmallestInBST(root.right,k,c);
    }


    //preorder successor

    public Node preorderSuccessor(Node root,int x)
    {
        if(root==null)
            return null;
        Node temp=root;
        Node parent=null;
        while(temp!=null && temp.data!=x)
        {
            if(x < temp.data)
            {
                if(temp.right!=null)
                {
                    parent=temp;
                }
                temp=temp.left;
            }
            else
                temp=temp.right;
        }

        if(temp==null)
            return null;
        if(temp.left!=null)
            return temp.left;
        if(temp.right!=null)
            return temp.right;
        if(parent!=null)
            return parent.right;
        else
            return null;
    }

    // preorder predecessor and successor of bst

    public void inOrderPreSuc(Node root,Node pre,Node suc,int x)
    {
        if(root==null)
            return ;

        if(root.data==x)
        {
            if(root.left!=null)
            {
                Node tmp=root.left;
                while(tmp.right!=null)
                {
                    tmp=tmp.right;
                }
                pre=tmp;
                System.out.println("predecessor is " + pre.data);
                  
            }
            else
            {
                if(pre==null)
                {
               System.out.println("no predecessor");
                }
                else
                {
                    System.out.println("predecessor is " + pre.data);
                }
            }

            if(root.right!=null)
            {
                Node temp=root.right;
                while(temp.left!=null)
                {
                    temp=temp.left;
                }
                suc=temp;
                    System.out.println("successor is " + suc.data);
                   
            }
            else
            {
               if(suc==null)
               {
                   System.out.println("no successor");
               }

               else
               {
                   System.out.println("successor is " +suc.data);
               }


            }
           // return;
        }

        if(x<root.data)
        {
            suc=root;
            inOrderPreSuc(root.left,pre,suc,x);
        }
        else
        {
            pre=root;
            inOrderPreSuc(root.right,pre,suc,x);
        }
    }

    public Node constructBSTFromPreorder(int a[],int size)
    {
        return constructBSTFromPreorderUtil(a,0,a.length-1);
    }

    public Node constructBSTFromPreorderUtil(int a[],int strt,int end)
    {

        if(strt>end)
            return null;

        Node node=new Node(a[strt]);
        int div=getDiv(a,strt+1,end,node.data);

        node.left=constructBSTFromPreorderUtil(a,strt+1, div-1);
        node.right=constructBSTFromPreorderUtil(a, div, end);
        return node;
    }
    
    public int getDiv(int a[],int strt,int end,int d)
    {

        int i;
        for( i=strt;i<=end;i++)
        {
            if(d<a[i])
                break;;
        }
        return i;
    }

    public Node construcctBSTFromPostorder(int a[],int size)
    {
        
        return constructBinaryTreeFromPostOrder(a,0,a.length-1);

    }

    public  Node constructBinaryTreeFromPostOrder(int[] post, int start, int end)
    {

        if(end < 0)

        return null;

        Node node = new Node(post[end]);

        int cut_off = getCutOff(post, start, end);

        if(cut_off == -1)

        return null;

        node.left = constructBinaryTreeFromPostOrder(post, start, cut_off - 1);

        node.right = constructBinaryTreeFromPostOrder(post, cut_off, end -1);

        return node;

    }

   public int getCutOff(int[] post, int start, int end)
   {

        if(start == end)

        return start;

        for(int i = start; i < end; i++)
        {

        if(post[i] > post[end])

        return i;

         }

       return -1;

}





    

}

class Node{
    int data;
    char p;
    //Node next;
    Node right;
    Node left;
    public Node(int x)
    {
        this.data=x;
    }
//    public Node(int x,Node next)
//    {
//        this.data=x;
//        this.next=next;
//    }


    public void setData(int x)
    {
        this.data=x;
    }

    public void setLeft(Node newNode)
    {
        this.left=newNode;
    }

     public void setRight(Node newNode)
    {
        this.right=newNode;
    }
//    public Node(char x)
//    {
//        this.p=x;
//    }

}

class Index{

    int index=0;
}
