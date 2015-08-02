package leetcode;

/**
 * @author Sunshine
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0, r = nums.length-1;
        int min = nums[0];
        while (l < r-1){
            int m = (l+r) / 2;
            if (nums[l] < nums[m]){
                min = Math.min(min, nums[l]);
                l = m+1;
            }
            else if (nums[l] > nums[m]){
                min = Math.min(min, nums[m]);
                r = m-1;
            }
            else{
                l++;
            }
        }
        return Math.min(Math.min(min, nums[l]), nums[r]);
    }
    
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        Find_Minimum_in_Rotated_Sorted_Array test = new Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(test.findMin(nums));
    }
}
