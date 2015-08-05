package leetcode;

/**
 * @author Sunshine
 */
public class Reverse_Bits {
    public int reverseBits(int n) {
        int result = n & 1;
        for (int i = 1; i < 32; i++){
            n = n >> 1;
            result = result << 1;
            result = result | (n & 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Reverse_Bits test = new Reverse_Bits();
        int n = 43261596;
        System.out.println(test.reverseBits(n));
    }
}
