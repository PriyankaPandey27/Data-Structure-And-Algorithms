/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Priyanka Nikhil :P
 *
 * admin
 */


class TrieNode{

    public char value;
    public HashMap<Character,TrieNode> children;
    public boolean bIsEnd;
    public TrieNode(char ch)
    {
        this.value=ch;
        children=new HashMap<Character,TrieNode>();
    }

    public HashMap<Character,TrieNode> getChildren()
    {
        return children;
    }

    public void setIsEnd(boolean val)
    {
        this.bIsEnd=val;
    }

    public boolean bIsEnd()
    {
        return bIsEnd;
    }


}


class Trie{

    private TrieNode root;

    public Trie(){

        root=new TrieNode((char)0);
    }

    public void insert(String word)
    {
        int len=word.length();
        TrieNode crawl=root;

        for(int level=0;level<len;level++)
        {
            HashMap<Character,TrieNode> child=crawl.getChildren();
            char ch=word.charAt(level);
            if(child.containsKey(ch))
            {
                crawl=child.get(ch);
            }
            else
            {
                TrieNode temp=new TrieNode(ch);
                child.put(ch, temp);
                crawl=temp;
            }

            
        }
        //System.out.println("crawl value " + crawl.value);
        crawl.setIsEnd(true);


    }

    public void longestPrefixMatching(String word)
    {
        String result="";
        int len=word.length();
         TrieNode crawl=root;
         //int prevMatch=0;
         int level;
         for(level=0;level<len;level++)
         {
             HashMap<Character,TrieNode> child=crawl.getChildren();

             char ch=word.charAt(level);
             //System.out.println("char  " + ch);
             if(child.containsKey(ch))
             {
                 result+=ch;
                // System.out.println("result " + result);
                 crawl=child.get(ch);
                // System.out.println("crawl " + crawl.value);
//                 if(crawl.bIsEnd()==true)
//                 {
//                    // System.out.println("inside crawl");
//                     prevMatch=level+1;
//                    // System.out.println("match  " + prevMatch);
//                 }

             }
             else
                 break;
         }
        // System.out.println("crawl value " + crawl.value);
        // System.out.println("result value " + result) ;
         if(level==len)
         {
             printAllData(crawl, result,0);
         }

//         if(crawl.bIsEnd()==false)
//         {
//             System.out.println(word.substring(0, prevMatch));
//         }
//         else
//         {
//             System.out.println(result);
//         }
    }
     public String getString (char[] c , int len)
   {
       
       String s = null;
       for(int i=0;i<=len;i++)
       {
           if(s==null) 
               s=String.valueOf(c[i]);
           else 
               s+=c[i];
          
       }
//        System.out.println("s= "+s);
       return s;
       
   }
    char[] datas = new char[256];

    public void printAllData(TrieNode crawl , String result , int index)
    {
            for (Map.Entry<Character, TrieNode> entry : crawl.getChildren().entrySet())
            {
             Character key = entry.getKey();
                //System.out.println("key is " + key);
             if(key!=null)
             {
                 datas[index] = key;
//                 result.  +=key;
             }
             if(entry.getValue().bIsEnd())
             {
                 String s2 = getString(datas, index);
                 System.out.println(result + s2);
             }
//             System.out.println("index = " + index);
             printAllData(entry.getValue(), result ,index +1);
            }
    }

}
public class Autofill {


    public static void main(String[] args)
    {
        Trie dict=new Trie();
//        dict.insert("roma");
//          dict.insert("are");
//        dict.insert("area");
//        dict.insert("base");
//        dict.insert("cat");
//        dict.insert("cater");
//        dict.insert("basement");
//          dict.insert("pick");

            dict.insert("sarma");
            dict.insert("saurabh");
        dict.insert("saumya");
        dict.insert("satima");
        
        dict.insert("stat");

//          String input="$#arepa";
//          System.out.print(input + " :  ");
//          dict.longestPrefixMatching(input);
          
          String input1="sau";
          System.out.print(input1 + " :  ");
          dict.longestPrefixMatching(input1);




    }

}
