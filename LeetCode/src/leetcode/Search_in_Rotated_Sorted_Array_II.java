package leetcode;

/**
 * @author Sunshine
 */
public class Search_in_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,3,1,1,1};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
