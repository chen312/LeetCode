package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                max = Math.max(max, map.size());
                int newStart = map.get(s.charAt(i))+1;
                for (int j = start; j < newStart; j++)
                    map.remove(s.charAt(j));
                start = newStart;
                map.put(s.charAt(i), i);
            }
            else{
                map.put(s.charAt(i), i);
                end = i;
            }
        }
        max = Math.max(max, map.size());
        return max;
    }
    
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters test = new Longest_Substring_Without_Repeating_Characters();
        String s = "bbbbb";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
