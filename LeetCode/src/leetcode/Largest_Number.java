package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sunshine
 */
public class Largest_Number {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        String str[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, new Cmp());
        System.out.println(Arrays.toString(str));
        String res = "";
        for (int i = str.length-1; i >= 0; i--)
            res = res.concat(str[i]);
        int i = 0;
        while (i < nums.length && res.charAt(i) == '0'){
            i++;
        }
        if (i == nums.length)
            return "0";
        return res.substring(i);
        
    }
    
    class Cmp implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ab.compareTo(ba);
        }
        
    }
    
    public static void main(String[] args) {
        Largest_Number test = new Largest_Number();
        int nums[] = {3, 30, 34, 5, 9};
        System.out.println(test.largestNumber(nums));
    }
}
