package leetcode;

import java.util.HashSet;

/**
 * @author Sunshine
 */
public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return false;
        if (k > nums.length-1)
            k = nums.length-1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= k; i++){
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        for (int i = k+1; i < nums.length; i++){
            set.remove(nums[i-k-1]);
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Contains_Duplicate_II test = new Contains_Duplicate_II();
        int nums[] = {1,2,1};
        int k = 1;
        System.out.println(test.containsNearbyDuplicate(nums, k));
    }
}
