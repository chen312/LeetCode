package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty())
            return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        TreeNode temp = next.right;
        while (temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        return next.val;
    }
}
