package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sunshine
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Populating_Next_Right_Pointers_in_Each_Node {
    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.add(root);
        TreeLinkNode pre = null;
        int cur = 0, last = 1;
        while (!queue.isEmpty()){
            TreeLinkNode temp = queue.poll();
            last--;
            if (pre != null){
                pre.next = temp;
            }
            pre = temp;
            if (temp.left != null){
                queue.add(temp.left);
                cur++;
            }
            if (temp.right != null){
                queue.add(temp.right);
                cur++;
            }
            if (last == 0){
                last = cur;
                cur = 0;
                pre = null;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        node1.left = node2;
        node1.right = node3;
        connect(node1);
    }
}
