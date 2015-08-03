package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0;
        for (int i = 0; i < version1.length(); i++)
            if (version1.charAt(i) == '.'){
                i1 = i;
                break;
            }
        for (int i = 0; i < version2.length(); i++)
            if (version2.charAt(i) == '.'){
                i2 = i;
                break;
            }
        int big1 = i1 == 0 ? Integer.parseInt(version1) : Integer.parseInt(version1.substring(0, i1));
        int big2 = i2 == 0 ? Integer.parseInt(version2) : Integer.parseInt(version2.substring(0, i2));
        String small1 = i1 == 0 ? "0" : version1.substring(i1+1);
        String small2 = i2 == 0 ? "0" : version2.substring(i2+1);
        if (big1 == big2){
            if (i1 == 0 && i2 == 0)
                return 0;
            return compareVersion(small1, small2);
        }
        else {
            if (big1 > big2)
                return 1;
            else
                return -1;
        }
    }
    
    public static void main(String[] args) {
        Compare_Version_Numbers test = new Compare_Version_Numbers();
        String version1 = "01";
        String version2 = "1";
        System.out.println(test.compareVersion(version1, version2));
    }
}
