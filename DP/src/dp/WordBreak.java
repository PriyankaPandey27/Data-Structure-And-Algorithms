/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author admin
 */
public class WordBreak {

    public static void main(String[] args) {

    if(wordBreakProblem("iiiiiiii"))
     System.out.println("yes\n");
    else
     System.out.println("no\n");

//    wordBreakProblem("iiiiiiii")? cout <<"Yes\n": cout << "No\n";
//    wordBreakProblem("")? cout <<"Yes\n": cout << "No\n";
//    wordBreakProblem("ilikelikeimangoiii")? cout <<"Yes\n": cout << "No\n";
//    wordBreakProblem("samsungandmango")? cout <<"Yes\n": cout << "No\n";

    }

    public static boolean wordBreakProblem(String str)
    {
        int size=str.length();
        if(size==0)
            return true;

        boolean wb[]=new boolean[size+1];
        for(int i=1;i<=size;i++)
        {

            if (wb[i-1] == false && dictionaryContains( str.substring(0, i) ))
            wb[i-1] = true;

            if(wb[i-1]==true)
            {
                if(i-1==size)
                    return true;

                for(int j=i+1;j<=size;j++)
                {
                    //System.out.println("inside j " + j + " inside i "+ i);
                    if(wb[j-1]==false && dictionaryContains(str.substring(i, j)))
                        wb[j-1]=true;


                }
            }
        }

        return wb[size-1];




    }

    public static boolean dictionaryContains(String word)
    {
        String dictionary[]={"mobile","samsung","sam","sung","man","mango",
                           "icecream","and","go","i","like","ice","cream"};
        for(int i=0;i<dictionary.length;i++)
        {
            if(dictionary[i].compareToIgnoreCase(word)==0)
                return true;
        }
        return false;
    }

}


