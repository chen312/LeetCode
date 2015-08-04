package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else{
                int count = map.get(nums[i]) + 1;
                if (count > nums.length/2)
                    return nums[i];
                else
                    map.put(nums[i], count);
            }
        }
        return nums[0];
    }
    
    public static void main(String[] args) {
        Majority_Element test = new Majority_Element();
        int nums[] = {1,5,8,7,1,1,1};
        System.out.println(test.majorityElement(nums));
    }
}
