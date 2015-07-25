package leetcode;

import java.util.Stack;
/**
 * @author Sunshine
 */
public class Validate_Binary_Search_Tree {
    public static boolean isValidBST(TreeNode root) {
        TreeNode pre[] = new TreeNode[1];
        pre[0] = null;
        return helper(root, pre);
    }
    
    public static boolean helper(TreeNode root, TreeNode[] pre) {
        if (root == null)
            return true;
        boolean left = helper(root.left, pre);
        if (pre[0] != null && root.val <= pre[0].val)
            return false;
        pre[0] = root;
        return left && helper(root.right, pre);
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        
        System.out.println(isValidBST(node1));
    }
}
