package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Pascals_Triangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++){
            result.add(1);
            for (int j = i-1; j > 0; j--)
                result.set(j, result.get(j)+result.get(j-1));
        }
        return result;
    }
    
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
}
