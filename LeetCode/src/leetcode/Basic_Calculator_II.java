package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class Basic_Calculator_II {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> chStack = new Stack<Character>();
        int num = 0;
        
        for (int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if (cur.isDigit(cur)){
                num = num * 10 + cur - '0';
                if (i+1 == s.length() || !Character.isDigit(s.charAt(i+1))){
                    if (!chStack.isEmpty() && chStack.peek().equals('*')){
                        int x = numStack.pop();
                        x = x * num;
                        numStack.push(x);
                        chStack.pop();
                    }
                    else if (!chStack.isEmpty() && chStack.peek().equals('/')){
                        int x = numStack.pop();
                        x = x / num;
                        numStack.push(x);
                        chStack.pop();
                    }
                    else
                        numStack.push(num);
                    num = 0;
                }
            }
            else if (cur != ' ')
                chStack.push(cur);
        }
        
        int result = 0;
        while (!chStack.isEmpty()){
            if (chStack.peek() == '+')
                result += numStack.pop();
            else
                result -= numStack.pop();
            chStack.pop();
        }
        return result + numStack.pop();
    }
    
    public static void main(String[] args) {
        Basic_Calculator_II test = new Basic_Calculator_II();
        String s = "3+5 / 2";
        System.out.println(test.calculate(s));
    }
}
