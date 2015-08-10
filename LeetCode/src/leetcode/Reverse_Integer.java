package leetcode;

/**
 * @author Sunshine
 */
public class Reverse_Integer {
    public int reverse(int x) {
        if (x == 0)
            return x;
        long result = 0;
        boolean positive;
        if (x >= 0)
            positive = true;
        else{
            positive = false;
            if (x == Integer.MIN_VALUE)
                return 0;
            x *= -1;
        }
        while (x % 10 == 0)
            x = x / 10;
        while (x / 10 > 0){
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit; 
        }
        result = result * 10 + x;
        if (!positive)
            result *= -1;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }
    
    public static void main(String[] args) {
        Reverse_Integer test = new Reverse_Integer();
        int x = 10;
        System.out.println(test.reverse(x));
    }
}
