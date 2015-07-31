package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class Binary_Tree_Preorder_Traversal {
    
    // Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result){
        if (root == null)
            return;
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
    
    // Iterate
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop().right;
            }
        }
        return result;
    }
    
    // Morris
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            if (cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null){
                    result.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
