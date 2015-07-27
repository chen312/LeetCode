package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Path_Sum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        int count[] = helper(root);
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < count.length; i++)
            if (count[i] == sum)
                return true;
        return false;
    }
    
    public static int[] helper(TreeNode root){
        if (root == null){
            int array[] = new int[0];
            return array;
        }
        
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        if (left.length + right.length > 0){
            int temp[] = new int[left.length+right.length];
            for (int i = 0; i < left.length; i++)
                temp[i] = left[i] + root.val;
            for (int i = 0; i < right.length; i++)
                temp[i+left.length] = right[i] + root.val;
            return temp;
        }
        else{
            int temp[] = new int[1];
            temp[0] = root.val;
            return temp;
        }
    }
    
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        
        System.out.println(hasPathSum2(node1, 30));
    }
}
