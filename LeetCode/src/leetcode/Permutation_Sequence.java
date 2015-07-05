package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sunshine
 */
public class Permutation_Sequence {
    
    public static int getFactorial(int n){
        int result  = 1;
        for (int i = n; i >= 1; i--)
            result = result * i;
        return result;
    }
    // We can determine the number of each position according to k.
    public static String getPermutation(int n, int k) {
         String result = "";
         List<Integer> list = new ArrayList<Integer>();
         for (int i = 1; i <= n; i++)
             list.add(i);
         
         for (int i = 0; i < n; i++){
             int len = n - i;
             int total = getFactorial(len);
             int unit = total / len;
             int current = 0;
             while (k > unit){
                 k = k - unit;
                 current++;
             }
             result += list.get(current);
             list.remove(current);
         }
         return result;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        System.out.println(getPermutation(n, k));
    }
}
