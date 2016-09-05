/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

import java.util.ArrayList;

public class TernarySearchTree {

    public static void main(String args[])
    {
        TernarySearchTreeTest ts=new TernarySearchTreeTest();
        System.out.println("Insert Element");
        ts.insert("IN");
        ts.insert("APPLE");
        ts.insert("PINE");
        ts.insert("PINA");
        ts.insert("PINEAPPLE");
        ts.insert("AN");
        ts.insert("INNINGS");
        System.out.println(" the string is " + ts.search("AN"));
        ts.tostring();

//        String p="PINE";
//        ts.tostring(p);
//        ts.delete("IN");
       // System.out.println("traversal is " + ts.traverse(null, p, p));
//        System.out.println("check whether elemts are present " + "IN " +ts.search("IN"));

        


    }
}

class TSTNode
{
    char data;
    boolean isEnd;
    TSTNode left,middle,right;

    public TSTNode(char x)
    {
        this.data=x;
        this.left=null;
        this.middle=null;
        this.right=null;
    }
}

class TernarySearchTreeTest{

    private TSTNode root;
    private ArrayList<String> al;

    public TernarySearchTreeTest()
    {
        root=null;
    }
    public void insert(String word)
    {
        root=insertUtil(root,word.toCharArray(),0);
    }

    public TSTNode insertUtil(TSTNode r,char[] word,int ptr )
    {
        if(r==null)
            r=new TSTNode(word[ptr]);
        if(word[ptr]>r.data)
            r.right=insertUtil(r.right,word,ptr);
        else if(word[ptr]<r.data)
            r.left=insertUtil(r.left,word,ptr);
        else
        {
            if(ptr+1 < word.length)
            {
                r.middle=insertUtil(r.middle,word,ptr+1);
                //System.out.println("r middle " + r.middle.data);
                
            }
            else
                r.isEnd=true;
        }
        return r;
    }

    public void delete(String word)
    {
        deleteUtil(root,word.toCharArray(),0);
    }

    public void deleteUtil(TSTNode r,char word[],int ptr)
    {
        if(r==null)
            return;

        if(word[ptr]<r.data)
            deleteUtil(r.left, word, ptr);
        else if(word[ptr]>r.data)
            deleteUtil(r.right, word, ptr);
        else
        {
            if(r.isEnd && ptr==word.length-1)
                r.isEnd=false;

            else if(ptr+1<word.length)
                deleteUtil(r.middle, word, ptr+1);

        }
    }

    public boolean search(String word)
    {
        return search(root,word.toCharArray(),0);
    }

    public boolean search(TSTNode r,char[] word,int ptr)
    {
        if(r==null)
            return false;
        if(word[ptr]<r.data)
            return search(r.left,word,ptr);
        else if(word[ptr]>r.data)
            return search(r.right,word,ptr);
        else
        {
            if(r.isEnd && ptr==word.length-1)
                return true;
            else if(ptr==word.length-1)
                return false;
            else
                return search(r.middle,word,ptr+1);


        }
    }

    public void nextLookUp(String word)
    {

    }

    public void nextLookUpUtil(TSTNode r,char[] word,int ptr)
    {
        if(r==null)
            return;
        if(word[ptr]<r.data)
            nextLookUpUtil(r.left,word,ptr);
        else if(word[ptr]>r.data)
            nextLookUpUtil(r.right,word,ptr);
        else
        {
            if(r.isEnd && ptr==word.length-1)
            {

            }
            else
                nextLookUpUtil(r.middle,word,ptr+1);
        }

    }

     public void tostring2(String word)
    {
        al = new ArrayList<String>();

        traverse(root, "",word);
        System.out.println("\nTernary Search Tree : "+ al);
       // System.out.println("size is "+al.size());
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i).equalsIgnoreCase(word))
            {
                if(i+1<al.size())
                {
                System.out.println("next value is " + al.get(i+1));
                break;
                }
                else
                {
                    System.out.println("next element not present in dictionary");
                }
            }
        }
//        for(String s : al)
//        {
//            if(s.equalsIgnoreCase(word))
//            {
//                System.out.println("");
//            }
//        }
    }
    /** function to traverse tree **/

     public void tostring()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        //return "\nTernary Search Tree : "+ al;
         for(String s : al)
        {
            System.out.println(s);
        }
         System.out.println();
    }
    /** function to traverse tree **/
    private void traverse(TSTNode r, String str)
    {
        if (r != null)
        {
            //System.out.println("r is :: " + r.data);
            traverse(r.left, str);

            str = str + r.data;
          //  System.out.println("str is ::: " + str);
            if (r.isEnd)
                al.add(str);

            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);

            traverse(r.right, str);
        }
    }
    public void traverse(TSTNode r, String str,String word)
    {
        if (r != null)
        {
          //  System.out.println("r is :: " + r.data);
            traverse(r.left, str,word);

            str = str + r.data;
            //System.out.println("str is ::: " + str);
            if (r.isEnd)
                al.add(str);

            traverse(r.middle, str,word);
            str = str.substring(0, str.length() - 1);

            traverse(r.right, str,word);
        }
    }
}
