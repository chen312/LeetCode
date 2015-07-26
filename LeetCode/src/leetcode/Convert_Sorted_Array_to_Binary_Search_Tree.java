package leetcode;

/**
 * @author Sunshine
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public static TreeNode helper(int[] nums, int left, int right){
        if (left > right)
            return null;
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = helper(nums, left, middle-1);
        root.right = helper(nums, middle+1, right);
        return root;
    }
    
    public static void main(String[] args) {
        
    }
}
