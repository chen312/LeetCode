package leetcode;

/**
 * @author Sunshine
 */
public class Partition_List {
    public static ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode newHead = new ListNode(0), current = newHead, prev = newHead, small = prev;
        newHead.next = head;
        while (current.next != null){
            if (current.next.val < x){
                if (current != small){
                    ListNode next = current.next.next;
                    current.next.next = small.next;
                    small.next = current.next;
                    current.next = next;
                }
                else
                    current = current.next;
                small = small.next;
            }
            else{
                current = current.next;
            }
        }
        return newHead.next;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(partition(node1, 3));
    }
}
