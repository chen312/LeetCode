package leetcode;

/**
 *
 * @Sunshine
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int l = 0, r = nums.length-1;
        while (l <= r){
            int m = (l+r) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
    
    public static void main(String[] args) {
        Search_Insert_Position test = new Search_Insert_Position();
        int nums[] = {1,3,5,6};
        int target = 0;
        System.out.println(test.searchInsert(nums, target));
    }
}
