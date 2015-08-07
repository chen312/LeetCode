package leetcode;

import java.util.Stack;

/**
 *
 * @author Sunshine
 */
public class Basic_Calculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            switch (cur){
                case ' ':
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    num = 0;
                    sign = 1;
                    break;
                case ')':
                    result += num * sign;
                    num = 0;
                    sign = 1;
                    result *= stack.pop();
                    result += stack.pop();
                    break;
                case '+':
                    result += num * sign;
                    sign = 1;
                    num = 0;
                    break;
                case '-':
                    result += num * sign;
                    sign = -1;
                    num = 0;
                    break;
                default:
                    num = num*10 + cur - '0';
                    break;
            }
        }
        
        result += num * sign;
        
        return result;
    }
    
    public static void main(String[] args) {
        Basic_Calculator test = new Basic_Calculator();
        String s = "1";
        System.out.println(test.calculate(s));
    }
}
