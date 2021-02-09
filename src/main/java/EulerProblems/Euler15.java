package EulerProblems;

public class Euler15 {
    public static void main(String[] args) {
        System.out.println(path(0, 0));
    }

    public static long path(int x, int y){
        if(x == 20 || y == 20){
            return 1;
        }
        else {
            long right = 0, bottom = 0;
            right = path(x + 1, y);
            bottom = path(x, y + 1);
            return right + bottom;
        }
    }
}
