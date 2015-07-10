package leetcode;

/**
 * @author Sunshine
 */
public class Valid_Number {
    public static boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        boolean dotFlag = false, eFlag = false;
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i))
            {
                //（1）前面不能有小数点或者‘e’和‘E’；（2）前一位是数字或者后一位要是数字
                case '.':
                    if (dotFlag || eFlag || 
                    ((i == 0 || !(s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9')) &&
                    (i == s.length()-1 || !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'))))
                        return false;
                    dotFlag = true;
                    break;
                //（1）必须是第一位或者在‘e’和‘E’后一位；（2）后一位要是数字或者'.'
                case '+':
                case '-':
                    if ((i > 0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')) || 
                    (i == s.length()-1 || !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' || s.charAt(i+1) == '.')))
                        return false;
                    break;
                //（1）前面不能有‘e’和‘E’出现过；（2）不能是第一位或者最后一位
                case 'e':
                case 'E':
                    if (eFlag || i == 0 || i == s.length()-1)
                        return false;
                    eFlag = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "0.1";
        System.out.println(isNumber(s));
    }
}
