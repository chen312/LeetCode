package leetcode;

/**
 * @author Sunshine
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean signal = false;
        ListNode tempHead = new ListNode(0);
        ListNode pre = tempHead;
        while (l1 != null && l2 != null){
            int cur = l1.val + l2.val + (signal ? 1:0);
            signal = (cur >= 10);
            cur = cur % 10;
            ListNode digit = new ListNode(cur);
            pre.next = digit;
            pre = digit;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null){
            int cur = l1.val + (signal ? 1:0);
            signal = (cur >= 10);
            cur = cur % 10;
            ListNode digit = new ListNode(cur);
            pre.next = digit;
            pre = digit;
            l1 = l1.next;
        }
        
        while (l2 != null){
            int cur = l2.val + (signal ? 1:0);
            signal = (cur >= 10);
            cur = cur % 10;
            ListNode digit = new ListNode(cur);
            pre.next = digit;
            pre = digit;
            l2 = l2.next;
        }
        if (signal)
            pre.next = new ListNode(1);
        System.out.println(tempHead.next);
        
        return tempHead.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        //head.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        //node5.next = node6;
        
        Add_Two_Numbers test = new Add_Two_Numbers();
        System.out.println(test.addTwoNumbers(head, node4));
    }
}
