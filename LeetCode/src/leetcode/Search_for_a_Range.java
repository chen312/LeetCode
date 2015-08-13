package leetcode;

import java.util.Arrays;

/**
 *
 * @Sunshine
 */
public class Search_for_a_Range {
    
    // 3 times
    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0)
            return result;
        int l = 0, r = nums.length-1, m = (l+r) / 2;
        while (l <= r){
            m = (l+r) / 2;
            if (nums[m] == target){
                result[0] = m;
                result[1] = m;
                break;
            }
            else if (nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        if (nums[m] != target)
            return result;
        l = m;
        r = nums.length-1;
        while (l <= r){
            int newM = (l+r) / 2;
            if (nums[newM] == target)
                l = newM+1;
            else
                r = newM-1;
        }
        result[1] = r;
        l = 0;
        r = m;
        while (l <= r){
            int newM = (l+r) / 2;
            if (nums[newM] == target)
                r = newM-1;
            else
                l = newM+1;
        }
        result[0] = l;
        
        return result;
    }
    
    // 2 times
    public int[] searchRange2(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0)
            return result;
        int ll = 0, lr = nums.length-1;
        while (ll <= lr){
            int m = (ll+lr) / 2;
            if (nums[m] < target)
                ll = m+1;
            else
                lr = m-1;
        }
        
        int rl = 0, rr = nums.length-1;
        while (rl <= rr){
            int m = (rl+rr) / 2;
            if (nums[m] > target)
                rr = m-1;
            else
                rl = m+1;
        }
        if (ll <= rr){
            result[0] = ll;
            result[1] = rr;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Search_for_a_Range test = new Search_for_a_Range();
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(test.searchRange(nums, target)));
    }
}
