package EulerProblems;

public class Euler27 {
    public static void main(String[] args) {
        int max = 0;
        int maxA = 0;
        int maxB = 0;
        for(int a=-999;a<1000;a++){
            for(int b=-1000;b<=1000;b++){
                int n = 0;
                while(true) {
                    int val = (int) (Math.pow(n, 2) + a * n + b);
                    n++;
                    if(!isPrime(val)){
                        if(n>max){
                            max = n;
                            maxA = a;
                            maxB = b;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(max);
        System.out.println("a= " + maxA);
        System.out.println("b= " + maxB);
        System.out.println("product= " + maxA*maxB);
    }

    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i = 2;i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
