package leetcode;

/**
 *
 * @Sunshine
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int walker = 0;
        for (int runner = 0; runner < nums.length; runner++){
            if (nums[runner] == val)
                continue;
            nums[walker] = nums[runner];
            walker++;
        }
        return walker;
    }
    
    public static void main(String[] args) {
        Remove_Element test = new Remove_Element();
        int nums[] = {1,1,2};
        System.out.println(test.removeElement(nums, 1));
    }
}
