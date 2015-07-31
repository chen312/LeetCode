package leetcode;

/**
 * @author Sunshine
 */
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode end = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val >= end.val){
                end = cur;
                cur = cur.next;
            }
            else{
                ListNode next = cur.next;
                end.next = next;
                if (cur.val < head.val){
                    cur.next = head;
                    head = cur;
                }
                else{
                    ListNode temp = head;
                    while (temp.next.val < cur.val){
                        temp = temp.next;
                    }
                    cur.next = temp.next;
                    temp.next = cur;
                }
                cur = next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Insertion_Sort_List test = new Insertion_Sort_List();
        System.out.println(test.insertionSortList(head));
    }
}
