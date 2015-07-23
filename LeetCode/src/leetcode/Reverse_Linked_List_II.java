package leetcode;

/**
 * @author Sunshine
 */
public class Reverse_Linked_List_II {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode current = head, prev = newHead, begin = newHead;
        for (int i = 1; i <= n; i++){
            System.out.println("i=" + i + " : " + head);
            if (i > m){
                ListNode temp = current.next;
                current.next = begin.next;
                begin.next = current;
                prev.next = temp;
                current = prev;
            }
            else if (i < m){
                begin = current;
            }
            prev = current;
            current = current.next;
        }
        return newHead.next;
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
        
        System.out.println(reverseBetween(head, 2, 4));
    }
}
