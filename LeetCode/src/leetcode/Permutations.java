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
        return result;
    }
    
    public static void main(String[] args) {
        Permutations test = new Permutations();
        int nums[] = {1,2,3};
        System.out.println(test.permute(nums));
    }
}
