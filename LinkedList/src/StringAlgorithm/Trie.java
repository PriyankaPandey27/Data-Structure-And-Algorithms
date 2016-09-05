/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */

class TrieNode{

    char letter;
    TrieNode[] links;
    boolean fullword;

    TrieNode(char letter,boolean fullword)
    {
        this.letter=letter;
        links=new TrieNode[26];
        this.fullword=fullword;
    }
}
public class Trie {
    
    public static void main(String[] args)
    {
        TrieNode root=createTree();
        
        String words[]={"an", "ant", "all", "allot", "alloy", "pri", "poter", "nikki", "suse"};
        for(int i=0;i<words.length;i++)
        {
            insertWord(root,words[i]);
        }
        
        char branch[]=new char[6];
        printTree(root,0,branch);

        System.out.println("---------------------");

//        String searchWrd="poter";
//
//        if(find(root,searchWrd))
//        {
//            System.out.println("word found is " + searchWrd);
//        }
//        else
//        {
//            System.out.println("word not found is " + searchWrd);
//        }
//
//        deleteKey(root, "poter");
//        printTree(root, 0, branch);

    }

    static TrieNode createTree()
    {
        return (new TrieNode('\0',false));
    }

    static boolean isItFreeNode(TrieNode node)
    {
        int i;
        for(i=0;i<node.links.length;i++)
        {
            if(node.links[i]!=null)
                return false;
        }
        return true;
    }

    static void insertWord(TrieNode root,String words)
    {
        char letter[]=words.toCharArray();
        int l=letter.length;
        //int offset=97;
        TrieNode curNode=root;

        for(int i=0;i<l;i++)
        {
            if(curNode.links[letter[i]-97]==null)
                curNode.links[letter[i]-97]=new TrieNode(letter[i],i==l-1?true:false);

            curNode=curNode.links[letter[i]-97];
        }

    }

    static void printTree(TrieNode root,int level,char[] branch)
    {
        if(root==null)
            return ;

        for(int i=0;i<root.links.length;i++)
        {
            branch[level]=root.letter;
            printTree(root.links[i], level+1, branch);
        }

        if(root.fullword)
        {
            for(int j=0;j<=level;j++)
                System.out.print(branch[j]);

            System.out.println();
        }

    }

    static boolean find(TrieNode root,String word)
    {
        char letter[]=word.toCharArray();
        int l=letter.length;
        int offset=97;
        TrieNode curNode=root;
        int i;
        for( i=0;i<l;i++)
        {
            if(curNode==null)
                return false;

            curNode=curNode.links[letter[i]-offset];
        }

        if(i==l && curNode==null)
            return false;

        if(curNode!=null && !curNode.fullword)
            return false;

        return true;
    }

    static void deleteKey(TrieNode root,String key)
    {
        char word[]=key.toCharArray();
        int l=word.length;
        boolean f;
        if(find(root,key))
        {
           f=deleteHelper(root,word,0);
            System.out.println("deleted successfully " + key);
        }
        else
            System.out.println("not deleted word " + key);
    }

    static boolean deleteHelper(TrieNode root,char[] word,int level)
    {
        int offset=97;

        if(root!=null)
        {
            int l=word.length;
            TrieNode curNode=root;

            if(l==level)
            {
                if(curNode.fullword)
                {
                    curNode.fullword=false;
                }

                if(isItFreeNode(curNode))
                {
                    return true;
                }
                return false;
            }
             else
            {
            int index=word[level]-offset;
            if(deleteHelper(root.links[index], word, level+1))
               {
                curNode.links[index]=null;
                return (curNode.fullword && isItFreeNode(curNode));
               }
            }
        }
        return false;


    }

    

}
