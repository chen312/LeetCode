package leetcode;

/**
 * @author Sunshine
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null){
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }
}
