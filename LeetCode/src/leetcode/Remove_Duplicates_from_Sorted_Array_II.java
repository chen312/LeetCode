package leetcode;

/**
 * @author Sunshine
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public static int removeDuplicates(int[] nums) {
        int len = 0, count = 0;
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                nums[len] = nums[i];
                len++;
                count++;
            }
            else if (nums[i] != nums[i-1]){
                count = 1;
                nums[len] = nums[i];
                len++;
            }
            else{
                if (count < 2){
                    count++;
                    nums[len] = nums[i];
                    len++;
                }
            }
        }
        return len;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
