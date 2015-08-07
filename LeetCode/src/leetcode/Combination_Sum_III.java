package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        helper(result, item, k, n, 0, 1);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int k, int n, int sum, int pos){
        if (item.size() == k ){
            if (sum == n){
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }
        
        for (int i = pos; i <= 9; i++){
            item.add(i);
            helper(result, item, k, n, sum+i, i+1);
            item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Combination_Sum_III test = new Combination_Sum_III();
        int k = 3;
        int n = 9;
        System.out.println(test.combinationSum3(k, n));
    }
}
