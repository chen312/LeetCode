package leetcode;

/**
 * @author Sunshine
 */
public class Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            bit++;
        }
        return m << bit;
    }
    
    public static void main(String[] args) {
        Bitwise_AND_of_Numbers_Range test = new Bitwise_AND_of_Numbers_Range();
        int m = 20, n = 22;
        System.out.println(test.rangeBitwiseAnd(m, n));
    }
}
