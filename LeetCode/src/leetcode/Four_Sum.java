package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @Sunshine
 */
public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> item = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        
        for (int position = len-1; position > 2; position--){
            if (position != len-1 && nums[position] == nums[position+1])
                continue;
                
            int current = nums[position];
            int newTarget = target - current;
            int newNums[] = new int[position];
            
            for (int i = 0; i < position; i++)
                newNums[i] = nums[i];
            item = threeSum(newNums, newTarget);
            
            for (int i = 0; i < item.size(); i++){
                item.get(i).add(current);
                list.add(item.get(i));
            }
        }
        return list;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target) {
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
                if (nums[i] + nums[start] + nums[end] == target){
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
                else if (nums[i] + nums[start] + nums[end] > target)
                    end--;
                else
                    start++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Four_Sum test = new Four_Sum();
        int nums[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(test.fourSum(nums, target));
    }
}
