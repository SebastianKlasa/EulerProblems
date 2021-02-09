package EulerProblems;

public class Euler16 {
    public static void main(String[] args) {
        String x = "1";
        int posVal = 1000;
        for(int i=0; i<posVal; i++){
            x = pow2(x);
        }
        System.out.println(x);

        int val=0;
        for(int i=0;i<x.length();i++){
            val += (x.charAt(i) - '0');
        }
        System.out.println(val);
    }

    public static String pow2(String n){
        String result = "";
        int rest = 0;
        for(int i=n.length()-1;i>=0; i--){
            int tmp = (n.charAt(i) - '0');
            int multiplyRes = tmp * 2 + rest;
            result += (multiplyRes%10);
            rest = (multiplyRes/10);
        }
        if(rest > 0){
            result +=rest;
        }
        StringBuilder sb = new StringBuilder(result);
        sb.reverse();
        return sb.toString();
    }

}
