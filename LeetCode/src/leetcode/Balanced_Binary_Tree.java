package leetcode;

/**
 * @author Sunshine
 */
public class Balanced_Binary_Tree {
    public static boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    
    public static int helper(TreeNode root){
        if (root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l, r) + 1;
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
        
        System.out.println(isBalanced(node1));
    }
}
