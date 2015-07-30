package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sunshine
 */
public class Word_Break_II {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (!canBreak(s, wordDict))
            return result;
        helper(s, wordDict, 0, new String(), result);
        return result;
    }
    
    public void helper(String s, Set<String> wordDict, int pos,String item, List<String> result){
        if (pos == s.length()){
            result.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = pos; i < s.length(); i++){
            str.append(s.charAt(i));
            if (wordDict.contains(str.toString())){
                String newItem = item.length()>0 ? (item+ " "+str.toString()) : str.toString();
                helper(s, wordDict, i+1, newItem, result);
            }
        }
    }
    
    public boolean canBreak(String s, Set<String> wordDict) {
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
        Word_Break_II test = new Word_Break_II();
        String s = "catsanddog";
        HashSet<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        
        System.out.println(test.wordBreak(s, wordDict));
    }
}
