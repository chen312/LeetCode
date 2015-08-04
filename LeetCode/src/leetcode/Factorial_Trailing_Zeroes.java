package leetcode;

/**
 * @author Sunshine
 */
public class Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        if (n < 0)
            return 0;
        int count = 0;
        for (int i = n/5; i > 0; i = i / 5){
            count += i;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Factorial_Trailing_Zeroes test = new Factorial_Trailing_Zeroes();
        System.out.println(test.trailingZeroes(1808548329));
    }
}
