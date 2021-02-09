package EulerProblems;

public class Euler14 {
    public static void main(String[] args) throws InterruptedException {
        int max = 0;
        int index = 0;
        for(int i=2; i<1000000; i++){
            int tmp = chainLength(i);
            if(tmp>max){
                max = tmp;
                index = i;
            }
        }
        System.out.println(index);
    }
    public static int chainLength(long startNum) throws InterruptedException {
        int x=1;
        long startNumBack = startNum;
        while (startNum!=1){
            if(startNum%2==0){
                startNum /= 2;
            }
            else{
                startNum = 3*startNum+1;
            }
            x++;
        }
        return x;
    }
}
