package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class Copy_List_with_Random_Pointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        RandomListNode pre = null;
        while (cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            if (pre != null)
                pre.next = copy;
            map.put(cur, copy);
            pre = copy;
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            RandomListNode copy = (RandomListNode) map.get(cur);
            RandomListNode random = (RandomListNode)map.get(cur.random);
            copy.random = random;
            cur = cur.next;
        }
        return (RandomListNode)map.get(head);
    }
}
