package leetcode;

/**
 * @author Sunshine
 */
public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == reverse(x))
            return true;
        return false;
    }
    
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
    
    // Convenient way
    public boolean isPalindrome2(int x) {
        if(x < 0)
            return false;
        int p1 = 0, p2 = x;
        while (p2 > 0){
            p1 = p1*10 + p2%10;
            p2 /= 10;
        }
        return p1 == x;
    }
    
    public static void main(String[] args) {
        Palindrome_Number test = new Palindrome_Number();
        int x = 232;
        System.out.println(test.isPalindrome(x));
    }
}
