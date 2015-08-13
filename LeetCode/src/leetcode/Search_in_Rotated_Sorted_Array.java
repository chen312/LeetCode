package leetcode;

/**
 *
 * @Sunshine
 */
public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r){
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] >= nums[l]){
                if (target >= nums[l] && target <= nums[m]){
                    r = m;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if (target >= nums[m] && target <= nums[r])
                    l = m;
                else
                    r = m-1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array test = new Search_in_Rotated_Sorted_Array();
        int nums[] = {1};
        int target = 0;
        System.out.println(test.search(nums, target));
    }
}
