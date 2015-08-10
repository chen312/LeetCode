package leetcode;

/**
 * @author Sunshine
 */
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String result = Character.toString(s.charAt(0));
        for (int i = 0; i < s.length(); i++){
            int size = 1;
            while (i-size >= 0 && i+size < s.length() && s.charAt(i-size) == s.charAt(i+size)){
                if (2 * size + 1 > result.length())
                    result = s.substring(i-size, i+size+1);
                size++;
            }
        }
        
        for (int i = 1; i < s.length(); i++){
            int size = 1;
            while (i-size >= 0 && i+size-1 < s.length() && s.charAt(i-size) == s.charAt(i+size-1)){
                if (2 * size > result.length())
                    result = s.substring(i-size, i+size);
                size++;
            }
        }
        return result;
    }
    
    // DP
    public String longestPalindrome2(String s) {
        if (s.length() == 0)
            return "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if (j-i+1 > max){
                        max = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Longest_Palindromic_Substring test = new Longest_Palindromic_Substring();
        String s = "abbaccada";
        System.out.println(test.longestPalindrome(s));
    }
}
