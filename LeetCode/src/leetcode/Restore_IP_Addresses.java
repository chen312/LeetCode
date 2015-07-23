package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Restore_IP_Addresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4)
            return result;
        helper(result, 1, 0, s, "");
        return result;
    }
    
    public static void helper(List<String> result, int part, int pos, String s, String item) {
        if (pos >= s.length())
            return;
        if (part == 4){
            String str = s.substring(pos);
            if (isValid(str)){
                result.add(item + "." + str);
            }
            return;
        }
        for (int i = 1; i < 4 && (pos + i <= s.length()); i++){
            String str = s.substring(pos, pos+i);
            if (isValid(str)){
                if (part == 1)
                    helper(result, part+1, pos+i, s, str);
                else
                    helper(result, part+1, pos+i, s, item+"."+str);
            }
        }
    }
    
    public static boolean isValid(String str){
        if (str.length() == 0 || str.length() > 3)
            return false;
        int num = Integer.parseInt(str);
        if (str.charAt(0) == '0' && str.length() > 1)
            return false;
        if (num >= 0 && num <= 255)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
