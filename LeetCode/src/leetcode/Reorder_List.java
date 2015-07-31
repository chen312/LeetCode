package leetcode;

/**
 * @author Sunshine
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode current = head, head2 = null;
        if (head == null || head.next == null)
            return;
        while (current != null){
            count++;
            head2 = current;
            current = current.next;
        }
        int num = (count-1) / 2;
        if (num == 0)
            return;
        
        // Cut the list into two part
        current = head;
        for (int i = 1; i < count-num; i++){
            current = current.next;
        }
        ListNode end2 = current.next;
        current.next = null;
        
        // Reverse the second part
        ListNode next = end2;
        current = next.next;
        next.next = null;
        while (current != null){
            end2 = current.next;
            current.next = next;
            next = current;
            current = end2;
        }
        
        // Merge two list
        ListNode current1 = head;
        ListNode current2 =head2;
        while (current2 != null){
            head2 = head2.next;
            current2.next = current1.next;
            current1.next = current2;
            current1 = current2.next;
            current2 = head2;
        }
    }
    
    public static void main(String[] args) {
        Reorder_List test = new Reorder_List();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        test.reorderList(head);
        System.out.println(head);
    }
}
