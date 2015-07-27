package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        List<TreeNode> result = new ArrayList<TreeNode>();
        helper(result, root);
        TreeNode pre = result.remove(0);
        while (!result.isEmpty()){
            TreeNode cur = result.remove(0);
            pre.left = null;
            pre.right = cur;
            pre = cur;
        }
    }
    
    public static void helper(List<TreeNode> result, TreeNode node){
        if (node == null)
            return;
        result.add(node);
        helper(result, node.left);
        helper(result, node.right);
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
        flatten(node1);
    }
}
