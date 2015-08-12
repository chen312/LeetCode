package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sunshine
 */
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder item = new StringBuilder();
        if (n == 0)
            return result;
        helper(result, item, 0, 0, n);
        return result;
    }
    
    public void helper(List<String> result, StringBuilder item, int countL, int countR, int n){
        if (countL == n && countR == n){
            result.add(item.toString());
            return;
        }
        if (countL < n){
            item.append('(');
            helper(result, item, countL+1, countR, n);
            item.deleteCharAt(item.length()-1);
        }
        if (countL > countR){
            item.append(')');
            helper(result, item, countL, countR+1, n);
            item.deleteCharAt(item.length()-1);
        }
    }
    
    public static void main(String[] args) {
        Generate_Parentheses test = new Generate_Parentheses();
        int n = 3;
        System.out.println(test.generateParenthesis(n));
    }
}
