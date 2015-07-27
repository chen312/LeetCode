package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sunshine
 */
public class Minimum_Depth_of_Binary_Tree {
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int last = 1, cur = 0;
        int depth = 1;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            last--;
            if (temp.left == null && temp.right == null)
                return depth;
            if (temp.left != null){
                queue.add(temp.left);
                cur++;
            }
            if (temp.right != null){
                queue.add(temp.right);
                cur++;
            }
            if (last == 0){
                depth++;
                last = cur;
                cur = 0;
            }
        }
        return depth;
    }
    
    // Recursion
    public static int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth2(root.right) + 1;
        if (root.right == null)
            return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
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
        
        System.out.println(minDepth2(node1));
    }
}
