package leetcode;

/**
 * @author Sunshine
 */
public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int result = 0;
        for (int i = 1; i < 32; i++){
            int temp = n & 1;
            if (temp == 1)
                result++;
            if (result == 2)
                return false;
            n = n >> 1;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Power_of_Two test = new Power_of_Two();
        int n = 31;
        System.out.println(test.isPowerOfTwo(n));
    }
}
