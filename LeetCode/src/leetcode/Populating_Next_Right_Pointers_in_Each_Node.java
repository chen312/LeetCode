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
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode curHead = null;
        while (lastHead != null){
            TreeLinkNode lastCur = lastHead;
            while (lastCur != null){
                if (lastCur.left != null){
                    if (curHead == null){
                        curHead = lastCur.left;
                        pre = curHead;
                    }
                    else{
                        pre.next = lastCur.left;
                        pre = lastCur.left;
                    }
                }
                if (lastCur.right != null){
                    if (curHead == null){
                        curHead = lastCur.right;
                        pre = curHead;
                    }
                    else{
                        pre.next = lastCur.right;
                        pre = lastCur.right;
                    }
                }
                lastCur = lastCur.next;
            }
            lastHead = curHead;
            curHead = null;
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
