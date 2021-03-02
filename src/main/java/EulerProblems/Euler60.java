package EulerProblems;

import java.util.LinkedList;
import java.util.List;

public class Euler60 {
    public static void main(String[] args) {
        LinkedList<Integer> num = new LinkedList<Integer>();
        num.add(3);
        num.add(7);
        num.add(109);
        num.add(673);
        for(int i=674; true; i++){
            if(isPrime(i)){
                num.addLast(i);
                if(checkConcatenating(num)){
                    System.out.println(sumList(num));
                    break;
                }
                else {
                    num.removeLast();
                }
            }
            if(i==Integer.MAX_VALUE){
                System.out.println("Max int size!!!");
                break;
            }
        }
    }

    public static int sumList(List<Integer> list){
        int sum = 0;
        for(int el:list){
            sum+=el;
        }
        return sum;
    }

    public static boolean checkConcatenating(List<Integer> list){
        for(Integer el1:list){
            for(Integer el2:list){
                if(el1!=el2){
                    String num1 = el1.toString() + el2.toString();
                    String num2 = el2.toString() + el1.toString();
                    if(!isPrime(Long.parseLong(num1)) || !isPrime(Long.parseLong(num2))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isPrime(long n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
