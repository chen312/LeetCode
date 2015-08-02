package leetcode;

/**
 * @author Sunshine
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode cur = headA;
        while (cur != null){
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        while (cur != null){
            cur = cur.next;
            lenB++;
        }
        int dif = Math.abs(lenB - lenA);
        if (lenA > lenB){
            while (dif > 0){
                headA = headA.next;
                dif--;
            }
        }
        else {
            while (dif > 0){
                headB = headB.next;
                dif--;
            }
        }
        while (headA != null){
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
