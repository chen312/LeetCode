package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max_local = nums[0];
        int min_local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++){
            int max_copy = max_local;
            max_local = Math.max(Math.max(nums[i], nums[i]*max_local), nums[i]*min_local);
            min_local = Math.min(Math.min(nums[i], nums[i]*max_copy), nums[i]*min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }
    
    public static void main(String[] args) {
        Maximum_Product_Subarray test = new Maximum_Product_Subarray();
        int nums[] = {-2, 3, -4};
        System.out.println(test.maxProduct(nums));
    }
}
