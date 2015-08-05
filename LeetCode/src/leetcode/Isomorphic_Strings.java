package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0)
            return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++){
            char key = s.charAt(i), value = t.charAt(i);
            if (map.containsKey(key)){
                if (map.get(key) != value)
                    return false;
            }
            else if (map.containsValue(value)){
                return false;
            }
            else {
                map.put(key, value);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        Isomorphic_Strings test = new Isomorphic_Strings();
        System.out.println(test.isIsomorphic(s, t));
    }
}
