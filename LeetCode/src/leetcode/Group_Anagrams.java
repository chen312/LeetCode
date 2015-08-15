package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sunshine
 */
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs.length == 0)
            return result;
        //Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++){
            char cur[] = strs[i].toCharArray();
            Arrays.sort(cur);
            String key = new String(cur);
            if (map.containsKey(key)){
                ArrayList<String> item = map.get(key);
                for (int j = 0; j < item.size(); j++){
                    if (strs[i].compareTo(item.get(j)) <= 0){
                        item.add(j, strs[i]);
                        break;
                    }
                }
                if (!item.contains(strs[i]))
                    item.add(strs[i]);
            }
            else{
                ArrayList<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(key, item);
            }
        }
        Iterator iter = map.values().iterator();
        while (iter.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iter.next();
            result.add(item);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Group_Anagrams test = new Group_Anagrams();
        String strs[] = {"", ""};
        System.out.println(test.groupAnagrams(strs));
    }
}
