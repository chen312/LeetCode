package leetcode;

/**
 * @author Sunshine
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Rotate_List {
    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            len++;
        }
        // The key point is to consider the situation that k > len.
        if (len != 0 && len <= k)
            k = k % len;
        if (head == null || k == 0)
            return head;
        
        ListNode start, end, newEnd = head;
        for (int i = 1; i <= len - k - 1; i++)
            newEnd = newEnd.next;
        start = newEnd.next;
        end = start;
        for (int i = 1; i < k; i ++)
            end = end.next;
        end.next = head;
        newEnd.next = null;
        
        return start;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode head = rotateRight(n1, 5);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
