package leetcode;

/**
 * @author Sunshine
 */
public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'A' + 1;
            result = result * 26 + cur;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Excel_Sheet_Column_Number test = new Excel_Sheet_Column_Number();
        String s = "AB";
        System.out.println(test.titleToNumber(s));
    }
}
