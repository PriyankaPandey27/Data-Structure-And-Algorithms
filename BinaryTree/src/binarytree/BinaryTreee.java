/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//import java.util.ArrayList;

public class BinaryTreee {

    public static void main(String args[])
    {
        binaryTree bt=new binaryTree();
       // binaryTree st=new binaryTree();
        bt.run();
        //st.run();
    }

}


 class binaryTree{
    Node root;
    Node root1;
    int max=Integer.MIN_VALUE;
    int maxs=0;
    int maxVal=-1;
    int d=0;
    static int preIndex=0;

    public static int finalDiff=Integer.MIN_VALUE;


    public void insertBST(Node root,int r)
    {
        if(root==null)
        {
            root=new Node(r);
            root.left=root.right=null;
        }
        System.out.print(root.data + " ");
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
        else if(r>root.data)
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




    public void insert(Node p,int d){

        Queue<Node> queue=new LinkedList<Node>();
        if(p==null)
        {
            root=new Node(d);
            root.left=root.right=null;
            return;
        }
        else
        {
            queue.add(root);
            while(!queue.isEmpty())
            {
                Node t=queue.remove();
                if(t.left==null)
                {
                    t.left=new Node(d);
                    queue.clear();
                    return;
                }
                else
                {
                    queue.add(t.left);
                }

                if(t.right==null)
                {
                    t.right=new Node(d);
                    queue.clear();
                    return;
                }
                else
                {
                    queue.add(t.right);
                }
            }
        }
    }


    public void rInsert(Node p,int data)
    {
        if(p==null)
        {
            root=new Node(data);
        }
        else
        {
            insertHelper(root,data);
        }
    }

    public void insertHelper(Node root,int d)
    { if(root==null)
      {
          return;
      }
      else
      {
        if(root.data>=d)
        {
            if(root.left==null)
            {
            root.left=new Node(d);
            }
            else
            {
                 insertHelper(root.right,d);
            }
        }
        else
        {
           if(root.right==null)
           {
               root.right=new Node(d);
           }
           else
           {
               insertHelper(root.right,d);
           }
        }
      }

    }

    public void rInorder(Node root)
    {
        if(root!=null)
        {
            rInorder(root.left);
            System.out.print(root.data + " ");
            //System.out.println("max value is" + max);
            if(max<root.data)
                max=root.data;
            rInorder(root.right);
        }
        else
            return;
    }

    //Inorder presentation of a binary tree
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
              //  if(root.data>max)
                //    max=root.data;
                System.out.print(root.data + " ");
                root=root.right;
            }
        }

              //  System.out.println("the max element" + max);

    }

    //preorder presentation of a binary tree

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

    public void iPreorder(Node root)
    {
        Stack s=new Stack();
        do
        {
            while(root!=null)
            {
                System.out.print(root.data + " ");
                s.push(root.right);
                root=root.left;
            }

            if(s.empty())
            {
                break;
            }
            else
            {
                root=(Node)s.pop();
            }
        }while(!s.isEmpty());
    }

    // postorder presentation of a binary tree

    public void rPostorder(Node root)
    {
        if(root!=null)
        {
            rPostorder(root.left);
            rPostorder(root.right);
            System.out.print(root.data + " ");
        }
        else
        {
            return;
        }
    }

    public void IpostOrder1stack(Node rt)
{

  if(rt==null)
      return;

  Stack s1=new Stack();

 // s1.push(rt);

do
{
    while(rt!=null)
    {
        if(rt.right!=null)
            s1.push(rt.right);

        s1.push(rt);

        rt=rt.left;
    }


    rt=(Node) s1.pop();

    Node top=null;

    if(!s1.isEmpty())
        top=(Node) s1.peek();


    if(rt.right!=null && rt.right==top)
    {
        Node t1=(Node) s1.pop();
        s1.push(rt);
        rt=rt.right;
    }
    else
    {
        System.out.print(rt.data+"  ");
        rt=null;
    }

}while(!s1.isEmpty());


}

    public void levelOrderQueue(Node root)
    {
        if(root==null)
            return;

        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node t=q.remove();
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);

            System.out.print(t.data + " ");
        }
    }
    // level order presentation of a binary tree
    public void iLevelOrder(Node root)
    {
        Stack s1=new Stack();
        Stack s2=new Stack();
        if(root==null)
        {
            return;
        }
        else
        {
            s1.push(root);
        }
        while(!s1.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node temp=(Node)s1.pop();
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
                System.out.print(temp.data + " ");
            }

            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
        }



    }

    public void printMax()
    {
        System.out.println("the maximum element is" + max);
    }

    public int maxInBinaryTree(Node root)
    {
        if(root!=null)
        {
            int leftMax=maxInBinaryTree(root.left);
            int rightMax=maxInBinaryTree(root.right);
            System.out.println("left element " + leftMax);
            System.out.println("right element  " + rightMax);
            if(leftMax>rightMax)
            {
                maxVal=leftMax;
            }
            else
            {
                maxVal=rightMax;
            }

            if(maxVal>root.data)
            {
                return maxVal;
            }
            else
            {
                maxVal=root.data;
                return maxVal;
            }
        }
        else
            return -4;
    }



       public int iFindMaxElement(Node root)
       {
           Queue<Node> q=new LinkedList<Node>();
           if(root!=null)
           {
               q.add(root);

               while(!q.isEmpty())
               {
                   Node tmp=q.remove();
                   if(tmp.data>maxVal){
                       maxVal=tmp.data;
                   }

                   if(tmp!=null)
                   {
                       if(tmp.left!=null)
                           q.add(tmp.left);
                       if(tmp.right!=null)
                           q.add(tmp.right);
                   }
               }
               return maxVal;

           }
           else
               return -4;
       }

       public boolean searchElementBT(Node root,int x)
       {
           if(root==null)
           {
               return false;
           }
           else if(root.data==x)
           {
               return true;
           }
           else
           {
           return searchElementBT(root.left,x)|| searchElementBT(root.right,x);
           }
       }

       public boolean isearchElementBT(Node root,int x)
       {
           Queue<Node> q=new LinkedList<Node>();
           if(root==null)
           {
               return false;
           }
           else
           {
               q.add(root);
               while(!q.isEmpty())
               {
                   Node tmp=(Node)q.remove();
                   if(tmp.data==x)
                   {
                       return true;
                   }

                   if(tmp!=null)
                   {
                       if(tmp.left!=null)
                       {
                           q.add(tmp.left);
                       }
                       if(tmp.right!=null)
                       {
                           q.add(tmp.right);
                       }
                   }
               }
               return false;
           }
       }
       
       
       public void deleteElement(Node root,int x)
       {
           Queue<Node> q=new LinkedList<Node>();
           boolean flag=false;
           Node curr=null;
           Node parent=null;
           boolean flag1=false;
           Node left=null;
           Node right=null;
           if(root==null)
           {
               return ;
           }
           else
           {
               Node tmp=null;
                q.add(root);

               while(!q.isEmpty())
               {
                   tmp=q.remove();
                   if(tmp.data==x)
                   {
                       left=tmp.left;
                       right=tmp.right;
                   }

                   if(tmp!=null)
                   {
                       if(tmp.left!=null)
                       {
                               
                           q.add(tmp.left);
                           if(tmp.left.data==x )
                          {
                           parent=tmp;
                           flag=true;
                          }

                       }
                       if(tmp.right!=null)
                       { 
                           q.add(tmp.right);
                            if(tmp.right.data==x)
                          {
                           parent=tmp;
                           flag1=true;

                          }
                       }
                       
                      
                   }
                  
               }
                curr=tmp;
                System.out.println("last element" + tmp.data);
               if(flag==true)
               {
                   parent.left=curr;
                   curr.left=left;
                   curr.right=right;
                   tmp=null;
               }

                if(flag1==true)
                {
                   parent.left=curr;
                   curr.left=left;
                   curr.right=right;
                   tmp=null;
                }
           }
           
       }

       public void reverseBinaryTree(Node root)
       {
           Queue<Node> q=new LinkedList<Node>();
           Stack s=new Stack();
           if(root==null)
           {
               return ;
           }
           else
           {
               q.add(root);
               while(!q.isEmpty())
               {
                   Node tmp=q.remove();
                   if(tmp.left!=null)
                   {
                       q.add(tmp.left);
                   }
                   if(tmp.right!=null)
                   {
                       q.add(tmp.right);
                   }
                   s.push(tmp);
               }

               while(!s.isEmpty())
               {
                   Node t= (Node)s.pop();
                   System.out.print( t.data + " " );
               }
           }
       }

    public int sizeBinaryTree(Node root)
    {
        int count=0;
         Queue<Node> q=new LinkedList<Node>();
         if(root==null)
             return 0;
         else
         {
             q.add(root);
             while(!q.isEmpty())
             {
                 Node t=q.remove();
                 count++;

                 if(t.left!=null)
                 {
                     q.add(t.left);
                 }
                 if(t.right!=null)
                 {
                     q.add(t.right);
                 }
             }
             return count;
         }
    }

    public int maxDepthRecursive(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int leftDeep=maxDepthRecursive(root.left);
            int rightDeep=maxDepthRecursive(root.right);
           // System.out.println("left" + leftDeep);
            //System.out.println("right" + rightDeep);
            return(leftDeep > rightDeep)?leftDeep+1:rightDeep+1;
        }
    }

    public void iComputeHeight(Node root)
    {
         Queue<Node> q=new LinkedList<Node>();

           Node nullNode=null; //Integer.MAX_VALUE;

           int ht=0;
           if(root==null)
               System.out.println("Height="+ht);

           q.add(root);
           q.add(nullNode);

           while(!q.isEmpty())
           {
               Node t=q.remove();

               if(t!=null)
               {
                   if(t.left!=null)
                       q.add(t.left);

                   if(t.right!=null)
                       q.add(t.right);
                  

               }

               else    // t is NULL
               {
                   if(!q.isEmpty())
                   {
                      

                   ht++;
                   //System.out.println("height inside " + ht);
                   q.add(nullNode);
                   }
                   else
                       break;

               }

           }

           System.out.println("Iterative Height="+ht);
    }

    public void deepestNode(Node root)
    {
         Queue<Node> q=new LinkedList<Node>();
         if(root==null)
         {
             return;
         }
         else
         {
             q.add(root);
             while(!q.isEmpty())
             {
                 root=q.remove();
                 if(root.left!=null)
                 {
                     q.add(root.left);
                 }
                 if(root.right!=null)
                 {
                     q.add(root.right);
                 }
             }
             System.out.println("the deepest node is" + root.data);
         }
    }

    public void sComputeHeight(Node root)
    {
        if(root==null)
        {
            return;
        }
        else
        {
            Stack s=new Stack();
            s.push(root);
            int maxHeight=0;
            Node prev=null;
             while(!s.isEmpty())
             {
                 Node curr=(Node)s.peek();
                 if(prev==null||prev.left==curr||prev.right==curr)
                 {
                  if(curr.left!=null)
                  {
                      s.push(curr.left);
                  }
                  else if(curr.right!=null)
                  {
                      s.push(curr.right);
                  }
                 }
                 else if(curr.left==prev)
                 {
                     if(curr.right!=null)
                     {
                         s.push(curr.right);
                     }
                 }
                 else
                 {
                     s.pop();
                 }

                 prev=curr;
                 if(s.size()>maxHeight)
                 {
                     maxHeight=s.size()-1;
                 }
             }
            System.out.println("the height of the tree is" + maxHeight);
        }

    }

    public void numberOfLeavesbyLevel(Node root)
    {
        int count=0;
        int full=0;
        int half=0;
        Queue<Node> q=new LinkedList<Node>();
        if(root==null)
        {
            return;
        }
        else
        {
            q.add(root);
            while(!q.isEmpty())
            {
                Node tmp=q.remove();
                if(tmp.left==null && tmp.right==null)
                {
                    count++;
                }
                // for full node

                if(tmp.left!=null && tmp.right!=null)
                {
                    full++;
                }

                // for half full node

                if(tmp.left!=null && tmp.right==null || tmp.left==null && tmp.right!=null)
                {
                    half++;
                }

                if(tmp.left!=null)
                {
                    q.add(tmp.left);
                }

                if(tmp.right!=null)
                {
                    q.add(tmp.right);
                }
            }
        }
        System.out.println("the number of leave nodes are" + count);
        System.out.println("the number of full nodes are" + full);
        System.out.println("the number of half nodes are " + half);

    }

      public int Diameter(Node root, int h)
      {
          int lheight=0,rheight=0;

            int ldiameter=0,rdiameter=0;

          if(root==null)
          {
              h=0;
              return 0;
          }

          ldiameter=Diameter(root.left,lheight);
//          System.out.println("left diameter " + ldiameter);
//          System.out.println("left height" + lheight);
          rdiameter=Diameter(root.right,rheight);
//          System.out.println("right diameter " + rdiameter);
//          System.out.println("right height" + rheight);

        h=Math.max(lheight,rheight)+1;


          if(ldiameter>rdiameter)
              return Math.max(lheight + rheight + 1,ldiameter);
          else
              return Math.max(lheight + rheight + 1,rdiameter);


      }

      public int widthTree(Node root)
      {

          int h=maxDepthRecursive(root);
          System.out.println("depth inside " +h);
          for(int i=1;i<=h;i++)
          {
              int tmp=getWidthTree(root,i);
              if(tmp>maxs)
              {
                  maxs=tmp;
              }
          }
          return maxs;
      }

      public int getWidthTree(Node root,int depth)
      {
          if(root==null)
          {
              return 0;
          }
          else
          {
              if(depth==1)
              {
                  return 1;
              }
              else
              {
                  return getWidthTree(root.left,depth-1)+getWidthTree(root.right,depth-1);
              }
          }
      }

      public void levelMaxSum(Node root)
      {
          int maxsum=0;
          int cursum=0;
          Node nullNode=null;
          if(root==null)
          {
              return;
          }

        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(nullNode);
        while(!q.isEmpty())
        {
            Node tmp=q.remove();
          //  maxsum=tmp.data;
            if(tmp!=null)
            {
                if(tmp.left!=null)
                {
                    q.add(tmp.left);
                    cursum=cursum+tmp.left.data;
                }
                if(tmp.right!=null)
                {
                    q.add(tmp.right);
                    cursum=cursum+tmp.right.data;
                }
                
            }
            else
            {
                if(cursum>maxsum)
                {
                    maxsum=cursum;
                }
                cursum=0;
                if(!q.isEmpty())
                {
                    q.add(nullNode);
                }
            }
        }
          System.out.println("maximum sum of the level is " + maxsum);
      }

      int path[]=new int[20];

     public void paths(Node root)
     {
        pathsUtil(root, 0);
         System.out.println("difference " + finalDiff);
     }

      public void pathsUtil(Node root,int pathlen)
      {
          if(root==null)
          {
              return;
          }
          else
          {
              path[pathlen]=root.data;
              pathlen++;
              if(root.left==null && root.right==null)
              {
                  //printPath(pathlen);
                  findDiffrnce(pathlen-1);

              }
              else
              {
                  pathsUtil(root.left,pathlen);
                  pathsUtil(root.right,pathlen);
              }
          }
         // System.out.println("differnce is " + finalDiff);
      }

      public void printPath(int len)
      {
          for(int i=0;i<len;i++)
          {
              System.out.print(path[i]+ " ");
          }
          System.out.println();
      }


      public void findDiffrnce(int len)
      {
          int leftMax=path[0];
          int diffrnce=Integer.MIN_VALUE;
          for(int i=1;i<=len;i++)
          {
              if(path[i]<leftMax)
              {
                  diffrnce=leftMax-path[i];
                  if(finalDiff<diffrnce)
                  {
                      finalDiff=diffrnce;
                  }
              }
              else
                  leftMax=path[i];

          }
          //return f;
      }



      public int sumBT(Node root)
      {
          if(root==null)
          {
              return 0;
          }
          else
          {
              return (root.data+sumBT(root.left)+sumBT(root.right));
          }
      }
      
      public int Height(Node root)
      {
          if(root==null)
          {
              return 0;
          }
          else
          {
              int l= Height(root.left);
              int r= Height(root.right);

                   return (1+Math.max(l,r));
            //  return (Math.max(l,r)+1);
          }
      }

      public int diameter(Node root)
      {
          int lt,rt=0;
          if(root==null)
          {
              return 0;
          }
          else
          {
              int lftHght=Height(root.left);
              int rgtHght=Height(root.right);


              lt=diameter(root.left);
              rt=diameter(root.right);
             // System.out.println("root "+ root.data + " lt = "+lt + " rt = "+ rt);
             // System.out.println("root "+ root.data + " height "+  (1+ lftHght + rgtHght));

              return Math.max( 1+ lftHght + rgtHght, Math.max(lt, rt));
          }
      }

      public boolean pathHasSum(Node root,int s)
      {
          if(root==null)
          {
              return(s==0);
          }
          else
          {
              s=s-root.data;
              return (pathHasSum(root.left,s) || pathHasSum(root.right,s));
          }
      }

      public Node mirrorTree(Node root)
      {
          Node temp=null;
          if(root!=null)
          {
             
              temp=root.left;
              root.left=root.right;
              root.right=temp;
              mirrorTree(root.left);
              mirrorTree(root.right);
          }
          return root;
      }

    public boolean areMirrorTrees(Node root,Node root1)
    {
        if(root==null && root1==null)
        {
            return true;
        }
        if(root==null || root1==null)
        {
            return false;
        }

        if(root.data!=root1.data )
        {
            return false;
        }
        else
        {
            return(areMirrorTrees(root.left,root1.right) && areMirrorTrees(root.right,root1.left));
        }
    }


public Node buildBT(int inOrder[],int preOrder[],int inStrt,int inEnd)
   {
         Node newNode=new Node(preOrder[preIndex]);

         if(inStrt>inEnd)
             return null;


         if(newNode==null)
         {
             System.out.println("Memory Problem");
             return null;
         }


       preIndex++;
        if(inStrt==inEnd) return newNode;

        int inIndex=0;


        for(int k=0;k<inOrder.length;k++)
        {
            if(inOrder[k]==newNode.data)
            {
               inIndex=k;
            }

        }

        newNode.left=buildBT(inOrder,preOrder,inStrt,inIndex-1);
        newNode.right=buildBT(inOrder,preOrder,inIndex+1,inEnd);

        return newNode;
   }



 public Node buildBTPost(int inOrder[],int postOrder[],int inStrt,int inEnd,int postIndex)
{
    Node newNode=new Node(postOrder[postIndex]);
    if(inStrt>inEnd)
        return null;

    if(inStrt==inEnd)
        return newNode;

   // postIndex--;
    int j,inIndex=0;
    for(j=inStrt;j<=inEnd;j++)
    {
        if(inOrder[j]==newNode.data)
            inIndex=j;
    }


    newNode.left=buildBTPost(inOrder,postOrder,inStrt,inIndex-1,postIndex-1-(inEnd-inIndex));
   // System.out.println("the left data" + newNode.left.data);
    newNode.right=buildBTPost(inOrder,postOrder,inIndex+1,inEnd,postIndex-1);
  //  System.out.println("THE RIGTHT DATA " + newNode.right.data);
     
    return newNode;
}

 public Node buildTree(int[] preorder, int[] inorder) {
    int preStart = 0;
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;

    return construct(preorder,inorder, inStart, inEnd);
}
int preStart=0;
public Node construct(int[] preorder, int[] inorder, int inStart, int inEnd){
    if(inStart>inEnd){
        return null;
    }

    //int val = preorder[preStart];
    Node p = new Node(preorder[preStart++]);

    if(inStart==inEnd)
     return p;
    //find parent element index from inorder
    int k=0;
    for(int i=inStart; i<=inEnd; i++){
        if(p.data == inorder[i]){
            k=i;
            //break;
        }
    }

    p.left = construct(preorder,inorder, inStart, k-1);
    //if(p.left!=null)
    //System.out.println("left chils " + p.left.data);
    p.right= construct(preorder,inorder, k+1 , inEnd);
   // if(p.right!=null)
   //System.out.println("right child " + p.right.data);

    return p;
}

public boolean printAncestors(Node root,Node n)
{
    if(root==null)
        return false;

    if(root.left!=null && root.right!=null)
    {
        if(root.left.data==n.data||root.right.data==n.data||printAncestors(root.left,n)||printAncestors(root.right,n))
        {
            System.out.println(root.data);
            return true;
        }
    }
//    else if(root.left!=null && root.right==null)
//    {
//        if(root.left.data==n.data||printAncestors(root.left,n)||printAncestors(root.right,n))
//        {
//            System.out.println(root.data);
//            return true;
//        }
//
//    }
//    else if(root.left==null && root.right!=null)
//    {
//         if(root.right.data==n.data||printAncestors(root.left,n)||printAncestors(root.right,n))
//        {
//            System.out.println(root.data);
//            return true;
//        }
//    }
        return false;

}

public Node LCA(Node root,Node n1,Node n2)
{
   if(root==null)
   {
       return root;
   }

   if(root.data==n1.data||root.data==n2.data)
   {
       return root;
   }

   Node left=LCA(root.left,n1,n2);
 // System.out.println("left inside LCA "+ left.data);
   Node right=LCA(root.right,n1,n2);
  //  System.out.println("right inside LCA "+ right.data);
   if(left!=null && right!=null)
   {
       return root;
   }
   else
   {
       return(left!=null?left:right);
   }
}


public int numberOfBSTs(int n)
{
    int[] count=new int[n+1];
    count[0]=1;
    count[1]=1;
    for(int i=2;i<=n;i++)
    {
        for(int j=0;j<i;j++)
        {
            count[i]+=count[j]*count[i-j-1];
        }
    }

    return count[n];
}



public void zigzagLevel(Node root)
{
    Stack s1=new Stack();
    Stack s2=new Stack();
    if(root==null)
        return;
    s1.push(root);
   while(!s1.isEmpty())
    {
        while(!s1.isEmpty())
        {
            Node t=(Node)s1.pop();
            System.out.print(t.data + " ");
            if(t!=null)
            {
                
                if(t.left!=null)
                {
                    s2.push(t.left);
                }
                if(t.right!=null)
                {
                    s2.push(t.right);
                }
            }
        }
        while(!s2.isEmpty())
        {
            Node p=(Node)s2.pop();
            System.out.print(p.data + " ");
            if(p!=null)
            {

                 if(p.right!=null)
                {
                    s1.push(p.right);
                }
                if(p.left!=null)
                {
                    s1.push(p.left);
                }
                
            }
        }
    }




}

public Node BuildFromPreorder(char A[],int i)
{
    if(A==null)
    {
        return null;
    }
    if(A.length == i)
    {
        return null;
    }
    Node newNode=new Node(A[i]);
    newNode.left=null;
    newNode.right=null;
    if(A[i]=='L')
    {
        return newNode;
    }
    i=i+1;
    newNode.left=BuildFromPreorder(A,i);
    i=i+1;

    newNode.right=BuildFromPreorder(A,i);
    return newNode;



}

//threaded binary tree

public void morrisTraversalInorder(Node root,int x)
{
    Node current,prev;
    if(root==null)
        return;
     current=root;

     while(current!=null)
     {
         if(current.left==null)
         {
             System.out.print(current.data + " ");
//             if(current.data==x)
//             {
//                 System.out.println("the inorder successor is " + current.right.data);
//             }
             current=current.right;
         }
         else
         {
             prev=current.left;
             while(prev.right!=null && prev.right!=current)
                 prev=prev.right;

             if(prev.right==null)
             {
                 prev.right=current;
                 current=current.left;

             }
             else
             {
                 prev.right=null;
                 System.out.print(current.data+ " ");
//                 if(current.data==x)
//             {
//                 System.out.println("the inorder successor is " + current.right.data);
//             }
                 current=current.right;
             }
         }
     }

}


public void morrisTraversalPreorder(Node root,int x)
{
    Node current,prev;
    if(root==null)
        return;
    current=root;

    while(current!=null)
    {
        if(current.left==null)
        {
           // System.out.print(current.data + " ");
            if(current.data==x)
             {
                 System.out.println("the preorder successor is " + current.right.right.data);
             }
            
            current=current.right;
        }
        else
        {
            prev=current.left;
            while(prev.right!=null && prev.right!=current)
                prev=prev.right;

            if(prev.right==current)
            {
                prev.right=null;
                current=current.right;
            }
            else
            {
               // System.out.print(current.data+ " ");

            if(current.data==x)
             {
                 System.out.println("the preorder successor is " + current.left.data);
             }
                prev.right=current;
                current=current.left;
            }
        }
    }
}


// inorder successor of a binary tree

public Node findRightSuccessor(Node root)
{
    while(root.left!=null)
    {
        root=root.left;
    }
    return root;
}

public Node inorderSuccessor(Node root,int x,Node parent)
{
    if(root==null)
        return null;

    if(root.data==x)
    {
        if(root.right!=null)
        {
            return findRightSuccessor(root.right);
        }
        else
        {
            return parent;
        }
    }
    Node left=inorderSuccessor(root.left,x,root);
    if(left!=null)
        return left;
    return inorderSuccessor(root.right,x,parent);

}

public void inorderSuccessorFrst(Node root,int k)
{
    Node p= inorderSuccessor(root,k,null);
    System.out.println("inorder successor is " + p.data);
}










    public void run()
    {
        insert(root,1);

        insert(root,2);
        insert(root,3);
        insert(root,4);
        insert(root,5);
        insert(root,6);
        insert(root,7);
        insert(root,8);
        insert(root,9);
        //insert(root,10);

//        Node n1=new Node(1);
//         Node n4=new Node(4);
//          Node n7=new Node(7);
//           Node n13=new Node(13);
//           Node n14=new Node(14,n13,null);
//         Node n10=new Node(10,null,n14);
//          Node n6=new Node(6,n4,n7);
//           Node n3=new Node(3,n1,n6);
//           Node n8=new Node(8,n3,n10);

      

        //insert(root1, 10);



//          rInsert(root,1);
//        rInsert(root,2);
//        rInsert(root,3);
//        rInsert(root,4);
//        rInsert(root,5);
//        rInsert(root,6);
//        rInsert(root,7);

//        System.out.println("recursively inorder representation");
//        rInorder(root);
//
        //TODO-------
        //deleteElement(root,3);
//
//                System.out.println("iteratively inorder representation");
//        iInorder(root);
//
//        printMax();

//        System.out.println("recursively preorder representation");
//        rPreorder(root);

//        System.out.println("iteratively preorder representation");
//        iPreorder(root);
//
//          System.out.println("iteratively postorder representation");
//          IpostOrder1stack(root);

//          System.out.println("recursive postorder ");
//          rPostorder(root);
//
//        System.out.println("iteratively level order presentation");
//        iLevelOrder(root);

//        int c=sizeBinaryTree(root);
//        System.out.println("\n the count of tree is" + c);

//        int d=maxDepthRecursive(root);
//        System.out.println("depth of the tree is" + d);

     //iComputeHeight(root);
//      levelMaxSum(root);
      //  deepestNode(root);

      //int starlen=0;
//      paths(n8);

//      int sum=sumBT(root);
//        System.out.println("the sum of the tree is " + sum);

//
    // sComputeHeight(root);
//       int t= maxDepthRecursive(root);
//        System.out.println("the depth of the tree is " + t);
//
//        int w=widthTree(root);
//        System.out.println("width of the tree is " +w);
//
//     numberOfLeavesbyLevel(root);
     //System.out.println("diameter" + Diameter(root,0));

       // reverseBinaryTree(root);

        //int m=maxInBinaryTree(root);
//        int m=iFindMaxElement(root);
//        System.out.println("\n maximum element in binary tree is" + m);

       // System.out.println("element after searching");
//        boolean r=isearchElementBT(root,23);
//        System.out.println(r);

//        int h=Height(root);
//        System.out.println("height of the tree " + h );
//
//        int dia=diameter(root);
//        System.out.println("diameter of the tree " + dia);
//        rInorder(root);
////
//        int sum=10;
//        boolean t=pathHasSum(root,sum);
//        System.out.println("the pas has the sum " + t);

//        root1=mirrorTree(root);
//         System.out.println("iteratively inorder representation after mirror");
//        iLevelOrder(root1);
//
//        boolean trees=areMirrorTrees(root,root1);
//        System.out.println(trees);

        int inOrder[]={8,4,2,5,1,6,7,3};
        int preOrder[]={1,2,4,8,5,7,6,3};
        int postOrder[]={8,4,5,2,6,3,7,1};
        int start=0;
        int end=inOrder.length-1;
        int postIndex=postOrder.length-1;
//
//
//        System.out.println("iteratively inorder representation");
//        rPostorder(buildTree(preOrder,inOrder));
//        System.out.println();
//        rPreorder(buildBTPost(inOrder,postOrder,start,end,postIndex));

        // Node node=new Node(8);
//        boolean v= printAncestors(root,node);
//        System.out.println(v);
//
//        Node n1=new Node(11);
//        Node p=LCA(root,n1,node);
//       System.out.println("the lowest common ancestor is "+ p.data);
//          int n=numberOfBSTs(3);
//          System.out.println("number of bsts " + n);
//        System.out.println();
           zigzagLevel(root);
//
//          String A="ILILL";
//          char S[]=A.toCharArray();
//
//          int i=S.length;
//          rInorder(BuildFromPreorder(S,i)) ;

//          ArrayList<ArrayList<Integer>> r=zigzagLevel(root);
//          System.out.println("zigzag traversal is " + r);
       // morrisTraversalInorder(root,6);
        System.out.println();
       // morrisTraversalPreorder(root,5);
        System.out.println();
       // inorderSuccessorFrst(root,1);

    }

  
}




class Node{
    int data;
    char p;
    Node right;
    Node left;
    public Node(int x)
    {
        this.data=x;
    }

    public Node(int data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

//    public Node(char x)
//    {
//        this.p=x;
//    }
}