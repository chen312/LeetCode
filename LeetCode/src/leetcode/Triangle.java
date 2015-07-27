package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = 0;
        for (int i = 1; i < triangle.size(); i++){
            List<Integer> pre = triangle.get(i-1);
            List<Integer> cur = triangle.get(i);
            cur.set(0, cur.get(0) + pre.get(0));
            for (int j = 1; j < i; j++){
                cur.set(j, Math.min(pre.get(j-1), pre.get(j)) + cur.get(j));
            }
            cur.set(i, cur.get(i) + pre.get(i-1));
        }
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++){
            if (i == 0)
                min = triangle.get(triangle.size()-1).get(i);
            else
                min = Math.min(min, triangle.get(triangle.size()-1).get(i));
        }
        return min;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        item.add(2);
        triangle.add(new ArrayList<Integer>(item));
        item.clear();
        item.add(3);item.add(4);
        triangle.add(new ArrayList<Integer>(item));
        item.clear();
        item.add(6);item.add(5);item.add(7);
        triangle.add(new ArrayList<Integer>(item));
        item.clear();
        item.add(4);item.add(1);item.add(8);item.add(3);
        triangle.add(new ArrayList<Integer>(item));
        
        System.out.println(minimumTotal(triangle));
    }
}
