/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class SuffixArrrayNaive {

    public static void main(String[] args) throws IOException
    {
        System.out.println(" enter the input string");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        int N=s1.length();
        HashMap<String,Integer> ht=new HashMap<String,Integer>();
        Vector<String> vec=new Vector(N);

        for(int i=0;i<N;i++)
        {
            ht.put(s1.substring(i, N), i);
            vec.add(s1.substring(i, N));
        }

        Collections.sort(vec);

        for(int i=0;i<vec.size();i++)
        {
            String key=vec.get(i);
            int c=ht.get(key);
            System.out.println(c+ " " +key);


        }


    }

}
