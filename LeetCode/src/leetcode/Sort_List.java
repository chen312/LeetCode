package leetcode;

/**
 * @author Sunshine
 */
public class Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode head = current;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 == null)
            current.next = l2;
        else if (l2 == null)
            current.next = l1;
        
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Sort_List test = new Sort_List();
        System.out.println(test.sortList(head));
    }
}
