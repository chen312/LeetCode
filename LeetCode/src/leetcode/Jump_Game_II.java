package leetcode;

/**
 *
 * @author Sunshine
 */
public class Jump_Game_II {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int lastReach = 0, reach = 0, step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++){
            if (i > lastReach){
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i]+i);
        }
        
        if (reach < nums.length-1)
            return 0;
        return step;
    }
    
    public static void main(String[] args) {
        Jump_Game_II test = new Jump_Game_II();
        int nums[] = {2,3,1,1,4};
        System.out.println(test.jump(nums));
    }
}
