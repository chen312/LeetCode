package leetcode;

/**
 * @author Sunshine
 */
public class Distinct_Subsequences {
    public static int numDistinct(String s, String t) {
        if (t.length() == 0)
            return 1;
        if (s.length() == 0)
            return 0;
        int dp[][] = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = 1;
        for (int i = 1; i <= t.length(); i++)
            dp[0][i] = 0;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                dp[i][j] = ((s.charAt(i-1) == t.charAt(j-1)) ? dp[i-1][j-1] : 0) + dp[i-1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
    
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
}
