package leetcode;

import java.util.HashSet;

/**
 * @author Sunshine
 */
public class Happy_Number {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1){
            System.out.println(n);
            String temp = String.valueOf(n);
            n = 0;
            for (int i = 0; i < temp.length(); i++){
                n += Math.pow(temp.charAt(i) - '0', 2);
            }
            if (set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }
    
    public static void main(String[] args) {
        Happy_Number test = new Happy_Number();
        System.out.println(test.isHappy(7));
    }
}
