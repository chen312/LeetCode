package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sunshine
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        helper(result, item, nums, used, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int[] nums, boolean[] used, int count){
        if (count == nums.length){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            if (!used[i]){
                used[i] = true;
                item.add(nums[i]);
                helper(result, item, nums, used, count+1);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        Permutations_II test = new Permutations_II();
        int nums[] = {1,1,2};
        System.out.println(test.permuteUnique(nums));
    }
}
