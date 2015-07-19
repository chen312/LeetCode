package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sunshine
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        result.add(item);
        Arrays.sort(nums);
        if (nums.length == 0)
            return result;
        for (int i = 1; i <= nums.length; i++){
            helper(result, item, 0, i, nums);
        }
        return result;
    }
    
    public static void helper(List<List<Integer>> result, List<Integer> item, int current, int size, int[] nums){
        if (item.size() == size){
            result.add(new ArrayList<>(item));
            return;
        }
        
        for (int i = current; i < nums.length; i++){
            item.add(nums[i]);
            helper(result, item, i+1, size, nums);
            item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subsets(nums));
    }
}
