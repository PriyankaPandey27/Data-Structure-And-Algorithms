
package recursion1st.log;

public class log {
    public static void main(String[] args) {
        logfunc(8);

    }
    public static int logfunc(int n){
        if(n==1) 
            return 0;
        else {
             System.out.print(n + "  ");
            int p=logfunc(n/2);
            System.out.println(p + "  ");
        return 1 + p;
        }
    }

}

