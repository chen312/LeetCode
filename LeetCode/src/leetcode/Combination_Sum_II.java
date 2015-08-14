package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Sunshine
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean used[] = new boolean[candidates.length];
        Arrays.sort(candidates);
        helper(result, item, candidates, used, target, 0, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int[] candidates, boolean[] used, int target, int pos, int sum){
        if (sum >= target){
            if (sum == target)
                result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++){
            if (i != 0 && candidates[i] == candidates[i-1] && !used[i-1])
                continue;
            item.add(candidates[i]);
            used[i] = true;
            helper(result, item, candidates, used, target, i+1, sum+candidates[i]);
            item.remove(item.size()-1);
            used[i] = false;
        }
    }
    
    public static void main(String[] args) {
        Combination_Sum_II test = new Combination_Sum_II();
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(test.combinationSum2(candidates, target));
    }
}
