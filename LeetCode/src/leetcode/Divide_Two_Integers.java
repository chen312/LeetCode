package leetcode;

/**
 *
 * @Sunshine
 */
public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        int result = 0;
        
        if (divisor == 0)
            return Integer.MAX_VALUE;
        while (d1 >= d2){
            int count = 0;
            while (d1 >= d2 << count)
                count++;
            result += 1 << (count-1);
            d1 -= d2 << (count-1);
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return result;
        else
            return -result;
    }
    
    public static void main(String[] args) {
        int dividend = 24;
        int divisor = 4;
        Divide_Two_Integers test = new Divide_Two_Integers();
        System.out.println(test.divide(dividend, divisor));
    }
}
