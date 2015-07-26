package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * @author Sunshine
 */
public class Binary_Tree_Level_Order_Traversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if (root == null)
            return result;
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (queue1.isEmpty()){
                queue1.addAll(queue2);
                queue2.clear();
                result.add(new ArrayList<>(item));
                item.clear();
            }
            else{
                TreeNode temp = queue1.poll();
                item.add(temp.val);
                if (temp.left != null)
                    queue2.add(temp.left);
                if (temp.right != null)
                    queue2.add(temp.right);
            }
        }
        result.add(new ArrayList<>(item));
        
        return result;
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
        
        System.out.println(levelOrder(node1));
    }
}
