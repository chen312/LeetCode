package leetcode;

/**
 * @author Sunshine
 */
public class Remove_Duplicates_from_Sorted_List_II {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head, prev = null;
        if (current == null)
            return head;
        while (current != null && current.next != null){
            System.out.println(head);
            if (current.next.val == current.val){
                while (current.next != null && current.next.val == current.val)
                    current.next = current.next.next;
                if (prev == null)
                    head = current.next;
                else
                    prev.next = current.next;
                current = current.next;
            }
            else{
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(deleteDuplicates(node1));
    }
}
