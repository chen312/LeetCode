package leetcode;

import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class Invert_Binary_Tree {
    // Recursion
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
    
    // Iteration
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return root;
    }
}
