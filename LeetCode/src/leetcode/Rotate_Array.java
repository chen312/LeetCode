package leetcode;

import java.util.Arrays;

/**
 *
 * @author Sunshine
 */
public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        k = k % nums.length;
        helper(nums, 0, nums.length - k -1);
        helper(nums, nums.length - k, nums.length-1);
        helper(nums, 0, nums.length-1);
    }
    
    public void helper(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    public static void main(String[] args) {
        Rotate_Array test = new Rotate_Array();
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        test.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
