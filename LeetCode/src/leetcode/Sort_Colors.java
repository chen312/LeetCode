package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Sort_Colors {
    public static void sortColors(int[] nums) {
        if (nums.length == 0)
            return;
        int low = 0, high = nums.length-1;
        while (high > low){
            if (nums[low] == 0)
                low++;
            else if (nums[high] != 0)
                high--;
            else{
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
            }
        }
        high = nums.length-1;
        while (high > low){
            if (nums[low] == 1)
                low++;
            else if (nums[high] != 1)
                high--;
            else{
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {0,2,1,1,2,0,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
