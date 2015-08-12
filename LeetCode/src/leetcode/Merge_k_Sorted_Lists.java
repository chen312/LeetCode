package leetcode;

/**
 *
 * @Sunshine
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        return helper(lists, 0, lists.length-1);
    }
    
    public ListNode helper(ListNode[] lists, int l, int r){
        if (l == r)
            return lists[l];
        int m = (l+r) / 2;
        return mergeTwoLists(helper(lists, l, m), helper(lists, m+1, r));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head;
        if (l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }
        else{
            head = l2;
            l2 = l2.next;
        }
        head.next = mergeTwoLists(l1, l2);
        return head;
    }
}
