/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StringAlgorithm;

/**
 *
 * @author admin
 */
public class ReplaceSpaces {

    public static void main(String[] args) {

        char[] ch={'t', 'h', 'e', ' ', ' ',' ' ,'d', 'o', 'g', ' ','h', ' ', ' ', ' ', ' ', 'm'};
        //int length=8;
        replace(ch, ch.length);
        System.out.println("");
        System.out.println("the string without space is " + removeSpace(ch));


    }

    public static void replace(char[] str,int length)
    {
        int spaceCount=0;
        int newLength=0;

        for(int i=0;i<length;i++)
        {
            if(str[i]==' ')
            {
                spaceCount++;
            }
        }

        int newPosition=length+(spaceCount*2);
        char[] newArry=new char[newPosition+1];
        newArry[newPosition]='\0';

        for(int i=0;i<length;i++)
        {
            if(str[i]==' ')
            {
                newArry[newLength]='%';
                newArry[newLength+1]='2';
                newArry[newLength+2]='0';
                newLength=newLength+3;
            }
            else
            {
                newArry[newLength]=str[i];
                newLength++;
            }
        }

        System.out.println(newArry);
    }


    public static String removeSpace(char s[])
    {
        if(s==null || s.length==0)
            return null;

      //  int count=0;
        String res="";
        for(int i=0;i<s.length;i++)
        {
            if(s[i]!=' ')
                res=res+s[i];
            
                
        }
        return res;

       // System.out.println(s);

    }



}
