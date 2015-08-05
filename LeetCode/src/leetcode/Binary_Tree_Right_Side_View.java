package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        int pos = 0;
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result, pos);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result, int pos){
        if (root == null)
            return;
        if (result.size() <= pos){
            result.add(root.val);
        }
        helper(root.right, result, pos+1);
        helper(root.left, result, pos+1);
    }
    
    //Iterate
    class Node{
        TreeNode root;
        int level;
        public Node(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }
    
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<Node> stack = new LinkedList<Node>();
        int pos = 0;
        while (root != null || !stack.isEmpty()){
            if (root != null){
                if (result.size() <= pos)
                    result.add(root.val);
                stack.push(new Node(root, pos));
                root = root.right;
                pos++;
            }
            else {
                pos = stack.peek().level+1;
                root = stack.pop().root.left;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Binary_Tree_Right_Side_View test = new Binary_Tree_Right_Side_View();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        
        System.out.println(test.rightSideView2(node1));
    }
}
