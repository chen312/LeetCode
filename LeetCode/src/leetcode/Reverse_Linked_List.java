package leetcode;

/**
 * @author Sunshine
 */
public class Reverse_Linked_List {
    // Iteration
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode start = head, end = head, cur = head.next;
        while (cur != null){
            end.next = cur.next;
            cur.next = start;
            start = cur;
            cur = end.next;
        }
        return start;
    }
    
    // Recursion
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        
        ListNode p = head.next;
        ListNode n = reverseList2(p);
        head.next = null;
        p.next = head;
        
        return n;
    }
    
    public static void main(String[] args) {
        Reverse_Linked_List test = new Reverse_Linked_List();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        
        System.out.println(test.reverseList2(head));
    }
}
