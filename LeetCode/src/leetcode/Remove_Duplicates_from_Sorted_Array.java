package leetcode;

/**
 *
 * @Sunshine
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int walker = 0;
        for (int runner = 0; runner < nums.length; runner++){
            if (runner > 0 && nums[runner] == nums[runner-1])
                continue;
            nums[walker] = nums[runner];
            walker++;
        }
        return walker;
    }
    
    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array test = new Remove_Duplicates_from_Sorted_Array();
        int nums[] = {1,1,2};
        System.out.println(test.removeDuplicates(nums));
    }
}
