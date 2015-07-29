package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
/**
 * @author Sunshine
 */
public class Word_Ladder {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord.length() == 0 || endWord.length() == 0 || wordDict.size() == 0)
            return 0;
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int level = 1, last = 1, cur = 0;
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()){
            String current = queue.poll();
            last--;
            for (int i = 0; i < current.length(); i++){
                char charCur[] = current.toCharArray();
                for (char c = 'a'; c <= 'z'; c++){
                    charCur[i] = c;
                    String temp = new String(charCur);
                    if (temp.equals(endWord))
                        return level+1;
                    if (wordDict.contains(temp) && !visited.contains(temp)){
                        visited.add(temp);
                        queue.offer(temp);
                        cur++;
                    }
                }
            }
            if (last == 0){
                last = cur;
                cur = 0;
                level++;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        
        System.out.println(ladderLength(beginWord, endWord, wordDict));
    }
}
