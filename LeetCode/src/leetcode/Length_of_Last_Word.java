package leetcode;

/**
 * @author Sunshine
 */
public class Length_of_Last_Word {
    public static int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) != ' ')
                len++;
            else
                return len;
        }
        return len;
    }
    
    public static int lengthOfLastWord2(String s){
        String[] array = s.split(" ");
        if (array.length == 0)
            return 0;
        return array[array.length-1].length();
    }
    
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord2(s));
    }
}
