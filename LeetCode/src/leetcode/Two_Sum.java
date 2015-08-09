package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i+1;
                return result;
            }
            else
                map.put(nums[i], i+1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Two_Sum test = new Two_Sum();
        int nums[] = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(test.twoSum(nums, target)));
    }
}
