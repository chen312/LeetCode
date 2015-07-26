package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sunshine
 */
public class Maximum_Depth_of_Binary_Tree {
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int cur = 0, last = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            last--;
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
    
    // Recusion
    public static int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right))+1;
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
        
        System.out.println(maxDepth(node1));
    }
}
