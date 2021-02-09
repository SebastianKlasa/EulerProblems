package EulerProblems;

public class Euler17 {
    public static void main(String[] args) {
        int n1 = countSingular();
        int n2 = countDozen();
        int n3 = countDecimal();
        int n4 = countHundred();
        int n5 = "onethousand".length();

        System.out.println(n4+n5);
    }

    public static int countSingular(){
        String[] val = {"one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};

        int x = 0;
        int prev = 0;
        for(int i=0;i<val.length;i++){
            prev = x;
            x+=val[i].length();
            System.out.println(i + " - "+(x-prev));
        }

        return x;
    }

    public static int countDozen(){
        String[] val = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};

        int x = 0;
        int prev = 0;
        for(int i=0;i<val.length;i++){
            prev = x;
            x+=val[i].length();
            System.out.println(i + " - "+(x-prev));
        }

        return x;
    }

    public static int countDecimal(){
        String[] val = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety"};

        int x = 0;
        int prev = 0;
        for(int i=0;i<val.length;i++){
            prev = x;
            x+=(val[i].length() * 10);
            x+=countSingular();
            System.out.println(i + " - "+(x-prev));
        }

        return x;
    }

    public static int countHundred(){
        String[] val = {"", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine"};

        int x = 0;
        int prev = 0;
        for(int i=0;i<val.length;i++){
            prev = x;
            if(i>0) x+=((val[i].length() + "hundredand".length())*100 -3);
            x+=countSingular();
            x+=countDozen();
            x+=countDecimal();
            System.out.println(i + " - "+(x-prev));
        }

        return x;
    }

}
