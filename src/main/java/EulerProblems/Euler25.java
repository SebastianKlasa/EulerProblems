package EulerProblems;

public class Euler25 {
    public static void main(String[] args) {
        String f = "1";
        String prev = "1";
        int i = 2;
        while(f.length()<1000){
            String tmp = f;
            f = addLargeNum(f, prev);
            prev = tmp;

            i++;
        }
        System.out.println(i);

    }

    //a>b
    public static String addLargeNum(String a, String b){
        int x = a.length();
        String b2 = "";
        for(int i=b.length();i<x;i++){
            b2+='0';
        }
        b2 += b;
        String result="";
        int base =0, rest=0;
        for(int i=x-1;i>=0;i--){
            int value = (a.charAt(i)-'0') + (b2.charAt(i)-'0') + rest;
            base = value % 10;
            rest = value / 10;
            result +=base;
        }
        if(rest>0) result+=rest;
        StringBuilder sb = new StringBuilder(result);
        return sb.reverse().toString();
    }
}
