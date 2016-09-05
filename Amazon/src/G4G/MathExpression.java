/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package G4G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MathExpression {
    
    

    public static void main (String[] args) {

        int h1 , h2;
        String s1;
        MyScanner in = new MyScanner();
        h1= in.nextInt();
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=h1;i++)
        {
            
            h2= in.nextInt();
            s1= in.nextLine();

            BigInteger sum = evaluateExpression(s1, h2);
            try {
                bos.write(sum + "\n");
            } catch (IOException ex) {
//                Logger.getLogger(MathExpression.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            bos.flush();
        } catch (IOException ex) {
//            Logger.getLogger(MathExpression.class.getName()).log(Level.SEVERE, null, ex);
        }
	}






    public static BigInteger evaluateExpression(String expression,int preced)
    {
        char[] input = expression.toCharArray();
        Stack<BigInteger> operator = new Stack<BigInteger>();
        Stack<Character> operand = new Stack<Character>();

        for (int i = 0; i < input.length; i++)
        {

            if (input[i] == ' ')
                continue;


            if (input[i] >= '0' && input[i] <= '9')
            {
                StringBuffer s = new StringBuffer();

                while (i < input.length && input[i] >= '0' && input[i] <= '9')
                    s.append(input[i++]);
                operator.push(new BigInteger(s.toString().trim()));
            }


            else if (input[i] == '(')
                operand.push(input[i]);


            else if (input[i] == ')')
            {
                while (operand.peek() != '(')
                  operator.push(operation(operand.pop(), operator.pop(), operator.pop()));
                operand.pop();
            }

            else if (input[i] == '+' || input[i] == '-' ||
                     input[i] == '*' || input[i] == '/')
            {

                while (!operand.empty() && precedencePriority(input[i], operand.peek(),preced))
                  operator.push(operation(operand.pop(), operator.pop(), operator.pop()));


                operand.push(input[i]);
            }
        }


        while (!operand.empty())
            operator.push(operation(operand.pop(), operator.pop(), operator.pop()));


        return operator.pop();
    }


    public static boolean precedencePriority(char op1, char op2,int priority)
    {
        if(priority == 0)
        {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
        }
        else if(priority == 1)
        {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return true;
        else
            return false;
        }
        else

             return false;
    }


    public static BigInteger operation(char c, BigInteger b, BigInteger a)
    {
        switch (c)
        {
        case '+':
            return a.add(b); // + b;
        case '-':
            return a.subtract(b); // - b;
        case '*':
            return a.multiply(b); // * b;
        case '/':
            if (b.equals(0))
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a.divide(b);
        }
        return new BigInteger("0");
    }

}

class MyScanner {

    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
