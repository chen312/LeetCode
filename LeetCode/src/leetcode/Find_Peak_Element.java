package leetcode;

/**
 * @author Sunshine
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public int helper(int[] nums, int l, int r){
        if (l == r)
            return l;
        if (r - l == 1)
            return nums[l] > nums[r] ? l : r;
        int m = (l + r) / 2;
        if (nums[m] > nums[m+1] && nums[m] > nums[m-1])
            return m;
        else if (nums[m] > nums[m+1])
            return helper(nums, l, m-1);
        else
            return helper(nums, m+1, r);
    }
    
    public static void main(String[] args) {
        Find_Peak_Element test = new Find_Peak_Element();
        int nums[] = {1,2,3,1};
        System.out.println(test.findPeakElement(nums));
    }
}
