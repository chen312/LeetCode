package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int item = stack.pop();
        if (!minStack.isEmpty() && item == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        return 0;
    }

    public int getMin() {
        if (!minStack.isEmpty())
            return minStack.peek();
        return 0;
    }
}
