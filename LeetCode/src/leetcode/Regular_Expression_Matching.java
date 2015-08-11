package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
    public boolean helper(String s, String p, int i, int j){
        if (j == p.length())
            return i == s.length();
        
        if (j == p.length()-1 || p.charAt(j+1) != '*'){
            if (i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.'))
                return false;
            else
                return helper(s, p, i+1, j+1);
        }
        
        while (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))){
            if (helper(s, p, i, j+2))
                return true;
            i++;
        }
        return helper(s, p, i, j+2);
    }
    
    // DP
    public boolean isMatch2(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (p.length() == 0)
            return false;
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for (int j = 0; j < p.length(); j++){
            if (p.charAt(j) == '*'){
                if (j < 1)
                    continue;
                if (j > 0 && dp[0][j-1])
                    dp[0][j+1] = true;
                if (p.charAt(j-1) != '.'){
                    for (int i = 0; i < s.length(); i++){
                        if (dp[i+1][j] || (j>0 && dp[i+1][j-1]) || 
                        (i>0 && j>0 && dp[i][j+1] && s.charAt(i)==s.charAt(i-1) && s.charAt(i-1)==p.charAt(j-1))){
                            dp[i+1][j+1] = true;
                        }
                    }
                }
                else{
                    int i = 0;
                    while (j>0 && i<s.length() && !dp[i+1][j-1] && !dp[i+1][j])
                        i++;
                    while (i < s.length()){
                        dp[i+1][j+1] = true;
                        i++;
                    }
                }
            }
            else{
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                        dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args) {
        Regular_Expression_Matching test = new Regular_Expression_Matching();
        String s = "abb";
        String p = "bbb*";
        System.out.println(test.isMatch2(s, p));
    }
}
