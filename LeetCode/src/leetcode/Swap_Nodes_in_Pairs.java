package leetcode;

/**
 *
 * @Sunshine
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode first = head, second, pre = newHead;
        while (first != null && first.next != null){
            second = first.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
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
        
        Swap_Nodes_in_Pairs test = new Swap_Nodes_in_Pairs();
        System.out.println(test.swapPairs(head));
    }
}
