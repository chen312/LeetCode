package leetcode;

/**
 * @author Sunshine
 */
public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0){
            int cur = (n-1) % 26;
            n = (n-1) / 26;
            result.insert(0, Character.toChars('A'+cur));
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Excel_Sheet_Column_Title test = new Excel_Sheet_Column_Title();
        int n = 52;
        System.out.println(test.convertToTitle(n));
    }
}
