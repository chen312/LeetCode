package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */

// NP problem
public class Combinations {
    public static void helper(List<List<Integer>> result, List<Integer> item, int count, int current, int n, int k){
        if (count == k){
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = current; i <= n; i++){
            if (k - count > n - current + 1)
                return;
            else{
                item.add(i);
                helper(result, item, count+1, i+1, n, k);
                item.remove(item.size()-1);
            }
        }
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0)
            return result;
        helper(result, new ArrayList<Integer>(), 0, 1, n, k);
        return result;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }
}
