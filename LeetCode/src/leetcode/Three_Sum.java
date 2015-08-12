package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        int start, end;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++){
            //item.add(nums[i]);
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            start = i+1;
            end = nums.length-1;
            while (start < end){
                if (nums[i] + nums[start] + nums[end] == 0){
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    result.add(new ArrayList<Integer>(item));
                    item.clear();
                    start++;
                    while (start < end && nums[start] == nums[start-1])
                        start++;
                    end--;
                    while (start < end && nums[end] == nums[end+1])
                        end--;
                }
                else if (nums[i] + nums[start] + nums[end] > 0)
                    end--;
                else
                    start++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Three_Sum test = new Three_Sum();
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }
}
