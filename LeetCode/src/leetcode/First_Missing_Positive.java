package leetcode;

/**
 *
 * @Sunshine
 */
public class First_Missing_Positive {
    
    // Counting sort
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
    
    public static void main(String[] args) {
        First_Missing_Positive test = new First_Missing_Positive();
        int nums[] = {3,4,-1,1};
        System.out.println(test.firstMissingPositive(nums));
    }
}
