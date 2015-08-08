package leetcode;

import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class MyStack {
    
    LinkedList<Integer> stack = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        stack.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.pollLast();
    }

    // Get the top element.
    public int top() {
        return stack.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.top());
    }
}
