package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Sunshine
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, item, candidates, target, 0, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int[] candidates, int target, int pos, int sum){
        if (sum >= target){
            if (sum == target)
                result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++){
            item.add(candidates[i]);
            helper(result, item, candidates, target, i, sum+candidates[i]);
            item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Combination_Sum test = new Combination_Sum();
        int candidates[] = {2,3,6,7};
        int target = 7;
        System.out.println(test.combinationSum(candidates, target));
    }
}
