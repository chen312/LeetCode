package leetcode;

/**
 *
 * @author Sunshine
 */
public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return head;
        ListNode pre = head, cur = head.next;
        while (cur != null){
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(6);
        head.next = node2;
        node2.next = node6;
        node6.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node7;
        Remove_Linked_List_Elements test = new Remove_Linked_List_Elements();
        System.out.println(test.removeElements(head, 6));
    }
}
