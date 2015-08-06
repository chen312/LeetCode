package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Minimum_Size_Subarray_Sum {
    
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int sum = 0, min = 0;
        int start = 0, end = -1;
        
        while (sum < s && end < nums.length-1){
            end++;
            sum += nums[end];
        } 
        
        if (sum < s)
            return 0;
        
        min = end - start + 1;
        int len = min;
        
        while (start <= end && end < nums.length){
            if (sum >= s){
                min = Math.min(min, len);
                sum -= nums[start];
                start++;
                len--;
            }
            else{
                if(end + 1 < nums.length){
                    sum += nums[++end];
                    len++;
                }
                else
                    break;
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        Minimum_Size_Subarray_Sum test = new Minimum_Size_Subarray_Sum();
        int nums[] = {2,3,1,2,3,4};
        int s = 7;
        System.out.println(test.minSubArrayLen(s, nums));
    }
}
