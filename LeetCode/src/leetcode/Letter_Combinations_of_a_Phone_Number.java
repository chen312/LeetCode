package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sunshine
 */
public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        StringBuilder item = new StringBuilder();
        if (digits.length() == 0)
            return result;
        helper(result, digits, item);
        return result;
    }
    
    public void helper(List<String> result, String digits, StringBuilder item){
        if (digits.length() == 0){
            result.add(item.toString());
            return;
        }
        String letters = getLetters(digits.charAt(0));
        digits = digits.substring(1);
        for (int i = 0; i < letters.length(); i++){
            item.append(letters.charAt(i));
            helper(result, digits, item);
            item.deleteCharAt(item.length()-1);
        }
    }
    
    private String getLetters(char digit)
    {
        switch(digit)
        {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
    
    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number test = new Letter_Combinations_of_a_Phone_Number();
        String digits = "23";
        System.out.println(test.letterCombinations(digits));
    }
}
