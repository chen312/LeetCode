package leetcode;

import java.util.Arrays;

/**
 *
 * @Sunshine
 */
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums.length  <= 1)
            return;
        int i;
        for (i = nums.length-2; i >= 0 && nums[i] >= nums[i+1]; i--)
            ;
        if (i < 0){
            reverse(nums, 0, nums.length-1);
        }
        else{
            int left = i;
            for (i = left+1; i < nums.length && nums[left] < nums[i]; i++)
                ;
            int temp = nums[left];
            nums[left] = nums[i-1];
            nums[i-1] = temp;
            reverse(nums, left+1, nums.length-1);
        }
    }
    
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        Next_Permutation test = new Next_Permutation();
        int nums[] = {2,3,1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
