package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Path_Sum_II {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        helper(result, item, root, sum);
        return result;
    }
    
    public static void helper(List<List<Integer>> result, List<Integer> item, TreeNode root, int sum){
        if (root == null)
            return;
        item.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            result.add(new ArrayList<Integer>(item));
        }
        else{
            helper(result, item, root.left, sum-root.val);
            helper(result, item, root.right, sum-root.val);
        }
        item.remove(item.size()-1);
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
        
        System.out.println(pathSum(node1, 30));
    }
}
