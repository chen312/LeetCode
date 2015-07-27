package leetcode;

/**
 * @author Sunshine
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public static TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        ListNode restore[] = new ListNode[1];
        restore[0] = head;
        return helper(restore, 0, len-1);
    }
    
    public static TreeNode helper(ListNode[] restore, int l, int r){
        if (l > r)
            return null;
        int m = (l + r) / 2;
        TreeNode left = helper(restore, l, m-1);
        TreeNode root = new TreeNode(restore[0].val);
        root.left = left;
        restore[0] = restore[0].next;
        root.right = helper(restore, m+1, r);
        return root;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        sortedListToBST(head);
    }
}
