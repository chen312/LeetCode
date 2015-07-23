package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Sunshine
 */
public class Subsets_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean used[] = new boolean[nums.length];
        result.add(item);
        Arrays.sort(nums);
        if (nums.length == 0)
            return result;
        for (int i = 1; i <= nums.length; i++){
            helper(result, item, 0, i, nums, used);
        }
        return result;
    }
    
    public static void helper(List<List<Integer>> result, List<Integer> item, int current, int size, int[] nums, boolean used[]){
        if (item.size() == size){
            result.add(new ArrayList<>(item));
            return;
        }
        
        for (int i = current; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && (item.isEmpty() || used[i-1] != true))
                continue;
            else{
                item.add(nums[i]);
                used[i] = true;
                helper(result, item, i+1, size, nums, used);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        System.out.println(subsetsWithDup(nums));
    }
}
