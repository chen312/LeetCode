package leetcode;

/**
 * @author Sunshine
 */
public class Sum_Root_to_Leaf_Numbers {
    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int result[] = new int[1];
        helper(result, root, 0);
        return result[0];
    }
    
    public static void helper(int[] result, TreeNode root, int sum){
        if (root.left == null && root.right == null){
            result[0] += (sum * 10 + root.val);
        }
        else{
            if (root.left != null)
                helper(result, root.left, sum*10 + root.val);
            if (root.right != null)
                helper(result, root.right, sum*10 + root.val);
        }
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        //TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        //node3.right = node5;
        
        System.out.println(sumNumbers(node1));
    }
}
