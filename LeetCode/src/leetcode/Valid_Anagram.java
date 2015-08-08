package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        if (s.length() != t.length())
            return false;
        
        for (int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if (map.containsKey(cur))
                map.put(cur, map.get(cur)+1);
            else
                map.put(cur, 1);
        }
        
        for (int i = 0; i < s.length(); i++){
            Character cur = t.charAt(i);
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur)-1);
                if (map.get(cur) == 0)
                    map.remove(cur);
            }
            else
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Valid_Anagram test = new Valid_Anagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(test.isAnagram(s, t));
    }
}
