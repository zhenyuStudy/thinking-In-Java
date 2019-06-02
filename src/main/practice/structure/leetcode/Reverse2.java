package structure.leetcode;

public class Reverse2 {

    public static int reverse(int x){
        int result = 0;

        while (x != 0) {
            int pop = x % 10;
            x = x /10;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 7654321;
        int result = reverse(target);
        System.out.println(result);
    }
}
