package leetcode;

import java.util.TreeSet;

/**
 * @author Sunshine
 */
public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if ((set.floor(cur) != null && cur <= set.floor(cur)+t) ||
                    (set.ceiling(cur) != null && cur >= set.ceiling(cur)-t))
                return true;
            set.add(cur);
            if (i >= k)
                set.remove(nums[i-k]);
        }
        return false;
    }
    
    public static void main(String[] args) {
        Contains_Duplicate_III test = new Contains_Duplicate_III();
        int nums[] = {4,2};
        System.out.println(test.containsNearbyAlmostDuplicate(nums, 2, 1));
    }
}
