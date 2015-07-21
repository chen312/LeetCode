package leetcode;

/**
 * @author Sunshine
 */
public class Remove_Duplicates_from_Sorted_List {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        if (current == null)
            return head;
        while (current != null && current.next != null){
            if (current.next.val == current.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteDuplicates(node1));
    }
}
