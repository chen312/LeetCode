package leetcode;

import java.util.LinkedList;

/**
 *
 * @Sunshine
 */
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0)
            return 0;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if (stack.isEmpty()){
                    start = i+1;
                }
                else{
                    stack.pop();
                    if (stack.isEmpty()){
                        max = Math.max(max, i-start+1);
                    }
                    else{
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Longest_Valid_Parentheses test = new Longest_Valid_Parentheses();
        String s = ")()())";
        System.out.println(test.longestValidParentheses(s));
    }
}
