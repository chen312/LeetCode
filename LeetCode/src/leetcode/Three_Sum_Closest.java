package leetcode;

import java.util.Arrays;

/**
 *
 * @Sunshine
 */
public class Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[2];
        int dif = Math.abs(result - target);
        int start, end;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            start = i+1;
            end = nums.length-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target){
                    return target;
                }
                else{
                    if (Math.abs(sum - target) < dif){
                        result = sum;
                        dif = Math.abs(sum - target);
                    }
                    if (nums[i] + nums[start] + nums[end] > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Three_Sum_Closest test = new Three_Sum_Closest();
        int nums[] = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(test.threeSumClosest(nums, target));
    }
}
