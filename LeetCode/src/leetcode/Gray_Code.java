package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Sunshine
 */
public class Gray_Code {
    public static List<Integer> grayCode(int n) {
        int num[] = new int[n];
        int multiple = 1;
        List<Integer> result  = new ArrayList<Integer>();
        result.add(0);
        for (int i = 1; i <= n; i++){
            for (int j = multiple-1; j >= 0; j--){
                result.add(result.get(j) + multiple);
            }
            multiple *= 2;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(grayCode(n));
    }
}
