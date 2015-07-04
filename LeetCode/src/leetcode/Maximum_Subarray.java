package leetcode;

/**
 * @author Sunshine
 */
public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int max[] = new int[nums.length];
        int result;
        
        if (nums.length == 0)
            return 0;
        max[0] = nums[0];
        result = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (max[i-1] < 0)
                max[i] = nums[i];
            else
                max[i] = nums[i] + max[i-1];
            if (max[i] > result)
                result = max[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
