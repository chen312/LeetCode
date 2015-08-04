package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sunshine
 */
public class Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer, Integer> tenHash = new HashMap<Integer, Integer>();
        
        HashMap<Character, Integer> cToi = new HashMap<Character, Integer>();
        cToi.put('A', 0);
        cToi.put('C', 1);
        cToi.put('G', 2);
        cToi.put('T', 3);
        
        Integer key = 0;
        
        if (s.length() < 10)
            return result;
        
        for (int i = 0; i <= 9; i++)
            key = (key << 2) + cToi.get(s.charAt(i));
        
        tenHash.put(key, 1);
        
        for (int loc = 10; loc < s.length(); loc++){
            key = ((key & 0x3ffff) << 2) | cToi.get(s.charAt(loc));
            
            if (tenHash.containsKey(key) && tenHash.get(key) == 1){
                tenHash.put(key, 2);
                result.add(s.substring(loc-9, loc+1));
            }
            else if (!tenHash.containsKey(key)){
                tenHash.put(key, 1);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Repeated_DNA_Sequences test = new Repeated_DNA_Sequences();
        System.out.println(test.findRepeatedDnaSequences(s));
    }
}
