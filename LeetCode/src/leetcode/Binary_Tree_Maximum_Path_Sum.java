package leetcode;

/**
 * @author Sunshine
 */
public class Binary_Tree_Maximum_Path_Sum {
    public static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(max, root);
        return max[0];
    }
    
    public static int helper(int[] max, TreeNode root){
        if (root == null)
            return 0;
        int left = helper(max, root.left);
        int right = helper(max, root.right);
        int cur = (left>0 ? left : 0) + (right>0 ? right : 0) + root.val;
        if (cur > max[0])
            max[0] = cur;
        return Math.max(left, Math.max(right, 0)) + root.val;
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
        
        System.out.println(maxPathSum(node1));
    }
}
