package leetcode;

/**
 * @author Sunshine
 */
public class Climbing_Stairs {
    // Time complexity is O(n)
    public static int climbStairs(int n) {
        if (n <= 3)
            return n;
        int a = 2, b = 3;
        for (int i = 4; i < n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a+b;
    }
    
    public static void main(String[] args) {
        int n = 6;
        System.out.println(climbStairs(n));
    }
}
