package leetcode;

/**
 *
 * @Sunshine
 */
public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, cur = head;
        while (cur != null){
            ListNode temp = cur;
            int i = 1;
            for (i = 1; i < k; i++){
                temp = temp.next;
                if (temp == null)
                    break;
            }
            if (i < k)
                break;
            for (i = 1; i < k; i++){
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
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
        
        Reverse_Nodes_in_k_Group test = new Reverse_Nodes_in_k_Group();
        System.out.println(test.reverseKGroup(head, 3));
    }
}
