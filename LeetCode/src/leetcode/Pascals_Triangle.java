package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        List<Integer> item = new ArrayList<Integer>();
        item.add(1);
        result.add(new ArrayList<Integer>(item));
        for (int i = 1; i < numRows; i++){
            item.clear();
            List<Integer> last = result.get(i-1);
            item.add(1);
            for (int j = 0; j < last.size()-1; j++)
                item.add(last.get(j) + last.get(j+1));
            item.add(1);
            result.add(new ArrayList<Integer>(item));
        }
        return result;
    }
    
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
