package leetcode;

/**
 * @author Sunshine
 */
public class House_Robber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int total[] = new int[nums.length];
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[2] + total[0];
        for (int i = 3; i < nums.length; i++){
            total[i] = Math.max(total[i-2], total[i-3]) + nums[i];
        }
        return Math.max(total[nums.length-1], total[nums.length-2]);
    }
    
    public static void main(String[] args) {
        House_Robber test = new House_Robber();
        int nums[] = {2,5,8,4,6,9,8};
        System.out.println(test.rob(nums));
    }
}
