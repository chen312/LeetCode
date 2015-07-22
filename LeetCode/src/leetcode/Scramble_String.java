package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Scramble_String {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        // We have to check this in order to pass the OJ
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.toString(c1).equals(Arrays.toString(c2)))
            return false;
        
        for (int i = 1; i < s1.length(); i++){
            String seg11 = s1.substring(0, i);
            String seg12 = s1.substring(i);
            String seg21 = s2.substring(0, i);
            String seg22 = s2.substring(i);
            if (isScramble(seg11, seg21) && isScramble(seg12, seg22))
                return true;
            seg21 = s2.substring(0, s2.length()-i);
            seg22 = s2.substring(s2.length()-i);
            if (isScramble(seg11, seg22) && isScramble(seg12, seg21))
                return true;
        }
        return false;
    }
    
    public static boolean isScrambleDP(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        boolean result[][][] = new boolean[s1.length()][s2.length()][s1.length()+1];
        for (int i = 0; i< s1.length(); i++)
            for (int j = 0; j < s2.length(); j++)
                result[i][j][1] = s1.charAt(i) == s2.charAt(j);
        for (int len = 2; len <= s1.length(); len++)
            for (int i = 0; i < s1.length()-len+1; i++)
                for (int j = 0; j < s2.length()-len+1; j++)
                    for (int k = 1; k < len; k++)
                        result[i][j][len] |= (result[i][j][k] && result[i+k][j+k][len-k]) || (result[i][j+len-k][k] && result[i+k][j][len-k]);
        return result[0][0][s1.length()];
    }
    
    public static void main(String[] args) {
        String s1 = "rgtae";
        String s2 = "great";
        System.out.println(isScrambleDP(s1, s2));
    }
}
