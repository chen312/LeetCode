package leetcode;

import java.util.LinkedList;

/**
 *
 * @Sunshine
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<ListNode> queue = new LinkedList<ListNode>();
        ListNode cur = head;
        while (cur != null){
            if (queue.size() == n+1)
                queue.remove();
            queue.offer(cur);
            cur = cur.next;
        }
        if (queue.size() == n)
            return head.next;
        else{
            ListNode pre = queue.remove();
            pre.next = queue.remove().next;
            return head;
        }
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null)
            return null;
        int i = 0;
        ListNode runner = head;
        while (runner != null && i < n){
            runner = runner.next;
            i++;
        }
        if (i < n)
            return head;
        if (runner == null)
            return head.next;
        ListNode walker = head;
        while (runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }
        walker.next = walker.next.next;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        head.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        
        Remove_Nth_Node_From_End_of_List test = new Remove_Nth_Node_From_End_of_List();
        System.out.println(test.removeNthFromEnd(head, 1));
    }
}
