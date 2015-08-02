package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() < 2)
            return s;
        String array[] = s.split(" ");
        System.out.println(Arrays.toString(array));
        StringBuilder str = new StringBuilder(array[array.length-1]);
        for (int i = array.length-2; i >= 0; i--){
            if (array[i].trim().length() != 0){
                str.append(" ");
                str.append(array[i]);
            }
        }
        return str.toString();
    }
    
    public static void main(String[] args) {
        Reverse_Words_in_a_String test = new Reverse_Words_in_a_String();
        String s = "   a   b ";
        System.out.println(test.reverseWords(s));
    }
}
