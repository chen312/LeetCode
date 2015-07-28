package leetcode;

/**
 * @author Sunshine
 */
public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        s = s.trim().toLowerCase();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                str.append(ch);
        }
        String temp = str.toString();
        if (temp.equals(str.reverse().toString()))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        String s = "1a1";
        System.out.println(isPalindrome(s));
    }
}
