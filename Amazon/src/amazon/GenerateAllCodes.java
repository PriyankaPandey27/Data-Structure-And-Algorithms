/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class GenerateAllCodes {

    public static void main(String[] args) {

        for(String s:decode("2010"))
        {
           System.out.println(s);
        }

    }

    public static Set<String> decode(String s)
    {
        char c='a';
        HashMap<Integer,Character> h=new HashMap<Integer,Character>();
        for(int i=1;i<=26;i++)
        {
            h.put(i,c);
            c++;
        }
        return decodeHelper(h, s, 0, new ArrayList<Character>());
    }

    public static Set<String> decodeHelper(HashMap<Integer,Character> h,String s,int index,ArrayList<Character> arr)
    {
        Set<String> res=new HashSet<String>();
        if(s.length()<=index)
        {
            String str="";
            for(char c : arr)
            {
                str+=c;
            }
            res.add(str);
            return res;
        }
        else
        {
            String st=s.charAt(index)+" ";
            int code=Integer.parseInt(st.trim());
            if (code == 0) {
            int precCharCode = Integer.parseInt((s.charAt(index - 1) + "").trim());
            if (precCharCode == 1)
            code = 10;
            if (precCharCode == 2)
            code = 20;
            }
            char p=h.get(code);
            //System.out.println("char value " + p);
            arr.add(p);
            res.addAll(decodeHelper(h, s, index+1, arr));
            arr.remove(arr.size()-1);
            if(s.length()>index+1)
            {
                code=Integer.valueOf(s.substring(index, index+2));
                //System.out.println("code value " + code);
                if(code<=26)
                {
                    p=h.get(code);
                   // System.out.println("char value inside " + p);
                    arr.add(p);
                    res.addAll(decodeHelper(h, s, index+2, arr));
                    arr.remove(arr.size()-1);
                }
            }
        }
        return res;
    }
}
