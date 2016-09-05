/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
    public String contact;
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

    public void setContact(String s)
    {
        this.contact=s;
    }

    public String getContact()
    {
        return contact;
    }


}


class Trie{

    private TrieNode root;

    public HashMap<String,String> contact=new HashMap<String,String>();

    public Trie(){

        root=new TrieNode((char)0);
    }

    public void insert(String word,String number)
    {
        int len=word.length();
        TrieNode crawl=root;
        String res="";

        for(int level=0;level<len;level++)
        {
            HashMap<Character,TrieNode> child=crawl.getChildren();
            char ch=word.charAt(level);
            res+=ch;
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
        crawl.setContact(number);
       // System.out.println("while inserting " + res);
//        if(contact.get(res)==null)
//        {
//            contact.put(res, number);
//        }


    }

    public void longestPrefixMatching(String word)
    {
        String result="";
        int len=word.length();
         TrieNode crawl=root;
         int prevMatch=0;
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
//             else
//                 break;
         }
         if(level==len)
         {
             printAllData(crawl, result,0);
         }

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
               // System.out.println("key is " + key);
             if(key!=null)
             {
                 datas[index] = key;
//                 result.  +=key;
             }
             if(entry.getValue().bIsEnd())
             {
                 String s2 = getString(datas, index);
                 String res=result+s2;
                 System.out.println(res + " " + entry.getValue().getContact());
//                 if(contact.get(res)!=null)
//                 {
//                     System.out.println(res + " " + contact.get(res));
//                 }
                 //System.out.println(res);
             }
//             System.out.println("index = " + index);
             printAllData(entry.getValue(), result ,index +1);
            }
    }
}
public class ContactList {


    public static void main(String[] args)
    {
        Trie dict=new Trie();
        dict.insert("sarma","9980458094");
        dict.insert("satima","9980458678");
        dict.insert("saurabh","9980445783");
        dict.insert("saumya","9980458094");
        dict.insert("stat","9980458094");
       

//          String input="$#arepa";
//          System.out.print(input + " :  ");
//          dict.longestPrefixMatching(input);

          String input1="st";
          System.out.print(input1 + " :  ");
          dict.longestPrefixMatching(input1);




    }

}

