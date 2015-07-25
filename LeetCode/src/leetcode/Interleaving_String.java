package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Interleaving_String {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean result[][] = new boolean[s1.length()+1][s2.length()+1];
        result[0][0] = true;
        for (int i = 0; i < s1.length(); i++){
            result[i+1][0] = result[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++){
            result[0][i+1] = result[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                result[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && result[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && result[i][j-1]);
            }
        }
        return result[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
