package leetcode;

/**
 * @author Sunshine
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder result = new StringBuilder();
        int cur = 0;
        while (true){
            if (cur == strs[0].length())
                return result.toString();
            char ch = strs[0].charAt(cur);
            for (int i = 1; i < strs.length; i++){
                if (cur == strs[i].length() || ch != strs[i].charAt(cur))
                    return result.toString();
            }
            result.append(ch);
            cur++;
        }
    }
    
    public static void main(String[] args) {
        Longest_Common_Prefix test = new Longest_Common_Prefix();
        String str[] = {"ccc","cc", "ccc"};
        System.out.println(test.longestCommonPrefix(str));
    }
}
