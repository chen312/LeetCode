package leetcode;

/**
 * @author Sunshine
 */
public class Single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
    
    public static void main(String[] args) {
        Single_Number test = new Single_Number();
        int nums[] = {1,1,2,2,8,4,8};
        System.out.println(test.singleNumber(nums));
    }
}
