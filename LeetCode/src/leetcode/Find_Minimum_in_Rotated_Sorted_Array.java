package leetcode;

/**
 * @author Sunshine
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0, r = nums.length-1;
        while (l <= r){
            if (l == r)
                return nums[l];
            int m = (l+r) / 2;
            if (nums[m] > nums[l] && nums[r] > nums[m])
                return nums[l];
            if (nums[m] == nums[l])
                return Math.min(nums[l], nums[r]);
            else if (nums[m] > nums[l]){
                l = m;
            }
            else {
                r = m;
            }
        }
        return nums[0];
    }
    
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        Find_Minimum_in_Rotated_Sorted_Array test = new Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(test.findMin(nums));
    }
}
