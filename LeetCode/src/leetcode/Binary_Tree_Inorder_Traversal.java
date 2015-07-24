package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @author Sunshine
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Binary_Tree_Inorder_Traversal {
    
    // Recursion
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }
    
    public static void helper(List<Integer> result, TreeNode node){
        if (node == null)
            return;
        helper(result, node.left);
        result.add(node.val);
        helper(result, node.right);
    }
    
    // Iteration
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
    
    // Morris Traversal
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode pre = null, cur = root;
        while (cur != null){
            if (cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
            
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        
        System.out.println(inorderTraversal3(node1));
    }
}
