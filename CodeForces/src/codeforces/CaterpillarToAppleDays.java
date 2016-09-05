/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class CaterpillarToAppleDays {


private static StringTokenizer st;

    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    public static String next()
    {
        return st.nextToken();
    }

    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        int h1 , h2, a , b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        h1= nextInt();
        h2 = nextInt();

        nextLine(br);
        a= nextInt();
        b = nextInt();

        int c=getdays(h1, h2, a, b);


//        System.out.println(c + "count");
//        BufferedOutputStream bos = new BufferedOutputStream(System.out);
       BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
        bos.write(c+"\n"); //    write(String.valueOf(count));
        bos.flush();
    }


    public static int getdays(int h1 , int h2 , int a , int b){
        if(h1==h2) return 0;
        if(h1>h2) return -1;

        int nightTime=15;
        int days=0;

        while(h1!=h2)
        {
            while(nightTime<=22)
            {
                h1=h1+a;
//                System.out.println("h1 inside 1loop  " + h1);
//            System.out.println("h2 inside 1loop" + h2);
                if(h1>=h2)
                    return days;
                nightTime++;
            }

            if((a)-(b)<=0)
                return -1;
            
            while(nightTime>22 || nightTime<=10)
            {
                if(nightTime>24)
                    nightTime=1;
                h1=h1-b;
                nightTime++;
            }

            while(nightTime>10 && nightTime<=14)
            {
                h1=h1+a;
                nightTime++;

            }
            days++;

//            System.out.println("h1  " + h1);
//            System.out.println("h2 " + h2);


        }
        System.out.println("days are " +days);
        return days;


    }


}
