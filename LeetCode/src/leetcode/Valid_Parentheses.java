package leetcode;

import java.util.Stack;

/**
 *
 * @Sunshine
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            switch (cur){
                case '(':
                case '[':
                case '{':
                    stack.push(cur);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Valid_Parentheses test = new Valid_Parentheses();
        String s = "([)]";
        System.out.println(test.isValid(s));
    }
}
