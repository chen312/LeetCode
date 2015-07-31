package leetcode;

/**
 * @author Sunshine
 */
public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode walker = head.next;
        ListNode runner = head.next.next;
        while (runner != null && runner.next != null && walker != runner){
            walker = walker.next;
            runner = runner.next.next;
        }
        if (runner == null || runner.next == null)
            return null;
        walker = head;
        while (runner != walker){
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }
    
    public static void main(String[] args) {
        Linked_List_Cycle_II test = new Linked_List_Cycle_II();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(test.detectCycle(node1));
    }
}
