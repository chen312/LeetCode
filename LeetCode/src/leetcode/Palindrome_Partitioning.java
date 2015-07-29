package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s.length() == 0)
            return result;
        List<String> item = new ArrayList<String>();
        helper(result, item, s, 0);
        return result;
    }
    
    public void helper(List<List<String>> result, List<String> item, String s, int pos){
        if (pos == s.length()){
            result.add(new ArrayList<String>(item));
            return;
        }
        for (int i = pos+1; i <= s.length(); i++){
            String temp = s.substring(pos, i);
            if (isPalindrome(temp)){
                item.add(temp);
                helper(result, item, s, i);
                item.remove(item.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        StringBuilder str = new StringBuilder(s);
        if (s.equals(str.reverse().toString()))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        String s = "aab";
        Palindrome_Partitioning test = new Palindrome_Partitioning();
        System.out.println(test.partition(s));
    }
}
