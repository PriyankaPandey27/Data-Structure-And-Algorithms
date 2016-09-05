/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

import java.util.HashMap;

/**
 *
 * Priyanka Nikhil :P
 *
 * admin
 */


class TrieNode{

    private char value;
    private HashMap<Character,TrieNode> children;
    private boolean bIsEnd;
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
        crawl.setIsEnd(true);


    }

    public String longestPrefixMatching(String word)
    {
        String result="";
        int len=word.length();
         TrieNode crawl=root;
         int prevMatch=0;
         for(int level=0;level<len;level++)
         {
             HashMap<Character,TrieNode> child=crawl.getChildren();

             char ch=word.charAt(level);
             //System.out.println("char  " + ch);
             if(child.containsKey(ch))
             {
                 result+=ch;
                // System.out.println("result " + result);
                 crawl=child.get(ch);
                 if(crawl.bIsEnd()==true)
                 {
                     prevMatch=level+1;
                     //System.out.println("match  " + prevMatch);
                 }

             }
//             else
//                 break;
         }

         if(crawl.bIsEnd()==false)
         {
             return word.substring(0, prevMatch);
         }
         else
             return result;
    }

}
public class LongestPrefixMatching {
    

    public static void main(String[] args)
    {
        Trie dict=new Trie();
        dict.insert("roma");
          dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("case");
        dict.insert("basement");
          dict.insert("pick");

//          String input="$#arepaa";
//          System.out.print(input + " :  ");
//          System.out.println(dict.longestPrefixMatching(input));
          
          String input1="cased";
          System.out.print(input1 + " :  ");
          System.out.println(dict.longestPrefixMatching(input1));




    }

}
