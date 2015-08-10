package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class ZigZag_Conversion {
    
    // Space Complexity: O(n)
    public String convert(String s, int numRows) {
        
        if (s.length() <= 2 || numRows == 1)
            return s;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        StringBuilder result = new StringBuilder();
        
        int i = 0;
        for (i = 0; i < s.length(); i = i + 2*(numRows-1)){
            //result.append(s.charAt(i));
            queue.offer(i);
            set.add(i);
        }
        if (i - s.length() <= numRows-1)
            queue.offer(i);
        
        while (!queue.isEmpty()){
            int cur = queue.remove();
            if (cur < s.length()){
                result.append(s.charAt(cur));
                if (cur - 1 >= 0 && !set.contains(cur-1)){
                    set.add(cur-1);
                    queue.offer(cur-1);
                }
                if (cur + 1 < s.length() && !set.contains(cur+1)){
                    set.add(cur+1);
                    queue.offer(cur+1);
                }
            }
            else{
                if (!set.contains(cur-1)){
                    set.add(cur-1);
                    queue.offer(cur-1);
                }
            }
        }
        return result.toString();
    }
    
    // Space Complexity: O(n2)
    public String convert2(String s, int numRows) {
        char table[][] = new char[numRows][s.length()];
        int current = 0, row =0, column = 0, base = numRows-1;
        String newString = "";
        
        if (s.length() == 0)
            return "";
            
        if (base == 0)
            return s;
        
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < s.length(); j++)
                table[i][j] = '#';
        }
        for(column = 0; current < s.length(); column++){
            if (column == 0 || column % base == 0){
                for (row = 0; row < numRows && current < s.length(); row++){
                    table[row][column] = s.charAt(current);
                    current++;
                }
                row = numRows-1;
            }
            else{
                row--;
                table[row][column] = s.charAt(current);
                current++;
            }
        }
        
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < s.length(); j++){
                if (table[i][j] != '#')
                    newString = newString + table[i][j];
            }
        }
        return newString;
    }
    
    public static void main(String[] args) {
        ZigZag_Conversion test = new ZigZag_Conversion();
        String s = "ABCDEFGHIJKLM";
        int numRows = 4;
        System.out.println(test.convert(s, numRows));
    }
}
