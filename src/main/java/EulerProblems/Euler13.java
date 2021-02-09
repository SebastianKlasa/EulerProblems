package EulerProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Euler13 {
    public static void main(String[] args) {
        File data = new File("euler13");
        List<String> strNum = new ArrayList<String>();

        try(Scanner scanner = new Scanner(data)){
            while(scanner.hasNext()){
                String number = scanner.nextLine();
                strNum.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long x40 = (sum(strNum, 40))/10000000000L;
        long x30 = (sum(strNum, 30) + x40)/10000000000L;
        long x20 = (sum(strNum, 20) + x30)/10000000000L;
        long x10 = (sum(strNum, 10) + x20)/10000000000L;
        long x00 = sum(strNum, 0) + x10;

        System.out.println(x00);
    }

    public static long sum(List<String> strNum, int startIndex){
        long sum = 0;
        List<Long> numbers = new ArrayList<Long>();
        for(String num:strNum){
            sum +=Long.parseLong(num.substring(startIndex, startIndex+10));
        }
        return sum;
    }

}
