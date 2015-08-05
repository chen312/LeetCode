package leetcode;

/**
 *
 * @author Sunshine
 */
public class House_Robber_II {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        
        int total[] = new int[nums.length];
        
        // First, rob nums[0]
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[2] + total[0];
        for (int i = 3; i < nums.length-1; i++){
            total[i] = Math.max(total[i-2], total[i-3]) + nums[i];
        }
        int result1 = Math.max(total[nums.length-2], total[nums.length-3]);
        
        // Second, do not rob nums[0]
        total[1] = nums[1];
        total[2] = nums[2];
        total[3] = nums[3] + total[1];
        for (int i = 4; i < nums.length; i++){
            total[i] = Math.max(total[i-2], total[i-3]) + nums[i];
        }
        int result2 = Math.max(total[nums.length-2], total[nums.length-1]);
        
        return Math.max(result1, result2);
    }
    
    public static void main(String[] args) {
        House_Robber_II test = new House_Robber_II();
        int nums[] = {1,3,1,3,100};
        System.out.println(test.rob(nums));
    }
}
