package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class LRUCache {
    class Node{
        Node pre, next;
        int key, val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    int num;
    HashMap<Integer, Node> map;
    Node first, last;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        // Move node to the last
        if (node != last){
            if (node == first)
                first = first.next;
            else
                node.pre.next = node.next;
            node.next.pre = node.pre;
            last.next = node;
            node.pre = last;
            node.next = null;
            last = node;
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null){
            node.val = value;
            if (node != last){
                if (node == first)
                    first = first.next;
                else
                    node.pre.next = node.next;
                node.next.pre = node.pre;
                last.next = node;
                node.pre = last;
                node.next = null;
                last = node;
            }
        }
        else{
            Node newNode = new Node(key, value);
            if (num >= capacity){
                map.remove(first.key);
                first = first.next;
                if (first != null)
                    first.pre = null;
                else
                    last = null;
                num--;
            }
            if (first == null || last == null)
                first = newNode;
            else
                last.next = newNode;
            newNode.pre = last;
            last = newNode;
            System.out.println("key:" + key );
            map.put(key, newNode);
            num++;
        }
    }
    
    public static void main(String[] args) {
        LRUCache test = new LRUCache(1);
        test.set(2, 1);
        System.out.println(test.get(2));
        test.set(3, 2);
        System.out.println(test.get(2));
    }
}
