package leetcode;

/**
 * @author Sunshine
 */
public class Decode_Ways {
    public static int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int result[] = new int[s.length()];
        if (s.charAt(0) - '0' != 0)
            result[0] = 1;
        else
            return 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                int temp = s.charAt(i-1) - '0';
                // "00"
                if (s.charAt(i-1) == '0')
                    return 0;
                // "10" or "20"
                else if (temp == 1 || temp == 2){
                    if (i == 1)
                        result[i] = 1;
                    else
                        result[i] = result[i-2];
                }
                else
                    return 0;
            }
            else{
                int temp = Integer.parseInt(s.substring(i-1, i+1));
                if (temp > 10 && temp <= 26){
                    if (i == 1)
                        result[i] = 2;
                    else
                        result[i] = result[i-1] + result[i-2];
                }
                else
                    result[i] = result[i-1];
            }
        }
        return result[s.length()-1];
    }
    
    public static void main(String[] args) {
        String s = "110";
        System.out.println(numDecodings(s));
    }
}
