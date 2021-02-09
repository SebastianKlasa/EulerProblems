package EulerProblems;

import java.util.HashMap;
import java.util.Map;

public class Euler31 {
    public static Map<Float, Integer> data = new HashMap<Float, Integer>();

    public static void main(String[] args) {
        System.out.println(count(0.04f));
    }

    public static int count(float lack){
        float[] coins = {0.01f, 0.02f, 0.05f, 0.1f, 0.2f, 0.5f, 1f, 2f};
        int sum = 0;

        for(int i=0; i<coins.length;i++){
            float tmpLack = lack - coins[i];
            if(tmpLack == 0) sum += 1;
            else if(tmpLack < 0) sum+= 0;
            else{
              //  if(data.get(tmpLack) != null)sum +=data.get(tmpLack);
              //  else{
                    sum += count(tmpLack);
              //  }
            }
        }
        data.put(lack, sum);
        return sum;
    }

}
