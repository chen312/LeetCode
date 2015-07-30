package leetcode;

/**
 * @author Sunshine
 */
public class Single_Number_II {
    public int singleNumber(int[] nums) {
        int digits[] = new int[32];
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < nums.length; j++){
                digits[i] += (nums[j] >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++)
            res += (digits[i] % 3) << i;
        return res;
    }
    
    public static void main(String[] args) {
        Single_Number_II test = new Single_Number_II();
        int nums[] = {2,2,2,3,5,3,3};
        System.out.println(test.singleNumber(nums));
    }
}
