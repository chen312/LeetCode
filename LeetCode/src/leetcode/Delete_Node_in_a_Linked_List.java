package leetcode;

/**
 * @author Sunshine
 */
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null){
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
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
        
        Delete_Node_in_a_Linked_List test = new Delete_Node_in_a_Linked_List();
        test.deleteNode(node3);
        System.out.println(head);
    }
}
