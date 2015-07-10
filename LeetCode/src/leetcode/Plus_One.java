package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Plus_One {
    public static int[] plusOne(int[] digits) {
        boolean isNine = true;
        boolean carry = true;
        if (digits.length == 0)
            return digits;
        for (int i = digits.length-1; i >= 0; i--){
            if (digits[i] != 9){
                isNine = false;
                if (carry){
                    digits[i] += 1;
                    carry = false;
                }
            }
            else{
                if (carry)
                    digits[i] = 0;
            }
        }
        if (isNine){
            int result[] = new int[digits.length+1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++)
                result[i] = 0;
            return result;
        }
        return digits;
    }
    
    public static void main(String[] args) {
        int digits[] = {9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
