package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;
        int result = 0, a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++){
            switch (tokens[i]){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation test = new Evaluate_Reverse_Polish_Notation();
        String tokens[] = {"2", "1", "+", "3", "*"};
        System.out.println(test.evalRPN(tokens));
    }
}
