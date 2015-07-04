package leetcode;

/**
 * @author Sunshine
 */
public class Jump_Game {
    public static boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        int far = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (i > far)
                return false;
            else
                far = Math.max(far, i+nums[i]);
        }
        return true;
    }
    
    public static void main(String[] args) {
        int nums[] = {0};
        System.out.println(canJump(nums));
    }
}
