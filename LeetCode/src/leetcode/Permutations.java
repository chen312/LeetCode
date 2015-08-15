package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sunshine
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean used[] = new boolean[nums.length];
        helper(result, item, nums, used, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int[] nums, boolean[] used, int count){
        //System.out.println(item);
        if (count == nums.length){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
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
        Permutations test = new Permutations();
        int nums[] = {1,2,3};
        System.out.println(test.permute(nums));
    }
}
