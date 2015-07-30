package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sunshine
 */
public class Word_Break {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean res[] = new boolean[s.length()+1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++){
            boolean temp = wordDict.contains(s.substring(0, i+1));
            for (int j = 1; j <= i; j++){
                temp |= (res[j] && wordDict.contains(s.substring(j, i+1)));
            }
            res[i+1] = temp;
        }
        return res[s.length()];
    }
    
    public static void main(String[] args) {
        Word_Break test = new Word_Break();
        String s = "leetcode";
        HashSet<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(test.wordBreak(s, wordDict));
    }
}
