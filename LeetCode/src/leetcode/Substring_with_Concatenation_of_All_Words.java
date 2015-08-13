package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @Sunshine
 */
public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || words.length == 0)
            return result;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
            
        int len = words[0].length();
        
        for (int begin = 0; begin < len && begin < s.length(); begin++){
            int cur = begin;
            int count = 0;
            int start = begin;
            HashMap<String, Integer> newSet = new HashMap<String, Integer>();
            while (cur+len <= s.length()){
                String str = s.substring(cur, cur+len);
                if (map.containsKey(str)){
                    if (newSet.containsKey(str))
                        newSet.put(str, newSet.get(str)+1);
                    else
                        newSet.put(str, 1);
                    if (newSet.get(str) <= map.get(str)){
                        count++;
                    }
                    else{
                        while (newSet.get(str) > map.get(str)){
                            String temp = s.substring(start, start+len);
                            if (newSet.containsKey(temp)){
                                newSet.put(temp, newSet.get(temp)-1);
                                if (newSet.get(temp) < map.get(temp))
                                    count--;
                            }
                            start += len;
                        }
                    }
                    if (count == words.length){
                        result.add(start);
                        String temp = s.substring(start, start+len);
                        if (newSet.containsKey(temp))
                            newSet.put(temp, newSet.get(temp)-1);
                        count--;
                        start += len;
                    }
                }
                else{
                    newSet.clear();
                    count = 0;
                    start = cur + len;
                }
                cur += len;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Substring_with_Concatenation_of_All_Words test = new Substring_with_Concatenation_of_All_Words();
        String s = "barfoothefoobarman";
        String words[] = {"foo", "bar"};
        System.out.println(test.findSubstring(s, words));
    }
}
