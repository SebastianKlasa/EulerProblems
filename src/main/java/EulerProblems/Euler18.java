package EulerProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This is solution for Euler problem 18 an 67
 */
public class Euler18 {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("euler67.txt"))){
            String row;
            List<ArrayList<Integer>> elements = new ArrayList<>();
            int index = 0;
            while((row = br.readLine()) != null){
                String[] nums = row.split(" ");
                List<Integer> listNums = new ArrayList<>();
                for(String num:nums) {
                    listNums.add(Integer.parseInt(num));
                }
                elements.add((ArrayList<Integer>) listNums);
            }
            System.out.println("loaded");

            for(int i=elements.size()-2;i>=0;i--){
                System.out.println(i);
                List<Integer> currList = elements.get(i);
                List<Integer> prevList = elements.get(i+1);
                for(int i1 = 0;i1<currList.size();i1++){
                    System.out.print(i1);
                    int n1 = currList.get(i1) + prevList.get(i1);
                    int n2 = currList.get(i1) + prevList.get(i1 + 1);
                    if(n1>n2) currList.set(i1, n1);
                    else currList.set(i1, n2);
                }
            }

            System.out.println("computed");
            System.out.println(elements.get(0).get(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
