package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Binary_Tree_Postorder_Traversal {
    // Recursion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result){
        if (root == null)
            return;
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
    
    // Iterate
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                result.add(0, root.val);
                stack.push(root);
                root = root.right;
            }
            else{
                root = stack.pop().left;
            }
        }
        return result;
    }
    
    // Morris
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode cur = dummy;
        TreeNode pre = null;
        while (cur != null){
            if (cur.left == null)
                cur = cur.right;
            else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    reverse(cur.left, pre);
                    TreeNode temp = pre;
                    while (temp != cur.left){
                        result.add(temp.val);
                        temp = temp.right;
                    }
                    result.add(temp.val);
                    reverse(pre, cur.left);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
    
    public void reverse(TreeNode start, TreeNode end){
        if (start == end)
            return;
        TreeNode pre = start;
        TreeNode cur = start.right;
        TreeNode next;
        while (pre != end){
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }
}
