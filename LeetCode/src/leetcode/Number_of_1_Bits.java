package leetcode;

/**
 * @author Sunshine
 */
public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 1; i <= 32; i++){
            int temp = n & 1;
            if (temp == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Number_of_1_Bits test = new Number_of_1_Bits();
        int n = 11;
        System.out.println(test.hammingWeight(n));
    }
}
